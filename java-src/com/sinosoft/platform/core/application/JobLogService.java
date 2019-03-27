/**
 * 
 */
package com.sinosoft.platform.core.application;

import java.math.BigDecimal;
import java.util.List;

import com.sinosoft.platform.core.domain.model.TDefJobLog;

/**
 * Job 执行日志记录
 * @author Darker.Wang
 * @date 2016-9-1 下午2:42:28
 * @company SINOSOFT
 */
public interface JobLogService {

	public static final String JOB_LOG_SEQ = "SEQ_T_DEF_JOB_LOG";
	
	public int insertJobLog(TDefJobLog jobLog);
	public int updateJobLog(TDefJobLog jobLog);
	public int deleteJobLog(TDefJobLog jobLog);
	public TDefJobLog selectJobLogs(BigDecimal id);
	public List<TDefJobLog> selectJobLogs(String jobCode);
	public List<TDefJobLog> selectJobLogs(TDefJobLog jobLog);
	public int insertJobLogs(List<TDefJobLog> jobLogs);
	public int updateJobLogs(List<TDefJobLog> jobLogs);
	public int deleteJobLogs(List<TDefJobLog> jobLogs);
}
