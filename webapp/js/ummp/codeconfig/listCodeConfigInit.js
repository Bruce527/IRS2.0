jQuery(function($) {
	$('#codeConfigTable').datagrid({
		title : '已定义转码算法信息', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : true, // 多选
		height : 400, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryList", // 数据来源
		sortName : 'ID', // 排序的列
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'ID', // 主键字段
		queryParams : {}, // 查询条件
		pagination : true, // 显示分页
		rownumbers : true, // 显示行号
		columns : [[{
					field : 'ck',
					checkbox : true,
					width : 2
				}, // 显示复选框
				{
					field : 'row.ID',
					title : 'ID',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.ID;
					}
				},
				{
					field : 'row.TARGETTABLENAME',
					title : '目标表',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.TARGET_TABLE_NAME;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.TARGETCOLNAME',
					title : '目标字段',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.TARGET_COL_NAME;
					}
				},{
					field : 'row.CODETYPE',
					title : '参考映射',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.CODE_TYPE;
					}
				},{
					field : 'row.TATATYPE',
					title : '数据源',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.DATA_TYPE;
					}
				}]],
		toolbar : [{
					text : '更新',
					iconCls : 'icon-edit',
					handler : function() {
						var rows = $('#codeConfigTable').datagrid('getSelections');
						if (rows.length == 0) {
							alert("请选择一个算法进行修改");
							return;
						}
						if (rows.length > 1) {
							alert("只能选择一个算法修改");
							return;
						}
						var	targetTableName= rows[0].TARGET_TABLE_NAME;
						var targetColName=rows[0].TARGET_COL_NAME;
						var id=rows[0].ID;
						var codeType= rows[0].CODE_TYPE;
						var dataType=rows[0].DATA_TYPE;
						$("#targetTableName").val(targetTableName);
						$("#targetColName").val(targetColName);
						$("#id").val(id);
						$("#codeType").val(codeType);
						$("#dataType").val(dataType);
						jQuery(function($) {
							$('#targetTableName').combobox({
								  url:'../codeconfig/listCodeTypeUrl',
								  valueField:'TARGET_TABLE_NAME',
								  textField:'TARGET_TABLE_NAME',
								  onLoadSuccess:function(r){//做一些默认设置
										var data=rows[0].DATA_TYPE;
										if(data.length > 0){
											$('#targetTableName').combobox('select',data);
										}
								  }
							});
							$('#targetColName').combobox({
								  url:'../codeconfig/listCodeTypeUrl',
								  valueField:'TARGET_COL_NAME',
								  textField:'TARGET_COL_NAME',
								  onLoadSuccess:function(r){//做一些默认设置
										var data=rows[0].DATA_TYPE;
										if(data.length > 0){
											$('#targetColName').combobox('select',data);
										}
								  }
							});
							$('#dataType').combobox({
								  url:'../codeconfig/listCodeTypeUrl',
								  valueField:'DATA_TYPE',
								  textField:'DATA_TYPE',
								  onLoadSuccess:function(r){//做一些默认设置
										var data=rows[0].DATA_TYPE;
										if(data.length > 0){
											$('#dataType').combobox('select',data);
										}
								  }
							});
							$('#codeType').combobox({
								  url:'../mapping/listCodeTypeUrl',
								  valueField:'codeType',
								  textField:'codeType',
								  onLoadSuccess:function(r){//做一些默认设置
										var data=rows[0].DATA_TYPE;
										if(data.length > 0){
											$('#codeType').combobox('select',data);
										}
								  }
							});
						});
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						deleteCode();
					}
				}, '-'],
		onLoadSuccess : function() {
			$('#codeConfigTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	$('#codeType').combobox({
		  url:'../mapping/listCodeTypeUrl',
		  valueField:'codeType',
		  textField:'codeType'
	});
	$('#dataType').combobox({
		  url:'../codeconfig/listCodeTypeUrl',
		  valueField:'DATA_TYPE',
		  textField:'DATA_TYPE'
	});
	$('#targetTableName').combobox({
		  url:'../codeconfig/listCodeTypeUrl',
		  valueField:'TARGET_TABLE_NAME',
		  textField:'TARGET_TABLE_NAME'
	});
	$('#targetColName').combobox({
		  url:'../codeconfig/listCodeTypeUrl',
		  valueField:'TARGET_COL_NAME',
		  textField:'TARGET_COL_NAME'
	});
	
});
	// 删除
	function deleteCode() {
		var rows = $('#codeConfigTable').datagrid('getSelections');
		if (rows.length == 0) {
			alert("请选择要删除的菜单");
			return;
		} else {
			$.messager.confirm('提示', '确定要删除吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0)
							ps += "?id=" + n.ID;
						else
							ps += "&id=" + n.ID;
					});
					$.post('deleteCode' + ps, function(data) {
						clearCode();
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}
	// 表格查询
	function searchCode() {
		var params = $('#codeConfigTable').datagrid('options').queryParams; // 先取得
		var fields = $('#CodeConfigForm').serializeArray(); // 自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
					params[field.name] = field.value; // 设置查询参数
		});
		$('#codeConfigTable').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
	}
	// 清空查询条件然后进行查询
	function clearCode() {
		$('#CodeConfigForm').form('clear');
		searchCode();
	}
	/**
	 * 该方法涉及到删除列则必须重写实现
	 */
	function deleteRow(rowIndex){
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				//置空所选
				$('#codeConfigTable').datagrid('clearSelections');
				//选中选择列
				$('#codeConfigTable').datagrid('selectRow',rowIndex-1);
				var row = $('#codeConfigTable').datagrid('getSelected');
				var ps = "?id=" + row.ID;
				$.post('deleteCode' + ps, function(data) {
					clearCode();
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}