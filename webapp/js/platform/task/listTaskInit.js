jQuery(function($) {
	/*  
	$('#taskTable').datagrid({
		title : '查询结果', // 标题
		method : 'post',
		iconCls : 'icon-search', // 图标
		singleSelect : true, // 多选
		height : 400, // 高度
		width  : '100%',
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : 'queryTaskList?queryFrom=me&queryFlag=0', // 数据来源
		sortName : 'id', // 排序的列
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
			},  {
				field : 'row.dbid',
				title : 'id',
				width : 0,
				hidden: true,
				sortable : false,
				formatter : function(value, row, index) {
					return row.dbid;
				} // 需要formatter一下才能显示正确的数据
			  },
		            
		             {
					field : 'row.policyNo',
					title : '保单号',
					width : 80,
					sortable : false,
					formatter : function(value, row, index) {
						return row.policyNo;
					} // 需要formatter一下才能显示正确的数据
				  },
				  {
						field : 'row.BussNo',
						title : '任务号',
						width : 100,
						sortable : false,
						formatter : function(value, row, index) {
							return row.BussNo;
						} // 需要formatter一下才能显示正确的数据
				  },
				  {
							field : 'row.saleChannel',
							title : '渠道',
							width : 40,
							sortable : false,
							formatter : function(value, row, index) {
								return row.saleChannel;
								
							} // 需要formatter一下才能显示正确的数据
				  },
				  {
						field : 'row.agentCom',
						title : '机构',
						width : 75,
						sortable : false,
						formatter : function(value, row, index) {
							return row.agentCom;
						} // 需要formatter一下才能显示正确的数据
			      },
			      {
						field : 'row.agentComName',
						title : '机构名称',
						width : 105,
						sortable : false,
						formatter : function(value, row, index) {
							return row.agentComName;
						} // 需要formatter一下才能显示正确的数据
			      },
			      {
						field : 'row.createTime',
						title : '提交日期',
						width : 110,
						sortable : false,
						formatter : function(value, row, index) {
							return row.createTime;
						} // 需要formatter一下才能显示正确的数据
			      },
			      {
						field : 'row.activityName',
						title : '任务状态',
						width : 60,
						sortable : false,
						formatter : function(value, row, index) {
							return row.activityName;
						} // 需要formatter一下才能显示正确的数据
			      },
			      {
						field : 'row.agentCode',
						title : '网点',
						width : 50,
						sortable : false,
						formatter : function(value, row, index) {
							//return row.username;
							return row.agentCode;
						} // 需要formatter一下才能显示正确的数据
			      },
			      {
						field : 'row.agentName',
						title : '网点名称',
						width : 130,
						sortable : false,
						formatter : function(value, row, index) {
							//return row.username;
							return row.agentName;
						} // 需要formatter一下才能显示正确的数据
			      },
			      {
						field : 'row.taskStatus',
						title : '业务类型',
						width : 60,
						sortable : false,
						formatter : function(value, row, index) {
							//return row.username;
							return row.taskStatus;
						} // 需要formatter一下才能显示正确的数据
			      },
			      {
						field : 'row.productCode',
						title : '主险编码',
						width : 60,
						sortable : false,
						formatter : function(value, row, index) {
							return row.productCode;
						} // 需要formatter一下才能显示正确的数据
			      },
			      {
						field : 'row.productName',
						title : '主险名称',
						width : 300,
						sortable : false,
						formatter : function(value, row, index) {
							return row.productName;
						} // 需要formatter一下才能显示正确的数据
			      }
				  ]],
		onLoadSuccess : function() {
			$('#taskTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	*/
});
