jQuery(function($) {
	$('#jobtname').combobox({
		url : 'queryJobTnameCombox',
		valueField : 'id',
		textField : 'jobtname',
		onSelect : function() {
			queryJobName();
		}
	});
	
	$('#salechnlTable').datagrid({
		title : '调度信息列表', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : false, // 多选
		height : 350, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "querSchedulerAllocateList", // 数据来源
		sortName : 'id', // 排序的列
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'id', // 主键字段
		queryParams : {}, // 查询条件
		pagination : true, // 显示分页
		rownumbers : true, // 显示行号
		columns : [ [ {
			field : 'ck',
			checkbox : true,
			width : 2
		}, 
		{
			field : 'row.jobtname1',
			title : '基本任务名称',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				 
				return row.jobtname1;
			}  
		},
		
		
		{
			field : 'row.jobtname',
			title : '调度',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				return  ">>>>>>>>>>";
			}
		},

		{
			field : 'row.jobtname2',
			title : '任务处理接口名',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				return row.jobtname2;
			}
		},

		{
			field : 'row.startdate',
			title : '调度关系起始期',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				return row.startdate;
			}
		}, {
			field : 'row.enddate',
			title : '调度关系终止期',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				return row.enddate;
			}
		} ] ],
	
		onLoadSuccess : function() {
			$('#salechnlTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});

});

function addsalechnltab(title, href) {
	 
	if (href) {
		var content = "<iframe scrolling='auto' frameborder='0'  src='" + href
				+ "' style='width:100%;height:100%;'></iframe>";
	} else {
		var content = '未实现';
	}
	if ($('#salechnltab').tabs('exists', title)) {
		$('#salechnltab').tabs('select', title);
		var tab = $('#salechnltab').tabs('getSelected');
		$('#salechnltab').tabs('update', {
			tab : tab,
			options : {
				title : title,
				content : content,
				closable : true
			}
		});
	} else {
		$('#salechnltab').tabs('add', {
			title : title,
			content : content,
			closable : true
		});
	}
}



// 表格查询
function searchSalechnl() {

	var params = $('#salechnlTable').datagrid('options').queryParams; // 先取得
	var fields = $('#salechnlForm').serializeArray(); // 自动序列化表单元素为JSON对象

	$.each(fields, function(i, field) {
		params[field.name] = field.value; // 设置查询参数

	});
	$('#salechnlTable').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
}
// 清空查询条件
function clearForm() {
	$('#salechnlForm').form('clear');
	searchSalechnl();
}
//下拉查询
function queryJobName() {
	$.post("queryJobNameCombox", $("#salechnlForm").serializeArray(), function(
			data) {
		$('#jobname').attr("value", data.jobname);
	});
}