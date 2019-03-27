<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/updownfile/createUpload.js"></script>
<%String path=application.getRealPath("/"); %>
<div id="tabdiv" class="easyui-panel">
	<form id="userForm">
		<input name="realPath" id="realPath" type="hidden"  value="<%=path %>">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="访问信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">批次类型：</td>
						<td align="left">
						<input class="table_input easyui-validatebox" name="batchType" id="batchType"  value="" >
						</td>
						<td class="table_text" align="right">上报数据类型：</td>
						<td align="left">
						<input class="table_input easyui-validatebox" name="dataType" id="dataType"  value="" >
						</td>
						<td class="table_text" align="right">业务起始时间：</td>
						<td align="left">
						<input id="startDate" name="startDate" type="text" class="easyui-datebox table_input" editable="false" ></input> 
						</td>
					</tr>
					<tr>
						<td class="table_text" align="right">业务状态：</td>
						<td align="left">
						<input class="table_input easyui-validatebox" name="bussFlag" id="bussFlag"  value="" >
						</td>
						<td class="table_text" align="right">数据险种类型：</td>
						<td align="left">
						<input class="table_input easyui-validatebox" name="insureType" id="insureType"  value="" >
						</td>
						<td class="table_text" align="right">业务结束时间：</td>
						<td align="left">
						<input id="endDate" name="endDate" type="text" class="easyui-datebox table_input"  editable="false"></input>
						</td>
					</tr>
					<tr>
						<!-- <td class="table_text" align="right">业务类型：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="bussType" id="bussType"  value="" >
						</td> -->
						<td class="table_text" align="right">批次号：</td>
						<td align="left">
						<input id="batchNo" name="batchNo" required="true" class="table_input " value="">
						</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm1()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchUser1()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
					<a href="#" onclick="createFile()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-edit">创建文件</a>
					<a href="#" onclick="uploadFile()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-add">上载文件</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 3px;" id="tabdiv">
	<table id="userTable"></table>
</div>
