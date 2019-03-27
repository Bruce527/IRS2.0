<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../js/ummp/monitordeploy/listMonitorMatterInit.js"></script>
<script type="text/javascript" src="../js/common.js"></script>

<div id="tabdiv" class="easyui-panel">
	<form id="userForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="事件包定义"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">监控事件包：</td>
						<td align="left">
						<input class="table_input"  class="table_TextArea easyui-validatebox"  name="monitorCode" id="monitorCode" ></input>
						</td>
						<td class="table_text" align="right">监控事件：</td>
						<td align="left">
						<input class="table_input"  class="table_TextArea easyui-validatebox"  name="sqlCode" id="sqlCode" ></input>
						</td>
					</tr>
				</table> 
				<div>
					<a href="#" onclick="clearForm()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchMatter()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
					<a href="#" onclick="deleteMatter()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-delete">删除事件包</a>
					<a href="#" onclick="addMatter()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-add">保存事件包</a>
				</div>
			</div>
		</div>
	</form>
</div>

<div style="margin-top: 3px;" id="tabdiv">
	<table id="userTable"></table>
</div>