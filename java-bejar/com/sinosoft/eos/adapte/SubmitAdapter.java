package com.sinosoft.eos.adapte;

import com.sinosoft.eos.exception.EOSException;
import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.ummp.exception.CISException;

/**
 * 报送分适配器
 * @author Darker.Wang
 * @date 2016-9-12 下午3:58:10
 * @company SINOSOFT
 */
public abstract class SubmitAdapter {
	/**默认字符集：UTF-8**/
	protected String encoding = "UTF-8";
	protected Object rtv = null;
	protected String reqUrl = null;
	public CErrors cErrors = new CErrors();
	protected SubmitReturn sr = new SubmitReturn();
	public SubmitAdapter() {
	}
	/**
	 * 获取字符集
	 * @return
	 */
	public String getEncoding() {
		return encoding;
	}
	/**
	 * 设置字符集
	 * @param encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * 报送数据提交
	 * @param model
	 * @return
	 * @throws CISException
	 */
	public abstract boolean submit(SubmitModel model) throws EOSException;

	/**
	 * 获取返回值
	 * @return
	 */
	public Object getReturn() {
		return rtv;
	}
	public SubmitReturn getSubmitReturn(){
		return sr;
	}
}
