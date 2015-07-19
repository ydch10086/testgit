package com.yd.ems.mdm.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_mdm_lifnr - 供应商基础信息</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_lifnrData {


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

    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;
    
    private String sup_status_name;
    
    


    public String getSup_status_name() {
		return sup_status_name;
	}
	public void setSup_status_name(String sup_status_name) {
		this.sup_status_name = sup_status_name;
	}
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

    public int getOperator(){
        return this.operator;
    }
    public void setOperator(int operator){
        this.operator = operator;
    }

    public String getOp_time(){
        return this.op_time;
    }
    public void setOp_time(String op_time){
        this.op_time = op_time;
    }

}