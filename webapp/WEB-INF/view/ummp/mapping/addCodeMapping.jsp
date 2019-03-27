<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/mapping/addCodeMapping.js"></script>
</head>
<body>
	<div id="mappingConfigInfoId" class="easyui-panel"
		title="新增代码映射" iconCls="icon-ok" collapsible="true">
		<div class="top_table" >
		<form id="codeForm">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="table_text" align="left">编码类型：</td>
					<td><input  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'codeType' id = "codeType"  ></td>
					
					<td class="table_text" align="left">原编码：</td>
					<td><input  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'basicCode' id = "basicCode"  ></td>
				</tr>
				<tr>
					<td class="table_text" align="left">原编码名称：</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'basicCodeName' id = "basicCodeName" ></td>
					
					<td class="table_text" align="left">目标编码：</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'targetCode' id = "targetCode" ></td>
				</tr>
				<tr>
					<td class="table_text" align="left">目标编码名称：</td>
					<td><input class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" name = 'targetCodeName' id = "targetCodeName" ></td>
					
					<td class="table_text" align="left">使用标识：</td>
					<td><input  name = 'esStatus' id = "esStatus" style="width:165px;"/></td>
				</tr>
				
				<tr>
					<td class = "table_text" align="left">平台机构：</td>
					<td><input  name = 'comId' id = "comId" style="width:165px;"/></td>					
					
					<td class="table_text" align="left">备注：</td>
					<td><input class='table_input' name = 'remark' id = "remark" ></td>

				</tr>
			</table>
			<input id = "codeId" name = "codeId" type = 'hidden' >
		</form>
		</div>
		<div>
		 <a href="#" onclick="saveMapping()" class="easyui-linkbutton e-cis_button" iconCls = "icon-ok">保存</a>
		</div>
	</div>
</body>
</html>