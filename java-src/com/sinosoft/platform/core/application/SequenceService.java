/**
 * 
 */
package com.sinosoft.platform.core.application;

import java.math.BigDecimal;

/**
 * 序列服务类接口
 * @author Darker.Wang
 * @date 2016-5-23 下午9:28:24
 * @version 1.0
 * @company SINOSOFT
 */
public interface SequenceService {
	/**获取sequence的值
	 * @param string
	 * @return
	 */
	public String getSeqValByName(String seqName);
	/**
	 * 指定长度获取序列
	 * @param seqName
	 * @param length
	 * @return
	 */
	public String getSeqValByName(String seqName,int length);
	/**
	 * 获取大数据
	 * @param seqName
	 * @return
	 */
	public BigDecimal getBigSeqValByName(String seqName);
	/**
	 * 添加一个序列
	 * @param seqName
	 * @param start
	 * @param step
	 * @return
	 */
	public int addSequnce(String seqName,int start,int step);
	/**
	 * 删除一个序列
	 * @param seqName
	 * @return
	 */
	public int delSequnce(String seqName);
	/**
	 * 获取固定序列号（SEQ_SERIALNO）
	 * @return
	 */
	public BigDecimal getSerialNo();
	/**
	 * 获取指定长度固定序列号（SEQ_SERIALNO） 无效返回-1
	 * @param length
	 * @return
	 */
	public String getSerialNo(int length);
	/**
	 * 获取指定序列号，指定长度，无效返回-1
	 * @param seqName 序列名称
	 * @param length 长度为空，则认为是不指定长度
	 * @return
	 */
	public String getSerialNo(String seqName,int length);
	/**
	 * 获取指定序列的最大值，指定长度，无效返回-1
	 * @param seqName 序列名称
	 * @param length 长度为空，则认为是不指定长度
	 * @return
	 */
	public String getMaxNo(String seqName,int length);
	
}
