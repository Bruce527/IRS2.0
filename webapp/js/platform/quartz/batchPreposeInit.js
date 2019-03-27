$(function(){
	initAllCombobox();
	initAllDatagrid();
});

function initAllCombobox(){
	//初始化下拉框  有效性
	$("#validity").combobox({
		 url:'../query/codeQueryUrl?codetype=ES_STATUS',
		 valueField:'code',
		 textField:'codeName',
		 editable : false
	});
	//数据源名称
	$("#dataSourceName").combobox({
		url:'../query/listJdbc?jdbcType=4',
		  valueField:'jdbcCode',
		  textField:'jdbcName',
		 editable : false
	});
}

var getDataArithmeticTable;
function initAllDatagrid(){
		//校验结果列表
		getDataArithmeticTable = $('#getDataArithmeticTable').datagrid({
		title : '校验结果列表', //标题
		method : 'post',
		iconCls : 'icon-edit', //图标
		singleSelect : false, //多选
		height : 360, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		url : "getDataSqlCode", //数据来源
		sortName : 'job_name', //排序的列
		sortOrder : 'asc', //倒序
		remoteSort : false, //服务器端排序
		idField : 'id', //主键字段
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
			title : '主键ID',
			width : 10,
			hidden:true,
			formatter : function(value, row, index) {
				return row.id;
			}
		}, //显示复选框
		{
			field : 'sqlCode',
			title : '算法编码',
			width : 200,
			sortable : true,
			formatter : function(value, row, index) {
				return row.sqlCode ;
			}
		}, {
			field : 'jdbcCode',
			title : '数据源名称',
			width : 150,
			sortable : true,
			formatter : function(value, row, index) {
				return row.jdbcCode;
			}
		}, {
			field : 'sqlDesc',
			title : '算法描述',
			width : 350,
			sortable : true,
			formatter : function(value, row, index) {
				return row.sqlDesc;
			}
		}, {
			field : 'code_alias',
			title : '有效标识',
			width : 80,
			sortable : true,
			formatter : function(value, row, index) {
				return row.code_alias;
			}
		}] ],
		toolbar : [{
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				parent.addtab('校验算法配置', 'quartz/addVerifySqlCodeUrl?flag=BATCH_CONFIG');
			}
		}, '-', {
			text : '更新',
			iconCls : 'icon-edit',
			handler : function() {
				updateScheduler();
			}
		}, '-', {
			text : '批量删除',
			iconCls : 'icon-cancel',
			handler : function() {
				deleteScheduler();
			}
		}, '-'],
		onLoadSuccess : function() {
			$('#getDataArithmeticTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
}
	
//更新
function updateScheduler() {
	var rows = getDataArithmeticTable.datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert("提示","请选择一个进行修改","info");
		return;
	}
	if(rows.length>1){
		$.messager.alert("提示","只能选择一个修改","info");
		return;
	}
	parent.addtab('更新校验算法信息', 'quartz/updateSchedulerUrl?id='+ rows[0].id);
}
//删除一行数据
function deleteRow(rowIndex){
	$.messager.confirm("提示","确定要删除吗?",function(result){
		if(result){
			//清除所选的列
			getDataArithmeticTable.datagrid("clearSelections");
			//获取勾选的行
			getDataArithmeticTable.datagrid("selectRow",rowIndex-1);
			var row = $('#getDataArithmeticTable').datagrid('getSelected');
			var ps = "?id="+row.id;
			$.post("deleteGetDataSqlCode"+ ps,function(data){
				getDataArithmeticTable.datagrid('cisreload');
				$.messager.alert('提示', data.mes, 'info');
			});
		}
		
	});
	
}
	
//删除多行数据
function deleteScheduler() {
	var rows = getDataArithmeticTable.datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert("提示","请选择中要删除的内容","info");
		return;
	}else{
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				var ps = "";
				$.each(rows, function(i, n) {
					if (i == 0){
						ps += "?id=" + escape(n.id);
					}else{
						ps += "&id=" + escape(n.id);
					}
				});
				$.post('deleteGetDataSqlCode' + ps, function(data) {
					getDataArithmeticTable.datagrid('cisreload');
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}
}
	
//表格查询
function searchTable() {
	$('#getDataArithmeticTable').datagrid('options').url = 'getDataSqlCode';
	var queryParam = $('#schedulerForm').serialize();
	queryParam = formDataToJsonStr(queryParam);
	$('#getDataArithmeticTable').datagrid('load',{queryParam:queryParam});
	
}
//清空查询条件
function clearForm() {
	$('#schedulerForm').form('clear');
}
	
	
//保存校验算法信息
function saveSQLInfo(){
	//表单必录框校验
	if(!$("#verifyArithmeticForm").form("validate")){
		return;
	}
	var array = [];
	array.push({
		"effectiveness":$("#effectiveness").combobox("getValue"),
		"sqlType":$("#sqlType").combobox("getValue"),
		"sqlFrom":$("#sqlFrom").combobox("getValue"),
		"sqlInto":$("#sqlInto").combobox("getValue"),
		"bussType":$("#bussType").combobox("getValue"),
		"codingAlgorithms":$("#codingAlgorithms").val(),
		"sql":$("#sql").val(),
		"algorithmDescription":$("#algorithmDescription").val(),
		"promptInformation":$("#promptInformation").val()
	});
	
	$.ajax({
		url:'saveVerify',
		type:'post',
		data:'param='+$.toJSON(array),
		cache:false,
		success:function(data){
			getDataArithmeticTable.datagrid('cisreload');
			$.messager.alert("提示信息",data.msg,"info");
		}
	});
		
	//此方式中文容易乱码建议使用 【$.ajax】
	/*$.post("saveVerify?param="+ encodeURIComponent(param),function(data){
		$.messager.alert("提示信息",data.msg,"info");
	});*/
		
};
	
	
	