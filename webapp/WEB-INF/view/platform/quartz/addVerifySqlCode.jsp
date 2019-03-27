<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/quartz/addVerifySqlCode.js"></script>
<!-- 校验算法配置 -->
<div id="tabdiv2">
	<form id="verifyArithmeticForm">
		<input type="hidden" id="flag" name="flag" value="${flag }">
		<div id="smsaccordion2" class="easyui-panel" fit="true" title="校验算法"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
							<td class="table_text" align="right">算法编码:</td>
							<td align="left"><input id="sqlCode" name="sqlCode"  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'"></td>
							<td class="table_text" align="right">数据源名称:</td>
							<td align="left"><input id="dataSourceName" name="dataSourceName" class="table_input " ></td>
							<td class="table_text" align="right">SQL类型:</td>
							<td align="left"><input id="sqlType" name="sqlType" class="table_input" class="table_TextArea easyui-validatebox" data-options="required:true,validType:'isBlank'" ></td>
						</tr>
						<tr>
							<td class="table_text" align="right">有效性:</td>
							<td align="left"><input id="validity" name="validity" class="table_input" ></td>
							<td  class="table_text">算法描述:</td>
							<td  align="left" colspan="3"><input   name="desc" id="desc" class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'"></td>
							
						</tr>
						
					</table>
					</div>
				<div class="top_table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td  class="table_text">SQL:</td>
							<td  align="left" colspan="3"  ><textarea  id="sql" name="sql" rows="30" cols="109"  style="margin-left: 10px; border: 1px solid #abcdef;" class="table_TextArea easyui-validatebox" data-options="required:true,validType:'isBlank'"></textarea></td>	
						</tr>
				
				</table>
				<div>
					<a href="#" onclick="commit()" class="easyui-linkbutton e-cis_button" iconCls="icon-save">保存</a>
				</div>
			</div>
		</div>
	</form>
</div>
