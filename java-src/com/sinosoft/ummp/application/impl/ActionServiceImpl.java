/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.ummp.application.ActionService;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.mapper.TDefActionTraceMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;

/**
 * ActionService 业务操作实现类，主要用于报送和返回履历插入和更新
 * @author Darker.Wang
 * @date 2016-8-29 下午2:52:24
 * @company SINOSOFT
 */
@Service("actionService")
public class ActionServiceImpl implements ActionService {

	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;
	@Autowired
	SequenceService sequenceService;
	
	private Logger logger = Logger.getLogger(ActionServiceImpl.class);
	
	public ActionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#insertActionTrace(java.util.List)
	 */
	@Override
	@Transactional
	public int insertActionTrace(List<TDefActionTrace> actionTraces) {
		// TODO Auto-generated method stub
		if(actionTraces == null){
			return -1;
		}
		logger.debug("insert action trace: "+actionTraces.size());
		int i=0;
		for(TDefActionTrace record : actionTraces){
			i += tDefActionTraceMapper.insert(record);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#updateActionTrace(java.util.List)
	 */
	@Override
	public int updateActionTrace(List<TDefActionTrace> actionTraces) {
		// TODO Auto-generated method stub
		if(actionTraces == null){
			return -1;
		}
		logger.debug("update action trace: "+actionTraces.size());
		int i=0;
		for(TDefActionTrace record : actionTraces){
			i += tDefActionTraceMapper.updateByPrimaryKey(record);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#deleteActionTreace(java.util.List)
	 */
	@Override
	public int deleteActionTreace(List<TDefActionTrace> actionTraces) {
		// TODO Auto-generated method stub
		if(actionTraces == null){
			return -1;
		}
		logger.debug("delete action trace: "+actionTraces.size());
		int i=0;
		for(TDefActionTrace record : actionTraces){
			i += tDefActionTraceMapper.deleteByPrimaryKey(record.getId());
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#selectActionTrace(com.sinosoft.ummp.domain.model.TDefActionTrace)
	 */
	@Override
	public List<TDefActionTrace> selectActionTrace(TDefActionTrace actionTrace) {
		// TODO Auto-generated method stub
		TDefActionTraceExample example = new TDefActionTraceExample();
		TDefActionTraceExample.Criteria criteria = example.createCriteria();
		if(actionTrace.getId() != null){
			criteria.andIdEqualTo(actionTrace.getId());
		}
		if(actionTrace.getBatchNo() != null){
			criteria.andBatchNoEqualTo(actionTrace.getBatchNo());
		}
		return tDefActionTraceMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#selectActionTrace(com.sinosoft.ummp.domain.model.TDefActionTraceExample)
	 */
	@Override
	public List<TDefActionTrace> selectActionTrace(TDefActionTraceExample examle) {
		// TODO Auto-generated method stub
		return tDefActionTraceMapper.selectByExample(examle);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#insertActionReturn(java.util.List)
	 */
	@Override
	public int insertActionReturn(List<TDefActionReturn> actionReturns) {
		// TODO Auto-generated method stub
		if(actionReturns == null){
			return -1;
		}
		logger.debug("insert action return: "+actionReturns.size());
		int i=0;
		for(TDefActionReturn record : actionReturns){
			i += tDefActionReturnMapper.insert(record);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#deleteActionReturn(java.util.List)
	 */
	@Override
	public int deleteActionReturn(List<TDefActionReturn> actionReturns) {
		// TODO Auto-generated method stub
		if(actionReturns == null){
			return -1;
		}
		logger.debug("delete action return: "+actionReturns.size());
		int i=0;
		for(TDefActionReturn record : actionReturns){
			i += tDefActionReturnMapper.deleteByPrimaryKey(record.getId());
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#updateActionReturn(java.util.List)
	 */
	@Override
	public int updateActionReturn(List<TDefActionReturn> actionReturns) {
		// TODO Auto-generated method stub
		if(actionReturns == null){
			return -1;
		}
		logger.debug("update action trace: "+actionReturns.size());
		int i=0;
		for(TDefActionReturn record : actionReturns){
			i += tDefActionReturnMapper.updateByPrimaryKey(record);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#selectActionReturn(com.sinosoft.ummp.domain.model.TDefActionReturn)
	 */
	@Override
	public List<TDefActionReturn> selectActionReturn(TDefActionReturn actionReturn) {
		// TODO Auto-generated method stub
		TDefActionReturnExample example = new TDefActionReturnExample();
		TDefActionReturnExample.Criteria criteria = example.createCriteria();
		if(actionReturn.getId() != null){
			criteria.andIdEqualTo(actionReturn.getId());
		}
		if(actionReturn.getActionNo() != null){
			criteria.andActionNoEqualTo(actionReturn.getActionNo());
		}
		return tDefActionReturnMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#selectActionReturn(com.sinosoft.ummp.domain.model.TDefActionReturnExample)
	 */
	@Override
	public List<TDefActionReturn> selectActionReturn(TDefActionReturnExample example) {
		// TODO Auto-generated method stub
		return tDefActionReturnMapper.selectByExample(example);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#selectActionTrace(java.lang.String)
	 */
	@Override
	public List<TDefActionTrace> selectActionTrace(String actionNo) {
		// TODO Auto-generated method stub
		TDefActionTraceExample example = new TDefActionTraceExample();
		TDefActionTraceExample.Criteria criteria = example.createCriteria();
		criteria.andActionNoEqualTo(actionNo);
		return tDefActionTraceMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ActionService#selectActionReturn(java.lang.String)
	 */
	@Override
	public List<TDefActionReturn> selectActionReturn(String actionNo) {
		// TODO Auto-generated method stub
		TDefActionReturnExample example = new TDefActionReturnExample();
		TDefActionReturnExample.Criteria criteria = example.createCriteria();
		criteria.andActionNoEqualTo(actionNo);
		return tDefActionReturnMapper.selectByExample(example);
	}

}
