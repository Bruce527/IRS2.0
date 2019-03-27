<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../js/ummp/submit/handSubmit.js"></script>
<script type="text/javascript" src="../js/common.js"></script>

<!-- 报送参数 -->
<div id="tabdiv1" >
		<form id="submitForm" style="margin-top: 10px;">
			<div id="smsaccordion" class="easyui-panel" fit="true" title="报送参数" iconCls = "icon-ok"
				 collapsible="true">
				<div class="top_table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="table_text" align="right">报送平台</td>
							<td><input id="platComId" name="platCom" class="table_input easyui-validatebox" data-options="validType:'isBlank',width:184"></input></td>
							<td class="table_text" align="right">业务类型</td>
							<td><input id="bussTypeId" name="bussType"  class="table_input easyui-validatebox"  data-options="validType:'isBlank',width:210"></input></td>
							<td class="table_text" align="right">起始日期</td>
							<td align="left"><input id = "startDate" name="startDate"   style="width: 182px;">
							
						</tr>
						<tr>
							<td class="table_text" align="right">批次号</td>
							<td><input name="batchNo" id="batchNo" class="table_input" style="width:180px"/></td>
							<td class="table_text" align="right">业务号</td>
							<td><input name="bussNo" id="bussNo" class="table_input" style="width:206px"></td>
							<td class="table_text" align="right">终止日期</td>
							<td  align="left"><input id="endDate" name="endDate"   style="width: 182px;"></td>
							
						</tr>
					</table>
				</div>
			</div>
		</form>
	</div>

<!-- 功能按钮 -->
<div style="margin-top: 10px;">
	<a href="#" onclick="clearForm()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a> 
	<a href="#" onclick="execute()" class="easyui-linkbutton e-cis_button" iconCls="icon-search">执行</a>
</div>

<div style="margin-top:15px;" id="tabdiv2">
	<table id="t_def_action_return"></table>
</div>
<div style="margin-top:15px;" id="tabdiv6">
	<table id="listTableHand"></table>
</div>
<div align="center" name=sss id = sss></div>

