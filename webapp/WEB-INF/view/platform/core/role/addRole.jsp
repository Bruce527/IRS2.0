<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/core/role/addRoleInit.js"></script>

<div id="tabdiv">
	<form id="addRoleForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="角色信息" iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">角色名称：</td>
						<td align="left"><input name="rolename" class="table_input"
							value=""></td>
						<td class="table_text" align="right">角色编码：</td>
						<td align="left"><input name="rolecode" class="table_input"
							value=""></td>
						<td style="border-right: none;">&nbsp;</td>
						<td align="left" style="border-right: none;">&nbsp;</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="addRole()" class="easyui-linkbutton e-cis_button" iconCls="icon-add">新增</a>
				</div>
			</div>
		</div>
	</form>
</div>


