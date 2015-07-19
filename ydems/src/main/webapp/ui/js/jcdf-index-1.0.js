
//记录窗口中间内容展示区的高度，便于后面所欲iframe的统一控制
var centerHeight = 0;
//进入首页默认初始化tab
var userData = JSON.parse(localStorage.getItem("userData"));
$(function(){
    setCurrentUser();
    getUserMenus();
//    isRechargePasswordSet();
	centerHeight = $("#welcomeTab").parent().height()-4;
	$('#centerTab').tabs({
		cache:false,
		onLoad:function(panel){
			var plugin = panel.panel('options').title;
		},
		onClose:function() {
			return false;
		},
		onSelect:function(title,index) {
/*			if("网点账户"==title){
				$("iframe[name=iframe"+index+"]").attr("src",$("iframe[name=iframe"+index+"]").attr("src")+"?random="+Math.random());
			}*/
		}
	});
	bindTabEvent();  
    bindTabMenuEvent(); 
});
//以tab的形式打开一个模块
var index = 0;
function openNewTab(id){
	index = index+1;
	var title = $("#"+id).text();
	var href = $("#"+id).attr("link");
	if ($('#centerTab').tabs('exists',title)){
		$('#centerTab').tabs('select', title);
	} else {
		$('#centerTab').tabs('add',{
			id:id,
			title:title,
			content:'<iframe id="frame_"'+id+' name="frame_'+id+'" width="100%" height="'+centerHeight+'" src="'+href+'" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0"></iframe>',
			closable:true
		});
	}
}
//打开对话框
var sonFrameName = null;
function jcdfDialog(frameName, href, title, maxHeight, maxWidth, widthRate) {
	sonFrameName = frameName;
	var dialogDiv = $("#jcdfDiglogDiv");
	if(!dialogDiv || dialogDiv.length <= 0) {
		var html = '<div id="jcdfDiglogDiv" style="display: none;">'+
			'<iframe id="jcdfDiglogDivIframe" name="" width="100%" height="200" src="" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0"></iframe>'+
			'</div>';
		$("body").append(html);
	}
	$("#jcdfDiglogDivIframe").attr('src', href);
	$('#jcdfDiglogDiv').css('display','');
	$('#jcdfDiglogDiv').dialog({
		title:title,
		modal:true,
		maximizable:true,
		resizable:true,
		closed: false,
		onOpen:function() {
			$$.fillDialogWidthAndHeight("jcdfDiglogDiv", widthRate, maxHeight, maxWidth);
			$("#jcdfDiglogDivIframe").height($("#jcdfDiglogDivIframe").parent().height()-4);
		},
		onResize:function() {
			$("#jcdfDiglogDivIframe").height($("#jcdfDiglogDivIframe").parent().height()-4);
		},
		onClose:function() {
			$("#jcdfDiglogDivIframe").attr('src', 'about:blank');
		}
	});
}

function modalDialog(href, title, maxHeight, maxWidth, widthRate) {
	var dialogDiv = $("#modalDiglogDiv");
	if(!dialogDiv || dialogDiv.length <= 0) {
		var html = '<div id="modalDiglogDiv" style="display: none;">'+
			'<iframe id="modalDiglogDivIframe" name="" width="100%" height="200" src="" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0"></iframe>'+
			'</div>';
		$("body").append(html);
	}
	$("#modalDiglogDivIframe").attr('src', href);
	$('#modalDiglogDiv').css('display','');
	$('#modalDiglogDiv').dialog({
		title:title,
		modal:true,
/*				maximizable:true,
		resizable:true,*/
		closed: false,
		onOpen:function() {
			$$.fillDialogWidthAndHeight("modalDiglogDiv", widthRate, maxHeight, maxWidth);
			$("#modalDiglogDivIframe").height($("#modalDiglogDivIframe").parent().height()-4);
		},
		onResize:function() {
			$("#modalDiglogDivIframe").height($("#modalDiglogDivIframe").parent().height()-4);
		},
		onClose:function() {
			$("#modalDiglogDivIframe").attr('src', 'about:blank');
		}
	});
}

