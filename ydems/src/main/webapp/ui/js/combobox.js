function loadMdmCombobox(getmdmUrl, id, status) {
	debugger;
	reqUrl = getmdmUrl;
	$.ajax({
		async : false,
		type : "POST",
		url : reqUrl,
		contentType : "application/json", // 必须有
		dataType : "json", // 表示返回值类型，不必须
		success : function(jsonData) {
			editHistoryData = jsonData.data;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].sup_code;
				var text1 = editHistoryData[i].sup_code_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + status).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}

	});
}
/* 加载对应编码的名称 */
function loadCombobox(ddicUrl, id, status) {
	debugger;
	reqUrl = ddicUrl + status;
	// alert(ddicUrl);
	$.ajax({
		type : "POST",
		url : reqUrl,
		contentType : "application/json", // 必须有
		dataType : "json", // 表示返回值类型，不必须
		success : function(jsonData) {
			editHistoryData = jsonData.data;
			// alert(editHistoryData);
			// data-options="valueField:'value',textField:'text',data:[{'value':'1','text':'java'},{'value':'2','text':'C#'}]"
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].code_type;
				var text1 = editHistoryData[i].code_name;
				// alert(value1);
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}

	});
}
/* 获取供应商名称 */
function load_Mdm_NameData(loadMdmUrl, msnSelectId) {
	$.ajax({
		type : "POST",
		async: false,
		url : loadMdmUrl,
		dataType : "json",
		contentType : "application/json",
		/* data : JSON.stringify(jsonData), */
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].sup_code;
				var text1 = editHistoryData[i].sup_code_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + msnSelectId).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}

