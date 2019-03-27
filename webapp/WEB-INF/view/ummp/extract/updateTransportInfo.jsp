<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/extract/updateTransportInfo.js"></script>
<script type="text/javascript" src="../js/commonutil.js"></script>
</head>

<body>
	 <input id="pID" name="pID" type="hidden" value="${ excId}"/>
	 <!-- 数据传输前操作 -->
	<div style="margin-top: 3px;width:1148px;" id="tabdiv1">
		<table id="dataTransportAgoTable"></table>
	</div>
	
	<!-- 数据传输配置 -->
	<div style="margin-top: 20px;width:1148px;" id="tabdiv2">
		<table id="dataTransportConfigTable"></table>
	</div>
	
	<!-- 数据传输后操作 -->
	<div  style="margin-top: 20px;width:1148px;" id="tabdiv3">
		<table id="dataTransportAfterTable"></table>
	</div>
	 
</body>
</html>