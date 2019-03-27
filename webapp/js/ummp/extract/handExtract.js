jQuery(function($) {
	initAllCombobox();         //初始化所有下拉框
	initAllDatagrid();         //初始化所有数据表格
});

function initTransportType(comId){
	$('#transType').combobox({
		  url:'../extract/queryListInfo?comId='+comId,
		  valueField:'excId',
		  textField:'excCode',
		  value:''
	  });
}

function initAllCombobox(){
	//传输类型
	$('#comId').combobox({
		  url:'../query/listPlatUrl',
		  editable:false,
		  valueField:'comId',
		  textField:'comName',
//		  onLoadSuccess:function(r){
//				var data = $('#comId').combobox('getData');
//				if(data.length > 0){
//					$('#comId').combobox('setValue',data[0].comId);
//					$('#comId').combobox('setText',data[0].comName);
//				}
//			  },
		  onSelect : function(record){
			  initTransportType(record.comId);
		  }
	 });
		$('#transType').combobox({
			  url:'../extract/queryListInfo',
			  valueField:'excCode',
			  textField:'excCode',
			  value:''
		  });
	// 起始日期选择框
	$('#startDate').datebox({ 
		required:true,
		editable:false
	});
	// 终止日期选择框
	$('#endDate').datebox({
		required:true,
		editable:false
	});
	
}

var verifyTable = null;
function initAllDatagrid(){
		verifyTable = $('#verifyTable').datagrid({
		title : '前置校验列表', //标题
		method : 'post',
		iconCls : 'icon-ok', //图标
		singleSelect : false, //多选
		height : 340, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		url : "../quartz/verifyList", //数据来源
		sortName : 'sqlId', //排序的列
		sortOrder : 'asc', //倒序
		remoteSort : true, //服务器端排序
		idField : 'sqlId', //主键字段
		queryParams : {}, //查询条件
		pagination : true, //显示分页
		rownumbers : true, //显示行号
		pageList:[5,10],
		columns : [ [ {
			field : 'ck',
			checkbox : true,
			width : 2
		}, //显示复选框
		{
			field : 'sqlId',
			title : '主键ID',
			width : 170,
			sortable : true,
			hidden:true,
			formatter : function(value, row, index) {
				return row.sqlId;
			}
		}, 
		{
			field : 'sqlCode',
			title : '算法编码',
			width : 170,
			sortable : true,
			formatter : function(value, row, index) {
				return row.sqlcode;
			}
		}, {
			field : 'sqlDesc',
			title : '算法描述',
			width : 140,
			sortable : true,
			formatter : function(value, row, index) {
				return row.sqlDesc;
			}
		}, {
			field : 'sql',
			title : '算法SQL',
			width : 400,
			sortable : true,
			formatter : function(value, row, index) {
				return row.sqlInfo;
			}
		} , {
			field : 'validate',
			title : '有效性',
			width : 80,
			sortable : true,
			formatter : function(value, row, index) {
				return row.esStatus;
			}
		} ] ],
		onLoadSuccess : function() {
			$('#verifyTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	
}
//清空表单条件
function clearForm(){
	$("#extractForm").form("clear");
}

//手动执行批处理
function execute(){

	if(!$("#extractForm").form("validate")){
		return false;
	}
	var startDate = $("#startDate").datebox("getValue");
	var endDate = $("#endDate").datebox("getValue");
	if(startDate!="" && endDate!=""){
		if(startDate>endDate){
			$.messager.alert("提示","起始日期不能大于终止日期","error");
			return false;
		}
	}
	//提数开始
	$.post("checkExtract",$("#extractForm").serializeArray(),function(data){
		if(data.result == 1 || data.result == "1"){
			var batchs = "批次："+data.batchNo+"<br>";
			batchs += " 状态："+data.stateFlagName;
			batchs += "<br>是否继续?";
			$.messager.confirm("提示","<font style='font-weight:bold'>存在数据</font><br>"+batchs,function(r){
				if(r){
					_extract();
				}
			});
		}else{
			_extract();
		}
	});
}
/**
 * 具体提数
 */
function _extract(){
	var ps = "";
	var rows = verifyTable.datagrid('getSelections');
	$.each(rows, function(i, n) {
		if (i == 0){
			ps += "&id=" + n.sqlId;
		}else{
			ps += "&id=" + n.sqlId;
		}
	});
	if(ps==""){
		ps="&id=0"; //0 代表没参数
	}
	
	var excId = $("#transType").combobox("getValue");	
	$.messager.progress({
		title:'温馨提示',
		msg:"<font style='font-weight:bold'>正在提数,请勿进行其他操作...<font>"
	});
	$.post("handExecuteExtract?excId="+excId+ps,$("#extractForm").serializeArray(),function(data){
		$.messager.alert("提示",data.msg,"info");
		$.messager.progress("close");
	});
}
