/**
 * 
 */
package com.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;

/**
 * @author Darker.Wang
 * @date 2016-7-5 下午5:19:07
 * @company SINOSOFT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/infrastructure-persistence.xml" })
public class SqlAdapterTest {

	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	public void SqlAdapterTest(){
		SqlAdapter  sqlAdapter = new SqlAdapter();
		String sql_q = "select sysdate from dual";
		String sql_i = "INSERT INTO t_def_code_dict (code_type,CODE,code_name,code_alias,com_id,es_status) VALUES ('TEST_TYPE','TEST','测试','测试',1,1)";
		String sql_d = "DELETE FROM t_def_code_dict WHERE code_type = 'TEST_TYPE'";
		String sql_u = "update t_def_code_dict set code = 'TEST_1' where code_type = 'TEST_TYPE'";
//		sqlAdapter.setSql(sql_q);
//		System.out.println(sqlAdapterMapper.excuteQuery(sqlAdapter));
		
//		sqlAdapter.setSql(sql_i);
//		System.out.println(sqlAdapterMapper.excuteInsert(sqlAdapter));
		
//		sqlAdapter.setSql(sql_u);
//		System.out.println(sqlAdapterMapper.excuteUpdate(sqlAdapter));
		
		sqlAdapter.setSql(sql_d);
		System.out.println(sqlAdapterMapper.excuteDelete(sqlAdapter));
	}
	@Test
	public void sqlAdapterTestDynamic(){
		SqlAdapter  sqlAdapter = new SqlAdapter();
		String sql = "select sysdate from dual where 1=1";
//		Map params = new HashMap();
//		params.put("startDate", "2016-07-26");
		sqlAdapter.setSql(sql);
		List<Map> result = sqlAdapterMapper.excuteQuery(sqlAdapter);
		for(Map map : result){
			System.out.println(map);
		}
	}
}
