package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.TDefManageComMapper;
import com.sinosoft.platform.core.domain.model.TDefCodeMapping;
import com.sinosoft.platform.core.domain.model.TDefCodeMappingExample;
import com.sinosoft.platform.core.domain.model.TDefManageCom;
import com.sinosoft.platform.core.domain.model.TDefManageComExample;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.ManageComService;
/*****************************************************
 * HISTORY
 * 
 * 2016/06/21 lht 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 * Description 管理机构控制器
 *****************************************************/
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ManageComServiceImpl implements ManageComService{
	private static final Logger log = Logger.getLogger(ManageComServiceImpl.class);
	Map<BigDecimal, TDefManageCom> fakeids = new HashMap<BigDecimal, TDefManageCom>();
	
	@Autowired
	TDefManageComMapper tDefManageComMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper;
	
	public List<TDefManageCom> loadManageCom()
	{
		TDefManageComExample examp = new TDefManageComExample();

		List<TDefManageCom> managecomList = tDefManageComMapper.selectByExample(examp);
		
		return managecomList;
	}
	/**
	 * 新增机构
	 * @throws CoreException 
	 */
	@Transactional
	public void saveManageCom(TDefManageCom tDefManageCom,LoginInfo loginInfo) throws CoreException{
		checkManageComForAdd(tDefManageCom);
		BigDecimal manageComSeq = commonServiceMapper.getSeqValByName("SEQ_T_DEF_MANAGE_COM");
		tDefManageCom.setId(manageComSeq);
		tDefManageCom.setInsertTime(new Date());
		this.tDefManageComMapper.insert(tDefManageCom);
	}
	private void checkManageComForAdd(TDefManageCom tDefManageCom) throws CoreException
	{
		ArrayList<TDefManageCom> manageComlist = null;
		manageComlist = this.tDefManageComMapper.queryComByComCode(tDefManageCom);
		if (manageComlist.size() > 0)
		{
			log.info("机构编码已经存在");
			throw new CoreException("该机构编码已经存在");
		}
	}
	/**
	 * 更新机构
	 */
	@Transactional
	public void updateManageCom(TDefManageCom tDefManageCom,LoginInfo loginInfo) {
		TDefManageCom oldmanageCom = this.tDefManageComMapper.selectByPrimaryKey(tDefManageCom.getId());
		tDefManageCom.setLastModifyTime(new Date());
		this.tDefManageComMapper.updateByPrimaryKey(tDefManageCom);
		
	}
	/**
	 * 删除机构
	 */
	@Transactional
	public void deleteManageCom(BigDecimal id) {
			TDefManageCom tDefManageCom = this.tDefManageComMapper.selectByPrimaryKey(id);
			this.tDefManageComMapper.deleteByPrimaryKey(tDefManageCom.getId());
		}
	/**
	 * 获取管理机构列表
	 */
	@Transactional
	public Map<String, Object> getPageList(DataGridModel dgm,
			TDefManageCom tDefManageCom) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("manageCode", tDefManageCom.getManageCode());
		paramMap.put("fid", tDefManageCom.getFid());
		paramMap.put("manageName", tDefManageCom.getManageName());
		paramMap.put("mmonitorCode", tDefManageCom.getMmonitorCode());
		paramMap.put("address", tDefManageCom.getAddress());
		paramMap.put("innerFid", tDefManageCom.getInnerFid());
		paramMap.put("licenseType", tDefManageCom.getLicenseType());
		paramMap.put("remark", tDefManageCom.getRemark());
		paramMap.put("lastModifyTime", tDefManageCom.getLastModifyTime());
		paramMap.put("insertTime", tDefManageCom.getInsertTime());
		paramMap.put("zipcode", tDefManageCom.getZipcode());
		paramMap.put("openDate", tDefManageCom.getOpenDate());
		paramMap.put("email", tDefManageCom.getEmail());
		paramMap.put("mmonitorType", tDefManageCom.getMmonitorType());
		paramMap.put("status", tDefManageCom.getStatus());
		paramMap.put("manageInnerCode", tDefManageCom.getManageInnerCode());
		paramMap.put("manageEnnameShort", tDefManageCom.getManageEnnameShort());
		paramMap.put("phone", tDefManageCom.getPhone());
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total = tDefManageComMapper.queryComListInfoCounts(paramMap);
		List<Map> list = tDefManageComMapper.queryComListInfoPages(paramMap);

		result.put("total", total);
		result.put("rows", list);
		return result;
	}

	@Transactional
	public TDefManageCom get(BigDecimal id) {
		return this.tDefManageComMapper.selectByPrimaryKey(id);
	}
	@Override
	public TDefManageCom selectById(BigDecimal id) {
		TDefManageComExample example = new TDefManageComExample();
		example.createCriteria().andIdEqualTo(id);
		List<TDefManageCom> tDefManageCom = this.tDefManageComMapper.selectByExample(example );
		return tDefManageCom.get(0);
	}
}
