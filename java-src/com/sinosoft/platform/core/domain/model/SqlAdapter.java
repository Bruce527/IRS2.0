package com.sinosoft.platform.core.domain.model;

import java.io.Serializable;

/**
 * SQL适配器
 * @author Darker.Wang
 * @date 2016-7-5 下午5:11:29
 * @company SINOSOFT
 */
public class SqlAdapter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//是否分页
	private boolean isByPage = false; 
	//执行SQL
	private String sql;
	//当前页
	private int page = 0;
	//总共多少页
	private int rows = 0;
	//数据类型，null 或者为空 则默认本地，否则指定
	private String DBType;
	
	public SqlAdapter() {
		// TODO Auto-generated constructor stub
	}
	public SqlAdapter(String sql) {
		// TODO Auto-generated constructor stub
		this.sql = sql;
	}
	
	public boolean isByPage() {
		return isByPage;
	}
	public void setByPage(boolean isByPage) {
		this.isByPage = isByPage;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public String getDBType() {
		return DBType;
	}
	public void setDBType(String dbType) {
		this.DBType = dbType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
