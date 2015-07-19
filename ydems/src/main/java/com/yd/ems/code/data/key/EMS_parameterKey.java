package com.yd.ems.code.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_mode_dm - 设备型号类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_parameterKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			equip_id
		};
	}
	
	public Object[] setKeys(int mod_type){
		return new Object[]{ 
				equip_id
		};
	}
	



    /** 
    * mod_type - 设备编号
    */
    private int equip_id;

	private String remark;
	
	private String operateCode;
	
    public int getMod_type(){
        return this.equip_id;
    }
    
    public void setMod_type(int equip_id){
        this.equip_id = equip_id;
    }

	public void setOperateCode(String operateCode){
		this.operateCode = operateCode;
	}
	
	public String getOperateCode(){
		return operateCode;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}
		
}