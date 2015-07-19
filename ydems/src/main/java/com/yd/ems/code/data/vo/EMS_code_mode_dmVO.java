package com.yd.ems.code.data.vo;


import com.yd.ems.code.data.po.EMS_code_mode_dmPO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_mode_dm - 设备型号类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_mode_dmVO {

	public Object[] getKeys(){
		return new Object[]{ 
			mod_type
		};
	}


    /** 
    * mod_type - 故障类型 
    */
    private int mod_type;
    /** 
    * mod_type_name - 故障类型描述 
    */
    private String mod_type_name;
    /** 
    * mod_status - 使用状态 
    */
    private String mod_status;

    public int getMod_type(){
        return this.mod_type;
    }
    public void setMod_type(int mod_type){
        this.mod_type = mod_type;
    }
    public String getMod_type_name(){
        return this.mod_type_name;
    }
    public void setMod_type_name(String mod_type_name){
        this.mod_type_name = mod_type_name;
    }
    public String getMod_status(){
        return this.mod_status;
    }
    public void setMod_status(String mod_status){
        this.mod_status = mod_status;
    }

	public EMS_code_mode_dmPO toPO(){
		EMS_code_mode_dmPO po = new EMS_code_mode_dmPO();
		
    	po.setMod_type(mod_type);
		po.setMod_type_name(mod_type_name);
		po.setMod_status(mod_status);
		
		return po;
	}
		
}