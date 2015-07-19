function loadCompanyCombobox(){
	$('#province').combobox({    
	    url:'/ydcmp/actions/common/provinces.do',    
	    valueField:'provinceId',    
	    textField:'provinceName',
	    filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.textField].indexOf(q) > -1;
		},
	    onSelect:function(rec){
	    	$("#city").combobox('clear');
	    	$("#branch").combobox('clear');
    		var url = "/ydcmp/actions/common/cities.do?privinceId=" + rec.provinceId;
	    	$("#city").combobox('reload', url);
	    	url = "/ydcmp/actions/org/get_branch_orgs_city.do?cityId=";
	    	$("#branch").combobox('reload', url);
	    	$("#orgCode").val("");
	    	$("#orgCode").blur();
	    },
	    loadFilter:function(oData){
	    	var data = oData.data;
	    	data.unshift({"provinceId":"","provinceName":"请选择"});
	    	return data;
	    },
	}); 
	
	$('#city').combobox({    
	    url:'',    
	    valueField:'cityId',    
	    textField:'cityName',
	    filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.textField].indexOf(q) > -1;
		},
		onSelect:function(rec){
			$("#branch").combobox('clear');
			var url = "/ydcmp/actions/org/get_branch_orgs_city.do?cityId=" + rec.cityId;
			$("#branch").combobox('reload', url);
	    },
	    loadFilter:function(oData){
	    	var data = oData.data;
	    	data.unshift({"cityId":"","cityName":"请选择"});
	    	return data;
	    },
	});
	
	$('#branch').combobox({
	    url:'',    
	    valueField:'orgCode',    
	    textField:'orgName',
	    filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.textField].indexOf(q) >-1;
		},
		onSelect:function(rec){
			$("#orgCode").val(rec.orgCode);
	    },  
	    loadFilter:function(oData){
	    	var data = oData.data;
	    	for(var i in data){
	    		data[i].orgName = data[i].orgName + "(" + data[i].orgCode + ")";
	    	}
	    	data.unshift({"orgCode":"","orgName":"请选择"});
	    	return data;
	    },
	});

}

function checkIsEditable(obj){
	var province = $('#province').combobox('getValue');
	var city = $('#city').combobox('getValue');
	var branch = $('#branch').combobox('getValue');
	if(province=="" && city=="" && branch==""){
		$("#orgCode").removeAttr("readonly");
	}else{
		$("#orgCode").attr("readonly", true);
	}
};