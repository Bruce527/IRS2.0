/**
 * 
 */
package com.sinosoft.ummp.application;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * 准备下载文件接口：现在前从服务器同步到本地
 * @author Darker.Wang
 * @date 2016-7-27 上午11:56:48
 * @company SINOSOFT
 */

public interface ReadyDownloadService {
	public CErrors cErrors = new CErrors();
	/***
	 * 
	 * @param loginInfo
	 * @param pojo
	 * @return
	 */
	public boolean readyForDownload(LoginInfo loginInfo,ParamPOJO pojo);
}
