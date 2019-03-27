/**
 * 
 */
package com.sinosoft.ummp.domain.pojo;

import java.math.BigDecimal;

/**
 * 传输POJO封装类
 * @author Darker.Wang
 * @date 2016-11-2 下午8:17:49
 * @company SINOSOFT
 */
public class TransExcPOJO {
	//来源数据源
	private String fromDataSource;
	//去向数据源
	private String intoDataSource;
	//目标表
	private String targetTable;
	//SQL类型
	private String sqlType;
	//SQLID
	private BigDecimal sqlId;
	//具体SQL
	private String sql;
	
	public String getFromDataSource() {
		return fromDataSource;
	}
	public void setFromDataSource(String fromDataSource) {
		this.fromDataSource = fromDataSource;
	}
	public String getIntoDataSource() {
		return intoDataSource;
	}
	public void setIntoDataSource(String intoDataSource) {
		this.intoDataSource = intoDataSource;
	}
	public String getTargetTable() {
		return targetTable;
	}
	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}
	public String getSqlType() {
		return sqlType;
	}
	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}
	public BigDecimal getSqlId() {
		return sqlId;
	}
	public void setSqlId(BigDecimal sqlId) {
		this.sqlId = sqlId;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	@Override
	public String toString() {
		return "TransExcPOJO [fromDataSource=" + fromDataSource
				+ ", intoDataSource=" + intoDataSource + ", \n targetTable="
				+ targetTable + ", sqlType=" + sqlType + ", \n sql=" + sql + "]";
	}
	/**
	 * debug模式输出
	 * @return
	 */
	public String toDebugString(){
		return toString();
	}
	/**
	 * info 模式输出
	 * @return
	 */
	public String toInfoString(){
		return "TransExcPOJO [fromDataSource=" + fromDataSource
				+ ", intoDataSource=" + intoDataSource + ", targetTable="
				+ targetTable + ", sqlType=" + sqlType + "]";
	}
}
