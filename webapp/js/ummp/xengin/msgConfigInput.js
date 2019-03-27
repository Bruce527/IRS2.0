jQuery(function($) {
	$('#platComId').combobox({
		  url:'../query/listPlatUrl',
		  valueField:'comId',
		  textField:'comName',
		  onLoadSuccess:function(r){
			var data = $('#platComId').combobox('getData');
			if(data.length > 0){
				$('#platComId').combobox('setValue',data[0].comId);
				$('#platComId').combobox('setText',data[0].comName);
			}
		  },
		  onSelect : function(record){
			  initBussType();
		  }
	 });
	initBussType();
	$('#formatTypeId').combobox({
		  url:'../query/codeQuery?codetype=FORMAT_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#formatTypeId').combobox('getData');
			if(data.length > 0){
				$('#formatTypeId').combobox('setValue',data[3].code);
				$('#formatTypeId').combobox('setText',data[3].codeName);
			}
		  },
		  onSelect : function(record){
			  initTempNode();
		  }
	  });
	$('#sendTypeId').combobox({
		  url:'../query/codeQuery?codetype=SEND_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#sendTypeId').combobox('getData');
			if(data.length > 0){
				$('#sendTypeId').combobox('setValue',data[0].code);
				$('#sendTypeId').combobox('setText',data[0].codeName);
			}
		  }
	  });
	 $('#statusId').combobox({
		  url:'../query/codeQuery?codetype=STATUS',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#statusId').combobox('getData');
			if(data.length > 0){
				$('#statusId').combobox('setValue',data[0].code);
				$('#statusId').combobox('setText',data[0].codeName);
			}
		  }
	  });
	 $('#implType').combobox({
		  editable : false,
		  url:'../query/codeQuery?codetype=IMPL_TYPE',
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#implType').combobox('getData');
			if(data.length > 0){
				$('#implType').combobox('setValue',data[0].code);
				$('#implType').combobox('setText',data[0].codeName);
			}
		  }
	  });
	 initTempNode();//默认自动初始化MSG节点
});
function initBussType(){
	var comId = $('#platComId').combobox('getValue');
	$('#bussTypeId').combobox({
		  url:'../query/codeQueryByCom?codetype=BUSS_TYPE&comid='+comId,
		  valueField:'code',
		  textField:'codeName',
		  onLoadSuccess:function(r){
			var data = $('#bussTypeId').combobox('getData');
			if(data.length > 0){
				$('#bussTypeId').combobox('setValue',data[0].code);
				$('#bussTypeId').combobox('setText',data[0].codeName);
			}
		  }
	  });
}
/**
 * 临时节点初始化
 */
function initTempNode(){
	var url = "nodeRootUrl?type=0";
	var xformat = $("#formatTypeId").combobox('getValue');
	if(xformat == 'CLASS'){
		var bussType = $("#bussTypeId").combobox('getValue');
		url = "dtoRootUrl?type=0&formatType="+xformat+"&bussType="+bussType;
	}
	 //临时节点初始化
	 $.messager.progress({text:"正在为您加载数据，请稍等..."});
	 $('#tempRootNodeId').combobox({
		  url:url,
		  valueField:'id',
		  textField:'text',
		  onLoadSuccess:function(r){
			$.messager.progress('close');  
			var data = $('#tempRootNodeId').combobox('getData');
			if(data.length > 0){
				$('#tempRootNodeId').combobox('setValue',data[0].id);
				$('#tempRootNodeId').combobox('setText',data[0].text);
			}
		  },
		  onSelect:function(node){
			  initTree(node);
		  }  
	  });
}
/**
 * 初始化节点数
 * @param node
 */
