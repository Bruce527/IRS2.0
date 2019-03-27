/**
 * 
 */
package com.sinosoft.ummp.application;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * 文件上载接口
 * @author Darker.Wang
 * @date 2016-7-27 上午11:56:48
 * @company SINOSOFT
 */
public interface UploadFileService {
	public CErrors cErrors = new CErrors();
	/**
	 * 文件上载：保单登记用户文件上载至服务器
	 * @param loginInfo 用户基本信息
	 * <p>用户编码必传，loginInfo.setUserCode()</p>
	 * @param pojo 参数基本信息
	 * <p>
	 *  1、批次号必传， pojo.setBatchNo();<br>
	 *	2、正式路径（工程UI路径）必传，pojo.setRealPath();<br>
	 *	3、批次类型必传，pojo.setBatchType();
	 * </p>
	 * @return
	 * @throws CoreException 
	 */
	public boolean uploadFile(LoginInfo loginInfo,ParamPOJO pojo) throws CoreException;
	/**
	 * 文件上载，符合上载条件的文件都需要上载
	 * @param loginInfo 用户基本信息
	 * <p>用户编码必传：loginInfo.setUserCode()</p>
	 * @return
	 * @throws CoreException
	 */
	public boolean uploadFile(LoginInfo loginInfo) throws CoreException;
}
