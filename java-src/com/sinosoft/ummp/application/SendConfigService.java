/**
 * 
 */
package com.sinosoft.ummp.application;

import com.sinosoft.ummp.domain.model.TDefSend;
import com.sinosoft.ummp.domain.pojo.SFTPConfigPOJO;

/**
 * @author Darker.Wang
 * @date 2016-6-30 下午1:42:10
 * 报送配置服务接口
 */
public interface SendConfigService {
	/**
	 * 查询报送信息
	 * @param comId
	 * @return
	 */
	public TDefSend selectByComId(Integer comId);
	/**
	 * 保存报送信息
	 * @param tDefSend
	 * @return
	 */
	public TDefSend saveTDefSend(TDefSend tDefSend);
	/**
	 * 保存SFTP信息
	 * @param pojo
	 * @return
	 */
	public boolean saveSFTPInfo(SFTPConfigPOJO pojo);
	/**
	 * 查询SFTP信息
	 * @param pojo
	 * @return
	 */
	public SFTPConfigPOJO querySFTPInfo(SFTPConfigPOJO pojo);
}
