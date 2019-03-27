/**
 * 
 */
package com.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.platform.core.application.SqlUtilService;

/**
 * @author Darker.Wang
 * @date 2016-9-28 下午7:46:20
 * @company SINOSOFT
 */

public class SqlUtilServiceTest extends BaseTest{

	@Autowired
	SqlUtilService sqlUtilService;
	@Autowired
	SqlSession sqlSession;
	@Test
	public void SqlUtilTest() {
		// TODO Auto-generated constructor stub
		String sql = "select sysdate from dual where 1=2";
		try {
			List<String> list = sqlUtilService.getSqlColInfo(sql);
			System.out.println("测试结果： "+list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
