jQuery(function($){
	
	//传输类型
	/*$('#transportType').combobox({
		  url:'../query/codeQueryUrl?codetype=TRANSPORTTYPE',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
	 });*/
	//数据源名称
	$('#jdbcCode').combobox({
		  required : true,	
		  url:'../query/codeQueryUrl?codetype=DATASOURCENAME',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
	 });
	
	$("#esStatus").combobox({
	      required : true,
		  url:'../query/codeQueryUrl?codetype=ES_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
		  
	});
});	

//提交保存
function saveUpdateSql(){
	if(!$("#dataTransportAgoConfigForm").form("validate")){
		return;
	}
	$.post('../monitordeploy/saveUpdateSqlInfo',$("#dataTransportAgoConfigForm").serialize(),function(data){
		$.messager.alert("提示",data.msg,"info");
	});
}
function getSqlParams(){
	var sqlId=$('#sqlId').val();
	$('#getSqlParams').window({
		width:1000, 
		height:400,
		title:'修改SQL参数',
		modal:true,
		href:"addDefinitionSqlParamUrl?id="+sqlId
	}); 
}
//添加参数
function addParam(){
	var code=$('#paramCodeId').val();
	if(code==null || code=='' || code=='undefined'){
		$.messager.alert("提示","请录入参数编码",'info');
		return;
	}
	var name=$('#paramNameId').val();
	if(name==null || name=='' || name=='undefined'){
		$.messager.alert("提示","请录入参数名称",'info');
		return;
	}
	var type=$('#paramType').val();
	if(type==null || type=='' || type=='undefined'){
		$.messager.alert("提示","请录入参数类型",'info');
		return;
	}
	var vType = $('#paramValueType').val();
	if(vType == null || "" == vType || 'undefined' == vType){
		$.messager.alert("提示","请选择参数值类型",'info');
		return ;
	}
	//提交 flag=0新增 1修改
	var url='paramSave?flag=0';
	$.post(url,$('#nodeParamForm').serialize(),function(data){
		$.messager.alert("提示","编码"+code+" " +data.msg,'info');
		clearParam();
		$('#npdg').datagrid('reload');
	});
}
/**
 * 修改参数
 */
function updateParam(){
	var id = $('#id').val();
	if(id == null || "" == id){
		$.messager.alert("提示","请选择一条记录修改",'info');
		return ;
	}
	var code = $('#paramCodeId').val();
	if(code == null || "" == code || 'undefined' == code){
		$.messager.alert("提示","请录入参数编码进行添加",'info');
		return ;
	}
	var name = $('#paramNameId').val();
	if(name == null || "" == name || 'undefined' == name){
		$.messager.alert("提示","请录入参数名称进行修改",'info');
		return ;
	}
	var type = $('#paramType').val();
	if(type == null || "" == type || 'undefined' == type){
		$.messager.alert("提示","请选择参数类型进行修改",'info');
		return ;
	}
	var vType = $('#paramValueType').val();
	if(vType == null || "" == vType || 'undefined' == vType){
		$.messager.alert("提示","请选择参数值类型进行修改",'info');
		return ;
	}
	//TODO 提交操作
	//提交 operater=0 新增 1 修改
	var url='paramSave?flag=1';
	$.post(url,$('#nodeParamForm').serialize(), function(data){
		//TODO SOMETHING
		$.messager.alert("提示","参数 "+name+" "+data.msg,'info');
		//提交完毕清空
		clearParam();
		//提交完毕刷新
		$("#npdg").datagrid('reload');
	});
}
/**
 * 动态确定参数值类型
 */
function changeParamValueType(){
	var value = $('#paramValueTypeId').combobox('getValue');
	$('#paramValueType').val(value);
}
function changeParamType(){
	var type = $('#paramTypeId').combobox('getValue');
	$('#paramType').val(type);
}
function changeParamSubType(){
	var sbType = $('#paramSubTypeId').combobox('getValue');
	$('#paramSubType').val(sbType);
}
//清空
function clearParam(){
	$('#id').val("");
	$('#paramType').val("");
	$('#paramCodeId').val("");
	$('#paramNameId').val("");
	$('#paramValueId').val("");
	$('#paramSubType').val("");
	$('#paramTypeId').combobox("reload");
	$('#paramSubTypeId').combobox("reload");
	$('#paramValueTypeId').combobox("reload");
}
/**
 * 实现Easyui 删除行级操作
 * @param index
 */
function deleteRow(index){
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if(result){
//			try{
				//参数删除
				var paramGrid = $("#npdg");
				if(paramGrid && 'undefined' != paramGrid){
					deleteParam(index);
				}
//			}catch(e){
//				//属性删除
//				var attriGrid = $("#nadg");
//				if(attriGrid && 'undefined' != attriGrid){
//					deleteAttri(index);
//				}
//			}
		}
	});
}
/**
 * 选中参数列执行
 * @param index
 * @param row
 */
function onClickParamRow(index,row){
	var id = row.id;
	var name = row.paramName;
	var type = row.paramType;
	var value = row.paramValue;
	var valueType = row.paramValueType;
	var subType = row.paramSubType;
	var code = row.paramCode;
	$('#id').val(id);
	$('#paramCodeId').val(code);
	$('#paramNameId').val(name);
	$('#paramType').val(type);
	$('#paramValueId').val(value);
	$("#paramTypeId").combobox("setValue",type);
	reloadCombox('paramValueTypeId',valueType);
	$("#paramSubTypeId").combobox("setValue",subType);
}
//重新初始化下拉框
function reloadCombox(id,text){
	var data = $('#'+id).combobox('getData');
	if(data.length > 0){
		var length = data.length;
		for(var i = 0; i < length; i++){
			var tText = data[i].codeName;
			if(tText == text){
				$('#'+id).combobox('setValue',data[i].code);
				$('#'+id).combobox('setText',data[i].codeName);
				break;
			}
		}
	}
}
function deleteParam(index){
	var nodeParamGrid = $('#npdg');
	//置空非所选
	nodeParamGrid.datagrid('clearSelections');
	//选中删除列
	nodeParamGrid.datagrid('selectRow',index-1);
	var row = nodeParamGrid.datagrid('getSelected');
	var ps = "?id=" + row.id;
	$.post('deleteSqlParam' + ps, function(data) {
		nodeParamGrid.datagrid('reload');
	});
}

