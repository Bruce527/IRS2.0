package com.sinosoft.eos.handle;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sinosoft.eos.adapte.SubmitAdapter;
import com.sinosoft.eos.adapte.submit.HttpSubmitAdapter;
import com.sinosoft.eos.exception.EOSException;
import com.sinosoft.eos.model.RequestModel;
import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.util.CError;
/**
 * 报送处理器，报送到什么接口，什么数据格式，返回是什么
 * @author Darker.Wang
 * @date 2016-5-25 下午6:36:46
 *
 */
public class SubmitHandler implements Handler{

	private Logger logger = Logger.getLogger(SubmitHandler.class);
	private List<SubmitModel> sms = null;
	private List<SubmitReturn> returns = new ArrayList<SubmitReturn>();
	public SubmitHandler(List<SubmitModel> sms) {
		// TODO Auto-generated constructor stub
		this.sms = sms;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 遍历调度
	 * @param sms
	 * @return
	 * @throws EOSException
	 */
	private boolean handle(List<SubmitModel> sms) throws EOSException {
		returns.clear();
		for (SubmitModel sm : sms) {
			try {
				SubmitAdapter adapter = newInstance(sm.getSubmitType());
				System.out.println("-SubmitHandler 报送批次："+sm.getBussModel().getBatchNo());
				boolean result = adapter.submit(sm);
				if(!result){
					cErrors.copyAllErrors(adapter.cErrors);
					return false;
				}
				SubmitReturn sr = adapter.getSubmitReturn();
				//序列号（SN-System.currentTimeMillis）相同，返回对应
				sr.setSubmitSerialNo(sm.getSubmitSerialNo());
				sr.setBussModel(sm.getBussModel());//业务类型封装如返回信息
				returns.add(sr);
			} catch (Exception e) {
				e.printStackTrace();
				RequestModel reqModel = sm.getReqModel();
				CError cError = new CError();
				cError.errorMessage = "报送调度失败："+reqModel.getReqUrl();
				cError.errorType = "1";
				cError.functionName = "handle";
				cError.moduleName = "SubmitHandler";
				cErrors.addOneError(cError);
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.eos.handle.Handler#newInstance(com.sinosoft.eos.model.SubmitModel)
	 */
	public SubmitAdapter newInstance(String interType) throws EOSException {
		SubmitAdapter adapter = null;
		logger.debug("interType: " + interType);
		try {
			adapter = new HttpSubmitAdapter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			EOSException cise = new EOSException();
			cise.setException(e);
			cise.setMessage(e.getMessage());
			cise.setFunction("com.sinosoft.eos.adapte.submit.SubmitAaptor newInstance()");
			throw cise;
		} 
		return adapter;
	}
	
	/* (non-Javadoc)
	 * @see com.sinosoft.eos.handle.Handler#handle()
	 */
	@Override
	public boolean handle() throws EOSException {
		// TODO Auto-generated method stub
		try {
			return this.handle(sms);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EOSException();
		}
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.eos.handle.Handler#getResult()
	 */
	@Override
	public List<?> getResult() {
		// TODO Auto-generated method stub
		return returns;
	}
	
}
