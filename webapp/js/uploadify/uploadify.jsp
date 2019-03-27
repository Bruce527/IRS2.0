
<%@page import="com.sinosoft.ummp.application.AppointFileImportService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="com.sinosoft.platform.core.util.FileUploadServletUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 request.setCharacterEncoding("UTF-8");
 String logPath = (String)request.getParameter("logPath");
 //System.out.println("logPath1:"+logPath);
 logPath = new String(logPath.getBytes("ISO8859-1"),"GBK");
 //System.out.println("logPath2:"+logPath);
 FileUploadServletUtil util = new FileUploadServletUtil();
 util.doPost(request, response);
 Map map = util.getParameters();
 System.out.println(map.entrySet());
 InputStream in = (InputStream)map.get("Filedata");
 String fileName = (String)map.get("Filename");
 //System.out.println("fileName1:"+fileName);
 fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
 //System.out.println("fileName2:"+fileName);
 try{
	 File fileDir = new File(logPath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		File outFile =new File(logPath+fileName);
		if(outFile.exists()){
			outFile.delete();
		}
		outFile.createNewFile();
	 FileOutputStream fos = new FileOutputStream(outFile);
	 byte[] buff = new byte[1024*1024*2];
	 int t = in.read(buff);
	 while(t != -1){
		 fos.write(buff,0,buff.length);
		 t = in.read(buff);
	 }
	 fos.flush();
	 
	 if(fos != null){
		 fos.close();
		 fos = null;
	 }
	 if(in != null){
		 in.close();
		 in = null;
	 }
	 System.out.println("上载文件成功："+logPath+fileName);
 }catch(Exception e){
	 e.printStackTrace();
	 System.out.println("上载文件失败："+logPath+fileName);
 }
 
%>
</body>
</html>