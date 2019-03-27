/**
 * 
 */
package com.sinosoft.ummp.application;

import java.io.File;
import java.util.List;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * 文件生成服务接口
 * @author Darker.Wang
 * @date 2016-7-26 下午12:01:31
 * @company SINOSOFT
 */
public interface CreateFileService {
	public CErrors cErrors = new CErrors(); 
	/**
	 * 创建文件接口
	 * @param loginInfo 用户基本信息
	 * <p>用户编码必传：loginInfo.setUserCode()</p>
	 * @param pojo 参数基本信息
	 * <p>
	 *  1、批次起始日期 必传：pojo.setStartDate();<br>
		2、批次结束日期 必传：pojo.setEndDate();<br>
		3、状态：pojo.setStateFlag();<br>
		4、平台机构 必传：pojo.setComId();
	 * </p>
	 * @return
	 * @throws CoreException 
	 * @throws Exception 
	 */
	public boolean submitData(LoginInfo loginInfo, ParamPOJO pojo) throws CoreException, Exception;
	/**
	 * 获取创建后的文件
	 * @return
	 */
	public List<File> getCreateFile();
}