function initTree(node){
	$.messager.confirm('提示',"是否选中节点："+node.text+" 添加？",function(add){
		  if (add){
			  var ids = $('#nodeTreeIds').val();
			  if(ids && ids !=""){
				  var isInner = ids.indexOf(node.id); 
				  if(isInner >= 0){
					  $.messager.confirm("提示","节点："+node.text+" 存在，是否重新添加！",function(r){
						  if(r){
							  var ids = $('#nodeTreeIds').val();
							  fromNodeTreeList(ids);
						  }
					  });
				  }else{
					  //说明：此处可控制是否可添加多个根节点，XML只能有一个根节点
					  var xformat = $("#formatTypeId").combobox('getValue');
					  if(xformat == "XML"){
						  $.messager.confirm("提示","XML格式报文只能添加一个根节点，是否刷新根节点操作？",function(r){
							  if(r){
								  $('#nodeTreeIds').val(node.id);
								  var ids = $('#nodeTreeIds').val();
								  fromNodeTreeList(ids);
							  }
						  });
					  }else{
						  $('#nodeTreeIds').val(ids+";"+node.id);
						  var ids = $('#nodeTreeIds').val();
						  fromNodeTreeList(ids);
					  }
				  }
			  }else{
				  $('#nodeTreeIds').val(node.id);
			  }
			  var ids = $('#nodeTreeIds').val();
			  fromNodeTreeList(ids);
		  }
		});
}
/**
 * 节点输入框与ID同步校验
 */
function checkInner(){
	var nodeCode = $('#nodeCodeId').val();
	if(nodeCode == null || "" == nodeCode || "" == nodeCode.trim()){
		//如果名称里面没有东西，则ID内默认是没有东西的
		$('#nodeId').val("");
		$('#nodeFid').val("");
	}
}
/**
 * 保存节点
 */
function saveNode(){
	var nodeCode = $('#nodeCodeId').val();
	if(nodeCode==null || nodeCode == ""){
		$.messager.alert("提示","请录入或者选择一个节点进行操作","info");
		return ;
	}
	var nodeSql = $('#nodeSqlId').val();
	if(nodeSql == null || nodeSql == ""){
		$.messager.confirm("提示","无对应生成子节点的信息，是否继续",function(r){
			if(r){
				submitThisNode();
			}
		});
	}else{
		submitThisNode();
	}
}
/**
 * 节点保存提交
 */
function submitThisNode(){
	var nodeCode = $('#nodeCodeId').val();
	var sonRoots = $('#thisSonTree').tree('getRoots');
	var ps = "";
	if(sonRoots && null != sonRoots && sonRoots.length > 0){
		for(var i = 0; i < sonRoots.length; i ++){
			var children = $('#thisSonTree').tree('getChildren',sonRoots[i].target);
			if(!children){
				$.messager.confirm("提示","当前提交无对应的子节点，是否确定提交？",function(r){
					if(!r){
						return;
					}
				});
			}else{
				for(var c = 0; c < children.length; c ++){
					ps += ("&text="+children[c].text);
				}
			}
		}
	}else{
		ps = "&text=";
	}
	addNodeSubmit(nodeCode,ps);	
}
/**
 * 添加TEMPNODE 提交
 * @param ps
 */
function addNodeSubmit(nodeCode,ps){
	var id = $('#nodeId').val(); //节点ID
	var fid = $('#nodeFid').val();//父类节点ID
	var content = $('#nodeSqlId').val();//子节点构造内容
	if(!contentFilter(content)){
		return ;
	}
	if(content.indexOf("#{") > 0){
		//将#{ 替换成^^ , } 替换成 ^ 保存时替换回来，因为作为参数传递过去传递不了，故替换
		content = content.replace(/\#{/g,"^^");
		content = content.replace(/\}/g,"^");
	}
	var sqlType  = $("input[name='msgNodeDef_NodeType']:checked").val();
	var url = "addNodeUrl?nodeCode="+nodeCode+"&type="+sqlType+"&id="+id+"&fid="+fid+"&content="+content+ps;
	$.post(url, function(data) {
		var sonRoots = $('#thisSonTree').tree('getRoots');
		if (sonRoots && null != sonRoots && sonRoots.length > 0) {
			$('#thisSonTree').tree('remove', sonRoots[0].target);
		}
		$('#nodeId').val("");
		$('#nodeFid').val("");
		$('#nodeCodeId').val("");
		$('#nodeSqlId').val("");
		//重新加载节点信息
		var ids = $('#nodeTreeIds').val();
		fromNodeTreeList(ids);
	});
}
/**
 * 保存报文引擎
 */
