package com.yd.ems.code.data.vo;

import com.yd.ems.code.data.po.EMS_parameterPO;

public class EMS_parameterVO {
	
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
	private String remark;
	
	private int org_id;
    /*供应商名称*/
    private String sup_code;
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
	public int getOrg_id() {
		return org_id;
	}


	public void setOrg_id(int org_id) {
		this.org_id = org_id;
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

	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getSup_code() {
		return sup_code;
	}


	public void setSup_code(String sup_code) {
		this.sup_code = sup_code;
	}
	public int getEquip_status() {
		return equip_status;
	}


	public void setEquip_status(int equip_status) {
		this.equip_status = equip_status;
	}


	public EMS_parameterPO toPO(){
		EMS_parameterPO po = new EMS_parameterPO();
		po.setEquip_id(equip_id);
		po.setEquip_name(equip_name);
		po.setEquip_type(equip_type);
		po.setEquip_description(equip_description);
		po.setSup_code(sup_code);
	    po.setEquip_status(equip_status);
	    po.setOrg_id(org_id);
		return po;
	}
}
