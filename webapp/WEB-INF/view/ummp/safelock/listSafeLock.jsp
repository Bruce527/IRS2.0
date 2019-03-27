<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/safelock/listSafeLock.js"></script>
<style type="text/css">
.selectRow{
	background-color: gray;
}
</style>
<title>Safe Lock Control</title>
</head>
<div id="tabdiv"  class="easyui-panel">
	<form id="safeLockForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="安全锁控中心"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td rowspan="2" width="180px"><input class="easyui-combobox table_text" name="comId" id="comId" style="width: 160px;"></td>
						<td class="table_text" align="right" width="160px">提数锁控: </td>
						<td onmouseover="overRow(this)" onmouseout="outRow(this)" class="table_text" style="text-align: left;">
							<a class="easyui-linkbutton" id="extractLock" iconCls = 'icon-redo' onclick="extractLock();">锁定</a> 
							<a class="easyui-linkbutton" id="extractUnLock" iconCls = 'icon-undo' onclick="extractUnLock();">解锁</a>
						</td>
					</tr>
					<tr>
					  <td class="table_text" align="right">报送锁控: </td>
					  <td onmouseover="overRow(this)" onmouseout="outRow(this)" class="table_text" style="text-align: left;">
					  	<a class="easyui-linkbutton" id="submitLock" iconCls = 'icon-redo' onclick="submitLock();">锁定</a> 
					  	<a class="easyui-linkbutton" id="submitUnLock" iconCls = 'icon-undo' onclick="submitUnLock();">解锁</a>
					  </td>
					</tr>
					<tr>
					  <td><input class="easyui-combobox table_text" name="loginType" id="loginType" style="width: 160px;"></td>
					  <td class="table_text" align="right">认证方式锁控: </td>
					  <td onmouseover="overRow(this)" onmouseout="outRow(this)" class="table_text" style="text-align: left;">
					  	<a class="easyui-linkbutton" id="loginTypeLock" iconCls = 'icon-redo' onclick="loginTypeLock();">锁定</a> 
					  	<a class="easyui-linkbutton" id="loginTypeUnLock" iconCls = 'icon-undo' onclick="loginTypeUnLock();">解锁</a>
					  </td>
					</tr>	
				</table>
			</div>
		</div>
	</form>
</div>
</html>