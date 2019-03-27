jQuery(function($) {
	$('#userTable').datagrid({
		title : '用户列表', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : false, // 多选
		height : 360, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryList", // 数据来源
		sortName : 'USERCODE', // 排序的列
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
					field : 'row.USERNAME',
					title : '用户姓名',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.USERNAME;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.USERCODE',
					title : '用户编码',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.USERCODE;
					}
				},{
					field : 'row.CODENAME',
					title : '用户状态',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.CODENAME;
					}
				},{
					field : 'row.USERDESCRIBE',
					title : '用户描述',
					width : 250,
					sortable : true,
					formatter : function(value, row, index) {
						return row.USERDESCRIBE;
					}
				},{
					field : 'row.COMPANYID',
					title : '所属机构ID',
					width : 150,
					hidden:true,
					sortable : true,
					formatter : function(value, row, index) {
						return row.COMPANYID;
					}
				},{
					field : 'row.COMPANYNAME',
					title : '所属机构',
					width : 180,
					sortable : true,
					formatter : function(value, row, index) {
						return row.COMPANYNAME;
					}
				},{
					field : 'row.CREATORCODE',
					title : '创建者',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.CREATORCODE;
					}
				},{
					field : 'row.USERSTATE',
					title : '状态1',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.USERSTATE;
					}
				},{
					field : 'row.EMAIL',
					title : '邮箱地址',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.EMAIL;
					}
				},{
					field : 'row.EMPOWERCODE',
					title : '认证编码',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.EMPOWERCODE;
					}
				},{
					field : 'row.ISLOCK',
					title : '状态2',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.ISLOCK;
					}
				}]],
		toolbar : [{
					text : '新增',
					iconCls : 'icon-add',
					handler : function() {
						parent.addtab('新增用户', 'user/addUserUrl');
					}
				}, '-', {
					text : '更新',
					iconCls : 'icon-edit',
					handler : function() {
						var rows = $('#userTable').datagrid('getSelections');
						if (rows.length == 0) {
							$.messager.alert('提示', "请选择一个用户进行修改", 'info');
							return;
						}
						if (rows.length > 1) {
							$.messager.alert('提示', "只能选择一个用户修改", 'info');
							return;
						}
						parent.addtab('更新用户', 'user/updateUserUrl?id='+ rows[0].ID);
					}
				}, '-', {
					text : '批量删除',
					iconCls : 'icon-remove',
					handler : function() {
						deleteUser();
					}
				}, '-', {
					text : '分配角色',
					iconCls : 'icon-edit',
					handler : function() {
						var rows = $('#userTable').datagrid('getSelections');
						if (rows.length == 0) {
							parent.addtab('分配角色', 'user/setUserNUrl');
							//addusertab('分配角色', 'setUserNUrl');
							return;
						}
						if (rows.length > 1) {
							$.messager.alert('提示', "只能选择一个用户分配", 'info');
							return;
						}
						parent.addtab('分配角色', 'user/setUserUrl?id=' + rows[0].ID);
						//addusertab('分配角色', 'setUserUrl?id=' + rows[0].ID);
						
					}
				}, '-'],
		onLoadSuccess : function() {
			$('#userTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
});


	function addusertab(title, href) {
		alert(href);
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
			$.messager.alert('提示', "请选择要删除的用户", 'info');
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
					$.post('deleteUser' + ps, function(data) {
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
				var ps = "?id=" + row.ID;
				$.post('deleteUser' + ps, function(data) {
					clearForm();
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}