jQuery(function($) {
		$('#manageComTable').datagrid({
			title : '机构列表',
			method : 'post',
			iconCls : 'icon-edit',
			singleSelect : false,
			height : 380,
			fitColumns : false,
			striped : true,
			collapsible : true,
			url : "queryList", 
			sortName : 'id', 
			sortOrder : 'asc',
			remoteSort : true,
			idField : 'id',
			queryParams : {},
			pagination : true,
			rownumbers : true,
			columns : [ [ {
				field : 'ck',
				checkbox : true,
				width : 2
			},
			{
				field : 'id',
				title : 'id',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.ID;
				}
			},
			{
				field : 'manageCode', 
				title : '核心机构编码',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.manageCode;
				}
			}
			,{
				field : 'fid', 
				title : '上级机构编码',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.fid;
				}
			}
			, {
				field : 'manageName',
				title : '机构名称',
				width : 80,
				sortable : true,
				formatter : function(value, row, index) {
					return row.manageName;
				}
			}, {
				field : 'mmonitorCode',
				title : '监管机构编码',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.mmonitorCode;
				}
			},{
				field : 'address',
				title : '地址',
				width : 300,
				sortable : true,
				formatter : function(value, row, index) {
					return row.address;
				}
			},{
				field : 'innerFid',
				title : 'innerFid',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.innerFid;
				}
			},{
				field : 'licenseType',
				title : 'licenseType',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.licenseType;
				}
			},{
				field : 'remark',
				title : 'remark',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.remark;
				}
			},{
				field : 'lastModifyTime',
				title : 'lastModifyTime',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.lastModifyTime;
				}
		}
			,{
				field : 'zipcode',
				title : 'zipcode',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.ID;
				}
			},{
				field : 'openDate',
				title : 'openDate',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.openDate;
				}
			},{
				field : 'email',
				title : 'email',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.email;
				}
			},{
				field : 'mmonitorType',
				title : 'mmonitorType',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.mmonitorType;
				}
			},{
				field : 'closeDate',
				title : '�ر�ʱ��',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.closeDate;
				}
			},{
				field : 'status',
				title : '״̬',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.status;
				}
			},{
				field : 'manageInnerCode',
				title : '���ڲ�����',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.manageInnerCode;
				}
			},{
				field : 'manageEnnameShort',
				title : 'Ӣ�ļ��',
				width : 100,
				sortable : true,
				hidden :true,
				formatter : function(value, row, index) {
					return row.manageEnnameShort;
				}
			},{
				field : 'phone',
				title : '联系电话',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					return row.phone;
				}
			} ] ],
			toolbar : [{
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					parent.addtab('新增机构', 'managecom/addManageComUrl');
				}
			}, '-', {
				text : '更新',
				iconCls : 'icon-edit',
				handler : function() {
					var rows = $('#manageComTable').datagrid('getSelections');
					if (rows.length == 0) {
						$.messager.alert('提示', "请选择一个机构进行修改", 'info');
						return;
					}
					if (rows.length > 1) {
						$.messager.alert('提示', "只能对一个机构修改", 'info');
						return;
					}
					parent.addtab('更新机构', "managecom/updateManageComUrl?id="+rows[0].id);
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					deleteManageCom();
				}
			}, '-'],
	onLoadSuccess : function() {
		$('#manageComTable').datagrid('clearSelections'); // 
	}
});
}); 

function addManageComtab(title, href) {
	if (href){  
        var content = "<iframe scrolling='auto' frameborder='0'  src='"+href+"' style='width:100%;height:100%;'></iframe>";  
	}else {  
        var content = 'δʵ��';  
    }  
	if($('#manageComtab').tabs('exists', title)) {
		$('#manageComtab').tabs('close', title);
		$('#manageComtab').tabs('add', {
			title : title,
            content:content, 
			closable : true
		});
	}
	else{
		$('#manageComtab').tabs('add', {
			title : title,
            content:content, 
			closable : true
		});
	}
} 
// ɾ��
function deleteManageCom() {
	var rows = $('#manageComTable').datagrid('getSelections');
	if (rows.length == 0) {
		$.messager.alert('提示', "请选择要删除的机构", 'info');
//		alert("请选择要删除的机构");
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
				$.post('deleteManageCom' + ps, function(data) {
					$('#manageComTable').datagrid('cisreload');
					$.messager.alert('提示', data.mes, 'info');
				});
			}
		});
	}
}
// 
function searchCom() {
	var params = $('#manageComTable').datagrid('options').queryParams; // 
	var fields = $('#manageComForm').serializeArray(); // 
	$.each(fields, function(i, field) {
				params[field.name] = field.value; // 
	});
	$('#manageComTable').datagrid('cisreload'); //
}
// 
function clearCom() {
	$('#manageComForm').form('clear');
	searchCom();
}
/**
 * 
 */
function deleteRow(rowIndex){
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			//�ÿ���ѡ
			$('#manageComTable').datagrid('clearSelections');
			//ѡ��ѡ����
			$('#manageComTable').datagrid('selectRow',rowIndex-1);
			var row = $('#manageComTable').datagrid('getSelected');
			var ps = "?id=" + row.id;
			$.post('deleteManageCom' + ps, function(data) {
				$('#manageComTable').datagrid('cisreload');
				$.messager.alert('提示', data.mes, 'info');
			});
		}
	});
}