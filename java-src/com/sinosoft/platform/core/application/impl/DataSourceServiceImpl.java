/**
 * 
 */
package com.sinosoft.platform.core.application.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.DataSourceService;
import com.sinosoft.platform.core.spring.DBContextHolder;

/**
 * 数据源连接服务实现类，用于获取连接，对连接操作等
 * @author Darker.Wang
 * @date 2016-9-28 下午9:06:56
 * @company SINOSOFT
 */
@Service("dataSourceService")
public class DataSourceServiceImpl implements DataSourceService {
	@Autowired
	DataSource dataSource;

	@Override
	public void close(Connection conn){
		if(conn != null){
			try {
				System.out.println("- Closed Connection : "+conn);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void close(Connection conn,PreparedStatement ps,Statement st,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
		}
		if(conn != null){
			close(conn);
			try {
				
				if(conn != null && !conn.isClosed()){
				   System.out.println("- Close Connection agin："+conn);
				   conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	@Override
	public void commit(Connection conn){
		try {
			if(conn != null && !conn.isClosed()){
				System.out.println("- Commit   : "+conn);
				conn.commit();
			}
		} catch (SQLException e) {
			this.close(conn);
			e.printStackTrace();
		}
	}
	@Override
	public void rollback(Connection conn){
		try {
			if(conn != null && !conn.isClosed()){
				System.out.println("- Rollback : "+conn);
				conn.rollback();
			}
		} catch (SQLException e) {
			this.close(conn);
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.SqlUtilService#getConnection()
	 */
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			System.out.println("- Create Connection : "+conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("- Create Connection Exception : "+e.getMessage());
		}
		return conn;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.SqlUtilService#getConnection(org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public Connection getConnection(boolean autoCommit, boolean readOnly) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(autoCommit);
			conn.setReadOnly(readOnly);
			System.out.println("- Create Connection : "+conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("- Create Connection Exception : "+e.getMessage());
			return null;
		}
		return conn;
	}
	
	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.SqlUtilService#getDataSource()
	 */
	@Override
	public DataSource getDataSource() {
		// TODO Auto-generated method stub
		return dataSource;
	}
	
	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.SqlUtilService#getConnection(boolean)
	 */
	@Override
	public Connection getConnection(boolean autoCommit) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("- Create Connection Exception : "+e.getMessage());
			return null;
		}
		return conn;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.DataSourceService#getConnection(java.lang.String)
	 */
	@Override
	public Connection getConnection(String dataSourceName) {
		// TODO Auto-generated method stub
		try{
			DBContextHolder.setDBType(dataSourceName);
			Connection conn = dataSource.getConnection();
			System.out.println("- Create Connection : "+conn);
			return conn;
		}catch(Exception e){
			DBContextHolder.recover();
			e.printStackTrace();
			System.out.println("- 指定dataSourceName获取数据源失败："+dataSourceName);
		}finally{
			System.out.println("- 还原默认数据源。");
			DBContextHolder.recover();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.DataSourceService#getConnection(java.lang.String, boolean)
	 */
	@Override
	public Connection getConnection(String dataSourceName, boolean autoCommit) {
		// TODO Auto-generated method stub
		Connection conn = getConnection(dataSourceName);
		if(conn != null){
			try {
				conn.setAutoCommit(autoCommit);
				return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.DataSourceService#getConnection(java.lang.String, boolean, boolean)
	 */
	@Override
	public Connection getConnection(String dataSourceName, boolean autoCommit,
			boolean readOnly) {
		// TODO Auto-generated method stub
		Connection conn = getConnection(dataSourceName);
		if(conn != null){
			try {
				conn.setAutoCommit(autoCommit);
				conn.setReadOnly(readOnly);
				return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}
