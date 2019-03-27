<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored ="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/ummp/xengin/msgConfigInput.js"></script>
<title>报文引擎配置</title>
</head>
<script type="text/javascript">
</script>
<body >
<div id="smsaccordion" class="easyui-panel">
<form id="xenginMainForm" name = "xenginMainForm">
	<div class="easyui-layout" fit="true" style="height: 680px;">
	<div region = "north" style="height: 130px">
	 <div id="smsaccordion" 
		 fit="true" 
		 title="引擎规则配置" 
		 class="easyui-panel"
		 iconCls="icon-ok" collapsible="true"
		 height: auto;>
		 <div class="top_table" style="padding-top: 5px;">
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="table_text" align="right">报送平台</td>
					<td  align="left">
						<input id = "platComId" name="platCom"
							    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
					<td class="table_text" align="right">业务类型</td>
					<td  align="left">
						<input id = "bussTypeId" name="bussType"
							    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
					</td>
					<td class="table_text" align="right" >报文类型</td>
					<td  align="left">
						<select id = "implType" name="implType"
							    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
					</td>
				</tr>
				<tr>
					<td class="table_text" align="right">报文格式</td>
					<td  align="left">
						<input id = "formatTypeId" name="formatType"
							    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
					<td class="table_text" align="right">报送方式</td>
					<td  align="left">
						<input id = "sendTypeId" name="sendType"
							    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
					</td>
					<td class="table_text" align="right">是否有效</td>
					<td  align="left">
						<input id = "statusId" name="status"
							    class="table_input easyui-validatebox" data-options="validType:'isBlank',width:205">
					</td>
				</tr>
			</table>
		 </div>
		 <div align="left">
			<a href="#" onclick="saveXEngin()" class="easyui-linkbutton e-cis_button" iconCls="icon-save">保存报文规则</a>
			<a href="#" onclick="scanXEngin()" class="easyui-linkbutton e-cis_button" iconCls="icon-print">浏览报文样式</a>
		 </div>
		 </div>
		 <div align="right"><font color="blue">此处下拉出现配置条件控件</font></div>
	</div>
	<div region="center">
	  <div>
		<table  class="top_table">
		 <tr>
		  <td class="table_text">报文描述</td>
		  <td class="table_text"><input class="table_input" style="width: 500px" name = "msgDesc" id = "msgDesc" value="报文描述"></td>
		  <td class="table_text">&nbsp;</td>
		 </tr>
		 <tr>
		  <td class="table_text">是否需要报文头</td>
		  <td class="table_text">
		   <textarea rows="1" cols="50" id = "headTitleId" name="headTitle"
		   class="table_input" style="width: 500px" ><?xml version="1.0" encoding="UTF-8"?></textarea>
		  </td>
		  <td class="table_text">
		  	<input type="radio" value = "1" name = "isTitle" checked="checked">是 
		  	<input type="radio" value = "0" name = "isTitle">否
		  </td>
		 </tr>
		 <tr>
		  <td class="table_text">临时节点</td>
		  <td class="table_text" style="text-align: left;">
		  	  <input id = "tempRootNodeId" name="tempRootNode"
					  class="easyui-combobox" style="width: 260px;"
					  onclick="fromTempNode()">
		      &nbsp;&nbsp;(备注：没有与业务关联或正在修改的节点)</td>
		  <td class="table_text">
		  	<a href = "#" class="easyui-linkbutton e-cis_button" iconCls="icon-delete" onclick="deleteTempNode()">删除</a>
		  </td>
		 </tr>
		</table>
	   </div>
	   <br>
	   <div>
	   <table>
	    <tr>
	     <td>
	     <div class="easyui-panel" style="height: 420px;">
	     <div align="center" style="padding-top: 1px;">节点树<hr color="lightgray"></span></div>
	      <ul id="msgTreeId" class="easyui-tree" 
	      	  style="height: 360px;width: 230px;padding-left: 20px;">
	      </ul>
	     </div>
	     
	     </td>
	     <td>
		 <div id="msgNodeDef" class="easyui-panel" style="height: 420px;width: auto;" align="left">
		 <fieldset class = "fieldset" style="width: 780px;height: auto;" >
		  <legend>节点定义</legend>
		  <table >
		   <tr>
		   	 <td>
		   	   <table>
		   	    <tr>
		   	     <td>
		   	     	<input type="hidden" name="nodeFid" id="nodeFid">
		   	     	<input type="hidden" name="nodeId" id="nodeId">
		   	     	节点 <input class="table_input" name="nodeCode" id="nodeCodeId" onkeyup="checkInner()" style="width: 220px"></td>
		   	 	 <td><a href="#" class="easyui-linkbutton e-cis_button" iconCls="icon-add"
		   	 	 	onclick="openAddAttri()">添加属性</a></td>
		   	 	 <td><a href="#" class="easyui-linkbutton e-cis_button" iconCls="icon-add" 
		   	 	 	onclick="openAddParam()">添加参数</a></td>
		   	 	 <td><a href="#" class="easyui-linkbutton e-cis_button" iconCls="icon-ok"  
		   	 	 	onclick="saveNode()">保存节点</a></td>
		   	    </tr>
		   	   </table>
		   	 </td>
		   </tr>
		   <tr>
		    <td><textarea class="table_inputarea" rows="8" cols="74" id="nodeSqlId"></textarea></td>
		    <td>
		     <table>
		      <tr align="left">
		       <td class="table_text" align="left">
		       	<input type = "radio"  name="msgNodeDef_NodeType" checked="checked" value = "1">SQL
		        <input type = "radio"  name="msgNodeDef_NodeType" value="2">手动 
		       </td>
		      </tr>
		      <tr align="left"><td class="table_text" align="left">
		      <a href = "#" class="easyui-linkbutton e-cis_button" iconCls="icon-reload" 
		      	 onclick="buildSonNodes()">生成子节点</a></td></tr>
		     </table>
		    </td>
		   </tr>
		   <tr>
		     <td colspan="4">
		   	  <div style="padding-left: 10px;display: ">
		   		<span><font color="gray">说明：所需参数以 #{XX} 或 '#{XX}' 引用，保存后选中节点添加参数定义</font></span>
		   	  </div>
		   	 </td>
		   	</tr>
		  </table>
		 </fieldset>
		 <br>
		 <div id="msgTreeId" style="height: auto;padding-left: 80px;width: 250px">
		   <ul id="thisSonTree" class="easyui-tree"></ul>
		 </div>
		</div>
	    </td>
	    </tr>
	   </table>
       </div>
	</div>
 </div>
 <div>
  <!-- 用于节点编辑时使用 ，保存完后清空 -->
  <input type="hidden" name="bussId" id = "bussId" value='${bussId}' readonly="readonly">
  <!-- 用于节点数的编辑和加载，保存后清空 -->
  <input type="hidden" name = "nodeTreeIds" id="nodeTreeIds" readonly="readonly">
  <!-- 添加节点属性信息 -->
  <div id="attriWin"></div>
  <!-- 添加节点参数信息 -->
  <div id="paramWin"></div>
 </div>
 </form>
</div>
</body>
</html>