function saveXEngin(){
	if(!saveXEnginCheck()){
		return false;
	}
	//CLASS格式配置时，提示信息。
	var classMsg = "";
	var xformat = $("#formatTypeId").combobox('getValue');
	if(xformat == "CLASS"){
		var ids = $('#nodeTreeIds').val();
		if(ids != null && ""!= ids){
			classMsg = "CLASS格式的报文，所配置节点将不被保存。";
		}
	}
	var useName = $("#implType").combobox('getText');
	var statusName = $("#statusId").combobox('getText');
	$.messager.confirm("提示","正在进行报文规则引擎保存，"+classMsg+"<br>状态："+statusName+"，<br>定义："+useName+"，<br> 请确认信息是否正确？",function(r){
		if(r){
			$.messager.progress({text:"正在为您提交数据，请稍等..."});
			$.post('saveXEnginUrl',$("form").serialize(),function(data){
				if(data.msg == "success"){
					$.messager.progress('close');
					$.messager.alert("提示","节点规则配置保存成功 ","info");
					
				}else{
					$.messager.progress('close');
					$.messager.alert("提示","节点规则配置保存 "+data.msg,"info");
				}
			});
		}else{
			//TODO FALSE THING
			
		};
	});
}
/**
 * 规则引擎保存校验
 */
function saveXEnginCheck(){
	var result = true;
	var ids = $('#nodeTreeIds').val();
	var comId = $("#platComId").combobox('getValue');
	var bussTypeId = $("#bussTypeId").combobox('getValue');
	var xformat = $("#formatTypeId").combobox('getValue');
	var sendTypeId = $("#sendTypeId").combobox('getValue');
	var statusId = $("#statusId").combobox('getValue');
	var implType = $("#implType").combobox('getValue');
	if(comId == null){
		$.messager.alert("提示","报送平台必须选择","info");
		return false;
	}
	if(bussTypeId == null){
		$.messager.alert("提示","业务类型必须选择","info");
		return false;
	}
	if(xformat == null){
		$.messager.alert("提示","报文格式必须选择","info");
		return false;
	}
	//返回报文直接返回过滤报送类型
	if(implType == "MSG_RESPONSE"){
		return true;
	}else{
		//返回报文直接返回过滤报送类型
		if(implType == null){
			$.messager.alert("提示","报文定义必须选择","info");
			return false;
		}
	}
	
	if(sendTypeId == null){
		$.messager.alert("提示","报送方式必须选择","info");
		return false;
	}
	if(statusId == null){
		$.messager.alert("提示","有效标识必须选择","info");
		return false;
	}
	if(xformat!='CLASS'){
		if(ids==null || "" == ids){
			$.messager.alert("提示","非CLASS格式的报文，节点必须配置","info");
			result = false;
		}
	}
	return result;
}
/**
 * 浏览报文引擎
 */
function scanXEngin(){
	var ids = $('#nodeTreeIds').val();
	var xformat = $("#formatTypeId").combobox('getValue');
	var xdesc = $('#msgDesc').val();
	var xtitle = $('#headTitleId').val();
	var isTitle = $("input[name='isTitle']:checked").val();
	
	if(ids == null || "" == ids){
		$.messager.alert("提示","节点树无待浏览报文，请构造或从临时节点选择编辑。","info");
		return;
	}
	if("CLASS" == xformat){
		$.messager.alert("提示","CLASS 类型格式目前不支持报文浏览。","info");
		return;
	}
	var ps = "&xformat="+xformat+"&xdesc="+xdesc+"&xtitle="+xtitle+"&isTitle="+isTitle;
	parent.addtab("浏览报文","mconfig/scanMsgUrl?ids="+ids+ps,false);
}

