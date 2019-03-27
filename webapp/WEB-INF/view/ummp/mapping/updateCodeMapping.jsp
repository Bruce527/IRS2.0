<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/mapping/updateCodeMapping.js"></script>
</head>
<body>
	<div id="mappingConfigInfoId" class="easyui-panel"
		title="修改代码映射" iconCls="icon-ok" collapsible="true">
		<div class="top_table" >
		<form id="codeForm">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="table_text">编码类型:</td>
					<td><input  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'codeType' id = "codeType" value="${tDefCodeMapping.codeType }" ></td>
					<td class="table_text">原编码:</td>
					<td><input  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'basicCode' id = "basicCode" value="${tDefCodeMapping.basicCode }"  ></td>
				</tr>
				<tr>
					<td class="table_text">原编码名称:</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'basicCodeName' id = "basicCodeName" value="${tDefCodeMapping.basicCodeName }" ></td>
					<td class="table_text">目标编码:</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'targetCode' id = "targetCode" value="${tDefCodeMapping.targetCode }"/></td>
				</tr>
				<tr>
					<td class="table_text">目标编码名称:</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'targetCodeName' id = "targetCodeName" value="${tDefCodeMapping.targetCodeName }" ></td>
					<td class="table_text">使用标识:</td>
					<td><input  name = 'esStatus' id = "esStatus" style="width:165px;" value="${tDefCodeMapping.esStatus }" /></td>
				</tr>
				<tr>
					<td class = "table_text">平台机构:</td>
					<td><input class='table_input' name = 'comId' id = "comId" value="${tDefCodeMapping.comId }"/></td>
					
					
					<td class="table_text">备注:</td>
					<td><input class='table_input' name = 'remark' id = "remark" value="${tDefCodeMapping.remark }"/></td>
					<td class="table_text">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			<input id = "codeId" name = "codeId" type = 'hidden' >
			<input id = "id" name = "id" type = 'hidden' value="${tDefCodeMapping.id}" >
		</form>
		</div>
		<div>
		 <a href="#" onclick="saveMapping()" class="easyui-linkbutton e-cis_button" iconCls = "icon-ok">保存</a>
		</div>
	</div>
</body>
</html>