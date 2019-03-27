package com.sinosoft.platform.core.spring;
/**
 * 多数据源控制：DBContextHolder.setDBType(DBContextHolder.XX) 控制数据源
 * @author Darker.Wang
 * @date 2016-7-7 下午1:51:44
 * @company SINOSOFT
 */
public class DBContextHolder {
	/**本地默认数据源**/
	public static final String DATA_SOURCE_UMP = "dataSourceUMP";
	/**ODS数据源**/
	public static final String DATA_SOURCE_ODS = "dataSourceODS";
	/**ICP开发环境**/
	public static final String DATA_SOURCE_ICPDEP = "dataSourceICPDEP";
	//TODO 如若新新增数据源，需要新增final 类
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	 * 设置当前线程的数据源类型
	 * @param dbType
	 */
	public static void setDBType(String dbType) {
		contextHolder.set(dbType);
	}

	/**
	 * 获取当前线程的数据源类型
	 * @return
	 */
	public static String getDBType() {
		return contextHolder.get();
	}

	/**
	 * 清空之后新起线程，恢复默认，否则若线程不变则为当前线程事先设置好的或者是实现默认的
	 */
	public static void clearDBType() {
		contextHolder.remove();
	}
	/**
	 * 回复本地默认数据源
	 */
	public static void recover(){
		setDBType(DATA_SOURCE_UMP);
	}
}