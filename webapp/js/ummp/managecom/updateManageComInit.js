jQuery(function($) {
	$('#status').combobox({
		  url:'../query/codeQueryUrl?codetype=USER_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true
	 	});

		$('#licenseType').combobox({
			  url:'../query/codeQueryUrl?codetype=COM_CODE',
			  valueField:'code',
			  textField:'codeName',
			  editable:false,
			  required:true
		 	});
			$('#innerFid').combobox({
				  url:'../query/codeQueryUrl?codetype=COM_CODE',
				  valueField:'code',
				  textField:'codeName',
				  editable:false,
				  required:true
			 	});
	})
$('#openDate').datebox({
	editable:false,
	disabled:true,
	required:true 

	}); 
$('#closeDate').datebox({
	editable:false,
	disabled:true,
	required:true 

	}); 


//更新管理机构
function updateManageCom(){
	if($('#updateManageComForm').form('validate')){
		$.messager.progress({
			title:'温馨提示',
			msg:'正在提交数据...'
		})
		$.post("saveUpdate",$("#updateManageComForm").serializeArray(),function(data){
			$.messager.alert('提示',data.mes,'info');
			$.messager.progress('close');
			parent.clearForm();
		});
	}
}