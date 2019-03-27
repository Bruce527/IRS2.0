jQuery(function($){
	initTableGrid();
	$('#platComId').combobox({
		  url:'../query/listPlatUrl',
		  editable:false,
		  valueField:'comId',
		  textField:'comName',
//		  onLoadSuccess:function(r){
//				var data = $('#platComId').combobox('getData');
//				if(data.length > 0){
//					$('#platComId').combobox('setValue',data[0].comId);
//					$('#platComId').combobox('setText',data[0].comName);
//				}
//			  },
		  onSelect : function(record){
			  initTransportType(record.comId);
		  }
	 });
		$('#transportType').combobox({
			  url:'../extract/queryListInfo',
			  valueField:'excCode',
			  textField:'excCode',
			  value:''
		  });
});

function initTransportType(comId){
	$('#transportType').combobox({
		  url:'../extract/queryListInfo?comId='+comId,
		  valueField:'excCode',
		  textField:'excCode',
		  value:''
	  });
}

function initTableGrid(){
	$('#listTable').datagrid({
		title : '传输列表', //标题
		method : 'post',
		iconCls : 'icon-ok', //图标
		singleSelect : false, //多选
		height : 400, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		url : "queryTransportList", //数据来源
		sortName : 'excId', //排序的列
		sortOrder : 'desc', //倒序
		remoteSort : false, //服务器端排序
		idField : 'excId', //主键字段
		queryParams : {}, //查询条件
		pagination : true, //显示分页
		rownumbers : true, //显示行号
		pageList:[5,10],
			columns : [ [ {
				field : 'ck',
				checkbox : true,
				width : 2
			}, //显示复选框
			{
				field : 'excId',
				title : '主键ID',
				width : 170,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.excId;
				}
			},{
				field : 'comId',
				title : '平台名称',
				width : 170,
				sortable : true,
				formatter : function(value, row, index) {
					return row.comName;
				}
			}
			,
			{
				field : 'excCode',
				title : '传输类型',
				width : 200,
				sortable : true,
				formatter : function(value, row, index) {
					return row.excCode;
				}
			}, {
				field : 'excDesc',
				title : '传输描述',
				width : 300,
				sortable : true,
				formatter : function(value, row, index) {
					return row.excDesc;
				}
			}, {
				field : 'exc_num',
				title : '执行排序',
				width : 60,
				sortable : true,
				formatter : function(value, row, index) {
					return row.exc_num;
				}
			}, {
				field : 'rc_status',
				title : '状态',
				width : 60,
				sortable : true,
				formatter : function(value, row, index) {
					return row.rc_status;
				}
			}] ],
		toolbar:[
			       {
			    	   text:'新增',
			    	   iconCls:'icon-add',
			    	   handler:function(){
			    		   //alert("待实现");
			    		   parent.addtab("新增","extract/addUpdateUrl");
			    	   }
			       },{
			    	   text:'更新',
			    	   iconCls:'icon-edit',
			    	   handler:function(){
			    		   var rows = $("#listTable").datagrid("getSelections");
			    		   if(rows.length == 0){
			    			   $.messager.alert("提示","请选择一个进行更新","info");
			    			   return ;
			    		   }
			    		   if(rows.length > 1){
			    			   $.messager.alert("提示","只能选择一个进行更新","info");
			    			   return;
			    		   }
			    		   parent.addtab("修改","extract/updateUrl?id="+rows[0].excId);
			    	   }
			       },
			       {
			    	   text:'配置脚本',
			    	   iconCls:'icon-edit',
			    	   handler:function(){
			    				var rows = $('#listTable').datagrid('getSelections');
			    							if(rows.length==0){
			    								$.messager.alert("提示","请选择一个进行配置脚本","info");
			    								return;
			    							}
			    							if(rows.length>1){
			    								$.messager.alert("提示","只能选择一个配置脚本","info");
			    								return;
			    							}
			    			parent.addtab('更新传输信息', 'extract/updateTransportInfoUrl?s='+ $.toJSON(rows));
			    			}
			       },
			       {
			    	   text:'批量删除',
			    	   iconCls:'icon-cancel',
			    	   handler:function(){
			    		   deleteById();
			    	   }
			       }
			       ],
			       onLoadSuccess : function() {
						$('#listTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
					}
	});
}

function deleteById(){

  //alert("待实现");
   var rows = $('#listTable').datagrid('getSelections');
   if(rows.length==0){
		$.messager.alert("提示","请选择需要删除","info");
		return;
	}else{
		var ps = "";
		$.each(rows, function(i, n) {
			if (i == 0){
				ps += "?id=" + escape(n.excId);
			}else{
				ps += "&id=" + escape(n.excId);
			}
		});
		$.post('../extract/deleteById' + ps, function(data) {
			$('#listTable').datagrid('cisreload');
			$.messager.progress('close');
			if(data.msg=='删除成功'){
				$.messager.alert('提示', data.msg, 'info');
			}
			if(data.msg=='该传输类型已配置SQL,确认删除？'){
				$.messager.confirm('提示',data.msg,function(result){
						if(result){
							$.messager.progress({
								title:'温馨提示',
								msg:'正在删除...'
							});
							$.post('../extract/deleteById'+ps+"&delete=1",function(data){
							$.messager.progress('close');
							$('#listTable').datagrid('cisreload');
							$.messager.alert('提示', data.msg, 'info');
						});
					}
				});
			}
		});
	}
}

/**
 * 该方法涉及到删除列则必须重写实现
 */
function deleteRow(rowIndex){
	//重写实现删除指定列
	//置空所选
	$.messager.progress({
		title:'温馨提示',
		msg:'正在删除...'
	});
	$('#listTable').datagrid('clearSelections');
	//选中选择列
	$('#listTable').datagrid('selectRow',rowIndex-1);
	var row = $('#listTable').datagrid('getSelected');
	var ps = "?id=" + row.excId;
	$.post('../extract/deleteById' + ps, function(data) {
		$('#listTable').datagrid('cisreload');
		$.messager.progress('close');
		if(data.msg=='删除成功'){
			$.messager.alert('提示', data.msg, 'info');
		}
		if(data.msg=='该传输类型已配置SQL,确认删除？'){
			$.messager.confirm('提示',data.msg,function(result){
					if(result){
						$.messager.progress({
							title:'温馨提示',
							msg:'正在删除...'
						});
						$.post('../extract/deleteById'+ps+"&delete=1",function(data){
						$.messager.progress('close');
						$('#listTable').datagrid('cisreload');
						$.messager.alert('提示', data.msg, 'info');
					});
				}
			});
		}
	});
}

//清空查询条件
function resetForm(){
	$("#transportInfoForm").form("clear");
}

//表格查询
function searchTransportList() {
	$('#listTable').datagrid('options').url = 'queryTransportList';
	var queryParam = $('#transportInfoForm').serialize();
	queryParam = formDataToJsonStr(queryParam);
	$('#listTable').datagrid('load',{queryParam:queryParam});
}
//查询
function searchTable(){
	$("#dataTransportAgoTable").datagrid("reload");
	$("#dataTransportConfigTable").datagrid("reload");
	$("#dataTransportAfterTable").datagrid("reload");
} 

