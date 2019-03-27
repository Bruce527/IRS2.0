package com.sinosoft.platform.core.spring.cxf;

import javax.jws.WebService;

@WebService(endpointInterface = "com.sinosoft.platform.core.spring.cxf.CXFWebserviceServer")
public class CXFWebserviceServerImpl {

	public String hello(String name) {
		System.out.println("hello " + name + "!");
		return "hello " + name + "!";
	}

}
