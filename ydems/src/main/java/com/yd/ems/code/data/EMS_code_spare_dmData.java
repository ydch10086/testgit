package com.yd.ems.code.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_code_spare_dm - 单位</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_spare_dmData {
	
    /** 
    * spare_id - 对象标识
    */
    private long spare_id;

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
     * 所属一级分类标示
     */
    private int spare_type;
    
    /**
     * 一级分类名称
     */
    private String spare_type_name;

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

	public long getSpare_id() {
		return spare_id;
	}

	public void setSpare_id(long spare_id) {
		this.spare_id = spare_id;
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

	public String getOp_time() {
		return op_time;
	}

	public void setOp_time(String op_time) {
		this.op_time = op_time;
	}

	public String getSpare_sub_type_name() {
		return spare_sub_type_name;
	}

	public void setSpare_sub_type_name(String spare_sub_type_name) {
		this.spare_sub_type_name = spare_sub_type_name;
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