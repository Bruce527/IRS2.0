<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../js/ztree/css/ztree.css" type="text/css">
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../js/platform/core/user/setUserInitN.js"></script>
<div class="easyui-layout" fit="true">
	<div region="west" split="true" border="false" style="width: 500%;">
		<div align="left">
			<table>
				<tr>
					<td>用户编码:    
						<input id="userCode" name="userCode" style="width: 80px" class="table_input easyui-validatebox" required="true">
						</td>  
					<td>
<%-- 					<input type="hidden" id="userid" name="userid" value="${id}"> --%>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
			<ul id="treeUL" class="ztree" style="height: 80px"></ul>
			<a href="#" onclick="addU2R()" class="easyui-linkbutton e-cis_button" iconCls="icon-save">保存</a>
		</div>
		<div align="right">
			
		</div>
	</div>
	<div region="center" border="false">
		<div>
			<table>
				<tr>
					<td>已存在角色：</td>
				</tr>
			</table>
		</div>
		<div align="center" >
			<ul id="treeUR" class="ztree" style="height: 80px"></ul>
		</div>
	</div>
</div>
