jQuery(function($) {
	initAllCombobox();         //初始化所有下拉框
});

function initAllCombobox(){
	// 平台机构ID
	$('#platComId').combobox({
		  required:true,	
		  url:'../query/listPlatUrl',
		  valueField:'comId',
		  textField:'comName',
		  onLoadSuccess:function(r){
			var data = $('#platComId').combobox('getData');
			if(data.length > 0){
				$('#platComId').combobox('setValue',data[0].comId);
				 initBussType(data[0].comId);
			}
		  },
		  onSelect : function(record){
			  var comId = record.comId;
			  initBussType(comId);
		  }
	 });
	// 起始日期选择框
	$('#startDate').datebox({});//可编辑
	// 终止日期选择框
	$('#endDate').datebox({});//可编辑
}
//二级联动业务类型
function initBussType(comId){
	$('#bussTypeId').combobox({
		  required:true,
		  url:'../query/codeQueryByCom?codetype=BUSS_TYPE&comid='+comId,
		  valueField:'code',
		  textField:'codeName',
		  onSelect : function(data){
			  if(data != null){
				  var bussType = data.code;
				  if(bussType == "SummaryCheck" 
					  || bussType == "SummaryCheckResultQuery" ){
					  $('#batchNo').val("");
					  $('#batchNo').attr("readonly","readonly");
				  }else{
					  $('#batchNo').removeAttr("readonly"); 
				  }
			  }
		  }
	  });
}


var t_def_action_return = null;
function initAllDatagrid(){
		t_def_action_return = $('#t_def_action_return').datagrid({
		title : '校验列表', //标题
		method : 'post',
		iconCls : 'icon-edit', //图标
		singleSelect : false, //多选
		height : 250, //高度
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		sortName : 'sqlId', //排序的列
		sortOrder : 'asc', //倒序
		remoteSort : true, //服务器端排序
		idField : 'sqlId', //主键字段
		queryParams : {}, //查询条件
		pagination : true, //显示分页
		rownumbers : true, //显示行号
		pageList:[5,10],
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
			$('#t_def_action_return').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	
}

//清空表单条件
function clearForm(){
	$("#submitForm").form("clear");
}

//手动执行提数
function execute(){

	if(!$("#submitForm").form("validate")){
		return ;
	}
	var comId =  $("#platComId").combobox("getValue");
	var bussType =  $("#bussTypeId").combobox("getValue");
	
	var startDate = $("#startDate").datebox("getValue");
	var endDate = $("#endDate").datebox("getValue");
	//平台非空校验
	if(!comId){
		$.messager.alert("提示","报送平台不能为空","info");
		return false;
	}
	//业务类型非空校验
	if(!bussType){
		$.messager.alert("提示","业务类型不能为空","info");
		return false;
	}
	//汇总对账和汇总查询时其实终止日期不能为空
	if(bussType == "SummaryCheck" || bussType == "SummaryCheckResultQuery" ){
		if(startDate == null || ""==startDate){
			$.messager.alert("提示","起始日期不能为空","info");
			return false;
		}
		if(startDate == null || ""==startDate){
			$.messager.alert("提示","终止日期不能为空","info");
			return false;
		}
	}
	//结束日期大于起始日期校验
	if(startDate!="" && endDate!=""){
		if(startDate>endDate){
			$.messager.alert("提示","起始日期不能大于终止日期","error");
			return false;
		}
	}
	
	$.messager.progress({
		title:'温馨提示',
		msg:'正在处理,请稍等...'
	});
	$.post("handExecuteSubmit?comId="+comId,$("#submitForm").serializeArray(),function(data){
		$.messager.alert("提示信息",data.msg,"info");
		$.messager.progress('close');
		 queryResult(data.actionNos);
	});
	
}

function queryResult(actionNos){
	if(!actionNos){
		return;
	}
	var url= "";
	$('#listTableHand').datagrid(
			{
				title : '报送列表', // 标题
				method : 'post',
				iconCls : 'icon-edit', // 图标
				singleSelect : true, // 多选
				height : 200, // 高度
				fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
				striped : true, // 奇偶行颜色不同
				collapsible : true,// 可折叠
				url : "listHandSubmit?actionNos="+actionNos, // 数据来源
				sortOrder : 'asc', // 正序
				remoteSort : true, // 服务器端排序
				idField : 'id', // 主键字段
				pagination : true, // 显示分页
				rownumbers : true, // 显示行号
				columns : [ [ {
					field : 'ck',
					checkbox : true,
					width : 2
				}, // 显示复选框
				{
					field : 'BATCHNO',
					title : '批次号',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						return row.BATCH_NO;
					}
				}, {
					field : 'ACTIONNO',
					title : '流水号',
					width : 120,
					sortable : true,
					formatter : function(value, row, index) {
						return row.ACTION_NO;
					}
				}, {
					field : 'DATAMSG',
					title : '报送结果',
					width : 140,
					sortable : true,
					formatter : function(value, row, index) {
						return row.DATA_MSG;
					}
				}, {
					field : 'STATEFLAG',
					title : '状态',
					width : 120,
					sortable : true,
					formatter : function(value, row, index) {
						return row.STATE_FLAG;
					}
				} ,{
					field : 'ACTIONMSG',
					title : '业务提示',
					width : 160,
					sortable : true,
					formatter : function(value, row, index) {
						return row.ACTION_MSG;
					}
				},{
					field : 'ACTIONTYPE',
					title : '类型业务',
					width : 120,
					sortable : true,
					formatter : function(value, row, index) {
						return row.ACTION_TYPE;
					}
				}] ],
				
				onLoadSuccess : function() {
					// 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
					$('#listTableHand').datagrid('clearSelections'); 
				}
			});
}
