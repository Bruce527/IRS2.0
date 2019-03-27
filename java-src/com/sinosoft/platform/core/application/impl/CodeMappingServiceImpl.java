package com.sinosoft.platform.core.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.CodeMappingService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.TDefCodeMappingMapper;
import com.sinosoft.platform.core.domain.model.TDefCodeMapping;
import com.sinosoft.platform.core.domain.model.TDefCodeMappingExample;
import com.sinosoft.platform.core.domain.model.TDefCodeMappingExample.Criteria;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.interfaces.user.UserController;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
/**
 * LDCodeMappingService 实现类
 * @author Darker.Wang
 * @date 2016-10-12 上午11:52:07
 * @company SINOSOFT
 */
@Service(value = "codeMappingService")
public class CodeMappingServiceImpl implements CodeMappingService {

	private static final Logger log = Logger.getLogger(UserController.class);
	@Autowired
	TDefCodeMappingMapper tDefCodeMappingMapper;
	@Autowired
	SequenceService sequenceService;
	
	public CodeMappingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TDefCodeMapping> queryCodeMapping(List<Integer> ids) {
		// TODO Auto-generated method stub
		List<BigDecimal> bds = new ArrayList<BigDecimal>();
		for(Integer id : ids){
			BigDecimal bd = new BigDecimal(id);
			bds.add(bd);
		}
		TDefCodeMappingExample example = new TDefCodeMappingExample();
		example.setDistinct(true);
		example.setOrderByClause("id");
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(bds);
		return tDefCodeMappingMapper.selectByExample(example);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryCodeMapping(DataGridModel model,TDefCodeMapping tDefCodeMapping) {
		// TODO Auto-generated method stub
		Map result = new HashMap();
		Map param = new HashMap();
		String codeType = null;
		BigDecimal comId = null;
		if(tDefCodeMapping != null){
			codeType = tDefCodeMapping.getCodeType();
			comId =  tDefCodeMapping.getComId();
		}
		param.put("queryStartIndex", model.getStartIndex());
		param.put("queryEndIndex", model.getEndIndex());
		param.put("codeType",codeType);
		param.put("comId",comId);
		//计算总数
		int total = tDefCodeMappingMapper.countByRecord(tDefCodeMapping);
		List list = tDefCodeMappingMapper.selectByPage(param);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}

	@Override
	@Transactional
	public int addCodeMapping(List<TDefCodeMapping> mappings) {
		// TODO Auto-generated method stub
		int i = 0;
		for(TDefCodeMapping mapping : mappings){
			i += tDefCodeMappingMapper.insertSelective(mapping);
		}
		return i;
	}

	@Override
	@Transactional
	public int deleteMapping(List<BigDecimal> ids) {
		int i = 0;
		for(BigDecimal id :ids){
			TDefCodeMappingExample example= new TDefCodeMappingExample();
			example.createCriteria().andIdEqualTo(id);
			int t = this.tDefCodeMappingMapper.deleteByExample(example);
			if(t>0){
				i++;
			}
		}
		return i;
	}

	@Override
	public int countByExample(String codetype) {
		// TODO Auto-generated method stub
		TDefCodeMappingExample example = new TDefCodeMappingExample();
		example.createCriteria().andCodeTypeEqualTo(codetype);
		return tDefCodeMappingMapper.countByExample(example);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryCodeType() {
		return tDefCodeMappingMapper.selectCodeType();
	}

	@Override
	public List<TDefCodeMapping> queryCodeByType(String codetype) {
		TDefCodeMappingExample example = new TDefCodeMappingExample();
		example.setDistinct(true);
		example.setOrderByClause("codetype");
		Criteria criteria = example.createCriteria();
		criteria.andCodeTypeEqualTo(codetype);
		return tDefCodeMappingMapper.selectByExample(example);
	}

	@Override
	@Transactional
	public void saveCodeMapping(TDefCodeMapping tDefCodeMapping,LoginInfo loginInfo) throws CoreException {
		TDefCodeMappingExample example = new TDefCodeMappingExample();
		example.createCriteria().andBasicCodeEqualTo(tDefCodeMapping.getBasicCode()).andCodeTypeEqualTo(tDefCodeMapping.getCodeType());
		List<TDefCodeMapping> tDefCodeMappings = this.tDefCodeMappingMapper.selectByExample(example );
		if(tDefCodeMappings.size()>0){
			throw new CoreException("原编码和类型编码重复!");
		}
		BigDecimal id = sequenceService.getBigSeqValByName("SEQ_T_DEF_CODE_MAPPING");
		tDefCodeMapping.setId(id );
//		tDefCodeMapping.setComId(loginInfo.getCompanyId());
		this.tDefCodeMappingMapper.insert(tDefCodeMapping);
	}

	@Override
	public TDefCodeMapping selectById(BigDecimal id) {
		TDefCodeMappingExample example = new TDefCodeMappingExample();
		example.createCriteria().andIdEqualTo(id);
		List<TDefCodeMapping> tDefCodeMappings = this.tDefCodeMappingMapper.selectByExample(example );
		return tDefCodeMappings.get(0);
	}

	@Override
	@Transactional
	public void updateSave(TDefCodeMapping tDefCodeMapping, LoginInfo loginInfo) throws CoreException {
		TDefCodeMappingExample example = new TDefCodeMappingExample();
		example.createCriteria().andBasicCodeEqualTo(tDefCodeMapping.getBasicCode())
		.andCodeTypeEqualTo(tDefCodeMapping.getCodeType()).andIdNotEqualTo(tDefCodeMapping.getId());
		List<TDefCodeMapping> tDefCodeMappings = this.tDefCodeMappingMapper.selectByExample(example );
		if(tDefCodeMappings.size()>0){
			throw new CoreException("原编码和类型编码重复!");
		}
		int i = this.tDefCodeMappingMapper.updateByPrimaryKeySelective(tDefCodeMapping);
		log.info(i);
	}
}
