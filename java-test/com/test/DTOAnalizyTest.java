/**
 * 
 */
package com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.platform.core.util.JsonUtil;
import com.sinosoft.platform.core.util.NodeTree;
import com.sinosoft.ummp.application.DTOAnalizyService;

/**
 * @author Darker.Wang
 * @date 2016-7-29 上午9:36:08
 * @company SINOSOFT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/infrastructure-persistence.xml" })
public class DTOAnalizyTest {

	@Autowired
	DTOAnalizyService dTOAnalizyService;
	/**
	 * 
	 */
	@Test
	public void DTOAnalizyServiceTest() {
		// TODO Auto-generated constructor stub
		String bussType = "AccPolicyInfo";
		try {
			List<NodeTree> nodeTress = dTOAnalizyService.dtoAnalizy(bussType);
			System.out.println(JsonUtil.conver2Json(nodeTress));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
