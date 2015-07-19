package com.yd.ems.code.data.po;


import com.yd.ems.code.data.vo.EMS_code_bigequip_dmVO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_bigequip_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_bigequip_dmPO {

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
	    
	    /**
	     * 管理组织
	     */
	    private int org_id;
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



	public EMS_code_bigequip_dmVO toVO(){
		EMS_code_bigequip_dmVO vo = new EMS_code_bigequip_dmVO();
	    vo.setBigequip_id(bigequip_id);
		vo.setBigequip_name(bigequip_name);
		vo.setBigequip_sub_type(bigequip_sub_type);
		vo.setBigequip_type(bigequip_type);
		vo.setBrand(brand);
		vo.setOrg_id(org_id);
		vo.setSup_code(sup_code);
		return vo;
	}
		
}