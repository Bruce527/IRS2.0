<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/report/listOperateReportInit.js"></script>

<div id="tabdiv"  class="easyui-panel">
	<form id="userForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="访问信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">用户名称：</td>
						<td><input name="username" id="username" class="table_input"></td>
						<td class="table_text" align="right">用户编码：</td>
						<td align="left"><input name="usercode" id="usercode"
							class="table_input"></td>
						<td class="table_text" align="right">统一认证编码：</td>
						<td><input name="empowerCode" id="empowerCode" class="table_input"></td>
					</tr>
					<tr>
						<td class="table_text" align="right">开始访问时间：</td>
						<td align="left">
						<input id="startDate" name="startDate" type="text" class="table_input easyui-datebox" editable="false" ></input> 
						</td>
						<td class="table_text" align="right">结束访问时间：</td>
						<td align="left">
						<input id="endDate" name="endDate" type="text" class="easyui-datebox table_input"  editable="false"></input>
						</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm1()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchUser1()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
					<a href="#" onclick="deriveLog()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">导出</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 3px;" id="tabdiv">
	<table id="userTable"></table>
</div>
