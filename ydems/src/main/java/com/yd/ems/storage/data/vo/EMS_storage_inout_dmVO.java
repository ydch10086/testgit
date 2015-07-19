package com.yd.ems.storage.data.vo;
import java.math.BigDecimal;

import com.yd.ems.storage.data.po.EMS_storage_inout_dmPO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_spare_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_inout_dmVO {

	public Object[] getKeys(){
		return new Object[]{ 
				inout_id
		};
	}
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
	     * 出库数量
	     */
	    private BigDecimal spare_out_store_num;
	    /**
         * 入库时间
         */
	    private String store_time;
	    /**
	     * 出库时间
	     */
	    private String out_store_time;
	    /**
	     * 单位
	     */
	    private int unit_code;
	    
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



		public String getSpare_store_id() {
			return spare_store_id;
		}



		public void setSpare_store_id(String spare_store_id) {
			this.spare_store_id = spare_store_id;
		}
		public int getUnit_code() {
				return unit_code;
			}



		public void setUnit_code(int unit_code) {
			this.unit_code = unit_code;
		}



	public String getStore_time() {
			return store_time;
		}



		public void setStore_time(String store_time) {
			this.store_time = store_time;
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



		public String getOut_store_time() {
			return out_store_time;
		}



		public void setOut_store_time(String out_store_time) {
			this.out_store_time = out_store_time;
		}



	public EMS_storage_inout_dmPO toPO(){
		EMS_storage_inout_dmPO po = new EMS_storage_inout_dmPO();
		po.setInout_id(inout_id);
		po.setInout_type(inout_type);
	    po.setSpare_store_id(spare_store_id);
	    po.setSpare_name(spare_name);
	    po.setSpare_sub_type(spare_sub_type);
	    po.setBrand(brand);
	    po.setSup_code(sup_code);
	    po.setSpare_type(spare_type);
	    po.setSpare_sub_type(spare_sub_type);
	    po.setOrg_id(org_id);
	    po.setSpare_in_store_num(spare_in_store_num);
	    po.setSpare_out_store_num(spare_out_store_num);
	    po.setUnit_code(unit_code);
	    po.setStore_time(store_time);
	    po.setOut_store_time(out_store_time);
	    po.setStore_person_id(store_person_id);
	    po.setStore_person_name(store_person_name);
	    po.setIn_store_type(in_store_type);
		return po;
	}
		
}