<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/extract/addUpdate.js"></script>
<script type="text/javascript" src="../js/commonutil.js"></script>
</head>

<script type="text/javascript">
	
</script>
<body>
	<div id="tabdiv">
		<form id="transportInfoForm">
			<div id="mappingconfigId" class="easyui-panel" fit="true"
				title="传输信息" iconCls="icon-ok" collapsible="true" style="height: 120px">
				<div class="top_table" style="width: 100%;height: 80px;" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td  class="table_text" align="right">传输类型:</td>
							<td  align="left"><input name="excCode" id="excCode" class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" style="width: 200px" onchange="lowerTOupper()"></td>
							<td  class="table_text" align="right">传输描述:</td>
							<td  align="left"><input name="excDesc" id="excDesc" class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" style="width: 200px"></td>
							<td class="table_text" align="right">执行排序:</td>
							<td align="left"><input id="excNum" name="excNum" class="easyui-numberbox table_input easyui-validatebox" data-options="required:true,validType:'isBlank',min:1" style="width: 200px"></td>
						</tr>
						<tr>
							<td class="table_text" align="right">报送平台</td>
							<td  align="left">
								<input id = "platComId" name="comId"
									    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
							<td class="table_text" align="right">是否有效</td>
							<td  align="left">
								<input id = "statusId" name="rcStatus"
									    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
							</td>
						</tr>
					</table>
				</div>
				<div>
			 		<a href="#" onclick="save()" class="easyui-linkbutton e-cis_button" iconCls = "icon-add">保存</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>