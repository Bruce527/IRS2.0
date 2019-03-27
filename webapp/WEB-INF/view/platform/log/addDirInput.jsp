<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<div align="center" style="padding-top: 20px">
	<table>
		<tr>
			<th class="table_text">名称</th>
			<td ><input id = "dirNameId" name="dirName" class="table_input" style="width: 200px"></td>
		</tr>
		<tr>
		 <td colspan="2" align="center">
		  <a href="#" 
		  	 class = 'easyui-linkbutton e-cis_button' 
		  	 iconCls="icon-ok" 
		  	 onclick="doDirOk()">确定</a>
		  <a href="#" 
		  	 class = 'easyui-linkbutton e-cis_button' 
		  	 iconCls="icon-no" 
		  	 onclick="doDirCancel()">取消</a>
		 </td>
		</tr>
	</table>
</div>
</body>
</html>