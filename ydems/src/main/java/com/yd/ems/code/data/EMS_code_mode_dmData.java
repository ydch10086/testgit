package com.yd.ems.code.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_code_mode_dm - 设备型号类型</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_mode_dmData {


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
    
    /** 
     * mod_status - 使用状态 
     */
     private String mod_status_name;


    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;


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

    public String getMod_status_name() {
		return mod_status_name;
	}
	public void setMod_status_name(String mod_status_name) {
		this.mod_status_name = mod_status_name;
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