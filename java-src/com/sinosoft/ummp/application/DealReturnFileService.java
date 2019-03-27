package com.sinosoft.ummp.application;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.CErrors;

/**
 * 数据处理接口
 * @author sendylou
 * @date 2016/9/5
 * @company sinosoft
 * 
 */
public interface DealReturnFileService {
	public CErrors cErrors = new CErrors();
	/**
	 * 数据处理接口
	 * @param pojo 参数基本信息
	 * <p>
	 *  1、传入处理文件名.zip,由实现类属性fileName接收;<br>
	 *  2、传入处理userCode;<br>
	 * </p>
	 * @return
	 * @throws CoreException 
	 * @throws Exception 
	 */
	public boolean submitData(ParamPOJO Pojo);
}
