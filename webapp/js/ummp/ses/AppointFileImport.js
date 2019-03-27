var logPath = null;
jQuery(function($) {
	$("#targetTable").combobox({
		 required:true,
		 url : '../query/codeQueryUrl?codetype=IMPORT_TABLE',
		 valueField:'code',
		 textField:'code',
		 editable : false,
		 onSelect:function(rec){
				$("#targetTableName").html(rec.codeName);
		}
	}); 
	$('#year').combobox({
		url:'codeQueryCodeTypeUrl', 
		editable : false,
		valueField:'year', 
		textField:'year'
	});
	$.post('../query/listSysPath',{ sysPath: "TEMP_PATH"},function(data){
		logPath = data.path;
		$("#filePath").uploadify({
	        'swf': '../js/uploadify/uploadify.swf',
	        'uploader':'../js/uploadify/uploadify.jsp?logPath='+logPath,
	        'folder': logPath,
	        'auto': false,
	        'multi': false,
	        'method':'post',
	        'removeTimeout':1,
	        'successTimeout':5,
	        'buttonText':'选择文件',
	        'fileTypeDesc':'csv文件',
	        'fileTypeExts':'*.csv',
	        'onInit':function(){
	        	
	        },
	        'onSelect': function(fileObj){
	        	changeFilePath(fileObj);
	        },
	        'onUploadSuccess':function(fileObj,data,response){
	        	submitForm();
	        }
		});
	});
});

/**
 * 为隐藏标签存储文件名和格式，以便数据传输使用
 * @param fileObj
 */
function changeFilePath(fileObj) {
	//清空先 
	appointFileImportForm.fileName.value = "";
	appointFileImportForm.fileType.value = ""; 
	//加载信息 
	var fileName = fileObj.name;
	var typeNumber = fileName.lastIndexOf("."); 
	var fileType = fileName.substring(typeNumber + 1); 
	//赋值 
	appointFileImportForm.fileName.value = fileName; 
	appointFileImportForm.fileType.value = fileType;
	
}
function fileImport() {
	if (!checkData()) {
		return;
	}
	var year = $('#year').combobox('getValue');
	if(year == null || year == ""){
		$.messager.confirm('提示', '未选择年份将会删除表内所有数据，确认继续吗?', function(result) {
				if(result){
					upload();
					return;
				}else{
					return;
				}
		});
	}else{
		upload();
	}
}
/**
 * 检验文件类型
 * 目前只支持.CSV格式文件的导入
 * @returns {Boolean}
 */
function checkData() {

	var tFileType = appointFileImportForm.fileType.value;
	 if (tFileType == ""||tFileType==null) {
			$.messager.alert("提示信息","请先选择文件","info");
			return false;
	}else if (tFileType != "csv") {
		$.messager.alert("提示信息","目前支持 .csv格式文件","info");
		return false;
	}
	if(!$('#appointFileImportForm').form('validate')){
		return false;
	}
	return true;
}
function clearForm() {
	$('#appointFileImportForm').form('clear');
	$("#targetTableName").html('');
}
function upload(){
	$('#filePath').uploadify('upload','*');
}
function submitForm() {
	$.messager.progress({
		title:'温馨提示',
		msg:'正在导入数据...'
	});

	var array = [];
	var fileName = appointFileImportForm.fileName.value;
	var fileType = appointFileImportForm.fileType.value;
	var targetTable = $('#targetTable').combobox('getValue');
	var targetTableName=$("#targetTableName").text();
	//alert(targetTableName);
	//var targetTableName = appointFileImportForm.targetTableName.value;
	var year = $('#year').combobox('getValue');
	var realPath =  logPath+fileName;
	array.push({
		"fileName"		 :  fileName,
		"fileType"		 :  fileType,
		"targetTable"	 :  targetTable,
		"targetTableName":  targetTableName,
		"year"			 :  year,
		"appPath"		 :	realPath
	}); 
	var param = $.toJSON(array);
	$.ajax({
		url		:	"AppointFileImport",
		type	:	"POST",
		data	:	"param="+param,
		cache	:	false,
		success	:	function(data){
			//导入结束后清空隐藏标签内容
			appointFileImportForm.fileName.value = "";
			appointFileImportForm.fileType.value = ""; 
			$.messager.alert("提示信息",data.mes,"info");
			$.messager.progress('close');
		}
	});
}