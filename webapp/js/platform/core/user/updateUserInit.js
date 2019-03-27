jQuery(function($) {
	$('#userState').combobox({
		  url:'../query/codeQueryUrl?codetype=USER_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  onLoadSuccess:function(r){// 做一些默认设置
				var data = $('#userStatee').val();
				if(data.length > 0){
					$('#userState').combobox('select',data);
			}
	}
	});
	
	$('#isLock').combobox({
		  url:'../query/codeQueryUrl?codetype=IS_LOCK',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  onLoadSuccess:function(r){// 做一些默认设置
				var data = $('#isLockk').val();
				if(data.length > 0 ){
					$('#isLock').combobox('select',data);
				}else{
					
				}
	}
	});
	$('#companyId').combobox({
		  url:'../query/listManageNameUrl',
		  valueField:'id',
		  textField:'manageName',
		  required:true,
		  value:'10101',
		  onLoadSuccess:function(r){// 做一些默认设置
				var data = $('#companyIdd').val();
				if(data.length > 0){
					$('#companyId').combobox('select',data);
				}
			  }
		});
	});
$('#startDate').datebox({
	editable:false,
	disabled:true,
	required:true 
	}); 
$('#endDate').datebox({
	editable:false,
	disabled:true,
	required:true 

	}); 

// 更新用户
function updateUser(){
	if($('#updateUserForm1').form('validate')){
		$.messager.progress({
			title:'温馨提示',
			msg:'正在提交数据...'
		});
			var companyIdValue = $('#companyId').combobox("getValue");
			if (!(/^\d+$/.test(companyIdValue))) {
			$.messager.alert('提示','管理机构错误，请下拉选择','info');
			$.messager.progress('close');
			return;
			}
			$.post("saveUpdate",$("#updateUserForm1").serializeArray(),function(data){
			$.messager.alert('提示',data.mes,'info');
			$.messager.progress('close');
//			parent.clearForm();
		});
	}
}