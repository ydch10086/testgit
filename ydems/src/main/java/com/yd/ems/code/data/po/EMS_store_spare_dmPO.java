package com.yd.ems.code.data.po;


import java.math.BigDecimal;

import com.yd.ems.code.data.vo.EMS_store_spare_dmVO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_spare_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_store_spare_dmPO {

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
	    /** 
	    * operator - 修改者 
	    */
	    private int operator;

	    /** 
	    * op_time - 修改日期 
	    */
	    private String op_time;

		private int unit_code;
		
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


	public EMS_store_spare_dmVO toVO(){
		EMS_store_spare_dmVO vo = new EMS_store_spare_dmVO();
		vo.setSpare_store_id(spare_store_id);
		vo.setSpare_name(spare_name);
		vo.setSpare_sub_type(spare_sub_type);
		vo.setSpare_type(spare_type);
		vo.setBrand(brand);
		vo.setOrg_id(org_id);
		vo.setSup_code(sup_code);
		return vo;
	}
		
}