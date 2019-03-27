package com.sinosoft.ummp.application;

/*****************************************************
 * HISTORY
 * 
 * 2016/07/04 lht 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功
 * 
 *****************************************************/

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.domain.model.TDefNoticeAccount;
import com.sinosoft.ummp.domain.model.TDefNoticeAdd;
import com.sinosoft.ummp.domain.model.TDefNoticeMain;

public interface EmailMonitorService {
	Map<String, Object> getPageList(DataGridModel dgm, DefUser defUser,
			TDefNoticeAccount tDefNoticeAccount);

	Map<String, Object> getPageList(DataGridModel dgm, String monitorCode,
			TDefNoticeMain tDefNoticeMain);

	Map<String, Object> getPageList(DataGridModel dgm, String monitorCode,
			TDefNoticeAdd tDefNoticeAdd);

	void saveEmail(TDefNoticeAccount tDefNoticeAccount, LoginInfo loginInfo) throws CoreException;

	void deleteEmailMonitor(BigDecimal id) throws CoreException ; ;

	void NoticeMain(Map<String, Object> map, LoginInfo loginInfo) throws CoreException;

	void NoticeAdd(Map<String, Object> map, LoginInfo loginInfo) throws CoreException;

	void saveEmail1(TDefNoticeAccount tDefNoticeAccount, LoginInfo loginInfo) throws CoreException;

	void deleteNoticeAdd(BigDecimal id);

	void deleteNoticeMain(BigDecimal id);

	void updateEmailMonitor(TDefNoticeAccount tDefNoticeAccount,
			LoginInfo loginInfo);
	List<TDefNoticeAccount> getAcctionF();
	
	void sendEmail(String monitorCode) throws CoreException;
}