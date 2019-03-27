//输入统一认证编码=>获取权限
	
	jQuery(function($) {
		treeRL();
		treeULL();
		$("#usercode").focusout( function (){getIdByUsercode();});
	});
	function beforeDragU(treeId, treeNodes) {
		var zTree = $.fn.zTree.getZTreeObj("treeUL");
		var aa = zTree.getNodesByParam("id", treeNodes[0].id);
		if (aa.length == 1) {
			$.messager.alert('提示','该角色已分配！','info');
			return false;
		}
		return true;
	}
	function beforeDropU(treeId, treeNodes, targetNode, moveType) {
		return true;
	}
	function beforeDragUL(treeId, treeNodes) {
		return true;
	}
	function treeULL(){
		var setting = {	
			data: {
				simpleData: {
					enable: true//简单json格式
				}
			},
			check: {
				enable : false
			},
			callback: {
				beforeDrag: beforeDragUL,
				beforeDrop: beforeDropU
			},
			edit : {
				
				drag : {
					isCopy : false,
					isMove : true
				},
				enable : true,
				removeTitle : "remove",
				renameTitle : "rename",
				showRemoveBtn : false,
				showRenameBtn : false
			}

		};
		var zNodes =[
		     	];
		$.fn.zTree.init($("#treeUL"), setting,zNodes);
	}
	function treeUL(){
		var setting = {	
			data: {
				simpleData: {
					enable: true//简单json格式
				}
			},
			check: {
				enable : false
			},
			callback: {
				beforeDrag: beforeDragUL,
				beforeDrop: beforeDropU
			},
			edit : {
				
				drag : {
					isCopy : false,
					isMove : true
				},
				enable : true,
				removeTitle : "remove",
				renameTitle : "rename",
				showRemoveBtn : false,
				showRenameBtn : false
			}

		};
		var zNodes =[
		     		{ id:23, pId:2, name:"随意拖拽 2-3"}
		     	];
		$.ajax({
			   async : false,
			   cache : false,
			   type : "POST",
			   dataType : "json",
			   url : "queryRole?userId="+$("#userid").val(),//客户和对应角色关系的请求
			   error : function() {
				   $.messager.alert("提示","请先输入用户或创建该用户！","info");
			   },
			   success : function(data) {
			    	zNodes = data; 
			   }
		    });
		$.fn.zTree.init($("#treeUL"), setting,zNodes);
	}
	
	//保存客户和对应角色的关系
	function addU2R(){
		var id = $("#userCode").val();
		if($.trim(id)==''){
			$.messager.alert('提示',"请输入用户编码！",'info')
			return;
		}
		$.messager.confirm('提示',"请确认用户编码："+id,function(result){
			if(result){
				$.messager.progress({
				title:'温馨提示',
				msg:'正在提交数据...'
				});
				var zTree = $.fn.zTree.getZTreeObj("treeUL");
				var nodes = zTree.transformToArray(zTree.getNodes());
				var dlist = [];
				var list = [];
				for(var i =0;i<nodes.length;i++){
					list.push(nodes[i].id);
				}
				dlist.push({"userCode":id,"roleId":list});
				$.post("saveSet?list="+$.toJSON(dlist),function(data){
					$.messager.alert('提示',data.mes,'info');
					$.messager.progress('close');
					$('#userTable').datagrid('cisreload');
				});
			}
		});
	}
	function getIdByUsercode(){
		treeUL();
		treeRL();
	} 
	function treeRL(){
		var setting = {
				edit : {
					drag : {
						isCopy : false,
						isMove : true
					},
					enable : true,
					removeTitle : "remove",
					renameTitle : "rename",
					showRemoveBtn : false,
					showRenameBtn : false
				},
				data: {
					simpleData: {
						enable: true
					}
				},
				check: {
					enable : false
				},
				callback: {
					beforeDrag: beforeDragU,
					beforeDrop: beforeDropU
				}
			};
			var zNodes =[
				{ id:23, pId:2, name:"随意拖拽 2-3"}
			];
			$.ajax({
			   async : false,
			   cache : false,
			   type : "POST",
			   dataType : "json",
			   url : "../role/listRole",//角色显示请求
			   error : function() {
				   $.messager.alert("","请求失败","info");
			   },
			   success : function(data) {
			    	zNodes = data; 
			   }
		    });
			$.fn.zTree.init($("#treeUR"), setting, zNodes);
	}
	
