jQuery(function($) {
	$('#comId').combobox({
		  url:'../query/listPlatUrl',
		  valueField:'comId',
		  textField:'comName',
		  onLoadSuccess:function(r){
			var data = $('#comId').combobox('getData');
			if(data.length > 0){
				$('#comId').combobox('setValue',data[0].comId);
				$('#comId').combobox('setText',data[0].comName);
				initComInfo(data[0]);
			}
		  } ,
		  onSelect:function(com){
			  initComInfo(com);
		  }
	 });
	$('#sendType').combobox({
		  url:'../query/codeQueryUrl?codetype=SEND_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#sendType').combobox('getData');
			if(data.length > 0){
				$('#sendType').combobox('setValue',data[0].code);
				$('#sendType').combobox('setText',data[0].codeName);
			}
		  }
	  });
});
/**
 * 初始化、显示报送平台相应的配置
 * @param com
 */
function initComInfo(com){
	$.post('showComInfoUrl?comId='+com.comId,function(data){
		if(data.msg == "success"){
			var sendInfo = data.info;
			showInfo(sendInfo);
		}else{
			clearInfo();
			$.messager.alert("提示",com.comName+" "+data.msg,"info");
		}
	});
}
/**
 * 清空信息
 */
function clearInfo(){
	$('#id').val("");
	$('#sendUser').val("");
	$('#sendPass').val("");
	$('#maxCount').val("");
	$('#minCount').val("");
	$('#sendApi').val("");
	$('#batchCount').val("");
}
/**
 * 显示信息
 * @param sendInfo
 */
function showInfo(sendInfo){
	$('#id').val(sendInfo.id);
	$('#sendUser').val(sendInfo.sendUser);
	$('#sendPass').val(sendInfo.sendPass);
	$('#maxCount').val(sendInfo.maxCount);
	$('#minCount').val(sendInfo.minCount);
	$('#sendApi').val(sendInfo.sendApi);
	$('#batchCount').val(sendInfo.batchCount);
	reloadSendType("sendType",sendInfo.sendType);
}
/**
 * 保存平台报送信息
 */
function saveSendInfo(){
	$.post('saveSendInfoUrl',$('form').serialize(),function(data){
		if(data.msg == "success"){
			$.messager.alert("提示","保存成功","info");
			//重新刷新
			$('#comId').combobox('reload');
		}else{
			$.messager.alert("提示",data.msg,"info");
		}
	});
}
/**
 * 重新加载选中的下拉框键值
 * @param id
 * @param value
 */
function reloadSendType(id,value){
	var data = $('#'+id).combobox('getData');
	for(var i = 0; i < data.length; i ++){
		if(data[i].code == value){
			$('#'+id).combobox('setValue',data[i].code);
			$('#'+id).combobox('setText',data[i].codeName);
			break;
		}
	}
}