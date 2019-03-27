/**
 * 
 */
package com.sinosoft.ummp.application;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;

/**
 * 报送返回处理
 * @author Darker.Wang
 * @date 2016-8-16 下午4:33:00
 * @company SINOSOFT
 */
public interface SubmitReturnService {
	/**
	 * 设置容器
	 * @param context
	 */
	public void setApplicationContext(ApplicationContext context);
	/**
	 * 获取容器
	 * @return
	 */
	public ApplicationContext getApplicationContext();
	/**
	 * 处理返回信息
	 * @param sms 报送信息
	 * @param srs 返回信息
	 * @param pojo 报送是POJO
	 * @return
	 */
	public Map<String,String> dealSubmitReturn(List<SubmitModel> sms,
			List<SubmitReturn> srs,ParamPOJO pojo);
}
