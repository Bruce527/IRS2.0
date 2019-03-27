<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/codedict/updateCodedictInit.js"></script>

<div id="tabdiv1">
	<form id="updateCodedictForm" method="post">
		<div id="smsaccordion1" class="easyui-panel" fit="true" title="更新枚举"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr >
						<td class="table_text" align="right">枚举类型：</td>
						<td align="left">
						<input id="codeType" name="codeType" readonly="readonly" class="table_input easyui-validatebox" validType="length[0,50]" value="${tDefCodeDict.codeType}" style="width: 180px">
						</td>
						<td class="table_text" align="right">枚举编码：</td>
						<td align="left">
						<input id="code" name="code" validType="length[0,50]" readonly="readonly"  class="table_input easyui-validatebox" value="${tDefCodeDict.code}" style="width: 180px">
						</td>
						</tr>
					<tr>
						<td class="table_text" align="right">枚举名称：</td>
						<td align="left">
	 					<input id="codeName" name="codeName" validType="length[0,50]" required="true" class="table_input easyui-validatebox" value="${tDefCodeDict.codeName}" style="width: 180px"></td>
					<td class="table_text" align="right">枚举别名：</td>
						<td align="left">
						<input id="codeAlias"  name="codeAlias" validType="length[0,200]"  class="table_input easyui-validatebox" value="${tDefCodeDict.codeAlias}" style="width: 180px">
						</td>
					</tr>
					<tr>
						<td class="table_text" align="right">平台编码：</td>
						<td align="left">
						<input id="comId" disabled="disabled" name="comId"  readonly="readonly" class="easuui-combobox" value="${tDefCodeDict.comId}" style="width: 184px">
						</td>
						<td class="table_text" align="right">状态标识：</td>
						<td align="left">
						<input class="easyui-combobox table_select" name="esStatus" id="esStatus" value="${tDefCodeDict.esStatus}" style="width: 184px">
						</td>
					</tr>

				</table>
				<div>
					<a href="#" onclick="updateCodedict()" class="easyui-linkbutton e-cis_button" iconCls="icon-add">修改</a>
				</div>
			</div>
		</div>
	</form>
</div>
