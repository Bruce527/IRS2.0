<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/emailmonitor/listEmailMonitorInit.js"></script>

<div id="tabdiv">
	<form id="emailMonitorForm">
		<div id="smsaccordion" class="easyui-panel" fit="false"
			collapsible="true"  title="发送邮件配置">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">服务器地址：</td>
						<td><input name="webAddress" id="webAddress" required="true"
							class="table_input easyui-validatebox"  style="width: 180px;"></td>
						<td class="table_text" align="right">服务器端口：</td>
						<td align="left"><input name="webPort" id="webPort"
							class="table_input easyui-validatebox" required="required" style="width: 180px;"></td>
						<td class="table_text" align="right">邮箱账户：</td>
						<td align="left"><input name="accountUser" id="accountUser"
							class="table_input easyui-validatebox" required="required" style="width: 180px;"></td>
					</tr>
					<tr>
						<td class="table_text" align="right">邮箱地址：</td>
						<td><input name="accountAddr" id="accountAddr"
							class="table_input easyui-validatebox" required="required" style="width: 180px;"></td>
						<td class="table_text" align="right">邮箱密码：</td>
						<td align="left"><input type="password" name="accountPass" id="accountPass"
							class="table_input easyui-validatebox" required="required" style="width: 180px;"></td>
						<td class="table_text" align="right">是否有效：</td>
						<td align="left"><select class="easyui-combobox table_select"
							name="erStatus" id="erStatus"  style="width: 184px;"></select></td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearEmail()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="saveEmail()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-save">保存</a>
				</div>
			</div>
		</div>
	</form>
</div>