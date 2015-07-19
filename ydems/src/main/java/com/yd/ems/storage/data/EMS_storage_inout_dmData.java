package com.yd.ems.storage.data;

import java.math.BigDecimal;


/**
 * <p>Data实体类</p>
 * <p>View: em_storage_inout_dm - 出入库操作记录</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_inout_dmData {
	
	/**
	 * 出入库流水号
	 */
	private String inout_id;
	/**
	 * 操作类型
	 */
	private String inout_type;
	
    /** 
    * spare_id - 对象标识
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
     * 入库数量
     */
    private BigDecimal spare_in_store_num;
    /**
     * 出库数量
     */
    private BigDecimal spare_out_store_num;
    /**
     * 库存数量
     */
    private BigDecimal spare_store_num;
    /**
     * 单位
     */
    private int unit_code;
    
    private String unit_code_name;
    /** 
    * operator - 操作人
    */
    private int operator;
    /** 
     * op_time - 修改日期 
     */
     private String op_time;

    /** 
    * store_time - 入库时间
    */
    private String store_time;
    /**
     * 出库时间
     * @return
     */
    private String out_store_time;
    
    /**
     * 入库人工号
     */
    private int store_person_id;
    /**
     * 入库人姓名
     */
    private String store_person_name;
    /**
     * 入库类型
     */
    private int in_store_type;
    /**
     * 入库类型名称
     */
    private String in_store_type_name;
    public String getInout_id() {
		return inout_id;
	}

	public void setInout_id(String inout_id) {
		this.inout_id = inout_id;
	}

	public String getInout_type() {
		return inout_type;
	}

	public void setInout_type(String inout_type) {
		this.inout_type = inout_type;
	}

	public String getStore_time() {
		return store_time;
	}

	public void setStore_time(String store_time) {
		this.store_time = store_time;
	}

	public String getOut_store_time() {
		return out_store_time;
	}

	public void setOut_store_time(String out_store_time) {
		this.out_store_time = out_store_time;
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

	public String getSup_code() {
		return sup_code;
	}

	public void setSup_code(String sup_code) {
		this.sup_code = sup_code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getSpare_in_store_num() {
		return spare_in_store_num;
	}

	public void setSpare_in_store_num(BigDecimal spare_in_store_num) {
		this.spare_in_store_num = spare_in_store_num;
	}

	public BigDecimal getSpare_out_store_num() {
		return spare_out_store_num;
	}

	public void setSpare_out_store_num(BigDecimal spare_out_store_num) {
		this.spare_out_store_num = spare_out_store_num;
	}

	public BigDecimal getSpare_store_num() {
		return spare_store_num;
	}

	public void setSpare_store_num(BigDecimal spare_store_num) {
		this.spare_store_num = spare_store_num;
	}


	public String getOp_time() {
		return op_time;
	}

	public void setOp_time(String op_time) {
		this.op_time = op_time;
	}

	public String getIn_store_type_name() {
		return in_store_type_name;
	}

	public void setIn_store_type_name(String in_store_type_name) {
		this.in_store_type_name = in_store_type_name;
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public int getStore_person_id() {
		return store_person_id;
	}

	public void setStore_person_id(int store_person_id) {
		this.store_person_id = store_person_id;
	}

	public String getStore_person_name() {
		return store_person_name;
	}

	public void setStore_person_name(String store_person_name) {
		this.store_person_name = store_person_name;
	}

	public int getIn_store_type() {
		return in_store_type;
	}

	public void setIn_store_type(int in_store_type) {
		this.in_store_type = in_store_type;
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

	public String getSpare_type_name() {
		return spare_type_name;
	}

	public void setSpare_type_name(String spare_type_name) {
		this.spare_type_name = spare_type_name;
	}

	public String getSup_code_name() {
		return sup_code_name;
	}

	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}

	public String getOrg_id_name() {
		return org_id_name;
	}

	public void setOrg_id_name(String org_id_name) {
		this.org_id_name = org_id_name;
	}    

}