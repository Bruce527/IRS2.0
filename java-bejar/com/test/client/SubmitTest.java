/**
 * 
 */
package com.test.client;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.exception.CISException;
import com.sinosoft.eos.exception.EOSException;
import com.sinosoft.ummp.application.SubmitService;

/**
 * @author Darker.Wang
 * @date 2016-7-4 下午7:25:33
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/infrastructure-persistence.xml" })
public class SubmitTest {

	@Autowired
	SubmitService submitService;

	@Test
	public void doSubmitTest() throws Exception {
		ParamPOJO pojo = new ParamPOJO();
		pojo.setStartDate("2016-07-05");
		pojo.setEndDate("2016-07-05");
		pojo.setBussType("InUpload");
		pojo.setBussFlag("0");
		BigDecimal comId = new BigDecimal(1);//北京意外险
		submitService.submit(comId, pojo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws HandlerException
	 */
	public static void main(String[] args) throws CISException, EOSException {

	}
}
