package com.sinosoft.platform.core.interfaces.cache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/cache")
public class CacheController {

	Logger logger = Logger.getLogger(CacheController.class);
	
	@RequestMapping(value = "/reload", method = RequestMethod.POST)
	public void reload(HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		//TODO CACHE
		logger.info("清除缓存...");
	}
}
