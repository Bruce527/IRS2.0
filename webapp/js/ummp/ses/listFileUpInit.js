jQuery(function($) {
	
	$('#UserFileTable').datagrid(
			{
				title : '文件', // 标题
				method : 'post',
				iconCls : 'icon-edit', // 图标
				singleSelect : true, // 多选
				height : 400, // 高度
				fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
				striped : true, // 奇偶行颜色不同
				collapsible : true,// 可折叠
				url : "querylistFileUp", // 数据来源
				//sortName : 'code_type', // 排序的列
				sortOrder : 'asc', // 正序
				remoteSort : true, // 服务器端排序
				idField : 'id', // 主键字段
				//queryParams : {}, // 查询条件
				pagination : true, // 显示分页
				rownumbers : true, // 显示行号
				columns : [ [ {
					field : 'ck',
					checkbox : true,

					width : 2
				}, // 显示复选框
				{
					field : 'row.id',
					title : 'ID',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.ID;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.filetype',
					title : '文件状态',
					width : 120,
					sortable : true,
					formatter : function(value, row, index) {
						return row.FILETYPE;
					}
				}, {
					field : 'row.filename',
					title : '文件名',
					width : 120,
					sortable : true,
					formatter : function(value, row, index) {
						return row.FILENAME;
					}
				}, {
					field : 'row.filepath',
					title : '文件路径',
					width : 400,
					sortable : true,
					formatter : function(value, row, index) {
						return row.FILEPATH;
					}
				} ] ],
				
				onLoadSuccess : function() {
					$('#UserFileTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				}
			});
});

function creatFile(){
	
	if(!$("#UserFileTable").form("validate")){
		return;
	}
	$.messager.progress({
		title:'温馨提示',
		msg:'正在提交数据...'
	});
	$.post('../sestj/creatFile', $("#userForm").serializeArray(), function(data) {
		$.messager.alert('提示', data.mes, 'info');
		$.messager.progress('close');
		$('#UserFileTable').datagrid('reload');

	});
}

function uploadFile() {
	var rows = $('#UserFileTable').datagrid('getSelections');
	if (rows.length == 0) {
		$.messager.alert('提示', "请选择要上传文件", 'info');
		return;
	} else {
		$.messager.confirm('提示', '确定要上传吗?', function(result) {
			if (result) {
				$.messager.progress({
					title:'温馨提示',
					msg:'正在提交数据...'
				});
				var ps = "";
				$.each(rows, function(i, n) {
					if (i == 0)
						ps += "?id=" + n.ID;
					else
						ps += "&id=" + n.ID;
				});
				$.post('xmlupFile' + ps, function(data) {
					
					$.messager.alert('提示', data.mes, 'info');
					$.messager.progress('close');
					$('#UserFileTable').datagrid('cisreload');
					
				});
			}
		});
	}
}

