<%@page import="com.icbc.ssic.base.SSICUserInfo"%>
<%@page import="com.icbc.ssic.base.Credentials"%>
<%@page import="config.Config"%>
<%@page session="false" %>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	HttpSession session=request.getSession(false);
	if(session==null){
		session=request.getSession();
	}
	String s=Config.getProperties().getProperty("SITE_SERVERURL");
	s=s.substring(0,s.lastIndexOf("/"));
	String addUrl=s.substring(s.lastIndexOf("/"))+"/ssicrequest.jsp";
	System.out.println(addUrl);
	System.out.println("addUser:"+session.getId());
	String flag = request.getParameter("retcode");
	System.out.println("===========================>>flag="+flag);
	String creatorCode="";
	String email="";
	String password="";
	String userDescribe="";
	String empowerType="0";
	String companyId="";
	String username="";
	String usercode="";
	if(flag != null && flag.equals("0")){//最终状态为0就行了
		email=(String)session.getAttribute("email");
		password=(String)session.getAttribute("password");
		creatorCode=(String)session.getAttribute("creatorCode");
		userDescribe=(String)session.getAttribute("userDescribe");
		System.out.println("email="+email+"\npassword="+password);
		String ssiAuth = request.getParameter("SSIAuth");
		String ssiSign = request.getParameter("SSISign");
		try{
			Credentials cred = new Credentials(ssiAuth, ssiSign);
			if (cred.isvalidateUtf8(Config.getPublicKey())) {
				SSICUserInfo userinfo = cred.getSSICUserInfo();
				usercode = userinfo.getUsername();
				username = userinfo.getName();
				companyId = userinfo.getBranchId();
			} 
		}catch(Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
%>
<script>
jQuery(function($) {
	$('#userState').combobox({
		  url:getBasePath()+'/query/codeQueryUrl?codetype=USER_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  value:'1'
	 	});

	$('#empowerType').combobox({
		  url:getBasePath()+'/query/codeQueryUrl?codetype=EMPOWER_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  onLoadSuccess:function(r){
			  var oper="<%=creatorCode %>";
			  if( oper != null){
					$("#creatorCode").val("<%=creatorCode %>");
				}
			  var creatorCode=$("#operator").val();
			  if(creatorCode != null || creatorCode==""){
				  $("#creatorCode").val(creatorCode);
			  }
			  if(<%=flag%> == 0){
				  $('#empowerType').combobox('select',0);
				  $("#creatorCode").val("<%=creatorCode%>");
			  	  $("#email").val("<%=email%>");
			  	  $("#password").val("<%=password%>");
			  	  $("#userDescribe").val("<%=userDescribe%>");
			  	  $("#username").val("<%=username%>");
			  	  $("#usercode").val("<%=usercode%>");
			  	  var creatorCode="<%=creatorCode%>";
			  	  if(creatorCode=="null"){
			  		  $.messager.confirm('提示',"添加失败：登录用户非统一认证用户",function(resutl){
			  			  if(resutl){
			  				  $("#creatorCode").val("");
						  	  $("#email").val("");
						  	  $("#password").val("");
						  	  $("#userDescribe").val("");
						  	  $("#username").val("");
						  	  $("#usercode").val("");
			  				  return;
			  				  //reRequest();
			  			  }
			  		  });
			  		  return;
			  	  }
				  addUser();
			     } 
			  if(<%=flag%>==1){
				  $.messager.confirm('提示',"验签失败，请重新输入或选择本地认证",function(result){
					  if(result){
						  reRequest();
					  }
				  });
				  $('#empowerType').combobox('select',1);
			  }
			  if(<%=flag%> ==2){
				  $.messager.confirm('提示',"证书实例化失败,请重新输入或选择本地认证",function(result){
					  if(result){
						  reRequest();
					  }
				  });
				  $('#empowerType').combobox('select',1);
			  }
			  if(<%=flag%> ==3){
				  $.messager.confirm('提示',"查找不到符合人员条件的信息,请重新输入或选择本地认证",function(result){
					  if(result){
						  reRequest();
					  }
				  });
				  $('#empowerType').combobox('select',1);
			  }
			  if(<%=flag%> ==4){
				  $.messager.confirm('提示',"执行存储过程失败,请重新输入或选择本地认证",function(result){
					  if(result){
						  reRequest();
					  }
				  });
				  $('#empowerType').combobox('select',1);
			  }
			  if(<%=flag%> ==5){
				  $.messager.confirm('提示',"统一认证处理异常,请重新输入或选择本地认证",function(result){
					  if(result){
						  reRequest();
					  }
				  });
				  $('#empowerType').combobox('select',1);
			  }
		     }
	 	});
		initCompany();
	
	});
	// 增加用户
	function addUser() {
		var empowerType=$('#empowerType').combobox("getValue");
		var flag=$("#flag").val();
		if($('#addUserForm').form('validate')){
				$.messager.progress({
					title:'温馨提示',
					msg:'正在提交数据...'
				});
				var companyIdValue = $('#companyId').combobox("getValue");
				if (!(/^\d+$/.test(companyIdValue))) {
					$.messager.alert('提示','管理机构错误，请下拉选择','info');
					$.messager.progress('close');
					return;
				}
				$.post(getBasePath()+"/user/saveAdd", $("#addUserForm").serializeArray(), function(data) {
					if(data.mes != null 
							&& data.mes != 'undefined' 
							&& data.mes != 'null' 
							&& data.mes != ""){
						$.messager.alert('提示', data.mes, 'info');
					}
					$.messager.progress('close');
					$("#flag").val("OK");
				});
		   };
	}	
	function initCompany(){
		var url = getBasePath()+'/query/listManageNameUrl';
		$('#companyId').combobox({
			  url:url,
			  valueField:'id',
			  textField:'manageName',
			  required:true,
			  value:'10101',
			  onLoadSuccess:function(r){
				  if('<%=flag%>'==0){
						  $('#companyId').combobox('setValue',"<%=companyId%>");
				  }else if('<%=flag%>' !=null && '<%=flag%>' !=0){
			   }
			}
		});
	}
	//校验统一认证用户是否存在
	function saveAdd(){
		var empowerType = $("#empowerType").combobox("getValue");
		//CR1800450 
		//if(empowerType==1){
		if(empowerType==2){
			addUser();
		}else{
			//先校验登录用户是否是统一认证用户，否则停止提交
			var creatorCode = $('#creatorCode').val();
			$.post(getBasePath()+'/user/checkUser?creatorCode='+creatorCode,function(data){
				if(data.result == 'false'){
					$.messager.alert('提示',"登录用户非统一认证用户，禁止添加统一认证用户","info");
					return;
				}
				//统一认证用户添加开始，先校验添加用户是否存在。
				var usercode=$("#usercode").val();
				if($.trim(usercode)==''){
					$.messager.alert('提示',"请输入用户编码！",'info');
					return ;
				}
				$.messager.progress({text:"正在校验，请稍后..."});
				fm.submit();
			});
		}
		$.messager.progress('close');
	}
	
	function reRequest(){
		var url = getBasePath()+"/user/addUserUrl";
		window.location.href = url;
	}
</script>
<div id="tabdiv">
	<form id="addUserForm" action="<%=addUrl %>" method="post" name="fm">
		<div id="smsaccordion" class="easyui-panel" fit="true" title="用户信息"
			iconCls="icon-ok" collapsible="true">
			<div class="top_table" >
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<td class="table_text" align="right">用户名称：</td>
						<td align="left">
						<input id="username" name="username" class="table_input easyui-validatebox" validType="length[0,20]" required="true">
						</td>
						<!-- CR1800450 域认证 -->
						<td class="table_text" align="right">域账号：</td>
						<!--td class="table_text" align="right">用户编码：</td-->
						<!-- END -->
						<td align="left">
						<input id="usercode" name="usercode" validType="length[0,20]" required="true" class="table_input easyui-validatebox" value="">
						<!-- <a href="#" onclick="check1()">校验</a>  -->
						</td>
						<td class="table_text" align="right">认证开关：</td>
						<td align="left">
						<input id="empowerType" name="empowerType" validType="length[0,50]" required="true" class="table_select easyui-combobox"  value="<%=empowerType %>"></input>
						</td>
					</tr>
					<tr>
					<!-- CR1800450 -->
						<!--  <td class="table_text" align="right">用户密码：</td>
						<td align="left" >
						<input id="password" name="password" class="table_input easyui-validatebox" value="" validType="length[0,20]" required="true"></td>
						-->
						<td class="table_text" align="right" >操作人员：</td>
						<td align="left">
						<input id="creatorCode"   readonly="readonly" name="creatorCode" validType="length[0,20]" required="true" class="table_input" >
						</td>
						
						<td class="table_text" align="right">管理机构：</td>
						<td align="left">
						<input class="table_select" name="companyId" id="companyId" ></td>
					</tr>
					<tr>
						<td class="table_text" align="right">邮箱地址：</td>
						<td align="left">
<!-- 						<input id="email" data-options="required:true,validType:'email'" name="email" class="table_input easyui-validatebox" value=""> -->
						<input id="email" name="email" class="table_input easyui-validatebox" value="">
						</td>
						<td class="table_text" align="right">用户描述：</td>
						<td align="left">
						<input id="userDescribe" name="userDescribe" class="table_input easyui-validatebox" value="">
						</td>
						<td class="table_text" align="right">用户状态：</td>
						<td align="left">
						<input class="easyui-combobox table_select" name="userState" id="userState" ></input>
						</td>
						<input type="hidden" id="flag" value="<%=request.getParameter("retcode") %>">
						<input type="hidden" id="operator" value=${userCode}>
					</tr>
				</table>
				<div>
					<a href="#" onclick="saveAdd()"
						class="easyui-linkbutton e-cis_button" iconCls="icon-add">新增</a>
				</div>
			</div>
		</div>
	</form>
</div>