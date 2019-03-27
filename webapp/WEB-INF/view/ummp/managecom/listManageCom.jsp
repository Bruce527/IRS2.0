<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/managecom/listManageComInit.js"></script>
<div id="tabdiv" class="easyui-panel">
	<form id="manageComForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="管理机构信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">核心机构编码：</td>
						<td><input name="manageCode" id="manageCode" class="table_input"></td>
						<td class="table_text" align="right">机构名称：</td>
						<td align="left"><input name="manageName" id="manageName"
							class="table_input"></td>
					</tr>
					<tr>
						<td class="table_text" align="right">监管机构编码：</td>
						<td><input name="mmonitorCode" id="mmonitorCode" class="table_input"></td>
						<td class="table_text" align="right">上级机构编码：</td>
						<td align="left"><input name="fid" id="fid"
							class="table_input"></td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearCom()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchCom()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
				</div>
			</div>
		</div>
	</form>
</div>

<div style="margin-top: 3px;" id="tabdiv">
	<table id="manageComTable"></table>
</div>