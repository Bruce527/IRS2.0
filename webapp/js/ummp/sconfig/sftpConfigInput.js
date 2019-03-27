jQuery(function($) {
	$('#comId').combobox({
		  url:'../query/listPlatUrl',
		  valueField:'comId',
		  textField:'comName',
		  onSelect:function(com){
			  qeurySFTPInfo();
		  }
	 });
	$('#roleId').combobox({
		  url:'../query/listRoleUrl',
		  valueField:'id',
		  textField:'rolename',
		  onSelect:function(com){
			  qeurySFTPInfo();
		  }
	  });
});

/**
 * 清空信息
 */
function clearInfo(){
	$('#sftpConfigForm').form('reset');
	$('#roleId').combobox('reload');
	$('#comId').combobox('reload');
}
/**
 * 显示信息
 * @param sendInfo
 */
function showInfo(pojo){
	$('#upUser').val(pojo.upUser);
	$('#upPass').val(pojo.upPass);
	$('#upIP').val(pojo.upIP);
	$('#upPort').val(pojo.upPort);
	$('#upURL').val(pojo.upURL);
	
	$('#downUser').val(pojo.downUser);
	$('#downPass').val(pojo.downPass);
	$('#downIP').val(pojo.downIP);
	$('#downPort').val(pojo.downPort);
	$('#downURL').val(pojo.downURL);
	//重新加载选择
	if(pojo.comId != null){
		reloadComComboBox("comId",pojo.comId);	
	}else{
		$('#comId').combobox('reload');
	}
	if(pojo.roleId != null){
		reloadRoleComboBox("roleId",pojo.roleId);
	}else{
		$('#roleId').combobox('reload');
	}
	
}
/**
 * 保存平台报送信息
 */
function saveSFTPInfo(){
	$.post('saveSFTPInfoUrl',$('form').serialize(),function(data){
		if(data.msg == "success"){
			$.messager.alert("提示","保存成功","info");
			//TODO 成功之事
			$('#comId').combobox('reload');
		}else{
			$.messager.alert("提示",data.msg,"info");
		}
	});
}
/**
 * 查询SFTP信息
 */
function qeurySFTPInfo(){
	$.post('qeurySFTPInfoUrl',$('form').serialize(),function(data){
		if(data.msg == "success"){
			//$.messager.alert("提示","查询成功","info");
			//TODO 成功之事
			showInfo(data.pojo);
		}else{
			$.messager.alert("提示",data.msg,"info");
			clearInfo();
		}
	});
}
/**
 * 重新加载选中的下拉框键值
 * @param id
 * @param value
 */
function reloadComComboBox(id,value){
	var data = $('#'+id).combobox('getData');
	for(var i = 0; i < data.length; i ++){
		if(data[i].code == value){
			$('#'+id).combobox('setValue',data[i].comId);
			$('#'+id).combobox('setText',data[i].comName);
			break;
		}
	}
}
/**
 * 重新加载选中的下拉框键值
 * @param id
 * @param value
 */
function reloadRoleComboBox(id,value){
	var data = $('#'+id).combobox('getData');
	for(var i = 0; i < data.length; i ++){
		if(data[i].code == value){
			$('#'+id).combobox('setValue',data[i].rolecode);
			$('#'+id).combobox('setText',data[i].rolename);
			break;
		}
	}
}