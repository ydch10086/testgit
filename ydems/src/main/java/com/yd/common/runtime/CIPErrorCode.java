package com.yd.common.runtime;

public class CIPErrorCode {
	public static final CIPErrorCode CALL_SUCCESS = new CIPErrorCode(0, "操作成功");
	public static final CIPErrorCode ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE = new CIPErrorCode(90001,"HTTP请求错误"); 
	public static final CIPErrorCode ERROR_REMOTE_SERVER_RETURN_ERROR = new CIPErrorCode(90002, "远程服务返回错误"); 
	public static final CIPErrorCode ERROR_RESOURCE_IS_NOT_READY = new CIPErrorCode(90003, "系统资源缺失"); 
	public static final CIPErrorCode ERROR_TECHNICAL_ERROR = new CIPErrorCode(99999, "技术处理失败"); 
	public static final CIPErrorCode ERROR_CONNECTION_TIMEOUT = new CIPErrorCode(99998, "连接超时"); 
	public static final CIPErrorCode ERROR_INVALID_AUTHORIZATION = new CIPErrorCode(99997, "无效的授权信息"); 
	public static final CIPErrorCode ERROR_NOT_SUPPORT_REMOTE_CALL = new CIPErrorCode(99996, "不支持远程系统调用"); 
	public static final CIPErrorCode ERROR_DATABASE_TECH_EXCEPTION = new CIPErrorCode(80001,"数据库操作异常"); 
	public static final CIPErrorCode ERROR_FUNCTION_NOT_SUPPORT = new CIPErrorCode(99995, "该功能点不支持");
	public static final CIPErrorCode ERROR_DUMPLICATE_PRIMARY_KEY = new CIPErrorCode(80002, "数据记录已经存在"); 
	public static final CIPErrorCode ERROR_RECORD_NOT_EXISTS = new CIPErrorCode(80003, "数据记录不存在");
	public static final CIPErrorCode ERROR_DATA_IS_MALFORM = new CIPErrorCode(80004, "数据格式不符合要求");
	public static final CIPErrorCode ERROR_ILLEGAL_ACCESS = new CIPErrorCode(80005, "非法用户访问");
	public static final CIPErrorCode ERROR_ILLEGAL_OPERATION = new CIPErrorCode(80006, "没有操作权限，请找管理员确认权限配置!");

	public int code;
	public String name;

	public CIPErrorCode(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName(int code) {
		
		return name;
	}
}
