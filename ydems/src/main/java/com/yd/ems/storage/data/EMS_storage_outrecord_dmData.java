package com.yd.ems.storage.data;

import java.math.BigDecimal;


/**
 * <p>Data实体类</p>
 * <p>View: em_storage_outrecord_dm - 出库操作记录</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_outrecord_dmData {
	
	/**
	 * 出库标示
	 */
	private String outrecord_id;
	/**
	 * 操作类型
	 */
	private String inout_type;
    /** 
    * spare_store_id - 对象标识
    */
    private String spare_store_id;

	/** 
    * spare_name -对象名称
    */
    private String spare_name;
    
    /**
     * 对象子类型
     * */
    private int spare_sub_type;
    
    /**
     * 对象子类型名称
     * */
    private String spare_sub_type_name;
    /**
     * 所属一级分类
     */
    private int spare_type;
    
    private String spare_type_name;
    /**
     * 供应商
     */
    private String sup_code;
    
    private String sup_code_name;
    
    /**
     * 品牌
     */
    private String brand;
    
    /**
     * 管理组织
     */
    private int org_id;
    
    private String org_id_name;
    /**
     * 出库数量
     */
    private BigDecimal spare_out_store_num;
 
    /**
     * 单位
     */
    private int unit_code;
    
    private String unit_code_name;

    /**
     * 出库时间
     * @return
     */
    private String out_store_time;
    
    /**
     * 出库人工号
     */
    private int out_store_person_id;
    /**
     * 出库人姓名
     */
    private String out_store_person_name;
    /**
     * 领用人工号
     */
    private int user_taken_id;
    /**
     * 领用人姓名
     */
    private String user_taken_name;
    /**
     * 领用时间
     */
    private String user_taken_time;
    /**
     * 领用类型
     */
    private int user_taken_type;
    /** 
     * operator - 操作人
     */
     private int operator;
     /** 
      * op_time - 修改日期 
      */
      private String op_time;
	public String getOutrecord_id() {
		return outrecord_id;
	}
	public void setOutrecord_id(String outrecord_id) {
		this.outrecord_id = outrecord_id;
	}
	public String getSpare_store_id() {
		return spare_store_id;
	}
	public void setSpare_store_id(String spare_store_id) {
		this.spare_store_id = spare_store_id;
	}
	public String getSpare_name() {
		return spare_name;
	}
	public void setSpare_name(String spare_name) {
		this.spare_name = spare_name;
	}
	public String getSpare_sub_type_name() {
		return spare_sub_type_name;
	}
	public void setSpare_sub_type_name(String spare_sub_type_name) {
		this.spare_sub_type_name = spare_sub_type_name;
	}
	public String getInout_type() {
		return inout_type;
	}
	public void setInout_type(String inout_type) {
		this.inout_type = inout_type;
	}
	public int getSpare_sub_type() {
		return spare_sub_type;
	}
	public void setSpare_sub_type(int spare_sub_type) {
		this.spare_sub_type = spare_sub_type;
	}
	public int getSpare_type() {
		return spare_type;
	}
	public void setSpare_type(int spare_type) {
		this.spare_type = spare_type;
	}
	public String getSpare_type_name() {
		return spare_type_name;
	}
	public void setSpare_type_name(String spare_type_name) {
		this.spare_type_name = spare_type_name;
	}
	public String getSup_code() {
		return sup_code;
	}
	public void setSup_code(String sup_code) {
		this.sup_code = sup_code;
	}
	public String getSup_code_name() {
		return sup_code_name;
	}
	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getOrg_id_name() {
		return org_id_name;
	}
	public void setOrg_id_name(String org_id_name) {
		this.org_id_name = org_id_name;
	}
	public BigDecimal getSpare_out_store_num() {
		return spare_out_store_num;
	}
	public void setSpare_out_store_num(BigDecimal spare_out_store_num) {
		this.spare_out_store_num = spare_out_store_num;
	}
	public int getUnit_code() {
		return unit_code;
	}
	public void setUnit_code(int unit_code) {
		this.unit_code = unit_code;
	}
	public String getUnit_code_name() {
		return unit_code_name;
	}
	public void setUnit_code_name(String unit_code_name) {
		this.unit_code_name = unit_code_name;
	}
	public String getOut_store_time() {
		return out_store_time;
	}
	public void setOut_store_time(String out_store_time) {
		this.out_store_time = out_store_time;
	}
	public int getOut_store_person_id() {
		return out_store_person_id;
	}
	public void setOut_store_person_id(int out_store_person_id) {
		this.out_store_person_id = out_store_person_id;
	}
	public String getOut_store_person_name() {
		return out_store_person_name;
	}
	public void setOut_store_person_name(String out_store_person_name) {
		this.out_store_person_name = out_store_person_name;
	}
	public int getUser_taken_id() {
		return user_taken_id;
	}
	public void setUser_taken_id(int user_taken_id) {
		this.user_taken_id = user_taken_id;
	}
	public String getUser_taken_name() {
		return user_taken_name;
	}
	public void setUser_taken_name(String user_taken_name) {
		this.user_taken_name = user_taken_name;
	}
	public String getUser_taken_time() {
		return user_taken_time;
	}
	public void setUser_taken_time(String user_taken_time) {
		this.user_taken_time = user_taken_time;
	}
	public int getUser_taken_type() {
		return user_taken_type;
	}
	public void setUser_taken_type(int user_taken_type) {
		this.user_taken_type = user_taken_type;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public String getOp_time() {
		return op_time;
	}
	public void setOp_time(String op_time) {
		this.op_time = op_time;
	}


}