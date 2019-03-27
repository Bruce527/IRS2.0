/**
 * 
 */
package com.sinosoft.ummp.task.job.impl;

import java.math.BigDecimal;
import java.util.Map;

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
 * 上海人身险报送批处理: 
 * @author Darker.Wang
 * @date 2016-8-18 下午2:06:05
 * @company SINOSOFT
 */
@Service
public class SHIAN0201Job extends SuperJob implements SubmitJob {
	
	public SHIAN0201Job(){
		//设置为报送群组
		this.setJobGroup("JOB_SUBMIT");
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.task.SuperJob#excute()
	 */
	@Override
	public boolean excute() throws Exception {
		// TODO Auto-generated method stub
		int interval = Integer.parseInt(Config.getProperties().getProperty("PRP_INTERVAL"));
		String startDate = DateUtils.calDate(DateUtils.getCurrentDate(),interval,"D");
		String endDate = DateUtils.calDate(DateUtils.getCurrentDate(),interval,"D");
		return submit(startDate,endDate);
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.task.job.SubmitJob#submit(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean submit(String startDate, String endDate) {
		//获取平台
		System.out.println("================= 上海人身险数据报送,承保信息异步上传批处理开始 =================");
		SubmitService service = (SubmitService) context.getBean(SubmitServiceImpl.class);
		System.out.println("================= StartDate: "+startDate+" endDate: "+endDate+" =================");
		try{
			 ParamPOJO pojo = new ParamPOJO();
			 pojo.setStartDate(startDate);
			 pojo.setEndDate(endDate);
			 pojo.setBussType("SHIAN0201");
			 pojo.setBussNo("");
			 pojo.setBatchNo("");
			 service.setApplicationContext(context);
			 Map<String,String> map =  service.submit(new BigDecimal(UMMPContext.SUBMIT_PLAT_SHIA), pojo);
			 System.out.println("================= 上海人身险数据报送批处理: "+map.get("msg"));
		}catch(Exception e){
			new CISException(e.getMessage(),CISExceptionRunable.EXCEPTION_ERROR_L2);
//			return false;
		}finally{
			System.out.println("=================上海人身险数据报送,承保信息异步上传批处理结束 =================");	
		}
		return true;
	}
	
	public static void main (String[] args ){
		
	
		
	}
	
}
