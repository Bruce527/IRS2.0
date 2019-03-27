package com.sinosoft.ummp.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * 提数批处理接口
 * 
 * @author lht
 * @date 2016-9-1 上午10:42:07
 * @company SINOSOFT
 */
public interface ExpinfoService {
	/**
	 * 根据传输类型手动提数
	 * 
	 * @param pojo
	 *            前台参数
	 * @param excId
	 *            传输ID
	 * @return 成功失败
	 * @throws Exception
	 */
	public boolean extract(ParamPOJO pojo, BigDecimal excId) throws Exception;

	/**
	 * <p>
	 * 获取返回值，map中取值如下：
	 * </p>
	 * String resultMap.get("msg");<br>
	 * String resultMap.get("errorCode");<br>
	 * String resultMap.get("errorMessage");<br>
	 * String resultMap.get("errorFunc");<br>
	 * String resultMap.get("exceptionMessage");<br>
	 * 
	 * @return
	 */
	public Map<String, String> getResultMap();
	
	public List<String> selectYear();

	public boolean dealData(String years, LoginInfo loginInfo) throws CoreException;

}
