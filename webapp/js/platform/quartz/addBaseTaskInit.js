jQuery(function($) {
	$('#makedate').datebox({ // 日期选择框
		required : true
	 
	});
	
	$('#job_name').combobox({
		required : true,
		url : 'queryJob',
		valueField : 'job_name',
		textField : 'job_name',
		editable : false
	});
});

function addBaseTask() {
	$.post("saveAddBaseTask", $("#BaseTaskForm").serializeArray(),
			function(data) {
				$.messager.alert('提示', data.mes, 'info');
				parent.clearForm();
			});
}