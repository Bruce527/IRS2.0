$(function(){
	
	var pID = $("#pID").val();
	//数据传输前列表
	$('#dataTransportAgoTable').datagrid({
		title : '数据传输前操作', //标题
		method : 'post',
		iconCls : 'icon-edit', //图标
		singleSelect : false, //多选
		height : 250, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		url : "dataTransportAgoTable", //数据来源
		sortName : 'job_name', //排序的列
		sortOrder : 'asc', //倒序
		remoteSort : true, //服务器端排序
		idField : 'id', //主键字段
		queryParams : {"queryParam":pID}, //查询条件
		pagination : true, //显示分页
		pageList:[5],
		rownumbers : true, //显示行号
			columns : [ [ {
				field : 'ck',
				checkbox : true,
				width : 2
			}, //显示复选框
			{
				field : 'id',
				title : 'ID',
				width : 50,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.id;
				}
			},{
				field : 'sqlId',
				title : 'sqlId',
				width : 50,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.sqlId;
				}
			},{
				field : 'exeCode',
				title : '传输类型',
				width : 140,
				sortable : true,
				formatter : function(value, row, index) {
					return row.exeCode;
				}
			}, {
				field : 'excNum',
				title : '执行顺序',
				width : 60,
				sortable : true,
				formatter : function(value, row, index) {
					return row.excNum;
				}
			}, {
				field : 'dsName',
				title : '数据源名称',
				width : 80,
				sortable : true,
				formatter : function(value, row, index) {
					return row.dsName;
				}
			}, {
				field : 'codeAlias',
				title : '有效性',
				width : 50,
				sortable : true,
				formatter : function(value, row, index) {
					return row.codeAlias;
				}
			}, {
				field : 'sqlInfo',
				title : 'SQL',
				width : 540,
				sortable : true,
				formatter : function(value, row, index) {
					return row.sqlInfo;
				}
			}, {
				field : 'sqlDesc',
				title : '描述',
				width : 140,
				sortable : true,
				formatter : function(value, row, index) {
					return row.sqlDesc;
				}
			}]],
			toolbar:[
				       {
				    	   text:'增加配置',
				    	   iconCls:'icon-add',
				    	   handler:function(){
				    		   parent.addtab('增加传输前配置信息', 'extract/addConfigUrl?flag=DATA_TRANSPORT_AGO_CONFIG'+'&pID='+pID);
				    	   }
				       },
				       {
				    	   text:'修改配置',
				    	   iconCls:'icon-edit',
				    	   handler:function(){
				    		   var rows = $('#dataTransportAgoTable').datagrid('getSelections');
								if(rows.length==0){
									$.messager.alert("提示","请选择一个进行修改","info");
									return;
								}
								if(rows.length>1){
									$.messager.alert("提示","只能选择一个修改","info");
									return;
								}
								
								parent.addtab('更新传输前配置信息', 'extract/updateConfigUrl?id='+ rows[0].id+'&flag=DATA_TRANSPORT_AGO_CONFIG'+'&num='+1);
				    	   }
				       },
				       {
				    	   text:'删除',
				    	   iconCls:'icon-cancel',
				    	   handler:function(){
				    		   deleteScheduler(1);
				    	   }
				       }
				    ],
				    onLoadSuccess : function() {
						$('#dataTransportAgoTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
					}
	});
	
	
	
	//数据传输配置
	$('#dataTransportConfigTable').datagrid({
		title : '数据传输配置列表', //标题
		method : 'post',
		iconCls : 'icon-edit', //图标
		singleSelect : false, //多选
		height : 250, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		url : "dataTransportConfigTable", //数据来源
		sortName : 'job_name', //排序的列
		sortOrder : 'asc', //倒序
		remoteSort : true, //服务器端排序
		idField : 'id', //主键字段
		queryParams : {"queryParam":pID}, //查询条件
		pagination : true, //显示分页
		pageList:[5],
		rownumbers : true, //显示行号
			columns : [ [ {
				field : 'ck',
				checkbox : true,
				width : 2
			}, //显示复选框
			{
				field : 'id',
				title : 'ID',
				width : 50,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.id;
				}
			},{
				field : 'sqlId',
				title : 'sqlId',
				width : 50,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.sqlId;
				}
			},{
				field : 'transportType',
				title : '传输方式',
				width : 140,
				sortable : true,
				formatter : function(value, row, index) {
					return row.exeCode;
				}
			}, {
				field : 'executeOrder',
				title : '执行顺序',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.excNum;
				}
			}, {
				field : 'dataSoruceName',
				title : '数据源名称',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.dsName;
				}
			}, {
				field : 'targetDBName',
				title : '目标数据库',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.targetDBName;
				}
			}, {
				field : 'targetTableName',
				title : '目标表名称',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.targetTableName;
				}
			}, {
				field : 'validate',
				title : '有效性',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.codeAlias;
				}
			}
			, {
				field : 'description',
				title : '描述',
				width : 140,
				sortable : true,
				formatter : function(value, row, index) {
					return row.sqlDesc;
				}
			}, {
				field : 'updateDate',
				title : '修改时间',
				width : 140,
				sortable : true,
				formatter : function(value, row, index) {
					return row.lastTime;
				}
			}]],
		toolbar:[
			       {
			    	   text:'增加配置',
			    	   iconCls:'icon-add',
			    	   handler:function(){
			    		   parent.addtab('增加传输中配置信息', 'extract/addConfigUrl?flag=DATA_TRANSPORT_CONFIG'+'&pID='+pID);
			    	   }
			       },
			       {
			    	   text:'修改配置',
			    	   iconCls:'icon-edit',
			    	   handler:function(){
			    		   var rows = $('#dataTransportConfigTable').datagrid('getSelections');
							if(rows.length==0){
								$.messager.alert("提示","请选择一个进行修改","info");
								return;
							}
							if(rows.length>1){
								$.messager.alert("提示","只能选择一个修改","info");
								return;
							}
							parent.addtab('更新传输中配置信息', 'extract/updateConfigUrl?id='+ rows[0].id+'&flag=DATA_TRANSPORT_CONFIG'+'&num='+2);
			    	   }
			       },
			       {
			    	   text:'删除',
			    	   iconCls:'icon-cancel',
			    	   handler:function(){
			    		   deleteScheduler(2);
			    	   }
			       }
			    ],
			    onLoadSuccess : function() {
					$('#dataTransportConfigTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				}
	});
	
	
	
	//数据传输后操作
	$('#dataTransportAfterTable').datagrid({
		title : '数据传输后列表', //标题
		method : 'post',
		iconCls : 'icon-edit', //图标
		singleSelect : false, //多选
		height : 250, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		url : "dataTransportAfterTable", //数据来源
		sortName : 'job_name', //排序的列
		sortOrder : 'asc', //倒序
		remoteSort : true, //服务器端排序
		idField : 'id', //主键字段
		queryParams : {"queryParam":pID}, //查询条件
		pagination : true, //显示分页
		pageList:[5],
		rownumbers : true, //显示行号
		columns : [ [ {
			field : 'ck',
			checkbox : true,
			width : 2
		}, //显示复选框
		{
			field : 'id',
			title : 'ID',
			width : 50,
			sortable : true,
			hidden:true,
			formatter : function(value, row, index) {
				return row.id;
			}
		},{
			field : 'sqlId',
			title : 'sqlId',
			width : 50,
			sortable : true,
			hidden:true,
			formatter : function(value, row, index) {
				return row.sqlId;
			}
		},{
			field : 'exeCode',
			title : '传输类型',
			width : 140,
			sortable : true,
			formatter : function(value, row, index) {
				return row.exeCode;
			}
		}, {
			field : 'excNum',
			title : '执行顺序',
			width : 60,
			sortable : true,
			formatter : function(value, row, index) {
				return row.excNum;
			}
		}, {
			field : 'dsName',
			title : '数据源名称',
			width : 80,
			sortable : true,
			formatter : function(value, row, index) {
				return row.dsName;
			}
		}, {
			field : 'codeAlias',
			title : '有效性',
			width : 50,
			sortable : true,
			formatter : function(value, row, index) {
				return row.codeAlias;
			}
		}, {
			field : 'sqlInfo',
			title : 'SQL',
			width : 540,
			sortable : true,
			formatter : function(value, row, index) {
				return row.sqlInfo;
			}
		}, {
			field : 'sqlDesc',
			title : '描述',
			width : 140,
			sortable : true,
			formatter : function(value, row, index) {
				return row.sqlDesc;
			}
			}]],
			toolbar:[
				       {
				    	   text:'增加配置',
				    	   iconCls:'icon-add',
				    	   handler:function(){
				    		   parent.addtab('增加传输后配置信息', 'extract/addConfigUrl?flag=DATA_TRANSPORT_AFTER_CONFIG'+'&pID='+pID);
				    	   }
				       },
				       {
				    	   text:'修改配置',
				    	   iconCls:'icon-edit',
				    	   handler:function(){
				    		   var rows = $('#dataTransportAfterTable').datagrid('getSelections');
								if(rows.length==0){
									$.messager.alert("提示","请选择一个进行修改","info");
									return;
								}
								if(rows.length>1){
									$.messager.alert("提示","只能选择一个修改","info");
									return;
								}
								parent.addtab('更新传输后配置信息', 'extract/updateConfigUrl?id='+ rows[0].id+'&flag=DATA_TRANSPORT_AFTER_CONFIG'+'&num='+3);
				    	   }
				       },
				       {
				    	   text:'删除',
				    	   iconCls:'icon-cancel',
				    	   handler:function(){
				    		   deleteScheduler(3);
				    	   }
				       }
				    ],
				    onLoadSuccess : function() {
						$('#dataTransportAfterTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
					}
	});
});





