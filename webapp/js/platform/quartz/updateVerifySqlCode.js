jQuery(function($) {
	initAllCombobox();
	
});

function initAllCombobox(){
	
	$('#dataSourceName').combobox({
		  required : true,	
		  url:'../query/codeQueryUrl?codetype=DATASOURCENAME',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
	 });

	//提取类型
	$('#sqlType').combobox({
		 required : true,	
		  url:'../query/codeQueryUrl?codetype=SQL_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
	 });
	
	$("#validity").combobox({
	      required : true,
		  url:'../query/codeQueryUrl?codetype=ES_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
		  
	});

}
		
		



//更新提交表单信息
function saveUpdateSQLInfo(){
	//表单校验
	if(!$("#verifyArithmeticForm").form("validate")){
		return;
	}
	var array = [];
	array.push({
		
		"sqlId":$("#sqlId").val(),
		"sqlCode":$("#sqlCode").val(),
		"dataSourceName":$("#dataSourceName").combobox("getValue"),
		"sqlType":$("#sqlType").combobox("getValue"),
		"validity":$("#validity").combobox("getValue"),
		"desc":$("#desc").val(),
		"sql": $("#sql").val()
		
	});
	
	$.ajax({
		url:'saveUpdateVerify',
		type:'post',
		data:'param='+ encodeURIComponent($.toJSON(array)),
		cache:false,
		success:function(data){
			$.messager.alert("提示信息",data.msg,"info");
		}
	});
}