/**
 * 打开添加节点属性窗口
 */
function openAddAttri(){
	var nodeId = $('#nodeId').val();
	if(nodeId == null || "" == nodeId){
		$.messager.alert("提示","请选择一个节点操作！",'info');
		return ;
	}
	var url = "addNodeAttriUrl?id="+nodeId;
	$('#attriWin').window({ 
		href:url,
		width:540, 
		height:400,
		title:'添加节点属性',
		modal:true
	}); 
}
/**
 * 打开添加节点参数窗口
 */
function openAddParam(){
	var nodeId = $('#nodeId').val();
	if(nodeId == null || "" == nodeId){
		$.messager.alert("提示","请选择一个节点操作！",'info');
		return;
	}
	var sql = $('#nodeSqlId').val();
	if(!sql || sql.length <= 0){
		$.messager.alert("提示","没有SQL可添加参数！如有必要，请添加SQL保存节点后进行添加参数。<br>参数为SQL中对应的'#{XX}'！",'info');
		return ;
	}
	$('#paramWin').window({ 
		width:1000, 
		height:520,
		title:'添加SQL参数',
		modal:true,
		href:"addNodeSqlParamUrl?id="+nodeId
	}); 
}
/**
 * 创建子节点
 */
function buildSonNodes(){
	var buildType = $("input[name='msgNodeDef_NodeType']:checked").val();
	if(buildType == 2){
		$.messager.alert("提示","目前只支持SQL类型构造子节点","info");
		return ;
	};
	var nodeCode = $('#nodeCodeId').val();
	if(nodeCode == null || "" == nodeCode){
		$.messager.alert("提示","请选择或录入一个节点进行构造","info");
		return ;
	}
	var content = $('#nodeSqlId').val();
	var isGoon = false;
	if(content == null || "" == content){
		$.messager.confirm("提示","无构造节点相应的SQL或信息，是否确认构造一个节点？",function(r){
			if(r){
				isGoon = true;
			}else{
				//TODO SOMETHING OTHER
				return ;
			}
		});
	}else{
		isGoon = true;
	}
	if(isGoon){
		if(!contentFilter(content)){
			return ;
		}
		if(content.indexOf("#{") > 0){
			//将#{ 替换成^^ , } 替换成 ^ 保存时替换回来，因为作为参数传递过去传递不了，故替换
			content = content.replace(/\#{/g,"^^");
			content = content.replace(/\}/g,"^");
		}
		var url = encodeURI('buildSonNode?nodeCode='+nodeCode+'&content='+content+'&type=1');
		$('#thisSonTree').tree({
			url:url,
			lines:true,
			/*checkbox:true,*/
			animate:true,
			onLoadSuccess : function(node, data){
			if(data == null){
				$.messager.alert("提示","无对应子节点信息，请录入或修改构造类容进行重试！","info");
				return;
			}
			if(data.length < 1 ){
				$.messager.alert("提示","构造子节点失败，请核对构造SQL是否正确或重试！","info");
				return;
			}
		},
		onLoadError : function(arguments) {
			
		}
		});
	}
}
/**
 * Content 过滤器
 */
function contentFilter( content){
	if(content.indexOf("^") > 0){
		$.messager.alert("提示","构造内容中不能包含 ^ 符号，请重试","info");
		return false;
	}
	
	return true;
}
/**
 * 更具指定ID从节点加载树
 */
