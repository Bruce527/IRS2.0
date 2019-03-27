package com.sinosoft.platform.core.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.TDefCodeMapping;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
/**
 * LDCodeMapping服务类
 * @author gyas-itpingw
 *
 */
public interface CodeMappingService {

	/**
	 * 统计记录数
	 * @param codetype
	 * @return
	 */
	public int countByExample(String codeType);
	/**
	 * 通过Id查询
	 * @param ids
	 * @return
	 */
	public List<TDefCodeMapping> queryCodeMapping(List<Integer> ids);
	/**
	 * 通过分页模型和类型查询
	 * @param model
	 * @param codetype
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map queryCodeMapping(DataGridModel model,TDefCodeMapping tDefCodeMapping);
	/**
	 * 查询无分页显示
	 * @param codetype
	 * @return
	 */
	public List<TDefCodeMapping> queryCodeByType(String codeType);
	/**
	 * 添加
	 * @param mappings
	 * @return
	 */
	public int addCodeMapping(List<TDefCodeMapping> mappings);
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	public int deleteMapping(List<BigDecimal> ids);
	/**
	 * 获取编码
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> queryCodeType();
	/**
	 * 保存
	 * @param tDefCodeMapping
	 * @param loginInfo
	 * @throws CISException 
	 */
	public void saveCodeMapping(TDefCodeMapping tDefCodeMapping,LoginInfo loginInfo) throws CoreException;
	
	/**
	 * 根据id查询回显页面
	 * @return
	 */
	public TDefCodeMapping selectById(BigDecimal id);
	/**
	 * 更新映射编码
	 * @param tDefCodeMapping
	 * @param loginInfo
	 * @throws CoreException
	 */
	public void updateSave(TDefCodeMapping tDefCodeMapping, LoginInfo loginInfo) throws CoreException;
}
