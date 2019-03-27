/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.ummp.application.CodeConfigService;
import com.sinosoft.ummp.domain.mapper.TDefTransCodeMapper;
import com.sinosoft.ummp.domain.model.TDefTransCode;


@Service
public class CodeConfigServiceImpl implements CodeConfigService {
	@Autowired
	TDefTransCodeMapper tDefTransCodeMapper; 
	@Override
	public Map<String, Object> getPageList(DataGridModel dgm,TDefTransCode transCode) {
		Map<String,Object> result=new HashMap<String,Object>();
		Map paramMap=new HashMap();
		paramMap.put("targetTableName", transCode.getTargetTableName());
		paramMap.put("targetColName", transCode.getTargetColName());
		paramMap.put("dataType", transCode.getDataType());
		paramMap.put("codeType", transCode.getCodeType());
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		
		int total=tDefTransCodeMapper.selectCount(paramMap);
		List<TDefTransCode> list = tDefTransCodeMapper.selectTransListInfo(paramMap);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	@Override
	public void deleteByPremaryKey(BigDecimal id) {
		this.tDefTransCodeMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public List<TDefTransCode> queryCodeType() {
		return tDefTransCodeMapper.selectTransCodeInfo();
	}
	
}
