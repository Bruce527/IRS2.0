jQuery(function($) {
	var logPath = $('#logPathId').val();
    $("#uploadify").uploadify({
        'swf': '../js/uploadify/uploadify.swf',
        'uploader': '../js/uploadify/uploadify.jsp?logPath='+logPath,
        'cancelImg': '../js/uploadify/uploadify-cancel.png',
        'folder': logPath,
        'queueID': 'fileQueue',
        'auto': false,
        'multi': true,
        'method':'post',
        'removeTimeout':1,
        'successTimeout':5,
        'buttonText':'选择文件',
        'onInit':function(){
        	
        },
        'onSelect': function(e, queueId, fileObj){
            
        },
        'onUploadSucces':function(file,data,response){
        	alert(file.name+" 上载成功");
        }
    });
  
});
function upload(){
	$('#uploadify').uploadify('upload','*');
}
function uploadCancel(){
	$('#uploadify').uploadify('cancel'); 
	$('#uploadify').uploadify('disable',false); 
}