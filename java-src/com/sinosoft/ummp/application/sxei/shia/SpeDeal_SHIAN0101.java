/**
 * 
 */
package com.sinosoft.ummp.application.sxei.shia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.application.MsgClassService;
import com.sinosoft.ummp.domain.model.BussModelImpl;

/**
 * 团单承保信息同步上传:特殊类处理
 * @author Darker.Wang
 * @date 2017-1-10 下午5:52:48
 * @company SINOSOFT
 */
@Service
public class SpeDeal_SHIAN0101 extends MsgClassService{
	@Autowired
	SequenceService sequenceService;
	/**
	 * 
	 */
	public SpeDeal_SHIAN0101() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgClassService#getSubmitData(com.sinosoft.ummp.domain.model.BussModelImpl, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public Object getSubmitData(BussModelImpl bmi, ParamPOJO pojo) {
		// TODO Auto-generated method stub
		System.out.println("我正在特殊处理：getBatchNo:"
		+pojo.getBatchNo()
		+" getBatchType:"+pojo.getBatchType()
		+" getBussType:"+pojo.getBussType());
		System.out.println(sequenceService.getMaxNo("MAXNO", 10));
		//TODO 特殊处理业务
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgClassService#getDataClass()
	 */
	@Override
	public Class<?> getDataClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgClassService#getReturnData()
	 */
	@Override
	public Object getReturnData() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgClassService#returnDeal()
	 */
	@Override
	public boolean returnDeal() {
		// TODO Auto-generated method stub
		return false;
	}

}
