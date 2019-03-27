<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/leftMenu.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/myWorkbench.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/pageCraniocaudal.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/global.css" />
<html>
<head>
<title>上海人身险报送平台</title>
</head>
<script type="text/javascript">

	jQuery.ajaxSetup({
		cache : false
	});//ajax不缓存
	
	jQuery(function($) {
		$.ajax({
		   async : false,
		   cache : false,
		   type : "POST",
		   dataType : "json",
		   url : "welcome/queryMenu",
		   error : function() {
		    	alert("请求失败");
		   },
		   success : function(data) {
			   initMenu(data);
		   } 
	    });
	});
	

	function initMenu(data){
		//判断菜单是否有加载
		if(data == null || data=="" || data=="undefined"){
			$.messager.alert("系统提示","<div align='center'><span style='font-weight:bold'>对不起！您暂无权限操作系统，请联系管理员。<br>谢谢！</span></div>");
			return ;
		}
		// 插入写死的“我的任务”
	    var target = $('<ul></ul>');
	    target.addClass('menu_main');
	     var li = $('<li></li>');
	    li.addClass('menu_title');
	    var href = 'javascript:addtab(\'我的任务 \',\'welcome\/listTaskUrl\');';
	    var a = $('<a></a>');
	    a.attr('href',href);
	    a.addClass('menu_title_link');
	    a.append('我的任务');
	    li.append(a); 
	    target.append(li);
		var tmpChildMenu = [];
		$.each(data, function (i, item) {
			if( item.pId == null || item.pId == ""){
				tmpChildMenu.push(item);
			} 			
		});
	    initChildMenu(target,tmpChildMenu,data);
	    
		$('#menuDiv').append(target);
		
		addtab('我的任务','welcome/listTaskUrl');
	}
	//初始化菜单信息
	function initChildMenu(target,tmpChildMenu,data){
		$.each(tmpChildMenu, function (i, item) {
			var li = $('<li></li>');
			var a = $('<a></a>');
		    a.append(item.name);
		    var tmpArr = [];
			$.each(data, function (i, item1) {
				if(item.id == item1.pId){
					tmpArr.push(item1);
				}
			});
			if(tmpArr.length > 0 &&   (item.pId == null || item.pId == "" )){
				a.addClass('menu_link select menu_folder');
		        a.attr('id','menu_link_'+item.id);
		        a.on('click',function(){
					 meunSelect( item.name , item.url , item.id ,item.pId,data)
				    });
		      	li.append(a);
		      	li.addClass('menu_item');
		    	li.attr('id','menu_item_'+item.id);
		      	var div = $('<div></div>');
		      	div.css('display','none'); 
		      	div.attr('id','submenuDiv'+item.id);
		      	var menus = $('<ul></ul>');
		      	menus.addClass('submenu');
		      	initChildMenu(menus, tmpArr, data);
		      	div.append(menus);
		      	li.append(div);
			} else if(tmpArr.length > 0 &&   (item.pId != null || item.pId != "" )){
				a.addClass('menu_link select menu_folder');
		        a.attr('id','menu_link_'+item.id);
		        a.on('click',function(){
					 meunSelect( item.name , item.url , item.id,item.pId ,data)
				    });
		      	li.append(a);
		      	li.addClass('submenu_item');
		    	li.attr('id','menu_item_'+item.id);
		      	var div = $('<div></div>');
		      	div.css('display','none'); 
		      	div.attr('id','submenuDiv'+item.id);
		      	var menus = $('<ul></ul>');
		      	menus.addClass('submenu');
		      	initChildMenu(menus, tmpArr, data);
		      	div.append(menus);
		      	li.append(div);
			} else{
				
				 if(item.pId == null || item.pId == "" ){
					a.addClass('menu_link select menu_folder');
			        a.attr('id','menu_link_'+item.id);
			        a.on('click',function(){
						 meunSelect( item.name , item.url , item.id ,item.pId , data)
					    });
			      	li.append(a);
			      	li.addClass('menu_item');
			    	li.attr('id','menu_item_'+item.id);
			      	
				} else {
					a.attr('id','sub_menu_link_'+item.id);
				    a.on('click',function(){
				    	subMeunSelect( item.name , item.url , item.id,item.pId ,data)
				    });
					li.append(a);
				    li.addClass('submenu_item');
				    li.attr('id','sub_menu_item_'+item.id);
				}
			}
			target.append(li);
		});
	}
	
	
	function deletetab(title)
	{
		if($('#work').tabs('exists', title))
		{
			$('#work').tabs('select', title);
			var tab = $('#work').tabs('getSelected'); 
			$('#work').tabs('close', title);
		}
	}
	//打开报文任务栏，是否需要记录日志
	function addtab(title, href,isLog){
		if(isLog){
			addtab(title,href);
		}else{
			_addtable(title,href);
		}
	} 
	function _addtable(title, href){
		if(href=='cache/reload'){
			$.post(href);
			return;
		}
		if($('#work').tabs('exists', title)) {
			$('#work').tabs('select', title);
	        var tab = $('#work').tabs('getSelected'); 
			$('#work').tabs('close', title);
			addIframeTab(title, href);
		}else {   
			addIframeTab(title, href);
		}
	}
	//自动添加日志
	function addtab(title, href) {
		_addtable(title, href);
		//用户操作履历
		insertTrace(title,href);
	}
	//Add By Darker.Wang 新增用户访问轨迹履历 2016-06-08
	function insertTrace(oTitle,oUrl){
		var action = "usertrace/insertTrace";
		$.post(action,{url:oUrl,title:oTitle},function(data){});
	}
	function addsubtab(title, href) {
		if($('#work').tabs('exists', title)) {
			$('#work').tabs('select', title);
	        var tab = $('#work').tabs('getSelected'); 
			$('#work').tabs('close', title);
			addIframeTab(title, href);
		}else {   
			addIframeTab(title, href);
		}
	}
	
	function addIframeTab(title, href){
		$('#work').tabs('addIframeTab', {tab:{
			title : title,
			closable : true
		},
		iframe:{src:href}});
	}
	

	//名称 链接 节点序号 总菜单数
	function meunSelect(name,url,id,pid,all){
		//显示隐藏子菜单
		var obj_div = '#submenuDiv'+id;
		if($(obj_div).length >0){
			var display = $(obj_div).css('display');
			if(display == "none"){
				$(obj_div).css('display','');
				$('#menu_link_'+id).css('background','url(img/arr2.png) 14px no-repeat');
				var obj_a ='#menu_link_'+id; 
				$(obj_a).css('color','#c7000a');
			}
			else{
				$(obj_div).css('display','none');
				$('#menu_link_'+id).css('background','url(img/arr1.png) 14px no-repeat');
				var obj_a = '#menu_link_'+id; 
				$(obj_a).css('color','#7e7e7e');
			}
			
			if(pid == null || pid == "" ){
				$.each(all, function (i, item) {
					obj_div = '#submenuDiv'+item.id;
					if(item.id != id){
						if($(obj_div).length >0){
							$(obj_div).css('display','none');
							$('#menu_link_'+item.id).css('background','url(img/arr1.png) 14px no-repeat'); 
							if(display == "none"){
								var obj_a = '#menu_link_'+item.id; 
								$(obj_a).css('color','#7e7e7e');
							}
						}
					}
				});
			}
			
		}
		
		 //链接颜色改变
		 var obj_a ='#menu_link_'+id; 
		
		$.each(all, function (i, item) {
			var sub_obj_a = '#sub_menu_link_'+item.id; 
			if($(sub_obj_a).length >0){
				$(sub_obj_a).css('color','#7e7e7e');
			}
			
		}); 
		
		if(url!=null && url != ""&& url != "null"){
			addtab(name, url);
		}
	}
	//名称 链接 节点序号 父菜单序号 总菜单数
	function subMeunSelect(name,url,id,pid,all){
		var sub_obj_a ='#sub_menu_link_'+id; 
		if($(sub_obj_a).length >0){
			$(sub_obj_a).css('color','#c7000a');
		}
		var p_obj_a ='#menu_link_'+pid; 
		if($(p_obj_a).length >0){
			$(p_obj_a).css('color','#c7000a');
		}
		 $.each(all, function (i, item) {
		    if(item.id==pid && item.id!=id){
				var obj = '#sub_menu_link_'+item.id; 
				if($(obj).length >0){
					$(obj).css('color','#c7000a');
				}
			} 
			 if(item.id!=id){
				var obj = '#sub_menu_link_'+item.id; 
				if($(obj).length >0){
					$(obj).css('color','#7e7e7e');
				} 
			}
		});
		
		if(url!=null && url != ""&& url != "null"){
			addtab(name, url);
		}
	}


