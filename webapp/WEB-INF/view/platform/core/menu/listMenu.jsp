<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/core/menu/listMenuInit.js"></script>

<div id="tabdiv" class="easyui-panel">
	<form id="menuForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="菜单信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">菜单名称：</td>
						<td><input name="privilegename" id="privilegename" class="table_input" style="width: 180px;"></td>
						<td class="table_text" align="right">菜单编码：</td>
						<td align="left"><input name="privilegecode" id="privilegecode"
							class="table_input" style="width: 180px;"></td>
					</tr>
<tr>
						<td class="table_text" align="right">菜单描述：</td>
						<td><input name="privilegeDescribe" id="privilegeDescribe" class="table_input" style="width: 180px;"></td>
						<td class="table_text" align="right">菜单标志：</td>
						<td><select class="easyui-combobox table_select" name="privilegeSign" id="privilegeSign" style="width: 184px;"></select></td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearMenu()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchMenu()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
				</div>
			</div>
		</div>
	</form>
</div>

<div style="margin-top: 3px;" id="tabdiv">
	<table id="menuTable"></table>
</div>