/* 加载设备类型列表：Url是请求的路径，id是对应的显示标签id */
function loadEquipTypeData(Url, id) {
	$.ajax({
		type : "POST",
		url : Url,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].typ_type;
				var text1 = editHistoryData[i].typ_type_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}

/* 加载设备类型编码 */
function loadEquipTypeIdData(equipTypeIdUrl, id) {
	$.ajax({
		type : "POST",
		url : equipTypeIdUrl,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].typ_type;
				var text1 = editHistoryData[i].typ_type_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 获取组织机构数据 */
function load_Orgn_NameData(loadOrgUrl, orgSelectId) {
	$.ajax({
		type : "POST",
		async: false,
		url : loadOrgUrl,
		dataType : "json",
		contentType : "application/json",
		/* data : JSON.stringify(jsonData), */
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].org_id;
				var text1 = editHistoryData[i].org_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + orgSelectId).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 获取单位数据 */
function load_Unit_Data(loadUnitUrl, unitSelectId) {
	$.ajax({
		type : "POST",
		url : loadUnitUrl,
		dataType : "json",
		contentType : "application/json",
		/* data : JSON.stringify(jsonData), */
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].unit_code;
				var text1 = editHistoryData[i].unit_code_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + unitSelectId).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 获取采购计划数据 */
function load_Purchase_Plain_Data(loadPurchasePlainUrl, che_obj_id, che_org_id,
		sup_code_id, pur_no_id) {
	/* che_obj_id：设备编号 che_org：组织机构 sup_code：验货供应商 pur_no_id：采购计划流水号 */
	$.ajax({
		type : "POST",
		url : loadPurchasePlainUrl,
		dataType : "json",
		contentType : "application/json",
		/* data : JSON.stringify(jsonData), */
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			var dataObj2 = [];
			var dataObj3 = [];
			var dataObj4 = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				/* 待验收设备编号pur_obj */
				var value1 = editHistoryData[i].pur_obj;
				var text1 = editHistoryData[i].pur_obj;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			for ( var i = 0; i < editHistoryData.length; i++) {
				/* 组织机构pur_org */
				var value1 = editHistoryData[i].pur_org;
				var text1 = editHistoryData[i].pur_org_name;
				dataObj2.push({
					value : value1,
					text : text1
				});
			}
			for ( var i = 0; i < editHistoryData.length; i++) {
				/* sup_code：验货供应商 */
				var value1 = editHistoryData[i].sup_code;
				var text1 = editHistoryData[i].sup_code_name;
				dataObj3.push({
					value : value1,
					text : text1
				});
			}
			for ( var i = 0; i < editHistoryData.length; i++) {
				/* pur_no_id：采购计划流水号 */
				var value1 = editHistoryData[i].pur_no;
				var text1 = editHistoryData[i].pur_no;
				dataObj4.push({
					value : value1,
					text : text1
				});
			}
			/* 设备编号 */
			$("#" + che_obj_id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
			/* 组织机构 */
			$("#" + che_org_id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj2
			});
			/* 验货供应商 */
			$("#" + sup_code_id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj3
			});
			/* 采购计划流水号 */
			$("#" + pur_no_id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj4
			});
		}
	});
}
/* 获取采购计划流水号 */
function load_Purchase_plan_Data(loadPurchasePlanUrl, purNoSelectId) {
	$.ajax({
		type : "POST",
		url : loadPurchasePlanUrl,
		dataType : "json",
		contentType : "application/json",
		/* data : JSON.stringify(jsonData), */
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].pur_no;
				var text1 = editHistoryData[i].pur_no;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + purNoSelectId).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 获取人员主信息 */
function load_Empolyee_Data(loadEmployeeUrl, employeeSelectId) {
	$.ajax({
		type : "POST",
		async: false,
		url : loadEmployeeUrl,
		dataType : "json",
		contentType : "application/json",
		/* data : JSON.stringify(jsonData), */
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].emp_id;
				var text1 = value1 + "(" + editHistoryData[i].emp_name+")";
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + employeeSelectId).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 加载设备数据：Url是请求的路径，id是对应的显示标签id */
function loadEquipData(Url, id) {
	$.ajax({
		type : "POST",
		url : Url,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].equip_id;
				var text1 = editHistoryData[i].equip_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 获取设备维修类型数据：Url是请求的路径，id是对应的显示标签id */
function loadRepairTypeData(Url, id) {
	$.ajax({
		type : "POST",
		url : Url,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].rep_type;
				var text1 = editHistoryData[i].rep_type_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 获取大型设备编号 */
function loadEquipIdData(Url, id) {
	$.ajax({
		type : "POST",
		async: false,
		url : Url,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].bigequip_id;
				var text1 = "标示:" + value1 + "|" + "设备名称:"
						+ editHistoryData[i].bigequip_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}

/* 获取故障类型主数据 */
function loadFaultData(Url, id) {
	$.ajax({
		type : "POST",
		url : Url,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].fau_type;
				var text1 = editHistoryData[i].fau_type_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}

/* 获取对象类型子类型标示列表 */
function loadRelateData(relateUrl, id) {
	debugger;
	$.ajax({
		type : "POST",
		url : relateUrl,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].cla_subtype;
				var text1 = editHistoryData[i].cla_subtype_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 加载设备型号 */
function loadEquipModelData(modelUrl, id) {
	$.ajax({
		type : "POST",
		url : modelUrl,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].mod_type;
				var text1 = editHistoryData[i].mod_type_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 备品备件主数据 */
function loadSpareData(Url, id) {
	$.ajax({
		type : "POST",
		url : Url,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].spare_id;
				var text1 = editHistoryData[i].spare_name;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/* 备品备件标示 */
function loadSpareIdData(Url, id) {
	$.ajax({
		type : "POST",
		url : Url,
		dataType : "json",
		contentType : "application/json",
		success : function(jsonData) {
			editHistoryData = jsonData.rows;
			var dataObj = [];
			for ( var i = 0; i < editHistoryData.length; i++) {
				var value1 = editHistoryData[i].spare_id;
				var text1 = editHistoryData[i].spare_id;
				dataObj.push({
					value : value1,
					text : text1
				});
			}
			$("#" + id).combobox({
				valueField : 'value',
				textField : 'text',
				data : dataObj
			});
		}
	});
}
/*
 * function setReadOnly(id) { document.getElementById(id).readOnly=true;
 * document.getElementById(id).style.backgroundColor = "#D1D1D1"; }
 */
function setAllInputReadOnly() {
	$("#pur_no").combobox({

		readonly : true
	});

	// setReadOnly("pur_obj");
	$("#pur_obj").combobox({
		// disabled:true
		readonly : true
	});

	$("#pur_org").combobox({
		readonly : true
	});
	$("#type_txt").combobox({
		readonly : true
	});
	$("#sup_code").combobox({
		readonly : true
	});
	$("#pur_amt").combobox({
		readonly : true
	});
	$("#pur_unit").combobox({
		readonly : true
	});
	$("#app_emp").combobox({
		readonly : true
	});
	$("#app_emp_num").combobox({
		readonly : true
	});
	$("#app_date").combobox({
		readonly : true
	});
}
