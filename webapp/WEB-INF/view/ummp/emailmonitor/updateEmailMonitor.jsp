<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript"
	src="../js/ummp/emailmonitor/updateEmailMonitorInit.js"></script>

<div id="tabdiv">
	<form id="updateEmailMonitorForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="修改邮箱"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">邮箱账户：</td>
						<td align="left"><input name="accountUser" id="accountUser"
							class="table_input" value="${ACCOUNTUSER}"></td>
						<td class="table_text" align="right">邮箱地址：</td>
						<td><input name="accountAddr" id="accountAddr" data-options="required:true,validType:'email'"
							class="table_input" value="${ACCOUNTADDR}"></td>
					</tr>
				</table>
				<input type="hidden" id="id" name="id" value="${ID}">
				<div>
					<a href="#" onclick="updateEmailMonitor()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-save">保存</a>
				</div>
			</div>
		</div>
	</form>
</div>
