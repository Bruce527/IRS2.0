<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="../js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../js/ztree/css/ztree.css" type="text/css">
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../js/platform/core/menu/updateMenuInit.js"></script>
<div class="easyui-layout" fit="true">
	<div region="west" split="true" border="false" style="width: 550%;">
		<div>
		
<div style="margin-top:20px;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width="50" align="right">菜单名称：</td>
<td width="200" align="left"><input id="privilegename" name="privilegename" class="table_input" value="${defPrivilege.privilegename}"></td>
</tr>
<tr>
<td width="50" align="right">映射路径：</td>
<td width="200" align="left"><input id="url" name="url" class="table_input" value="${defPrivilege.url}"></td>
<input type="hidden" id="oldname" name="name" value="${defPrivilege.privilegename}">
</tr>
<tr>
<td width="50" align="right">系统：</td>
<td width="200" align="left"><input id="system" name="system" class="table_input" value="${defPrivilege.method}" placeholder="不填默认本系统菜单"></td>
</tr>
<tr>
<td width="80" align="right">菜单描述：</td>
<td width="160" align="left"><input id="privilegeDescribe" name="privilegeDescribe" class="table_input" value="${defPrivilege.privilegeDescribe}"></td>
</tr>
<tr>
<td width="80" align="right">菜单标志：</td>
<td width="160" align="left"><input id="privilegeSign" name="privilegeSign" class="table_select easyui-combobox" value="${defPrivilege.privilegeSign}"></td>
</tr>
</table>
<div><a href="#" onclick="saveUpdate()" class="easyui-linkbutton" iconCls="icon-add" style="margin:10px 0 0 40px;">修改</a></div>
</div>
		</div>
	</div>
	<div region="center" border="false">
		<div style="float:center;width:200px;margin-left:8%;">
			<ul id="upmenutree" class="ztree"></ul>
		</div>
	</div>
</div>
