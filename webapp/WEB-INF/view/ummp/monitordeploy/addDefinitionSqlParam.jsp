<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

</script>
<body>
	<div class="top_table" align="center" style="width:300px;height:auto;padding-left: 2px">
	     <br>
	     <form id = "nodeParamForm">
		 <table class="easyui-datagrid" id= "npdg" style="width:1000px;height:auto;"
		 		data-options="title:'sql参数',
		 		url:'initParamUrl?id=<%=request.getParameter("id")%>',
				striped : true,
				idField : 'id',
				height : 200,
				width : 1000,
				method : 'get',
				rownumbers:true,
				iconCls : 'icon-edit',
				singleSelect : true,
				onClickRow : function(rowIndex,rowData){onClickParamRow(rowIndex,rowData)},
				fitColumns : false">
			<thead> 
			 <tr>
			  	<th data-options="field:'id',width:80,align:'center',hidden:true">ID</th>
			  	<th data-options="field:'paramCode',width:100,align:'center'">参数编码</th>
		 		<th data-options="field:'paramName',width:100,align:'center'">参数名称</th>
		 		<th data-options="field:'paramType',width:100,align:'center'">参数类型</th>
		 		<th data-options="field:'paramValueType',width:80,align:'center'">参数值类型</th>
		 		<th data-options="field:'paramValue',width:350,align:'left'">参数值</th>
		 		<th data-options="field:'paramSubType',width:100,align:'center'">参数域</th>
			 </tr>
			</thead>
		 </table>
		 <table style="width: 800px;">
		  <tr>
		   <td class="table_text" align="left">参数编码</td>
		   <td><input class="table_input" name="paramCode" id = "paramCodeId" style="width: 180px"></td>
		   <td class="table_text" align="left">参数名称</td>
		   <td><input class="table_input" name="paramName" id = "paramNameId" style="width: 180px"></td>
		  </tr>
		  <tr>
		  </tr>
		  <tr>
		   <td class="table_text" align="left">参数类型</td>
		   <td><input class="easyui-combobox" id = "paramTypeId" style="width: 183px;"
		   	   data-options="url:'../query/codeQuery?codetype=PARAM_TYPE',
		   	   valueField:'code',
		  	   textField:'codeName',
		  	   panelHeight:100,
		  	   onSelect:function(){
			   	changeParamType();
			   },
		  	   onLoadSuccess:function(r){
				var data = $('#paramTypeId').combobox('getData');
				if(data.length > 0){
					$('#paramTypeId').combobox('setValue',data[0].code);
					$('#paramTypeId').combobox('setText',data[0].codeName);
					$('#paramType').val(data[0].code);
				}
		  	   }"></td>
		   <td class="table_text" align="left">参数值类型</td>
		   <td><input class="easyui-combobox" id = "paramValueTypeId" style="width: 183px;"
			   data-options="url:'../query/codeQuery?codetype=PARAM_VALUE_TYPE',
			   valueField:'code',
			   textField:'codeName',
			   panelHeight:100,
			   onSelect:function(){
			   	changeParamValueType();
			   },
			   onLoadSuccess:function(r){
				var data = $('#paramValueTypeId').combobox('getData');
				if(data.length > 0){
					$('#paramValueTypeId').combobox('setValue',data[0].code);
					$('#paramValueTypeId').combobox('setText',data[0].codeName);
					$('#paramValueType').val(data[0].code);
				}
		  	   }"></td>
		  </tr>
		  <tr>
		   <td class="table_text" align="left">参数值</td>
<!--name  P or p -->
		   <td colspan="3"><input class="table_input" name="ParamValue" id = "paramValueId" style="width:700px"></td>
		  </tr>
		  <tr>
		   <td class="table_text" align="left">参数域</td>
		   <td>
		  <input class="easyui-combobox" id = "paramSubTypeId" style="width: 183px;"
			   data-options="url:'../query/codeQuery?codetype=PARAM_SUB_TYPE',
			   valueField:'code',
			   textField:'codeName',
			   panelHeight:50,
			   onSelect:function(){
			   	changeParamSubType();
			   },
			   onLoadSuccess:function(r){
				var data = $('#paramSubTypeId').combobox('getData');
				if(data.length > 0){
					$('#paramSubTypeId').combobox('setValue',data[0].code);
					$('#paramSubTypeId').combobox('setText',data[0].codeName);
					$('#paramSubType').val(data[0].code);
				}
		  	   }">
		  	 </td>
		   <td colspan="2" align="center">
		     <div align="center" style="padding-bottom: 10px">
			   	<a href="#" class="easyui-linkbutton e-cis_button" iconCls="icon-add" 
			   	onclick="addParam()">添加</a>
			   	<a href="#" class="easyui-linkbutton e-cis_button" iconCls="icon-ok" 
			   	onclick="updateParam()">修改</a>
			   	<a href="#" class="easyui-linkbutton e-cis_button" iconCls="icon-ok" 
			   	onclick="clearParam()">清除</a>
		   	 </div>
		   </td>
		  </tr>
		 </table>
		 <div>
<%-- 		  <input type="hidden" name = "id" id="id" value="<%=request.getParameter("id")%>"> --%>
		  <input type="hidden" name = "id"  id = "id"><!-- ID -->
		  <!-- 参数类型 -->
		  <input type="hidden" name = "paramType"  id = "paramType">
		  <!-- 参数值类型 -->
		  <input type="hidden" name = "paramValueType"  id = "paramValueType">
		  <!-- 参数域 -->
		  <input type="hidden" name = "paramSubType"  id = "paramSubType">
		  <input type="hidden" name = "sqlId"  id = "sqlId" value="<%=request.getParameter("id")%>">
		 </div>
		 </form>
	</div>
</body>
</html>