<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="../js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../js/ztree/css/ztree.css" type="text/css">
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../js/platform/core/menu/addMenuInit.js"></script>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'west'"  style="width: 550%;">
		

<div style="margin-top:20px;float:left;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width="80" align="right">菜单名称：</td>
<td width="160" align="left"><input id="menuname" name="menuname" class="table_input" value="" style="width: 180px;"></td>
</tr>
<tr>
<td width="80" align="right">映射路径：</td>
<td width="160" align="left"><input id="menuurl" name="menuurl" class="table_input" value="" style="width: 180px;"></td>
</tr>
<tr>
<td width="80" align="right">系统：</td>
<td width="160" align="left"><input id="system" name="system" class="table_input" value="" placeholder="不填默认本系统菜单" style="width: 180px;"></td>
</tr>
<tr>
<td width="80" align="right">菜单描述：</td>
<td width="160" align="left"><input id="privilegeDescribe" name="privilegeDescribe" class="table_input" value="" style="width: 180px;"></td>
</tr>
<tr>
<td width="80" align="right">菜单标志：</td>
<td width="160" align="left"><input class="table_select easyui-combobox" name="privilegeSign" id="privilegeSign" style="width: 184px;"></td>
</tr>
</table>
<div><a href="#" onclick="addNodes()" class="easyui-linkbutton" iconCls="icon-add" style="margin:10px 0 0 40px;">生成菜单节点</a></div>
</div>


		
		
		
		 <div style="float:right;width:200px;margin-right:20px;" fit="true">
			<ul id="newtree" class="ztree" style="border:none;"></ul>
		</div> 
	</div>
	<div data-options="region:'center'" >
		<div style="float:center;width:200px;margin-left:8%;">
			<ul id="menutree" class="ztree"></ul>
		</div>
		<div align="center">
			<a href="#" onclick="saveAdd()" class="easyui-linkbutton" iconCls="icon-save" style="float:left;margin:10px 0 0 40px;">保存</a>
		</div>

	</div>
</div>
