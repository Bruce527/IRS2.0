jQuery(function($) {
	$('#userTable').datagrid({
		title : '用户访问记录', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : true, // 多选
		height : 380, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryListLog", // 数据来源
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
					field : 'row.USERCODE',
					title : '用户编码',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.USERCODE;
					} // 需要formatter一下才能显示正确的数据
				}, {
					field : 'row.USERNAME',
					title : '用户名',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.USERNAME;
					}
				},{
					field : 'row.USERIP',
					title : '登录IP',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.USERIP;
					}
				},{
					field : 'row.TRACEMSG',
					title : '访问页面',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						return row.TRACEMSG;
					}
				},{
					field : 'row.INSERTTIME',
					title : '访问时间',
					width : 160,
					sortable : true,
					formatter : function(value, row, index) {
						return row.INSERTTIME;
					}
				}]],
		onLoadSuccess : function() {
			$('#userTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
});
	// 表格查询1
	function searchUser1() {
		var params = $('#userTable').datagrid('options').queryParams; // 先取得
		var fields = $('#userForm').serializeArray(); // 自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
					params[field.name] = field.value; // 设置查询参数
		});
		$('#userTable').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
	}
	// 清空查询条件
	function clearForm1() {
		$('#userForm').form('clear');
		searchUser1();
	}

	//报表导出:报送结果
	function deriveLog(){
		//获取页面参数
		var startDate=$("#startDate").datebox('getValue');
		var endDate=$("#endDate").datebox('getValue');
		var userCode=$("#usercode").val();
		var userName=$("#username").val();
		var empowerCode=$("#empowerCode").val();
		var param={"startDate":startDate,
		   	  	   "endDate":endDate,
		   		   "userCode":userCode,
		   		   "userName":userName,
		   		   "empowerCode":empowerCode,
		   		   "flag":"UserOperateLog"};
		 //打开窗口发送请求
	    window.open('../report/ReportDeriveToExcel.xls?param='+encodeURI($.toJSON(param)));
	}
