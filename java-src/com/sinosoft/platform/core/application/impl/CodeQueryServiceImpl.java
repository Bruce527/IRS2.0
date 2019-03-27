package com.sinosoft.platform.core.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.mapper.TDefCodeDictMapper;
import com.sinosoft.platform.core.domain.mapper.TDefJdbcMapper;
import com.sinosoft.platform.core.domain.mapper.TDefPlatComMapper;
import com.sinosoft.platform.core.domain.mapper.TDefRoleMapper;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefCodeDictExample;
import com.sinosoft.platform.core.domain.model.TDefCodeDictExample.Criteria;
import com.sinosoft.platform.core.domain.model.TDefJdbc;
import com.sinosoft.platform.core.domain.model.TDefJdbcExample;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefPlatComExample;
import com.sinosoft.platform.core.domain.model.TDefRole;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.StringTool;

/**
 * CodeQueryService 实现类
 * @author Darker.Wang
 * @date 2016-10-12 上午11:51:34
 * @company SINOSOFT
 */
@Service(value="codeQueryService")
public class CodeQueryServiceImpl implements CodeQueryService{

	@Autowired
	TDefCodeDictMapper tDefCodeDictMapper;
	@Autowired
	TDefRoleMapper tDefRoleMapper;
	@Autowired
	TDefJdbcMapper tDefJdbcMapper;
	
	//一下入驻可根据自己系统需要走统一枚举码入口处的
	@Autowired
	TDefPlatComMapper tDefPlatComMapper;
	
	
	private static final Logger loger = Logger.getLogger(CodeQueryServiceImpl.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TDefCodeDict> queryCode(String codetype, LoginInfo loginfo) {
		// TODO Auto-generated method stub
		loger.debug("QUERY CODE:"+codetype);
		TDefCodeDictExample example = new TDefCodeDictExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codetype);
		if(loginfo != null){
			criteria.andComIdEqualTo(loginfo.getCompanyId());
		}
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setOrderByClause("CODE");
		return tDefCodeDictMapper.selectByExample(example);
	}

