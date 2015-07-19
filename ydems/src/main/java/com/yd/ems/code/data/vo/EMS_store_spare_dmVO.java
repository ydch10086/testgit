package com.yd.ems.code.data.vo;
import java.math.BigDecimal;

import com.yd.ems.code.data.po.EMS_store_spare_dmPO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_spare_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_store_spare_dmVO {

	public Object[] getKeys(){
		return new Object[]{ 
				spare_store_id
		};
	}


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

        private int unit_code;
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



	public EMS_store_spare_dmPO toPO(){
		EMS_store_spare_dmPO po = new EMS_store_spare_dmPO();
	    po.setSpare_store_id(spare_store_id);
	    po.setSpare_name(spare_name);
	    po.setSpare_sub_type(spare_sub_type);
	    po.setSpare_type(spare_type);
	    po.setSup_code(sup_code);
	    po.setBrand(brand);
	    po.setOrg_id(org_id);
	    po.setUnit_code(unit_code);
		return po;
	}
		
}