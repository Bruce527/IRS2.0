/**
 * 
 */
package com.sinosoft.ummp.application;

import javax.servlet.http.HttpServletResponse;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.ummp.domain.model.TDocUpdown;

/**
 * 文件输出流：供本地文件通过前台页面下载使用
 * @author Darker.Wang
 * @date 2016-7-27 上午11:56:48
 * @company SINOSOFT
 */
public interface DownloadFileService {
	public CErrors cErrors = new CErrors();
	/**
	 * 文件输出流：供本地文件通过前台页面下载使用
	 * @param response 响应请求
	 * @param tDocUpdown 实体类
	 * <p>
	 *  1,文件名必传,tDocUpdown.setDocName();<br>
	 *  2,文件path必传,tDocUpdown.setDocPath();
	 *  </p>
	 * @return
	 */
	public boolean downloadFile(HttpServletResponse response,TDocUpdown tDocUpdown);
}
