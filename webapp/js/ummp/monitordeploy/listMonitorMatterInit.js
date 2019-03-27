jQuery(function($) {
	$('#userTable').datagrid({
		title : '事件包监控事件', // 标题
		method : 'post',
		iconCls : 'icon-ok', // 图标
		singleSelect : false, // 多选
		height : 400, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryListEvent", // 数据来源
		sortName : 'ID', // 排序的列
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
					title : 'ID',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.id;
					}
				},
				{
					field : 'row.ID',
					title : '排序',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.ID;
					}
				},
				{
					field : 'row.monitorCode',
					title : '事件包',
					width : 180,
					sortable : true,
					formatter : function(value, row, index) {
						return row.monitorCode;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.rcStatus',
					title : '事件包标识',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.rcStatus;
					}
				},{
					field : 'row.sqlCode',
					title : '事件编码',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						return row.sqlCode;
					}
				},{
					field : 'row.sqlDesc',
					title : '事件描述',
					width : 300,
					sortable : true,
					formatter : function(value, row, index) {
						return row.sqlDesc;
					}
				},{
					field : 'row.esStatus',
					title : '关联标识',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.esStatus;
					}
				}]],
		toolbar : [{
					text : '事件包复效',
					iconCls : 'icon-edit',
					handler : function() {
						MonitorEffective();
					}
				},{
					text : '事件包失效',
					iconCls : 'icon-edit',
					handler : function() {
						MonitorInvalid();
					}
				}, '-',{
					text : '关联复效',
					iconCls : 'icon-edit',
					handler : function() {
						RelaEffective();
					}
				}, {
					text : '关联失效',
					iconCls : 'icon-edit',
					handler : function() {
						RelaInvalid();
					}
				}, '-',{
					text : '监控事件移除',
					iconCls : 'icon-remove',
					handler : function() {
						deleteEvent();
					}
				}, '-'],
		onLoadSuccess : function() {
			$('#userTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	$('#sqlCode').combobox({
		  url:'listSqlDescUrl',
		  valueField:'sqlCode',
		  textField:'sqlDesc',
		  editable:false
	 	});
	$('#monitorCode').combobox({
		  url:'listMonitorNameUrl',
		  valueField:'monitorCode',
		  textField:'monitorCode',
		  editable:true
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
	function deleteEvent() {
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
					$.post('deleteEvent' + ps, function(data) {
						$.messager.alert('提示', data.mes, 'info');
//						clearForm;
					});
				}
				clearForm();
			});
		}
	}
	// 删除事件包
	function deleteMatter() {
		var monitorCode=$("#monitorCode").combobox('getValue');
		if(monitorCode==null || $.trim(monitorCode)==''){
			$.messager.alert('提示', "包名不能为空,请下拉选！", 'info');
			return;
		}
		$.messager.confirm('提示','确认删除该包名及包名下已配置的监控事件吗?',function(result){
			if(result){
				$.post('deleteMatter?monitorCode='+monitorCode,function(data){
					clearForm();
					$.messager.alert('提示',data.mes,'info');
					reLoad();
				});
			}
		});
	}
	//重新初始化下拉选
	function reLoad(){
		jQuery(function($){
			$('#sqlCode').combobox({
				  url:'listSqlDescUrl',
				  valueField:'sqlCode',
				  textField:'sqlDesc',
				  editable:false
			 	});
			$('#monitorCode').combobox({
				  url:'listMonitorNameUrl',
				  valueField:'monitorCode',
				  textField:'monitorCode',
				  editable:true
			 	});
		});
	}
	// 表格查询
	function searchMatter() {
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
		searchMatter();
	}
	/**
	 * 添加事件、包按钮
	 */
	function addMatter(){
		var monitorCode=$('#monitorCode').combobox("getValue");
		var sqlCode=$('#sqlCode').combobox("getValue");
		if($.trim(monitorCode)=="" || $.trim(sqlCode)==""){
			$.messager.alert('提示',"事件包和事件都不能为空！",'info');
			return;
		}
		var array=[];
		array.push({
			"monitorCode":monitorCode,
			"sqlCode":sqlCode
		});
		$.ajax({
			url:'../monitordeploy/saveEvent',
			data:'param='+$.toJSON(array),
			type:'post',
			cache:false,
			success:function(data){
				$.messager.alert("提示信息",data.msg,"info");
				clearForm();
				reLoad();
			}
		});
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
				$.post('deleteEvent' + ps, function(data) {
					var ps = "?id=" + row.id;
//					searchMatter();
					clearForm();
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}
	function MonitorEffective() {
		var rows = $('#userTable').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示', "请选择要复效的选项", 'info');
			return;
		} 
		if (rows.length > 1) {
			$.messager.alert('提示', "只能复效选择一条", 'info');
			return;
		} 
		if (rows[0].rcStatus =='有效') {
			$.messager.alert('提示', "该选项已经有效", 'info');
			return;
		} 
		var monitorCode= rows[0].monitorCode;
		$.post('MonitorEffective?monitorCode=' + monitorCode, function(data) {
			$.messager.alert('提示', data.mes, 'info');
			 $('#userTable').datagrid('reload');
		});
	}
	function MonitorInvalid() {
		var rows = $('#userTable').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示', "请选择要失效的选项", 'info');
			return;
		} 
		if (rows.length > 1) {
			$.messager.alert('提示', "只能失效选择一条", 'info');
			return;
		} 
		if (rows[0].rcStatus =='无效') {
			$.messager.alert('提示', "该选项已经失效", 'info');
			return;
		} 
		var monitorCode= rows[0].monitorCode;
		$.post('MonitorInvalid?monitorCode=' + monitorCode, function(data) {
			$.messager.alert('提示', data.mes, 'info');
			$('#userTable').datagrid('reload');
		});
	}
	function RelaEffective() {
		var rows = $('#userTable').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示', "请选择要复效的选项", 'info');
			return;
		} 
		if (rows.length > 1) {
			$.messager.alert('提示', "只能复效选择一条", 'info');
			return;
		} 
		if (rows[0].esStatus =='有效') {
			$.messager.alert('提示', "该选项已经有效", 'info');
			return;
		} 
		var id= rows[0].id;
		$.post('RelaEffective?id=' + id, function(data) {
			$.messager.alert('提示', data.mes, 'info');
			$('#userTable').datagrid('reload');
		});
	}
	function RelaInvalid() {
		var rows = $('#userTable').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert('提示', "请选择要失效的选项", 'info');
			return;
		} 
		if (rows.length > 1) {
			$.messager.alert('提示', "只能失效选择一条", 'info');
			return;
		} 
		if (rows[0].esStatus =='无效') {
			$.messager.alert('提示', "该选项已经失效", 'info');
			return;
		} 
		var id= rows[0].id;
		$.post('RelaInvalid?id=' + id, function(data) {
			$.messager.alert('提示', data.mes, 'info');
			$('#userTable').datagrid('reload');
		});
	}
	
	
	