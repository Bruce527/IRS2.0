/**
 * 
 */
package com.sinosoft.ummp.application;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.TDefSqlParams;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.domain.model.TDefTransexc;
import com.sinosoft.ummp.exception.CISException;

/**
 * 
 * @author gyas-itpingw
 *
 */
public interface ExtractConfigService {

	/**
	 * 保存提数脚本配置信息
	 * @author gyas-itpingw
	 * @param param
	 * @param loginInfo 
	 * @return 
	 * @throws CISException 
	 */
	BigDecimal saveGetDataSqlConfigInfo(String param, LoginInfo loginInfo) throws CISException;
	
	
	/**
	 * 添加数据传输配置信息
	 * @param param
	 * @param loginInfo
	 */
	void addConfigInfo(String param, LoginInfo loginInfo);

	/**
	 * 添加数据传输前配置信息
	 * @param param
	 * @param loginInfo
	 */
	void saveDataTransportAgoConfigInfo(String param, LoginInfo loginInfo);


	/**
	 * 查询传输列表
	 * @param dgm
	 * @param param
	 * @return
	 */
	Map<String, Object> queryTransportList(DataGridModel dgm, String param);

	
	/**
	 * 更新传输信息
	 * @param param
	 * @param loginInfo
	 */
	void updateTransportInfo(String param, LoginInfo loginInfo);

	//////////////////////////////传输中配置/////////////////////////////////
	/**
	 * 获取传输类型
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List getTransportType();

	/**
	 * 获取提数脚本信息
	 * @param id
	 * @return
	 */
	Map<String, Object> getSqlCodeInfoById(BigDecimal id,String flag);

	
	/**
	 * 更新
	 * @throws CISException 
	 */
	void saveUpdateGetDataSqlConfigInfo(Map<String,Object> map, LoginInfo loginInfo) throws CISException;

	/**
	 * 传输配置前列表查询
	 * @param dgm
	 * @param queryParam 
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	Map<String, Object> dataTransportAgoTable(DataGridModel dgm, String queryParam) throws SQLException, IOException;

	/**
	 * 传输配置列表查询
	 * @param dgm
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	Map<String, Object> dataTransportConfigTable(DataGridModel dgm,String queryParam) throws SQLException, IOException;
	
	/**
	 * 传输配置前列表查
	 * @param dgm
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	Map<String, Object> dataTransportAfterTable(DataGridModel dgm,String queryParam) throws SQLException, IOException;

	/**
	 * 删除
	 * @param id
	 * @param num 
	 */
	void deleteDataTransportConfigById(BigDecimal id, Integer num);


	void saveSqlParam(Integer flag, TDefSqlParams params) throws CISException;

	/**
	 * 保存&修改
	 * @param tDefTransexc
	 * @param loginInfo
	 * @throws CISException 
	 */
	void saveUpdate(TDefTransexc tDefTransexc, LoginInfo loginInfo) throws CISException;


	/**
	 * 根据id查询对象
	 * @param id
	 * @return
	 */
	TDefTransexc getById(BigDecimal id);


	void updateSave(TDefTransexc tDefTransexc, LoginInfo loginInfo) throws CISException;


	int deleById(List<BigDecimal> id,String flag) throws CoreException;


	/**
	 * 查询所有传输类型
	 * @return
	 */
	List<TDefTransexc> queryTransType();


	/**
	 * 根据传输类型的id查询对应的传输描述
	 * @param excId
	 * @return
	 */
	String getTransDesc(BigDecimal excId);


	@SuppressWarnings("rawtypes")
	List<Map> queryListInfo(BigDecimal comId);

}
