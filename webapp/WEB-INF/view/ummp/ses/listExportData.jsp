<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/ummp/ses/listExportData.js"></script>

<div id="tabdiv"  class="easyui-panel">
	<form id="exportDataForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="指定数据表导出"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					
					<tr>
						<td class="table_text" align="right">导出年份：</td>
						<td><select class="easyui-combobox table_select" name="exportDataYearSign" id="exportDataYearSign" style="width: 150px;"></select>(单位：年)</td>
					
						<td class="table_text" align="right">导出数据表：</td>
						<td><input id="exportDataTabSign" name="exportDataTabSign" class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205"/></td>
						<td class="table_text" align="left">目标表描述：</td>
						<td><input id="exportDataTabDesc" name="exportDataTabDesc" class="table_input" readonly="readonly" style="width:200px"/></td>
					</tr>	
				</table>
				
				<div>
					<a href="#" onclick="exportSubmit()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">导出</a>
				</div>				
			</div>
			<div><p style="color: red;font-size: medium;">说明：目前支持.csv 导出</p></div>
		</div>
	</form>
</div>
