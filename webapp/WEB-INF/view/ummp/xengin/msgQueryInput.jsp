<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored ="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/xengin/msgQueryInput.js"></script>
<title>报文引擎查询</title>
</head>
<script type="text/javascript">
</script>
<body >
<div id="smsaccordion" class="easyui-panel">
<form id="msgQueryForm" name = "msgQueryForm">
	<div class="easyui-layout" fit="true" style="height: 680px;">
	<div region = "north" style="height: 130px">
	 <div id="smsaccordion" 
		 fit="true" 
		 title="引擎规则查询" 
		 class="easyui-panel"
		 iconCls="icon-ok" collapsible="true"
		 height: auto;>
		 <div class="top_table" style="padding-top: 5px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="table_text" align="right">报送平台</td>
					<td  align="left">
						<input id = "platComId" name="platCom"
							    class="easyui-combobox" data-options="validType:'isBlank',width:205">
					<td class="table_text" align="right">业务类型</td>
					<td  align="left">
						<input id = "bussTypeId" name="bussType"
							    class="easyui-combobox" data-options="validType:'isBlank',width:205">
					</td>
					<td class="table_text" align="right">报文定义</td>
					<td  align="left">
						<input id = "implType" name="implType"
							    class="easyui-combobox" data-options="validType:'isBlank',width:205">
					</td>
				</tr>
				<tr>
					<td class="table_text" align="right">报文格式</td>
					<td  align="left">
						<input id = "formatTypeId" name="formatType"
							    class="easyui-combobox" data-options="validType:'isBlank',width:205">
					<td class="table_text" align="right">报送方式</td>
					<td  align="left">
						<input id = "sendTypeId" name="sendType"
							    class="easyui-combobox" data-options="validType:'isBlank',width:205">
					</td>
					<td class="table_text" align="right">是否有效</td>
					<td  align="left">
						<input id = "statusId" name="status"
							    class="easyui-combobox" data-options="validType:'isBlank',width:205">
					</td>
				</tr>
			</table>
		 </div>
		 <div align="left">
			<a href="#" onclick="resetForm()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a>
			<a href="#" onclick="msgQuery()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">查询</a>
		 </div>
		 </div>
		 <div align="right"><font color="blue">此处下拉出现查询条件控件</font></div>
	</div>
	<div region="center">
	  <div>
		<table id="msgQueryGrid"></table>
      </div>
	</div>
 </div>
 <div>
  <!-- 用于节点编辑时使用 ，保存完后清空 -->
  <input type="hidden" name="bussId" id = "bussId" value='${bussId}'>
 </div>
 </form>
</div>
</body>
</html>