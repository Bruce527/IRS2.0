/**
 * 
 */
package com.sinosoft.ummp.application;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.model.BussModelImpl;

import config.Config;

/**
 * 特殊类报文节点规则引擎：所有的特殊类放在sxei.平台专用文件包下
 * @author Darker.Wang
 * @date 2017-1-10 下午4:12:17
 * @company SINOSOFT
 */
public abstract class MsgClassService implements XEnginService {
	/**XML 字符集**/
	public String XMLEncoding = Config.getEncoding();
	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;
	Logger logger = Logger.getLogger(MsgClassService.class);
 	private Map<String,String> defaultParams = new HashMap<String,String>();
	protected Class<?> dataClass;
	private Object rtvData;
	public ParamPOJO pojo;
	public Map<String,String> getDefaultParams(){
		return defaultParams;
	}
	public void setDefaultParams(Map<String,String> defp){
		 defaultParams = defp;
	}
	/**
	 * 
	 */
	public MsgClassService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.XEnginService#getSubmitData(com.sinosoft.ummp.domain.model.BussModelImpl, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public abstract Object getSubmitData(BussModelImpl bmi, ParamPOJO pojo);
	private ApplicationContext context;
	/**
	 * @return
	 */
	public ApplicationContext getApplicationContext() {
		return context;
	}
	public void setApplication(ApplicationContext context){
		this.context = context;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.XEnginService#getDataClass()
	 */
	@Override
	public Class<?> getDataClass() {
		return dataClass;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.XEnginService#getReturnData()
	 */
	@Override
	public Object getReturnData(){
		return rtvData;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.XEnginService#returnDeal()
	 */
	@Override
	public abstract boolean returnDeal();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
