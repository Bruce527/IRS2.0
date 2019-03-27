package com.sinosoft.ummp.application;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.ummp.domain.model.TDefActionTrace;

/**
 * 报送服务接口<br>
 * 1、List<TDefBussModel> 调用 getBussModeByCom(BigDecimal comId) 获取到需要报送的业务信息<br>
 * 2、submitBussModel(List<TDefBussModel> bms,ParamPOJO pojo) 进行报送
 * @author Darker.Wang
 * @date 2016-9-1 上午11:18:57
 * @company SINOSOFT
 */
public interface SubmitService {
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
	 * 根据平台和参数进行报送
	 * @param comId 报送平台机构ID
	 * @param pojo 报送参数
	 * @return
	 */
	public Map<String,String> submit(BigDecimal comId, ParamPOJO pojo) throws Exception;

	/**
	 * 查询待保送记录
	 * @param model
	 * @param transType
	 * @param batchNo
	 * @param stateFlag
	 * @return
	 */
	public Map<String, Object> listFile(DataGridModel model,String transType,String batchNo,String stateFlag);

	/**
	 * 用于报送完毕显示报送结果信息
	 * @param model
	 * @param actionNos
	 * @param tDefActionTrace
	 * @return
	 */
	public Map<String, Object> listHand(DataGridModel model,String actionNos,TDefActionTrace tDefActionTrace);
}

