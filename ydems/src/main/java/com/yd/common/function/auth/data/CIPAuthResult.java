package com.yd.common.function.auth.data;


public enum CIPAuthResult {
	SUCCESS(0, "操作成功"),
	LOGIN_SUCCESS(0, "登录成功"),
	USER_LOCKED(2,"用户被锁定"),
	USER_IS_NULL(1, "用户不能为空"),
	PASS_CODE_ERROR(3,"验证码不匹配"),
	LOGOUT_SUCCESS(0, "登出成功"),
	LOGIN_FAIL(9,"登录系统失败，非法用户"),
	LOGOUT_FAIL(8,"登出系统失败"),
	PASSWORD_RESET(21,"初始密码，需重置"),
	PASSWORD_IS_NULL(22,"密码为空或不合规"),
	PASSWORD_IS_USED(23,"密码在过去三次已经被使用"),
	PASSWORD_ERROR(24,"密码错误"),
	PASSWORD_NOT_MATCHED_4_RESET_PASSWORD(27,"密码重置：新旧密码不一致");
	
	public final int code;
	public final String name;
	private CIPAuthResult(int code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static String getName(int code){
		for (CIPAuthResult d : CIPAuthResult.values()) {  
            if (d.code == code) {  
                return d.name;  
            }  
        }  
        return null; 
	}
}
