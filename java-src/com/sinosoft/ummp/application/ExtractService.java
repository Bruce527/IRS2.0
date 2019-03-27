/**
 * 
 */
package com.sinosoft.ummp.application;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DataGridModel;


/**
 * 提数批处理接口，
 * <br>2016-12-10 17:00 Darker 新增指定提数批次号
 * @author Darker.Wang
 * @date 2016-9-1 上午10:42:07
 * @company SINOSOFT
 */
public interface ExtractService {
	/**
	 * 根据传输类型手动提数
	 * @param pojo 前台参数
	 * @param excId 传输ID
	 * @return 成功失败
	 * @throws Exception
	 */
	public boolean extract(ParamPOJO pojo,BigDecimal excId) throws Exception;
	/**
	 * 传输前校验
	 * @param sqlIds
	 * @return 校验SQL 与结果的Map集合 集合中 <br> 
	 * 0 与 false 代表失败，所以配置校验SQL也是需要返回 1-成功，0-失败 true-成功，false-失败
	 * @throws Exception
	 */
	public List<Map<String,String>> extractBefore(List<BigDecimal> sqlIds) throws Exception;
	/**
	 * <p> 获取返回值，map中取值如下：</p>
	 * String resultMap.get("msg");<br>
	 * String resultMap.get("errorCode");<br>
	 * String resultMap.get("errorMessage");<br>
	 * String resultMap.get("errorFunc");<br>
	 * String resultMap.get("exceptionMessage");<br>
	 * @return
	 */
	public Map<String,String> getResultMap();
	/**
	 * 提数检验：<br>
	 * map result: 1-有值 0-无值<br>
	 * map batchNo: 对批次号<br>
	 * map stateFlag: 对应状态<br>
	 * map stateFlagName: 对应状态中文名<br>
	 * @param pojo
	 * @param excId
	 * @return
	 */
	public Map<String, String> checkExtract(ParamPOJO pojo);
	/**
	 * 获取异常信息集合
	 * @return
	 */
	public List<Exception> getExceptions();
	/**
	 * 指定提数批次号
	 * @param tBatchNo
	 * @author Darker.Wang
	 */
	public void setBatchNo(String tBatchNo);
	/**
	 * 获取指定提数批次号
	 * @return
	 */
	String getBatchNo();
	/**
	 * 获取前置校验SQL
	 * @param dgm
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	Map<String, Object> getVerifyList(DataGridModel dgm) throws SQLException,
			IOException;
}
