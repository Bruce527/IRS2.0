/**
 * 
 */
package com.sinosoft.eos.handle;

import java.util.List;

import com.sinosoft.eos.exception.EOSException;
import com.sinosoft.platform.core.util.CErrors;

/**
 * @author Darker.Wang
 * @date 2016-7-5 上午10:00:27
 * 提数报送控制器，控制走提数还是报送
 */
public interface Handler {

	public CErrors cErrors = new CErrors();
	public boolean handle() throws EOSException;
	/**
	 * 获取提交结果，注意构造成正确的类型
	 * @return 
	 */
	public List<?> getResult();
}
