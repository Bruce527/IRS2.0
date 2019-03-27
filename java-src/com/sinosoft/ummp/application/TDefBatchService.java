/**
 * 
 */
package com.sinosoft.ummp.application;

import java.math.BigDecimal;

/**
 * 批次信息表服务类，用以获取批次号，交易号，等信息，如果方法不够您用，请添加字段或者方法实现即可
 * @author Darker.Wang
 * @date 2016-7-8 上午11:58:45
 * @company SINOSOFT
 */
public interface TDefBatchService {
	/**
	 * 根据类型获取批次号
	 * @param batchType
	 * @return
	 */
	public String getBatchNo(String batchType);
	/**
	 * 根据类型和机构获取批次号
	 * @param batchType
	 * @param comId
	 * @return
	 */
	public String getBatchNo(String batchType,BigDecimal comId);
	/**
	 * 根据类型，当前日期，机构获取批次号
	 * @param batchType
	 * @param currentDate
	 * @param comId
	 * @return
	 */
	public String getBatchNo(String batchType,String currentDate,BigDecimal comId);
	/**
	 * 根据类型，当前日期获取批次号
	 * @param batchType
	 * @param currentDate
	 * @return
	 */
	public String getBatchNo(String batchType,String currentDate);
	/**
	 * 获取交易号
	 * @param currentDate
	 * @return
	 */
	public String getTransNo(String currentDate);
	/**
	 * 获取交易号
	 * @param currentDate
	 * @param companyCode
	 * @return
	 */
	public String getTransNo(String currentDate,String companyCode);
	/**
	 * 获取批次号
	 * @param tInsureType 险种类型
	 * @param tBatchType 批次类型
	 * @param tCompanyCode 公司编码
	 * @return
	 */
	public String getBatchNo(String tInsureType, String tBatchType,String tCompanyCode);
}