</script>
<!-- easyui-layout 可分上下左右中五部分，中间的是必须的，支持href，这样就可以不用iframe了 -->
<body class="easyui-layout" id="mainBody">
	<!-- 上-->
	<div data-options="region:'north',border:false" class="header">
		<div class="background" align="justify">
		    <table>
		     <tr>
		     <td><img class="logo" src="img/metlife.jpg" style="height: 50px;"></td>
		   		<td valign="bottom" align="right" style="width: 900px;">
		       <div style="margin-right: 10px; text-align: right;">
			    <span> 登录区站：${userip} | 登录用户：${_user} | 
			    <!-- CR1800450 -->
			     <!--  
				 <a href="#" onclick=" addtab('密码修改', 'user/modifyUserUrl')">密码修改</a> | 
				 -->
				 <a href="#" onclick=" addtab('重新登陆', 'welcome/reloadUrl')">注销</a>
			    </span>
			  </div>
		      </td>
		     </tr>
		    </table>
		</div>
	</div>
	<!-- left -->
	<div region="west" split="true" border="false" title="系统菜单"
		style="height: 100%; min-width:260px;overflow:hide;overflow:auto;width: 165px;border:1px solid #d2e0e6;background:#f0f6fa;">
		<div class="personal_menu" id = "menuDiv"></div>
	</div>
	<!-- center -->
	<div region="center" border="false" split="false" >
		<div class="easyui-tabs" id='work' fit='true'
			border='false' plain='true'>
		</div>
	</div>
	<!-- buttom -->
	<div region="south" split="false" border="false">
		<div class="footer">
			<p>大都会人寿</p>
			<!-- <p>@CopyRight 2016 ICBC-AXA LIFE ICP</p> -->
		</div>
	</div>
</body>
</html>
