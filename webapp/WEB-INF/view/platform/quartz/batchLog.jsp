<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/quartz/batchLogInit.js"></script>
<div id="tabdiv" class="easyui-panel">
	<form id="batchLogForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="批处理日志"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">作业名称</td>
						<td align="left"><input class = "table_input" name="homework"  id ="homework" ></select></td>
						<td class="table_text" align="right">执行方式</td>
						<td align="left"><select class = "table_input" name="run_mode"  id="run_mode" ></select></td>
					</tr>
					<tr>
						<td class="table_text" align="right">起始日期</td>
						<td><input name="startDate" id="startDate" class="table_input"></td>
						<td class="table_text" align="right">结束日期</td>
						<td align="left"><input name="endDate" id="endDate" class="table_input"></td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="query()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div id="logToolBarId">
 <table>
  <tr>
    <td class="table_text" align="right">作业名称</td>
	<td align="left"><input class = "table_input" name="logWork"  id ="logWork" ></select></td>
    <td class="table_text" align="right">起始日期</td>
	<td><input name="startTime" id="startTime" class="easyui-datetimebox table_input"></td>
	<td class="table_text" align="right">结束日期</td>
	<td align="left"><input name="endTime" id="endTime" class="easyui-datetimebox table_input"></td>
	<td valign="top"><a class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearLog()">删除日志</a></td>
  </tr>
 </table>
</div>
<div style="margin-top: 3px;" id="tabdiv">
	<table id="homeWorkExecuteTable"></table>
</div>