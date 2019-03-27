<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/platform/quartz/addSchedulerInit.js"></script>
<div id="tabdiv">
	<form id="addSchedulerForm" method="post">
		<div id="smsaccordion" class="easyui-panel" style="width: 1121px; height: 160px; display: block;" fit="true" title="作业计划信息"
			iconCls="icon-ok" collapsible="true">
		<div class="top_table" >
		<table width="100%"  border="0" cellspacing="0" cellpadding="0" >
			<tr>
						<td class="table_title" align="right">作业:</td>
						<td class="table_td_input">
							<input class = "table_input" name="job_name"  id ="job_name" style="width:170px;"/>
						</td>
						
						<td class="table_title" align="right">作业名称：</td>
						<td class="table_td_input">
							<input name="homeworkName" id="homeworkName" class="table_input" readonly="readonly">
						</td>
			</tr>
		</table>
		<div id="templatetriggerdiv">
			<table width="100%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="table_title" >模板：</td>
				<td class="table_td_input">
				<select id="template_type" class="easyui-combobox table_select" name="template_type"> <option value="template1" selected>每天定时</option> </select>
				</td>
				<td class="table_title" >执行时间：</td>
				<td class="table_td_input">
				<input type="text" id="executeTime" name="executeTime"   size="20"  >
				</td>
			</tr>
			<tr>
				<td class="table_title">计划描述：</td>
				<td class="table_td_input">
					<input id="tempPlanToDescribe" name="tempPlanToDescribe"   class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" />
				</td>
			</tr>
			</table>
		</div>
		<div id="crontriggerdiv">
			<table width="100%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="table_title" >Cron表达式：</td>
				<td class="table_td_input">
				<input id="cron_expression" name="cron_expression" value=""  class="table_input" >
				</td>
				<td class="table_title">计划描述：</td>
				<td class="table_td_input">
					<input id="cronlanToDescribe" name="cronlanToDescribe"   class="table_input"  />
				</td>
			</tr>
			</table>
		</div>
		<div id="simpletriggerdiv">
		<table width="100%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="table_title" >开始时间：</td>
				<td class="table_td_input">
				<input  class="easyui-datetimebox table_input" id="startTime" name="startTime"  style="width:170px;"  data-options="required:true,editable:false "> 
				</td>
				<td class="table_title" >结束时间：</td>
				<td class="table_td_input">
				<input  class="table_input easyui-datetimebox" id="endTime" name="endTime" data-options="editable:false" > 
				</td>
			</tr>
			<tr>
				<td class="table_title" >执行次数：</td>
				<td class="table_td_input">
				<input type="text" id="repeatCount" name="repeatCount" style="width:170px;" class = "easyui-numberspinner" >
				 <a href="#" title="表示调度启动后执行多少次结束，-1是无限循环" class="easyui-tooltip">Tip（执行次数）</a> 
				</td>
				<td class="table_title" >执行间隔：</td>
				<td class="table_td_input">
				<input type="text" id="repeatInterval" class="easyui-numberbox table_input" style="width: 100px;" name="repeatInterval"> 
				<select id="unit" class="easyui-combobox table_select" style="width: 50px;" name="unit" >
							<option value="1000">秒</option>
							<option value="60000">分</option>
							<option value="3600000">时</option>
							<option value="86400000" selected="selected">天</option>
				</select>
				 <a href="#" title="表示调度间隔多长时间执行一次" class="easyui-tooltip">Tip（执行间隔）</a> 
				</td>
			</tr>
			<tr>
				<td class="table_title">计划描述：</td>
				<td class="table_td_input">
					<input id="planToDescribe" name="planToDescribe"  style="width:165px;" class="table_input easyui-validatebox" data-options="required:true,validType:'isBlank'" />
				</td>
				<td class="table_title">&nbsp;</td>
				<td class="table_td_input">
					<input id="planToDescribe" type="hidden" name="planToDescribe"  class="table_input" />
				</td>
			</tr>
			<!-- 
			<tr>
				<td class="table_title" >延迟运行时间：</td>
				<td class="table_td_input">
				<input type="text" id="delayOperationTime" class="easyui-numberbox table_input" style="width: 100px;" name="delayOperationTime" data-options="min:1" > 
				<select id="delayOperationTimeUnit" class="easyui-combobox table_select" style="width: 50px;" name="delayOperationTimeUnit" >
							<option value="1">秒</option>
							<option value="60" selected="selected">分</option>
							<option value="3600">时</option>
							<option value="86400" >天</option>
				</select>
				<td class="table_title">延迟运行次数：</td>
				<td class="table_td_input">
					<input id="trydelayoperationcount"  name="trydelayoperationcount"  class="easyui-numberbox table_input" data-options="min:1" />
				</td>
			</tr>
			 -->
			</table>
		</div>
		<div style="margin-top: 5px;">
			<a href="#" onclick="clearForm()" class="easyui-linkbutton e-cis_button" iconCls="icon-reload">清空</a> 
			<a href="#" onclick="addScheduler()" class="easyui-linkbutton e-cis_button" iconCls="icon-add">保存</a>
		</div>
	</div>
	</div>
  </form>
</div>

<div style="margin-top: 5px;" id="tabdiv">
	<table id="verifyTable"></table>
</div>
