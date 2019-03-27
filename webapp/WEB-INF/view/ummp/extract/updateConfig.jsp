<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/extract/updateConfig.js"></script>
<script type="text/javascript" src="../js/commonutil.js"></script>
</head>

<body>
	<!-- 提数脚本配置 -->
	<div id="tabdiv2">
		<form id="getDataSqlConfigform">
			<input type="hidden" id="flag" name="flag" value="${flag}"/>
			<input type="hidden" id="PID" name="PID" value="${PID}"/>
			<input type="hidden" id="sqlId" name="sqlId" value="${sqlId}"/>
			<div id="smsaccordion2" class="easyui-panel" fit="true" title="提数脚本配置"
				iconCls="icon-ok" collapsible="true">
				<div class="top_table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="table_text" align="right">传输类型:</td>
							<td align="left"><input id="transportType" name="transportType" class="table_input" value="${transportType }"/></td>
							<td class="table_text" align="right">目标表名:</td>
							<td align="left"><input id="targetTableName"   name="targetTableName" class="table_input" value="${targetTableName }"/></td>
							<td class="table_text" align="right">算法编码:</td>
							<td align="left"><input id="sqlCode" name="sqlCode"  class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" value="${sqlCode }"/></td>
						</tr>
						<tr>
							<td class="table_text" align="right">数据源名称:</td>
							<td align="left"><input id="dataSourceName" name="dataSourceName" class="table_input " value="${dataSourceName }"/></td>
							<td class="table_text" align="right">目标数据库:</td>
							<td align="left"><input id="targetDatabase"   name="targetDatabase" class="table_input" value="${targetDatabase }"/></td>
							<td class="table_text" align="right">SQL类型:</td>
							<td align="left"><input id="sqlType" name="sqlType" class="table_input" class="table_TextArea easyui-validatebox" data-options="required:true,validType:'isBlank'" value="${sqlType }"/></td>
						</tr>
						<tr>
							<td class="table_text" align="right">有效性:</td>
							<td align="left"><input id="validity" name="validity" class="table_input" value="${validity }"/></td>
							<td class="table_text" align="right">执行顺序:</td>
							<td align="left"><input id="order" name="order" class="easyui-numberbox table_input easyui-validatebox" data-options="required:true,validType:'isBlank',min:1" value="${order }"></td>
							<td  class="table_text">算法描述:</td>
							<td  align="left"><input name="desc" id="desc" class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'"value="${desc }"/></td>
						</tr>
						<tr>
							<td  class="table_text">查询SQL:</td>
							<td  align="left" colspan="5" >
							<textarea  id="sql" name="sql" rows="30" cols="109"  
							style="margin-left: 10px; border: 1px solid #abcdef;"  
							class="table_TextArea easyui-validatebox" 
							data-options="required:true,validType:'isBlank'">${sql}</textarea>
							</td>
						</tr>
					</table>
					<div>
						<a href="#" onclick="commit()" class="easyui-linkbutton e-cis_button" iconCls="icon-save">提交</a>
						<a href="#" onclick="getSqlParams()" class="easyui-linkbutton e-cis_button" iconCls="icon-save">获取sql参数</a>
					</div>
					<div id="getSqlParams"></div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>