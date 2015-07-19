package com.yd.common.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CIPRuntimeConfigure {

	//系统id
	public static String cip_system_id;
	public static String cip_system_type;
	public static boolean cip_is_cluster = false;
	
	//系统配置
	public static boolean cip_is_remote_conf = false;
	public static String cip_remote_conf_url;
	public static String cip_local_conf_file;
	
	
	//日志配置
	public static boolean cip_is_remote_log = false;
	public static String cip_log_url;
	
	//缓存配置
	public static boolean cip_is_remote_cache = true;
			

	//授权服务
	public static boolean cip_user_xremote = false;
	public static boolean cip_auth_xremote = true;
	public static String cip_auth_url;
	public static String cip_login_url;
	public static String cip_menu_url;
	public static long cip_auth_Id;// 权限注册码

	//文本信息服务
	public static boolean cip_text_xremote;
	public static String cip_text_remote_url;
	public static String cip_text_local_file;

	/** JNDI数据源名称*/
	public static String jndiName;  
	
	/** 数据库模式*/
	public static String dbSchema;
	

	
	/** 登录地址*/
	public static String loginURL;
	
	/** 获取菜单地址*/
	public static String menuURL;
	
	//应用个性化配置
	public static String loginPageURI = "login.html";
	public static String ErrorPageURI = "error.html";

	
	public static Map<String, String> additionalInfos = new HashMap<String, String>();
	
	public static String cip_default_lang;//系统默认语言
	
	//文件处理默认路径
	public static String cip_temp_file_path;
	public static String cip_actual_file_path;
	

	
}
