/**
 * 
 */
package com.sinosoft.ummp.application;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * 查询文件接口：将服务器文件同步到本地
 * @author Darker.Wang
 * @date 2016-7-27 上午11:56:48
 * @company SINOSOFT
 */

public interface QueryFileService {
	public CErrors cErrors = new CErrors();
	/**
	 * 查询文件：将服务器文件同步到本地
	 * @param loginInfo 用户基本信息
	 * <p>用户编码必传，loginInfo.setUserCode()</p>
	 * @param pojo 参数基本信息
	 * <p>
	 * 1,起始日期必传，pojo.setStartDate();<br>
	 * 2,截止日期必传，pojo.setEndDate();<br>
	 * 3,文件类型必传，pojo.setFileType();<br>
	 * </p>
	 * @return
	 */
	public boolean fileDownload(LoginInfo loginInfo,ParamPOJO pojo);
}
