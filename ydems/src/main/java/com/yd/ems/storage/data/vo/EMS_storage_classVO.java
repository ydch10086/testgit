package com.yd.ems.storage.data.vo;

import java.math.BigDecimal;

import com.yd.ems.storage.data.po.EMS_storage_classPO;

/**
 * <p>实体类</p>
 * <p>Table: em_storage_class - 备品备件工具类</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_classVO {

	public Object[] getKeys(){
		return new Object[]{ 
			cla_id
		};
	}


    /** 
    * cla_id - 对象类标识 
    */
    private long cla_id;
    /** 
    * cla_type - 对象类类型 
    */
    private int cla_type;
    /** 
    * cla_sub_type - 对象类子类型 
    */
    private int cla_sub_type;
    /** 
    * cla_txt - 对象类名称 
    */
    private String cla_txt;
    /** 
    * cla_bel_type - 所属种类 
    */
    private int cla_bel_type;
    /** 
    * sup_code - 供应商 
    */
    private int sup_code;
    /** 
    * cla_bra - 所属品牌 
    */
    private String cla_bra;
    /** 
    * cla_orgeh - 管理组织 
    */
    private int cla_orgeh;
    /** 
    * cla_imp_amt - 入库数量 
    */
    private BigDecimal cla_imp_amt;
    /** 
    * cla_amt - 库存数量 
    */
    private BigDecimal cla_amt;
    /** 
    * cla_exp_amt - 出库数量 
    */
    private BigDecimal cla_exp_amt;
    /** 
    * cla_unit - 数量单位 
    */
    private int cla_unit;

    public long getCla_id(){
        return this.cla_id;
    }
    public void setCla_id(long cla_id){
        this.cla_id = cla_id;
    }
    public int getCla_type(){
        return this.cla_type;
    }
    public void setCla_type(int cla_type){
        this.cla_type = cla_type;
    }
    public int getCla_sub_type(){
        return this.cla_sub_type;
    }
    public void setCla_sub_type(int cla_sub_type){
        this.cla_sub_type = cla_sub_type;
    }
    public String getCla_txt(){
        return this.cla_txt;
    }
    public void setCla_txt(String cla_txt){
        this.cla_txt = cla_txt;
    }
    public int getCla_bel_type(){
        return this.cla_bel_type;
    }
    public void setCla_bel_type(int cla_bel_type){
        this.cla_bel_type = cla_bel_type;
    }
    public int getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(int sup_code){
        this.sup_code = sup_code;
    }
    public String getCla_bra(){
        return this.cla_bra;
    }
    public void setCla_bra(String cla_bra){
        this.cla_bra = cla_bra;
    }
    public int getCla_orgeh(){
        return this.cla_orgeh;
    }
    public void setCla_orgeh(int cla_orgeh){
        this.cla_orgeh = cla_orgeh;
    }
    public BigDecimal getCla_imp_amt(){
        return this.cla_imp_amt;
    }
    public void setCla_imp_amt(BigDecimal cla_imp_amt){
        this.cla_imp_amt = cla_imp_amt;
    }
    public BigDecimal getCla_amt(){
        return this.cla_amt;
    }
    public void setCla_amt(BigDecimal cla_amt){
        this.cla_amt = cla_amt;
    }
    public BigDecimal getCla_exp_amt(){
        return this.cla_exp_amt;
    }
    public void setCla_exp_amt(BigDecimal cla_exp_amt){
        this.cla_exp_amt = cla_exp_amt;
    }
    public int getCla_unit(){
        return this.cla_unit;
    }
    public void setCla_unit(int cla_unit){
        this.cla_unit = cla_unit;
    }

	public EMS_storage_classPO toPO(){
		EMS_storage_classPO po = new EMS_storage_classPO();
		
    	po.setCla_id(cla_id);
		po.setCla_type(cla_type);
		po.setCla_sub_type(cla_sub_type);
		po.setCla_txt(cla_txt);
		po.setCla_bel_type(cla_bel_type);
		po.setSup_code(sup_code);
		po.setCla_bra(cla_bra);
		po.setCla_orgeh(cla_orgeh);
		po.setCla_imp_amt(cla_imp_amt);
		po.setCla_amt(cla_amt);
		po.setCla_exp_amt(cla_exp_amt);
		po.setCla_unit(cla_unit);
		
		return po;
	}
		
}