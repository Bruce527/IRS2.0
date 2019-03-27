/**
 * 
 */
package com.sinosoft.eos.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 业务模型,按批次报送时无业务号，按业务报送时有批次号，即每次报送都会是一个批次
 * @author Darker.Wang
 * @date 2016-7-6 下午7:32:10
 * @company SINOSOFT
 */
public class BussModel implements Serializable{

	
	private static final long serialVersionUID = 1L;
	/** 1-保单号 **/
	public static final int BUSSNO_TYPE_POLICY = 1;//保单号
	/** 2-批单号|保全号 **/
	public static final int BUSSNO_TYPE_ENDERSMENT = 2;//批单号
	/** 3-理赔号|赔案号 **/
	public static final int BUSSNO_TYPE_CLAIM = 3;//理赔号
	/** 0-其他号 **/
	public static final int BUSSNO_TYPE_OTHER = 0;//其他号
	//注意 此处的类型与T_DEF_PLAT_COM 中 COM_CODE 保持统一
	/**1-北京健康险平台**/
	public static final String SUB_PLAT_BJHI = "BJHI";//北京健康险平台
	/**2-北京意外险平台**/
	public static final String SUB_PLAT_BJAI = "BJAI";//北京意外青苔
	/**3-上海人身险平台**/
	public static final String SUB_PLAT_SHIA = "SHIA";//上海人身险平台
	/**4-江苏中介平台**/
	public static final String SUB_PLAT_JSAP = "JSAP";//江苏中介平台
	/**5-保单登记平台**/
	public static final String SUB_PLAT_PRP = "PRP";//保单登记保单登记平台
	/**6-山东意外险平台**/
	public static final String SUB_PLAT_SDAI = "SDAI";//山东意外险平台
	
	private String bussNo;//业务号
	private String bussNoType;//业务号类型
	private String bussDate;//业务日期
	private String batchNo;//批次号
	private String bussType;//业务类型
	private String bussCode;//业务编码
	private String bussName;//业务名称
	private String subBussType;//父级业务类型【定义为报送平台】
	private BigDecimal comId;//报送机构

	/**
	 * 获取业务号
	 * @return
	 */
	public String getBussNo() {
		return bussNo;
	}

	/**
	 * 设置业务号
	 * @param bussNo
	 */
	public void setBussNo(String bussNo) {
		this.bussNo = bussNo;
	}

	/**
	 * 获取业务号类型
	 * @return
	 */
	public String getBussNoType() {
		return bussNoType;
	}

	/**
	 * 设置业务号类型
	 * @param bussNoType
	 */
	public void setBussNoType(String bussNoType) {
		this.bussNoType = bussNoType;
	}

	public String getBussDate() {
		return bussDate;
	}

	public void setBussDate(String bussDate) {
		this.bussDate = bussDate;
	}

	/**
	 * 获取批次号
	 * @return
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * 设置批次号
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * 获取业务类型
	 * @return
	 */
	public String getBussType() {
		return bussType;
	}

	/**
	 * 设置业务类型
	 * @param bussType
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	/**
	 * 获取业务编码
	 * @return
	 */
	public String getBussCode() {
		return bussCode;
	}

	/**
	 * 设置业务编码
	 * @param bussCode
	 */
	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}

	/**
	 * 获取业务名称
	 * @return
	 */
	public String getBussName() {
		return bussName;
	}
	
	/**
	 * 设置业务名称
	 * @param bussName
	 */
	public void setBussName(String bussName) {
		this.bussName = bussName;
	}

	/**
	 * 获取平台ID
	 * @return
	 */
	public BigDecimal getComId() {
		return comId;
	}

	/**
	 * 设置平台ID
	 * @param comId
	 */
	public void setComId(BigDecimal comId) {
		this.comId = comId;
	}


	/**
	 * 获取父级业务类型【定义为报送平台】
	 * @return
	 */
	public String getSubBussType() {
		return subBussType;
	}

	/**
	 * 设置父级业务类型【定义为报送平台】
	 * @param subBussType
	 */
	public void setSubBussType(String subBussType) {
		this.subBussType = subBussType;
	}


	@Override
	public String toString() {
		return "BussModel [bussNo=" + bussNo + ", bussNoType=" + bussNoType
				+ ", batchNo=" + batchNo + ", bussType=" + bussType
				+ ", bussCode=" + bussCode + ", bussName=" + bussName
				+ ", comId=" + comId + "]";
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
