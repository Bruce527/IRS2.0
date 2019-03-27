<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../js/ztree/css/ztree.css" type="text/css">
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../js/platform/core/role/setPlatformInit.js"></script>
 <div class="easyui-layout" fit="true"> 
 	<div id="scrolldiv" region="west" split="true"  border="false" style="width: 500%;overflow:scroll; ">
		<div class="hb"  align="left">
			<a href="#" onclick="addR2P()"
			   class="easyui-linkbutton" iconCls="icon-save">保存</a>
		</div>
		
		<div align="center">
		 <div align="center" >
			<table>
				<tr>
					<td>角色：${defRole.rolename}</td>
					<td><input type="hidden" id="roleid" name="roleid" value="${defRole.id}"></td>
				</tr>
			</table>
		 </div>
			<ul id="treeRL" class="ztree" style="height:150px;"></ul>
		</div>
	</div>
	<div region="center" border="false" style="width: 500%;overflow:scroll; "> 
		<div>&nbsp;</div>
		<div align="center">
			<table>
				<tr>
					<td>已存在平台机构：</td>
				</tr>
			</table>
		</div>
		<div align="center">
			<ul id="treeRR" class="ztree"></ul>
		</div>
		
		
	</div> 
</div> 
 			 