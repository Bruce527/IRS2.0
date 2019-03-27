jQuery(function($){
	$('#platComId').combobox({
		  url:'../query/listPlatUrl',
		  valueField:'comId',
		  textField:'comName',
		  required:true
	 });
	 $('#statusId').combobox({
		  url:'../query/codeQuery?codetype=STATUS',
		  valueField:'code',
		  textField:'codeName',
		  required:true
	  });
});
function save(){
	if(!$("#transportInfoForm").form("validate")){
		return ;
	}
	var num=$("#excNum").val();
	if(num>99){
		$.messager.alert('提示',"执行顺序限制在两位数以内,请重新填写！",'info');
		return;
	}
	$.messager.progress({
		title:'温馨提示',
		msg:'正在提交数据...'
	});
	$.post('../extract/updateSave',$("#transportInfoForm").serializeArray(),function(data){
		$.messager.alert("提示信息",data.msg,"info");
		$.messager.progress('close');
	});
} 

function lowerTOupper(){
	var excCode = $("#excCode").val();
	if(excCode != null && excCode != "" && excCode != undefined ){
		excCode = excCode.toLocaleUpperCase();
		$("#excCode").val(excCode);
	}
}



