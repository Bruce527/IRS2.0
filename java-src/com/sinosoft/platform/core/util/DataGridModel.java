package com.sinosoft.platform.core.util;


/**
 * EasyUI datagrid 封装类
 * @author Darker.Wang
 * @date 2016-8-11 下午5:28:41
 * @company SINOSOFT
 */
public class DataGridModel implements java.io.Serializable {

	private static final long serialVersionUID = 7232798260610351343L;

	private int page; // 当前页,名字必须为page

	private int rows; // 每页大小,名字必须为rows

	private String sort; // 排序字段

	private String order; // 排序规则
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	/**
	 * 获取起始页
	 * @return
	 */
	public int getStartIndex(){
		int startIndex =  (this.page - 1) * this.rows + 1;
		return startIndex;
	}
	/**
	 * 获取结束页
	 * @return
	 */
	public int getEndIndex(){
		int startIndex =  (this.page - 1) * this.rows + this.rows;
		return startIndex;
	}
}