function fromNodeTreeList(nodes){
	
	var ps = "";
	var isSplit = nodes.indexOf(";");
	if(isSplit > 0){
		var nodeList = nodes.split(";");
		if(nodeList.length > 0){
			for(var i = 0; i < nodeList.length; i ++){
				ps += "&id="+nodeList[i];
			};
		}
	}else{
		ps = "&id="+nodes.trim();
	}
	var treeDelete = $('#treeDeleteId');
	$('#msgTreeId').tree({
		lines:true,
		url : 'nodeTreeList?type=0' + ps,
		dnd : true,
		/*
		 onStopDrag:function(node){
			$.messager.confirm("提示","确定删除？",function(r){
				if(r){
					$('#msgTreeId').tree('remove',node.target);
				}
			});
		},*/
		onClick:function(node){
			$('#nodeId').val(node.id);
			$('#nodeFid').val(node.fid);
			$('#nodeCodeId').val(node.text);
			getSqlTypeAndContent(node.id);
		}
	});
}
/**
 * 根据ID获取加载子节点的内容
 * @param id
 */
function getSqlTypeAndContent(id){
	$.post('getTempNodeSql?id='+id,function (data){
		$('#nodeSqlId').val("");
		$('#nodeSqlId').val(data.CONTENT);
	});
}
/**
 * 选中属性列执行
 * @param index
 * @param row
 */
function onClickAttriRow(index,row){
	var id = row.id;
	var name = row.name;
	var type = row.type;
	var value = row.value;
	var code = row.code;
	$('#id').val(id);
	$('#attriCodeId').val(code);
	$('#attriNameId').val(name);
	$('#attriTypeId').val(type);
	$('#attriValueId').val(value);
}
/**
 * 选中参数列执行
 * @param index
 * @param row
 */
function onClickParamRow(index,row){
	var id = row.id;
	var name = row.name;
	var type = row.type;
	var value = row.value;
	var valueType = row.valueType;
	var subType = row.subType;
	var code = row.code;
	$('#id').val(id);
	$('#paramCodeId').val(code);
	$('#paramNameId').val(name);
	$('#paramType').val(type);
	$('#paramValueId').val(value);
	$("#paramTypeId").combobox("setValue",type);
	reloadCombox('paramValueTypeId',valueType);
	$("#paramSubTypeId").combobox("setValue",subType);
}
//重新初始化下拉框
function reloadCombox(id,text){
	var data = $('#'+id).combobox('getData');
	if(data.length > 0){
		var length = data.length;
		for(var i = 0; i < length; i++){
			var tText = data[i].codeName;
			if(tText == text){
				$('#'+id).combobox('setValue',data[i].code);
				$('#'+id).combobox('setText',data[i].codeName);
				break;
			}
		}
	}
}
/**
 * 添加属性
 */
function addAttri(){
	
	var code = $('#attriCodeId').val();
	if(code == null || "" == code || 'undefined' == code){
		$.messager.alert("提示","请录入编码进行添加",'info');
		return ;
	}
	var name = $('#attriNameId').val();
	if(name == null || "" == name || 'undefined' == name){
		$.messager.alert("提示","请录入属性名称进行添加",'info');
		return ;
	}
	var value = $('#attriValueId').val();
	if(value == null || "" == value || 'undefined' == value){
		$.messager.alert("提示","请录入属性值进行添加",'info');
		return ;
	}
	
	//提交 operater=0 新增 1 修改
	var url='nodeAttriSaveUrl?operater=0';
	$.post(url,$('#nodeAttriForm').serialize(), function(data){
		//TODO SOMETHING
		$.messager.alert("提示","节点 "+name+" "+data.msg,'info');
		$("#nadg").datagrid('reload');
		//提交完毕清空
		$('#id').val("");
		$('#attriNameId').val("");
		$('#attriTypeId').val("");
		$('#attriValueId').val("");
		$('#attriCodeId').val("");
	});
}
/**
 * 修改属性
 */
