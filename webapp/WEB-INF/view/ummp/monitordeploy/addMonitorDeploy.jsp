<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"src="../js/ummp/monitordeploy/addMonitorDeploy.js"></script>
<script type="text/javascript" src="../js/commonutil.js"></script>
</head>

<body>
	
	<!-- 数据传输前配置信息 -->
	<div id="tabdiv2">
		<form id="dataTransportAgoConfigForm">
			<div id="smsaccordion2" class="easyui-panel" fit="true" title="监控算法配置"
				iconCls="icon-ok" collapsible="true" style="height:auto;">
				<div class="top_table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="table_text" align="left">有效性：</td>
							<td align="left">
							<input class="table_select easyui-combobox" name="esStatus" id="esStatus" ></input>
							</td>
							<td class="table_text" align="left">数据源名称：</td>
							<td align="left">
							<input class="table_select easyui-combobox" name="jdbcCode" id="jdbcCode" ></input>
							</td>
							<!-- <td class="table_text" align="left">提取类型：</td>
							<td align="left">
							<input class="table_select easyui-combobox" name="bussType" id="bussType" ></input>
							</td> -->
							<td class="table_text" align="right">算法编码：</td>
							<td><input style="width:152px" name="sqlCode" id="sqlCode"  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'"></td>
						</tr>
						<tr>
							<td  class="table_text" align="left">事件SQL:</td>
							<td  align="left" colspan="8" style="width:90%" ><textarea  id="sqlInfo" name="sqlInfo" rows="20" cols="100"  style="margin-left: 10px;border:1px solid #abcdef;" class="table_TextArea easyui-validatebox" data-options="required:true,validType:'isBlank'"></textarea></td>	
						</tr>
						<tr>
							<td  class="table_text" align="left">事件描述:</td>
							<td  align="left" colspan="8"  ><input style="width:615px" name="sqlDesc" id="sqlDesc" class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'"></td>
						</tr>
					</table>
					<div>
						<a href="#" onclick="definition()" class="easyui-linkbutton e-cis_button" iconCls="icon-save">定义</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div id="addSqlParam">
		
	</div>
</body>
</html>