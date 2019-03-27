<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/quartz/batchPreposeInit.js"></script>
<script type="text/javascript" src="../js/commonutil.js"></script>

<div id="tabdiv" class="easyui-panel">
	<form id="schedulerForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="查询参数"
			 collapsible="true">
			<div class="top_table" >
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td  class="table_title">算法编码:</td>
						<td  class="table_td_input"><input name="algorithmCoding" id="algorithmCoding" class="table_input"></td>
						<td  class="table_title">算法描述:</td>
						<td  class="table_td_input"><input name="sqlDesc" id="sqlDesc" class="table_input"></td>
					</tr>
					<tr>
						<td  class="table_title">有效性:</td>
						<td  class="table_td_input"><input name="validity" id="validity" class="table_input"></td>
						<td  class="table_title">数据源名称:</td>
						<td  class="table_td_input"><input name="dataSourceName" id="dataSourceName" class="table_input"></td>
					</tr>
					
				</table>
			</div>
			<div style="margin-top: 5px;">
					<a href="#" onclick="clearForm()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchTable()"class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
			</div>
		</div>
	</form>
</div>

<div style="margin-top: 10px;">
	<table id="getDataArithmeticTable"></table>
</div>

