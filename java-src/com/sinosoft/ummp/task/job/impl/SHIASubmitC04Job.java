/**
 * 
 */
package com.sinosoft.ummp.task.job.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.ummp.application.SubmitService;
import com.sinosoft.ummp.application.impl.SubmitServiceImpl;
import com.sinosoft.ummp.exception.CISException;
import com.sinosoft.ummp.exception.CISExceptionRunable;
import com.sinosoft.ummp.task.SuperJob;
import com.sinosoft.ummp.task.job.SubmitJob;
import com.sinosoft.ummp.util.UMMPContext;

import config.Config;

/**
 * 上海人身险报送批处理:<br>
 * 团险理赔信息同步上传：SHIAC04<br>
 * @author Darker.Wang
 * @date 2016-8-18 下午2:06:05
 * @company SINOSOFT
 */
@Service
public class SHIASubmitC04Job extends SuperJob implements SubmitJob {
	
	public SHIASubmitC04Job(){
		//设置为报送群组
		this.setJobGroup("JOB_SUBMIT");
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.task.SuperJob#excute()
	 */
	@Override
	public boolean excute() throws Exception {
		// TODO 获取前一天数据
		int interval = Integer.parseInt(Config.getProperties().getProperty("PRP_INTERVAL"));
		String startDate = DateUtils.calDate(DateUtils.getCurrentDate(),interval,"D");
		String endDate = DateUtils.calDate(DateUtils.getCurrentDate(),interval,"D");
		return submit(startDate,endDate);
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.task.job.SubmitJob#submit(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean submit(String startDate, String endDate) throws Exception {
		//获取平台
		System.out.println("================= 上海人身险数据报送批处理开始 =================");
		SubmitService service = (SubmitService) context.getBean(SubmitServiceImpl.class);
		System.out.println("================= StartDate: "+startDate+" endDate: "+endDate+" =================");
		/**团险理赔信息同步上传：SHIAC04 **/
		
		try{
				 System.out.println("-  C04正在保送...");
				 ParamPOJO pojo = new ParamPOJO();
				 pojo.setStartDate(startDate);
				 pojo.setEndDate(endDate);
				 pojo.setUserCode(loginInfo.getUserCode());
				 pojo.setComId(new BigDecimal(UMMPContext.SUBMIT_PLAT_SHIA));
				 pojo.setBussType("SHIAC04");
				 service.setApplicationContext(context);
				 service.submit(new BigDecimal(UMMPContext.SUBMIT_PLAT_SHIA), pojo); 
			
		}catch(Exception e){
			String errorMsg = "上海人身险业务类型：C04执行失败！<br>";
			System.out.println(errorMsg);
			CISException cis = new CISException(errorMsg+e.getMessage(),CISExceptionRunable.EXCEPTION_ERROR_L5);
			cis.setException(e);
			throw cis;
		}finally{
			System.out.println("================= 上海人身险数据报送批处理结束 =================");	
		}
		return true;
	}
}
