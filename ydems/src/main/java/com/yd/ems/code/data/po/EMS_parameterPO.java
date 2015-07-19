package com.yd.ems.code.data.po;

import com.yd.ems.code.data.vo.EMS_parameterVO;

public class EMS_parameterPO {
	
	public Object[] getKeys(){
	return new Object[]{ 
			equip_id
		};
	}
	/*设备编码*/
	private String equip_id;
	/*设备名称*/
	private String equip_name;
	/*设备类型*/
	private int equip_type;
	/*设备描述*/
	private String equip_description;
	private int org_id;
	/*修改者*/
	private int operator;
	 /* op_time - 修改日期*/
	private String op_time;
	/*供应商名称*/
	private String sup_code;
	private String remark;
	/*设备状态*/
	private int equip_status;
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


	public String getEquip_description() {
		return equip_description;
	}


	public void setEquip_description(String equip_description) {
		this.equip_description = equip_description;
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


	public String getSup_code() {
		return sup_code;
	}


	public void setSup_code(String sup_code) {
		this.sup_code = sup_code;
	}


	public int getOrg_id() {
		return org_id;
	}


	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public int getEquip_status() {
		return equip_status;
	}


	public void setEquip_status(int equip_status) {
		this.equip_status = equip_status;
	}


	public EMS_parameterVO toVO(){
		EMS_parameterVO vo = new EMS_parameterVO();
		vo.setEquip_id(equip_id);
		vo.setEquip_name(equip_name);
		vo.setEquip_type(equip_type);
		vo.setEquip_description(equip_description);
        vo.setSup_code(sup_code);
        vo.setRemark(remark);
        vo.setEquip_status(equip_status);
        vo.setOrg_id(org_id);
		return vo;
	}
	
}
