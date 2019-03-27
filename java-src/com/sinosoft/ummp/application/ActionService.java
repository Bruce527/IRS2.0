/**
 * 
 */
package com.sinosoft.ummp.application;

import java.util.List;

import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;

/**
 * 义务交流履历操作
 * @author Darker.Wang
 * @date 2016-8-29 下午2:42:23
 * @company SINOSOFT
 * @version 1.0
 */
public interface ActionService {

	/**
	 * 插入ActionTrace
	 * @param actionTraces
	 * @return
	 */
	public int insertActionTrace(List<TDefActionTrace> actionTraces);
	/**
	 * 更改ActionTrace
	 * @param actionTraces
	 * @return
	 */
	public int updateActionTrace(List<TDefActionTrace> actionTraces);
	/**
	 * 删除 ActionTrace
	 * @param actionTraces
	 * @return
	 */
	public int deleteActionTreace(List<TDefActionTrace> actionTraces);
	/**
	 * 查询ActionTrace by select
	 * @param actionTrace
	 * @return
	 */
	public List<TDefActionTrace> selectActionTrace(TDefActionTrace actionTrace);
	/**
	 * 查询ActionTrace by example
	 * @param examle
	 * @return
	 */
	public List<TDefActionTrace> selectActionTrace(TDefActionTraceExample example);
	/**
	 * 查询 ActionTrace by actionNo 
	 * @param actionNo
	 * @return
	 */
	public List<TDefActionTrace> selectActionTrace(String actionNo);
	/**
	 * 插入ActionReturn
	 * @param actionReturns
	 * @return
	 */
	public int insertActionReturn(List<TDefActionReturn> actionReturns);
	/**
	 * 删除ActionReturn
	 * @param actionReturns
	 * @return
	 */
	public int deleteActionReturn(List<TDefActionReturn> actionReturns);
	/**
	 * 更新ActionReturn
	 * @param actionReturns
	 * @return
	 */
	public int updateActionReturn(List<TDefActionReturn> actionReturns);
	/**
	 * 查询ActionReturn By select 
	 * @param actionReturn
	 * @return
	 */
	public List<TDefActionReturn> selectActionReturn(TDefActionReturn actionReturn);
	/**
	 * 查询ActionReturn by example
	 * @param examle
	 * @return
	 */
	public List<TDefActionReturn> selectActionReturn(TDefActionReturnExample example);
	/**
	 * 查询 ActionReturn by actionNo 
	 * @param actionNo
	 * @return
	 */
	public List<TDefActionReturn> selectActionReturn(String actionNo);
	
}
