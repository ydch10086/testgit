package com.yd.ems.code.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_mode_dm - 设备型号类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_mode_dmKey {	
	
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
    * mod_type - 故障类型 
    */
    private int equip_id;

	/*private String remark;
	
	private String operateCode;
	*/
    public int getMod_type(){
        return this.equip_id;
    }
}