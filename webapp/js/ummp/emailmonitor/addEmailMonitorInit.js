jQuery(function($) {
	$('#erStatus').combobox({
		  url:'../query/codeQueryUrl?codetype=USER_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true
//		  onLoadSuccess:function(r){//做一些默认设置
//				var data = $('#status').combobox('getData');
//				if(data.length > 0){
//					$('#status').combobox('setValue',data[1]. code);
//					$('#status').combobox('setText',data[1]. codeName);
//				}
//			  }

	 	});
});

// 增加监控邮箱
	function addEmailMonitor() {
		if($('#addEmailMonitorForm').form('validate')){
			$.messager.progress({
				title:'温馨提示',
				msg:'正在提交数据...'
			});
			$.post("saveEmail", $("#addEmailMonitorForm").serializeArray(), function(data) {
				$.messager.alert('提示', data.mes, 'info');
				$.messager.progress('close');
				parent.clearForm();
			});
		};
	}