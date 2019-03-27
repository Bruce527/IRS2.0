<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/updownfile/dealData.js"></script>
<div id="tabdiv" class="easyui-panel">
	<form id="userForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="访问信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">业务起始时间：</td>
						<td align="left">
						<input id="startDate" name="startDate" type="text" class="table_input easyui-datebox" editable="false" ></input> 
						</td>
						<td class="table_text" align="right">业务结束时间：</td>
						<td align="left">
						<input id="endDate" name="endDate" type="text" class="easyui-datebox table_input"  editable="false"></input>
						</td>
						<td class="table_text" align="right">文件类型：</td>
						<td align="left">
						<input class="table_input easyui-validatebox" name="fileType" id="fileType"  value="" >
						</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="synchronize()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
					<a href="#" onclick="fileDownload()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-print">数据下载</a>
					<a href="#" onclick="dealData()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-edit">数据处理</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 3px;" id="tabdiv">
	<table id="userTable"></table>
</div>
