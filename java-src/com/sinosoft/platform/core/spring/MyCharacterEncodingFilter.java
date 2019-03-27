package com.sinosoft.platform.core.spring;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.CharacterEncodingFilter;

public class MyCharacterEncodingFilter extends CharacterEncodingFilter {
	private String excludePatterns;

	public void initFilterBean() throws ServletException {
		this.excludePatterns = getFilterConfig().getInitParameter(
				"excludePatterns");
	}

	public void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain) {

		String url = null;
		try {
			url = request.getRequestURL().toString();
			if (!matchExcludePatterns(url)) {
				super.doFilterInternal(request, response, filterChain);
			} else {
				filterChain.doFilter(request, response);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean matchExcludePatterns(String url) {
		if (url.endsWith(excludePatterns)) {
			return true;
		}
		return false;
	}
}
