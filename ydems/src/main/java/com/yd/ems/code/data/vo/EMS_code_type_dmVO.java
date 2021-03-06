package com.yd.ems.code.data.vo;


import com.yd.ems.code.data.po.EMS_code_type_dmPO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_type_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_type_dmVO {

	public Object[] getKeys(){
		return new Object[]{ 
			typ_type
		};
	}


    /** 
    * typ_type - 对象类型编码 
    */
    private int typ_type;
    /** 
    * typ_type_name - 对象类型描述 
    */
    private String typ_type_name;
    /** 
    * typ_status - 使用状态 
    */
    private String typ_status;

    public int getTyp_type(){
        return this.typ_type;
    }
    public void setTyp_type(int typ_type){
        this.typ_type = typ_type;
    }
    public String getTyp_type_name(){
        return this.typ_type_name;
    }
    public void setTyp_type_name(String typ_type_name){
        this.typ_type_name = typ_type_name;
    }
    public String getTyp_status(){
        return this.typ_status;
    }
    public void setTyp_status(String typ_status){
        this.typ_status = typ_status;
    }

	public EMS_code_type_dmPO toPO(){
		EMS_code_type_dmPO po = new EMS_code_type_dmPO();
		
    	po.setTyp_type(typ_type);
		po.setTyp_type_name(typ_type_name);
		po.setTyp_status(typ_status);
		
		return po;
	}
		
}