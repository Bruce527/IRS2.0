package com.sinosoft.platform.core.spring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinosoft.platform.core.util.Constants;
public class SessionFilter extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getRequestURI().toString();
		String contextPath = req.getContextPath();
		if (url != null) {
			if (url.indexOf(".") == -1
					&& url.indexOf("query/codeQuery") == -1
					&& url.indexOf("query/codeQueryUrl") == -1
					&& url.indexOf("query/codeQueryByType") == -1
					&& url.indexOf("query/listManageNameUrl") == -1
					&& url.indexOf("user/addUserAgainUrl") == -1
					&& url.indexOf("welcome") == -1
					&& !url.equals(contextPath + "/")
					&& !url.equals(contextPath + "")) {
				HttpSession session = req.getSession();
				if (session.getAttribute(Constants.USER_INFO_SESSION) == null) {
					//System.out.println("- "+url+" >> /welcome/sessionReloadUrl");
					res.sendRedirect(contextPath + "/welcome/sessionReloadUrl");
					return;
				}
			}
			if (url.indexOf(".") == -1 && !url.contains("indexicp.jsp")
					&& (url.equals(contextPath + "") || url.equals(contextPath+"/"))) {
				//System.out.println("- "+url+" >> "+contextPath + "/index.jsp");
				res.sendRedirect(contextPath + "/index.jsp");
				return;
			}
			if (url.indexOf(".") == -1 && url.contains("SSICUrl")) {
				//System.out.println("- SSICUrl >> "+url+" >> "+contextPath + "/index.jsp");
				res.sendRedirect(contextPath + "/index.jsp");
				return;
			}
			if(url.indexOf("welcome/insertTrace") != -1){
				//TODO 做insertTrace的过滤
			}
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
