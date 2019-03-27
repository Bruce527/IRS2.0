function doOk(){
	$('#addFileDirId').form({
		url:'addFileDir'
	});
}
function doCancel(){
	alert(1);
	/*
	$('#newDirWin').window({
		onBeforeClose:function(){
			if(confirm('友情提示：是否确定退出？')){
				$('#newDirWin').window('close',true);
			}else{
				return false;
			}
		}
	});
	*/
}