jQuery(function($) {
		$('#roleTable').datagrid({
			title : '角色列表', //标题
			method : 'post',
			iconCls : 'icon-edit', //图标
			singleSelect : false, //多选
			height : 380, //高度
			fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped : true, //奇偶行颜色不同
			collapsible : true,//可折叠
			url : "queryList", //数据来源
			sortName : 'id', //排序的列
			sortOrder : 'asc', //正序
			remoteSort : true, //服务器端排序
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
				field : 'rolename',
				title : '角色名称',
				width : 200,
				sortable : true,
				formatter : function(value, row, index) {
					return row.rolename;
				} //需要formatter一下才能显示正确的数据
			}, {
				field : 'rolecode',
				title : '角色编码',
				width : 200,
				sortable : true,
				formatter : function(value, row, index) {
					return row.rolecode;
				}
			} ] ],
			toolbar : [ {
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					addroletab('新增角色','addRoleUrl');
				}
			}, '-', {
				text : '更新',
				iconCls : 'icon-edit',
				handler : function() {
					var rows = $('#roleTable').datagrid('getSelections');
					if(rows.length==0){
						$.messager.alert('提示', "请选择一个角色进行修改", 'info');
						return;
					}
					if(rows.length>1){
						$.messager.alert('提示', "只能选择一个角色修改", 'info');
						return;
					}
					parent.addtab('更新角色',"role/updateRoleUrl?id="+rows[0].id);
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					deleteRole();
				}
			}, '-', {
				text : '分配菜单',
				iconCls : 'icon-edit',
				handler : function() {
					var rows = $('#roleTable').datagrid('getSelections');
					if(rows.length==0){
						$.messager.alert('提示', "请选择一个角色分配", 'info');
						return;
					}
					if(rows.length>1){
						$.messager.alert('提示', "只能选择一个角色分配", 'info');
						return;
					}
					parent.addtab('分配菜单',"role/setRoleUrl?id="+rows[0].id);
				}
			}, '-', {
				text : '分配平台',
				iconCls : 'icon-edit',
				handler : function() {
					var rows = $('#roleTable').datagrid('getSelections');
					if(rows.length==0){
						$.messager.alert('提示', "请选择一个角色分配", 'info');
						return;
					}
					if(rows.length>1){
						$.messager.alert('提示', "只能选择一个角色分配", 'info');
						return;
					}
					parent.addtab('分配平台',"role/setPlatformUrl?id="+rows[0].id);
				}
			}, '-'],
			onLoadSuccess : function() {
				$('#roleTable').datagrid('clearSelections'); 
			}
		});
	});
	function addroletab(title, href) {
		if (href){  
	        var content = "<iframe scrolling='auto' frameborder='0'  src='"+href+"' style='width:100%;height:100%;'></iframe>";  
		}else {  
            var content = '未实现';  
        }  
		if($('#roletab').tabs('exists', title)) {
			$('#roletab').tabs('close', title);
			$('#roletab').tabs('add', {
				title : title,
	            content:content, 
				closable : true
			});
		}
		else{
			$('#roletab').tabs('add', {
				title : title,
	            content:content, 
				closable : true
			});
		}
	}
	//删除
	function deleteRole() {
		var rows = $('#roleTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示', "请选择要删除的角色", 'info');
			return;
		}else{
			$.messager.confirm('提示', '确定要删除吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0)
							ps += "?rid=" + n.id;
						else
							ps += "&rid=" + n.id;
					});
					$.post('deleteRole' + ps, function(data) {
						$('#roleTable').datagrid('cisreload');
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}
	/**
	 * 该方法涉及到删除列则必须重写实现
	 */
	function deleteRow(rowIndex){
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				//置空非所选
				$('#roleTable').datagrid('clearSelections');
				//选中删除列
				$('#roleTable').datagrid('selectRow',rowIndex-1);
				var row = $('#roleTable').datagrid('getSelected');
				var ps = "?rid=" + row.id;
				$.post('deleteRole' + ps, function(data) {
					$('#roleTable').datagrid('reload');
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}
	//表格查询
	function searchRole() {
		var params = $('#roleTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields = $('#listRoleForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			params[field.name] = field.value; //设置查询参数
		});
		$('#roleTable').datagrid('cisreload'); //设置好查询参数 reload 一下就可以了
	}
	//清空查询条件
	function clearRole() {
		$('#listRoleForm').form('clear');
		searchRole();
	}