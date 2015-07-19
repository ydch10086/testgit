package com.yd.common.log.data;

//基础数据维护日志，支持数据变动恢复功能
public class CIPBaseDataOperateLog {
	public long occur_time; 	//key 记录时间
	public String sys_id;			//key 系统
	public String table_id;		//表名
	public String ref_id;		//记录id
	public String old_values;	//变更前值
	public String new_values;	//变更后值
	public String user_id;
	public int operate_type;	//增删改类型
	
	@Override
	public String toString() {
		return "CIPBaseDataOperateLog [occur_time=" + occur_time + ", sys_id="
				+ sys_id + ", table_id=" + table_id + ", ref_id=" + ref_id
				+ ", old_values=" + old_values + ", new_values=" + new_values
				+ ", user_id=" + user_id + ", operate_type=" + operate_type
				+ "]";
	}
	
	
}
