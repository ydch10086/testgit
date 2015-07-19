package com.yd.common.auth;

//当前系统用户信息
public class CIPUserProfileData {
	public String sys_id;
	public String user_id;
	public String user_name;
	public String user_pwd;
	public int user_pwd_init; //初始密码标识：0：初始；1：设置
	public int pwd_reset_day; //重置密码天数
	public int pwd_reset_flag;
	public String org_id;		//挂靠机构：客户id；部门id；供应商id；加盟商id；事件id；
	public String position_id; //岗位id
	public String persion_id; //人员id
	public int user_status=0; //1:锁定；0：正常
	public int user_type=0; 
	//0:企业内部应用用户；
	//1：加盟用户；
	//2：供应商用户；
	//3：客户用户；
	//4：系统间通信用户；
	//5：定时任务用户；
	//6：系统运维管理用户；
	//7：临时用户
	public String start_date;
	public String end_date;
}