function updateAttri(){
	var id = $('#id').val();
	if(id == null || "" == id){
		$.messager.alert("提示","请选择一条记录修改",'info');
		return ;
	}
	var code = $('#attriCodeId').val();
	if(code == null || "" == code || 'undefined' == code){
		$.messager.alert("提示","请录入编码进行修改",'info');
		return ;
	}
	var name = $('#attriNameId').val();
	if(name == null || "" == name || 'undefined' == name){
		$.messager.alert("提示","请录入名称进行修改",'info');
		return ;
	}
	/*
	var type = $('#attriTypeId').val();
	if(type == null || "" == value || 'undefined' == type){
		$.messager.alert("提示","请录入类型进行修改",'info');
		return ;
	}
	*/
	var value = $('#attriValueId').val();
	if(value == null || "" == value || 'undefined' == value){
		$.messager.alert("提示","请录入默认值进行修改",'info');
		return ;
	}
	//TODO 提交操作
	//提交 operater=0 新增 1 修改
	var url='nodeAttriSaveUrl?operater=1';
	$.post(url,$('#nodeAttriForm').serialize(), function(data){
		//TODO SOMETHING
		$.messager.alert("提示","节点 "+name+" "+data.msg,'info');
		$("#nadg").datagrid('reload');
		//提交完毕清空
		$('#id').val("");
		$('#attriNameId').val("");
		$('#attriTypeId').val("");
		$('#attriValueId').val("");
		$('#attriCodeId').val("");
	});
	
}
/**
 * 添加属性
 */
function addParam(){
	
	var code = $('#paramCodeId').val();
	if(code == null || "" == code || 'undefined' == code){
		$.messager.alert("提示","请录入参数编码进行添加",'info');
		return ;
	}
	var name = $('#paramNameId').val();
	if(name == null || "" == name || 'undefined' == name){
		$.messager.alert("提示","请录入参数名称进行添加",'info');
		return ;
	}
	var type = $('#paramType').val();
	if(type == null || "" == type || 'undefined' == type){
		$.messager.alert("提示","请选择参数类型进行添加",'info');
		return ;
	}
	var vType = $('#paramValueType').val();
	if(vType == null || "" == vType || 'undefined' == vType){
		$.messager.alert("提示","请选择参数值类型进行添加",'info');
		return ;
	}
	var content = $("#paramValueId").val();
	//TODO 基本校验
	if(!checkParam(type,content)){
		return false;
	}
	//TODO 提交 operater=0 新增 1 修改
	var url='nodeParamSave?operater=0';
	$.post(url,$('#nodeParamForm').serialize(), function(data){
		//TODO SOMETHING
		$.messager.alert("提示","编码 "+code+" "+data.msg,'info');
		//提交完毕清空
		clearParam();
		//提交完毕刷新
		$("#npdg").datagrid('reload');
	});
}
/**
 * 校验参数
 * @param type
 * @param content
 * @returns {Boolean}
 */
function checkParam(type,content){
	//2、3 类型，参数值必填
	if(type == "2" || type == 2 || type == "3" || type == 3){
		if(content == null || content == ''){
			$.messager.alert("提示","参数参数值必须填写",'info');
			return false;
		}
	}
	//2类型，SQL 必须有效，此为基本的格式校验
	if(type == "2" || type == 2){
		content = content.toUpperCase();
		if(content.indexOf("SELECT") < 0){
			$.messager.alert("提示","参数类型为2，参数值必须是有效SQL",'info');
			return false;
		}
		if(content.indexOf("FROM") < 0){
			$.messager.alert("提示","参数类型为2，参数值必须是有效SQL",'info');
			return false;
		}
	}
	return true;
}
/**
 * 修改参数
 */
