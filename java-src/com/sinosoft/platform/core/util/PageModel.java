/**
 * 
 */
package com.sinosoft.platform.core.util;

import java.io.Serializable;

/**
 * 分页模型
 * @author Darker.Wang
 * @date 2016-6-1 下午4:37:39
 * 
 */
public class PageModel extends DataGridModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PageModel() {
		// TODO Auto-generated constructor stub
	}
	/**查询起始页**/
	private int queryStartIndex;
	/**结束页**/
	private int queryEndIndex;
	/**总记录数**/
	private int allCount;
	/**where后自定义条件**/
	private int whereAnd;
	
	public int getQueryStartIndex() {
		return queryStartIndex;
	}


	public void setQueryStartIndex(int queryStartIndex) {
		this.queryStartIndex = queryStartIndex;
	}


	public int getQueryEndIndex() {
		return queryEndIndex;
	}


	public void setQueryEndIndex(int queryEndIndex) {
		this.queryEndIndex = queryEndIndex;
	}


	public int getAllCount() {
		return allCount;
	}


	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}


	public int getWhereAnd() {
		return whereAnd;
	}


	public void setWhereAnd(int whereAnd) {
		this.whereAnd = whereAnd;
	}

	

	@Override
	public String toString() {
		return "PageModel [queryStartIndex=" + queryStartIndex
				+ ", queryEndIndex=" + queryEndIndex + ", allCount=" + allCount
				+ ", whereAnd=" + whereAnd + "]";
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
