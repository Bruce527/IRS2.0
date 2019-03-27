/**
 * 
 */
package com.sinosoft.ummp.application;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.model.BussModelImpl;

import config.Config;

/**
 * 节点特殊处理类入口：com.sinosoft.ummp.application.sxei.在对应的平台包中 添加类：SpeDeal_业务类型<br>\
 * 所有特殊处理类命名：SpeDeal_业务类型
 * @author Darker.Wang
 * @date 2017-1-10 下午5:35:53
 * @company SINOSOFT
 */
@Service
public class MsgClassInterfaces {
	/**XML 字符集**/
	public String XMLEncoding = Config.getEncoding();
	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;
	private Logger logger = Logger.getLogger(MsgClassService.class);
	private ApplicationContext context;
	private MsgClassService service;
	/**
	 * 
	 */
	public MsgClassInterfaces() {
		// TODO Auto-generated constructor stub
	}
	public Class<?> getDataClass(){
		if(service != null){
			return service.getDataClass();
		}
		return null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getSubmitData(BussModelImpl bmi, ParamPOJO pojo) throws CoreException{
		//BigDecimal comId = bmi.getComId();
		BigDecimal comId = new BigDecimal (5);
		String bussType = pojo.getBussType();
		String prefixPackageName = "com.sinosoft.ummp.application.sxei";
		Map map = new HashMap();
		map.put("bussType", bussType);
		map.put("comId", comId);
		List dealClasses = tDefActionReturnMapper.selectDealReturnClass(map);
		logger.debug("- MsgClassInterfaces bussType: "+bussType+" comId: "+comId);
		String cName = null;//类名
		String pName = null;//包名
		String bName = null;//业务名
		String className = null;
		try{
			//构造类名
			Map rtvMap = (Map) dealClasses.get(0);
			bName = (String) rtvMap.get("BUSSTYPE");
			//类名为BussType+"RDeal"
			cName = "SpeDeal_"+bName;
			pName = (String) rtvMap.get("PACKAGENAME");
			className = prefixPackageName + "."+pName+"."+cName;
			logger.info("- 特殊处理类："+className);	
			//反射调用类处理
			Class<?> clazz = Class.forName(className);
			//从容器中获取
			ApplicationContext act = ContextLoader.getCurrentWebApplicationContext();
			if(act == null){
				logger.debug("- ApplicationContext is null and get it from set ："+getApplicationContext());	
				act = getApplicationContext();
			}
			service = (MsgClassService) act.getBean(clazz);
			if(service.getApplicationContext() == null){
				service.setApplication(getApplicationContext());
			}
			return service.getSubmitData(bmi, pojo);
		}catch(ClassNotFoundException e){
			//e.printStackTrace();
			CoreException ce = new CoreException();
			ce.setException(e);
			ce.setErrorCode("CNFE");
			ce.setStackTrace(e.getStackTrace());
			ce.setFunction("MsgClassInterfaces.getSubmitData");
			ce.setMessage("无特殊处理的类："+className);
			throw ce;
		}catch(Exception e){
			CoreException ce = new CoreException();
			ce.setException(e);
			ce.setErrorCode("E");
			ce.setStackTrace(e.getStackTrace());
			ce.setFunction("MsgClassInterfaces.getSubmitData");
			ce.setMessage("特殊处理的类执行异常!");
			logger.info("特殊处理的类执行异常: "+e.getMessage());
			e.printStackTrace();
			throw ce;
		}
	}
	/**
	 * @return
	 */
	public ApplicationContext getApplicationContext() {
		return context;
	}
	public void setApplication(ApplicationContext context){
		this.context = context;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
