<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/codedict/addCodedictInit.js"></script>

<div id="tabdiv">
	<form id="addCodedictForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="枚举信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table" >
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<td class="table_text" align="right">枚举类型：</td>
						<td align="left">
						<input id="codeType" name="codeType" class="table_input easyui-validatebox" validType="length[0,50]" required="true" style="width: 180px" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
						</td>
						<td class="table_text" align="right">枚举编码：</td>
						<td align="left">
						<input id="code" name="code" validType="length[0,50]" required="true" class="table_input easyui-validatebox" value="" style="width: 180px"onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
						</td>
						<td class="table_text" align="right">枚举名称：</td>
						<td align="left">
						<input id="codeName"   name="codeName" validType="length[0,50]" required="true" class="table_input easyui-validatebox"style="width: 180px"/>
						</td>
					</tr>
					<tr>
						<td class="table_text" align="right">枚举别名：</td>
						<td align="left" >
						<input id="codeAlias" name="codeAlias" class="table_input easyui-validatebox" value="" validType="length[0,200]"style="width: 180px"/ ></td>
						<td class="table_text" align="right">机构编码：</td>
						<td align="left">
						<input id="comId" name="comId" validType="length[0,10]"  class="table_input easyui-validatebox"  style="width: 180px"/>
						</td>
						
						<td class="table_text" align="right">状态标识：</td>
						<td align="left">
						<input class="easyui-combobox table_select" name="esStatus" id="esStatus" style="width: 184px" /></td>
					</tr>
					
				</table>
				<div>
				<a href="#" onclick="clearForm()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="addCodedict()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-add">新增</a>
				</div>
			</div>
		</div>
	</form>
</div>
