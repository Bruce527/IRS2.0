package com.sinosoft.ummp.application.rdsi.shia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.application.ReturnDealService;

/**
 * 个险承保信息同步上传结果返回处理，调用承保信息同步上传返回处理。
 * @author Darker.Wang
 * @date 2016-12-6 下午4:56:14
 * @company SINOSOFT
 */
@Service
public class SHIAN0102RDeal implements ReturnDealService {
	
	@Autowired 
	SHIAN01RDeal sHIAN01RDeal;
	
	/**
	 * 边解析边处理
	 */
	@Override
	@Transactional
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		return sHIAN01RDeal.dealReturn(sr, pojo);
	}
}













