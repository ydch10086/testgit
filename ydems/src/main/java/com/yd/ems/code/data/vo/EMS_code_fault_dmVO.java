package com.yd.ems.code.data.vo;


import com.yd.ems.code.data.po.EMS_code_fault_dmPO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_fault_dm - 故障类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_fault_dmVO {

	public Object[] getKeys(){
		return new Object[]{ 
			fau_type
		};
	}


    /** 
    * fau_type - 故障类型 
    */
    private int fau_type;
    /** 
    * fau_type_name - 故障类型描述 
    */
    private String fau_type_name;
    /** 
    * fau_status - 使用状态 
    */
    private String fau_status;

    public int getFau_type(){
        return this.fau_type;
    }
    public void setFau_type(int fau_type){
        this.fau_type = fau_type;
    }
    public String getFau_type_name(){
        return this.fau_type_name;
    }
    public void setFau_type_name(String fau_type_name){
        this.fau_type_name = fau_type_name;
    }
    public String getFau_status(){
        return this.fau_status;
    }
    public void setFau_status(String fau_status){
        this.fau_status = fau_status;
    }

	public EMS_code_fault_dmPO toPO(){
		EMS_code_fault_dmPO po = new EMS_code_fault_dmPO();
		
    	po.setFau_type(fau_type);
		po.setFau_type_name(fau_type_name);
		po.setFau_status(fau_status);
		
		return po;
	}
		
}