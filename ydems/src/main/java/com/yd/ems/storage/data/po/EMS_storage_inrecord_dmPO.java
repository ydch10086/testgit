package com.yd.ems.storage.data.po;


import java.math.BigDecimal;

import com.yd.ems.storage.data.vo.EMS_storage_inrecord_dmVO;


/**
 * <p>实体类</p>
 * <p>Table: em_storage_inrecord_dm - 入庫記錄</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_inrecord_dmPO {

	public Object[] getKeys(){
		return new Object[]{ 
				inrecord_id
		};
	}
	/**
	 * 入库标示
	 */
	private String inrecord_id;
	/**
	 * 操作类型
	 */
	private String inout_type;
    /** 
    * spare_store_id - 对象标识
    */
    private String spare_store_id;
    /**
     * 入库时间
     * @return
     */
    private String in_store_time;
    
    /**
     * 入库人工号
     */
    private int store_person_id;
    /**
     * 入库人姓名
     */
    private String store_person_name;

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
    /**
     * 供应商
     */
    private String sup_code;    
    /**
     * 品牌
     */
    private String brand;
    
    /**
     * 管理组织
     */
    private int org_id;
    /**
     * 入库数量
     */
    private BigDecimal spare_in_store_num;
    /**
     * 入库类型
     */
    private String in_store_type;
    /**
     * 单位
     */
    private int unit_code;
    /** 
     * operator - 修改者
     */
     private int operator;

     /** 
     * op_time - 修改日期
     */
     private String op_time;
	public String getInrecord_id() {
		return inrecord_id;
	}
	public void setInrecord_id(String inrecord_id) {
		this.inrecord_id = inrecord_id;
	}
	public String getInout_type() {
		return inout_type;
	}
	public void setInout_type(String inout_type) {
		this.inout_type = inout_type;
	}
	public String getSpare_store_id() {
		return spare_store_id;
	}
	public void setSpare_store_id(String spare_store_id) {
		this.spare_store_id = spare_store_id;
	}
	public String getIn_store_time() {
		return in_store_time;
	}
	public void setIn_store_time(String in_store_time) {
		this.in_store_time = in_store_time;
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
	public String getSpare_sub_type_name() {
		return spare_sub_type_name;
	}
	public void setSpare_sub_type_name(String spare_sub_type_name) {
		this.spare_sub_type_name = spare_sub_type_name;
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
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public BigDecimal getSpare_in_store_num() {
		return spare_in_store_num;
	}
	public void setSpare_in_store_num(BigDecimal spare_in_store_num) {
		this.spare_in_store_num = spare_in_store_num;
	}
	public String getIn_store_type() {
		return in_store_type;
	}
	public void setIn_store_type(String in_store_type) {
		this.in_store_type = in_store_type;
	}
	public int getUnit_code() {
		return unit_code;
	}
	public void setUnit_code(int unit_code) {
		this.unit_code = unit_code;
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
	public EMS_storage_inrecord_dmVO toVO(){
		EMS_storage_inrecord_dmVO vo = new EMS_storage_inrecord_dmVO();
		
		return vo;
	}
		
}