//可删除多行数据
function deleteScheduler(num) {
	
	var rows;

	if(num == 1){
		 rows = $('#dataTransportAgoTable').datagrid('getSelections');
	}else if(num == 2){
		 rows = $('#dataTransportConfigTable').datagrid('getSelections');
	}else{
		 rows = $('#dataTransportAfterTable').datagrid('getSelections');
	}
	
	if(rows.length==0){
		$.messager.alert("提示","请选择中要删除的内容","info");
		return;
	}else{
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				var ps = "";
				$.each(rows, function(i, n) {
					if (i == 0){
						ps += "?id=" + escape(n.sqlId);
					}else{
						ps += "&id=" + escape(n.sqlId);
					}
				});
				
				$.post('deleteDataTransportConfigById' + ps+"&num="+num, function(data) {
					
					if(num == 1){
						$('#dataTransportAgoTable').datagrid('cisreload');
					}else if(num == 2){
						$('#dataTransportConfigTable').datagrid('cisreload');
					}else{
						$('#dataTransportAfterTable').datagrid('cisreload');
					}
					
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}
}


//删除一行数据
//function deleteRow(rowIndex){
//	$.messager.confirm("提示","确定要删除吗?",function(result){
//		if(result){
//			
//			//清除所选的列
//			$('#dataTransportAgoTable').datagrid('clearSelections');
//			$('#dataTransportConfigTable').datagrid('clearSelections');
//			$('#dataTransportAfterTable').datagrid('clearSelections');
//			//获取勾选的行
//			$('#dataTransportAgoTable').datagrid("selectRow",rowIndex-1);
//			$('#dataTransportConfigTable').datagrid("selectRow",rowIndex-1);
//			$('#dataTransportAfterTable').datagrid("selectRow",rowIndex-1);
//			
//			var row ;
//			
//			var row1 = $('#dataTransportAgoTable').datagrid('getSelected');
//			var row2 = $('#dataTransportConfigTable').datagrid('getSelected');
//			var row3 = $('#dataTransportAfterTable').datagrid('getSelected');
//			alert("row1"+ row1);
//			alert("row2"+ row2);
//			alert("row3"+ row3);
//			
//			return ;
//			var ps = "?id="+row.id;
//			$.post("deleteDataTransportConfigById"+ ps,function(data){
//				$('#getDataArithmeticTable').datagrid('cisreload');
//				$.messager.alert('提示', data.mes, 'info');
//			});
//		}
//		
//	});
//	
//}

