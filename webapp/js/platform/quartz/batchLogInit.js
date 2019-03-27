jQuery(function($) {
		initAllCombobox();
		initAllDatagrid();
});
	
function initAllCombobox(){
	//作业
	$("#homework").combobox({
		url : 'queryJob',
		valueField : 'jobName',
		textField : 'description',
		editable : false,
		onSelect : function(data){
			$("#logWork").combobox('setValue',data.jobName)
		}
	});
	//作业
	$("#logWork").combobox({
		url : 'queryJob',
		valueField : 'jobName',
		textField : 'description',
		editable : false
	});
	//执行方式
	$("#run_mode").combobox({
		  url:'../query/codeQueryUrl?codetype=RUN_MODE',
		  valueField:'code',
		  textField:'codeName',
		  editable : false
	});
	//开始日期
	$('#startDate').datetimebox({ // 起始日期选择框
		editable:false,
		required: true,
		showSeconds: false 
		
	});
	//终止日期	
	$('#endDate').datetimebox({ // 终止日期选择框
		editable:false,
		required: true,
		showSeconds: false 
	});
	
}

var homeWorkExecuteTable = null ;	
function initAllDatagrid(){
	homeWorkExecuteTable = $('#homeWorkExecuteTable').datagrid({
		title : '作业执行列表', //标题
		method : 'post',
		iconCls : 'icon-edit', //图标
		singleSelect : false, //多选
		height : 380, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		url : "queryBatchLogList", //数据来源
		sortName : 'job_name', //排序的列
		sortOrder : 'asc', //倒序
		remoteSort : true, //服务器端排序
		idField : 'trigger_name', //主键字段
		queryParams : {}, //查询条件
		pagination : true, //显示分页
		rownumbers : true, //显示行号
		columns : [ [ {
			field : 'ck',
			checkbox : true,
			width : 2
		}, //显示复选框
		{
			field : 'id',
			title : 'ID',
			width : 100
		}, //显示复选框
		{
			field : 'taskName',
			title : '作业名称',
			width : 160,
			sortable : true,
			formatter : function(value, row, index) {
				return row.taskName;
			}
		}, {
			field : 'description',
			title : '计划描述',
			width : 250,
			sortable : true,
			formatter : function(value, row, index) {
				return row.description;
			}
		}, {
			field : 'start_time',
			title : '起始日期',
			width : 120,
			sortable : true,
			formatter : function(value, row, index) {
				return row.start_time;
			}
		}
		, {
			field : 'end_time',
			title : '结束日期',
			width : 120,
			sortable : true,
			formatter : function(value, row, index) {
				return row.end_time;
			}
		}, {
			field : 'executeType',
			title : '执行方式',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				return row.executeType;
			}
		}, {
			field : 'runStatus',
			title : '运行状态',
			width : 140,
			sortable : true,
			hidden:true,
			formatter : function(value, row, index) {
				
				if(row.runStatus == '已结束'){
					return "已结束";
				}
				if(row.runStatus == "WAITING"){
					return "等待中";
				}else if(row.runStatus == "PAUSED"){
					return "暂停";
				}else if(row.runStatus == "ACQUIRED"){
					return "正常执行";
				}else if(row.runStatus == "BLOCKED"){
					return "阻塞";
				}else{
					return "错误";
				}
			}
		}, {
			field : 'logMsg',
			title : '执行状况',
			width : 140,
			sortable : true,
			formatter : function(value, row, index) {
				return row.logMsg;
			}
		}  ] ],
		toolbar:'#logToolBarId',
		onLoadSuccess : function() {
			$('#homeWorkExecuteTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
}	

//清空查询条件
function clearForm() {
	$('#batchLogForm').form('clear');
}
//表格查询
function query() {
	
	homeWorkExecuteTable.datagrid('options').url = 'queryBatchLogList';
	var queryParam = {
			"homework":$("#homework").combobox("getValue"),
			"run_mode":$("#run_mode").combobox("getValue"),
			"startDate":$("#startDate").datetimebox("getValue"),
			"endDate":$("#endDate").datetimebox("getValue")
	};
	queryParam = $.toJSON(queryParam);
	homeWorkExecuteTable.datagrid('reload',{queryParam:queryParam});
}
function clearLog(){
	var logWork = $("#logWork").combobox("getValue");
	var startTime = $("#startTime").combobox("getValue");
	var endTime = $("#endTime").combobox("getValue");
	$.messager.confirm("提示","确定要清空日志吗？",function(r){
		if(r){
			var ps = "?logWork="+logWork+"&startTime="+startTime+"&endTime="+endTime;
			$.post('deleteTriggerLogs'+ps,function(data){
				$('#homeWorkExecuteTable').datagrid('reload');
				$.messager.alert("提示",data.msg,"info");
			});	
		}
	});
}
function deleteRow(rowIndex){
	$.messager.confirm('提示', '确定要删除日志吗?', function(result) {
		if (result) {
			//置空非所选
			$('#homeWorkExecuteTable').datagrid('clearSelections');
			//选中删除列
			$('#homeWorkExecuteTable').datagrid('selectRow',rowIndex-1);
			var row = $('#homeWorkExecuteTable').datagrid('getSelected');
			var ps = "?id=" + row.id;
			$.post('deleteTriggerLog' + ps, function(data) {
				$('#homeWorkExecuteTable').datagrid('reload');
				$.messager.alert('提示', data.msg, 'info');
			});
		}
	});
}