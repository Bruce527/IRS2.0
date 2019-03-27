<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 
 报送配置
 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/sconfig/sftpConfigInput.js"></script>
</head>
<body>
<div id="tabdiv">
<form id="sftpConfigForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="SFTP地址配置"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					 <td align="center" >使用者信息</td>
					 <td class="table_text">使用平台：</td>
					 <td><input class="easyui-combobox" name = "comId" id="comId" 
					 	        style="width: 164px;"></td>
					 <td class="table_text">使用角色：</td>
					 <td><input class="easyui-combobox" name = "roleId" id="roleId" 
					 	        style="width: 164px;"></td>
					</tr>
					<tr>
						<td align="center" >上传信息配置</td>
						<td class="table_text">上传SFTP用户名：</td>
						<td  align="left" >
							<input id = "upUser" name="upUser" class="table_input">
						</td>
						<td class="table_text" align="right">上传SFTP密码：</td>
						<td  align="left">
							<input id = "upPass" name="upPass" class="table_input">
						</td>
					</tr>
					<tr>
						<td align="center" >&nbsp;</td>
						<td class="table_text">上传SFTP IP：</td>
						<td  align="left" >
							<input id = "upIP" name="upIP" class="table_input">
						</td>
						<td class="table_text" align="right">上传SFTP 端口：</td>
						<td  align="left">
							<input id = "upPort" name="upPort" class="table_input">
						</td>
					</tr>
					<tr>
						<td align="center" >&nbsp;</td>
						<td class="table_text">上传SFTP目录：</td>
						<td  align="left" colspan="3">
							<input id = "upURL" name="upURL" class="table_input" 
							style="width: 657px">
						</td>
					</tr>
					<tr>
					 <td align="center" >下载信息配置</td>
					 <td class="table_text">下载SFTP用户名：</td>
					 <td><input name="downUser" id = "downUser" class="table_input"></td>
					 <td class="table_text">下载SFTP密码：</td>
					 <td><input name="downPass" id = "downPass" class="table_input" ></td>
					</tr>
					<tr>
						<td align="center" >&nbsp;</td>
						<td class="table_text">下载SFTP IP：</td>
						<td  align="left" >
							<input id = "downIP" name="downIP" class="table_input">
						</td>
						<td class="table_text" align="right">下载SFTP 端口：</td>
						<td  align="left">
							<input id = "downPort" name="downPort" class="table_input">
						</td>
					</tr>
					<tr>
						<td align="center" >&nbsp;</td>
						<td class="table_text">上传SFTP目录：</td>
						<td  align="left" colspan="3">
							<input id = "downURL" name="downURL" class="table_input"
							style="width: 657px">
						</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="saveSFTPInfo()" 
						class="easyui-linkbutton e-cis_button" iconCls="icon-save">设置</a>
				</div>
			</div>
		</div>
		<div>
		  <!-- 暂存TDefSend id  -->
		  <input type = "hidden" name = "id">
		</div>
	</form>
</div>
</body>
</html>