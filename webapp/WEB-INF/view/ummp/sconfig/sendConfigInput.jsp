<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 
 报送配置
 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/sconfig/sendConfigInput.js"></script>
</head>
<body>
<div id="tabdiv">
<form id="sendConfigForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="报送地址配置"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					 <td align="center">报送平台选择</td>
					 <td class="table_text">报送平台：</td>
					 <td colspan="3"><input class="easyui-combobox" name = "comId" id="comId" 
					 	        style="width: 164px;"></td>
					</tr>
					<tr>
						<td align="center">用户名，密码配置</td>
						<td class="table_text">报送用户名：</td>
						<td  align="left" >
							<input id = "sendUser" name="sendUser" class="table_input">
						</td>
						<td class="table_text" align="right">报送密码：</td>
						<td  align="left">
							<input id = "sendPass" name="sendPass" class="table_input">
						</td>
					</tr>
					<tr>
					 <td align="center">异步请求中发送业务量配置</td>
					 <td class="table_text">最大业务量：</td>
					 <td><input name="maxCount" id = "maxCount" class="table_input"></td>
					 <td class="table_text">最小业务量：</td>
					 <td colspan="2"><input name="minCount" id = "minCount" class="table_input" ></td>
					</tr>
					<tr>
					 <td align="center">访问API</td>
					 <td class="table_text">API地址：</td>
					 <td colspan="3"><input name="sendApi" id = "sendApi" class="table_input" style="width: 590px;"></td>
					</tr>
					<tr>
					 <td align="center">报送方式</td>
					 <td class="table_text">报送方式：</td>
					 <td colspan="3"><input name="sendType" style="width: 164px;"
					 class="easyui-combobox" id="sendType"></td>
					</tr>
					<tr>
					 <td align="center">承保拆单管理</td>
					 <td class="table_text">单次报送被保人数量：</td>
					 <td colspan="3"><input name="batchCount" class="table_input" id="batchCount" ></td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="saveSendInfo()" 
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