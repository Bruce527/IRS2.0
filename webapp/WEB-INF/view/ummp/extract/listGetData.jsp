<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/extract/listGetData.js"></script>
<script type="text/javascript" src="../js/commonutil.js"></script>
</head>

<script type="text/javascript">
	
</script>
<body>
	<div id="tabdiv"  class="easyui-panel">
		<form id="transportInfoForm">
			<div id="mappingconfigId" class="easyui-panel" fit="true"
				title="传输信息" iconCls="icon-ok" collapsible="true">
				<div class="top_table" style="width: 100%;" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="table_text" align="right">报送平台</td>
							<td  align="left">
								<input id = "platComId" name="comId"
									    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205"></td>
							<td  class="table_title">传输类型</td>
							<td  align="left"><input name="transportType" id="transportType" class="table_input" style="width: 200px;"></td>
							<td  class="table_title">传输描述</td>
							<td  align="left"><input name="transportDesc" id="transferDescribe" class="table_input" style="width: 250px;"></td>
						</tr>
					</table>
					<a href="#" onclick="resetForm()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
					<a href="#" onclick="searchTransportList()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
				</div>
			</div>
		</form>
	</div>
	
	<div style="margin-top: 10px; id="tabdiv">
		<table id="listTable"></table>
	</div>
	
	
</body>
</html>