jQuery(function($) {
	initLogPath();
});
/**
 * 初始化
 */
function initLogPath(){
	$.post('../log/initLogPath',function(data){
		$('#logPathId').val(data.logPath);
		reFreash();
	});
}
/**
 * 搜索
 */
function reSearch(){
	var research = $('#researchId').val();
	freash('../log/listSearch',research);
}
/**
 * 刷新
 */
function reFreash(){
	freash('../log/listFiles',"*");
}

/**
 * 指定URL刷新
 * @param url
 * @param search 有则是条件刷新，无则直接刷新
 */
function freash(url,search){
	var path = $('#logPathId').val();
	if(path == null || path == ""){
		$.messager.alert("提示","无访问路径");
		return ;
	}
	if(path.lastIndexOf("/")==(path.length-1) || path.lastIndexOf("/")==(path.length-2)){
		
	}else{
		path = path+"/";
	}
	//alert(url+" path:"+path+" research:"+search);
	$('#logTableGridId').datagrid({
		title : '日志信息', //标题
		method : 'post',
		iconCls : 'icon-edit', //图标
		url : url, //数据来源
		queryParams : {logPath : path,research:search}, //查询条件
		height : 380, //高度
		pagination : true, //显示分页
		nowrap : true,//true把数据显示在一行上。设置为true能提高加载性能。
		rownumbers : true, //显示行号
		showFooter : true,//定义是否显示行页脚
		striped : true, //奇偶行颜色不同
		collapsible : true,//可折叠
		singleSelect : false, //多选
		fitColumns : false, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		sortName : 'modifyTime', //排序的列
		sortOrder : 'desc', //倒序
		idField : 'fileName', //主键字段
		columns : [ [ {
			field : 'ck',
			checkbox : true,
			width : 2
		}, //显示复选框
		{
			field : 'fileName',
			title : '文件名称',
			width : 400,
			sortable : true,
			formatter : function(value, row, index) {
				//需要formatter一下才能显示正确的数据
				return row.fileName;
			} 
		}, /*{
			field : 'makeTime',
			title : '创建日期',
			width : 150,
			sortable : true,
			formatter : function(value, row, index) {
				return row.makeTime;
			}
		},*/
		 {
			field : 'modifyTime',
			title : '修改日期',
			width : 150,
			sortable : true,
			formatter : function(value, row, index) {
				return row.modifyTime;
			}
		},
		{
			field : 'size',
			title : '大小/个数',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				return row.size;
			}
		},
		{
			field : 'maker',
			title : '创建者',
			width : 100,
			sortable : true,
			hidden : true,
			formatter : function(value, row, index) {
				return row.maker;
			}
		},
		{
			field : 'filePath',
			title : '文件路径',
			width : 200,
			hidden : true,
			formatter : function(value, row, index) {
				return row.filePath;
			}
		},
		{
			field : 'isDect',
			title : '操作',
			width : 100,
			formatter : function(value, row, index) {
				var html = "<div align = 'center'>";
				if(row.isDect == 1){
					html += "<a href='#' onclick = \"_OpenFile('"+row.fileName+"')\">打开</a>";
				}
				else if(row.isDect == 0){
					html += "<a href='#' onclick = \"_DownFile('"+row.fileName+"')\">下载</a>";
				}
				else{
					html += "未知";
				}
				html += "</div>";
				return html;
			}
		}
		]],
		toolbar : [{
			text : '新增文件',
			iconCls : 'icon-add',
			handler : function() {
				addFiles();
			}
		}, '-', {
			text : '新增文件夹',
			iconCls : 'icon-add',
			handler : function() {
				newFileDir();
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-delete',
			handler : function() {
				deleteFiles();
			}
		},
		/*'-', {
			text : '批量下载',
			iconCls : 'icon-save',
			handler : function() {
				_DownFiles();
			}
		}*/
		],
		onLoadSuccess : function() {
			//一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			$('#logTableGridId').datagrid('clearSelections'); 
		},
		onDblClickRow : function(rowIndex, rowData){
			if(rowData && rowData.isDect == 1){
				var path = $('#logPathId').val();
				$('#logPathId').val(path + rowData.fileName + "/");
				reFreash();
			}
		}
	});
}
/**
 * 跳转至增加文件页面
 */
