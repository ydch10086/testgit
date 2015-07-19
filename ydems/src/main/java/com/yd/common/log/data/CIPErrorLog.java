package com.yd.common.log.data;

//系统异常日志接入功能，用于系统异常技术诊断
public class CIPErrorLog {
	public long occur_time; 	//key 记录时间
	public String sys_id;			//key 系统
	public int func_id;			//功能点
	public int error_code;		//错误码
	public String error_msg;	//错误文本
	public int error_level;     //错误等级
	@Override
	public String toString() {
		return "CIPErrorLog [occur_time=" + occur_time + ", sys_id=" + sys_id
				+ ", func_id=" + func_id + ", error_code=" + error_code
				+ ", error_msg=" + error_msg + ", error_level=" + error_level
				+ "]";
	}
	
	
	
}
