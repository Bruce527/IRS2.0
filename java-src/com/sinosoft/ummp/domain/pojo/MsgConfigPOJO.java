/**
 * 
 */
package com.sinosoft.ummp.domain.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * XEnginPOJO 用于查询，更新等
 * @author Darker.Wang
 * @date 2016-6-28 下午10:12:07
 */
public class MsgConfigPOJO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bussId;//业务编码ID
	private Integer platCom;//平台编码
	private String platComName;//平台编码名称
	private String bussType;//业务类型
	private String bussTypeName;//业务类型名称
	private String bussCode;//业务编码
	private String formatType;//报文格式
	private String formatTypeName;//报文格式名称
	private String sendType;//报送类型
	private String sendTypeName;//报送类型名称
	private String status;//状态标识
	private String statusName;//状态标识名称
	private String msgDesc;//报文描述
	private String isTitle;//是否需要报文头
	private String headTitle;//报文头
	private String userCode;//用户编码
	private String implType;//实现方式
	private List<Integer> nodeIds;
	private String nodeTreeIds;
	
	public Integer getBussId() {
		return bussId;
	}


	public void setBussId(Integer bussId) {
		this.bussId = bussId;
	}


	public Integer getPlatCom() {
		return platCom;
	}


	public void setPlatCom(Integer platCom) {
		this.platCom = platCom;
	}


	public String getPlatComName() {
		return platComName;
	}


	public void setPlatComName(String platComName) {
		this.platComName = platComName;
	}


	public String getBussType() {
		return bussType;
	}


	public void setBussType(String bussType) {
		this.bussType = bussType;
	}


	public String getBussTypeName() {
		return bussTypeName;
	}


	public void setBussTypeName(String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}


	public String getBussCode() {
		return bussCode;
	}


	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}


	public String getFormatType() {
		return formatType;
	}


	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}


	public String getFormatTypeName() {
		return formatTypeName;
	}


	public void setFormatTypeName(String formatTypeName) {
		this.formatTypeName = formatTypeName;
	}


	public String getSendType() {
		return sendType;
	}


	public void setSendType(String sendType) {
		this.sendType = sendType;
	}


	public String getSendTypeName() {
		return sendTypeName;
	}


	public void setSendTypeName(String sendTypeName) {
		this.sendTypeName = sendTypeName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	public String getMsgDesc() {
		return msgDesc;
	}


	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}


	public String getIsTitle() {
		return isTitle;
	}


	public void setIsTitle(String isTitle) {
		this.isTitle = isTitle;
	}


	public String getHeadTitle() {
		return headTitle;
	}


	public void setHeadTitle(String headTitle) {
		this.headTitle = headTitle;
	}


	public List<Integer> getNodeIds() {
		return nodeIds;
	}


	public void setNodeIds(List<Integer> nodeIds) {
		this.nodeIds = nodeIds;
	}
	/**
	 * 另外构造ID设置
	 * @param nodeIds
	 */
	public void setNodeIds(String nodeTreeIds) {
		this.nodeIds = new ArrayList<Integer>();
		if(nodeTreeIds != null && nodeTreeIds.contains(";")){
			String[] ids = nodeTreeIds.split(";",-1);
			for(String id : ids){
				this.nodeIds.add(Integer.parseInt(id));
			}
		}else if(nodeTreeIds != null && !"".equals(nodeTreeIds)){
			this.nodeIds.add(Integer.parseInt(nodeTreeIds));
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	

	public String getImplType() {
		return implType;
	}


	public void setImplType(String implType) {
		this.implType = implType;
	}


	public String getNodeTreeIds() {
		return nodeTreeIds;
	}


	public void setNodeTreeIds(String nodeTreeIds) {
		this.nodeTreeIds = nodeTreeIds;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
