<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/platform/log/listLogInput.js"></script>
</head>
<body>
<div id="tabdiv1" class="easyui-panel">
	<form id="logForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="日志加载"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table" style="height: 70px">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th class="table_text" align="right" style=" padding-left: 10px">路径:</th>
						<td><input name="logPath" id="logPathId" class="table_input" value=""
						style="border-left:0px;border-right: 0px;border-top: 0px; border-bottom:0px;
						width: 1000px;"></td>
					</tr>
					<tr>
					 <td colspan="2" style="padding-bottom: 10px">
					  <a href="#" class = 'easyui-linkbutton e-cis_button' iconCls="icon-reload" onclick="reFreash()">刷新</a>
					  <a href="#" class = 'easyui-linkbutton e-cis_button' iconCls="icon-back" onclick="goBack()">返回</a>
					  <input  class="table_input" id = "researchId" name = "research" style="width: 200px;">
					  <a href="#" class = 'easyui-linkbutton e-cis_button' iconCls="icon-search"
					  	 onclick="reSearch()">搜索</a>					  
					 </td>
					</tr>
				</table>
			</div>
		</div>
		<div id="logTabeDiv" class="easyui-panel" 
			collapsible="true"
			data-options="iconCls:'icon-ok'">
			<table id="logTableGridId"></table>
		</div>
	</form>
</div>
<div id="newDirWin"></div>
</body>
</html>