/**
 * 
 */
package com.sinosoft.platform.core.application;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

/**
 * @author Darker.Wang
 * @date 2016-6-24 上午10:31:44
 * 
 */
public interface SqlSessionSerivce {
	/**
	 * 获取指定连接的Session
	 * @param conn
	 * @return
	 */
	public SqlSession getSession(Connection conn);
	/**
	 * 获取本地连接Session
	 * @return
	 */
	public SqlSession getSession();
}
