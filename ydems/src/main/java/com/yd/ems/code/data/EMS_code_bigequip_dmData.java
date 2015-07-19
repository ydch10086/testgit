package com.yd.ems.code.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_code_bigequip_dm - 单位</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_bigequip_dmData {
	
    /** 
    * bigequip_id - 对象标识
    */
    private String bigequip_id;

    /** 
    * bigequip_name -对象名称
    */
    private String bigequip_name;
    
    /**
     * 对象子类型
     * */
    private int bigequip_sub_type;
    /**
     * 对象子类型名称
     * */
    private String bigequip_sub_type_name;
    /**
     * 所属一级分类
     */
    private int bigequip_type;
    
    /**
     * 一级分类名称
     */
    private String bigequip_type_name;
    /**
     * 供应商
     */
    private String sup_code;
    
    /**
     * 供应商名称
     */
    private String sup_code_name;
    
    /**
     * 品牌
     */
    private String brand;
    
    /**
     * 管理组织
     */
    private int org_id;
    /**
     * 管理组织名称
     */
    private String org_id_name;
    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;

	public String getBigequip_id() {
		return bigequip_id;
	}

	public void setBigequip_id(String bigequip_id) {
		this.bigequip_id = bigequip_id;
	}

	public String getBigequip_name() {
		return bigequip_name;
	}

	public void setBigequip_name(String bigequip_name) {
		this.bigequip_name = bigequip_name;
	}

	public int getBigequip_sub_type() {
		return bigequip_sub_type;
	}

	public void setBigequip_sub_type(int bigequip_sub_type) {
		this.bigequip_sub_type = bigequip_sub_type;
	}

	public int getBigequip_type() {
		return bigequip_type;
	}

	public void setBigequip_type(int bigequip_type) {
		this.bigequip_type = bigequip_type;
	}

	public String getBigequip_type_name() {
		return bigequip_type_name;
	}

	public void setBigequip_type_name(String bigequip_type_name) {
		this.bigequip_type_name = bigequip_type_name;
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

	public String getBigequip_sub_type_name() {
		return bigequip_sub_type_name;
	}

	public void setBigequip_sub_type_name(String bigequip_sub_type_name) {
		this.bigequip_sub_type_name = bigequip_sub_type_name;
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