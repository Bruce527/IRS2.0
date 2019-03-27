function updateRole(){
	$.messager.progress({
		title:'温馨提示',
		msg:'正在提交数据...'
	});
		$.post("saveUpdate",$("#updateRoleForm").serializeArray(),function(data){
			$.messager.alert('提示',data.mes,'info');
			$.messager.progress('close');
			parent.clearRole();
		});
		
	}