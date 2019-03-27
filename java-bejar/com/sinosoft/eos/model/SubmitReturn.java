/**
 * 
 */
package com.sinosoft.eos.model;


/**
 * 返回信息类,与请求信息同步使用哦
 * @author Darker.Wang
 * @date 2016-8-16 下午4:35:20
 * @company SINOSOFT
 */
public class SubmitReturn{
	
	private String submitSerialNo;//请求序列号
	private BussModel bussModel;
	private String message;// 提示信息
	private boolean result;// 访问结果，成功与否
	private Object returnObj;// 返回对象
	private Class<?> returnObjClass;// 返回对象类型

	/**
	 * 获取SSN = SN-System.currentTimeMillis
	 * @return
	 */
	public String getSubmitSerialNo() {
		return submitSerialNo;
	}

	/**
	 * 设置SSN = SN-System.currentTimeMillis
	 * @param sbumitSerialNo
	 */
	public void setSubmitSerialNo(String submitSerialNo) {
		this.submitSerialNo = submitSerialNo;
	}

	public BussModel getBussModel() {
		return bussModel;
	}

	public void setBussModel(BussModel bussModel) {
		this.bussModel = bussModel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Object getReturnObj() {
		return returnObj;
	}

	public void setReturnObj(Object returnObj) {
		this.returnObj = returnObj;
	}

	public Class<?> getReturnObjClass() {
		return returnObjClass;
	}

	public void setReturnObjClass(Class<?> returnObjClass) {
		this.returnObjClass = returnObjClass;
	}

}
