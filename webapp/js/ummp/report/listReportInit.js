jQuery(function($) {
	$('#userTable').datagrid({
		title : '业务报送明细', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : true, // 多选
		height : 250, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryList", // 数据来源
		pageList:[5,10,20,30,50],//分页
		sortName : 'USERCODE', // 排序的列
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'ID', // 主键字段
		queryParams : {}, // 查询条件
		pagination : true, // 显示分页
		rownumbers : true, // 显示行号
		columns : [[/*{
					field : 'ck',
					checkbox : true,
					width : 2
				}, // 显示复选框
*/				{
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
					field : 'row.batchNo',
					title : '批次号',
					width : 140,
					sortable : true,
					formatter : function(value, row, index) {
						return row.BATCH_NO;
					} // 需要formatter一下才能显示正确的数据
				},
				{
					field : 'row.bussType',
					title : '业务类型',
					width : 240,
					sortable : true,
					formatter : function(value, row, index) {
						return row.BUSS_TYPE;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.actionData',
					title : '报送时间',
					width : 140,
					sortable : true,
					formatter : function(value, row, index) {
						return row.INSERT_TIME;
					}
				},{
					field : 'row.actionSucCount',
					title : '报送结果',
					width : 350,
					sortable : true,
					formatter : function(value, row, index) {
						return row.RETURN_MSG;
					}
				}]],
		onLoadSuccess : function() {
			$('#userTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	$('#userTable2').datagrid({
		title : '业务提数明细', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : true, // 多选
		height : 250, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryTsList", // 数据来源
		sortName : 'USERCODE', // 排序的列
		pageList:[5,10,20,30,50],//分页
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'ID', // 主键字段
		queryParams : {}, // 查询条件
		pagination : true, // 显示分页
		rownumbers : true, // 显示行号
		columns : [[/*{
					field : 'ck',
					checkbox : true,
					width : 2
				}, // 显示复选框
*/				{
					field : 'row.ID',
					title : 'ID',
					width : 80,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.ID;
					}
				},
				{
					field : 'row.BATCH_NO',
					title : '批次号',
					width : 140,
					sortable : true,
					formatter : function(value, row, index) {
						return row.BATCH_NO;
					} // 需要formatter一下才能显示正确的数据
				},{
					field : 'row.bussType',
					title : '传输类型',
					width : 240,
					sortable : true,
					formatter : function(value, row, index) {
						return row.BUSS_TYPE;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.ACTION_DATE',
					title : '提数时间',
					width : 140,
					sortable : true,
					formatter : function(value, row, index) {
						return row.ACTION_DATE;
					}
				},{
					field : 'row.SUCCESS',
					title : '提数结果',
					width : 350,
					sortable : true,
					formatter : function(value, row, index) {
						return row.SUCCESS;
					}
				}]],
		onLoadSuccess : function() {
			$('#userTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});

});




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
//		  onLoadSuccess:function(r){
//			var data = $('#platComId').combobox('getData');
//			if(data.length > 0){
//				$('#platComId').combobox('setValue',data[0].comId);
//				$('#platComId').combobox('setText',data[0].comName);
//			}
//		  },
		  onSelect : function(record){
			  initBussType();
		  }
	 });
	
	$('#platComIdd').combobox({
		  required:true,	
		  url:'../query/listPlatUrl',
		  valueField:'comId',
		  textField:'comName',
//		  onLoadSuccess:function(r){
//			var data = $('#platComId').combobox('getData');
//			if(data.length > 0){
//				$('#platComIdd').combobox('setValue',data[0].comId);
//				$('#platComIdd').combobox('setText',data[0].comName);
//			}
//		  },
		  onSelect : function(record){
			  initTransType();
		  }
	 });
	initTransType();
	initBussType();
	// 起始日期选择框
	$('#startDate').datebox({ 
		editable:false
	});
	// 终止日期选择框
	$('#endDate').datebox({ 
		editable:false
	});
}
//二级联动传输类型
function initTransType(){
	var comIdd = $('#platComIdd').combobox('getValue');
	$('#bussTypeIdd').combobox({
		  url:'../report/getTransType?comId='+comIdd,
		  valueField:'EXC_CODE',
		  textField:'EXC_DESC'
	  });
}
//二级联动业务类型
function initBussType(){
	var comId = $('#platComId').combobox('getValue');
	$('#bussTypeId').combobox({
		  url:'../query/codeQueryByCom?codetype=BUSS_TYPE&comid='+comId,
		  valueField:'code',
		  textField:'codeName'
	  });
}
	// 表格查询1
	function searchUser1() {
		var params = $('#userTable').datagrid('options').queryParams; // 先取得
		var fields = $('#userForm').serializeArray(); // 自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
					params[field.name] = field.value; // 设置查询参数
		});
		$('#userTable').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
	}
	// 表格查询2
	function searchUser2() {
		var params = $('#userTable2').datagrid('options').queryParams; // 先取得
		var fields = $('#userForm2').serializeArray(); // 自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
					params[field.name] = field.value; // 设置查询参数
		});
		$('#userTable2').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
	}
	// 清空查询条件
	function clearForm1() {
		$('#userForm').form('clear');
		searchUser1();
	}
	// 清空查询条件
	function clearForm2() {
		$('#userForm2').form('clear');
		searchUser2();
	}
	//报表导出:报送结果
	function derive1(){
		//获取页面参数
		var startDate=$("#startDate").datebox('getValue');
		var endDate=$("#endDate").datebox('getValue');
		var bussTypeId=$("#bussTypeId").combobox('getValue');
		var platComId=$("#platComId").combobox('getValue');
		var comName=$("#platComId").combobox('getText');
		if($.trim(platComId)==""){
			$.messager.alert('提示',"请先选择报送平台！",'info')
			return;
		}
		var param={"startDate":startDate,
		   		   "endDate":endDate,
		   		   "bussType":bussTypeId,
		   		   "platCom":platComId,
		   		   "comName":comName,
		   		   "flag":"BussReportResult"};
		 //打开窗口发送请求
	    window.open('../report/ReportDeserveToExcel?param='+encodeURI($.toJSON(param)));
	}
	//报表导出:报送明细
	function derive2(){
		//获取页面参数
		var startDate=$("#startDatee").datebox('getValue');
		var endDate=$("#endDatee").datebox('getValue');
		var bussTypeId=$("#bussTypeIdd").combobox('getValue');
		var platComId=$("#platComIdd").combobox('getValue');
		var comName=$("#platComIdd").combobox('getText');
		if($.trim(platComId)==""){
			$.messager.alert('提示',"请先选择报送平台！",'info')
			return;
		}
		var param={"startDate":startDate,
		   		   "endDate":endDate,
		   		   "bussType":bussTypeId,
		   		   "platCom":platComId,
		   		   "comName":comName,
		   		   "flag":"BussExtractResult"};
		 //打开窗口发送请求
	    window.open('../report/ReportDeserveToExcel?param='+encodeURI($.toJSON(param)));
	}
