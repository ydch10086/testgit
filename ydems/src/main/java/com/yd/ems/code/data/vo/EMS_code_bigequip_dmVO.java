package com.yd.ems.code.data.vo;


import com.yd.ems.code.data.po.EMS_code_bigequip_dmPO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_type_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_bigequip_dmVO {

	public Object[] getKeys(){
		return new Object[]{ 
				bigequip_id
		};
	}


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
	     * 所属一级分类
	     */
	    private int bigequip_type;

	    /**
	     * 供应商
	     */
	    private String sup_code;
	    
	    /**
	     * 品牌
	     */
	    private String brand;
	    
        private int org_id;
  

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




	public EMS_code_bigequip_dmPO toPO(){
		EMS_code_bigequip_dmPO po = new EMS_code_bigequip_dmPO();
		po.setBigequip_id(bigequip_id);
		po.setBigequip_name(bigequip_name);
		po.setBigequip_sub_type(bigequip_sub_type);
		po.setBigequip_type(bigequip_type);
		po.setBrand(brand);
		po.setOrg_id(org_id);
		po.setSup_code(sup_code);
		return po;
	}
		
}