<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/ses/ExpinfoImport.js"></script>
<script type="text/javascript" src="../js/commonutil.js"></script>
</head>

<body>
	<div id="tabdiv">
		<form id="extractForm" style="margin-top: 15px;">
			<div id="smsaccordion" class="easyui-panel" fit="true" title="明细清单提取"
				collapsible="true">
				<div class="top_table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="table_text" align="right">传输类型</td>
							<td><input id="transType" name="transType"
								class="table_input easyui-validatebox"
								data-options="validType:'isBlank',width:205" /></td>
							<td class="table_text" align="right">传输描述</td>
							<td><input id="transDesc" name="transDesc"
								class="table_input" readonly="readonly" style="width: 200px" /></td>
							<td class="table_text" align="right">清单提取年份:<select
								class="easyui-combobox table_select" name="year" id="year"
								style="width: 150px;"></select>(单位：年)
							</td>

						</tr>
					</table>
					<div>
						<a href="#" onclick="execute()"
							class="easyui-linkbutton e-cis_button" iconCls="icon-search">提数</a>
					</div>
				</div>
			</div>
		</form>
	</div>

	<form id="calculForm" style="margin-top: 15px;">
		<div id="tabdiv1">
			<div id="smsaccordion" class="easyui-panel" fit="true" title="数据指标计算"
				collapsible="true">
				<div class="top_table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>数据计算年份 :<select
								class="easyui-combobox table_select" name="years" id="years"
								style="width: 150px;"></select>(单位：年)</td>
						</tr>
					</table>
					<div>
						<a href="#" onclick="calculationData()"
							class="easyui-linkbutton e-cis_button" iconCls="icon-search">计算</a>
					</div>
				</div>
			</div>
		</div>
	</form>
	
</body>
</html>