package com.yd.common.function.domain.data;

public class CIPDomainMetaData {
	private String 	domain_id;
	private String 	domain_name;
	private int 	domain_type;
	private int 	is_null_flag;
	private int 	data_length;
	private String 	default_value;
	private int 	float_length;
	private String 	data_type;
	private String 	create_time;
	private String 	update_time;
	private String 	operator;
	private String 	resp_id;
	private String 	domain_desc;
	private String 	ref_table_id;
	
	
	
	@Override
	public String toString() {
		return "CIPDomainMetaData [domain_id=" + domain_id + ", domain_name="
				+ domain_name + ", domain_type=" + domain_type
				+ ", is_null_flag=" + is_null_flag + ", data_length="
				+ data_length + ", default_value=" + default_value
				+ ", float_length=" + float_length + ", data_type=" + data_type
				+ ", create_time=" + create_time + ", update_time="
				+ update_time + ", operator=" + operator + ", resp_id="
				+ resp_id + ", domain_desc=" + domain_desc + ", ref_table_id="
				+ ref_table_id + "]";
	}
	public String getDomain_id() {
		return domain_id;
	}
	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}
	public String getDomain_name() {
		return domain_name;
	}
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	public int getDomain_type() {
		return domain_type;
	}
	public void setDomain_type(int domain_type) {
		this.domain_type = domain_type;
	}
	public int getIs_null_flag() {
		return is_null_flag;
	}
	public void setIs_null_flag(int is_null_flag) {
		this.is_null_flag = is_null_flag;
	}
	public int getData_length() {
		return data_length;
	}
	public void setData_length(int data_length) {
		this.data_length = data_length;
	}
	public String getDefault_value() {
		return default_value;
	}
	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}
	public int getFloat_length() {
		return float_length;
	}
	public void setFloat_length(int float_length) {
		this.float_length = float_length;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getResp_id() {
		return resp_id;
	}
	public void setResp_id(String resp_id) {
		this.resp_id = resp_id;
	}
	public String getDomain_desc() {
		return domain_desc;
	}
	public void setDomain_desc(String domain_desc) {
		this.domain_desc = domain_desc;
	}
	public String getRef_table_id() {
		return ref_table_id;
	}
	public void setRef_table_id(String ref_table_id) {
		this.ref_table_id = ref_table_id;
	}
	

}