function addFiles(){
	var path = $('#logPathId').val();
	var url = 'log/addFileUrl?type=1&logPath='+path;
	parent.addtab('新增文件',url);
	
}
/**
 * 测试方法
 */
function test(){
	 $.messager.alert("测试","logInput——Test===>");
}
/**
 * 新增文件夹
 */
function newFileDir(){
	
	$('#newDirWin').dialog({ 
		width:500, 
		height:230,
		title:'新增文件夹',
		href: 'addFileUrl?type=0',
		modal:true});
}
/**
 * 返回
 */
function goBack(){
	
	var path_o = $('#logPathId').val();
	if(path_o == null || path_o == ""){
		$.messager.alert("提示","无访问路径");
		return;
	}
	var lastIndex = path_o.lastIndexOf("/");
	var path_n = path_o.substr(0,lastIndex+1);
	if(path_n == path_o){
		path_o = path_o.substr(0,lastIndex+1);
	}
	lastIndex = path_o.lastIndexOf("/");
	path_o =  path_o.substr(0,lastIndex);
	path_n = path_o.substr(0,path_o.lastIndexOf("/")+1);
	$('#logPathId').val(path_n);
	
	reFreash();
}
/**
 * 打开一个文件夹
 * @param fileName
 */
function _OpenFile(fileName){
	var path = $('#logPathId').val();
	$('#logPathId').val(path + fileName + "/");
	reFreash();
}
/**
 * 批量下载文件
 * @param fileName
 */
function _DownFile(fileName){
	var path = $('#logPathId').val();
	var url = "downLoadFile?"+encodeURI(encodeURI("filePath="+(path+fileName)+"&fileName="+fileName+"&logPath="+path));
	window.location.href=url;
}
function _DownFiles(){
	//downLoadFiles
	var path = $('#logPathId').val();
	var rows = $('#logTableGridId').datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert("提示","请选择要下载的文件");
		return;
	}else{
		$.messager.confirm('提示', '确定要批量下载吗?', function(result) {
			if (result) {
				var ps = "?logPath="+path;
				$.each(rows, function(i, n) {
						ps += "&fileList=" + n.fileName;
				});
				url = "downLoadFiles"+ps;
				window.location.href=url;
			}
		});
	}
}
/**
 * 删除文件
 */
function deleteFiles(){
	var path = $('#logPathId').val();
	var rows = $('#logTableGridId').datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert("提示","请选择要删除的文件");
		return;
	}else{
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			if (result) {
				var ps = "?logPath="+path;
				$.each(rows, function(i, n) {
						ps += "&files=" + n.fileName;
				});
				ps = encodeURI(encodeURI(ps));
				$.post('deleteFiles' + ps, function(data) {
					$('#logTableGridId').datagrid('cisreload');
				});
			}
		});
	}
}
/**
 * 该方法涉及到删除列则必须重写实现
 */
function deleteRow(rowIndex){
	/*
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
	if(result){
		var path = $('#logPathId').val();
		// 置空所选
		$('#logTableGridId').datagrid('clearSelections');
		// 选中选择列
		$('#logTableGridId').datagrid('selectRow',rowIndex-1);
		var row = $('#logTableGridId').datagrid('getSelected');
		var ps = "?logPath="+path+"&files=" + row.fileName;
		$.post('deleteFiles' + ps, function(data) {
			// $.messager.alert('提示', data.mes, 'info');
			$('#logPathId').val(path);
			reFreash();
		});
	}
  });
	*/
}
/**
 * 确定创建文件夹
 */
function doDirOk(){
	var path = $('#logPathId').val();
	var dirName = $('#dirNameId').val();
	var ps = "?logPath="+path+"&dirName="+dirName;
	$.post('addFileDir' + ps, function(data) {
		$('#logTableGridId').datagrid('cisreload');
		$('#newDirWin').window('close',true);
		//$.messager.alert('提示', data.mes, 'info');
	});
}
/**
 * 取消创建文件夹
 */
function doDirCancel(){
	$('#newDirWin').window('close',true);
}