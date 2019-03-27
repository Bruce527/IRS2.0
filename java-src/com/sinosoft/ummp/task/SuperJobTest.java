package com.sinosoft.ummp.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.ummp.application.SubmitService;
import com.sinosoft.ummp.application.impl.SubmitServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:resource/spring/infrastructure-persistence.xml","classpath:resource/spring/context-datasource-jdbc.xml",})
public class SuperJobTest extends SuperJob{

	
	

	@Test
	public void aaa() throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		SubmitService service = (SubmitService) context.getBean(SubmitServiceImpl.class);

	}

	@Override
	public boolean excute() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
