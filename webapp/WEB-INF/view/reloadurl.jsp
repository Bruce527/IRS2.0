<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<div>&nbsp;</div>
<script type="text/javascript">
	$.messager.confirm('系统提示', '是否退出系统？', function(r) {
		if (r) {
		<%
		Enumeration es = session.getAttributeNames();
		while(es.hasMoreElements()){
			String sessionName = (String) es.nextElement();
			System.out.println("======>清空 Session : "+sessionName+" ... ");
			session.removeAttribute(sessionName);
		}
		Enumeration er = request.getAttributeNames();
		while(es.hasMoreElements()){
			String requestName = (String) er.nextElement();
			System.out.println("======>清空 Request : "+requestName+" ... ");
			session.removeAttribute(requestName);
		}
		session.setAttribute("SafeExist", "1");
		%>
		top.window.location="../index.jsp?SafeExist=1";		
	}else{
		parent.deletetab("重新登陆");
	}});
</script>