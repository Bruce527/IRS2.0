package com.sinosoft.platform.core.spring.cxf;

import javax.jws.WebService;

@WebService
public interface CXFWebserviceServer {
	public String hello(String name);
}
