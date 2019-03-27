package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
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
import com.sinosoft.platform.core.domain.mapper.DefUserMapper;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefUserMapper;
import com.sinosoft.platform.core.domain.mapper.UserServiceMapper;
import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.domain.model.TDefUser;
import com.sinosoft.platform.core.domain.model.TDefUserExample;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.EmailMonitorService;
import com.sinosoft.ummp.application.EmailSinoService;
import com.sinosoft.ummp.domain.mapper.TDefMonitorMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeAccountMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeAddMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeMainMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeMapper;
import com.sinosoft.ummp.domain.model.TDefMonitor;
import com.sinosoft.ummp.domain.model.TDefMonitorExample;
import com.sinosoft.ummp.domain.model.TDefNotice;
import com.sinosoft.ummp.domain.model.TDefNoticeAccount;
import com.sinosoft.ummp.domain.model.TDefNoticeAccountExample;
import com.sinosoft.ummp.domain.model.TDefNoticeAdd;
import com.sinosoft.ummp.domain.model.TDefNoticeAddExample;
import com.sinosoft.ummp.domain.model.TDefNoticeExample;
import com.sinosoft.ummp.domain.model.TDefNoticeMain;
import com.sinosoft.ummp.domain.model.TDefNoticeMainExample;

/*****************************************************
 * HISTORY
 * 
 * 2016/07/04 lht 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功�?
 * 
 * Description 管理机构控制�?
 *****************************************************/
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmailMonitorServiceImpl implements EmailMonitorService {
	public static final Logger log = Logger.getLogger(EmailMonitorServiceImpl.class);
	Map<BigDecimal, DefUser> fakeids = new HashMap<BigDecimal, DefUser>();
	@Autowired
	UserServiceMapper userServiceMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper;
	@Autowired
	TDefNoticeAccountMapper tDefNoticeAccountMapper;
	@Autowired
	TDefNoticeAddMapper tDefNoticeAddMapper;
	@Autowired
	TDefNoticeMainMapper tDefNoticeMainMapper;
	@Autowired
	TDefNoticeMapper tDefNoticeMapper;
	@Autowired
	DefUserMapper defUserMapper;
	@Autowired
	TDefUserMapper TDefUserMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	TDefMonitorMapper tDefMonitorMapper;
	@Autowired
	EmailSinoService emailSinoService;
	/**
	 * 
	 * 获取邮箱数据
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Map<String, Object> getPageList(DataGridModel dgm, DefUser defUser,
			TDefNoticeAccount tDefNoticeAccount) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total = tDefNoticeAccountMapper.queryNoticeListInfoCounts(paramMap);
		List<Map> list = tDefNoticeAccountMapper
				.queryNoticeListInfoPages(paramMap);

		result.put("total", total);
		result.put("rows", list);
		return result;
	}

	/**
	 * 新增邮箱服务�?
	 * 
	 * @throws CoreException
	 */
	@Transactional
	public void saveEmail(TDefNoticeAccount tDefNoticeAccount,
			LoginInfo loginInfo) throws CoreException {
//		String accountAddr = tDefNoticeAccount.getAccountAddr();
		String operator = loginInfo.getUserCode();
		TDefNoticeAccountExample example = new TDefNoticeAccountExample();
		example.createCriteria().andNoticeTypeEqualTo("F");
		List<TDefNoticeAccount> selectByExample = tDefNoticeAccountMapper.selectByExample(example);
		//如果发件人箱不存在
		if(selectByExample.size() == 0){
			BigDecimal accountSeq = commonServiceMapper.getSeqValByName("SEQ_T_DEF_NOTICE_ACCOUNT");
			tDefNoticeAccount.setId(accountSeq);
			tDefNoticeAccount.setOperator(operator);
			tDefNoticeAccount.setNoticeType("F");
			tDefNoticeAccount.setInsertTime(new Date());
			tDefNoticeAccount.setLastModifyTime(new Date());
			tDefNoticeAccountMapper.insert(tDefNoticeAccount);
		}else{
			tDefNoticeAccount.setOperator(operator);
			tDefNoticeAccount.setNoticeType("F");
			tDefNoticeAccount.setInsertTime(new Date());
			tDefNoticeAccount.setLastModifyTime(new Date());
			tDefNoticeAccountMapper.updateByExampleSelective(tDefNoticeAccount, example);
		}
	}

	/**
	 * 获取抄�?邮箱数据
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Map<String, Object> getPageList(DataGridModel dgm,
			String monitorCode, TDefNoticeAdd tDefNoticeAdd) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		paramMap.put("monitorCode", monitorCode);
		int total = tDefNoticeAddMapper.queryAddListInfoCounts(paramMap);
		List<Map> list = tDefNoticeAddMapper.queryAddListInfoPages(paramMap);

		result.put("total", total);
		result.put("rows", list);
		return result;
	}

	/**
	 * 获取发�?邮箱数据
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getPageList(DataGridModel dgm,
			String monitorCode, TDefNoticeMain tDefNoticeMain) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		paramMap.put("monitorCode", monitorCode);
		int total = tDefNoticeMainMapper.queryMainListInfoCounts(paramMap);
		List<Map> list = tDefNoticeMainMapper.queryMainListInfoPages(paramMap);

		result.put("total", total);
		result.put("rows", list);
		return result;
	}

	/**
	 * 删除邮箱
	 * 
	 * @throws CoreException
	 */
	@Transactional
	public void deleteEmailMonitor(BigDecimal id) throws CoreException {
		DefUser tDefUser = defUserMapper.selectByPrimaryKey(id);
		if (tDefUser != null) {
			throw new CoreException("用户邮箱，不能删除！");
		}
		TDefNoticeAccount tDefNoticeAccount = this.tDefNoticeAccountMapper
				.selectByPrimaryKey(id);
		if (tDefNoticeAccount != null) {
			this.tDefNoticeAccountMapper.deleteByPrimaryKey(tDefNoticeAccount.getId());
			TDefNoticeMainExample mainexample = new TDefNoticeMainExample();
			mainexample.createCriteria().andNoticeToEqualTo(tDefNoticeAccount.getId().toString());
			TDefNoticeAddExample addexample = new TDefNoticeAddExample();
			addexample.createCriteria().andNoticeToEqualTo(tDefNoticeAccount.getId().toString());
			tDefNoticeMainMapper.deleteByExample(mainexample);
			tDefNoticeAddMapper.deleteByExample(addexample);
			return;
		}
	}

	/**
	 * 删除抄�?邮箱
	 */
	@Transactional
	public void deleteNoticeAdd(BigDecimal id) {
		TDefNoticeAdd tDefNoticeAdd = this.tDefNoticeAddMapper
				.selectByPrimaryKey(id);
		this.tDefNoticeAddMapper.deleteByPrimaryKey(tDefNoticeAdd.getId());
	}

	/**
	 * 删除抄�?邮箱
	 */
	@Transactional
	public void deleteNoticeMain(BigDecimal id) {
		TDefNoticeMain tDefNoticeMain = this.tDefNoticeMainMapper
				.selectByPrimaryKey(id);
		this.tDefNoticeMainMapper.deleteByPrimaryKey(tDefNoticeMain.getId());
	}

	/**
	 * 更新邮箱
	 */
	@Transactional
	public void updateEmailMonitor(TDefNoticeAccount tDefNoticeAccount,
			LoginInfo loginInfo) {
		BigDecimal primaryKey = tDefNoticeAccount.getId();
		TDefNoticeAccount oldNoticeAccount = this.tDefNoticeAccountMapper
				.selectByPrimaryKey(tDefNoticeAccount.getId());
		if (oldNoticeAccount != null) {
//			String oldAccountAddr = oldNoticeAccount.getAccountAddr();
			String noticeType = oldNoticeAccount.getNoticeType();
			String operator = oldNoticeAccount.getOperator();
			Date insertTime = oldNoticeAccount.getInsertTime();
			String webAddress = oldNoticeAccount.getWebAddress();
			String webPort = oldNoticeAccount.getWebPort();
			String accountPass = oldNoticeAccount.getAccountPass();
			String erStatus = oldNoticeAccount.getErStatus();
			tDefNoticeAccount.setLastModifyTime(new Date());
			tDefNoticeAccount.setNoticeType(noticeType);
			tDefNoticeAccount.setWebPort(webPort);
			tDefNoticeAccount.setWebAddress(webAddress);
			tDefNoticeAccount.setInsertTime(insertTime);
			tDefNoticeAccount.setOperator(operator);
			tDefNoticeAccount.setAccountPass(accountPass);
			tDefNoticeAccount.setErStatus(erStatus);
			this.tDefNoticeAccountMapper.updateByPrimaryKey(tDefNoticeAccount);
			return;
		}
		DefUser defUser = this.defUserMapper.selectByPrimaryKey(primaryKey);
		if (defUser != null) {
			defUser.setEmail(tDefNoticeAccount.getAccountAddr());
			defUser.setUsername(tDefNoticeAccount.getAccountUser());
			this.defUserMapper.updateByPrimaryKey(defUser);
		}
	}

	/**
	 * 添加发�?邮箱
	 * 
	 * @throws CoreException
	 */
	@Transactional
	public void NoticeMain(Map<String, Object> map, LoginInfo loginInfo)
			throws CoreException {
		// 获取请求参数
		String monitorCode = (String) map.get("monitorCode");
		// BigDecimal id = (BigDecimal) map.get("id");
		String id = (String) map.get("id");

		TDefNoticeExample example = new TDefNoticeExample();
		example.createCriteria().andNoticeCodeEqualTo(monitorCode);
		List<TDefNotice> selectByExample = this.tDefNoticeMapper
				.selectByExample(example);
		if (selectByExample.size() == 0) {
			BigDecimal noticeId = commonServiceMapper
					.getSeqValByName("SEQ_T_DEF_NOTICE");
			TDefNotice tDefNotice = new TDefNotice();
			tDefNotice.setNoticeId(noticeId);
			tDefNotice.setNoticeCode(monitorCode);
			tDefNotice.setNoticeName(monitorCode);
			tDefNotice.setNoticeType("email");
			this.tDefNoticeMapper.insert(tDefNotice);
			BigDecimal noticeMainId = commonServiceMapper
					.getSeqValByName("SEQ_T_DEF_NOTICE_MAIN");
			TDefNoticeMain tDefNoticeMain = new TDefNoticeMain();
			tDefNoticeMain.setNoticeId(noticeId);
			tDefNoticeMain.setId(noticeMainId);
			tDefNoticeMain.setNoticeTo(id);
			this.tDefNoticeMainMapper.insert(tDefNoticeMain);
			return;
		} else {
			BigDecimal noticeId = selectByExample.get(0).getNoticeId();
			TDefNoticeMainExample mainexample = new TDefNoticeMainExample();
			mainexample.createCriteria().andNoticeToEqualTo(id)
					.andNoticeIdEqualTo(noticeId);
			List<TDefNoticeMain> selectByExample2 = this.tDefNoticeMainMapper
					.selectByExample(mainexample);
			if (selectByExample2.size() == 0) {
				TDefNoticeMain tDefNoticeMain = new TDefNoticeMain();
				BigDecimal noticeMainId = commonServiceMapper
						.getSeqValByName("SEQ_T_DEF_NOTICE_MAIN");
				tDefNoticeMain.setId(noticeMainId);
				tDefNoticeMain.setNoticeId(noticeId);
				tDefNoticeMain.setNoticeTo(id);
				this.tDefNoticeMainMapper.insert(tDefNoticeMain);
				return;
			} else {
				throw new CoreException("该邮箱已存在");
			}
		}
	}

	/**
	 * 添加抄�?邮箱
	 * 
	 * @throws CoreException
	 */
	@Transactional
	public void NoticeAdd(Map<String, Object> map, LoginInfo loginInfo)
			throws CoreException {
		// 获取请求参数
		String monitorCode = (String) map.get("monitorCode");
		String id = (String) map.get("id");

		TDefNoticeExample example = new TDefNoticeExample();
		example.createCriteria().andNoticeCodeEqualTo(monitorCode);
		List<TDefNotice> selectByExample = this.tDefNoticeMapper
				.selectByExample(example);
		if (selectByExample.size() == 0) {
			BigDecimal noticeId = commonServiceMapper
					.getSeqValByName("SEQ_T_DEF_NOTICE");
			TDefNotice tDefNotice = new TDefNotice();
			tDefNotice.setNoticeId(noticeId);
			tDefNotice.setNoticeCode(monitorCode);
			tDefNotice.setNoticeName(monitorCode);
			tDefNotice.setNoticeType("email");
			this.tDefNoticeMapper.insert(tDefNotice);
			BigDecimal noticeAddId = commonServiceMapper
					.getSeqValByName("SEQ_T_DEF_NOTICE_ADD");
			TDefNoticeAdd tDefNoticeAdd = new TDefNoticeAdd();
			tDefNoticeAdd.setNoticeId(noticeId);
			tDefNoticeAdd.setId(noticeAddId);
			tDefNoticeAdd.setNoticeTo(id);
			this.tDefNoticeAddMapper.insert(tDefNoticeAdd);
			return;
		} else {
			BigDecimal noticeId = selectByExample.get(0).getNoticeId();
			TDefNoticeAddExample addexample = new TDefNoticeAddExample();
			addexample.createCriteria().andNoticeToEqualTo(id)
					.andNoticeIdEqualTo(noticeId);
			List<TDefNoticeAdd> selectByExample2 = this.tDefNoticeAddMapper
					.selectByExample(addexample);
			if (selectByExample2.size() == 0) {
				TDefNoticeAdd tDefNoticeAdd = new TDefNoticeAdd();
				BigDecimal noticeAddId = commonServiceMapper
						.getSeqValByName("SEQ_T_DEF_NOTICE_ADD");
				tDefNoticeAdd.setId(noticeAddId);
				tDefNoticeAdd.setNoticeId(noticeId);
				tDefNoticeAdd.setNoticeTo(id);
				this.tDefNoticeAddMapper.insert(tDefNoticeAdd);
				return;
			} else {
				throw new CoreException("该邮箱已存在");
			}
		}
	}

	@Transactional
	public void saveEmail1(TDefNoticeAccount tDefNoticeAccount,
			LoginInfo loginInfo) throws CoreException {
		String accountAddr = tDefNoticeAccount.getAccountAddr();
		String operator = loginInfo.getUserCode();
		TDefNoticeAccountExample example = new TDefNoticeAccountExample();
		example.createCriteria().andAccountAddrEqualTo(accountAddr);
		List<TDefNoticeAccount> selectByExample = tDefNoticeAccountMapper
				.selectByExample(example);
		TDefUserExample tdefUserExample = new TDefUserExample();
		tdefUserExample.createCriteria().andEmailEqualTo(accountAddr);
		List<TDefUser> selectByExample2 = TDefUserMapper
				.selectByExample(tdefUserExample);
		if (selectByExample.size() == 0 && selectByExample2.size() == 0) {
			BigDecimal accountSeq = commonServiceMapper
					.getSeqValByName("SEQ_T_DEF_NOTICE_ACCOUNT");
			tDefNoticeAccount.setId(accountSeq);
			tDefNoticeAccount.setOperator(operator);
			tDefNoticeAccount.setNoticeType("I");
			tDefNoticeAccount.setInsertTime(new Date());
			// tDefNoticeAccount.setLastModifyTime(new Date());
			tDefNoticeAccountMapper.insert(tDefNoticeAccount);
		} else {
			throw new CoreException("邮箱已存在");
		}

	}

	@Override
	public List<TDefNoticeAccount> getAcctionF() {
		TDefNoticeAccountExample example = new TDefNoticeAccountExample();
		example.createCriteria().andNoticeTypeEqualTo("F");
		return tDefNoticeAccountMapper.selectByExample(example);
	}

	@Override
	public void sendEmail(String monitorCode) throws CoreException {
		TDefMonitorExample example = new TDefMonitorExample();
		example.createCriteria().andMonitorCodeEqualTo(monitorCode);
		List<TDefMonitor> list = tDefMonitorMapper.selectByExample(example);
			TDefMonitor tDefMonitor = list.get(0);
			emailSinoService.sendEmail(tDefMonitor);
		
	}
}
