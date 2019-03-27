jQuery(function($){
	initAllCombobox();
});

function initAllCombobox(){
	$('#exportDataYearSign').combobox({
		  url:'listExportDataYearUrl',
		  valueField:'ExportDataYear',
		  textField:'ExportDataYear'
		  //editable:false
	 });
	
	//目标表名
	$('#exportDataTabSign').combobox({
		 required:true,
		 url:'listExportDataTabUrl',
		 valueField:'tabCode',
		 textField:'tabCode',
		 editable : false,
		 onSelect:function(rec){
			 //debugger;
			 $.post("getExportDataTabName?tabCode=" + rec.tabCode, function(data) {
					$("#exportDataTabDesc").val(data.tabName);
				});
		}
	});
}
/**
 * 点击导出按钮
 * @returns {Boolean}
 */
function exportSubmit(){
	//获取页面参数
	var dataYear=$("#exportDataYearSign").combobox('getValue');
	var tabCode=$("#exportDataTabSign").combobox('getValue');
	var param={
			   "dataYear":dataYear,
   		 	   "tabCode":tabCode
   			  };
	
	if(check()){
		if(tabCode!=""){
			 //打开窗口发送请求
		    window.open('../sess/ReportDataToExcel?param='+encodeURI($.toJSON(param)));
		}else{
			$.messager.alert('提示', "请选择您要导出的表", 'info');
		}
		
	}else{
		return;
	}
	
}
/**
 * 验证输入框中值得合法性
 */
function check(){
	//获取页面输入的参数
	var dataYear=$("#exportDataYearSign").combobox('getValue');
	var tabCode=$("#exportDataTabSign").combobox('getValue');
	var currentDate=parseInt(new Date().getFullYear());
	if($.trim(dataYear)==""){
		$.messager.alert('提示', "请输入年份", 'info');
		return;
	}
	if($.isNumeric(dataYear)){
		//是纯数字，判断有效性
		if(parseInt(dataYear)>=currentDate-9 && parseInt(dataYear)<=currentDate){
			return true;
		}else{
			$.messager.alert('提示', "请输入有效的年份或者选择已有年份", 'info');
			return false;
		}
	}else{
		$.messager.alert('提示', "导出年份中不能含有非数字字符", 'info');
		return false;
	}
}