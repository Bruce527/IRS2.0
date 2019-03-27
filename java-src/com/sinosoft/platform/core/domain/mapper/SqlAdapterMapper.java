/**
 * 
 */
package com.sinosoft.platform.core.domain.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;

/**
 * @author Darker.Wang
 * @date 2016-6-24 上午10:40:11
 * 动态SQL适配器
 */
public interface SqlAdapterMapper {
	/**
	 * 执行动态查询SQL
	 * @param sqlAdapter
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> excuteQuery(SqlAdapter sqlAdapter);
	/**
	 * 执行动态查询SQL
	 * @param sqlAdapter
	 * @return
	 */
	public BigDecimal excuteQueryCount(SqlAdapter sqlAdapter);
	/**
	 * 执行动态更新SQL
	 * @param sqlAdapter
	 * @return
	 */
	public int excuteUpdate(SqlAdapter sqlAdapter);
	/**
	 * 执行动态插入SQL
	 * @param sqlAdapter
	 * @return
	 */
	public int excuteInsert(SqlAdapter sqlAdapter);
	/**
	 * 执行动态删除SQL
	 * @param sqlAdapter
	 * @return
	 */
	public int excuteDelete(SqlAdapter sqlAdapter);
	
	public List<ParamPOJO> excuteParamPOJO(SqlAdapter sqlAdapter);

}
