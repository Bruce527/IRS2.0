<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/ses/AppointFileImport.js"></script>
<script type="text/javascript" src="../js/uploadify/jquery.uploadify.js"></script>
<link rel="stylesheet" type="text/css"	href="../js/uploadify/uploadify.css" />
<div id="tabdiv" class="easyui-panel">
	<form id="appointFileImportForm" name="appointFileImportForm" action=""
		method="get">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="指定文件导入"
			iconCls="icon-ok" collapsible="true" style="height: 500px">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="left">导入数据表：</td>
						<td align="left"><input id="targetTable" name="targetTable"
							class="table_input easyui-combobox" style="width: 220px">
							&nbsp;&nbsp;<span id="targetTableName"></span></td>
					</tr>
					<tr>
						<td class="table_text" align="left">年份：</td>
						<td align="left"><input id="year" name="year"
							class="table_input" style="width: 220px"></td>
					</tr>
					<tr>
						<td class="table_text" align="left">请选择导入文件：</td>
						<td align="left"><font color="red">*说明：导入文件与数据库表必须字段上统一，目前仅支持.csv导入</font></td>
					</tr>
				</table>
			</div>
			<div style="padding-left: 5px;padding-top: 5px;">
			<input type="hidden" name="fileName" value="">
			<input type="hidden" name="fileType" value="">
			<input id="filePath" name="filePath" type="file"  style="width:350px;">
			</div>
			<div>
				<a href="#" onclick="clearForm()"
					class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
				<a href="#" onclick="fileImport();"
					class="easyui-linkbutton e-cis_button" iconCls="icon-add">导入</a>
			</div>
		</div>
	</form>
</div>
