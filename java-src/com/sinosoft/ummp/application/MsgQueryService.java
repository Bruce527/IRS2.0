/**
 * 
 */
package com.sinosoft.ummp.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.ummp.exception.CISException;
import com.sinosoft.ummp.domain.pojo.MsgQueryPOJO;


/**
 * @author Darker.Wang
 * @date 2016-6-28 下午9:59:28
 * 报文查询服务接口
 */
public interface MsgQueryService {

	/**
	 * 根据条件查询
	 * @param pojo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List queryBaseMsg(MsgQueryPOJO pojo,DataGridModel dgm);
	/**
	 * 根据条件统计
	 * @param pojo
	 * @param dgm
	 * @return
	 */
	int countBaseMsg(MsgQueryPOJO pojo,DataGridModel dgm);
	/**
	 * 校验报文规则是否在使用中，使用中返回true,否则返回false
	 * @param implId
	 * @return
	 */
	boolean checkMsgEnginIsUsing(BigDecimal bussId);
	/**
	 * 转换指定实现为修改模式
	 * @param bussId
	 * @param implId
	 * @return
	 * @throws CISException 
	 */
	boolean pushMsgEngin4Update(BigDecimal bussId) throws CISException;
	/**
	 * 失效
	 * @param bussId
	 * @return
	 */
	Map<String,String> loseEffect(BigDecimal bussId);
	/**
	 * 复效
	 * @param bussId
	 * @return
	 */
	Map<String,String> reEffect(BigDecimal bussId);
}
