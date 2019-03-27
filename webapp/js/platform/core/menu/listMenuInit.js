jQuery(function($) {
	$('#privilegeSign').combobox({
		  url:'../query/codeQueryUrl?codetype=STATUS',
		  valueField:'code',
		  textField:'codeName',
		  editable:false
	 	});
		$('#menuTable').datagrid({
			title : '菜单列表', //标题
			method : 'post',
			iconCls : 'icon-edit', //图标
			singleSelect : false, //多选
			height : 380, //高度
			fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped : true, //奇偶行颜色不同
			collapsible : true,//可折叠
			url : "queryList", //数据来源
			sortName : 'privilege.id', //排序的列
			sortOrder : 'asc', //倒序
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
				field : 'id',
				title : '菜单ID',
				width : 80,
				sortable : true,
				formatter : function(value, row, index) {
					return row.id;
				} //需要formatter一下才能显示正确的数据
			}, {
				field : 'privilegename',
				title : '菜单名称',
				width : 160,
				sortable : true,
				formatter : function(value, row, index) {
					return row.privilegename;
				} //需要formatter一下才能显示正确的数据
			}, {
				field : 'privilegecode',
				title : '菜单编码',
				width : 80,
				sortable : true,
				formatter : function(value, row, index) {
					return row.privilegecode;
				}
			}, {
				field : 'privilegeDescribe',
				title : '菜单描述',
				width : 200,
				sortable : true,
				formatter : function(value, row, index) {
					return row.privilegeDescribe;
				}
			},{
				field : 'codeName',
				title : '菜单标志',
				width : 70,
				sortable : true,
				formatter : function(value, row, index) {
					return row.codeName;
				}
			},{
				field : 'url',
				title : '路径',
				width : 400,
				sortable : true,
				formatter : function(value, row, index) {
					return row.url;
				}
			} ] ],
			toolbar : [{
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					parent.addtab('新增菜单', 'menu/addMenuUrl');
				}
			}, '-', {
				text : '更新',
				iconCls : 'icon-edit',
				handler : function() {
					updateMenu();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					deleteMenu();
				}
			}, '-'],
			onLoadSuccess : function() {
				$('#menuTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
	});
	function addMenutab(title, href) {
		if (href){  
	        var content = "<iframe scrolling='auto' frameborder='0'  src='"+href+"' style='width:100%;height:100%;'></iframe>";  
		}else {  
            var content = '未实现';  
        }  
		if($('#menutab').tabs('exists', title)) {
			$('#menutab').tabs('close', title);
			$('#menutab').tabs('add', {
				title : title,
	            content:content, 
				closable : true
			});
		}else {   
			$('#menutab').tabs('add', {
				title : title,
	            content:content, 
				closable : true
			});
		}
	}
	//更新
	function updateMenu() {
		var rows = $('#menuTable').datagrid('getSelections');
					if(rows.length==0){
						$.messager.alert('提示', "请选择一个菜单进行修改", 'info');
						return;
					}
					if(rows.length>1){
						$.messager.alert('提示', "只能选择一个菜单修改", 'info');
						return;
					}
					parent.addtab('更新菜单', "menu/updateMenuUrl?id="+rows[0].id);
	}
	//删除
	function deleteMenu() {
		var rows = $('#menuTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示', "请选择要删除的菜单", 'info');
			return;
		}else{
			$.messager.confirm('提示', '确定要删除吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0){
							ps += "?pid=" + n.id;
						}else{
							ps += "&pid=" + n.id;
						}
					});
					$.post('deleteMenu' + ps, function(data) {
						$('#menuTable').datagrid('cisreload');
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
		
		var menuTableGrid = $('#menuTable');
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				//置空非所选
				menuTableGrid.datagrid('clearSelections');
				//选中删除列
				menuTableGrid.datagrid('selectRow',rowIndex-1);
				var row = menuTableGrid.datagrid('getSelected');
				var ps = "?pid=" + row.id;
				$.post('deleteMenu' + ps, function(data) {
					menuTableGrid.datagrid('reload');
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}
	//表格查询
	function searchMenu() {
		var params = $('#menuTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields = $('#menuForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			params[field.name] = field.value; //设置查询参数
		});
		$('#menuTable').datagrid('cisreload'); //设置好查询参数 reload 一下就可以了
	}
	//清空查询条件
	function clearMenu() {
		$('#menuForm').form('clear');
		searchMenu();
	}