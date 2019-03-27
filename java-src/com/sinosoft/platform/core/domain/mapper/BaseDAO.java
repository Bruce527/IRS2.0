package com.sinosoft.platform.core.domain.mapper;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinosoft.platform.core.application.DataSourceService;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.spring.DBContextHolder;
/**
 * Base DAO as a father for DAO ,All DAO implements maybe but not must extends this class
 * @author Darker.Wang
 * @date 2016-05-12
 */
@Repository
public class BaseDAO extends SqlSessionDaoSupport{

	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	public SqlSession sqlSession;
	@Autowired
	DataSourceService dataSourceService;

	/**
	 * 恢复默认DBType
	 */
	public void clearDBType() {
		DBContextHolder.clearDBType();
	}
	/**
	 * 设置指定数据源
	 * @param dbType DBContextHolder.XX 与配置文件中保持一致
	 */
	public void setDBType(String dbType){
		DBContextHolder.setDBType(dbType);
	}
	/**
	 * 获取本地连接池中的连接，使用后记得关闭
	 * @return
	 */
	public Connection getConnection(){
		Connection con = dataSourceService.getConnection();
		return con;
	}
	/**
	 * 根据是否自动提交获取连接池
	 * @param autoCommit
	 * @return
	 */
	public Connection getConnection(boolean autoCommit){
		Connection con = dataSourceService.getConnection(autoCommit);
		return con;
	}
	/**
	 * 获取数据源
	 * @return
	 */
	public DataSource getDataSource(){
		return dataSourceService.getDataSource();
	}
	/**
	 * 关闭指定连接
	 * @param con
	 */
	public void close(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
	}
	/**
	 * 适用于自动注入： 适用于通过注解获取
	 * @return
	 */
	public SqlSession getSession(SqlAdapter sqlAdapter){
		sqlSession = super.getSqlSession();
		if(sqlSession == null){
			sqlSession = sqlSessionFactory.openSession();
		}
		return sqlSession;
	}
	/**
	 * 适用于自动注入： 重写getSession这个方法
	 * @param conn
	 * @return
	 */
	public SqlSession getSession(Connection conn){
		sqlSession = sqlSessionFactory.openSession(conn);
		return sqlSession;
	}
	
	public void GC(){
		if(sqlSession != null){
			sqlSession.clearCache();
			sqlSession.close();
			sqlSession = null;
			clearDBType();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
