<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ummp/xengin/addNodeAtrri.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">

</script>
<body>
	<div class="top_table" align="center" style="width:300px;height:auto;padding-left: 2px">
	     <br>
	     <form id = "nodeAttriForm">
		 <table class="easyui-datagrid" id= "nadg" style="width:300px;height:auto;"
		 		data-options="title:'节点属性',
		 		url:'initNodeAttriUrl?id=<%=request.getParameter("id")%>',
				striped : true,
				idField : 'id',
				height : 200,
				width : 520,
				rownumbers:true,
				method : 'post',
				iconCls : 'icon-edit',
				singleSelect : true,
				onClickRow : function(rowIndex,rowData){onClickAttriRow(rowIndex,rowData)},
				fitColumns : false">
			<thead> 
			 <tr>
			  	<th data-options="field:'id',width:80,hidden:true">ID</th>
			  	<th data-options="field:'code',width:100">编码</th>
		 		<th data-options="field:'name',width:100">名称</th>
		 		<th data-options="field:'type',width:80">类型</th>
		 		<th data-options="field:'value',width:100">默认值</th>
			 </tr>
			</thead>
		 </table>
		 <table style="width: 500px;">
		  <tr> 
		   <td class="table_text" align="left">编码</td>
		   <td><input class="table_input" name="attriCode" id = "attriCodeId"></td>
		  </tr>
		  <tr>
		   <td class="table_text" align="left" style="width: 100px">名称</td>
		   <td><input class="table_input" name="attriName" id = "attriNameId"></td>
		  </tr>
		  <tr>
		   <td class="table_text" align="left">类型</td>
		   <td><input class="table_input" name="attriType" id = "attriTypeId"></td>
		  </tr>
		  <tr>
		   <td class="table_text" align="left">默认值</td>
		   <td><input class="table_input" name="attriValue" id = "attriValueId"></td>
		   <td rowspan="4" style="width: 200px;text-align: center;">
		     <div align="center" style="padding-bottom: 10px">
			   	<a href="#" class="easyui-linkbutton e-cis_button" iconCls="icon-add" 
			   	onclick="addAttri()">添加</a>
			   	<a href="#" class="easyui-linkbutton e-cis_button" iconCls="icon-ok" 
			   	onclick="updateAttri()">修改</a>
		   	 </div>
		   </td>
		  </tr>
		 </table>
		 <div>
		  <input type="hidden" name = "nodeId" value="<%=request.getParameter("id")%>">
		  <input type="hidden" name = "id"  id = "id">
		 </div>
		 </form>
	</div>
</body>
</html>