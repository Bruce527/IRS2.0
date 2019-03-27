<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/extract/handExtract.js"></script>
</head>
<body>
	<div id="tabdiv1">
		<form id="extractForm" style="margin-top: 15px;">
			<div id="smsaccordion" class="easyui-panel" fit="true" title="参数信息" iconCls = "icon-ok"
				 collapsible="true">
				<div class="top_table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="table_text" align="right">提数平台</td>
							<td  align="left">
								<input id = "comId" name="comId" class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
							</td>
							<td class="table_text" align="right">传输类型</td>
							<td><input id="transType" name="transType" class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205"/></td>
							<td class="table_text" align="right">业务号</td>
							<td><input name="bussNo" id="bussNo" class="table_input" style="width:200px"></td>
						</tr>
						<tr>
							<td class="table_text" align="right">起始日期</td>
							<td><input name="startDate" id="startDate" class="table_input" style="width: 205px;"></td>
							<td class="table_text" align="right">终止日期</td>
							<td ><input name="endDate" id="endDate" class="table_input" style="width: 205px;"></td>
							<!-- <td class="table_text" align="right">批次号</td>
							<td><input name="batchNo" id="batchNo" class="table_input" style="width:200px"/></td> -->
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
</body>
</html>