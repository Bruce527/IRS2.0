/**
 * 
 */
package com.sinosoft.ummp.application.rdsi.shia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.application.ReturnDealService;

/**
 * 团单核保信息同步上传 返回处理，调用核保信息同步上传返回处理。<br>
 * 因为是根据接口的BUSS_TYPE构造返回处理类，所以为区分团险个险将接口升级为SHIAU0101 则要有其相对应的返回处理
 * @author Darker.Wang
 * @date 2016-12-6 下午4:38:34
 * @company SINOSOFT
 */
@Service
public class SHIAU0101RDeal implements ReturnDealService{
	@Autowired
	SHIAU01RDeal sHIAU01RDeal;

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ReturnDealService#dealReturn(com.sinosoft.eos.model.SubmitReturn, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		// TODO Auto-generated method stub
		boolean result = sHIAU01RDeal.dealReturn(sr, pojo);
		System.out.println("SHIAU0101 返回处理，调用SHIAU01的返回处理： "+result);
		return result;
	}
}

