<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/core/user/updateUserInit.js"></script>

<div id="tabdiv1">
	<form id="updateUserForm1" method="post">
		<div id="smsaccordion1" class="easyui-panel" fit="true" title="用户信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="table_text" align="right">用户名称：</td>
						<td align="left">
						<input id="username" name="username" class="table_input easyui-validatebox" validType="length[0,10]" required="true" value="${defUser.username}" >
						</td>
						<td class="table_text" align="right">用户编码：</td>
						<td align="left">
						<input id="usercode" readonly="readonly" name="usercode" validType="length[0,10]" required="true" class="table_input easyui-validatebox" value="${defUser.usercode}">
						</td>
						<td class="table_text" align="right">管理机构：</td>
						<td align="left">
						<select class="table_select easyui-combobox" name="companyId" id="companyId"  value="${defUser.companyId }" ></select></td>
					</tr>
					<tr>
						<td class="table_text" align="right">操作人员：</td>
						<td align="left">
						<input id="creatorCode"  readonly="readonly" name="creatorCode" validType="length[0,10]" required="true" class="table_input easyui-validatebox" value="${userCode}">
						</td>
						<!-- <td class="table_text" align="right">用户密码：</td>
						<td align="left" >
						<input id="password" name="password" required="true"  class="table_input easyui-validatebox" value="" validType="length[0,20]" value="${password}">
						</td> -->
						<%-- <td class="table_text" align="right">认证编码：</td>
						<td align="left">
						<input id="empowerCode" name="empowerCode" validType="length[0,10]" required="true" class="table_input easyui-validatebox" value="${defUser.empowerCode}">
						</td> --%>
						<td class="table_text" align="right">用户描述：</td>
						<td align="left">
						<input id="userDescribe" name="userDescribe" class="table_input easyui-validatebox" value="${defUser.userDescribe}">
						</td>
						<td class="table_text" align="right">用户状态：</td>
						<td align="left">
						<select class="easyui-combobox table_select" name="userState" id="userState" value="${defUser.userState}" ></select>
						</td>
						<!--<td class="table_text" align="right">附件：</td>
						<td align="left">
						<input type="file" name="fileToUpload" id="fileToUpload" multiple="multiple" onchange="fileSelected();" />
						<a href="#" onclick="addUser()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-redo">上传</a>
						
						</td>-->
					</tr>
					<tr>
						<td class="table_text" align="right">邮箱地址：</td>
						<td align="left">
						<input id="email" data-options="required:true,validType:'email'" name="email" class="table_input easyui-validatebox" value="${defUser.email}">
						</td>
					</tr>
					<!-- <tr>
						<td class="table_text" align="right">用户名称：</td>
						<td  align="left">
							<input id="username" name="username" class="table_input easyui-validatebox" validType="length[0,10]" required="true" value="${name}">
						</td>
						<td class="table_text" align="right">用户编码：</td>
						<td  align="left">
							<input id="usercode" name="usercode" class="table_input easyui-validatebox" validType="length[0,10]" required="true" value="${code}">
						</td>
						<td class="table_text" align="right">密码：</td>
						<td  align="left">
							<input id="password" name="password" class="table_input easyui-validatebox" validType="length[0,20]" required="true" value="">
						</td>
					</tr>
					<tr>
						<td class="table_text" align="right">管理机构：</td>
						<td align="left">
							<select class="table_select easyui-validatebox" name="companyId" id="companyId" >
							</select>
						</td>
					</tr> -->

				</table>
				<input type="hidden" id="id" name="id" value="${defUser.id}">
				<input type="hidden" id="companyIdd" name="companyId" value="${defUser.companyId}">
				<input type="hidden" id="isLockk" name="isLockk" value="${defUser.isLock}">
				<input type="hidden" id="userStatee" name="userStatee" value="${defUser.userState}">
				
				<div>
					<a href="#" onclick="updateUser()" class="easyui-linkbutton e-cis_button" iconCls="icon-add">修改</a>
				</div>
			</div>
		</div>
	</form>
</div>
