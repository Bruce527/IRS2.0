/**
 * 
 */
package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.sinosoft.ummp.domain.model.BussModelImpl;

/**
 * 用于实现业务模型
 * @author Darker.Wang
 * @date 2016-7-5 下午6:39:28
 * @company SINOSOFT
 */
public interface BussModelImplMapper {

	/**
	 * 根据业务号获取实现方式
	 * @param bussId
	 * @return
	 */
	public List<BussModelImpl> selectBybussId(BigDecimal bussId);
	/**
	 * 根据业务类型获取实现方式
	 * @param bussType
	 * @return
	 */
	public String getImplType(BigDecimal bussId);
	
}