	@Override
	public List<TDefCodeDict> queryCode(String codetype) {
		TDefCodeDictExample example = new TDefCodeDictExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codetype);
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setOrderByClause("CODE");
		return tDefCodeDictMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#queryCode(java.lang.String, java.lang.String, com.sinosoft.util.LoginInfo)
	 */
	@Override
	public List<TDefCodeDict> queryCode(String codetype, String code,
			LoginInfo loginfo) {
		TDefCodeDictExample example = new TDefCodeDictExample();
		Criteria criteria = example.createCriteria();
		if(codetype != null){
			criteria.andCodeTypeEqualTo(codetype);
		}
		if(code != null){
			criteria.andCodeEqualTo(code);
		}
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setOrderByClause("CODE");
		return tDefCodeDictMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#queryCode(java.lang.String, java.lang.String)
	 */
	@Override
	public List<TDefCodeDict> queryCode(String codeType, String code) {
		// TODO Auto-generated method stub
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		if(codeType != null && !"".equals(codeType)){
			criteria.andCodeTypeEqualTo(codeType);
		}
		if(code != null && !"".equals(code)){
			criteria.andCodeEqualTo(code);
		}
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setDistinct(true);
		example.setOrderByClause("CODE");
		List<TDefCodeDict> codes = tDefCodeDictMapper.selectByExample(example);
		return codes;
	}
	@Override
	public List<TDefPlatCom> listPlatsByUserCode(String userCode) {
		// TODO Auto-generated method stub
		List<TDefPlatCom> coms = tDefPlatComMapper.selectByUserCode(userCode);
		return coms;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#listPlatsById(java.lang.Integer)
	 */
	@Override
	public TDefPlatCom listPlatsById(Integer id) {
		// TODO Auto-generated method stub
		return tDefPlatComMapper.selectByPrimaryKey(new BigDecimal(id));
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#listRoles()
	 */
	@Override
	public List<TDefRole> listRoles() {
		// TODO Auto-generated method stub
		return tDefRoleMapper.selectByExample(null);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#listRoles(com.sinosoft.util.LoginInfo)
	 */
	@Override
	public List<TDefRole> listRoles(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		return tDefRoleMapper.selectByUserCode(loginInfo.getUserCode());
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#listRoleById(java.lang.Integer)
	 */
	@Override
	public List<TDefRole> listRoleById(Integer id) {
		// TODO Auto-generated method stub
		List<TDefRole> rtvList = new ArrayList<TDefRole>();
		rtvList.add(tDefRoleMapper.selectByPrimaryKey(new BigDecimal(id)));
		return rtvList;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#listJdbc(java.lang.String)
	 */
	@Override
	public List<TDefJdbc> listJdbc(String jdbcType) {
		// TODO Auto-generated method stub
		TDefJdbcExample example = new TDefJdbcExample();
		if(jdbcType != null && !"".equals(jdbcType)){
			example.createCriteria().andJdbcTypeEqualTo(jdbcType);
		}
		return tDefJdbcMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#queryCode(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public List<TDefCodeDict> queryCode(String codeType, BigDecimal comid) {
		// TODO Auto-generated method stub
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		if(codeType != null && !"".equals(codeType)){
			criteria.andCodeTypeEqualTo(codeType);
		}
		if(comid != null && !"".equals(comid)){
			criteria.andComIdEqualTo(comid);
		}
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setDistinct(true);
		example.setOrderByClause("CODE");
		List<TDefCodeDict> codes = tDefCodeDictMapper.selectByExample(example);
		return codes;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#lietRoles(java.lang.String)
	 */
	@Override
	public List<TDefRole> lietRoles(String userCode) {
		// TODO Auto-generated method stub
		return tDefRoleMapper.selectByUserCode(userCode);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#getCodeName(java.lang.String, java.lang.String)
	 */
	@Override
	public String getCodeName(String codeType, String code) {
		// TODO Auto-generated method stub
		List<TDefCodeDict> codes = queryCode(codeType,code);
		if(codes!= null && codes.size() > 0 ){
			return codes.get(0).getCodeName();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#getCodeAlails(java.lang.String, java.lang.String)
	 */
	@Override
	public String getCodeAlails(String codeType, String code) {
		// TODO Auto-generated method stub
		List<TDefCodeDict> codes = queryCode(codeType,code);
		if(codes!= null && codes.size() > 0 ){
			return codes.get(0).getCodeAlias();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#getCodeArray(java.lang.String)
	 */
	@Override
	public List<String> getCodeArray(String codeType) {
		// TODO Auto-generated method stub
		List<TDefCodeDict> codes = queryCode(codeType);
		List<String> codeArray = new ArrayList<String>();
		for(TDefCodeDict code : codes){
			codeArray.add(code.getCode());
		}
		return codeArray;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#queryCodeType()
	 */
	@Override
	public List<String> queryCodeType() {
		// TODO Auto-generated method stub
		return tDefCodeDictMapper.codeQueryType();
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.CodeQueryService#queryCodeCom()
	 */
	@Override
	public List<Map<String,String>> queryCodeCom() {
		// TODO Auto-generated method stub
		TDefPlatComExample example = new TDefPlatComExample();
		example.setDistinct(true);
		example.setOrderByClause("COM_ID");
		List<TDefPlatCom> tcs = tDefPlatComMapper.selectByExample(example);
		List<Map<String,String>> rtvMaps = new ArrayList<Map<String,String>>();
		for(TDefPlatCom com : tcs){
			Map<String,String> map = new HashMap<String,String>();
			map.put("comId",""+ com.getComId());
			map.put("comName", com.getComName());
			rtvMaps.add(map);
		}
		return rtvMaps;
	}
	
	public List<String> getCodes(String codeType) {
		List<String> rtv = new ArrayList<String>();
		List<TDefCodeDict> codes = queryCode(codeType);
		for(TDefCodeDict code : codes){
			rtv.add(code.getCode());
		}
		return rtv;
	}

	@Override
	public List<String> queryYear() {
		// TODO Auto-generated method stub
		return tDefCodeDictMapper.selectExportDataYear();
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#getSysPath(java.lang.String)
	 */
	@Override
	public String getSysPath(String defPath) {
		// TODO Auto-generated method stub
		List<TDefCodeDict> codes = queryCode("SYS_PATH");
		Map<String,String> map = new HashMap<String,String>();
		for(TDefCodeDict code : codes){
			map.put(code.getCode(),code.getCodeAlias());
		}
		if(map.containsKey(defPath)){
			String value = map.get(defPath);
			//判断是否有参数
			if(value.indexOf("${") != -1 && value.indexOf("}") != -1){
				int s = value.indexOf("${");
				int e = value.indexOf("}");
				String v = value.substring(s+2, e).trim();
				if(!map.containsKey(v)){
					return value;
				}
				String param = "${"+v+"}";
				String va = map.get(v).trim();
				String rtv = StringTool.replaceBy(param, va, value);
				rtv = StringTool.replaceBy("//", "/", rtv);
				return rtv;
			}else{
				return value;
			}
		}
		
		map.clear();
		codes.clear();
		
		map = null;
		codes = null;
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#getCodeAlails(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public String getCodeAlails(String codeType, String code, BigDecimal comId) {
		// TODO Auto-generated method stub
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codeType);
		criteria.andCodeTypeEqualTo(code);
		criteria.andComIdEqualTo(comId);
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setDistinct(true);
		example.setOrderByClause("CODE");
		List<TDefCodeDict> codes = tDefCodeDictMapper.selectByExample(example);
		if(codes == null || codes.size() <= 0){
			return null;
		}
		return codes.get(0).getCodeAlias();
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#getCodeDict(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public TDefCodeDict getQueryCode(String codeType, String code,BigDecimal comId) {
		// TODO Auto-generated method stub
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codeType);
		criteria.andCodeEqualTo(code);
		criteria.andComIdEqualTo(comId);
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setDistinct(true);
		example.setOrderByClause("CODE");
		List<TDefCodeDict> codes = tDefCodeDictMapper.selectByExample(example);
		if(codes == null || codes.size() <= 0){
			return null;
		}
		return codes.get(0);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#updateQueryCode(com.sinosoft.platform.core.domain.model.TDefCodeDict)
	 */
	@Override
	public int updateQueryCode(TDefCodeDict codeDict) {
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codeDict.getCodeType().trim());
		criteria.andCodeEqualTo(codeDict.getCode().trim());
		criteria.andComIdEqualTo(codeDict.getComId());
		return tDefCodeDictMapper.updateByExample(codeDict, example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#insertQueryCode(com.sinosoft.platform.core.domain.model.TDefCodeDict)
	 */
	@Override
	public int insertQueryCode(TDefCodeDict codeDict) {
		deleteQueryCode(codeDict);
		return tDefCodeDictMapper.insert(codeDict);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#deleteQueryCode(com.sinosoft.platform.core.domain.model.TDefCodeDict)
	 */
	@Override
	public int deleteQueryCode(TDefCodeDict codeDict) {
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codeDict.getCodeType().trim());
		criteria.andCodeEqualTo(codeDict.getCode().trim());
		criteria.andComIdEqualTo(codeDict.getComId());
		return tDefCodeDictMapper.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#getStateRela(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public String getStatusRela(String codeType, String code, BigDecimal comId) {
		// TODO Auto-generated method stub
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codeType);
		criteria.andCodeEqualTo(code);
		if(comId != null){
			criteria.andComIdEqualTo(comId);
		}
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setDistinct(true);
		example.setOrderByClause("CODE");
		List<TDefCodeDict> codes = tDefCodeDictMapper.selectByExample(example);
		if(codes == null || codes.size() <= 0){
			return null;
		}
		return codes.get(0).getCodeStatusRela();
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#getGroupRela(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public String getGroupRela(String codeType, String code, BigDecimal comId) {
		// TODO Auto-generated method stub
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codeType);
		criteria.andCodeEqualTo(code);
		if(comId != null){
			criteria.andComIdEqualTo(comId);
		}
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setDistinct(true);
		example.setOrderByClause("CODE");
		List<TDefCodeDict> codes = tDefCodeDictMapper.selectByExample(example);
		if(codes == null || codes.size() <= 0){
			return null;
		}
		return codes.get(0).getCodeGroupRela();
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.platform.core.application.CodeQueryService#getQueryCode(java.lang.String, java.lang.String)
	 */
	@Override
	public TDefCodeDict getQueryCode(String codeType, String code) {
		// TODO Auto-generated method stub
		TDefCodeDictExample example = new TDefCodeDictExample();
		TDefCodeDictExample.Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codeType);
		criteria.andCodeEqualTo(code);
		//锁定有效数据
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		example.setDistinct(true);
		example.setOrderByClause("CODE");
		List<TDefCodeDict> codes = tDefCodeDictMapper.selectByExample(example);
		if(codes == null || codes.size() <= 0){
			return null;
		}
		return codes.get(0);
	}
	
}
