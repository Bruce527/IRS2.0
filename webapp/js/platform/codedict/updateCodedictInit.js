jQuery(function($) {
	$('#esStatus').combobox({
		  url:'../query/codeQueryUrl?codetype=ES_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  onLoadSuccess:function(r){// 做一些默认设置
				var data = $('#esStatus').val();
				if(data.length > 0){
					$('#esStatus').combobox('select',data);
			}
		  }
	});
	$('#comId').combobox({
		  url:'listComIdUrl',
		  valueField:'comId',
		  textField:'comName',
		  editable:false,
		  required:false,
		  selective:false,
		  onLoadSuccess:function(r){// 做一些默认设置
				var data = $('#comId').val();
				if(data.length > 0){
					$('#comId').combobox('select',data);
			}
		  }
	});
});

// 更新用户
function updateCodedict(){
	if($('#updateCodedictForm').form('validate')){
		$.messager.progress({
			title:'温馨提示',
			msg:'正在提交数据...'
		});
		$.post("saveUpdate",$("#updateCodedictForm").serializeArray(),function(data){
			$.messager.alert('提示',data.mes,'info');
			$.messager.progress('close');
			parent.clearForm();
		});
	}
}