package com.yd.common.log.data;

//系统功能访问日志，支持审计功能
public class CIPAccessAuditLog {
	public long occur_time; 	//key 记录时间
	public String sys_id;			//key 系统
	public int func_id;			//功能点
	public String user_id; 		
	public String ip;
	@Override
	public String toString() {
		return "CIPAccessAuditLog [occur_time=" + occur_time + ", sys_id="
				+ sys_id + ", func_id=" + func_id + ", user_id=" + user_id
				+ ", ip=" + ip + "]";
	}
	
	
}
