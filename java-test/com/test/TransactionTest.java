/**
 * 
 */
package com.test;

import java.lang.Thread.State;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jxl.common.Logger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.spring.DBContextHolder;
import com.sinosoft.platform.core.util.DateUtils;

/**
 * @author Darker.Wang
 * @date 2016-11-1 上午10:54:08
 * @company SINOSOFT
 */
public class TransactionTest extends BaseTest{
	private static final Logger log = Logger.getLogger(TransactionTest.class);
	@Autowired
	SequenceService sequenceService; 
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;

	SqlAdapter sqlAdapter = new SqlAdapter();
	@Test
	public void testAction(){
		try {
			_testAction();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("rawtypes")
	private void _testAction() throws InterruptedException{
		for(int i = 0 ; i < 100; i++){
			DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ODS);
			String sql = "SELECT to_char(SYSDATE,'yyyymmddhhmiss')||LPAD(ROWNUM,10,0) AS ID,p.policy_no AS code_type,'姓名已屏蔽' AS code_name,SYSDATE AS inserttime,'SYS' AS OPERATOR FROM ODS_STG.OFE_T_POLICY p WHERE ROWNUM < 50000";
//			String sql = "SELECT to_char(SYSDATE,'yyyymmddhhmissSSS') AS ID,'TEST_CODE' AS code_type,'测试' AS code_name,SYSDATE AS inserttime,'SYS' AS OPERATOR FROM dual ";
			log.info("正在传输中处理，SQL_DS： "+DBContextHolder.getDBType());
			log.info("正在传输中处理，SQL_IS："+sql);
			sqlAdapter.setSql(sql);
			List<Map> maps  = sqlAdapterMapper.excuteQuery(sqlAdapter);
			SaveTableThread saveTables = new SaveTableThread(maps,DBContextHolder.DATA_SOURCE_UMP,"T_TEST_CODE");
			Thread thread = new Thread(saveTables);
			thread.start();
			State state = thread.getState();
			log.info("传输完毕，执行："+state);
		}
	}
	
	private class SaveTableThread implements Runnable{
		Logger sLogger = Logger.getLogger(SaveTableThread.class);
		@SuppressWarnings("rawtypes")
		List<Map> listMap;
		String intoJdbc;
		String targetTable;
		/**
		 * 新增线程
		 * @param listMap 结果集合
		 * @param intoJdbc 插入JDBC
		 * @param targetTable 目标表
		 */
		@SuppressWarnings("rawtypes")
		SaveTableThread(List<Map> listMap,String intoJdbc,String targetTable){
			this.listMap = listMap;
			this.intoJdbc = intoJdbc;
			this.targetTable = targetTable;
		}
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			boolean result = false;
			try {
				sLogger.info(targetTable+"准备保存数据");
				result = saveTargetTable(listMap,intoJdbc,targetTable);
				sLogger.info(targetTable+" 保存数据完毕，结果："+result);
			} catch (SQLException e) {
				e.printStackTrace();
				sLogger.info(targetTable+" 保存数据异常："+e.getMessage());
			}finally{
				DBContextHolder.recover();
			}
		}
		@SuppressWarnings("rawtypes")
		@Transactional
		private boolean saveTargetTable(List<Map> lists,String sqlIntoJdbc,String targetTable) throws SQLException{
			
			List<String> keys = new ArrayList<String>(); //所有的KEY
			List<Object> values = new ArrayList<Object>(); //所有的VALUE
			StringBuffer sbk = null;
			StringBuffer sbv = null;
			
			for (Map<String,Object> map : lists) {
				
				for(Map.Entry<String, Object> entry :map.entrySet()){
					String key = entry.getKey();
					keys.add(key);
				}
				
				sbk = new StringBuffer();
				
				String substring= "";
				for (String key : keys) {
					sbk.append(key);
					sbk.append(",");
					Object obj = map.get(key);
					if(obj instanceof BigDecimal){
						values.add(obj);
					}else if(obj instanceof String){
						values.add("\'"+obj+"\'");
					}else if(obj instanceof Date){
						Date date = (Date)obj;
						String  dateTime = DateUtils.getDateTimeString(date);
						String h = dateTime.substring(11, 13);
						String m = dateTime.substring(14, 16);
						String s = dateTime.substring(17, dateTime.length());
						if(h.equals("00")&&m.equals("00")&&s.equals("00")){
							String dateString = DateUtils.getDateString(date);  //转换成日期格式
							values.add("to_date("+"\'"+dateString+"\'"+","+"\'"+"YYYY-MM-DD" +"\'"+")");
						}else{
							values.add("to_date("+"\'"+dateTime+"\'"+","+"\'"+"YYYY-MM-DD HH24:MI:SS" +"\'"+")");
						}
					}
				}
				
				String insertSQL = "insert into "+targetTable+" "+"(";
				String key = sbk.toString();
				insertSQL += key;
				substring = insertSQL.substring(0,insertSQL.lastIndexOf(","));
				substring+=")";                                                
				
				
				String value = " values (";
				substring+=value;
				
				sbv = new StringBuffer();
				
				int i = 0;
				for (Object object : values) {
					sbv.append(object);
					i++;
					if(values.size()==i){
						break;
					}
					sbv.append(",");
				}
				
				String svalue = sbv.toString();
				svalue = svalue+")";
				substring += svalue;
				
//				sLogger.info("传输中插入数据，自动构造的 INSERT");
//				sLogger.info("传输中插入数据，SQL_DS："+DBContextHolder.getDBType());
//				sLogger.info("传输中插入数据，SQL_IS："+substring);
				System.out.println(DBContextHolder.getDBType()+" saving data ："+substring);
				sqlAdapter.setSql(substring);
				DBContextHolder.setDBType(sqlIntoJdbc);
				//执行插入SQL
				try{
					sqlAdapterMapper.excuteInsert(sqlAdapter);
				}catch(Exception e){
					e.printStackTrace();
					log.error("执行插入SQL异常，SQL："+sqlAdapter.getSql());
					//垃圾回收
					keys.clear();
					values.clear();
					
					DBContextHolder.recover();
					
//					//考虑是抛出还是继续？目前先继续
//					SQLException sqlException = new SQLException("执行SQL异常："+e.getMessage());
//					throw sqlException;
					
					//目前采用继续
					continue;
				}
				
				//垃圾回收
				keys.clear();
				values.clear();
				sbk = null;
				sbv = null;
				substring = "";
			}	
			return true;
		}
	}
	public static void main(String[] args){
		List<String> sqls = new ArrayList<String>();
		for(int i = 0; i<125; i++){
			sqls.add("SQL:"+i);
		}
		int inv = 10;
		for(int i = 0;i < sqls.size(); i+=inv){
			int end = i+inv;
			if(end > sqls.size()){
				end = sqls.size();
			}
			List<String> tsqls = sqls.subList(i, end);
			show(tsqls);
			System.out.println("完成一批："+(i+1)+" - "+end);
		}
	}
	private static void show(List<String> sqls){
		for(String sql : sqls){
			System.out.println(sql);
		}
	}
	
}
