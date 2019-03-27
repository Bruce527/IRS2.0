package com.sinosoft.eos.handle;

import java.util.List;

import com.sinosoft.eos.adapte.ExtractAdapter;
import com.sinosoft.eos.exception.EOSException;
import com.sinosoft.eos.model.ExtractModel;

public class ExtractHandler implements Handler{

	public ExtractHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/* (non-Javadoc)
	 * @see com.sinosoft.eos.handle.Handler#handle(java.util.List)
	 */
	public void handle(List<ExtractModel> ems) throws EOSException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.eos.handle.Handler#newInstance(com.sinosoft.eos.model.SubmitModel)
	 */
	public ExtractAdapter newInstance(String interType) throws EOSException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.eos.handle.Handler#handle()
	 */
	@Override
	public boolean handle() throws EOSException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.eos.handle.Handler#getSubmitResult()
	 */
	@Override
	public List<Object> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
