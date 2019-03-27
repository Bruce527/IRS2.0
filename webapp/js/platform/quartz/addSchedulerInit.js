jQuery(function($) {
			$("#templatetriggerdiv").hide();
			$("#simpletriggerdiv").show();
			$("#crontriggerdiv").hide();
			$('#trigger_type').combobox({
				onSelect : function(rec) {
					if (rec.value == "simpletrigger") {
						$("#simpletriggerdiv").show();
						$("#crontriggerdiv").hide();
						$("#templatetriggerdiv").hide();
					} else if (rec.value == "crontrigger") {
						$("#crontriggerdiv").show();
						$("#simpletriggerdiv").hide();
						$("#templatetriggerdiv").hide();
					} else if (rec.value == "templatetrigger") {
						$("#templatetriggerdiv").show();
						$("#simpletriggerdiv").hide();
						$("#crontriggerdiv").hide();
					}
				},
				editable : false
			});

			/*$('#job_name').combobox({
						required : true,
						url : 'queryJob',
						valueField : 'jobName',
						textField : 'jobName',
						editable : false
						onSelect:function(rec){
							$.post("getDescInfoByJobName?jobName=" + rec.jobName, function(data) {
								
								$("#planToDescribe").val(data.info);
							});
						}
					});
			 		*/
			//作业
			$("#job_name").combobox({
				url : 'queryJob',
				valueField : 'jobName',
				textField : 'jobName',
				editable : false,
				onSelect:function(rec){
					$.post("getDescInfoByJobName?jobName=" + rec.jobName, function(data) {
						$("#homeworkName").val(data.info);
					});
				}
			});
			$('#executeTime').timespinner({
						showSeconds : true,
						editable : false
					});

			$('#repeatCount').numberspinner({
						min : -1,
						editable : true,
						onSpinUp:function(){
							var value = $(this).val();
							if(value == "0"){
								$(this).val("1");
							}
						},
						onSpinDown:function(){
							var value = $(this).val();
							if(value == "0"){
								$(this).val("-1");
							}
						}
					});
			
			$('#verifyTable').datagrid({
				title : '校验列表', //标题
				method : 'post',
				iconCls : 'icon-edit', //图标
				singleSelect : false, //多选
				height : 300, //高度
				fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
				striped : true, //奇偶行颜色不同
				collapsible : true,//可折叠
				url : "verifyList", //数据来源
				sortName : 'sqlId', //排序的列
				sortOrder : 'asc', //倒序
				remoteSort : true, //服务器端排序
				idField : 'sqlId', //主键字段
				queryParams : {}, //查询条件
				pagination : true, //显示分页
				rownumbers : true, //显示行号
				columns : [ [ {
					field : 'ck',
					checkbox : true,
					width : 2
				}, //显示复选框
				{
					field : 'sqlId',
					title : '主键ID',
					width : 170,
					sortable : true,
					hidden:true,
					formatter : function(value, row, index) {
						return row.sqlId;
					}
				}, 
				{
					field : 'sqlCode',
					title : '算法编码',
					width : 170,
					sortable : true,
					formatter : function(value, row, index) {
						return row.sqlcode;
					}
				}, {
					field : 'sqlDesc',
					title : '算法描述',
					width : 140,
					sortable : true,
					formatter : function(value, row, index) {
						return row.sqlDesc;
					}
				}, {
					field : 'sql',
					title : '算法SQL',
					width : 400,
					sortable : true,
					formatter : function(value, row, index) {
						return row.sqlInfo;
					}
				} , {
					field : 'validate',
					title : '有效性',
					width : 80,
					sortable : true,
					formatter : function(value, row, index) {
						return row.esStatus;
					}
				} ] ],
				onLoadSuccess : function() {
					$('#verifyTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				}
			});
			
		});

function clearForm(){
	$("#addSchedulerForm").form("clear");
	$("#unit").combobox("setValue","86400000");
	$("#delayOperationTimeUnit").combobox("setValue","60");
}

//增加调度
function addScheduler() {
			var rows = $('#verifyTable').datagrid('getSelections');
			var ps = "";
			if(rows.length!=0){
				$.each(rows, function(i, n) {
					if (i == 0){
						ps += "&id=" + escape(n.sqlId);
					}else{
						ps += "&id=" + escape(n.sqlId);
					}
				});
			}else{
				ps+= "&id=" + 0;
			}
				
			//简单调度
			var job_name =  $("#job_name").combobox('getValue');
			var startTime = $("#startTime").datetimebox('getValue');
			var planToDescribe = $("#planToDescribe").val();
			var repeatCount = $("#repeatCount").val();
			var repeatInterval = $("#repeatInterval").val();
			
			if (job_name == null || job_name == "") {
				$.messager.alert('提示', "作业不能为空", 'info');
				return ;
			}
			
			if (startTime == null || startTime == "") {
				$.messager.alert('提示', "开始日期不能为空", 'info');
				return ;
			} 
			
			if (repeatCount == null || repeatCount == "" || repeatCount == "0" ) {
				$.messager.alert('提示', "执行次数输入有误", 'info');
				return ;
			}
			
			if(repeatCount == "1"){
				
			}else{
				
				if (repeatInterval == null || repeatInterval == "") {
					$.messager.alert('提示', "执行间隔不能为空", 'info');
					return ;
				}
				
			}
			if(planToDescribe == null || planToDescribe == ""||planToDescribe == undefined){
				$.messager.alert('提示', "计划描述不能为空", 'info');
				return;
			}
			
			$.messager.progress({
				title:'温馨提示',
				msg:'正在提交数据...'
			});
			//var tPlanToDescribe = encodeURI(encodeURI(planToDescribe));
			var dlist = [];
			dlist.push({
				"trigger_type": "simpletrigger",
				"job_name" : job_name,
				"cron_expression" : $("#cron_expression").val(),
				"startTime" : startTime,
				"endTime" : $("#endTime").val(),
				"repeatCount" : $("#repeatCount").val(),
				"repeatInterval" : $("#repeatInterval").val(),
				"executeTime" : $("#executeTime").timespinner('getValue'),
				"template_type" : $("#template_type").combobox('getValue'),
				"unit" : $("#unit").combobox('getValue'),
				"planToDescribe":planToDescribe
				//,"delayOperationTime":$("#delayOperationTime").val(),
				//"delayOperationTimeUnit" : $("#delayOperationTimeUnit").combobox('getValue'),
				//"trydelayoperationcount":$("#trydelayoperationcount").val()
				});
			$.ajax({
				url:'saveAdd',
				type:'post',
				data:'list='+ encodeURI(encodeURI($.toJSON(dlist)))+ps,
				cache:false,
				success:function(data){
					$.messager.alert('提示', data.mes, 'info');
					$.messager.progress("close");
				}
			});
}

//// 增加调度 原版
//function addScheduler() {
//	
//	//获取触发器类型
//	var trigger_type = $("#trigger_type").combobox('getValue');
//	
//	if(trigger_type == 'simpletrigger'){
//			//简单调度
//			var job_name =  $("#job_name").combobox('getValue');
//			var startTime = $("#startTime").val();
//			var planToDescribe = $("#planToDescribe").val();
//			var repeatCount = $("#repeatCount").val();
//			var repeatInterval = $("#repeatInterval").val();
//			
//			if (job_name == null || job_name == "") {
//				$.messager.alert('提示', "任务名称不能为空", 'info');
//				return ;
//			}
//			
//			if (startTime == null || startTime == "") {
//				$.messager.alert('提示', "开始日期不能为空", 'info');
//				return ;
//			} 
//			
//			if (repeatCount == null || repeatCount == "") {
//				$.messager.alert('提示', "执行次数不能为空", 'info');
//				return ;
//			}
//			
//			if (repeatInterval == null || repeatInterval == "") {
//				$.messager.alert('提示', "执行间隔不能为空", 'info');
//				return ;
//			}
//			
//			if(planToDescribe == null || planToDescribe == ""||planToDescribe == undefined){
//				$.messager.alert('提示', "计划描述不能为空", 'info');
//				return;
//			}
//			
//			var dlist = [];
//			dlist.push({
//						"trigger_type" : $("#trigger_type").combobox('getValue'),
//						"job_name" : job_name,
//						"cron_expression" : $("#cron_expression").val(),
//						"startTime" : startTime,
//						"endTime" : $("#endTime").val(),
//						"repeatCount" : $("#repeatCount").val(),
//						"repeatInterval" : $("#repeatInterval").val(),
//						"executeTime" : $("#executeTime").timespinner('getValue'),
//						"template_type" : $("#template_type").combobox('getValue'),
//						"unit" : $("#unit").combobox('getValue'),
//						"planToDescribe":planToDescribe
//					});
//			$.ajax({
//				url:'saveAdd',
//				type:'post',
//				data:'list='+ $.toJSON(dlist),
//				cache:false,
//				success:function(data){
//					$.messager.alert('提示', data.mes, 'info');
//				}
//			});
//			/*$.post("saveAdd?list=" + $.toJSON(dlist), function(data) {
//						$.messager.alert('提示', data.mes, 'info');
//			});*/
//		
//	}else if(trigger_type == 'templatetrigger'){
//			//Cron模板调度
//			var job_name =  $("#job_name").combobox('getValue');
//			var startTime = $("#executeTime").val();
//			var tempPlanToDescribe = $("#tempPlanToDescribe").val();
//			if (job_name == null || job_name == "") {
//				$.messager.alert('提示', "任务名称不能为空", 'info');
//				return ;
//			}
//			if (startTime == null || startTime == "") {
//				$.messager.alert('提示', "执行时间不能为空", 'info');
//				return ;
//			}
//			if (tempPlanToDescribe == null || tempPlanToDescribe == "") {
//				$.messager.alert('提示', "计划描述不能为空", 'info');
//				return ;
//			}
//			
//			var dlist = [];
//			dlist.push({
//							"trigger_type" : $("#trigger_type").combobox('getValue'),
//							"job_name" : job_name,
//							"cron_expression" : $("#cron_expression").val(),
//							//"startTime" : startTime,
//							//"endTime" : $("#endTime").val(),
//							"repeatCount" : $("#repeatCount").val(),
//							"repeatInterval" : $("#repeatInterval").val(),
//							"executeTime" : $("#executeTime").timespinner('getValue'),
//							"template_type" : $("#template_type").combobox('getValue'),
//							"unit" : $("#unit").combobox('getValue'),
//							"tempPlanToDescribe":tempPlanToDescribe
//								
//					});
//			
//				$.ajax({
//					url:'saveAdd',
//					type:'post',
//					data:'list='+ $.toJSON(dlist),
//					cache:false,
//					success:function(data){
//						$.messager.alert('提示', data.mes, 'info');
//					}
//				});
//			/*$.post("saveAdd?list=" + $.toJSON(dlist), function(data) {
//						$.messager.alert('提示', data.mes, 'info');
//			});*/
//		
//	}else{
//			//Cron表达式调度
//			var job_name =  $("#job_name").combobox('getValue');
//			var cron_expression = $("#cron_expression").val();
//			var cronlanToDescribe = $("#cronlanToDescribe").val();
//			
//			if (job_name == null || job_name == "") {
//				$.messager.alert('提示', "任务名称不能为空", 'info');
//				return ;
//			}
//			if (cron_expression == null || cron_expression == "") {
//				$.messager.alert('提示', "Cron表达式不能为空", 'info');
//				return ;
//			}
//			
//			
//			if (cronlanToDescribe == null || cronlanToDescribe == "") {
//				$.messager.alert('提示', "描述信息不能为空", 'info');
//				return ;
//			}
//			
//			var dlist = [];
//			dlist.push({
//						"trigger_type" : $("#trigger_type").combobox('getValue'),
//						"job_name" : job_name,
//						"cron_expression" : $("#cron_expression").val(),
//						"repeatCount" : $("#repeatCount").val(),
//						"repeatInterval" : $("#repeatInterval").val(),
//						"executeTime" : $("#executeTime").timespinner('getValue'),
//						"template_type" : $("#template_type").combobox('getValue'),
//						"unit" : $("#unit").combobox('getValue'),
//						"cronlanToDescribe":cronlanToDescribe
//					});
//			
//			$.ajax({
//				url:'saveAdd',
//				type:'post',
//				data:'list='+ $.toJSON(dlist),
//				cache:false,
//				success:function(data){
//					$.messager.alert('提示', data.mes, 'info');
//				}
//			});
//			/*$.post("saveAdd?list=" + $.toJSON(dlist), function(data) {
//						$.messager.alert('提示', data.mes, 'info');
//			});*/
//	    }
//}