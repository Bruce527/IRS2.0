<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/managecom/addManageComInit.js"></script>

<div id="tabdiv">
	<form id="addManageComForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="机构信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table" >
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<td class="table_text" align="right">核心机构编码：</td>
						<td align="left">
						<input id="manageCode" name="manageCode" class="table_input easyui-validatebox " validType="length[0,10]" required="true" style="width: 180px;">
						</td>
						<td class="table_text" align="right">机构部门代码：</td>
						<td align="left">
						<input id="manageInnerCode" name="manageInnerCode" validType="length[0,10]" required="true" class="table_input " value="" style="width: 180px;">
						</td>
						<td class="table_text" align="right">名称：</td>
						<td align="left">
						<input id="manageName"  name="manageName"  required="true" class="table_input easyui-validatebox"  value="" style="width: 180px;">
						</td>
					</tr>
					<tr>
						<td class="table_text" align="right">简称：</td>
						<td align="left" >
						<input id="manageNameShort" name="manageNameShort" class="table_input " value=""  style="width: 180px;"></td>
						<td class="table_text" align="right">英文简称：</td>
						<td align="left">
						<input id="manageEnnameShort" name="manageEnnameShort"   class="table_input " value="" style="width: 180px;">
						</td>
						
						<td class="table_text" align="right">状态：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="status" id="status" style="width: 184px;"></td>
					</tr>
					<tr>
					<td class="table_text" align="right">邮箱：</td>
						<td align="left">
						<input id="email" data-options="validType:'email'" name="email" class="table_input easyui-validatebox" value="" style="width: 180px;">
						</td>
						<td class="table_text" align="right">办公电话：</td>
						<td align="left">
						<input id="phone" name="phone" validType="length[0,13]" required="true" class="table_input " value="" style="width: 180px;">
						</td>
						<td class="table_text" align="right">办公地址：</td>
						<td align="left" >
						<input id="address" name="address" class="table_input easyui-validatebox" value="" validType="length[0,30]" required="true" style="width: 180px;"></td>
					</tr>
					<tr>
						<td class="table_text" align="right">开设时间：</td>
						<td align="left">
						<input id="openDate" name="openDate" type="text" class="table_input easyui-datebox" style="width: 184px;"></input>
						</td>
						<td class="table_text" align="right">关闭时间：</td>
						<td align="left">
						<input id="closeDate" name="closeDate" type="text" class="table_input easyui-datebox" style="width: 184px;"></input>
						</td>
						<td class="table_text" align="right">邮政编码：</td>
						<td align="left">
						<input id="zipcode" name="zipcode" validType="length[0,10]" required="true" class="table_input " value="" style="width: 180px;">
						</td>
					</tr>
					<tr>
						<td class="table_text" align="right">备注：</td>
						<td align="left">
						<input id="remark" name="remark" validType="length[0,30]" required="" class="table_input " value="" style="width: 180px;"> 
						</td>
						<td class="table_text" align="right">监管类型：</td>
						<td align="left">
						<input id="mmonitorType" name="mmonitorType" validType="length[0,10]" required="true" class="table_input " value="" style="width: 180px;">
						</td>
						<td class="table_text" align="right">监管机构编码：</td>
						<td align="left">
						<input id="mmonitorCode" name="mmonitorCode" validType="length[0,10]" required="true" class="table_input easyui-validatebox" value="" style="width: 180px;">
						</td>
						</tr>
						<tr>
						<td class="table_text" align="right">牌照类型：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="licenseType" id="licenseType" style="width: 184px;"></select>
						</td>
						<td class="table_text" align="right">上级机构编码：</td>
						<td align="left">
						<input id="fid" name="fid" validType="length[0,10]" required="true" class="table_input easyui-validatebox" value="" style="width: 180px;">
						</td>
						<td class="table_text" align="right">上级机构部门编码：</td>
						<td align="left">
						<input class="table_select easyui-combobox" name="innerFid" id="innerFid" style="width: 184px;">
						</td>
					</tr>
					
					
				</table>
				<div>
					<a href="#" onclick="addManageCom()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-add">新增</a>
				</div>
			</div>
		</div>
	</form>
</div>
