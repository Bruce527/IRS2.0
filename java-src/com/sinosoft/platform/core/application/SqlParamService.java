/**
 * 
 */
package com.sinosoft.platform.core.application;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.TDefSqlParamsExample;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;

/**
 * SQL对应的参数接口类
 * @author Darker.Wang
 * @date 2016-7-26 上午9:07:00
 * @company SINOSOFT
 */
public interface SqlParamService {
	/***
	 * 系统默认参数
	 */
	public Map<String,String> defaultParams = new HashMap<String,String>();
	/**
	 * 获取系统默认参数
	 * @return
	 */
	public Map<String,String> getDefaultParam();
	/**
	 * 设置系统默认参数
	 * @param dm
	 */
	public void setDefaultParam(Map<String,String> dm);
	/**
	 * 用以对SQL进行参数赋值
	 * 1、赋值系统默认参数
	 * 2、赋值参入参数
	 * 3、若传入参数与系统参数相同，取传入参数
	 * 4、SQL中参数形式为#{XX}
	 * @param sql 返回赋值后的参数
	 * @param sqlParams 传入参数
	 * @return
	 */
	public String doSqlParamed(String sql,Map<String,String> sqlParams);
	/**
	 * 初始化系统默认参数
	 * @param pojo
	 * @return
	 */
	public Map<String,String> initDefaultParams(ParamPOJO pojo);
	/**
	 * 用获取参数
	 * @param example
	 * @param pojo 为空则加载传入参数
	 * @return
	 */
	public Map<String,String> initParams(TDefSqlParamsExample example,ParamPOJO pojo);
	/**
	 * 用获取参数
	 * @param example 初始化参数的实例
	 * @param pojo 为空则加载传入参数
	 * @param otherParam 其他参数【自定义或者来自业务】
	 * @return
	 */
	public Map<String,String> initParams(TDefSqlParamsExample example,ParamPOJO pojo,Map<String,String> otherParam);
	/**
	 * 根据SQLID获取到对应的赋值后的SQL（自动从参数表中获取值）
	 * @param sqlId
	 * @param pojo
	 * @return
	 */
	public String getSqlBySqlId(BigDecimal sqlId,ParamPOJO pojo);
	
	/**
	 * 1、根据SQL获取到对应的赋值后的SQL<br>
	 * （自动从参数表中获取值，因为给定SQL所以只有系统默认参数，即从POJO中取）<br>
	 * 2、同时可给特定自定义参数Map。<br>
	 * 3、注意：若有相同参数，则自定义参数将会覆盖原有参数，自定义级别大于参数对象
	 * @param sqlId sqlId
	 * @param pojo 参数对象
	 * @param param 自定义参数
	 * @return
	 */
	public String getSqlBySqlId(BigDecimal sqlId, ParamPOJO pojo,
			Map<String, String> param);
	/**
	 * 初始化并获取系统参数
	 * @param sqlId
	 * @param pojo
	 * @return
	 */
	public Map<String, String> getSqlParams(BigDecimal sqlId, ParamPOJO pojo,Map<String, String> selfParam);
	/**
	 * 获取SQL对应的参数<br>
	 * 内部调用 initDefaultParams
	 * @param pojo
	 * @return
	 */
	public Map<String, String> getSysParams(ParamPOJO pojo);
	/**
	 * 获取SQL<br>
	 * 注意：<br>
	 * 1、调用前若有需要请先调用：getSysParams 初始化系统参数的方法获取到系统参数<br>
	 * 2、也可以传递自定义的参数进入,自定义的级别优先配置的级别
	 * @param sqlId
	 * @param pojo
	 * @param selfParam
	 * @return
	 */
	public String getSql(BigDecimal sqlId, ParamPOJO pojo,
			Map<String, String> selfParam);
	
}
