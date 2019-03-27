/**
 * 
 */
package com.sinosoft.platform.core.domain.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Darker.Wang
 * @date 2016-7-5 下午1:47:44
 * 提数或者报送的参数PO，后续有特殊参数可以继承该类，该类只作为基本的参数POJO类，也做系统默认SQL参数类<br>
 * 保证与T_DEF_SQL_PARAM 中 对应的 param_code 相同 where param_sub_type = '0'（系统默认每条SQL都能使用的）<br>
 * 若在表中添加系统默认参数，需要在SQL中用到则需要在该类中添加一个属性，构造其 get set 方法，这样在SQL参数赋值时才能赋值<br>
 * @注意： 只准添加不准修改或者删除，添加请标注用途，添加者和日期
 */
public class ParamPOJO implements ParamEnum,Serializable {

	//system parameters for msgEngin create by Darker.Wang 2016-07-26 
	private static final long serialVersionUID = 1L;
	private String startDate;//起始日期
	private String endDate;//截至日期
	private String bussNo;//业务号
	private String bussType;//业务类型
	private String bussFlag;//业务状态
	private String batchNo;//批次号
	private String dateSerialNo;//日期序列号
	private String serialNo;//序列号
	private String companyCode;//公司编码
	private String currentDate;//当前日期
	private String currentTime;//当前时间
	private String year;//明細年份
	
	//for extract or submit add by Darker.Wang 2016-07-26
	private String dataType;//数据类型  I=增量 H=存量
	private String insureType;//险种类型 L=寿险 P=财险 H=健康险
	private String batchType;//批次类型 HIS=存量数据；INC=增量数据；FAI=重新上报的错误数据；DET=对账明细数据
	private String transNo;//传输或者交易编码
	private String transType;//传输类型或者交易类型
	
	//for download or upload add by Darker.Wang 2016-07-26
	private String realPath;//真是路径，用以获取工程发布工程，一般用于文件上传或下载
	
	//for userinfo
	private String userCode;
	
	//for createfile
	private BigDecimal comId;
	private String stateFlag;
	
	//for download:U-上传的成功数据，D-失败的数据
	private String fileType;
	
	//for dealReturnFile:文件名
	private String fileName;
	
	//for 团险承保拆单单次被保人数
	private String cutCount;
	//for 团险承保拆单的拆单次数
	private String bagsCount;
	//for 团险承保拆单的单次报送的被保险人数量
	private String minRowNum;
	private String maxRowNum;
	//for 团险承保拆单的保单下被保险人数
	private String insuredCount;
	//for 团险承保拆单的当前包数
	private String currentBagCount;
	
	private String sendType;//报送期别：01-保单登记一期、02-保单登记二期
	private String pthCode;//补报说明 
	private String remark;//补报原因，只有当pthCode==20时，需要填写下面补报原因
	
	
	
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getPthCode() {
		return pthCode;
	}
	public void setPthCode(String pthCode) {
		this.pthCode = pthCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取： 团险承保拆单单次被保人数
	 * @return
	 */
	public String getCutCount() {
		return cutCount;
	}
	/**
	 * 设置：团险承保拆单单次被保人数
	 * @param cutCount
	 */
	public void setCutCount(String cutCount) {
		this.cutCount = cutCount;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getStateFlag() {
		return stateFlag;
	}

	public BigDecimal getComId() {
		return comId;
	}

	public void setComId(BigDecimal comId) {
		this.comId = comId;
	}

	public void setStateFlag(String stateFlag) {
		this.stateFlag = stateFlag;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getUserCode() {
		return userCode;
	}

	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getBussNo() {
		return bussNo;
	}

	public void setBussNo(String bussNo) {
		this.bussNo = bussNo;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getBussFlag() {
		return bussFlag;
	}

	public void setBussFlag(String bussFlag) {
		this.bussFlag = bussFlag;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getInsureType() {
		return insureType;
	}

	public void setInsureType(String insureType) {
		this.insureType = insureType;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public String getDateSerialNo() {
		return dateSerialNo;
	}

	public void setDateSerialNo(String dateSerialNo) {
		this.dateSerialNo = dateSerialNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}


	public String getBagsCount() {
		return bagsCount;
	}
	public void setBagsCount(String bagsCount) {
		this.bagsCount = bagsCount;
	}
	
	public String getMinRowNum() {
		return minRowNum;
	}
	public void setMinRowNum(String minRowNum) {
		this.minRowNum = minRowNum;
	}
	public String getMaxRowNum() {
		return maxRowNum;
	}
	public void setMaxRowNum(String maxRowNum) {
		this.maxRowNum = maxRowNum;
	}
	
	public String getInsuredCount() {
		return insuredCount;
	}
	public void setInsuredCount(String insuredCount) {
		this.insuredCount = insuredCount;
	}
	
	public String getCurrentBagCount() {
		return currentBagCount;
	}
	public void setCurrentBagCount(String currentBagCount) {
		this.currentBagCount = currentBagCount;
	}
	@Override
	public String toString() {
		return "ParamPOJO [startDate=" + startDate + ", endDate=" + endDate
				+ ", bussNo=" + bussNo + ", bussType=" + bussType
				+ ", bussFlag=" + bussFlag + ", batchNo=" + batchNo
				+ ", dateSerialNo=" + dateSerialNo + ", serialNo=" + serialNo
				+ ", companyCode=" + companyCode + ", currentDate="
				+ currentDate + ", currentTime=" + currentTime + ", year="
				+ year + ", dataType=" + dataType + ", insureType="
				+ insureType + ", batchType=" + batchType + ", transNo="
				+ transNo + ", transType=" + transType + ", realPath="
				+ realPath + ", userCode=" + userCode + ", comId=" + comId
				+ ", stateFlag=" + stateFlag + ", fileType=" + fileType
				+ ", fileName=" + fileName + ", cutCount=" + cutCount
				+ ", bagsCount=" + bagsCount + ", minRowNum=" + minRowNum
				+ ", maxRowNum=" + maxRowNum + ", insuredCount=" + insuredCount
				+ ", currentBagCount=" + currentBagCount + ", sendType="
				+ sendType + ", pthCode=" + pthCode + ", remark=" + remark
				+ "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
