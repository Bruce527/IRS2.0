jQuery(function($) {
	$('#platComId').combobox({
		editable : false,
		url:'../query/listPlatUrl',
		valueField:'comId',
		textField:'comName',
		onLoadSuccess : function(data) {
			if (data && data.length > 0) {
				$('#platComId').combobox('setValue',data[0].comId);
			}
		},
		onSelect : function(record){
		  initBussType();
		  msgQuery();
	    }
	 });
	msgQuery();
	initBussType();//注掉以防止平台与业务错乱
	$('#formatTypeId').combobox({
		  editable : false,
		  url:'../query/codeQuery?codetype=FORMAT_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#formatTypeId').combobox('getData');
			if(data.length > 0){
				//$('#formatTypeId').combobox('setValue',data[0].code);
			}
		  }
	  });
	$('#sendTypeId').combobox({
		  editable : false,
		  url:'../query/codeQuery?codetype=SEND_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#sendTypeId').combobox('getData');
			if(data.length > 0){
				//$('#sendTypeId').combobox('setValue',data[0].code);
			}
		  }
	  });
	 $('#statusId').combobox({
		  editable : false,
		  url:'../query/codeQueryUrl?codetype=STATUS',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#statusId').combobox('getData');
			if(data.length > 0){
				//$('#statusId').combobox('setValue',data[0].code);
			}
		  }
	  });
	 $('#implType').combobox({
		  editable : false,
		  url:'../query/codeQueryUrl?codetype=IMPL_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#implType').combobox('getData');
			if(data.length > 0){
				//$('#implType').combobox('setValue',data[0].code);
			}
		  }
	  });
});
function initBussType(){
	var comId = $('#platComId').combobox('getValue');
	$('#bussTypeId').combobox({
		  url:'../query/codeQueryByCom?codetype=BUSS_TYPE&comid='+comId,
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(data){
			if(data != null && data.length > 0){
				$('#bussTypeId').combobox('setValue',data[0].code);
			}
		  }
	  });
}
/**
 * 查询报文
 */
function msgQuery(){
	var comId = $("#platComId").combobox('getValue');
	var bussType = $("#bussTypeId").combobox('getValue');
	var formatType = $("#formatTypeId").combobox('getValue');
	var sendType = $("#sendTypeId").combobox('getValue');
	var status = $("#statusId").combobox('getValue');
	var implType =  $("#implType").combobox('getValue');
	var ps = "&comId="+comId+"&bussType="+bussType
		+"&formatType="+formatType+"&sendType="+sendType
		+"&status="+status+"&implType="+implType;
	initMsgDataGrid(ps);
}
/**
 * 表单重置
 */
function resetForm(){
	$('#msgQueryForm').form('reset');
}
function initMsgDataGrid(ps){
	 $('#msgQueryGrid').datagrid({
			url:'msgBaseInfoQuery?type=0'+ps,
			title : '报文引擎', // 标题
			iconCls : 'icon-ok', // 图标
			singleSelect : false, // true-单选  false-多选
			height : 400, // 高度
			fitColumns : false, // 自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped : true, // 奇偶行颜色不同
			collapsible : true,// 可折叠
			/*
			sortName : 'BUSSID', // 排序的列
			sortOrder : 'DESC', // 倒序
			*/			
			remoteSort : true, // 服务器端排序
			idField : 'BUSSID', // 主键字段
			queryParams : {}, // 查询条件
			pagination : true, // 显示分页
			rownumbers : true, // 显示行号
			pageSize:10,
			pageList:[5,10,15],
			columns:[[ 
			{field : 'ck',checkbox : true,width:2},
			{field:'BUSSID',title:'业务ID',/*hidden:true,*/width:60}, 
			{field:'COMID',title:'机构ID',hidden:true,width:100}, 
			{field:'COMNAME',title:'报送平台',width:150,align:'center'}, 
			{field:'BUSSTYPE',title:'BUSSTYPE',hidden:true,width:100,align:'center'},
			{field:'BUSSTYPENAME',title:'业务类型',width:150,align:'center'},
			{field:'BUSSNAME',title:'业务描述',width:200,align:'center'},
			{field:'BUSSCODE',title:'报文编码',hidden:true,width:150,align:'center'},
			{field:'FORMATTYPE',title:'报文格式',width:80,align:'center'},
			{field:'SENDTYPE',title:'SEND_TYPE',hidden:true,width:150,align:'center'},
			{field:'SENDTYPENAME',title:'报送方式',width:150,align:'center'},
			{field:'IMPLTYPENAME',title:'报文类型',width:150,align:'center'},
			{field:'STATUSNAME',title:'是否有效',editor:'checkbox',width:50,align:'center'}
			]],
			toolbar:[
				       {
				    	   text:'新增',
				    	   iconCls:'icon-add',
				    	   handler:function(){
				    		   parent.addtab('报文配置', 'mconfig/msgConfigUrl');
				    	   }
				       },'-',
				       {
				    	   text:'修改',
				    	   iconCls:'icon-edit',
				    	   handler:function(){
				    		   updateMsgEngin();
				    	   }
				       },'-',
				       {
				    	   text:'复效',
				    	   iconCls:'icon-edit',
				    	   handler:function(){
				    		   reEffect();
				    	   }
				       },'-',
				       {
				    	   text:'失效',
				    	   iconCls:'icon-edit',
				    	   handler:function(){
				    		   loseEffect();
				    	   }
				       },'-',
				       {
				    	   text:'批量删除',
				    	   iconCls:'icon-delete',
				    	   handler:function(){
				    		   deleteRows();
				    	   }
				       }
				 ]
		});
}

