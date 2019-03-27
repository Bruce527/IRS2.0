package com.sinosoft.ummp.application;

import java.math.BigDecimal;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.TDefJdbc;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.model.TDefSqlParams;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.domain.model.TDefBagEvent;

public interface MonitorDeployService{
	Map<String, Object> getPageList(DataGridModel dgm, TDefSql sql,TDefJdbc jdbc);

	void saveEventInfo(Map<String, Object> map, LoginInfo loginInfo) throws Exception;

	void deleteGetDataSqlCode(BigDecimal id);

	Map<String, Object> getExistEvent(DataGridModel dgm, TDefSql sql,
			TDefBagEvent event);

	void deleteEvent(BigDecimal id);

	void deleteMatter(String monitorCode);
	/**
	 * 保存监控定义算法，保存的算法SQL类型为 MONITOR_CONFIG
	 * @param map
	 * @param loginInfo
	 * @param type 保存标识 1-修改 0-新增
	 * @throws CoreException
	 */
	void saveDefinitionInfo(Map<String, Object> map, LoginInfo loginInfo) throws Exception;

	void saveUpdateSqlInfo(Map<String, Object> map, LoginInfo loginInfo) throws Exception;
	//生成压缩文件
	void createZip(String monitorCode,String zipName) throws CoreException;
	
	void saveSqlParam(Integer flag, TDefSqlParams params) throws CoreException;

	Map<String, Object> findGetDataSqlCodeById(BigDecimal id);
	/**
	 * 自定义参数传递
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	public void setParam(Map map);
}
