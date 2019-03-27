<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/mapping/listCodeMapping.js"></script>
</head>
<body>
	<div id="tabdiv"  class="easyui-panel">
		<form id="fm">
			<div id="mappingconfigId" class="easyui-panel" fit="true"
				title="代码映射配置" iconCls="icon-ok" collapsible="true" style="height: 60px">
				<div class="top_table" style="width: 100%;height: 50px;" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="table_text" align="right">编码类型：</td>
							<td align="left"><select id="codeTypeId" name="codeType" class="easyui-combobox" style="width: 180px;"></td>
							<td class="table_text" align="right">平台机构：</td>
							<td align="left"><select id="comId" name="comId" class="easyui-combobox" style="width: 180px;"></td>
						</tr>
					</table>
				<div>
						<a href="#" onclick="resetForm()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
						<a href="#" onclick="searchMapping()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
				</div>
				</div>
			</div>
		</form>
	</div>
	<div style="margin-top: 3px;" id="tabdiv">
		<table id="codeMappingGridId"></table>
	</div>
<!-- 
	<div id="mappingConfigInfoId" class="easyui-panel"
		title="新增修改" iconCls="icon-ok" collapsible="true">
		<div class="top_table" >
		<form id="codeForm">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="table_text">编码类型</td>
					<td><input  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'codeType' id = "codeType" style="width: 200px;" ></td>
					<td class="table_text">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="table_text">原编码</td>
					<td><input  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'basicCode' id = "basicCode" style="width: 200px;" ></td>
					<td class="table_text">原编码名称</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'basicCodeName' id = "basicCodeName" style="width: 200px;"></td>
				</tr>
				<tr>
					<td class="table_text">目标编码</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'targetCode' id = "targetCode" style="width: 200px;"></td>
					<td class="table_text">目标编码名称</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'targetCodeName' id = "targetCodeName" style="width: 200px;"></td>
				</tr>
				<tr>
					<td class="table_text">使用标识</td>
					<td><input  name = 'esStatus' id = "esStatus"/></td>
					<td class="table_text">备注</td>
					<td><input class='table_input' name = 'remark' id = "remark" style="width: 200px;"></td>
				</tr>
			</table>
			<input id = "codeId" name = "codeId" type = 'hidden' >
		</form>
		</div>
		<div>
		 <a href="#" onclick="save()" class="easyui-linkbutton e-cis_button" iconCls = "icon-ok">保存</a>
		</div>
	</div> 
-->
</body>
</html>