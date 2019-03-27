package com.sinosoft.eos.adapte;

import com.sinosoft.eos.exception.EOSException;
import com.sinosoft.eos.model.ExtractModel;

/**
 * 提数分发调度器
 * @author Darker.Wang
 * @date 2016-5-18 下午3:15:58
 *
 */
public abstract class ExtractAdapter {

	private Object rtv;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public abstract boolean extract(ExtractModel ems) throws EOSException;
	/* (non-Javadoc)
	 * @see com.sinosoft.eos.adapte.Adaptor#getResult()
	 */
	public Object getResult() {
		// TODO Auto-generated method stub
		return rtv;
	}
}
