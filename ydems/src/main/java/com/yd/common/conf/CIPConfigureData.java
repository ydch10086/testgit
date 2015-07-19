package com.yd.common.conf;

public class CIPConfigureData {

	private String sys_id;
	private String conf_id;
	private String conf_value;
	private String conf_txt;
	private int create_date;
	private int update_date;


	public String getConf_txt() {
		return conf_txt;
	}



	public String getSys_id() {
		return sys_id;
	}



	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}



	public void setConf_txt(String conf_txt) {
		this.conf_txt = conf_txt;
	}
	
	public String getConf_id() {
		return conf_id;
	}
	public void setConf_id(String conf_id) {
		this.conf_id = conf_id;
	}
	public String getConf_value() {
		return conf_value;
	}
	public void setConf_value(String conf_value) {
		this.conf_value = conf_value;
	}
	public int getCreate_date() {
		return create_date;
	}
	public void setCreate_date(int create_date) {
		this.create_date = create_date;
	}
	public int getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(int update_date) {
		this.update_date = update_date;
	}
	@Override
	public String toString() {
		return "CIPConfigureData [sys_id=" + sys_id + ", conf_id=" + conf_id
				+ ", conf_value=" + conf_value + ", conf_txt=" + conf_txt
				+ ", create_date=" + create_date + ", update_date="
				+ update_date + "]";
	}
	
	
	
}
