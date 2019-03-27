<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>上海人身险报送平台</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
<link href="<%=request.getContextPath()%>/css/global.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/login2.css" rel="stylesheet" type="text/css">

<script>
  jQuery(function($) {
	  initEmpType();
	  //屏蔽掉用户名和密码
	  showLoginInfo(1);
	  $('#usercode').focus();
	  //跳转登录
	  //autoLogin();
	});
    function initEmpType(){
    	$('#empowerType').combobox({
  		  url:'query/codeQuery?codetype=EMPOWER_TYPE',
  		  valueField:'code',
  		  textField:'codeName',
  		  panelWidth : 250,
  		  panelHeight : 55,
  		  onLoadSuccess:function(r){
  			var data = $('#empowerType').combobox("getData");
  			if(data.length > 0){
  				$('#empowerType').combobox("setValue",data[0].code);
  				//$('#EMPType').val(data[0].code);
  				//显示用户名和密码
  				if(data[0].code != null && (data[0].code == "1" || data[0].code == 1)){
  					showLoginInfo(1);
  				}
  			}else{
  				$('#empowerType').combobox("setValue","0");
  				$('#empowerType').combobox("setText","0 - 统一认证")
  			}
  		  },
  		  onSelect:function(record){
  			//$('#EMPType').val(record.code);
  			if(record.code != null && record.code == 1){
  				$('#usercode').val("");//默认测试用户
  				$('#password').val("");//默认测试用户密码
  				showLoginInfo(1);
  			}else{
  				$('usercode').val('');
  				$('#password').val("");
  			    showLoginInfo(0);
  			}
  		  }
  	  });
  	  $('.combo').css('width','248px').css('border','1px solid rgb(204,214,214)').css('height','25px');
  	  $('.combo-text').css('width','220px').css('text-indent','4px').css('font-weight','bold').css('font-size','12px');
  	  $('.combo-arrow').css('background-color','#FFFFFF');
    }
	function showLoginInfo(isShow) {
		if (isShow == 1) {
			$('#loginInfoId').show();
		} else {
			$('#loginInfoId').hide();
		}
	}
	//Enter 键操作
	function enterLogin(e) {
		var key = window.event ? e.keyCode : e.which;
		if (key == 13) {
			loginForm();
		}
	}
	/**
	 * 自动登录
	 */
	
	function autoLogin() {
		var ssiflag = $('#SSIFlag').val();
		if(ssiflag == 2 || ssiflag == '2'){
			loginForm();
		}
	}
	//登录
	function loginForm() {
		//var ssiflag = $('#SSIFlag').val();
		var usercode = $('#usercode').val();
		var password = $('#password').val();
		var empowerType = $('#empowerType').combobox("getValue");
		//if((ssiflag == 0 || ssiflag == "0" ) && empowerType == 0 && ('null' == usercode || null == usercode)){
		//	window.location = "indexssic.jsp?SSIFlag="+ssiflag+"&EmpType="+empowerType;
		//}
		
		
		usercode = $('#usercode').val();
		password = $('#password').val();
		
		var errCode = "";
		var errMes = "";
		if ((usercode == null || usercode == "") && empowerType != 0) {
			errCode = "1"; 
			errMes = "用户名不能为空！";
			showMsg(errMes);
		} else {
			if ((password == null || password == "") && empowerType != 0) {
				errCode = "2";
				errMes = "密码不能为空！";
				showMsg(errMes);
			} else {
				if (empowerType == null || empowerType == "") {
					errCode = "3";
					errMes = "请选择认证方式登录!";
					showMsg(errMes);
				} else {
					//统一认证入口
					var url = "welcome/loginUrl";
					//if (empowerType == 0 && (usercode == null || usercode == 'null' || usercode == "")) {
					//	window.location="indexssic.jsp?SSIFlag="+ssiflag+"&EmpType="+empowerType;
					//}else{
						$.messager.progress({text:"正在登录，请稍等..."});
						loginUrl(url);
						$.messager.progress('close');
					//}
				}
			}
		}
	}
	//根据URL辨别登录入口
	function loginUrl(url) {
		var empowerType = $('#empowerType').combobox('getValue');
		var empType = $('EmpType').val();
		if(empType != null 
				&& (empowerType == null 
				|| "" == empowerType 
				|| 'null' == empowerType)){
			$('#empowerType').combobox('setValue',empType);
		}else if ((empType == null || empType == "" ) 
				&& (empowerType == null 
				|| "" == empowerType 
				|| 'null' == empowerType)){
			$('#empowerType').combobox('setValue',"0");
		}
		$.post(url, $("#fm").serializeArray(), function(data) {
			if (data.msg == 'success') {
				fm.submit();
			} else {
				errCode = data.errorCode;
				errMes = data.message;
				if (errCode == "1") {
					$('#usercode').focus();
					showMsg(errMes);
				} else {
					if (errCode == "2") {
						$('#password').focus();
						showMsg(errMes);
					} else {
						$('#empowerType').focus();
						showMsg(errMes);
					}
				}
			}
		});
	}
	function reload(){
		window.location="index.jsp?SSIFlag=-1";
	}
	//隐藏信息
	function hiddenMeg() {
		$('#loginMsg').css('display', 'none');
	}
	
