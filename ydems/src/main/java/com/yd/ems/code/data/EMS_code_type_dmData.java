package com.yd.ems.code.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_code_type_dm - 对象类型</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_type_dmData {


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

    /** 
    * typ_status_name - 使用状态 中文
    */
    private String typ_status_name;


    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;


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
	public String getTyp_status_name() {
		return typ_status_name;
	}
	public void setTyp_status_name(String typ_status_name) {
		this.typ_status_name = typ_status_name;
	}

}