<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/emailmonitor/listMonitorNotice.js"></script>
<title>ListMonitorNotice</title>
</head>
<body>
<div id="tabdiv">
	<div id="smsaccordion" class="easyui-panel" fit="false" title="监控事件包"
		iconCls="icon-ok" collapsible="true" >
		<div class="top_table">
			<table border="0" cellspacing="5" cellpadding="2">
				<tr>
					<td class="table_text" align="right">请选择监控事件包，然后配置发送和抄送 </td>
					<td><select class="easyui-combobox table_select"
						name="monitorCode" id="monitorCode" style="width: 204px"></select></td>
						<td><a href="#" onclick="sendEmail()" id="sendEmail"
						class="easyui-linkbutton e-cis_button" iconCls="icon-ok">发送</a></td>
						<td><a href="#" onclick="downloadMonitor()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-print">下载</a></td>
				</tr>
			</table>
		</div>
	</div>
   <div id="smsaccordion" class="easyui-panel" fit="false" collapsible="true">
    <table>
     <tr>
     	<td rowspan="2" valign="top"><table id="emailMonitorTable"></table></td>
     	<td><table id="NoticeMainTable"></table></td>
     </tr>
     <tr>
      <td colspan="1"><table id="NoticeAddTable"></table></td>
     </tr>
    </table>
	</div>
</div>
</body>
</html>