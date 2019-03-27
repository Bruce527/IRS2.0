<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/quartz/updateVerifySqlCode.js"></script>
<!-- 校验算法配置 -->
<div id="tabdiv2">
	<form id="verifyArithmeticForm">
		<input id="sqlId" name="sqlId" value="${sqlId}" type="hidden">
		<div id="smsaccordion2" class="easyui-panel" fit="true" title="校验算法"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="table_text" align="right">算法编码:</td>
							<td align="left"><input id="sqlCode" name="sqlCode"  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" value="${SqlCode}"></td>
							<td class="table_text" align="right">数据源名称:</td>
							<td align="left"><input id="dataSourceName" name="dataSourceName" class="table_input " value="${dataSourceName }"></td>
							<td class="table_text" align="right">SQL类型:</td>
							<td align="left"><input id="sqlType" name="sqlType" class="table_input" class="table_input" value="${sqlType }"></td>
						</tr>
						<tr>
							<td class="table_text" align="right">有效性:</td>
							<td align="left"><input id="validity" name="validity" class="table_input" value="${ EsStatus}"></td>
							<td  class="table_text">算法描述:</td>
							<td  align="left" colspan="4"><input  style="width:60%;" value="${ desc}" name="desc" id="desc" class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'"></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td  class="table_text">SQL:</td>
							<td  align="left" colspan="4" style="width:60%" ><textarea  id="sql" name="sql" rows="15" cols="100"  style="margin-left: 10px; border: 1px solid #abcdef;" class="table_TextArea easyui-validatebox" data-options="required:true,validType:'isBlank'">${sql}</textarea></td>	
						</tr>
				</table>
				<div>
					<a href="#" onclick="saveUpdateSQLInfo()" class="easyui-linkbutton e-cis_button" iconCls="icon-save">保存</a>
				</div>
			</div>
		</div>
	</form>
</div>
