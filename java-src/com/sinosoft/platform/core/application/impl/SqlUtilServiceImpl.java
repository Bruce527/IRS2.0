package com.sinosoft.platform.core.application.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.DataSourceService;
import com.sinosoft.platform.core.application.SqlUtilService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;

/**
 * <br>SINOSOFT 专用
 * <br>针对于SQL的一些基本通用操作，更新请注释更新时间和内容
 * @author Darker.Wang
 * @date 2016-6-24 下午12:01:10
 */
@Service("sqlUtilService")
public class SqlUtilServiceImpl implements SqlUtilService {

	private static Logger logger = Logger.getLogger(SqlUtilServiceImpl.class);
	@Autowired
	DataSourceService dataSourceService;
	@Autowired
	SqlSession sqlSession;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	/**
	 * 将SQL分裂，成一个节点
	 * @param sql
	 * @return Map<String,String> key=大写 value = 小写
	 */
	private static Map<String,String> getSqlAllInfos(String sql){
		Map<String,String> rtvMap = new HashMap<String,String>();
		//以空格分开
		String[] alls = sql.split(" ",-1);
		for(String s : alls){
			if(s != null && !"".equals(s)){
				String value = s.trim();
				if(value.contains(",")){
					//以逗号分开
					String[] cs = value.split(",");
					for(String ss : cs){
						if(ss != null && !"".equals(",")){
							String temp = ss.trim();
							temp = temp.replaceAll("\"", "").replace("'","");
							if(!rtvMap.containsKey(temp.toUpperCase())){
								rtvMap.put(temp.toUpperCase(), temp);
							}else{
								rtvMap.put(temp, temp);
							}
						}
					}
				}else{
					value = value.replaceAll("\"", "").replace("'","");
					if(!rtvMap.containsKey(value.toUpperCase())){
						rtvMap.put(value.toUpperCase(),value);	
					}else{
						rtvMap.put(value,value);	
					}
				}
			}
		}
		return rtvMap;
	}
	/**
	 * 特殊化Sql
	 * @param sql
	 * @return
	 */
	private String forwardOnly(String sql){
		sql = replaceBy("'#{","'",sql);
		sql = replaceBy("#{","'",sql);
		sql = replaceBy("'${","'",sql);
		sql = replaceBy("${","'",sql);
		sql = replaceBy("'{","'",sql);
		sql = replaceBy("{","",sql);
		sql = replaceBy("'?'","''",sql);
		sql = replaceBy("?","''",sql);
		sql = replaceBy("}'","'",sql);
		sql = replaceBy("}","'",sql);
		//sql += " AND 1=2";
		return sql;
	}
	
	/**
	 * 获取SQL查询列的信息 用list是为了保证顺序性
	 * @param sql
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public List<String> getSqlColInfo(String sql) throws SQLException{
		List<String> rtvList = new ArrayList<String>();
		Connection conn = null;
		try{
			String tSql = forwardOnly(sql);
			logger.debug("- SQL: "+tSql);
			conn = dataSourceService.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(tSql);
			ResultSetMetaData data = rs.getMetaData();
			int maxCol = data.getColumnCount();
			//编列列，List保证顺序性
			for(int column = 1; column <= maxCol; column ++){
				String columnName = data.getColumnName(column);
				rtvList.add(columnName.toUpperCase());
			}
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
			rs = null;
			st = null;
			data = null;
			dataSourceService.close(conn);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("- getSqlColInfo Exception ："+e.getMessage());
			return rtvList;
		}finally{
			if(conn != null && !conn.isClosed()){
				System.out.println("- Close Connection ："+conn);
				conn.close();
			}
		}
		return rtvList;
	}
	/**
	 * 获取 SQL查询列的源信息
	 * @param sql
	 * @return
	 */
	public List<String> getSqlSrcInfo(String sql) throws SQLException{
		List<String> asList = new ArrayList<String>();
		Map<String,String> mapAll = getSqlAllInfos(sql);
		List<String> mapColumns = getSqlColInfo(sql);
		for(String colName : mapColumns){
			String value = mapAll.get(colName.toUpperCase());
			asList.add(value);
		}
		return asList;
	}
	/**
     * 替换指定，用于SQL参数赋值
     * @param key 需要替换的KEY
     * @param value 成换成的VALUE
     * @param src 原SRC
     * @return
     */
    public String replaceBy(String key,String value,String src){
    	if(src == null || src.equals("")){
    		return null;
    	}
    	StringBuffer sb = new StringBuffer(src);
    	if(value == null){
    		value = "NULL";
    	}
    	while(src.contains(key)){
    		int i = src.lastIndexOf(key);
    		src = sb.replace(i, i+key.length(), value).toString();
    		sb = new StringBuffer(src);
    	}
    	return src;
    }
    
	/**
	 * 根据参数替换 参数类型#{XXX}
	 * @param params 参数  key-value key={XXX}
	 * @param src 元SQL
	 * @return 替换后SQL
	 */
    public String paramedSql(Map<String,String> params,String sql){
    	if(sql == null || "".equals(sql)){
    		return null;
    	}
    	Set<String> set = params.keySet();
    	Iterator<String> iter = set.iterator();
    	logger.debug("Before Paramed SQL==> "+sql);
    	while(iter.hasNext()){
    		String key = (String) iter.next();
    		Object obj = params.get(key);
    		String value = "";
    		if(obj != null){
    			value = obj.toString();
    		}
    		if(!key.startsWith("#{")){
    			key = "#{"+key;
    		}
    		if(!key.endsWith("}")){
    			key = key+"}";
    		}
    		sql = replaceBy(key,value,sql);
    	}
    	logger.debug("After  Paramed SQL==> "+sql);
    	return sql;
    }
}
