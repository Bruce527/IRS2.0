/**
 * 
 */
package com.sinosoft.ummp.task.job.impl;

import java.math.BigDecimal;
import java.util.List;

import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.ummp.application.ExtractService;
import com.sinosoft.ummp.application.impl.ExtractServiceImpl;
import com.sinosoft.ummp.domain.mapper.TDefTransexcMapper;
import com.sinosoft.ummp.domain.model.TDefTransexc;
import com.sinosoft.ummp.task.SuperJob;
import com.sinosoft.ummp.task.job.ExtractJob;
import com.sinosoft.ummp.util.UMMPContext;

/**
 * 上海人身险数据提取批处理
 * @author Darker.Wang
 * @date 2016-8-18 下午2:06:37
 * @company SINOSOFT
 */
public class SHIAExtractDataJob extends SuperJob implements ExtractJob {

	ExtractService service = null;
	public SHIAExtractDataJob(){
		//设置为提数群组
		this.setJobGroup("JOB_EXTRACT");
	}
	
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.task.job.ExtractJob#extract(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean extract(String startDate, String endDate) throws Exception {
		// TODO 业务实现
		System.out.println("================= 上海人身险数据提取批处理开始 =================");
		try{
			System.out.println("================= StartDate: "+startDate+" endDate: "+endDate);
			//查询传输
			TDefTransexcMapper tDefTransexcMapper = context.getBean(TDefTransexcMapper.class);
			List<TDefTransexc> list = tDefTransexcMapper.getTransByComId(new BigDecimal(UMMPContext.SUBMIT_PLAT_SHIA));
			if(list == null || list.size() <= 0){
				System.out.println("================= 上海人身险数据提取批处理 : 无对应的传输");
			}
			service = (ExtractService) context.getBean(ExtractServiceImpl.class);
			String tBatchNo = "TN-"+DateUtils.getCurrentDateAndTime();
			service.setBatchNo(tBatchNo);
			for(TDefTransexc trans : list){
				BigDecimal excId = trans.getExcId();
				ParamPOJO pojo = new ParamPOJO();
				pojo.setStartDate(startDate);
				pojo.setEndDate(endDate);
				pojo.setBussNo("");//设置为空，否则ORACEL匹配成NULL
				pojo.setUserCode(loginInfo.getUserCode());//设置操作用户
				pojo.setComId(new BigDecimal(UMMPContext.SUBMIT_PLAT_SHIA));//设置操作平台
			 	service.extract(pojo, excId);
			}
		}catch(Exception e){
			throw e;
		}finally{
			System.out.println("================= 上海人身险数据提取批处理结束 =================");
		}
		return true;
	}

	/**
	 * 提数，提完数日期置后：提数日期在T_DEF_CODE_DICT中配置 code_type=SYS_VAR code=START_DATE/END_DATE
	 * @throws Exception 
	 * @see com.sinosoft.ummp.task.SuperJob#excute()
	 */
	@Override
	public boolean excute() throws Exception {
		TDefCodeDict startCode = getCodeDict("SYS_VAR", "START_DATE", new BigDecimal(UMMPContext.SUBMIT_PLAT_SHIA));
		TDefCodeDict endCode = getCodeDict("SYS_VAR", "END_DATE", new BigDecimal(UMMPContext.SUBMIT_PLAT_SHIA));
		String startDate = startCode.getCodeAlias();
		String endDate = endCode.getCodeAlias();
		boolean result = extract(startDate,endDate);
		if(result){
			String newStartDate = calDate(startDate,1,"D");
			String newEndDate = calDate(endDate,1,"D");
			startCode.setCodeAlias(newStartDate);
			endCode.setCodeAlias(newEndDate);
			updateCodeDict(startCode);
			updateCodeDict(endCode);
		}
		return result;
	}

}