//绑定tab的双击事件、右键事件  
function bindTabEvent(){  
    $(".tabs-inner").live('dblclick',function(){  
        var subtitle = $(this).children("span").text();  
        if($(this).next().is('.tabs-close')){  
            $('#centerTab').tabs('close',subtitle);  
        }  
    });  
    $(".tabs-inner").live('contextmenu',function(e){  
        $('#mm').menu('show', {  
            left: e.pageX,  
            top: e.pageY  
     });  
     var subtitle =$(this).children("span").text();  
     $('#mm').data("currtab",subtitle);  
     $('#centerTab').tabs('select', subtitle);
     return false;  
    });  
 } 

//绑定tab右键菜单事件  
function bindTabMenuEvent() {  
    //关闭当前  
    $('#mm-tabclose').click(function() {  
        var currtab_title = $('#mm').data("currtab");  
        if (currtab_title!="欢迎页面") {  
            $('#centerTab').tabs('close', currtab_title);  
        }  
    });  
    //全部关闭  
    $('#mm-tabcloseall').click(function() {  
        $('.tabs-inner span').each(function(i, n) {  
            if ($(this).parent().next().is('.tabs-close')) {  
                var t = $(n).text();  
                $('#centerTab').tabs('close', t);  
            }  
        });  
    });  
    //关闭除当前之外的TAB  
    $('#mm-tabcloseother').click(function() {  
        var currtab_title = $('#mm').data("currtab");  
        $('.tabs-inner span').each(function(i, n) {  
            if ($(this).parent().next().is('.tabs-close')) {  
                var t = $(n).text();  
                if (t != currtab_title)  
                    $('#centerTab').tabs('close', t);  
            }  
        });  
    });  
    //关闭当前右侧的TAB  
    $('#mm-tabcloseright').click(function() {  
        var nextall = $('.tabs-selected').nextAll();  
        if (nextall.length == 0) {  
//            alert('已经是最后一个了');  
            return false;  
        }  
        nextall.each(function(i, n) {  
            if ($('a.tabs-close', $(n)).length > 0) {  
                var t = $('a:eq(0) span', $(n)).text();  
                $('#centerTab').tabs('close', t);  
            }  
        });  
        return false;  
    });  
    //关闭当前左侧的TAB  
    $('#mm-tabcloseleft').click(function() {  
        var prevall = $('.tabs-selected').prevAll();  
        if (prevall.length == 1) {  
//            alert('已经是第一个了');  
            return false;  
        }  
        prevall.each(function(i, n) {  
            if ($('a.tabs-close', $(n)).length > 0) {  
                var t = $('a:eq(0) span', $(n)).text();  
                $('#centerTab').tabs('close', t);  
            }  
        });  
        return false;  
    });  
}  

//刷新
function refreshJcdfDatagrid(datagridId, type){
	window.frames[sonFrameName].$$.refreshJcdfDatagrid(datagridId);
	try{
	window.frames[sonFrameName].$$.flashTable(datagridId);
	}catch(e){}
}
//关闭窗口
function closeJcdfDialog() {
	$('#jcdfDiglogDiv').dialog('close');
}

function closeModalDialog() {
	$('#modalDiglogDiv').dialog('close');
}

//弹出消息提示框
function showJcdfMessager(frameName, title, msg, icon, fn) {
	title = !title ? "提示消息" : title;
	msg = !msg ? "?":msg;
	icon = !icon ? "info":icon;
	$.messager.alert(title, msg, icon, function(){
		if(fn)eval('window.frames["'+frameName+'"].'+fn);
	});	
}
//弹出确认消息框
function showJcdfConfirm(frameName, title, msg, fn) {
	title = !title ? "确认" : title;
	msg = !msg ? "?" : msg;
	$.messager.confirm(title, msg, function(r){
		if (r && fn){
			eval('window.frames["'+frameName+'"].'+fn);
		}
	});
}
//回调函数
function invokeParentMethod(fn, args) {
	var argsStr = "";
	var methodStr = "";
	if (arguments.length > 1) {
		for (var i = 1; i < arguments.length; i=i+1) {
			argsStr = argsStr ? argsStr+',"'+arguments[i]+'"' : '"'+arguments[i]+'"';
		}
		if (argsStr) {
			methodStr = arguments[0]+"("+argsStr+")";
		} else {
			methodStr = methodStr[0];
		}
		eval('window.frames["'+sonFrameName+'"].'+methodStr);
	}
}

