<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../js/platforms/quartz/handOperationInit.js"></script>
<script type="text/javascript" src="../js/common.js"></script>

<!-- 作业名称 -->
<div id="tabdiv">
	<form id="workForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="作业信息"
			 collapsible="true"  >
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">作业</td>
						<td><input id="homework" name="homework" class="table_input"/></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</div>

<!-- 批处理参数 -->
<div id="tabdiv1" >
	<form id="extractForm" style="margin-top: 15px;">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="参数信息"
			 collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">业务号</td>
						<td><input name="businessNo" id="businessNo" class="table_input"></td>
						<td class="table_text" align="right">批次号</td>
						<td><input name="batchNo" id="batchNo" class="table_input"/></td>
					</tr>
					<tr>
						<td class="table_text" align="right">起始日期</td>
						<td><input name="startDate" id="startDate" class="table_input"></td>
						<td class="table_text" align="right">终止日期</td>
						<td ><input name="endDate" id="endDate" class="table_input"></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</div>

<!-- 监控参数 -->
<div id="tabdiv2" style="margin-top: 15px;">
	<form id="monitorForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="事件包定义"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">事件包</td>
						<td><input class="table_input easyui-validatebox" data-options="validType:'isBlank'"  name="monitorCode" id="monitorCode" ></input></td>
					</tr>
				</table> 
			</div>
		</div>
	</form>
</div>

<!-- 报送参数 -->
<div id="tabdiv3" style="margin-top: 15px;">
	<form id="submitForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="报送参数"  collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">报送平台</td>
						<td><input id="platComId" name="platCom" class="table_input easyui-validatebox" data-options="validType:'isBlank'"></input></td>
						<td class="table_text" align="right">业务类型</td>
						<td><input id="bussTypeId" name="bussType"  class="table_input easyui-combobox easyui-validatebox"  data-options="validType:'isBlank'"></input></td>
					</tr>
					<tr>
						<td class="table_text" align="right">业务号</td>
						<td><input name="submit_businessNo" id="submit_businessNo" class="table_input"></td>
						<td class="table_text" align="right">批次号</td>
						<td><input name="submit_batchNo" id="submit_batchNo" class="table_input"/></td>
					</tr>
					<tr>
						<td class="table_text" align="right">起始日期</td>
						<td align="left"><input id = "submit_startDate" name="submit_startDate" class="easyui-datebox" data-options="editable:false" style="width: 165px;">
						<td class="table_text" align="right">终止日期</td>
						<td  align="left"><input id="submit_endDate" name="submit_endDate"class="easyui-datebox" data-options="editable:false" style="width: 165px;"></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</div>

<!-- 功能按钮 -->
<div style="margin-top: 10px;">
	<a href="#" onclick="clearForm()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a> 
	<a href="#" onclick="execute()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">执行</a>
</div>

<!-- 批处理前置校验表格 -->
<div style="margin-top: 15px;" id="tabdiv6">
	<table id="verifyTable"></table>
</div>


