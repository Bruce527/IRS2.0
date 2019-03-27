jQuery(function($) {
		$('#schedulerTable').datagrid({
			title : '作业计划列表', //标题
			method : 'post',
			iconCls : 'icon-edit', //图标
			singleSelect : false, //多选
			height : 400, //高度
			fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped : true, //奇偶行颜色不同
			collapsible : true,//可折叠
			url : "queryList", //数据来源
			sortName : 'job_name', //排序的列
			sortOrder : 'asc', //倒序
			remoteSort : true, //服务器端排序
			idField : 'trigger_name', //主键字段
			queryParams : {}, //查询条件
			pagination : true, //显示分页
			rownumbers : true, //显示行号
			columns : [ [ {
				field : 'ck',
				checkbox : true,
				width : 2
			}, //显示复选框
			{
				field : 'taskName',
				title : '任务名称',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.taskName;
				}
			},
			{
				field : 'description',
				title : '计划描述',
				width : 170,
				sortable : true,
				formatter : function(value, row, index) {
					return row.description;
				}
			},
			{
				field : 'lastTime',
				title : '下次执行时间',
				width : 120,
				sortable : true,
				formatter : function(value, row, index) {
					return row.lastTime;
				}
			}, {
				field : 'prev_fire_time',
				title : '上次执行时间',
				width : 120,
				sortable : true,
				formatter : function(value, row, index) {
					return row.prev_fire_time;
				}
			}, {
				field : 'trigger_state',
				title : '执行状态',
				width : 60,
				sortable : true,
				formatter : function(value, row, index) {
					if(row.trigger_state == "WAITING"){
						return "等待中";
					}else if(row.trigger_state == "PAUSED"){
						return "暂停";
					}else if(row.trigger_state == "ACQUIRED"){
						return "正常执行";
					}else if(row.trigger_state == "BLOCKED"){
						return "阻塞";
					}else{
						return "错误";
					}
				}
			}, {
				field : 'trigger_type',
				title : '类型',
				width : 70,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.trigger_type;
				}
			}, {
				field : 'start_time',
				title : '开始时间',
				width : 120,
				sortable : true,
				formatter : function(value, row, index) {
					return row.start_time;
				}
			}, {
				field : 'end_time',
				title : '结束时间',
				width : 120,
				sortable : true,
				formatter : function(value, row, index) {
					return row.end_time;
				}
			}, {
				field : 'cron_expression',
				title : 'cron表达式',
				width : 140,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.cron_expression;
				}
			}, {
				field : 'repeat_count',
				title : '计划执行次数',
				width : 80,
				sortable : true,
				formatter : function(value, row, index) {
					if(row.repeat_count == -1){
						return "重复执行";
					}
					return row.repeat_count;
				} //需要formatter一下才能显示正确的数据
			}, {
				field : 'repeat_interval',
				title : '执行间隔<font color="red">（单位:秒）</font>',
				width : 110,
				sortable : true,
				formatter : function(value, row, index) {
					if(row.repeat_interval == "5184000"){
						return "";
					}
					return row.repeat_interval;
				} //需要formatter一下才能显示正确的数据
			}, {
				field : 'times_triggered',
				title : '已执行次数',
				width : 100,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.times_triggered;
				} //需要formatter一下才能显示正确的数据
			}, {
				field : 'trigger_name',
				title : '调度名称',
				width : 60,
				sortable : true,
				hidden:true,
				formatter : function(value, row, index) {
					return row.trigger_name;
				} //需要formatter一下才能显示正确的数据
			}  ] ],
			toolbar : [{
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					parent.addtab('新增作业', 'quartz/addSchedulerUrl');
				}
			}, '-', {
				text : '暂停',
				iconCls : 'icon-edit',
				handler : function() {
					$.messager.progress({text:"正在为您暂停任务，请稍等..."});
					pauseScheduler();
					$.messager.progress('close'); 
				}
			}, '-', {
				text : '恢复',
				iconCls : 'icon-edit',
				handler : function() {
					$.messager.progress({text:"正在为您恢复任务，请稍等..."});
					resumeScheduler();
					$.messager.progress('close');  
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					deleteScheduler();
				}
			}, '-'],
			onLoadSuccess : function() {
				$('#schedulerTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
	});
	
	function addSchedulertab(title, href) {
		if (href){  
	        var content = "<iframe scrolling='auto' frameborder='0'  src='"+href+"' style='width:100%;height:100%;'></iframe>";  
		}else {  
            var content = '未实现';  
        }  
		if($('#schedulertab').tabs('exists', title)) {
			$('#schedulertab').tabs('close', title);
			$('#schedulertab').tabs('add', {
				title : title,
	            content:content, 
				closable : true
			});
		}else {   
			$('#schedulertab').tabs('add', {
				title : title,
	            content:content, 
				closable : true
			});
		}
	}
	//更新
	function updateScheduler() {
		var rows = $('#schedulerTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert("提示","请选择一个调度进行修改","info");
			return;
		}
		if(rows.length>1){
			$.messager.alert("提示","只能选择一个调度修改","info");
			return;
		}
		var dlist = [];
		var url = "";
		if(null!=rows[0].privilege.url){
			url = rows[0].privilege.url;
		}
		var system = "";
		if(null!=rows[0].privilege.method){
			system = rows[0].privilege.method;
		}
		dlist.push({"name":rows[0].privilege.privilegename,"url":url,"system":system}); 
		parent.addtab('更新调度', 'scheduler/updateSchedulerUrl?list='+$.toJSON(dlist));
	}
	
	function deleteRow(rowIndex){
		$.messager.confirm("提示","确定要删除吗?",function(){
			//清除所选的列
			$("#schedulerTable").datagrid("clearSelections");
			//获取勾选的行
			$("#schedulerTable").datagrid("selectRow",rowIndex-1);
			var row = $('#schedulerTable').datagrid('getSelected');
			var ps = "?trigger_name="+row.trigger_name;
			$.post("deleteScheduler"+ ps,function(data){
				$('#schedulerTable').datagrid('cisreload');
				$.messager.alert('提示', data.mes, 'info');
			});
			
		});
		
	}
	
	//删除
	function deleteScheduler() {
		var rows = $('#schedulerTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert("提示","请选择要删除的任务","info");
			return;
		}else{
			$.messager.confirm('提示', '确定要删除吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0){
							ps += "?trigger_name=" + escape(n.trigger_name);
						}else{
							ps += "&trigger_name=" + escape(n.trigger_name);
						}
					});
					$.post('deleteScheduler' + ps, function(data) {
						$('#schedulerTable').datagrid('cisreload');
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}
	//暂停
	function pauseScheduler() {
		var rows = $('#schedulerTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert("提示","请选择要暂停的调度","info");
			return;
		}else{
			$.messager.confirm('提示', '确定要暂停吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0){
							ps += "?trigger_name=" + escape(n.trigger_name);
						}else{
							ps += "&trigger_name=" + escape(n.trigger_name);
						}
					});
					$.post('pauseScheduler' + ps, function(data) {
						$('#schedulerTable').datagrid('cisreload');
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}
	
	//恢复
	function resumeScheduler() {
		var rows = $('#schedulerTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert("提示","请选择要恢复的调度","info");
			return;
		}else{
			$.messager.confirm('提示', '确定要恢复吗?', function(result) {
				if (result) {
					var ps = "";
					$.each(rows, function(i, n) {
						if (i == 0){
							ps += "?trigger_name=" + escape(n.trigger_name);
						}else{
							ps += "&trigger_name=" + escape(n.trigger_name);
						}
					});
					$.post('resumeScheduler' + ps, function(data) {
						$('#schedulerTable').datagrid('cisreload');
						$.messager.alert('提示', data.mes, 'info');
					});
				}
			});
		}
	}
	
	//表格查询
	function searchScheduler() {
		var params = $('#schedulerTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields = $('#schedulerForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			params[field.name] = field.value; //设置查询参数
		});
		$('#schedulerTable').datagrid('cisreload'); //设置好查询参数 reload 一下就可以了
	}
	//清空查询条件
	function clearScheduler() {
		$('#schedulerForm').form('clear');
		searchScheduler();
	}