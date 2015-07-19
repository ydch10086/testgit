package com.yd.common.runtime;

public class CIPRuntimeOperator {
	private String subject_id;
	private String subject_name;
	private String subject_org;
	private String subject_org_type;
	private String operate_tm;  //操作时间精确到second
	private String operate_dt;  //操作日期精确到day
	private String subject_ip;
	
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_id() {
		return subject_id;
	}
	public String getOperate_tm() {
		return operate_tm;
	}
	public String getOperate_dt() {
		return operate_dt;
	}
	public String getSubject_ip() {
		return subject_ip;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public void setOperate_tm(String operate_tm) {
		this.operate_tm = operate_tm;
	}
	public void setOperate_dt(String operate_dt) {
		this.operate_dt = operate_dt;
	}
	public void setSubject_ip(String subject_ip) {
		this.subject_ip = subject_ip;
	}
	public String getSubject_org() {
		return subject_org;
	}
	public void setSubject_org(String subject_org) {
		this.subject_org = subject_org;
	}
	public String getSubject_org_type() {
		return subject_org_type;
	}
	public void setSubject_org_type(String subject_org_type) {
		this.subject_org_type = subject_org_type;
	}
}
