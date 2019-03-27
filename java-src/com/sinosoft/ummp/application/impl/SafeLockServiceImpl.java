/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.mapper.TDefCodeDictMapper;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.ummp.application.SafeLockService;
import com.sinosoft.ummp.domain.pojo.SafeLockPOJO;

/**
 * 安全锁控服务实现类
 * @author Darker.Wang
 * @date 2016-11-2 下午5:48:17
 * @company SINOSOFT
 */
@Service("safeLockService")
public class SafeLockServiceImpl implements SafeLockService {

	@Autowired
	CodeQueryService codeQueryService;
	@Autowired
	TDefCodeDictMapper tDefCodeDictMapper;
	/**
	 * 
	 */
	public SafeLockServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SafeLockService#extractLock(com.sinosoft.ummp.domain.pojo.SafeLockPOJO)
	 */
	@Override
	public Map<String, String> extractLock(SafeLockPOJO pojo) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		map.put("msg", "锁定成功");
		TDefCodeDict codeDict = codeQueryService.getQueryCode("SYS_VAR", "EXTRACT_FLAG",pojo.getComId());
		if(codeDict == null){
			map.put("msg", "无待锁定对象");
			return map;
		}
		if(codeDict.getCodeAlias() != null && "1".equals(codeDict.getCodeAlias())){
			map.put("msg", "已是锁定状态");
			return map;
		}else{
			codeDict.setCodeAlias("1");
			codeQueryService.updateQueryCode(codeDict);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SafeLockService#extractUnLock(com.sinosoft.ummp.domain.pojo.SafeLockPOJO)
	 */
	@Override
	public Map<String, String> extractUnLock(SafeLockPOJO pojo) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		map.put("msg", "解锁成功");
		TDefCodeDict codeDict = codeQueryService.getQueryCode("SYS_VAR", "EXTRACT_FLAG",pojo.getComId());
		if(codeDict == null){
			map.put("msg", "无待解锁对象");
			return map;
		}
		if(codeDict.getCodeAlias() != null && "0".equals(codeDict.getCodeAlias())){
			map.put("msg", "未曾锁定，无需解锁");
			return map;
		}else{
			codeDict.setCodeAlias("0");
			codeQueryService.updateQueryCode(codeDict);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SafeLockService#submitLock(com.sinosoft.ummp.domain.pojo.SafeLockPOJO)
	 */
	@Override
	public Map<String, String> submitLock(SafeLockPOJO pojo) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		map.put("msg", "锁定成功");
		TDefCodeDict codeDict = codeQueryService.getQueryCode("SYS_VAR", "SUBMIT_FLAG",pojo.getComId());
		if(codeDict == null){
			map.put("msg", "无待锁定对象");
			return map;
		}
		if(codeDict.getCodeAlias() != null && "1".equals(codeDict.getCodeAlias())){
			map.put("msg", "已是锁定状态");
			return map;
		}else{
			codeDict.setCodeAlias("1");
			codeQueryService.updateQueryCode(codeDict);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SafeLockService#submitUnLock(com.sinosoft.ummp.domain.pojo.SafeLockPOJO)
	 */
	@Override
	public Map<String, String> submitUnLock(SafeLockPOJO pojo) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		map.put("msg", "解锁成功");
		TDefCodeDict codeDict = codeQueryService.getQueryCode("SYS_VAR", "SUBMIT_FLAG",pojo.getComId());
		if(codeDict == null){
			map.put("msg", "无待解锁对象");
			return map;
		}
		if(codeDict.getCodeAlias() != null && "0".equals(codeDict.getCodeAlias())){
			map.put("msg", "未曾锁定，无需解锁");
			return map;
		}else{
			codeDict.setCodeAlias("0");
			codeQueryService.updateQueryCode(codeDict);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SafeLockService#loginTypeLock(com.sinosoft.ummp.domain.pojo.SafeLockPOJO)
	 */
	@Override
	public Map<String, String> loginTypeLock(SafeLockPOJO pojo) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		TDefCodeDict codeDict = codeQueryService.getQueryCode("EMPOWER_TYPE",pojo.getLoginType());
		map.put("msg", "锁定成功");
		if(codeDict == null){
			map.put("msg", "无待锁定对象");
			return map;
		}
		if(codeDict != null){
			if(codeDict.getEsStatus() != null && "1".equals(codeDict.getEsStatus())){
				map.put("msg", "已是锁定状态");
				return map;
			}else{
				codeDict.setEsStatus(Short.parseShort("1"));
				codeQueryService.updateQueryCode(codeDict);
			}
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SafeLockService#loginTypeUnLock(com.sinosoft.ummp.domain.pojo.SafeLockPOJO)
	 */
	@Override
	public Map<String, String> loginTypeUnLock(SafeLockPOJO pojo) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		map.put("msg", "解锁成功");
		TDefCodeDict codeDict = codeQueryService.getQueryCode("EMPOWER_TYPE",pojo.getLoginType());
		if(codeDict == null){
			map.put("msg", "无待解锁对象");
			return map;
		}
		if(codeDict.getEsStatus() != null && "0".equals(codeDict.getEsStatus())){
			map.put("msg", "未曾锁定，无需解锁");
			return map;
		}else{
			codeDict.setEsStatus(Short.parseShort("0"));
			codeQueryService.updateQueryCode(codeDict);
		}
		return map;
	}

}
