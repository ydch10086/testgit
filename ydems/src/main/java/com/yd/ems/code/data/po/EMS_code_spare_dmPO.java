package com.yd.ems.code.data.po;


import com.yd.ems.code.data.vo.EMS_code_spare_dmVO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_spare_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_spare_dmPO {

	public Object[] getKeys(){
		return new Object[]{ 
				spare_id
		};
	}

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


	public EMS_code_spare_dmVO toVO(){
		EMS_code_spare_dmVO vo = new EMS_code_spare_dmVO();
		vo.setSpare_id(spare_id);
		vo.setSpare_name(spare_name);
		vo.setSpare_sub_type(spare_sub_type);
		vo.setSpare_type(spare_type);
		vo.setBrand(brand);
		vo.setOrg_id(org_id);
		vo.setSup_code(sup_code);
		return vo;
	}
		
}