</script>
</head>
<body class="easyui-layout">
<div class="center" region="center">
	<div class="title" align="left" style="padding-left: 150px;">
 	 <span>上海人身险报送平台 </span>
	</div>
	<!-- 页面布局 -->
	<div style="padding-left: 50px">
	  <table>
		 <tr>
		   <td align="left" width="300px">
		    <div style="padding-top: 25px;padding-left: 90px;">
		    	<img src="img/metlife.jpg" style="width:300px">
		    </div>
		   </td>
		   <td></td>
		 </tr>
		 <tr>
		  <td></td>
		  <td valign="top" align="right" style="width: 350px;padding-left: 400px;">
		      <form id="fm" action="welcome" method="post">
		      <div class="login" style="width: auto;height: auto;" align="center">
		         <table>
		          <tr align="center"><td width="350px">
		          <div id = "loginInfoId" style="display: ">
		        		<div class="login_lable" align="left" style="padding-left: 48px;">用户名：<span id = "usercodeMsg" class = "message" ></span></div>
						<div align="center">
		    				<input class="login_text" name="usercode"  id="usercode"   type="text" maxlength="20" onclick="hiddenMeg();">
		    			</div>
		            	<div class="login_lable" align="left" style="padding-left: 48px;">密码：<span id = "passwordMsg" class = "message"></span></div>
		    			<div align="center">
		    				<input class="login_text" name="password"  id="password"  type="password" maxlength="20" onclick="hiddenMeg();">
		    	    	</div>
		    	  </div>
		          
		          <div style="padding-right: 10px; display:none">
		            <select id = "empowerType" name = 'empowerType' data-options="panelWidth:238,panelHeight:50">
		             
		              <option name="empowerType1" value="1">
		            </select>
		          </div>
		          </td></tr>
		          <tr align="center"><td width="350px">
		          <br>
		          <input class="button" name="login" type="button"  id="login" 
		          		 onclick="loginForm();" 
		          		 onkeyup="enterLogin()">
		          <br>
		          </td></tr>
		         </table>
		          <br>
		      </div>
    		</form>
		  </td>
		 </tr>
		</table>
 </div>
</div>
<div>"D:/sinosoft/icp1.2.1/webapp/index.jsp"
<%-- <input type="hidden" readonly="readonly" id = "SSIFlag" name="SSIFlag" value="<%=SSIFlag%>"> --%>
<%-- <input type="hidden" readonly="readonly" id = "EMPType" name="EMPType" value="<%=EmpType%>"> --%>
</div>
<!-- buttom -->
<div region="south" split="false" border="false" style="height: 40px">
	<div class="footer">
		<p>大都会人寿</p>
</div>
</div>
</body>
</html>
