/**
 * 
 */
package com.sinosoft.eos.adapte.submit;


import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.ebao.health.insurance.dto.PolicyAsynResultDTO;
import com.ebao.health.insurance.dto.PolicyResultsDTO;
import com.sinosoft.eos.adapte.SubmitAdapter;
import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.pdl.api.client.AccWebServiceClient;
import com.sinosoft.pdl.api.client.HltWebServiceClient;
import com.sinosoft.pdl.constants.HltConstants;
import com.sinosoft.platform.core.util.CError;

/**
 * 远程类方式提交，适用于北京健康险，北京意外险，上海人身险<br>
 * 因为每个平台的客户端和处理方式不一样，故此处分别调用不同的方法<br>
 * 若新增远程调用访问平台，<br>
 * 则只需要新增对应的方法(Object submitXXXXWebService(SubmitModel model,int flag) 即可，可参照已存在方法) <br>
 * 同时在根据BussModel中的SUB_BUSS_TYPE调用指定方法即可
 * @author Darker.Wang
 * @date 2016-7-4 下午7:07:21
 */
public class DTOSubmitAdapter extends SubmitAdapter {

	
	private Logger logger = Logger.getLogger(HttpSubmitAdapter.class);
	/* (non-Javadoc)
	 * @see com.sinosoft.eos.adapte.submit.SubmitAaptor#submit(com.sinosoft.eos.model.SubmitModel)
	 */
	@Override
	public boolean submit(SubmitModel model) {
		Method[] methods = DTOSubmitAdapter.class.getMethods();
		String doMethod = "submit"+model.getBussModel().getSubBussType()+"WebService";
		String message = null;
		boolean result = false;
		for(Method method : methods){
			method.setAccessible(true);//可访问私有属性和方法
			logger.debug(" filter method : "+method.getName());
			if(doMethod.equals(method.getName())){
				logger.debug(" do method : "+doMethod);	
				try {
					rtv = method.invoke(this,model, 1);
					result = true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					message = "暂时无："+model.getBussModel().getSubBussType()+" 对应的报送客户端访问方法：请确定方法 "+doMethod+" 存在且有效！";
					CError cError = new CError();
					cError.errorMessage = message;
					cError.functionName = "submit";
					cError.moduleName = "RemoteSubmitAdapter";
					cErrors.addOneError(cError);
					logger.info(cError.errorMessage);
					result = false;
				}finally{
					//构造返回信息
					SubmitReturn res = new SubmitReturn();
					res.setMessage(message);
					res.setResult(result);
					res.setReturnObj(rtv);
					res.setReturnObjClass(model.getReturnClass());
				}
			}
		}
		
		// 返回数据造型
		if (model.getReturnClass() != null && rtv != null) {
			rtv = model.getReturnClass().cast(rtv);
		}
		return result;
	}
	/**
	 * 北京健康险平台报送
	 * @param model
	 * @param flag 0-回写 1-拆单保送未完成，暂不回写
	 * @return
	 */
	public Object submitBJHIWebService(SubmitModel model,int flag){
		
		boolean resultState = false;
		BigDecimal comId = model.getBussModel().getComId();
		/**
		 * 报送接口调用，com.sinosoft.pdl.api.client中实现的客户端
		 * 新增则需要增加客户端对应的config 和  constants
		 */
		HltWebServiceClient client = new HltWebServiceClient(comId);
		String serviceId = model.getBussModel().getBussType();
		logger.debug(""+model.getSubmitType());
		Object obj = model.getSubmitData();
		if (obj == null) {
			logger.error("NO data transfered from DB!");
			return null;
		} 
		Class<?> clazz = model.getSubmitClass();
		logger.info("submit data class : " + clazz);
		
		obj = clazz.cast(obj);
		//报送
		Object responseObj = client.execute(serviceId, obj);
		if (null == responseObj) {
			logger.error("Upload cannot get return dto!");
			return null;
		}
		boolean toDBResult = true;// = dtoGenerator.dtos2pos(responseObj,serialno, serviceId,subTaskNos);
		if (!toDBResult) {
			logger.error("Write sequence number to schema failed!");
			return null;
		}
		if(flag != 0){ // 拆单返回结果记录
			if(HltConstants.DPC_SYN_POLICY.equals(serviceId)){
				PolicyResultsDTO tPolicyResultsDTO = (PolicyResultsDTO) responseObj;
				if (!"1".equals(tPolicyResultsDTO.getResponseCode())){
					logger.error(HltConstants.DPC_SYN_POLICY+" 回写："+resultState);
				}
			} else if (HltConstants.DPC_ASYN_POLICY.equals(serviceId)){
				PolicyAsynResultDTO tPolicyAsynResultDTO = (PolicyAsynResultDTO) responseObj;
				if (!"1".equals(tPolicyAsynResultDTO.getResponseCode())){
					logger.error(HltConstants.DPC_ASYN_POLICY+" 回写："+resultState);
				}
			}
		}
		return responseObj;
	}
	/**
	 * 北京以外险平台报送
	 * @param model
	 * @param flag 0-回写 1-拆单保送未完成，暂不回写
	 * @return
	 */
	public Object submitBJAIWebService(SubmitModel model,int flag){
		
		String serviceId = model.getBussModel().getBussType();
		logger.debug(""+model.getSubmitType());
		Object obj = model.getSubmitData();
		if (obj == null) {
			logger.error("NO data transfered from DB!");
			return null;
		} 
		Class<?> clazz = model.getSubmitClass();
		logger.info("submit data class : " + clazz);
		
		obj = clazz.cast(obj);
		//报送
		AccWebServiceClient client = new AccWebServiceClient(model.getBussModel().getComId());
		Object responseObj = client.execute(serviceId, obj);
		if (null == responseObj) {
			logger.error("Upload cannot get return dto!");
			return null;
		}
		boolean toDBResult = true;// = dtoGenerator.dtos2pos(responseObj,serialno, serviceId,subTaskNos);
		if (!toDBResult) {
			logger.error("Write sequence number to schema failed!");
			return null;
		}
		return responseObj;
	}
	/**
	 * 上海人生险平台报送
	 * @param model
	 * @param flag 0-回写 1-拆单保送未完成，暂不回写
	 * @return
	 */
	public Object submitSHIAWebService(SubmitModel model,int flag){
		
		String serviceId = model.getBussModel().getBussType();
		logger.debug(""+model.getSubmitType());
		Object obj = model.getSubmitData();
		if (obj == null) {
			logger.error("NO data transfered from DB!");
			return null;
		} 
		Class<?> clazz = model.getSubmitClass();
		logger.info("submit data class : " + clazz);
		
		obj = clazz.cast(obj);
		//报送
		AccWebServiceClient client = new AccWebServiceClient(model.getBussModel().getComId());
		Object responseObj = client.execute(serviceId, obj);
		if (null == responseObj) {
			logger.error("Upload cannot get return dto!");
			return null;
		}
		boolean toDBResult = true;// = dtoGenerator.dtos2pos(responseObj,serialno, serviceId,subTaskNos);
		if (!toDBResult) {
			logger.error("Write sequence number to schema failed!");
			return null;
		}
		return responseObj;
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
