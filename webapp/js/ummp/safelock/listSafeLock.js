jQuery(function($){
	$('#comId').combobox({
		editable : false,
		url:'../query/listPlatUrl',
		valueField:'comId',
		textField:'comName',
		onLoadSuccess : function(data) {
			if (data && data.length > 0) {
				$('#comId').combobox('setValue',data[0].comId);
			}
		},
		onSelect : function(record){}
	 });
	$('#loginType').combobox({
		  url:'../query/codeQuery?codetype=EMPOWER_TYPE',
		  valueField:'code',
		  textField:'codeName', 
		  onLoadSuccess:function(data){
			if(data.length > 0){
				$('#loginType').combobox("setValue",data[0].code);
			}
		  },
		  onSelect:function(data){}
	  });
});
function overRow(t){
	t.className="table_text selectRow";
}
function outRow(t){
	t.className="table_text";
}
function submit(url){
	$.post(url,$('#safeLockForm').serialize(), function(data){
		$.messager.alert("提示",data.msg,"info");
	});
}
//提数锁定
function extractLock(){
	var url = "extractLock";
	submit(url);
}
//提数解锁
function extractUnLock(){
	var url = "extractUnLock";
	submit(url);
}
//报送锁定
function submitLock(){
	var url = "submitLock";
	submit(url);
}
//报送解锁
function submitUnLock(){
	var url = "submitUnLock";
	submit(url);
}
//登录方式锁定
function loginTypeLock(){
	var url = "loginTypeLock";
	submit(url);
}
//登录方式解锁
function loginTypeUnLock(){
	var url = "loginTypeUnLock";
	submit(url);
}