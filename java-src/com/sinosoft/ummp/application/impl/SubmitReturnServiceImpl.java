/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

import com.sinosoft.eos.model.BussModel;
import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.ummp.application.ActionService;
import com.sinosoft.ummp.application.ReturnDealService;
import com.sinosoft.ummp.application.SubmitReturnService;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.mapper.TDefActionTraceMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionTrace;

/**
 * 报送返回处理实现类
 * @author Darker.Wang
 * @date 2016-8-16 下午4:33:14
 * @company SINOSOFT
 */
@Service
public class SubmitReturnServiceImpl implements SubmitReturnService {

	@Autowired
	ActionService actionService;
	@Autowired 
	SequenceService sequenceService;
	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;
	private ApplicationContext context;
	private static Logger logger = Logger.getLogger(SubmitReturnServiceImpl.class);
	/**
	 * 
	 */
	public SubmitReturnServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 返回处理任务内部类：为了加快效率，其机制是启动线程自动处理。
	 * @author Darker.Wang
	 * @date 2016-9-7 上午11:52:24
	 * @company SINOSOFT
	 */
	private class DealReturnTask implements Runnable{

		private SubmitReturn sr;
		private ParamPOJO pojo;
		/**
		 * 构造器
		 * @param sr 返回封装类
		 * @param pojo 参数
		 */
		DealReturnTask(SubmitReturn sr,ParamPOJO pojo){
			this.sr = sr;
			this.pojo = pojo;
		}
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			dealReturnRun(sr,pojo);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SubmitReturnService#dealSubmitReturn(com.sinosoft.ummp.application.List, com.sinosoft.ummp.application.List)
	 */
	@Override
	public Map<String, String> dealSubmitReturn(List<SubmitModel> sms,
			List<SubmitReturn> srs,ParamPOJO pojo) {
		Map<String,String> map = new HashMap<String,String>();
		if(srs == null){
			logger.info("- 报送返回为空：无需处理！");
			map.put("msg", "批次："+pojo.getBatchNo()+" 报送返回为空,无需处理");
		}
		//1 报送更新 2 返回插入
		List<TDefActionTrace> actionTracesUpadate = new ArrayList<TDefActionTrace>();
		List<TDefActionReturn> actionReturnInsert = new ArrayList<TDefActionReturn>();
		for(SubmitReturn sr : srs){
			String actionNo = sr.getSubmitSerialNo();
			
			logger.info("- "+actionNo+" "+sr.getMessage());
			logger.debug("- 返回信息："+sr.getReturnObj().toString());
			
			//TODO 启动后台自动处理机制
			boolean returnBoolean = dealReturn(sr,pojo);
			//TODO 构造返回更新履历详细
			List<TDefActionTrace> actionTraces = actionService.selectActionTrace(actionNo);
			for (TDefActionTrace tDefActionTrace : actionTraces) {
				tDefActionTrace.setActionSucCount(returnBoolean ? Long.parseLong("1") : Long.parseLong("0"));
				tDefActionTrace.setOperator(pojo.getUserCode());
				tDefActionTrace.setLastModifyTime(DateUtils.getCurrentTimestamp());
				actionTracesUpadate.add(tDefActionTrace);
			}
		}
		
		//TODO 保存返回更新信息
		boolean result = insertActionTraceAndReturn(actionTracesUpadate,actionReturnInsert);
		map.put("msg", "批次："+pojo.getBatchNo()+" 报送成功，返回处理完毕！");
		if(!result){
			map.put("msg", "批次："+pojo.getBatchNo()+" 报送成功，返回处理失败！");
		}
		logger.info("- 返回处理完毕：");
		return map;
	}
	/**
	 * 事务控制提交
	 * @param actionTraces
	 * @param actionReturnInsert
	 * @return
	 */
	@Transactional
	public boolean insertActionTraceAndReturn(List<TDefActionTrace> actionTraces,List<TDefActionReturn> actionReturnInsert){
		for (TDefActionTrace tDefActionReturn : actionTraces) {
			tDefActionTraceMapper.updateByPrimaryKey(tDefActionReturn);
		}
		for (TDefActionReturn tDefActionReturn : actionReturnInsert) {
			tDefActionReturnMapper.insert(tDefActionReturn);
		}
		return true;
	}
	/**
	 * 启动后台处理，处理机制是启动线程
	 * @param sr
	 * @param pojo
	 * @return
	 */
	private boolean dealReturn(SubmitReturn sr,ParamPOJO pojo){
		DealReturnTask task = new DealReturnTask(sr,pojo);
		task.run();
		//下部分是以线程方式运行，若SHELL脚本调用，则会输出处理的日志，影响SHELL判断最后一行成功还是失败，故而改用直接调用，相当于内部类存在了。以后有需要在释放开以线程方式实现
		//Thread thread = new Thread(task);
		//thread.start();
		return true;
	}
	/**
	 * 返回处理具体方法<br>
	 * <p>
	 * 
	 * 1、严格来说其实只有一条记录，一个接口对应一个返回处理类;<br>
	 * 2、返回处理类对应地址:<br>
	 * com.sinosoft.ummp.application.srsi +.+ 平台编码小写作为包名  +.+ 类名;<br>
	 * 3、类名为BussType+"RDeal";<br>
	 * </p>
	 * @param sr
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected final boolean dealReturnRun(SubmitReturn sr,ParamPOJO pojo){
		if(sr == null){
			logger.debug("- 无返回处理信息：");
			return false;
		}
		BussModel bm = sr.getBussModel();
		BigDecimal comId = bm.getComId();
		String bussType = bm.getBussType();
		String prefixPackageName = "com.sinosoft.ummp.application.rdsi";
		Map map = new HashMap();
		map.put("bussType", bussType);
		map.put("comId", comId);
		List dealClasses = tDefActionReturnMapper.selectDealReturnClass(map);
		
		for(int i = 0; i < dealClasses.size(); i ++){
			String cName = null;//类名
			String pName = null;//包名
			String bName = null;//业务名
			String className = null;
			try{
				//构造类名
				Map rtvMap = (Map) dealClasses.get(i);
				bName = (String) rtvMap.get("BUSSTYPE");
				//类名为BussType+"RDeal"
				cName = bName+"RDeal";
				pName = (String) rtvMap.get("PACKAGENAME");
				className = prefixPackageName + "."+pName+"."+cName;
				logger.debug("- 返回处理类："+className);	
				//反射调用类处理
				Class<?> clazz = Class.forName(className);
				//从容器中获取
				ApplicationContext act = ContextLoader.getCurrentWebApplicationContext();
				if(act == null){
					logger.debug("- ApplicationContext is null and get it from set ："+getApplicationContext());	
					act = getApplicationContext();
				}
				ReturnDealService service = (ReturnDealService) act.getBean(clazz);
				service.dealReturn(sr,pojo);
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				logger.warn("- 无返回处理类："+className);
				continue;
			}
			catch(Exception e){
				e.printStackTrace();
				logger.warn("- 返回处理异常："+e.getMessage());
				continue;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SubmitReturnService#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext context) {
		// TODO Auto-generated method stub
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SubmitReturnService#getApplicationContext()
	 */
	@Override
	public ApplicationContext getApplicationContext() {
		// TODO Auto-generated method stub
		return context;
	}

}
