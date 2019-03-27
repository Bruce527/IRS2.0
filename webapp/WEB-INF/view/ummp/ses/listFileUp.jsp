<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/ummp/ses/listFileUpInit.js"></script>
<%String path=application.getRealPath("/"); %>

<div>
<div id="tabdiv"  class="easyui-panel">
	<form id="userForm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="文件上传"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table">
				<input type="hidden" name="realPath" id="realPath" value="<%=path %>">
					
				<div>
					<a href="#" onclick="creatFile()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-reload">生成</a>
					<a href="#" onclick="uploadFile()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-search">上传</a>
				</div>
			</div>
		</div>
	</form>
</div>

<div style="margin-top: 3px;" id="tabdiv">
	<table id="UserFileTable"></table>
</div>