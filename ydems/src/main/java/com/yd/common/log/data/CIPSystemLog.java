package com.yd.common.log.data;

public class CIPSystemLog {
	public long occur_time; 	//key 记录时间
	public String sys_id;			//key 系统
	public int key_point;		//系统生命周期技术 关键点
	public int error_code;
	public String key_msg;
	@Override
	public String toString() {
		return "CIPSystemLog [occur_time=" + occur_time + ", sys_id=" + sys_id
				+ ", key_point=" + key_point + ", key_msg=" + key_msg + "]";
	}
	
	
	
}
