package com.sinosoft.platform.core.application.impl;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.SqlSessionSerivce;


/**
 * 我的SqlSession工厂
 * @author Darker.Wang
 * @date 2016-6-24 上午10:22:35
 *
 */
@Service
public class SqlSessionServiceImpl implements SqlSessionSerivce{
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;

	/**
	 * 创建指定的SqlSession，用于不同库的执行
	 * @param conn
	 * @return
	 */
	public SqlSession getSession(Connection conn){
		sqlSession = sqlSessionFactory.openSession(conn);
		return sqlSession;
	}
	/**
	 * 获取本地SqlSession
	 * @return
	 */
	public SqlSession getSession(){
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
