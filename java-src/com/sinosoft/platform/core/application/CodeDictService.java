package com.sinosoft.platform.core.application;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * 枚举字典接口
 * @author Darker.Wang
 * @date 2016-8-5 下午4:59:05
 * @company SINOSOFT
 */
public interface CodeDictService {
	
	/**
	 * 添加下枚举字段
	 * @param loginfo 登陆信息
	 * @param tdefcodedict 下拉框字段
	 * @throws CoreException 
	 */
	void saveCodedict(TDefCodeDict tdefcodedict,LoginInfo loginfo) throws  CoreException;
	/**
	 * 保存枚举字典
	 * @param list
	 * @param loginfo
	 * @throws CoreException 
	 */
	void saveCodedict(List<LinkedHashMap<String, Object>> list,LoginInfo loginfo) throws  CoreException;
	/**
	 * 更新枚举字段
	 * @param loginfo 登陆信息
	 * @param tdefcodedict 下拉框字段
	 * @throws CoreException 
	 */
	void updateCodedict(TDefCodeDict tdefcodedict,LoginInfo loginInfo) throws  CoreException;
	/**
	 * 添加枚举字段
	 * @param loginfo 登陆信息
	 * @param tdefcodedict 下拉框字段
	 */
	void deleteCodedict(TDefCodeDict tdefcodedict,LoginInfo loginInfo);
	
	/**
	 * 分页查询 
	 * @param dgm 什么鬼
	 * @param tdefcodedict 下拉框字段
	 */
	Map<String, Object> getPageList(DataGridModel dgm, TDefCodeDict tdefcodedict);
	/**
	 * 保存枚举字典
	 * @param tDefCodeDictKey
	 */
	TDefCodeDict selectbyKey(TDefCodeDict tDefCodeDict);

}
