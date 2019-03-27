jQuery(function($) {
	$('#erStatus').combobox({
		url : '../query/codeQueryUrl?codetype=USER_STATUS',
		valueField : 'code',
		textField : 'codeName',
		editable : false,
		required : true,
		onLoadSuccess:function(data){
			if(data!= null && data.length > 0){
				$('#erStatus').combobox('setValue',data[0].code);
			}
		}
	});
	$.post('queryFAccount',function(data){
		if(data!=null&&data!=''){
			$('#webAddress').val(data.webAddress);
			$('#webPort').val(data.webPort);
			$('#accountUser').val(data.accountUser);
			$('#accountAddr').val(data.accountAddr);
			$('#accountPass').val(data.accountPass);
			$('#erStatus').combobox('select',data.erStatus);
		}if(data==null || data==''){
			$.messager.alert('提示', '发件人不存在，请重新配置', 'info');
		}
	});
	
});

/**
 * 保存邮箱服务器配置
 */
function saveEmail() {
	if ($('#emailMonitorForm').form('validate')) {
		$.messager.progress({
			title : '温馨提示',
			msg : '正在提交数据...'
		});
		$.post("saveAdd", $("#emailMonitorForm").serializeArray(), function(
				data) {
			$('#emailMonitorTable').datagrid('cisreload');
			$.messager.alert('提示', data.mes, 'info');
			$.messager.progress('close');
			parent.clearForm();
		});
	}
	;
}

// 清空查询条件然后进行查询
function clearEmail() {
	$('#emailMonitorForm').form('clear');
}