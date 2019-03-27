<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/monitordeploy/listMonitorDeployInit.js"></script>

<div id="tabdiv" class="easyui-panel">
	<form id="userForm">
		<div id="smsaccordion" class="easyui-panel" fit="false" title="监控算法配置"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">有效性：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="esStatus" id="esStatus" ></input>
						</td>
						<td class="table_text" align="right">算法编码：</td>
						<td><input name="sqlCode" id="sqlCode" class="table_input"></td>
					</tr>
					<tr>
						<td class="table_text" align="right">数据源名称：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="jdbcCode" id="jdbcCode" ></input>
						</td>
						<td class="table_text" align="right">算法描述：</td>
						<td align="left"><input name="sqlDesc" id="sqlDesc"
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
