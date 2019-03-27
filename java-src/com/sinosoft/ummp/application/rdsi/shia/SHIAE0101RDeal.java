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
 * 团单保全信息同步上传返回处理，调用保全信息同步返回处理接口
 * @author Darker.Wang
 * @date 2016-12-6 下午4:53:39
 * @company SINOSOFT
 */
@Service
public class SHIAE0101RDeal implements ReturnDealService{

	@Autowired
	SHIAE01RDeal sHIAE01RDeal;
	/**
	 * 
	 */
	public SHIAE0101RDeal() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ReturnDealService#dealReturn(com.sinosoft.eos.model.SubmitReturn, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		// TODO Auto-generated method stub
		return sHIAE01RDeal.dealReturn(sr, pojo);
	}

}
