jQuery(function($) {
	
	$('#batchType').combobox({
		  url:'../query/codeQueryUrl?codetype=BATCHTYPE',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true
	 	});
	$('#dataType').combobox({
		  url:'../query/codeQueryUrl?codetype=DATATYPE',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true
	 	});
	$('#bussFlag').combobox({
		  url:'../query/codeQueryUrl?codetype=BUSSFLAG',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true
	 	});
	$('#insureType').combobox({
		  url:'../query/codeQueryUrl?codetype=INSURETYPE',
		  valueField:'code',
		  textField:'codeName',
		  editable:false,
		  required:true,
		  value:'L'
	 	});
	userTableInit();
});

function userTableInit(){
	var batchNo = $('#batchNo').val();
	var transType = $('#batchType').combobox('getValue');
	var stateFlag = $('#bussFlag').combobox('getValue');
	$('#userTable').datagrid({
		title : '批次详情', // 标题
		method : 'post',
		iconCls : 'icon-edit', // 图标
		singleSelect : true, // 多选
		height : 300, // 高度
		fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped : true, // 奇偶行颜色不同
		collapsible : true,// 可折叠
		url : "queryCreateFile", // 数据来源
		sortName : 'DOCID', // 排序的列
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'DOCID', // 主键字段
		queryParams : {batchNo:batchNo,transType:transType,stateFlag:stateFlag}, // 查询条件
		pagination : true, // 显示分页
		rownumbers : true, // 显示行号
		columns : [[{
					field : 'ck',
					checkbox : true,
					width : 2
				}, // 显示复选框
				{
					field : 'DOCID',
					title : 'ID',
					width : 100,
					hidden :true
				},{
					field : 'SUBBUSSTYPE',
					title : '批次类型',
					width : 100
				},{
					field : 'BATCHNO',
					title : '批次号',
					width : 180
				},{
					field : 'TRANSDATE',
					title : '交易日期',
					width : 120,
					formatter : function(value, row, index) {
						return row.TRANSDATE;
					}
				},{
					field : 'STATEFLAG',
					title : '状态',
					width : 160,
					hidden : true
				},{
					field : 'STATEFLAGNAME',
					title : '业务状态',
					width : 160
				},{
					field : 'PAGENAME',
					title : '文件名',
					width : 200
				},{
					field : 'INSERTTIME',
					title : '创建日期',
					width : 100
				}]],
		onLoadSuccess : function() {
			$('#userTable').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		},
		onSelect : function(index,row){
			$('#startDate').datebox('setValue',row.TRANSDATE);
			$('#endDate').datebox('setValue',row.TRANSDATE);
			$('#bussFlag').combobox('setValue',row.STATEFLAG);
			if(row.BATCHNO){
				$('#batchNo').val(row.BATCHNO);
			}
			if(row.SUBBUSSTYPE){
				$('#batchType').val(row.SUBBUSSTYPE);
			}
		}
	});
}
// 表格查询
function searchUser1() {
	userTableInit();
}
// 清空查询条件
function clearForm1() {
	$('#userForm').form('clear');
	searchUser1();
}
//创建文件
function createFile(){
	if($("#userForm").form('validate')){
		var startDate=$("#startDate").datebox('getValue');
		var endDate=$("#endDate").datebox('getValue');
		if($.trim(startDate)=='' || $.trim(startDate)==''){
			$.messager.alert('提示',"请输入业务起始日期！",'info');
			return;
		}
		if($.trim(endDate)=='' || $.trim(endDate)==''){
			$.messager.alert('提示',"请输入业务结束日期！",'info');
			return;
		}
		$.messager.progress({
			title:'温馨提示',
			msg:'正在创建文件...'
		});
		$.post('../updownfile/createFileUrl',$("#userForm").serialize(),function(data){
			$.messager.alert('提示',data.msg,'info');
			$.messager.progress('close');
			searchUser1();
		});
	}
}
//上载文件
function uploadFile(){
	var rows = $("#userTable").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请选择一个文件进行上载！",'info');
		return;
	}
	if(rows.length > 1){
		$.messager.alert('提示',"只能选择一个文件进行上载！",'info')
		return;
	}
	$.messager.progress({
		title:'温馨提示',
		msg:'正在上传文件...'
	});
	var id = rows[0].DOCID;
	$.post('../sestj/upload?id='+id,function(data){
		if(data.msg=='undefined'){
			$.messager.alert('提示',"上传失败！",'info');
			return;
		}else{
			$.messager.alert('提示',data.msg,'info');
			$.messager.progress('close');
			searchUser1();
		}
	});
}
