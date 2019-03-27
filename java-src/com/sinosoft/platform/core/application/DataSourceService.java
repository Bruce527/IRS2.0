/**
 * 
 */
package com.sinosoft.platform.core.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * 数据源服务类
 * @author Darker.Wang
 * @date 2016-9-28 下午9:05:32
 * @company SINOSOFT
 */
public interface DataSourceService {

	/**
	 * 关闭连接
	 */
	public void close(Connection conn);
	/**
	 * 关闭连接
	 * @param conn
	 * @param ps
	 * @param st
	 * @param rs
	 */
	public void close(Connection conn,PreparedStatement ps,Statement st,ResultSet rs);
	/**
	 * 提交
	 */
	public void commit(Connection conn);
	/**
	 * 回滚
	 */
	public void rollback(Connection conn);
	/***
	 * 获取DataSource
	 * @return
	 */
	public DataSource getDataSource();
	/**
	 * 获取默认 Connection autocomit = default
	 * @return
	 */
	public Connection getConnection();
	/**
	 * 创建连接
	 * @param autoCommit 是否自动提交
	 * @return
	 */
	public Connection getConnection(boolean autoCommit);
	/**
	 * 获取默认数据源创建连接
	 * @param autoCommit 是否自动提交
	 * @param readOnly 是否只读
	 * @return
	 */
	public Connection getConnection(boolean autoCommit, boolean readOnly);
	/**
	 * 用于指定DataSourceName获取连接
	 * @param dataSourceName 数据源名称
	 * @return
	 */
	public Connection getConnection(String dataSourceName);
	/**
	 * 用于指定DataSourceName获取连接
	 * @param dataSourceName 数据源名称
	 * @param autoCommit 数据源是否自动提交
	 * @return
	 */
	public Connection getConnection(String dataSourceName,boolean autoCommit);
	/**
	 * 用于指定DataSourceName获取连接
	 * @param dataSourceName 数据源名称
	 * @param autoCommit 数据源是否自动提交
	 * @param readOnly 数据源只读
	 * @return
	 */
	public Connection getConnection(String dataSourceName,boolean autoCommit,boolean readOnly);
}
