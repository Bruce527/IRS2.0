/**
 * 
 */
package com.sinosoft.ummp.application;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.ummp.domain.model.BussModelImpl;

import config.Config;

/**
 * 节点构造解析实现类
 * @author Darker.Wang
 * @date 2016-7-8 下午3:31:18
 * @company SINOSOFT
 */
public abstract class MsgNodeService implements XEnginService {
	private static Logger logger = Logger.getLogger(MsgNodeService.class);
	private static Map<String,String> defaultParams = new HashMap<String,String>();
	private Class<?> dataClass;
	private Object rtvData;
	public ParamPOJO pojo;
	public Map<String,String> getDefaultParams(){
		return defaultParams;
	}
	public void setDefaultParams(Map<String,String> defp){
		 defaultParams = defp;
	}
	/**XML 字符集**/
	public String XMLEncoding = Config.getEncoding();
	/**
	 * XML 格式构造
	 * @param bmi
	 * @return
	 * @throws CoreException 
	 */
	public abstract String getXml(BussModelImpl bmi) throws CoreException;
	/***
	 * JSON 格式构造
	 * @param bmi
	 * @return
	 */
	public abstract String getJson(BussModelImpl bmi) throws CoreException;
	/**
	 * TXT 格式构造
	 * @param bmi
	 * @return
	 */
	public abstract String getTxt(BussModelImpl bmi) throws CoreException;

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgNodeService#getSubmitData(com.sinosoft.ummp.domain.model.BussModelImpl)
	 */
	@Override
	public String getSubmitData(BussModelImpl bmi,ParamPOJO pojo) throws CoreException {
		String submitString  = null;
		this.pojo = pojo;
		//初始化系统参数
		logger.info("获取报送数据："+bmi.getBussName()+" 数据格式："+bmi.getFormatType());
		// TODO 报送数据准备
		if(bmi.getFormatType().equals(SubmitModel.FORMAT_TYPE_XML)){
			dataClass = String.class;
			bmi.setComId(pojo.getComId());
			submitString = getXml(bmi);
			logger.debug("getSubmitData XML : \n"+submitString);
			return submitString;
		}else if(bmi.getFormatType().equals(SubmitModel.FORMAT_TYPE_JSON)){
			dataClass = String.class;
			submitString = getJson(bmi);
			logger.debug("getSubmitData JSON : \n"+submitString);
			return submitString;
		}else if(bmi.getFormatType().equals(SubmitModel.FORMAT_TYPE_TXT)){
			dataClass = String.class;
			submitString = getTxt(bmi);
			logger.debug("getSubmitData TXT : \n"+submitString);
			return submitString;
		}else {
			logger.info("getSubmitData do not suport format type ："+bmi.getFormatType());
		}
		// TODO 返回报送数据
		return submitString;
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
