package com.yd.ems.storage.data;

import java.math.BigDecimal;


/**
 * <p>Data实体类</p>
 * <p>View: em_code_spare_dm - 单位</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_spare_dmData {
	
    /** 
    * spare_id - 对象标识
    */
    private String spare_store_id;

    public String getSpare_store_id() {
		return spare_store_id;
	}

	public void setSpare_store_id(String spare_store_id) {
		this.spare_store_id = spare_store_id;
	}

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
     * 入库数量
     */
    private BigDecimal spare_in_store_num;
    /**
     * 入库时间
     */
    private String spare_in_store_date;
    /**
     * 出库数量
     */
    private BigDecimal spare_out_store_num;
   /**
    * 出库时间
    */
    private String spare_out_store_date;
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
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;

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

	public String getSpare_sub_type_name() {
		return spare_sub_type_name;
	}

	public void setSpare_sub_type_name(String spare_sub_type_name) {
		this.spare_sub_type_name = spare_sub_type_name;
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


	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public String getSup_code_name() {
		return sup_code_name;
	}

	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
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

	public String getSpare_in_store_date() {
		return spare_in_store_date;
	}

	public void setSpare_in_store_date(String spare_in_store_date) {
		this.spare_in_store_date = spare_in_store_date;
	}

	public String getSpare_out_store_date() {
		return spare_out_store_date;
	}

	public void setSpare_out_store_date(String spare_out_store_date) {
		this.spare_out_store_date = spare_out_store_date;
	}

	public String getOrg_id_name() {
		return org_id_name;
	}

	public void setOrg_id_name(String org_id_name) {
		this.org_id_name = org_id_name;
	}    

}