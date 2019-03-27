/**
 * 
 */
package com.sinosoft.ummp.application;

import org.apache.log4j.Logger;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.domain.model.BussModelImpl;

/**
 * TDO报文规则服务类（抽象父类，实现XEnginService）
 * @author Darker.Wang
 * @date 2016-7-8 下午4:05:35
 * @company SINOSOFT
 */
public abstract class MsgDTOService implements XEnginService{

	private static Logger logger = Logger.getLogger(MsgDTOService.class);
	private Class<?> dataClass;
	private Object rtvData;
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.XEnginService#getSubmitData(com.sinosoft.ummp.domain.model.BussModelImpl)
	 */
	@Override
	public Object getSubmitData(BussModelImpl bmi,ParamPOJO pojo) {
		// TODO Auto-generated method stub
		logger.debug("XML节点构造： "+bmi.getBussName()+" 格式："+bmi.getFormatType());
		
		return null;
	}

	@Override
	public Object getReturnData() {
		// TODO Auto-generated method stub
		return rtvData;
	}

	@Override
	public boolean returnDeal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class<?> getDataClass() {
		// TODO Auto-generated method stub
		return dataClass;
	}

	
}
