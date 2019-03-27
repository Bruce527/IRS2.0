<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Map"%>
<%@page import="com.icbc.ssic.base.Credentials"%>
<%@page import="com.icbc.ssic.base.SSICService"%>
<%@page import="com.icbc.ssic.base.SSICUser"%>
<%@page import="config.Config"%>
<%@page session="false" %>
<%
	HttpSession session=request.getSession(false);
	if(session==null){
		session=request.getSession();
	}
	String flag=request.getParameter("retcode");
	if(flag == null){
		session.setAttribute("email", request.getParameter("email"));
		session.setAttribute("password",request.getParameter("password"));
		session.setAttribute("creatorCode", request.getParameter("creatorCode"));
		session.setAttribute("userDescribe",request.getParameter("userDescribe"));
		
		System.out.println("request:"+request.getParameter("email")+"\n"+request.getParameter("password"));
		System.out.println("request:"+session.getId());
		
		String tellerno=request.getParameter("usercode");
		System.out.println("返回状态码：------------>"+flag);
		String creator = request.getParameter("creatorCode");
		String clientSiteno=Config.getProperties().getProperty("SITE_SERVERSERVICE");
		String s=Config.getProperties().getProperty("SITE_SERVERURL");
		String tellerUrl=s.substring(0, s.lastIndexOf("/")+1)+"ssicrequest.jsp";
		tellerUrl=URLEncoder.encode(tellerUrl);
		System.out.println("tellerno="+tellerno+"\ncreator="+creator+"\nclientSiteno="+clientSiteno+"\ntellerUrl="+tellerUrl);
		
		SSICUser user=new SSICUser(creator);
		String timeOut=Config.getProperties().getProperty("TSINTERVAL");
		Credentials cred=new Credentials(user,timeOut);
		//产生签名信息
		cred.generate(Config.getPublicKey(),Config.getPrivateKey());
		String ip=Config.getProperties().getProperty("SSIC_SERVERIP");
		String QTI=Config.getProperties().getProperty("SSIC_QUERYTELLERINFO");
		response.sendRedirect("http://"+ip+QTI+"Utf8?"+cred.getAuthStringURL()+"&SERVICENAME="+clientSiteno+"&serviceURL="+tellerUrl+"&TELLERNO="+tellerno);
		System.out.println("http://"+ip+QTI+"Utf8"+"?"+cred.getAuthStringURL()+"\n&SERVICENAME="+clientSiteno+"\n&serviceURL="+tellerUrl+"\n&TELLERNO="+tellerno);
	}else{
		request.getRequestDispatcher("WEB-INF/view/platform/core/user/addUser.jsp").forward(request,response);
	}
%>