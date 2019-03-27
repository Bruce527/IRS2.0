/**
 * 
 */
package com.test.client;

import com.sinosoft.eos.handle.ExtractHandler;
import com.sinosoft.eos.handle.Handler;
import com.sinosoft.eos.exception.EOSException;


/**
 * @author Darker.Wang
 * @date 2016-5-18 下午3:36:38
 * 
 */
public class ExtractTest {

	/**
	 * 
	 */
	public ExtractTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws HandlerException 
	 */
	public static void main(String[] args) throws EOSException {
		// TODO Auto-generated method stub
		Handler ehandler = new ExtractHandler();
		ehandler.handle();
	}

}
