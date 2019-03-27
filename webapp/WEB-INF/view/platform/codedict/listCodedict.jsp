<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/codedict/listCodedictInit.js"></script>

<div id="tabdiv" class="easyui-panel">
	<form id="codedictForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="枚举信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">枚举类型：</td>
						<td align="left"><input name="codeType" id="codeType" class="table_input" style="width: 180px"></td>
						<td class="table_text" align="right">枚举编码：</td>
						<td align="left"><input name="code" id="code" class="table_input" value="" style="width: 180px"></td>
					</tr>
					<tr>
						<td class="table_text" align="right">平台编码：</td>
						<td align="left"><input id="comId" name="comId"  class="easyui-combobox" style="width: 180px"></td>
						<td class="table_text" align="right">状态标识：</td>
						<td align="left">
						<input class="easyui-combobox table_select" name="esStatus" id="esStatus" style="width: 184px" >
						</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchCodedict()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 3px;" id="tabdiv">
	<table id="codedictTable"></table>
</div>
