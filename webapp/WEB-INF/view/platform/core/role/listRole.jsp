<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/core/role/listRoleInit.js"></script>
<div id="tabdiv" class="easyui-panel">
	<form id="listRoleForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="角色信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">角色名称：</td>
						<td  align="left"><input name="rolename"
							class="table_input"></td>
						<td class="table_text" align="right">角色编码：</td>
						<td  align="left"><input name="rolecode"
							class="table_input"></td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearRole()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchRole()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 3px;" id="tabdiv"> 
	<table id="roleTable"></table>
</div>
<div id="roletab" class="easyui-tabs" fit="false" border="ture"  plain="true"></div>