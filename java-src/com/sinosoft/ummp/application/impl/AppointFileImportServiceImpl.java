package com.sinosoft.ummp.application.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.ummp.application.AppointFileImportService;
import com.sinosoft.ummp.util.CSVUtil;

@Service
public class AppointFileImportServiceImpl implements AppointFileImportService {
	private static final Logger log = Logger
			.getLogger(AppointFileImportServiceImpl.class);

	private SqlAdapter sqlAdapter = new SqlAdapter();

	@Autowired
	SqlAdapterMapper sqlAdapterMapper;

	/** 
	 * map{	年份：year，<br>
	 * 		服务器文件路径：appPath，<br>
	 * 		目标表名：targetTable，<br>
	 * 		目标表中文名：targetTableName
	 * 		}
	 * @throws CoreException 
	 */
	@Override
	public void ImportFile(Map map, Logger log) throws CoreException {
		String appPath = (String) map.get("appPath");
		
			List<String[]> retlist = CSVUtil.importCsv(new File(appPath));
//			System.out.println("------------" + retlist
//					+ "---------------------");
			List<Map<String, String>> lists = changReturn(retlist);
			saveTargetTable(lists, map);
				
	}

	/**
	 * 集合转换,将list<String[]>,转成 List<Map<String, String>>
	 * 
	 * @param List
	 *            <String[]>
	 * @return
	 */
	public List<Map<String, String>> changReturn(List<String[]> lists) {
		System.out.println(lists.size()+"--------------------------------------================================");
		String[] keys = lists.get(0);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		System.out.println(lists.size());
		for (int i = 1; i < lists.size()-1; i++) {
			String[] values = lists.get(i);
			Map<String, String> map = new HashMap<String, String>();
			for (int j = 0; j < keys.length; j++) {
				map.put(keys[j], values[j]);
			}
			list.add(map);
		}
		return list;

	}
	// 动态拼insert语句保存到目标表
	@Transactional
	public void saveTargetTable(List<Map<String, String>> lists,Map map1) throws CoreException {
		try {
			String targetTable = (String)map1.get("targetTable");
			List<String> keys = new ArrayList<String>(); // 所有的KEY
			List<String> values = new ArrayList<String>(); // 所有的VALUE
			StringBuffer sbk = null;
			StringBuffer sbv = null;
			List<Map> retMap = getValue(targetTable);
			// for (Map<String,String> map : lists) {
			for (int i = 0; i < lists.size(); i++) {
				Map<String, String> map = lists.get(i);
				for (Map.Entry<String, String> entry : map.entrySet()) {
					String key = entry.getKey();
					keys.add(key);
				}

				sbk = new StringBuffer();

				String substring = "";
				// for (String key : keys) {
				for (int j = 0; j < keys.size(); j++) {
					String key = keys.get(j);
					sbk.append(key);
					sbk.append(",");
					String str = map.get(key);
					if(str != null && !"".equals(str))
					str = changeSringByType(retMap, str, key, targetTable);
					else
						str = "\'" + str + "\'";
					values.add(str);
				}
				String insertSQL = "insert into " + targetTable + " " + "(";
				String key = sbk.toString();
				insertSQL += key;
				substring = insertSQL.substring(0, insertSQL.lastIndexOf(","));
				substring += ")";
				log.debug(substring);

				String value = " values (";
				substring += value;

				sbv = new StringBuffer();

				int i1 = 0;
				for (Object object : values) {
					sbv.append(object);
					i1++;
					if (values.size() == i1) {
						break;
					}
					sbv.append(",");
				}

				String svalue = sbv.toString();
				svalue = svalue + ")";
				substring += svalue;
				sqlAdapter.setSql(substring);
				// DBContextHolder.setDBType(sqlInfoJdbc);参数已经删除，如有需要再做增加
				sqlAdapterMapper.excuteInsert(sqlAdapter);
				keys.clear();
				values.clear();
				sbk = null;
				sbv = null;
				substring = "";
			}
		} catch (Exception e) {
			throw new CoreException("保存至目标数据库失败!",4);
		}
	}

