package com.sinosoft.platform.core.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefJdbc;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefRole;
import com.sinosoft.platform.core.util.LoginInfo;
/**
 * 码表公共服务接口
 * @author Darker.Wang
 * @date 2016-5-26 上午11:15:50
 *
 */
public interface CodeQueryService {

	/**
	 * 返回集合List:LDCode
	 * @param codetype
	 * @param loginfo
	 * @return
	 */
	public List<TDefCodeDict> queryCode(String codetype,LoginInfo loginfo);
	/**
	 * 返回集合List:LDCode
	 * @param codetype
	 * @param loginfo
	 * @return
	 */
	public List<TDefCodeDict> queryCode(String codetype,String code,LoginInfo loginfo);
	/**
	 * 无条件查询
	 * @param codetype
	 * @return
	 */
	public List<TDefCodeDict> queryCode(String codeType);
	/**
	 * 获取编码信息
	 * @param codeType
	 * @param code
	 * @return
	 */
	public List<TDefCodeDict> queryCode(String codeType,String code);
	/**
	 * 根据用户编码显示用户的平台
	 * @param userCode
	 * @return
	 */
	public List<TDefPlatCom> listPlatsByUserCode(String userCode);
	/**
	 * 通过ID获取平台信息
	 * @param id
	 * @return
	 */
	public TDefPlatCom listPlatsById(Integer id);
	/**
	 * 获取系统所有角色
	 * @return
	 */
	public List<TDefRole> listRoles();
	/**
	 * 获取用户所有角色
	 * @param loginInfo
	 * @return
	 */
	public List<TDefRole> listRoles(LoginInfo loginInfo);
	/**
	 * 根据用户编码获取对应权限
	 * @param userCode
	 * @return
	 */
	public List<TDefRole> lietRoles(String userCode);
	/**
	 * @param id
	 * @return
	 */
	public List<TDefRole> listRoleById(Integer id);
	/**
	 * @param jdbcType 4-SPRING数据源
	 * @return
	 */
	public List<TDefJdbc> listJdbc(String jdbcType);
	/**
	 * 根据传进来的COMId获取对应的信息
	 * @param codetype
	 * @param comid
	 * @return
	 */
	public List<TDefCodeDict> queryCode(String codetype, BigDecimal comid);
	/**
	 * 获取CodeName
	 * @param codeType
	 * @param code
	 * @return
	 */
	public String getCodeName(String codeType,String code);
	/**
	 * 获取CodeAlials
	 * @param codeType
	 * @param code
	 * @return
	 */
	public String getCodeAlails(String codeType,String code);
	/**
	 * 获取CodeAlials
	 * @param codeType
	 * @param code
	 * @param comId
	 * @return
	 */
	public String getCodeAlails(String codeType,String code,BigDecimal comId);
	/**
	 * 获取Code as Array
	 * @param codeType
	 * @return
	 */
	public List<String> getCodeArray(String codeType);
	/**
	 * 获取所有类型
	 * @return
	 */
	public List<String> queryCodeType();
	/**
	 * 获取所有平台机构编码
	 * @return
	 */
	public List<Map<String,String>> queryCodeCom();
	/**
	 * 根据类型获取所有编码
	 * @param codeType
	 * @return
	 */
	public List<String> getCodes(String codeType);
	/**
	 * 构造近十年年数
	 * @return
	 */
	public List<String> queryYear();
	/**
	 * 获取系统配置路径:支持参数化配置。<br>
	 * EG: ROOT_PATH = /root/icp/<br>
	 * LOG_PATH = ${ROOT_PATH}/xmllog or ${ROOT_PATH}heartlog
	 * @param code
	 * @return
	 */
	public String getSysPath(String code);
	/**
	 * 获取枚举字典
	 * @param codeType
	 * @param code
	 * @param comId
	 * @return
	 */
	public TDefCodeDict getQueryCode(String codeType,String code,BigDecimal comId);
	/**
	 * 更改CodeDict
	 * @param codeDict
	 */
	public int updateQueryCode(TDefCodeDict codeDict);
	/**
	 * 保存CodeDict
	 * @param codeDict
	 */
	public int insertQueryCode(TDefCodeDict codeDict);
	/**
	 * 删除指定枚举
	 * @param codeDict
	 * @return
	 */
	public int deleteQueryCode(TDefCodeDict codeDict);
	/**
	 * 获取状态关联
	 * @param codeType
	 * @param code
	 * @param comId
	 * @return
	 */
	public String getStatusRela(String codeType,String code,BigDecimal comId);
	/**
	 * 获取群组关联
	 * @param codeType
	 * @param code
	 * @param comId
	 * @return
	 */
	public String getGroupRela(String codeType,String code,BigDecimal comId);
	/**
	 * 获取枚举信息，返回第一条，用于只有一个的情况下
	 * @param codeType
	 * @param code
	 * @return
	 */
	public TDefCodeDict getQueryCode(String codeType, String code);
}
