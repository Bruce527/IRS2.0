<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示</title>
</head>
<body>
<div>
 <h1>操作异常</h1>
 <ul>
  <li>检查网络：<%request.getRequestURI() %>是否正常</li>
  <li>请重新登录系统重试</li>
  <li>严重问题请联系管理员</li>
 </ul>
</div>
</body>
</html>