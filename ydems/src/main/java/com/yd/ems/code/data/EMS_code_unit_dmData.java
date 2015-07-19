package com.yd.ems.code.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_code_unit_dm - 单位</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_unit_dmData {


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

    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;


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