/**
 * 失效
 * @returns {Boolean}
 */
function loseEffect(){
	var row = $('#msgQueryGrid').datagrid('getChecked');
	if(!row || "" == row){
		$.messager.alert("提示","请选择待失效记录!","info");
		return false;
	}if(row.length > 1){
		$.messager.alert("提示","只能选择待失效记录，请重新选择!","info");
		return false;
	}
	$.messager.confirm('提示','失效会使规则无效，若该规则正在使用则有影响报送数据的风险！确定要继续吗？',function(r){
		if(r){
			//TODO 复效操作
			$.messager.progress({text:"正在失效中，请稍等..."});
			$.post('loseEffect',{bussId:row[0].BUSSID},function(data){
				$.messager.progress('close');
				if(data.msg == 'success'){
					$.messager.alert("提示",row[0].BUSSNAME+" 已经失效。","info");
					$('#msgQueryGrid').datagrid('reload');
				}else{
					$.messager.alert("提示",data.msg,"info");
				}
				$('#msgQueryGrid').datagrid('clearChecked');
			});
		}
	});
}
/**
 * 复效
 * @returns {Boolean}
 */
function reEffect(){
	var row = $('#msgQueryGrid').datagrid('getChecked');
	if(!row || "" == row){
		$.messager.alert("提示","请选择一条记录进行复效!","info");
		return false;
	}if(row.length > 1){
		$.messager.alert("提示","只能选择一条规则进行复效，请重新选择!","info");
		return false;
	}
	$.messager.confirm('提示','复效将会覆盖目前正在使用的该业务的报文规则，且后期将会一直使用！确定要复效吗？',function(r){
		if(r){
			//TODO 复效操作
			$.messager.progress({text:"正在复效中，请稍等..."});
			$.post('reEffect',{bussId:row[0].BUSSID},function(data){
				$.messager.progress('close');
				if(data.msg == 'success'){
					$.messager.alert("提示",row[0].BUSSNAME+" 复效成功。","info");
					$('#msgQueryGrid').datagrid('reload');
				}else{
					$.messager.alert("提示",data.msg,"info");
				}
				$('#msgQueryGrid').datagrid('clearChecked');
			});
		}
	});
}
/**
 * 修改报文引擎
 * @returns {Boolean}
 */
function updateMsgEngin(){
	var row = $('#msgQueryGrid').datagrid('getChecked');
	if(!row || "" == row){
		$.messager.alert("提示","请选择一条记录进行修改!","info");
		return false;
	}if(row.length > 1){
		$.messager.alert("提示","只能选择一条规则进行修改，请重新选择!","info");
		return false;
	}
	else{
		$.messager.confirm("提示","修改报文规则可能影响到目前正在报送的数据，请确认目前没有程序在使用该报文规则！",function(r){
			if(r){
				var bussId = row[0].BUSSID;
				var bussCode = row[0].BUSSCODE;
				var url = "updateMsgEngin?bussId="+bussId+"&bussCode="+bussCode;
				$.messager.progress({text:"正在为您修改数据，请稍等..."});
				$.post(url,function(data){
					$.messager.progress('close');
					if(data.msg="success"){
						parent.addtab('报文修改', 'mconfig/msgConfigUrl');
						$('#msgQueryGrid').datagrid('reload');
					}else{
						$.messager.alert("提示",data.msg,"info");
					}
					$('#msgQueryGrid').datagrid('clearChecked');
				});
			}
		});
	}
}
function deleteRows(){
	var row = $('#msgQueryGrid').datagrid('getChecked');
	if(row == null || row.length <= 0){
		$.messager.alert("提示","请至少选择一条记录进行删除","info");
		return ;
	}
	$.messager.confirm('提示','是否确定删除所选记录？',function(r){
		if(r){
			var ps = "?type=1";
			for(var i = 0; i < row.length; i++){
				ps += "&bussId="+row[i].BUSSID;
			}
			$.messager.progress({text:"正在为您删除数据，请稍等..."});
			$.post('deleteMsgEngin' + ps, function(data) {
				$.messager.progress('close');
				if(data.msg == "success"){
					$.messager.alert('提示', "报文规则删除成功", 'info');
					$('#msgQueryGrid').datagrid('reload');
				}else{
					$.messager.alert('提示',data.msg,"info");
				}
				$('#msgQueryGrid').datagrid('clearChecked');
			});
		}
	});
}
function deleteRow(rowIndex){
	$.messager.confirm('提示','是否确定删除该记录？',function(r){
		if(r){
			//置空所选
			$('#msgQueryGrid').datagrid('clearChecked');
			//选中选择列
			$('#msgQueryGrid').datagrid('selectRow',rowIndex-1);
			var row = $('#msgQueryGrid').datagrid('getSelected');
			var ps = "?bussId=" + row.BUSSID;
			$.messager.progress({text:"正在为您删除数据，请稍等..."});
			$.post('deleteMsgEngin' + ps, function(data) {
				$.messager.progress('close');
				if(data.msg == "success"){
					$.messager.alert('提示', "报文规则"+row.BUSSTYPENAME+" 删除成功", 'info');	
					$('#msgQueryGrid').datagrid('reload');
				}else{
					$.messager.alert('提示',data.msg,"info");
				}
				$('#msgQueryGrid').datagrid('clearChecked');
			});
		}
	});
}
