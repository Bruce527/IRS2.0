jQuery(function($){
	initAllCombobox();
});

function initAllCombobox(){
	//有效性 
	$('#esStatus').combobox({
		  required : true,
		  url:'../query/codeQueryUrl?codetype=STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
	 });
	//机构
	 $('#comId').combobox({
		 required : true,
		  url:'listPlatUrl',
		  valueField:'comId',
		  textField:'comName',
		  editable:false
	 });
}

function saveMapping(){
	if(!$("#codeForm").form("validate")){
		return ;
	}
	$.messager.progress({
		title:'温馨提示',
		msg:'正在提交数据...'
	});
	$.post('../mapping/updateCodeMapping',$("#codeForm").serializeArray(),function(data){
		$.messager.alert("提示信息",data.msg,"info");
		$.messager.progress('close');
	});
}
