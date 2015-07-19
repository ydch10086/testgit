package com.yd.common.function.auth.data;

public class CIPUserDataPO {
	private String sys_id;
	private String user_id;
	private String user_name;
	private String user_pwd;
	private int user_pwd_init; //初始密码标识：0：初始；1：设置
	private int pwd_reset_days; //重置密码天数
	private int pwd_reset_flag;
	private String org_id;		//挂靠机构：客户id；部门id；供应商id；加盟商id；事件id；
	private String position_id; //岗位id
	private String persion_id; //人员id
	private int user_status=0; //1:锁定；0：正常
	private int user_type=0; 
	//0:企业内部应用用户；
	//1：加盟用户；
	//2：供应商用户；
	//3：客户用户；
	//4：系统间通信用户；
	//5：定时任务用户；
	//6：系统运维管理用户；
	//7：临时用户
	private String start_date;
	private String end_date;
	private String user_pwd_his1;
	private String user_pwd_his2;
	private String user_pwd_his3;
	
	public String getSys_id() {
		return sys_id;
	}
	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public int getUser_pwd_init() {
		return user_pwd_init;
	}
	public void setUser_pwd_init(int user_pwd_init) {
		this.user_pwd_init = user_pwd_init;
	}

	public int getPwd_reset_days() {
		return pwd_reset_days;
	}
	public void setPwd_reset_days(int pwd_reset_days) {
		this.pwd_reset_days = pwd_reset_days;
	}
	public int getPwd_reset_flag() {
		return pwd_reset_flag;
	}
	public void setPwd_reset_flag(int pwd_reset_flag) {
		this.pwd_reset_flag = pwd_reset_flag;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String getPosition_id() {
		return position_id;
	}
	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}
	public String getPersion_id() {
		return persion_id;
	}
	public void setPersion_id(String persion_id) {
		this.persion_id = persion_id;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getUser_pwd_his1() {
		return user_pwd_his1;
	}
	public void setUser_pwd_his1(String user_pwd_his1) {
		this.user_pwd_his1 = user_pwd_his1;
	}
	public String getUser_pwd_his2() {
		return user_pwd_his2;
	}
	public void setUser_pwd_his2(String user_pwd_his2) {
		this.user_pwd_his2 = user_pwd_his2;
	}
	public String getUser_pwd_his3() {
		return user_pwd_his3;
	}
	public void setUser_pwd_his3(String user_pwd_his3) {
		this.user_pwd_his3 = user_pwd_his3;
	}
	
	
	
}
