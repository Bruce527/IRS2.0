<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/xengin/msgShowInput.js"></script>
<title>Insert title here</title>
</head>
<body>
<div style="font-size: 14">正在浏览报文
 <div style="display: none;">
    <span>您可以： </span>
 	<a href="#" class="easyui-linkbutton" onclick="downXmlScan()">下载</a>
 	<form action="">
 	 <input type = "hidden" name = "ids" id="ids" value ='${ids}'>
 	 <input type = "hidden" name = "format" id="format" value ='${format}'>
 	 <input type = "hidden" name = "isTitle" id="isTitle" value ='${isTitle}'>
 	 <input type = "hidden" name = "title" id="title" value ='${title}'>
 	</form>
 </div>
 <h4>报文描述</h4>
 <p>${xmsg_desc}</p>
</div>
<div class="easyui-panel" style="height: 600px;width:800px; visibility: visible;">
	<xmp id="xmsg" style = "background-color:window;">${xmsg}</xmp>
</div>
</body>
</html>