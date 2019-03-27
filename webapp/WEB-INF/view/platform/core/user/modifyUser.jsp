<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/core/user/modifyUserInit.js"></script>
<link rel="stylesheet" type="text/css" href="../css/having.css" type="text/css">
<form id="modifyUserForm" method="post" style="margin: 0;text-align: left;">
	<div style="padding-top: 20px;padding-left: 200px">
	 <table width="100%" >
		<tr class="stagetr_tr2"><td>输入原密码：<input type="Password"  id="password" name="password" style="width: 200" value=""></td>
		</tr>
		<tr><tr class="stagetr_tr2"><td>输入新密码：<input type="Password"  id="password1" name="password1" style="width: 200" value=""></td> </tr>
		<tr class="stagetr_tr2"><td>确认新密码：<input type="Password"  id="password2" name="password2" style="width: 200" value=""></td></tr>
		<tr>
			<td ><a href="#" onclick="modifyUser()"
				class="easyui-linkbutton" iconCls="icon-add">确认</a><a href="#" onclick="reset()"
				class="easyui-linkbutton" iconCls="icon-add">重置</a></td>
		</tr>
	</table>
	</div>
</form>