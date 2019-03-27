//测试3
	
	jQuery(function($) {
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
		   url : "../role/listRole?userId="+$("#userid").val(),//角色显示请求
		   error : function() {
			   $.messager.alert("提示","请求失败","info");
		   },
		   success : function(data) {
		    	zNodes = data; 
		   }
	    });
		$.fn.zTree.init($("#treeUR"), setting, zNodes);
		treeUL();
	});
	function beforeDragU(treeId, treeNodes) {
		var zTree = $.fn.zTree.getZTreeObj("treeUL");
		var aa = zTree.getNodesByParam("id", treeNodes[0].id);
		if (aa.length == 1) {
			$.messager.alert("提示","该角色已分配！",'info');
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
				   $.messager.alert('提示',"请求失败2","info");
			   },
			   success : function(data) {
			    	zNodes = data; 
			   }
		    });
		$.fn.zTree.init($("#treeUL"), setting,zNodes);
	}
	//保存客户和对应角色的关系
	function addU2R(){
		$.messager.progress({
			title:'温馨提示',
			msg:'正在提交数据...'
		});
		var zTree = $.fn.zTree.getZTreeObj("treeUL");
		var nodes = zTree.transformToArray(zTree.getNodes());
		var id = $("#userid").val();
		var code=$("#userCode").val();
		var dlist = [];
		var list = [];
		for(var i =0;i<nodes.length;i++){
			list.push(nodes[i].id);
		}
		dlist.push({"userId":id,"roleId":list,"userCode":code});
		$.post("saveSet?list="+$.toJSON(dlist),function(data){
			$.messager.alert('提示',data.mes,'info');
			$.messager.progress('close');
			$('#userTable').datagrid('cisreload');
		});
	}
