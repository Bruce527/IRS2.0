<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/uploadify/jquery.uploadify.js" ></script>
<link rel="stylesheet" type="text/css" href="../js/uploadify/uploadify.css" />
<script type="text/javascript" src="../js/platform/log/addFileInput.js"></script>
<title>FILE UPLOADING </title>
<%
  request.setCharacterEncoding("UTF-8");
  String path = (String)request.getAttribute("path");
%>
<script type="text/javascript">
 
</script>
</head>
<body onload="test()">
<div align="center" style="padding-left: 10px;padding-top:20px;display: ">
	<span>上载路径 : </span>
	<input type="text" value='<%=path %>' id="logPathId" style="width: 300px">
</div>
<div align="center" style="padding-top: 20px">
 <table>
   <tr>
     <td align="center" colspan="2" style="padding-top: 10px">
    	<a href="#" class="easyui-linkbutton e-cis_button" onclick = "upload()" iconCls="icon-ok">上传</a>
    	<a href="#" class="easyui-linkbutton e-cis_button" onclick = "uploadCancel()" iconCls="icon-no">取消</a>
     </td>
   </tr>
   <tr><td><hr></td></tr>
   <tr>
    <td align="center">
    <form action="" id='fileUploadifyFormId'>
  		<input id="uploadify" name="uploadify" type="file"  multiple="true" style="width:350px;">
  	</form>
    </td>
   </tr>
 </table>
 <div id="fileQueue"></div>
</div>
</body>
</html>