package com.yd.common.log.data;

//所有事务操作日志接入，断点可以恢复功能
public class CIPTransactionLog {
	public long occur_time; 	//key 记录时间
	public String sys_id;
	public int trans_id;		//key 事务代码
	public int step_id;			//事务步骤
	public int execute_status;	//执行状态：开始、正常结束、错误结束
	public String trans_msg; 	//事务信息
	@Override
	public String toString() {
		return "CIPTransactionLog [occur_time=" + occur_time + ", sys_id="
				+ sys_id + ", trans_id=" + trans_id + ", step_id=" + step_id
				+ ", execute_status=" + execute_status + ", trans_msg="
				+ trans_msg + "]";
	}

	
	
}
