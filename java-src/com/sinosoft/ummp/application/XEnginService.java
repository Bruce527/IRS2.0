/**
 * 
 */
package com.sinosoft.ummp.application;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.ummp.domain.model.BussModelImpl;

/**
 * 报送数据（报文规则）接口
 * @author Darker.Wang
 * @date 2016-7-8 下午3:27:01
 * @company SINOSOFT
 */
public interface XEnginService {

	/**
	 * 获取报送数据
	 * @param bmi
	 * @return
	 */
	public Object getSubmitData(BussModelImpl bmi,ParamPOJO pojo) throws CoreException;
	/**
	 * 获取数据类型
	 * @return
	 */
	public Class<?> getDataClass();
	/**
	 * 获取返回结果
	 * @return
	 */
	public Object getReturnData();
	/**
	 * 返回处理
	 * @return
	 */
	public boolean returnDeal();
}