/**
 *	系统密码修改和退出功能控制
 */	
$(function(){
	//退出系统
	$("#logout").bind('click', function(){
		$.messager.confirm('提示消息', "确定退出?", function(r){
			if (r) {
				$.ajax({
					type : "POST",
					url : c_url_logout,
					dataType : "json",
					success : function(oData) {
						if (oData && oData.errorCode ==0 ) {
							localStorage.removeItem("userData");
							window.location.href = c_url_login;
						}else{
							$$.showJcdfMessager('提示消息', oData.msg, 'warning');
						}
					}
				});
			}
		});
	});
});

function isRechargePasswordSet(){
	if(userData!=null && userData.orgData!=null && (userData.orgData.orgType=="2" || userData.orgData.orgType=="22")){
		$.ajax({
			type : "POST",
			url : c_url_has_pwd,
			dataType : "json",
			success : function(oData) {
				if (oData && oData.xSuccess && oData.hasPassword!=undefined && !oData.hasPassword) {
					$('#setPassDialog').dialog('open');
				}
			}
		});
	}
}

function setPassword(){
	if (!$("#form_password").form('validate')) {
		return false;
	}
	var jsonData = $$.serializeToJson("#form_password");
	if(!jsonData) return false;
	jsonData.new_pass = encodeURIComponent(jsonData.new_pass);
	jsonData.confirm_pass = encodeURIComponent(jsonData.confirm_pass);
	//如果数据验证通过(即数据合法)
	$$.openProcessingDialog();
	//ajax提交数据
	$.ajax({
		type : "POST",
		url : c_url_change_pwd,
		dataType : "json",
		data : jsonData,
		success : function(data) {
			$$.closeProcessingDialog();
			if (data && data.xSuccess) {
				$('#setPassDialog').dialog('close');
				$$.showJcdfMessager('提示消息', '设置充值密码成功', 'info');
			} else {
				$$.showJcdfMessager('提示消息', data.msg, 'warning');
			}
		}
	});
};

function resetForm(){
	$("#form_password").form('reset');
}

function setCurrentUser(){
	if(userData!=null){
		$("#userName").html(userData.user_name);
		$("#userId").html(userData.user_id);
	}else{
		window.location.href = c_url_login;
	}
}

function getUserMenus(){
	$.ajax({
		type : "POST",
		url : c_url_get_resources,
		cache : false,
		dataType : "json",
		success : function(data) {
			if (null != data && data.errorCode==0) {
				generateMenu(data.data);
			    $('#sysMenu').accordion('select', 0);
			}  else {
				$$.showJcdfMessager('提示消息', data.msg, 'warning'); 
			}
		}
	});
}

function generateMenu(menus){
	var lis="";
	for(var i=0;i<menus.length;i++){
		if(menus[i].type=="F"&&menus[i].level==0){
			var iconCls = "";
			$("#sysMenu").accordion("add",{
				title:menus[i].name,
				iconCls:iconCls,
				content:"<div style='padding: 1px;'><ul class='easyui-tree'>"+
				generateMenu(menus[i].menus)+
				"</ul></div>"
			});
		} else if(menus[i].type=="F"){
			lis+="<span>"+menus[i].name+"</span><ul>"+generateMenu(menus[i].menus)+"</ul>";
		}else if(menus[i].type=="A"){
			lis+="<li>"+
			"<a id="+menus[i].id+" link='../../"+menus[i].url+"' onclick=openNewTab('"+menus[i].id+"') >"+menus[i].name+"</a>"+
		    "</li>";
		}
	}
	return lis;
};

function mloadCombobox(fieldId,ddicType){	
	$('#'+fieldId).combobox({
		url:c_url_ddic+ddicType,
		valueField : 'code_type',
		textField : 'code_name',
		filter : function(q, row) {
			var opts = $(this).combobox('options');
			return row[opts.textField].indexOf(q) > -1;
		},
		loadFilter: function(data){
			if (data!=null && data.errorCode>0){
				if(data.msg!=null && data.msg!=""){
					$$.showJcdfMessager('提示消息', data.msg, 'warning');
				}
			}
			return data.data;
		}
	});
}