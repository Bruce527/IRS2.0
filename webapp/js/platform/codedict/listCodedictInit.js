jQuery(function($) {
	$('#esStatus').combobox({
		url : '../query/codeQueryUrl?codetype=ES_STATUS',
		valueField : 'code',
		textField : 'codeName',
		editable : false
	});
	$('#comId').combobox({
		url : 'listComIdUrl',
		valueField : 'comId',
		textField : 'comName',
		editable : true
	});
	$('#codeType').combobox({
		url : 'codeQueryCodeTypeUrl',
		valueField : 'codeType',
		textField : 'codeType',
		editable : true
	});
	$('#codedictTable').datagrid(
			{
				title : '枚举字典', // 标题
				method : 'post',
				iconCls : 'icon-edit', // 图标
				singleSelect : false, // 多选
				height : 380, // 高度
				fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
				striped : true, // 奇偶行颜色不同
				collapsible : true,// 可折叠
				url : "queryList", // 数据来源
				sortName : 'code_type', // 排序的列
				sortOrder : 'asc', // 正序
				remoteSort : true, // 服务器端排序
				// idField : 'id', // 主键字段
				queryParams : {}, // 查询条件
				pagination : true, // 显示分页
				rownumbers : true, // 显示行号
				columns : [ [ {
					field : 'ck',
					checkbox : true,

					width : 2
				}, // 显示复选框
				{
					field : 'row.codetype',
					title : '枚举类型',
					width : 160,
					sortable : true,
					formatter : function(value, row, index) {
						return row.codetype;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.code',
					title : '枚举编码',
					width : 150,
					sortable : true,
					formatter : function(value, row, index) {
						return row.code;
					}
				}, {
					field : 'row.codename',
					title : '枚举名称',
					width : 160,
					sortable : true,
					formatter : function(value, row, index) {
						return row.codename;
					}
				}, {
					field : 'row.codealias',
					title : '枚举别名',
					width : 250,
					sortable : true,
					formatter : function(value, row, index) {
						return row.codealias;
					}
				}, {
					field : 'row.comidname',
					title : '平台编码',
					width : 130,
					sortable : true,
					formatter : function(value, row, index) {
						return row.comidname;
					}
				}, {
					field : 'row.comid',
					title : '平台编码',
					width : 130,
					sortable : true,
					hidden : true,
					formatter : function(value, row, index) {
						return row.comid;
					}
				}, {
					field : 'row.esstatus1',
					title : '状态标识',
					width : 80,
					sortable : true,
					formatter : function(value, row, index) {
						return row.esstatus1;
					}
				},{
					field : 'row.esstatus',
					title : '状态标识',
					width : 80,
					sortable : true,
					hidden : true,
					formatter : function(value, row, index) {
						return row.esstatus;
					}
				} ] ],
				toolbar : [
						{
							text : '新增',
							iconCls : 'icon-add',
							handler : function() {
								parent.addtab('新增枚举',
												'codedict/addCodedictUrl');
							}
						},'-',
						{
							text : '更新',
							iconCls : 'icon-edit',
							handler : function() {
								var rows = $('#codedictTable').datagrid(
										'getSelections');
								if (rows.length == 0) {
									$.messager.alert('提示', "请选择一个枚举字段进行修改",'info');
									return;
								}
								if (rows.length > 1) {
									$.messager.alert('提示', "只能选择一个枚举字段进行修改",'info');
									return;
								}
								var dlist = [];
								dlist.push({
									"codeType" : rows[0].codetype,
									"code" : rows[0].code,
									"comId" : rows[0].comid
								});
								parent.addtab('更新枚举信息',
										'codedict/updateCodedictUrl?list='
												+ $.toJSON(dlist));
							}
						}, '-', {
							text : '删除',
							iconCls : 'icon-remove',
							handler : function() {
								deleteCodedict();
							}
						}, '-' ],
				onLoadSuccess : function() {
					$('#codedictTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				}
			});
});
// 删除
function deleteCodedict() {
	var rows = $('#codedictTable').datagrid('getSelections');
	if (rows.length == 0) {
		$.messager.alert('提示', "请选择要删除的枚举类型");
		return;
	} else {
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				var ps = "";
				$.each(rows, function(i, n) {
					if (i == 0)
						ps += "?list=" + n.codetype + "@ @" + n.code+"@ @"+n.comid;
					else
						ps += "&list=" + n.codetype + "@ @" + n.code+"@ @"+n.comid;
				});
				$.post('deleteCodedict' + ps, function(data) {
					clearForm();
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}
}
// 表格查询
function searchCodedict() {
	var params = $('#codedictTable').datagrid('options').queryParams; // 先取得
	var fields = $('#codedictForm').serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
		params[field.name] = field.value; // 设置查询参数
	});
	$('#codedictTable').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
}
// 清空查询条件然后进行查询
function clearForm() {
	$('#codedictForm').form('clear');
	searchCodedict();
}
/**
 * 该方法涉及到删除列则必须重写实现
 */
function deleteRow(rowIndex) {
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			// 置空所选
			$('#codedictTable').datagrid('clearSelections');
			// 选中选择列
			$('#codedictTable').datagrid('selectRow', rowIndex - 1);
			var row = $('#codedictTable').datagrid('getSelected');
			var ps = "?list=" + row.codetype + "@ @" + row.code+"@ @"+row.comid;
			var list = 
			$.post('deleteCodedict' + ps, function(data) {
				clearForm();
				$.messager.alert('提示', data.mes, 'info');
			});
		}
	});
}