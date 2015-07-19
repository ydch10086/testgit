package com.yd.common.log.data;

//系统功能点执行跟踪日志，支持技术验证，及系统异常重现功能
public class CIPFunctionTraceLog {
	public long occur_time; 	//key 记录时间
	public String sys_id;			//key 系统
	public int func_id;			//功能点
	public int step_id;			//执行步骤
	public String step_msg;		//操作信息
	@Override
	public String toString() {
		return "CIPFunctionTraceLog [occur_time=" + occur_time + ", sys_id="
				+ sys_id + ", func_id=" + func_id + ", step_id=" + step_id
				+ ", step_msg=" + step_msg + "]";
	}
	
	
	
}
