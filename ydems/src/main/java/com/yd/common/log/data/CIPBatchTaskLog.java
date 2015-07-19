package com.yd.common.log.data;

//所有批量程序的日志接入，错误可用重跑功能 
public class CIPBatchTaskLog {
	public long occur_time; 	//key 记录时间
	public String sys_id;			//key 系统
	public int task_id;			//批量任务id
	public int step_id;			//执行步骤
	public String step_msg;		//步骤信息
	public int error_code;		// 0 成功；1：完成但是有异常；2：错误，不可继续；3，技术异常
	@Override
	public String toString() {
		return "CIPBatchTaskLog [occur_time=" + occur_time + ", sys_id="
				+ sys_id + ", task_id=" + task_id + ", step_id=" + step_id
				+ ", step_msg=" + step_msg + ", error_code=" + error_code + "]";
	}
	
	
	
}
