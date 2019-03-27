package com.sinosoft.platform.core.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.CodeDictService;
import com.sinosoft.platform.core.domain.mapper.TDefCodeDictMapper;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefCodeDictExample;
import com.sinosoft.platform.core.domain.model.TDefCodeDictExample.Criteria;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * CodeDict 操作服务类
 * @author Darker.Wang
 * @date 2016-8-5 下午4:58:18
 * @company SINOSOFT
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CodeDictServiceImpl implements CodeDictService {
	private static final Logger log = Logger.getLogger(CodeDictServiceImpl.class);
	
	@Autowired
	TDefCodeDictMapper tdefCodedictMapper;
	
	@Override
	@Transactional
	public void saveCodedict(TDefCodeDict tdefcodedict, LoginInfo loginfo) throws CoreException {
			checkCodedict(tdefcodedict);
			checkCodedicetforAdd(tdefcodedict);
			this.tdefCodedictMapper.insert(tdefcodedict);
		} 

	@Override
	@Transactional
	public void updateCodedict(TDefCodeDict tDefCodeDict, LoginInfo loginInfo) throws CoreException {
			TDefCodeDictExample example = new TDefCodeDictExample();
			Criteria  criteria = example.createCriteria().andCodeEqualTo(tDefCodeDict.getCode()).andCodeTypeEqualTo(tDefCodeDict.getCodeType());
			if(tDefCodeDict.getComId() != null && !"".equals(tDefCodeDict.getComId())){
				criteria.andComIdEqualTo(tDefCodeDict.getComId());
			}else{
				criteria.andComIdIsNull();
			}
			this.tdefCodedictMapper.updateByExampleSelective(tDefCodeDict,example);
	}

	@Override
	@Transactional
	public void deleteCodedict(TDefCodeDict tDefCodeDict, LoginInfo loginInfo) {
		TDefCodeDictExample example = new TDefCodeDictExample();
		Criteria  criteria = example.createCriteria().andCodeEqualTo(tDefCodeDict.getCode()).andCodeTypeEqualTo(tDefCodeDict.getCodeType());
		if(tDefCodeDict.getComId() != null && !"".equals(tDefCodeDict.getComId())){
			criteria.andComIdEqualTo(tDefCodeDict.getComId());
		}else{
			criteria.andComIdIsNull();
		}
		tdefCodedictMapper.deleteByExample(example);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> getPageList(DataGridModel dgm,TDefCodeDict tdefcodedict) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("codetype", tdefcodedict.getCodeType());
		paramMap.put("code", tdefcodedict.getCode());
		paramMap.put("codename", tdefcodedict.getCodeName());
		paramMap.put("codealias", tdefcodedict.getCodeAlias());
		paramMap.put("comid", tdefcodedict.getComId());
		if(tdefcodedict.getEsStatus()!=null)
		paramMap.put("esstatus", tdefcodedict.getEsStatus().toString());
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total = tdefCodedictMapper.queryCodedictListInfoCounts(paramMap);
		List<Map> list = tdefCodedictMapper.queryCodedictListInfoPages(paramMap);
		result.put("total", total);
		result.put("rows",list);
		return result;
	}
	public void checkCodedict(TDefCodeDict tdefcodedict) throws CoreException
	{
		log.debug("code:"+tdefcodedict.getCode()+" codeTyep:"+tdefcodedict.getCodeType()+" codeName:"+tdefcodedict.getCodeName());
		if ("".equals(tdefcodedict.getCode()) || tdefcodedict.getCodeType() == null)
		{
			log.info("枚举类型为空");
			throw new CoreException("枚举类型不能为空");
		}
		if ("".equals(tdefcodedict.getCode()) || tdefcodedict.getCode() == null)
		{
			log.info("枚举编码为空");
			throw new CoreException("枚举编码不能为空");
		}
		if ("".equals(tdefcodedict.getCodeName()) || tdefcodedict.getCodeName() == null)
		{
			log.info("枚举名称为空");
			throw new CoreException("枚举名称不能为空");
		}
	}
	private void checkCodedicetforAdd(TDefCodeDict tDefCodeDict) throws CoreException
	{
		
		List<TDefCodeDict> codedictlist = null;
		TDefCodeDictExample example = new TDefCodeDictExample();
		Criteria  criteria = example.createCriteria().andCodeEqualTo(tDefCodeDict.getCode()).andCodeTypeEqualTo(tDefCodeDict.getCodeType());
		if(tDefCodeDict.getComId() != null && !"".equals(tDefCodeDict.getComId())){
			criteria.andComIdEqualTo(tDefCodeDict.getComId());
		}else{
			criteria.andComIdIsNull();
		}
		codedictlist = tdefCodedictMapper.selectByExample(example);
		if (codedictlist.size()!=0)
		{
			log.info("该平台此种枚举类型下此编码已经存在");
			throw new CoreException("该平台该枚举类型下此编码已经存在");
		}
	}

	@Override
	@Transactional
	public void saveCodedict(List<LinkedHashMap<String, Object>> list,
			LoginInfo loginfo) throws CoreException {
		List<TDefCodeDict> tdefCodedicts=new ArrayList<TDefCodeDict>();
		for(int i=0;i<list.size();i++){
			TDefCodeDict tdefCodedict=new TDefCodeDict();
			String tcodetype=list.get(i).get("codeType").toString();
			String tcode=list.get(i).get("code").toString();
			String tcodename=list.get(i).get("codeName").toString();
			String tcodealias=list.get(i).get("codeAlias").toString();
			String tcomid=list.get(i).get("comId").toString();
			String tesstatus=list.get(i).get("esStatus").toString();
				if(tcodetype!=null && !"".equals(tcodetype))
				{
					tdefCodedict.setCodeType(tcodetype);
				}
				if(tcode!=null && !"".equals(tcode))
				{
					tdefCodedict.setCode(tcode);
				}
				if(tcodename!=null && !"".equals(tcodename))
				{
					tdefCodedict.setCodeName(tcodename);
				}
				if(tcodealias!=null && !"".equals(tcodealias))
				{
					tdefCodedict.setCodeAlias(tcodealias);
				}
				if(tcomid!=null && !"".equals(tcomid))
				{
					BigDecimal comid= new BigDecimal(tcomid);
					tdefCodedict.setComId(comid);
				}
				if(tesstatus!=null && !"".equals(tesstatus))
				{
					tdefCodedict.setEsStatus((short)Integer.parseInt(tesstatus));
				}
				tdefCodedicts.add(tdefCodedict);
		}
		for(TDefCodeDict tdefcodedict:tdefCodedicts){
			this.saveCodedict(tdefcodedict, loginfo);
		}
		
	}

	@Override
	public TDefCodeDict selectbyKey(TDefCodeDict tDefCodeDict) {
		TDefCodeDictExample example = new TDefCodeDictExample();
		Criteria  criteria = example.createCriteria().andCodeEqualTo(tDefCodeDict.getCode()).andCodeTypeEqualTo(tDefCodeDict.getCodeType());
		if(tDefCodeDict.getComId() != null && !"".equals(tDefCodeDict.getComId())){
			criteria.andComIdEqualTo(tDefCodeDict.getComId());
		}else{
			criteria.andComIdIsNull();
		}
		List<TDefCodeDict> tDefCodeDicts = tdefCodedictMapper.selectByExample(example);
		if(tDefCodeDicts.size()>0){
			return tDefCodeDicts.get(0);
		}else{
			return null;
		}
	}
}
