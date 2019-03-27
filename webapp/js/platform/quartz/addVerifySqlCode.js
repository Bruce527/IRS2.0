var flag ;
jQuery(function($){
	flag = $("#flag").val();
	initAllCombobox();
});	

function initAllCombobox(){
	//数据源名称
	$('#dataSourceName').combobox({
		  required : true,	
		  url:'../query/listJdbc?jdbcType=4',
		  valueField:'jdbcCode',
		  textField:'jdbcName',
		  editable : false,
		  value:'dataSourceUMP'
		  
	 });
	//提取类型
	$('#sqlType').combobox({
		 required : true,	
		  url:'../query/codeQueryUrl?codetype=SQL_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
	 });
	//有效性 
	$('#validity').combobox({
		  required : true,
		  url:'../query/codeQueryUrl?codetype=ES_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable : false,
		  value:'1'
	 });
}
 
//提交保存
function commit(){
	
	if(!$("#verifyArithmeticForm").form("validate")){
		return;
	}
	
	var array = [];
	array.push({
				"sqlCode":$("#sqlCode").val(),
				"dataSourceName":$("#dataSourceName").combobox("getValue"),
				"sqlType":$("#sqlType").combobox("getValue"),
				"validity":$("#validity").combobox("getValue"),
				"desc":$("#desc").val(),
				"sql": $("#sql").val() //解决+号提数到后台变成空字符的问题
	});
	$.messager.progress({text:"正在为您提交数据，请稍等..."});
	$.ajax({
		url:'../quartz/saveVerify',
		data:'param='+encodeURIComponent($.toJSON(array))+'&flag='+ flag,
		type:'post',
		cache:false,
		success:function(data){
			$.messager.progress('close');
			$.messager.alert("提示信息",data.msg,"info");
		}
	});
}
