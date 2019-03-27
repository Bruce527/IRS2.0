<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/report/listReportInit.js"></script>

<div id="tabdiv2">
	<form id="userForm2">
		<div id="smsaccordion" class="easyui-panel"
			fit="false" title="业务提数结果统计"
			iconCls="icon-ok" collapsible="true" style="width:1160px;">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">报送平台</td>
						<td><input id="platComIdd" name="comId" class="table_input easyui-validatebox" ></input></td>
						<td class="table_text" align="right">传输类型</td>
						<td><input id="bussTypeIdd" name="bussType"  class="table_input easyui-validatebox" style="width:206px"></input></td>
					</tr>
					<tr>
						<td class="table_text" align="right">提数起期</td>
						<td align="left">
						<input id="startDatee" name="startDate" type="text" class="table_input easyui-datebox" editable="false" ></input> 
						</td>
						<td class="table_text" align="right">提数止期</td>
						<td align="left">
						<input id="endDatee" name="endDate" type="text" class="easyui-datebox table_input"  editable="false" style="width:206px"></input>
						</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm2()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchUser2()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
					<a href="#" onclick="derive2()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">导出</a>
				</div>
			</div>
		</div>
	</form>
	
</div>
<div style="margin-top: 3px;width: 1160px;" id="tabdiv">
	<table id="userTable2"></table>
</div>
<div id="usertab" class="easyui-tabs" fit="false" border="ture" plain="true" style="height:60px;width:1160px;"></div>
<div id="tabdiv" >
	<form id="userForm">
		<div id="smsaccordion" class="easyui-panel" 
		fit="false" title="业务报送结果统计" 
			iconCls="icon-ok" collapsible="true" style="width:1160px;">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">报送平台</td>
						<td><input id="platComId" name="comId" class="table_input" ></input></td>
						<td class="table_text" align="right">业务类型</td>
						<td><input id="bussTypeId" name="bussType"  class="table_input" style="width:206px"></input></td>
					</tr>
					<tr>
						<td class="table_text" align="right">报送起期</td>
						<td align="left">
						<input id="startDate" name="startDate" type="text" class="table_input easyui-datebox" editable="false" ></input> 
						</td>
						<td class="table_text" align="right">报送止期</td>
						<td align="left">
						<input id="endDate" name="endDate" type="text" class="easyui-datebox table_input"  editable="false" style="width:206px"></input>
						</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm1()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchUser1()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
					<a href="#" onclick="derive1()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">导出</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 3px;width: 1160px;" id="tabdiv">
	<table id="userTable"></table>
</div>
<!-- <div id="tabdiv2">
	<form id="userForm2">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="业务报送明细"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">数据提取起期：</td>
						<td align="left">
						<input id="startDate" name="startDate" type="text" class="table_input easyui-datebox"  editable="false"></input> 
						</td>
						<td class="table_text" align="right">数据提取止期：</td>
						<td align="left">
						<input id="endDate" name="endDate" type="text" class="easyui-datebox table_input" editable="false"></input>
						</td>
					</tr>
					<tr>
						<td class="table_text" align="right">业务类型：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="companyId" id="companyId" ></input>
						</td>
						<td class="table_text" align="right">业务状态：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="bussType" id="bussType" ></input>
						</td>
					</tr>
					<tr>
						<td class="table_text" align="right">业务号码：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="companyId" id="companyId" ></input>
						</td>
					</tr>
				</table>
				<div>
					<a href="#" onclick="clearForm2()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchUser2()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
					<a href="#" onclick="derive2()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">导出</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div style="margin-top: 3px;" id="tabdiv">
	<table id="userTable2"></table>
</div> -->
