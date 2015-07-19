package com.yd.ems.code.data.vo;


import com.yd.ems.code.data.po.EMS_code_unit_dmPO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_unit_dm - 单位</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_unit_dmVO {

	public Object[] getKeys(){
		return new Object[]{ 
			unit_code
		};
	}


    /** 
    * unit_code - 单位编码 
    */
    private int unit_code;
    /** 
    * unit_code_name - 单位编码描述 
    */
    private String unit_code_name;
    /** 
    * unit_status - 使用状态 
    */
    private String unit_status;

    public int getUnit_code(){
        return this.unit_code;
    }
    public void setUnit_code(int unit_code){
        this.unit_code = unit_code;
    }
    public String getUnit_code_name(){
        return this.unit_code_name;
    }
    public void setUnit_code_name(String unit_code_name){
        this.unit_code_name = unit_code_name;
    }
    public String getUnit_status(){
        return this.unit_status;
    }
    public void setUnit_status(String unit_status){
        this.unit_status = unit_status;
    }

	public EMS_code_unit_dmPO toPO(){
		EMS_code_unit_dmPO po = new EMS_code_unit_dmPO();
		
    	po.setUnit_code(unit_code);
		po.setUnit_code_name(unit_code_name);
		po.setUnit_status(unit_status);
		
		return po;
	}
		
}