function updateParam(){
	var id = $('#id').val();
	if(id == null || "" == id){
		$.messager.alert("提示","请选择一条记录修改",'info');
		return ;
	}
	var code = $('#paramCodeId').val();
	if(code == null || "" == code || 'undefined' == code){
		$.messager.alert("提示","请录入参数编码进行添加",'info');
		return ;
	}
	var name = $('#paramNameId').val();
	if(name == null || "" == name || 'undefined' == name){
		$.messager.alert("提示","请录入参数名称进行修改",'info');
		return ;
	}
	var type = $('#paramType').val();
	if(type == null || "" == type || 'undefined' == type){
		$.messager.alert("提示","请选择参数类型进行修改",'info');
		return ;
	}
	var vType = $('#paramValueType').val();
	if(vType == null || "" == vType || 'undefined' == vType){
		$.messager.alert("提示","请选择参数值类型进行修改",'info');
		return ;
	}
	var content = $("#paramValueId").val();
	//TODO 基本校验
	if(!checkParam(type,content)){
		return false;
	}
	//TODO 提交 operater=0 新增 1 修改
	var url='nodeParamSave?operater=1';
	$.post(url,$('#nodeParamForm').serialize(), function(data){
		//TODO SOMETHING
		$.messager.alert("提示","参数 "+name+" "+data.msg,'info');
		//提交完毕清空
		clearParam();
		//提交完毕刷新
		$("#npdg").datagrid('reload');
	});
	
}
/**
 * 清除参数
 */
function clearParam(){
	$('#id').val("");
	$('#paramType').val("");
	$('#paramCodeId').val("");
	$('#paramNameId').val("");
	$('#paramValueId').val("");
	$('#paramSubType').val("");
	$('#paramTypeId').combobox("reload");
	$('#paramSubTypeId').combobox("reload");
	$('#paramValueTypeId').combobox("reload");
}
/**
 * 实现Easyui 删除行级操作
 * @param index
 */
function deleteRow(index){
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if(result){
			//参数删除
			try{
				var paramGrid = $("#npdg");
				if(paramGrid && 'undefined' != paramGrid){
					deleteParam(index);
				}
			}catch(e){
				var attiGrid = $("#nadg");
				if(attiGrid && 'undefined' != attiGrid){
					deleteAttri(index);
				}
			}
		}
	});
}
/**
 * 删除节点属性
 * @param index
 */
function deleteAttri(index){
	var nodeAttriGrid = $('#nadg');
	//置空非所选
	nodeAttriGrid.datagrid('clearSelections');
	//选中删除列
	nodeAttriGrid.datagrid('selectRow',index-1);
	var row = nodeAttriGrid.datagrid('getSelected');
	var ps = "?id=" + row.id;
	$.post('deleteTempNodeAttri' + ps, function(data) {
		nodeAttriGrid.datagrid('reload');//数据库刷新
	});
}
/**
 * 删除节点参数
 * @param index
 */
function deleteParam(index){
	var nodeParamGrid = $('#npdg');
	//置空非所选
	nodeParamGrid.datagrid('clearSelections');
	//选中删除列
	nodeParamGrid.datagrid('selectRow',index-1);
	var row = nodeParamGrid.datagrid('getSelected');
	var ps = "?id=" + row.id;
	$.post('deleteTempNodeParam' + ps, function(data) {
		if(data.result == "false"){
			$.messager.alert("提示",data.msg,"info");
		}else{
			nodeParamGrid.datagrid('reload');
		}
		
	});
}
/***
 * 删除临时子节点
 */
function deleteTempNode(){
	var tempNodeId = $('#tempRootNodeId').combobox('getValue');
	var tempNodeName = $('#tempRootNodeId').combobox('getText');
	$.messager.confirm('提示','是否确定删除临时节点：'+"  "+tempNodeName,function(r){
		if(r){
			$.post('deleteTempNode?id=' + tempNodeId, function(data) {
				if(data.msg == 'success'){
					$.messager.confirm('提示','删除临时节点：'+tempNodeName+" 成功");
					$('#tempRootNodeId').combobox('reload');
				}
			});
		}
	});
}
/**
 * 动态确定参数值类型
 */
function changeParamValueType(){
	var value = $('#paramValueTypeId').combobox('getValue');
	$('#paramValueType').val(value);
}
/**
 * 动态确定参数类型
 */
function changeParamType(){
	var type = $('#paramTypeId').combobox('getValue');
	$('#paramType').val(type);
}
function changeParamSubType(){
	var sbType = $('#paramSubTypeId').combobox('getValue');
	$('#paramSubType').val(sbType);
}