/**
 * 
 */
package com.sinosoft.ummp.application;

import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;

/**
 * @author Darker.Wang
 * @date 2016-9-6 下午9:42:16
 * @company SINOSOFT
 */

public interface ReturnDealService {

	/**
	 * 返回处理
	 * @param sr
	 * @param pojo
	 * @return
	 */
	public boolean dealReturn(SubmitReturn sr,ParamPOJO pojo);

}
