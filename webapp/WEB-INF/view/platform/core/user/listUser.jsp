<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/core/user/listUserInit.js"></script>
<div id="tabdiv" class="easyui-panel">
	<form id="userForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="用户信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">用户名称：</td>
						<td><input name="username" id="username" class="table_input"></td>
						<td class="table_text" align="right">用户编码：</td>
						<td align="left"><input name="usercode" id="usercode"
							class="table_input"></td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchUser()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 3px;" id="tabdiv">
	<table id="userTable"></table>
</div>
