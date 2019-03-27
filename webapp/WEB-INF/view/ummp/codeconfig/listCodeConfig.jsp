<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/ummp/codeconfig/listCodeConfigInit.js"></script>
</head>
<body>
<div id="tabdiv"  class="easyui-panel">
	<form id="CodeConfigForm">
		<input id="id" name="id" type="hidden">
<!-- 		<input id="id" name="id"> -->
		<div id="smsaccordion" class="easyui-panel" fit="true" title="转码配置校验"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">目标表名：</td>
						<td align="left"><input class="easyui-combobox table_select"
							name="targetTableName" id="targetTableName" value="${targetTableName}"></input></td>
						<td class="table_text" align="right">目标字段：</td>
						<td align="left"><input class="easyui-combobox table_select"
							name="targetColName" id="targetColName" value="${targetColName}"></input></td>
					</tr>
					<tr>
						<td class="table_text" align="right">参考映射：</td>
						<td align="left"><input name="codeType" id="codeType"
							class="easyui-combobox table_select" value="${codeType}"></td>
						<td class="table_text" align="right">数据来源：</td>
						<td align="left"><input class="easyui-combobox table_select"
							name="dataType" id="dataType" value="${dataType }"></input></td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearCode()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">重置</a>
					<a href="#" onclick="searchCode()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
					<a href="#" onclick="updateCode()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">修改</a>
						<a href="#" onclick="saveCode()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">定义</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 10px;" id="tabdiv">
	<table id="codeConfigTable"></table>
</div>
</body>
</html>