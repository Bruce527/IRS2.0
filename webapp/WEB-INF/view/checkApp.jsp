<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上海人身险报送平台</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
<link href="<%=request.getContextPath()%>/css/global.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
jQuery(function($) {
	check();
});
function check(){
	 var html = "<table cellpadding='50px' border='1px'>"+
	  " <tr>"+
	  "<th align='center' width = '120px' height='30px'>APP 状态 </th>"+
	  "<th align='center' width = '120px' height='30px'>DB  状态 </th>"+
	  "<th align='center' width = '200px' height='30px'>系统时间</th>"+
	  "</tr>";
	  $.post('checkAlive',function(data){
		  try{
			  var color = 'black';
			  if(data.msg == 'success'){
				  color = 'blue';
			  }else{
				  color = 'red';
			  }
			  var tHtml = "<tr>"
				  +"<td align='center' height='20px'><font color = "+color+">"+data.app+"</font></td>"
				  +"<td align='center' height='20px'><font color = "+color+">"+data.db+"</font></td>"
				  +"<td align='center' height='20px'><font color = "+color+">"+data.date+"</font></td></tr>";
				  +"</table>";
				  $('#checkDiv').append(html+tHtml);
		  }catch(e){
			  $('#checkDiv').append("<p>APP IS STOPED </p>");
		  }
	  })
}
</script>
<body>
<div class="top_panel">
 <form action="" id="checkFM" id="checkFM">
 	<div id="checkDiv" style="padding-top: 50px;" align="center">
 	</div>
 </form>
</div>
</body>
</html>