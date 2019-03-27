jQuery(function($){
	initAllCombobox();
	initTableGrid();
});

function initAllCombobox(){
	$('#codeTypeId').combobox({
		  url:'listCodeTypeUrl',
		  valueField:'codeType',
		  textField:'codeType'
		  //editable:false
	 });
	 $('#comId').combobox({
//		 required : true,
		  url:'listPlatUrl',
		  valueField:'comId',
		  textField:'comName',
		  editable:false
	 });
	//有效性 
	$('#esStatus').combobox({
		  required : true,
		  url:'../query/codeQueryUrl?codetype=STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable : false,
		  value:'1'
	 });
}
function saveMapping(){
	alert("保存-开发中...");
}
function editMapping(){
	
}

var editIndex = undefined;
function initTableGrid(){
	var codeType = $('#codeTypeId').combobox('getValue');
	var comId = $('#comId').combobox('getValue');
	$('#codeMappingGridId').datagrid({
		title : '映射列表', //标题
		method : 'post',
		iconCls : 'icon-ok', //图标
		singleSelect : false, //多选
		height : 400, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		url : "queryMapping", //数据来源
		sortName : 'id', //排序的列
		sortOrder : 'desc', //倒序
		remoteSort : false, //服务器端排序
		idField : 'id', //主键字段
		queryParams : {}, //查询条件
		pagination : true, //显示分页
		rownumbers : true, //显示行号
		pageList:[10,20],
		queryParams:{ 
			codeType: codeType,  		
			comId: comId},
		columns:[[ 
		{field : 'ck',checkbox : true,width : 2},
		{field:'id',title:'主键ID',hidden:false,width:50}, 
		{field:'codeType',title:'编码类型',width:70,align:"center"}, 
		{field:'basicCode',title:'原编码',editor:'checkbox',width:90,align:"center"}, 
		{field:'basicCodeName',title:'原编码名称',editor:'checkbox',width:120,align:'center'}, 
		{field:'targetCode',title:'目标编码',editor:'checkbox',width:100,align:'center'} ,
		{field:'targetCodeName',title:'目标编码名称',editor:'checkbox',width:350,align:'center'},
		{field:'codeAlias',title:'使用标识',editor:'checkbox',width:60,align:'center'},
		{field:'comName',title:'平台机构',editor:'checkbox',width:120,align:'center'},
		{field:'remark',title:'备注',editor:'checkbox',width:80,align:'center'}
		]],
		toolbar:[ {
			    	   text:'新增',
			    	   iconCls:'icon-add',
			    	   handler:function(){
//			    		   initTableGrid();
			    		   parent.addtab("新增代码映射配置","mapping/addCodeMappingUrl");
			    	   }
			       },
			       {
			    	   text:'更新',
			    	   iconCls:'icon-edit',
			    	   handler:function(){
			    		 onUpdate();  
			    		   var rows = $("#codeMappingGridId").datagrid("getSelections");
			    		   if(rows.length == 0){
			    			   $.messager.alert("提示","请选择一个进行更新...","info");
			    			   return;
			    		   }
			    		   if(rows.length > 1){
			    			   $.messager.alert("提示","只能选择一个进行更新!","info");
			    			   return;
			    		   }
			    		   parent.addtab("更新代码映射配置","mapping/updateCodeMappingUrl?id="+rows[0].id);  
			    	   }

//						text : '更新',
//						iconCls : 'icon-edit',
//						handler : function() {
//							var rows = $('#codeMappingGridId').datagrid('getSelections');
//							if (rows.length == 0) {
//								$.messager.alert('提示', "请选择一个进行更新！！", 'info');
//								return;
//							}
//							if (rows.length > 1) {
//								$.messager.alert('提示', "只能选择一个进行修改！！", 'info');
//								return;
//							}
//							parent.addtab('更新代码映射配置', 'mapping/updateCodeMappingUrl?id='+ rows[0].ID);
//						}
					
			       },
			       {
			    	   text:'批量删除',
			    	   iconCls:'icon-cancel',
			    	   handler:function(){
			    		   onDeleteBatch();
			    	   }
			       }
			       ],
			       onLoadSuccess:function(){
			    	   $("#codeMappingGridId").datagrid("clearSelections");
			       }
	});
}
/**
 * 修改
 */
