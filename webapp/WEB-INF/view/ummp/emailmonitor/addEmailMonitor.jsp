<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript"
	src="../js/ummp/emailmonitor/addEmailMonitorInit.js"></script>

<div id="tabdiv">
	<form id="addEmailMonitorForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="新增邮箱"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
<!-- 						<td class="table_text" align="right">邮箱服务器地址：</td> -->
<!-- 						<td><input name="webAddress" id="webAddress" -->
<!-- 							class="table_input"></td> -->
<!-- 						<td class="table_text" align="right">服务器端口：</td> -->
<!-- 						<td align="left"><input name="webPort" id="webPort" -->
<!-- 							class="table_input"></td> -->
						<td class="table_text" align="right">邮箱用户名：</td>
						<td align="left"><input name="accountUser" id="accountUser"
							class="easyui-validatebox table_input" required="true"></td>
<!-- 					</tr> -->
<!-- 					<tr> -->
						<td class="table_text" align="right">邮箱地址：</td>
						<td><input name="accountAddr" id="accountAddr" data-options="required:true,validType:'email'"
							class="easyui-validatebox table_input" required="true"></td>
<!-- 						<td class="table_text" align="right">邮箱密码：</td> -->
<!-- 						<td align="left"><input name="accountPass" id="accountPass" -->
<!-- 							class="table_input"></td> -->
<!-- 						<td class="table_text" align="right">是否有效：</td> -->
<!-- 						<td align="left"><select class="easyui-combobox table_select" -->
<!-- 							name="erStatus" id="erStatus"></select></td> -->
					</tr>
				</table>
				<div>
					<a href="#" onclick="addEmailMonitor()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-save">保存</a>
				</div>
			</div>
		</div>
	</form>
</div>
