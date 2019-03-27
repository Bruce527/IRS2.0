jQuery(function($) {
	$('#status').combobox({
		  url:'../query/codeQueryUrl?codetype=USER_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  onLoadSuccess:function(r){//做一些默认设置
				var data = $('#status').combobox('getData');
				if(data.length > 0){
					$('#status').combobox('setValue',data[1]. code);
					$('#status').combobox('setText',data[1]. codeName);
				}
			  }

	 	});

$('#licenseType').combobox({
		  url:'../query/codeQueryUrl?codetype=COM_CODE',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  onLoadSuccess:function(r){//做一些默认设置
				var data = $('#licenseType').combobox('getData');
				if(data.length > 0){
					$('#licenseType').combobox('setValue',data[0]. code);
					$('#licenseType').combobox('setText',data[0]. codeName);
				}
			  }
	 	});

$('#innerFid').combobox({
		  url:'../query/codeQueryUrl?codetype=COM_CODE',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  onLoadSuccess:function(r){//做一些默认设置
				var data = $('#innerFid').combobox('getData');
				if(data.length > 0){
					$('#innerFid').combobox('setValue',data[0]. code);
					$('#innerFid').combobox('setText',data[0]. codeName);
				}
			  }
	 	});
})
$('#openDate').datebox({
	editable:false,
	disabled:true,
//	required:true 

	}); 
$('#closeDate').datebox({
	editable:false,
	disabled:true,
//	required:true 

	}); 

// 增加管理机构
	function addManageCom() {
		if($('#addManageComForm').form('validate')){
			$.messager.progress({
				title:'温馨提示',
				msg:'正在提交数据...'
			});
			$.post("saveAdd", $("#addManageComForm").serializeArray(), function(data) {
				$.messager.alert('提示', data.mes, 'info');
				$.messager.progress('close');
				parent.clearForm();
			});
		};
	}