	/**
	 * 根据字段类型转换字符串格式
	 * 
	 * @param  retMap  str key tTargetTable
	 * @return
	 */
	private String changeSringByType(List<Map> retMap, String str, String key,
			String tTargetTable) {
		// List<Map> retMap = getValue(tTargetTable);
		for (Map map : retMap) {
			String TABLE_NAME = (String) map.get("TABLE_NAME");
			String COLUMN_NAME = (String) map.get("COLUMN_NAME");
			String DATA_TYPE = (String) map.get("DATA_TYPE");
			if (TABLE_NAME.equalsIgnoreCase(tTargetTable)&& COLUMN_NAME.equalsIgnoreCase(key)&& DATA_TYPE.equalsIgnoreCase("NUMBER")) {
				return str;
			} else if (TABLE_NAME.equalsIgnoreCase(tTargetTable)
					&& COLUMN_NAME.equalsIgnoreCase(key)
					&& DATA_TYPE.equalsIgnoreCase("VARCHAR2")) {
				return "\'" + str + "\'";
			} else if (TABLE_NAME.equalsIgnoreCase(tTargetTable)
					&& COLUMN_NAME.equalsIgnoreCase(key)
					&& DATA_TYPE.equalsIgnoreCase("DATE")) {
				Date date = new Date(str);
				String dateTime = DateUtils.getDateTimeString(date);
				String h = dateTime.substring(11, 13);
				String m = dateTime.substring(14, 16);
				String s = dateTime.substring(17, dateTime.length());
				if (h.equals("00") && m.equals("00") && s.equals("00")) {
					String dateString = DateUtils.getDateString(date); // 转换成日期格式
					return "to_date(" + "\'" + dateString + "\'" + "," + "\'"
							+ "YYYY/MM/DD" + "\'" + ")";
				} else {
					return "to_date(" + "\'" + dateTime + "\'" + "," + "\'"
							+ "YYYY/MM/DD HH24:MI:SS" + "\'" + ")";
				}
			}
		}
		return null;
	}

	/**
	 * 获取数据表结构 {TABLE_NAME,COLUMN_NAME,DATA_TYPE,IS_PK,LOLUMN_ID}
	 * 
	 * @param tTargetTable(目标表)
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getValue(String tTargetTable) {
		String sql = " SELECT UTC.TABLE_NAME,UTC.COLUMN_NAME,UTC.DATA_TYPE,(CASE WHEN PKT.pk_name IS NOT NULL THEN 'Y' ELSE 'N' END) AS IS_PK,UTC.COLUMN_ID FROM User_Tab_Columns UTC "
				+ " LEFT JOIN "
				+ " (SELECT ucc.TABLE_NAME, ucc.CONSTRAINT_NAME AS PK_NAME,ucc.COLUMN_NAME AS PK_COL FROM User_Cons_Columns ucc,User_Constraints uc "
				+ " WHERE ucc.CONSTRAINT_NAME = uc.CONSTRAINT_NAME "
				+ " AND uc.CONSTRAINT_TYPE = 'P') PKT "
				+ " ON PKT.pk_col = UTC.COLUMN_NAME AND PKT.TABLE_NAME = UTC.TABLE_NAME"
				+ " WHERE UTC.TABLE_NAME = UPPER('"
				+ tTargetTable
				+ "')  "
				+ " ORDER BY UTC.TABLE_NAME,UTC.COLUMN_ID";
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		List<Map> list = sqlAdapterMapper.excuteQuery(sqlAdapter);
		return list;
	}
	/**
	 * 插入前的删除判断
	 */
	public void deleteTable(Map map) {
		String tTargetTable = (String)map.get("targetTable");
		String tYear = (String)map.get("year");
		if (tYear.equals("")||tYear==null) {
			String sql = "DELETE FROM " + tTargetTable;
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteInsert(sqlAdapter);
		}
		if (!tYear.equals("")&&tYear!=null) {
			String sql = "DELETE FROM " + tTargetTable + " WHERE YEAR = '"
					+ tYear + "'";
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteInsert(sqlAdapter);
		}
	}
}
