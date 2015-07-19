package com.yd.ems.code.data;
/**
 * <p>Data实体类</p>
 * <p>View: EMS_parameter - 对象类型</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_parameterData {
	
	/*设备编码*/
	private String equip_id;
	/*设备名称*/
	private String equip_name;
	/*设备类型*/
	private int equip_type;
	/*设备类型*/
	private String equip_type_name;
	/*设备描述*/
	private String equip_description;
	/*供应商编号*/
	private String sup_code;
	//供应商名称
	private String sup_code_name;
	/*供应商编号*/
	private int org_id;
	//供应商名称
	private String org_id_name;
	/*修改者*/
	private int operator;
	/** 
	    * op_time - 修改日期 
	    */
	private String op_time;
	/*设备状态*/
	private int equip_status;
	/*设备状态名称*/
	private String equip_status_name;
	public String getEquip_id() {
		return equip_id;
	}
	public void setEquip_id(String equip_id) {
		this.equip_id = equip_id;
	}
	public String getEquip_name() {
		return equip_name;
	}
	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}
	public int getEquip_type() {
		return equip_type;
	}
	public void setEquip_type(int equip_type) {
		this.equip_type = equip_type;
	}
	public String getEquip_type_name() {
		return equip_type_name;
	}
	public void setEquip_type_name(String equip_type_name) {
		this.equip_type_name = equip_type_name;
	}
	public String getEquip_description() {
		return equip_description;
	}
	public void setEquip_description(String equip_description) {
		this.equip_description = equip_description;
	}
	public String getSup_code() {
		return sup_code;
	}
	public void setSup_code(String sup_code) {
		this.sup_code = sup_code;
	}
	public String getSup_code_name() {
		return sup_code_name;
	}
	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public String getOp_time() {
		return op_time;
	}
	public void setOp_time(String op_time) {
		this.op_time = op_time;
	}
	public int getEquip_status() {
		return equip_status;
	}
	public void setEquip_status(int equip_status) {
		this.equip_status = equip_status;
	}
	public String getEquip_status_name() {
		return equip_status_name;
	}
	public void setEquip_status_name(String equip_status_name) {
		this.equip_status_name = equip_status_name;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getOrg_id_name() {
		return org_id_name;
	}
	public void setOrg_id_name(String org_id_name) {
		this.org_id_name = org_id_name;
	}
}
