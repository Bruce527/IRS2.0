package com.test;

import org.junit.runner.RunWith;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.platform.core.util.LoginInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring/context-datasource-jdbc.xml","classpath*:spring/infrastructure-persistence.xml"})
@Repository
public class BaseTest {
	public LoginInfo loginfo = new LoginInfo();
	
	public BaseTest() {
		loginfo.setUserCode("SYS-AUTO");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Md5PasswordEncoder md5=new Md5PasswordEncoder();
		System.out.println(md5.encodePassword("User123$", null));
	}

}
