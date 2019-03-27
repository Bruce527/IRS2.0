/**
 * 
 */
package com.sinosoft.platform.core.application.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.JobLogService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.TDefJobLogMapper;
import com.sinosoft.platform.core.domain.model.TDefJobLog;
import com.sinosoft.platform.core.domain.model.TDefJobLogExample;

/**
 * Job 执行日志记录实现类
 * @author Darker.Wang
 * @date 2016-9-1 下午2:58:35
 * @company SINOSOFT
 */
@Service(value="jobLogService")
public class JobLogServiceImpl implements JobLogService {

	@Autowired
	TDefJobLogMapper tDefJobLogMapper;
	@Autowired
	SequenceService sequenceService;
	
	public JobLogServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#insertJobLog(com.sinosoft.platform.core.domain.model.TDefJobLog)
	 */
	@Override
	public int insertJobLog(TDefJobLog jobLog) {
		// TODO Auto-generated method stub
		if(jobLog.getId() == null){
			jobLog.setId(sequenceService.getBigSeqValByName(JOB_LOG_SEQ));
		}
		return tDefJobLogMapper.insert(jobLog);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#updateJobLog(com.sinosoft.platform.core.domain.model.TDefJobLog)
	 */
	@Override
	public int updateJobLog(TDefJobLog jobLog) {
		// TODO Auto-generated method stub
		return tDefJobLogMapper.updateByPrimaryKey(jobLog);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#deleteJobLog(com.sinosoft.platform.core.domain.model.TDefJobLog)
	 */
	@Override
	public int deleteJobLog(TDefJobLog jobLog) {
		// TODO Auto-generated method stub
		return tDefJobLogMapper.deleteByPrimaryKey(jobLog.getId());
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#selectJobLogs(java.math.BigDecimal)
	 */
	@Override
	public TDefJobLog selectJobLogs(BigDecimal id) {
		// TODO Auto-generated method stub
		return tDefJobLogMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#selectJobLogs(java.lang.String)
	 */
	@Override
	public List<TDefJobLog> selectJobLogs(String jobCode) {
		// TODO Auto-generated method stub
		TDefJobLogExample example = new TDefJobLogExample();
		example.createCriteria().andJobCodeEqualTo(jobCode);
		return tDefJobLogMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#selectJobLogs(com.sinosoft.platform.core.domain.model.TDefJobLog)
	 */
	@Override
	public List<TDefJobLog> selectJobLogs(TDefJobLog jobLog) {
		// TODO Auto-generated method stub
		TDefJobLogExample example = new TDefJobLogExample();
		TDefJobLogExample.Criteria criteria = example.createCriteria();
		if(jobLog.getId() != null){
			criteria.andIdEqualTo(jobLog.getId());
		}
		if(jobLog.getJobCode() != null){
			criteria.andJobCodeEqualTo(jobLog.getJobCode());
		}
		if(jobLog.getJobName() != null){
			criteria.andJobNameLike("%"+jobLog.getJobName()+"%");
		}
		if(jobLog.getStartTime() != null){
			criteria.andStartTimeGreaterThanOrEqualTo(jobLog.getStartTime());
		}
		if(jobLog.getEndTime() != null){
			criteria.andEndTimeGreaterThanOrEqualTo(jobLog.getEndTime());
		}
		if(jobLog.getJobStatus() != null){
			criteria.andJobStatusEqualTo(jobLog.getJobStatus());
		}
		return tDefJobLogMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#insertJobLogs(java.util.List)
	 */
	@Override
	@Transactional
	public int insertJobLogs(List<TDefJobLog> jobLogs) {
		// TODO Auto-generated method stub
		int i = 0;
		for (TDefJobLog tDefJobLog : jobLogs) {
			i += this.insertJobLog(tDefJobLog);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#updateJobLogs(java.util.List)
	 */
	@Override
	public int updateJobLogs(List<TDefJobLog> jobLogs) {
		// TODO Auto-generated method stub
		int i = 0;
		for (TDefJobLog tDefJobLog : jobLogs) {
			i += this.updateJobLog(tDefJobLog);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.JobLogService#deleteJobLogs(java.util.List)
	 */
	@Override
	public int deleteJobLogs(List<TDefJobLog> jobLogs) {
		// TODO Auto-generated method stub
		int i = 0;
		for (TDefJobLog tDefJobLog : jobLogs) {
			i += this.deleteJobLog(tDefJobLog);
		}
		return i;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