function onUpdate(){
	var checked = $('#codeMappingGridId').datagrid('getChecked');
	if(!checked || checked == null || 'undefined' == checked){
		$.messager.alert("提示","请选择一行进行操作，谢谢！","info");
		$('#codeId').val("");
		$('#basicCode').val("");
		$('#basicCodeName').val("");
		$('#targetCode').val("");
		$('#targetCodeName').val("");
		$('#otherSign').val("");
		$('#remark').val("");
		return ;
	}
	$('#codeId').val(checked[0].ID);
	$('#basicCode').val(checked[0].basicCode);
	$('#basicCodeName').val(checked[0].basicCodeName);
	$('#targetCode').val(checked[0].targetCode);
	$('#targetCodeName').val(checked[0].targetCodeName);
	$('#otherSign').val(checked[0].otherSign);
	$('#remark').val(checked[0].remark);
}
/**
 * 批量删除
 */
function onDeleteBatch(){
	var rows = $('#codeMappingGridId').datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert("提示","请选择要删除的数据","info");
		return;
	}else{
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				var ps = "";
				$.each(rows, function(i, n) {
					if (i == 0){
						ps += "?id=" + escape(n.id);
					}else{
						ps += "&id=" + escape(n.id);
					}
				});
				$.post('../mapping/deleteById' + ps, function(data) {
					$('#codeMappingGridId').datagrid('cisreload');
					$.messager.alert('提示', data.msg, 'info');
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
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			//置空所选
			$('#codeMappingGridId').datagrid('clearSelections');
			//选中选择列
			$('#codeMappingGridId').datagrid('selectRow',rowIndex-1);
			var row = $('#codeMappingGridId').datagrid('getSelected');
			var ps = "?id=" + row.id;
			$.post('../mapping/deleteById' + ps, function(data) {
				$('#codeMappingGridId').datagrid('cisreload');
				$.messager.alert('提示', data.msg, 'info');
			});
		}
	});
}

function endEditing(){
	if(editIndex == undefined){
		return true;
	}
	if($('#codeMappingGridId').datagrid('validateRow',editIndex)){
		$('#codeMappingGridId').datagrid('endEdit',editIndex);
		editIndex = undefined;
		return true;
	}else{
		return true;
	}
}
function onClickCell(index,field){
	if(editIndex != index){
		if(endEditing()){
			$('#codeMappingGridId').datagrid('selectRow',index).datagrid('beginEdit',index);
			var ed = $('#codeMappingGridId').datagrid('getEdit',{index:index,field:field});
			if(ed){
				
			}
			editIndex = index;
		}else{
			setTimeout(function(){
				$('#codeMappingGridId').datagrid('selectRow',editIndex);
			},0);
		}
	}
}
function onEndEdit(index,row){
	var ed = $(this).datagrid('getEditor',{index:index,field:'id'});
	row.codetype = $(ed.target).combobox('getText');
}
//查询
function searchMapping(){
	var params = $('#codeMappingGridId').datagrid('options').queryParams; // 先取得
	var fields = $('#fm').serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
				params[field.name] = field.value; // 设置查询参数
	});
	$('#codeMappingGridId').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
}
//清空表单
function resetForm(){
	$("#fm").form("reset");
	searchMapping();
}

function save(){
	
	if(!$("#codeForm").form("validate")){
		return ;
	}
	$.messager.progress({
		title:'温馨提示',
		msg:'正在提交数据...'
	});
	$.post('../mapping/saveCodeMapping',$("#codeForm").serializeArray(),function(data){
		$.messager.alert("提示信息",data.msg,"info");
		$.messager.progress('close');
	});
		
}