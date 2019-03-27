jQuery(function($) {
	initAllCombobox(); // 初始化所有下拉框

});

function initAllCombobox(){
	$('#year').combobox({
		  url:'listExportDataYearUrl',
		  valueField:'ExportDataYear',
		  textField:'ExportDataYear'
		  // editable:false
	 });
	
		$('#years').combobox({
			  url:'listExportDataYearUrl',
			  valueField:'ExportDataYear',
			  textField:'ExportDataYear'
			  // editable:false
		 });
	// 传输类型
	$("#transType").combobox({
		 required:true,
		 url:'queryTransType',
		 valueField:'excId',
		 textField:'excCode',
		 editable : false,
		 onSelect:function(rec){
			$.post("getTransDesc?excId=" + rec.excId, function(data) {
				$("#transDesc").val(data.transDesc);
			});
		}
	});
}

// 手动执行批处理
function execute(){
		if(!$("#extractForm").form("validate")){
			return false;
		}
		var year = $("#year").combobox('getValue');
		if(year == ""){
				$.messager.alert("提示","请输入提取年份","error");
				return false;
		}
		var excId = $("#transType").combobox("getValue");
		$.messager.progress({
			title:'温馨提示',
			msg:'正在处理...请稍等'
		});
		$.post("handExecuteExtract?excId="+excId,$("#extractForm").serializeArray(),function(data){
			$.messager.alert("提示",data.msg,"info");
			$.messager.progress("close");
		});
}


function calculationData(){
	var years = $("#years").combobox("getValue");
	if(years==""){
		$.messager.alert("提示","请输入計算年份","error");
		return false;
	}
	$.messager.progress({
		title:'温馨提示',
		msg:'正在处理...请稍等'
	});
	$.post("calcul?time="+years,$("#calculForm").serializeArray(),function(data){
		$.messager.alert("提示",data.msg,"info");
		$.messager.progress("close");
	});
}