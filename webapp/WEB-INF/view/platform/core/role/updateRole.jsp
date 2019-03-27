<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/core/role/updateRoleInit.js"></script>

<div id="tabdiv">
	<form id="updateRoleForm" method="post">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="角色信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">角色名称：</td>
						<td align="left"><input id="rolename" name="rolename" class="table_input" value="${defRole.rolename}"></td>
						<td class="table_text" align="right">角色编码：</td>
						<td align="left"><input id="rolecode" name="rolecode" class="table_input" value="${defRole.rolecode}"></td>
						<td style="border-right: none;">&nbsp;</td>
						<td align="left" style="border-right: none;">&nbsp;</td>
					</tr>
				</table>
				<input type="hidden" id="id" name="id" value="${defRole.id}">
				<div>
					<a href="#" onclick="updateRole()" class="easyui-linkbutton e-cis_button" iconCls="icon-add">修改</a>
				</div>
			</div>
		</div>
	</form>
</div>