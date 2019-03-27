jQuery(function($) {
	$('#monitorCode').combobox({
		url : 'listMonitorNameUrl',
		valueField : 'monitorCode',
		textField : 'monitorCode',
		editable : false,
		onSelect : function(rec) {
			$('#NoticeMainTable').datagrid('options').url = 'NoticeMain';
			$('#NoticeMainTable').datagrid('load', {
				queryParam : rec.monitorCode
			});
			$('#NoticeAddTable').datagrid('options').url = 'NoticeAdd';
			$('#NoticeAddTable').datagrid('load', {
				queryParam : rec.monitorCode
			});
		}
	});
	$('#emailMonitorTable').datagrid(
			{
				title : '邮件通讯列表', // 标题
				method : 'post',
				iconCls : 'icon-ok', // 图标
				singleSelect : false, // 多选
				height : 420, // 高度
				width : 650,
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
				pageSize:20,
				pageList:[10,20,50],
				columns : [ [
						{
							field : 'ck',
							checkbox : true,
							width : 2
						}, // 显示复选框
						{
							field : 'id',
							title : 'id',
							width : 100,
							sortable : true,
							hidden : true,
							formatter : function(value, row, index) {
								return row.ID;
							}
						},
						{
							field : 'ACCOUNTADDR',
							title : '邮箱地址',
							width : 250,
							sortable : true,
							align : 'center',
							formatter : function(value, row, index) {
								return row.ACCOUNTADDR;
							} // 需要formatter一下才能显示正确的数据
						},
						{
							field : 'ACCOUNTUSER',
							title : '用户名',
							width : 120,
							align : 'center',
							sortable : true,
							formatter : function(value, row, index) {
								return row.ACCOUNTUSER;
							}
						},
						{
							field : 'operator',
							title : '操作',
							width : 150,
							align : 'center',
							sortable : true,
							formatter : function(value, row, index) {
								var html = "<div align = 'center'>";
								html += "<a href='#' onclick = \"_SaveMain('"
										+ row.ID + "')\">添加收件人</a>";
								html += "&nbsp;&nbsp; | &nbsp;&nbsp;";
								html += "<a href='#' onclick = \"_SaveAdd('"
										+ row.ID + "')\">添加抄送人</a>";
								html += "</div>";
								return html;
							}
						} ] ],
				toolbar : [
						{
							text : '新增',
							iconCls : 'icon-add',
							handler : function() {
								parent
										.addtab('新增邮箱',
												'emailmonitor/addEmailMonitorUrl');
							}
						},
						'-',
						{
							text : '更新',
							iconCls : 'icon-edit',
							handler : function() {
								var rows = $('#emailMonitorTable')
										.datagrid('getSelections');
								if (rows.length == 0) {
									$.messager.alert('提示', "请选择一个邮箱进行修改", 'info');
									return;
								}
								if (rows.length > 1) {
									$.messager.alert('提示', "只能选择一个邮箱修改", 'info');
									return;
								}
								var dlist = [];
								dlist
										.push({
											"ID" : rows[0].ID,
											"ACCOUNTUSER" : rows[0].ACCOUNTUSER,
											"ACCOUNTADDR" : rows[0].ACCOUNTADDR
										});
								parent.addtab('更新邮箱',
										'emailmonitor/updateEmailMonitorUrl?list='
												+ $.toJSON(dlist));
							}
						}, '-', {
							text : '删除',
							iconCls : 'icon-remove',
							handler : function() {
								deleteEmailMonitor();
							}
						}],
				onLoadSuccess : function() {
					$('#emailMonitorTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				}
	});
	$('#NoticeMainTable').datagrid({
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : false, // 多选
		height : 205, // 高度
		width : 420,
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : 'NoticeMain',
		sortName : 'id', // 排序的列
		sortOrder : 'asc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'id', // 主键字段
		queryParams : {}, // 查询条件
		rownumbers : true, // 显示行号
		columns : [ [ {
			field : 'ck',
			checkbox : true,
			width : 2
		}, // 显示复选框
		{
			field : 'monitorCode',
			title : '事件编码',
			width : 150,
			sortable : true,
			hidden : true,
			formatter : function(value, row, index) {
				return row.monitorCode;
			} // 需要formatter一下才能显示正确的数据
		}, {
			field : 'noticeTo',
			title : '收件邮箱地址',
			width : 250,
			sortable : true,
			formatter : function(value, row, index) {
				return row.noticeTo;
			} // 需要formatter一下才能显示正确的数据
		} ] ],
		toolbar : [{
			text : '收件邮箱',iconCls : 'icon-tip'
		},'-',{
			text : '移出',
			iconCls : 'icon-undo',
			handler : function() {
				deleteNoticeMain();
			}
		}],
		onLoadSuccess : function() {
			$('#NoticeMainTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	$('#NoticeAddTable').datagrid({
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : true, // 多选
		height : 205, // 高度
		width : 420,
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : 'NoticeAdd', // 数据来源
		sortName : 'id', // 排序的列
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'id', // 主键字段
		queryParams : {}, // 查询条件
		rownumbers : true, // 显示行号
		columns : [ [ {
			field : 'ck',
			checkbox : true,
			width : 2
		}, // 显示复选框
		{
			field : 'id',
			title : 'id',
			width : 100,
			sortable : true,
			hidden : true,
			formatter : function(value, row, index) {
				return row.ID;
			}
		}, {
			field : 'monitorCode',
			title : '事件包编码',
			width : 150,
			sortable : true,
			hidden : true,
			formatter : function(value, row, index) {
				return row.monitorCode;
			} // 需要formatter一下才能显示正确的数据
		}, {
			field : 'row.noticeTo',
			title : '抄送邮箱地址',
			width : 250,
			sortable : true,
			formatter : function(value, row, index) {
				return row.noticeTo;
			}
		} ] ],
		toolbar : [{
			text : '抄送邮箱',iconCls : 'icon-tip'
		},'-',{
			text : '移出',
			iconCls : 'icon-undo',
			handler : function() {
				deleteNoticeAdd();
			}
		}],
		onLoadSuccess : function() {
			$('#NoticeAddTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
});

	function _SaveMain(ID) {
		var id = ID;
		var monitorCode = $("#monitorCode").combobox('getValue');
		var array = [];
		if (monitorCode == null || monitorCode == '') {
			$.messager.alert('提示', "请选择事件包", 'info');
			return;
		}
		array.push({
			"monitorCode" : monitorCode,
			"id" : id
		});
		$.ajax({
			url : 'SaveNoticeMain',
			data : 'param=' + $.toJSON(array),
			type : 'post',
			cache : false,
			success : function(data) {
				$('#NoticeMainTable').datagrid('cisreload');
				$.messager.alert("提示信息", data.msg, "info");
				//clearForm();
			}
		});
	}
	// 添加抄送邮箱
	function _SaveAdd(ID) {
		var id = ID;
		var monitorCode = $("#monitorCode").combobox('getValue');
		var array = [];
		if (monitorCode == null || monitorCode == '') {
			$.messager.alert('提示', "请选择事件包", 'info');
			return;
		}
		array.push({
			"monitorCode" : monitorCode,
			"id" : id
		});
		$.ajax({
			url : 'SaveNoticeAdd',
			data : 'param=' + $.toJSON(array),
			type : 'post',
			cache : false,
			success : function(data) {
				$('#NoticeAddTable').datagrid('cisreload');
				$.messager.alert("提示信息", data.msg, "info");
				//clearForm();
			}
		});
	}

	// 删除邮箱
	function deleteEmailMonitor() {
		var rows = $('#emailMonitorTable').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示', "请选择要删除的邮箱", 'info');
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
					$.post('deleteEmailMonitor' + ps, function(data) {
						$('#emailMonitorTable').datagrid('cisreload');
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}

	// 删除抄送邮箱
	function deleteNoticeAdd() {
		var rows = $('#NoticeAddTable').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示', "请选择要移出的邮箱", 'info');
			return;
		} else {
			$.messager.confirm('提示', '确定要移出吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0)
							ps += "?id=" + n.ID;
						else
							ps += "&id=" + n.ID;
					});
					$.post('deleteNoticeAdd' + ps, function(data) {
						$('#NoticeAddTable').datagrid('cisreload');
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}

	// 删除抄送邮箱
	function deleteNoticeMain() {
		var rows = $('#NoticeMainTable').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示', "请选择要移出的邮箱", 'info');
			return;
		} else {
			$.messager.confirm('提示', '确定要移出吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0)
							ps += "?id=" + n.ID;
						else
							ps += "&id=" + n.ID;
					});
					$.post('deleteNoticeMain' + ps, function(data) {
						$('#NoticeMainTable').datagrid('cisreload');
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}
	/**
	 * 选择监控事件包发送
	 */
	function sendEmail() {
		var monitorCode = $("#monitorCode").combobox('getValue');
		if(!monitorCode){
			$.messager.alert("提示信息", "请选择监控时间包", "info");
			return;
		}
		$.messager.progress({
			title:'温馨提示',
			msg:'正在发送邮件...'
		});
		$.ajax({
			url : 'sendMonitorEmail',
			data : 'monitorCode=' + monitorCode,
			type : 'post',
			cache : false,
			success : function(data) {
				$.messager.alert("提示", data.msg, "info");
				$.messager.progress('close');
			}
		});
	}
	function downloadMonitor(){
		var monitorCode = $("#monitorCode").combobox('getValue');
		if(!monitorCode){
			$.messager.alert("提示信息", "请选择监控事件包", "info");
			return;
		}
		var url = "downloadMonitor?"+encodeURI(encodeURI("monitorCode="+monitorCode));
		window.location.href=url;
	}