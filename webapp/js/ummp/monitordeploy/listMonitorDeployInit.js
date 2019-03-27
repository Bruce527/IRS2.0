jQuery(function($) {
	$('#userTable').datagrid({
		title : '监控算法列表', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : false, // 多选
		height : 380, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryList", // 数据来源
		sortName : 'id', // 排序的列
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'id', // 主键字段
		queryParams : {}, // 查询条件
		pagination : true, // 显示分页
		rownumbers : true, // 显示行号
		columns : [[{
					field : 'ck',
					checkbox : true,
					width : 2
				}, // 显示复选框
				{
					field : 'row.id',
					title : 'All',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.id;
					}
				},{
					field : 'row.esStatus',
					title : 'IS',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.esStatus;
					}
				},{
					field : 'row.sqlInfo',
					title : 'WILL',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.sqlInfo;
					}
				},
				{
					field : 'row.sqlCode',
					title : '算法编码',
					width : 180,
					sortable : true,
					formatter : function(value, row, index) {
						return row.sqlCode;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.jdbcCode',
					title : '数据源名称',
					width : 180,
					sortable : true,
					formatter : function(value, row, index) {
						return row.jdbcCode;
					}
				},{
					field : 'row.sqlDesc',
					title : '算法描述',
					width : 300,
					sortable : true,
					formatter : function(value, row, index) {
						return row.sqlDesc;
					}
				},{
					field : 'row.codeName',
					title : '有效标识',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.codeName;
					}
				}]],
		toolbar : [{
					text : '定义',
					iconCls : 'icon-add',
					handler : function() {
						parent.addtab('监控算法定义', 'monitordeploy/addMonitorDeployUrl');
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						var rows = $('#userTable').datagrid('getSelections');
						if (rows.length == 0) {
							$.messager.alert("提示","请选择一个进行修改","info");
							return;
						}
						if (rows.length > 1) {
							$.messager.alert("提示","只能选择一个修改","info");
							return;
						}
						var dlist = [];
						parent.addtab('监控算法修改', 'monitordeploy/updateMonitorDeployUrl?id='+ rows[0].id);
					}
				}, '-', {
					text : '批量删除',
					iconCls : 'icon-remove',
					handler : function() {
						deleteUser();
					}
				}, '-'],
		onLoadSuccess : function() {
			$('#userTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	$('#esStatus').combobox({
		  url:'../query/codeQueryUrl?codetype=USER_STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false/*,
		  required:true*/
	 	});
	$("#jdbcCode").combobox({
		 url:'../query/codeQueryUrl?codetype=DATASOURCENAME',
		 valueField:'code',
		 textField:'codeName',
		 editable : false
		
	});
});

$('#startDate').datebox({
	editable:false,
	disabled:true,
	required:true 

	}); 
$('#endDate').datebox({
	editable:false,
	disabled:true,
	required:true 

	}); 

	function addusertab(title, href) {
		if (href){  
	        var content = "<iframe scrolling='auto' frameborder='0'  src='"+href+"' style='width:100%;height:100%;'></iframe>";  
		}else {  
            var content = '未实现';  
        }  
		if($('#usertab').tabs('exists', title)) {
			$('#usertab').tabs('close', title);
			$('#usertab').tabs('add', {
				title : title,
	            content:content, 
				closable : true
			});
		}
		else{
			$('#usertab').tabs('add', {
				title : title,
	            content:content, 
				closable : true
			});
		}
	} 
	// 删除
	function deleteUser() {
		var rows = $('#userTable').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示', "请选择要删除的选项", 'info');
			return;
		} else {
			$.messager.confirm('提示', '确定要删除吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0)
							ps += "?id=" + n.id;
						else
							ps += "&id=" + n.id;
					});
					$.post('deleteSqlCode' + ps, function(data) {
						clearForm();
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}
	// 表格查询
	function searchUser() {
		var params = $('#userTable').datagrid('options').queryParams; // 先取得
		var fields = $('#userForm').serializeArray(); // 自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
					params[field.name] = field.value; // 设置查询参数
		});
		$('#userTable').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
	}
	// 清空查询条件然后进行查询
	function clearForm() {
		$('#userForm').form('clear');
		searchUser();
	}
	/**
	 * 该方法涉及到删除列则必须重写实现
	 */
	function deleteRow(rowIndex){
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				//置空所选
				$('#userTable').datagrid('clearSelections');
				//选中选择列
				$('#userTable').datagrid('selectRow',rowIndex-1);
				var row = $('#userTable').datagrid('getSelected');
				var ps = "?id=" + row.id;
				$.post('deleteSqlCode' + ps, function(data) {
					clearForm();
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}