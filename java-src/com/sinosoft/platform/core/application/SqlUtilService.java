/**
 * 
 */
package com.sinosoft.platform.core.application;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * SQL工具服务类，用于对SQL的解析，赋值等
 * @author Darker.Wang
 * @date 2016-9-28 下午7:17:51
 * @company SINOSOFT
 */
public interface SqlUtilService {
	/**
	 * 获取SQL查询列的信息 用list是为了保证顺序性:查询后列信息
	 * @param sql
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public List<String> getSqlColInfo(String sql) throws SQLException;
	/**
	 * 获取 SQL查询列的源信息，EG as Abc return Abc
	 * @param sql
	 * @return
	 */
	public List<String> getSqlSrcInfo(String sql) throws SQLException;
	/**
     * 替换指定，用于SQL参数赋值
     * @param key 需要替换的KEY
     * @param value 成换成的VALUE
     * @param src 原SRC
     * @return
     */
	public String replaceBy(String key,String value,String src);
	/**
	 * 根据参数替换 参数类型#{XXX}
	 * @param params 参数  key-value key={XXX}
	 * @param src 元SQL
	 * @return 替换后SQL
	 */
	public String paramedSql(Map<String,String> params,String sql);
	
	
	
}
