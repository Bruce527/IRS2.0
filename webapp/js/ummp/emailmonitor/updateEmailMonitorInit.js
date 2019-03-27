jQuery(function($) {})
function updateEmailMonitor(){
	if($('#updateEmailMonitorForm').form('validate')){
		$.messager.progress({
			title:'温馨提示',
			msg:'正在提交数据...'
		})
		$.post("saveUpdate",$("#updateEmailMonitorForm").serializeArray(),function(data){
			$.messager.alert('提示',data.mes,'info');
			$.messager.progress('close');
			parent.clearForm();
		});
	}
}
