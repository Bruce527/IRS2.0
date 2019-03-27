	jQuery(function($) {
	$('#esStatus').combobox({
		  url:'../query/codeQueryUrl?codetype=ES_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true
	 	});
	$('#comId').combobox({
		url : 'listComIdUrl',
		valueField : 'comId',
		textField : 'comName',
		editable : false//机构代码只能从已有的平台选取,不能自定义
	});
	});
	//清空表格
	function clearForm(){
		$('#addCodedictForm').form('clear');
	}
// 增加枚举
	function addCodedict() {
		if($('#addCodedictForm').form('validate')){
			$.messager.progress({
				title:'温馨提示',
				msg:'正在提交数据...'
			});
				$.post("saveAdd", $("#addCodedictForm").serializeArray(),function(data){
				$.messager.alert('提示', data.mes, 'info');
				$.messager.progress('close');
			});
		}
	}