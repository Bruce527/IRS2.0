jQuery(function($) {
	$('#userTable').datagrid({
		title : '文件记录列表', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : true, // 多选
		height : 380, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryDownloadFile", // 数据来源
		sortName : 'INSERT_TIME', // 排序的列
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'DOC_ID', // 主键字段
		queryParams : {}, // 查询条件
		pagination : true, // 显示分页
		rownumbers : true, // 显示行号
		columns : [[{
					field : 'ck',
					checkbox : true,
					width : 2
				}, // 显示复选框
				{
					field : 'row.INSERT_TIME',
					title : 'ID',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.INSERT_TIME;
					}
				},{
					field : 'row.DOC_PATH',
					title : 'ID',
					width : 100,
					sortable : true,
					hidden :true,
					formatter : function(value, row, index) {
						return row.DOC_PATH;
					}
				},{
					field : 'row.DOC_NAME',
					title : '文件名称',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						return row.DOC_NAME;
					} // 需要formatter一下才能显示正确的数据
				},{
					field : 'row.DOC_MAKE_TIME',
					title : '创建时间',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.DOC_MAKE_TIME;
					}
				},{
					field : 'row.LAST_MODIFY_TIME',
					title : '修改时间',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						return row.LAST_MODIFY_TIME;
					}
				},{
					field : 'row.DOC_TYPE',
					title : '文件类型',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						if(row.DOC_TYPE == 'U'){
							return '成功';
						} else if(row.DOC_TYPE == 'D'){
							return '失败';
						}
						
					}
				},{
					field : 'row.DOWN_TIMES',
					title : '下载次数',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						return row.DOWN_TIMES;
					}
				}]],
		onLoadSuccess : function() {
			$('#userTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	$('#fileType').combobox({
		  url:'../query/codeQueryUrl?codetype=FILETYPE',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:false,
		  value:'D'
	 	});
});
	// 表格查询
	function searchUser() {
		var params = $('#userTable').datagrid('options').queryParams; // 先取得
		var fields = $('#userForm').serializeArray(); // 自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			params[field.name] = field.value; // 设置查询参数
		});
		$('#userTable').datagrid('cisreload'); // 设置好查询参数 reload 一下就可以了
	}
	// 清空查询条件
	function clearForm() {
		$('#userForm').form('clear');
		searchUser();
	}
	//是否将文件同步到本地@author SendyLou
	function synchronize(){
			$.messager.confirm('提示',"确认:文件同步到本地;取消:取回本地文件",function(result){
				if(result){
					var startDate = $("#startDate").datebox('getValue');
					var endDate = $("#endDate").datebox('getValue');
					var fileType = $("#fileType").combobox('getValue');
					if($.trim(startDate)=='' || $.trim(endDate)=='' || $.trim(fileType)==''){
						$.messager.alert('提示',"请选择日期和文件类型!",'info');
						return;
					}
					//调用QueryFileService
					$.messager.progress({
						title:'温馨提示',
						msg:'正在同步文件...'
					});
					$.post('../updownfile/queryFileUrl',$("#userForm").serialize(),function(data){
						$.messager.alert('提示',data.msg,'info');
						$.messager.progress('close');
						searchUser();
					});
				}else{
					searchUser();
				}
			});
	}

	//文件下载@author SendyLou
	function fileDownload(){
		var rows = $("#userTable").datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择一个文件下载！",'info');
			return;
		}
		if(rows.length>1){
			$.messager.alert('提示',"只能选择一个文件下载！",'info')
			return;
		}
		var array = [];
		array.push({
			'DOC_NAME' : rows[0].DOC_NAME,
			'DOC_PATH' : rows[0].DOC_PATH
		});
		var list = $.toJSON(array);
		window.open('../updownfile/downFileUrl?list='+list);
	}
	//数据处理@author SendyLou
	function dealData(){
		var rows = $("#userTable").datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择一个文件进行处理！",'info');
			return;
		}
		if(rows.length>1){
			$.messager.alert('提示',"只能选择一个文件进行处理！",'info')
			return;
		}
		$.messager.progress({
			title:'温馨提示',
			msg:'正在处理文件...'
		});
		var array = [];
		var DOC_NAME = rows[0].DOC_NAME;
		array.push({
			'DOC_NAME' : DOC_NAME
		});
		var list = $.toJSON(array);
		$.ajax({
			url		:	"dealDataUrl",
			type	:	"POST",
			data	:	"list="+list,
			cache	:	false,
			success	:	function(data){
				$.messager.alert("提示信息",data.msg,"info");
				$.messager.progress('close');
				searchUser();
			}
		});
	}
	
	
	
	
	
	
	
	
	