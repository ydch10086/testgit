package com.yd.common.function.auth.data;

public class CIPLoginData {
	public String user_id; //用户id
	public String user_pwd; //密码
	public String pass_code; //验证码
	public String local_pass_code; //session中pass code
	@Override
	public String toString() {
		return "CIPLoginData [user_id=" + user_id + ", user_pwd=" + user_pwd
				+ ", pass_code=" + pass_code + ", local_pass_code="
				+ local_pass_code + "]";
	}
	
	
	
}
