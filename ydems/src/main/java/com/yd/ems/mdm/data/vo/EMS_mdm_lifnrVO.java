package com.yd.ems.mdm.data.vo;


import com.yd.ems.mdm.data.po.EMS_mdm_lifnrPO;

/**
 * <p>实体类</p>
 * <p>Table: em_mdm_lifnr - 供应商基础信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_lifnrVO {

	public Object[] getKeys(){
		return new Object[]{ 
			sup_code
		};
	}


    /** 
    * sup_code - 供应商编码 
    */
    private String sup_code;
    /** 
    * sup_code_name - 供应商名称 
    */
    private String sup_code_name;
    /** 
    * sup_status - 使用状态 
    */
    private String sup_status;
    /** 
    * sup_adress - 联系地址 
    */
    private String sup_adress;
    /** 
    * sup_contact - 联系电话 
    */
    private int sup_contact;

    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }
    public String getSup_code_name(){
        return this.sup_code_name;
    }
    public void setSup_code_name(String sup_code_name){
        this.sup_code_name = sup_code_name;
    }
    public String getSup_status(){
        return this.sup_status;
    }
    public void setSup_status(String sup_status){
        this.sup_status = sup_status;
    }
    public String getSup_adress(){
        return this.sup_adress;
    }
    public void setSup_adress(String sup_adress){
        this.sup_adress = sup_adress;
    }
    public int getSup_contact(){
        return this.sup_contact;
    }
    public void setSup_contact(int sup_contact){
        this.sup_contact = sup_contact;
    }

	public EMS_mdm_lifnrPO toPO(){
		EMS_mdm_lifnrPO po = new EMS_mdm_lifnrPO();
		
    	po.setSup_code(sup_code);
		po.setSup_code_name(sup_code_name);
		po.setSup_status(sup_status);
		po.setSup_adress(sup_adress);
		po.setSup_contact(sup_contact);
		
		return po;
	}
		
}