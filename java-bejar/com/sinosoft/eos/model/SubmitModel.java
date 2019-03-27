/**
 * 
 */
package com.sinosoft.eos.model;

import config.Config;

/**
 * 报送模型
 * @author Darker.Wang
 * @date 2016-9-12 下午1:45:26
 * @company SINOSOFT
 */
public class SubmitModel {

	/**字符串方式提交*/
	public static final String SUBMIT_TYPE_STRING = "STRING";
	/**字节流方式提交**/
	public static final String SUBMIT_TYPE_STREAM = "STREAM";
	/**DTO方式提交**/
	public static final String SUBMIT_TYPE_DTO = "DTO";
	/**WSDL 方式 该方式提交若无submitTypeObj 则走默认WSDLService 提交**/
	public static final String SUBMIT_TYPE_WSDL = "WSDL";
	
	/**HTTP 协议交互**/
	public static final String PROTOCOL_TYPE_HTTP = "HTTP";
	/**SFTP 协议交互**/
	public static final String PROTOCOL_TYPE_SFTP = "SFTP";
	/**SOCKET 协议交互**/
	public static final String PROTOCOL_TYPE_SOCKET = "SOCKET";

	/**CLASS 数据格式**/
	public static final String FORMAT_TYPE_CLASS = "CLASS";
	/**XML 数据格式**/
	public static final String FORMAT_TYPE_XML = "XML";
	/**TXT 数据格式【暂不支持】**/
	public static final String FORMAT_TYPE_TXT = "TXT";
	/**JSON 数据格式【暂不支持】**/
	public static final String FORMAT_TYPE_JSON = "JSON";
	/**ZIP 数据格式 【暂不支持】**/
	public static final String FORMAT_TYPE_ZIP = "ZIP";
	
	private String submitSerialNo;//请求序列号
	private String submitType;//报送类型 
	private  Object submitClientObj;//报送客户端类
	private String submitTime;//报送时间
	private Object submitData;//报送数据
	private Class<?> submitClass;//声明发送的数据类型
	private String submitNo;//报送编号需要是则用之
	private String returnType;//返回类型
	private Object returnData;//返回数据
	private String returnTime;//返回时间
	private Class<?> returnClass;//声明返回的数据类型
	private String encoding = Config.getEncoding();//默认字符集
	
	/**报送业务模型**/
	private BussModel bussModel;
	/**报送请求模型**/
	private RequestModel reqModel;
	
	/**
	 * 获取报送字符集
	 * @return
	 */
	public String getEncoding() {
		return encoding;
	}
	/**
	 * 设置报送字符集
	 * @param encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
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
	/**
	 * 报送类型
	 * @return
	 */
	public String getSubmitType() {
		return submitType;
	}

	/**
	 * 定义提交方式
	 * @param submitType
	 */
	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	
	/**
	 * 获取报送客户端类【WSDL 报送时使用】
	 * @return
	 */
	public Object getSubmitClientObj() {
		return submitClientObj;
	}
	/**
	 * 设置报送客户端类【WSDL 报送时使用】
	 * @param submitClientObj
	 */
	public void setSubmitClientObj(Object submitClientObj) {
		this.submitClientObj = submitClientObj;
	}
	/**
	 * 报送时间
	 * @return
	 */
	public String getSubmitTime() {
		return submitTime;
	}

	/**
	 * 设置报送时间
	 * @param submitTime
	 */
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	/**
	 * 获取报送数据对象
	 * @return
	 */
	public Object getSubmitData() {
		return submitData;
	}

	/**
	 * 设置报送数据对象
	 * @param submitData
	 */
	public void setSubmitData(Object submitData) {
		this.submitData = submitData;
	}

	/**
	 * 返回数据类型
	 * @return
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * 设置返回数据类型
	 * @param returnType
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	/**
	 * 获取返回数据对象，注意根据类型构造成对应的类型
	 * @return
	 */
	public Object getReturnData() {
		return returnData;
	}

	/**
	 * 设置返回数据对象
	 * @param returnData
	 */
	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}

	/**
	 * 获取返回时间
	 * @return
	 */
	public String getReturnTime() {
		return returnTime;
	}

	/**
	 * 设置返回时间
	 * @param returnTime
	 */
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * 获取报送类
	 * @return
	 */
	public Class<?> getSubmitClass() {
		return submitClass;
	}

	/**
	 * 设置报送类
	 * @param submitClass
	 */
	public void setSubmitClass(Class<?> submitClass) {
		this.submitClass = submitClass;
	}

	/**
	 * 获取返回类
	 * @return
	 */
	public Class<?> getReturnClass() {
		return returnClass;
	}

	/**
	 * 设置返回类
	 * @param returnClass
	 */
	public void setReturnClass(Class<?> returnClass) {
		this.returnClass = returnClass;
	}

	
	/**
	 * 获取请求编号
	 * @return
	 */
	public String getSubmitNo() {
		return submitNo;
	}

	/**
	 * 设置报送编号
	 * @param submitNo
	 */
	public void setSubmitNo(String submitNo) {
		this.submitNo = submitNo;
	}

	/**
	 * 获取请求模型
	 * @return
	 */
	public RequestModel getReqModel() {
		return reqModel;
	}

	/**
	 * 设置请求模型
	 * @param reqModel
	 */
	public void setReqModel(RequestModel reqModel) {
		this.reqModel = reqModel;
	}

	/**
	 * 获取报送业务模型
	 * @return
	 */
	public BussModel getBussModel() {
		return bussModel;
	}

	/**
	 * 设置报送业务模型
	 * @param bussModel
	 */
	public void setBussModel(BussModel bussModel) {
		this.bussModel = bussModel;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
