package com.yd.ems.storage.data.vo;

import java.math.BigDecimal;

import com.yd.ems.storage.data.po.EMS_storage_op_docPO;

/**
 * <p>实体类</p>
 * <p>Table: em_storage_op_doc - 物料操作凭证</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_op_docVO {

	public Object[] getKeys(){
		return new Object[]{ 
			doc_no
		};
	}


    /** 
    * doc_no - 操作凭证流水 
    */
    private long doc_no;
    /** 
    * cla_id - 对象类标识 
    */
    private long cla_id;
    /** 
    * doc_year - 年度 
    */
    private String doc_year;
    /** 
    * doc_month - 月度 
    */
    private String doc_month;
    /** 
    * doc_op_type - 出入标识 
    */
    private String doc_op_type;
    /** 
    * op_type - 操作类型 
    */
    private String op_type;
    /** 
    * doc_op_amt - 操作数量 
    */
    private BigDecimal doc_op_amt;
    /** 
    * doc_unit - 数量单位 
    */
    private String doc_unit;
    /** 
    * op_emp - 入库出库人 
    */
    private int op_emp;
    /** 
    * op_date - 入库出库日期 
    */
    private String op_date;
    /** 
    * use_emp - 领用人 
    */
    private int use_emp;
    /** 
    * use_time - 领用时间 
    */
    private String use_time;
    /** 
    * use_org - 领用机构 
    */
    private int use_org;
    /** 
    * op_org - 出入库机构 
    */
    private int op_org;

    public long getDoc_no(){
        return this.doc_no;
    }
    public void setDoc_no(long doc_no){
        this.doc_no = doc_no;
    }
    public long getCla_id(){
        return this.cla_id;
    }
    public void setCla_id(long cla_id){
        this.cla_id = cla_id;
    }
    public String getDoc_year(){
        return this.doc_year;
    }
    public void setDoc_year(String doc_year){
        this.doc_year = doc_year;
    }
    public String getDoc_month(){
        return this.doc_month;
    }
    public void setDoc_month(String doc_month){
        this.doc_month = doc_month;
    }
    public String getDoc_op_type(){
        return this.doc_op_type;
    }
    public void setDoc_op_type(String doc_op_type){
        this.doc_op_type = doc_op_type;
    }
    public String getOp_type(){
        return this.op_type;
    }
    public void setOp_type(String op_type){
        this.op_type = op_type;
    }
    public BigDecimal getDoc_op_amt(){
        return this.doc_op_amt;
    }
    public void setDoc_op_amt(BigDecimal doc_op_amt){
        this.doc_op_amt = doc_op_amt;
    }
    public String getDoc_unit(){
        return this.doc_unit;
    }
    public void setDoc_unit(String doc_unit){
        this.doc_unit = doc_unit;
    }
    public int getOp_emp(){
        return this.op_emp;
    }
    public void setOp_emp(int op_emp){
        this.op_emp = op_emp;
    }
    public String getOp_date(){
        return this.op_date;
    }
    public void setOp_date(String op_date){
        this.op_date = op_date;
    }
    public int getUse_emp(){
        return this.use_emp;
    }
    public void setUse_emp(int use_emp){
        this.use_emp = use_emp;
    }
    public String getUse_time(){
        return this.use_time;
    }
    public void setUse_time(String use_time){
        this.use_time = use_time;
    }
    public int getUse_org(){
        return this.use_org;
    }
    public void setUse_org(int use_org){
        this.use_org = use_org;
    }
    public int getOp_org(){
        return this.op_org;
    }
    public void setOp_org(int op_org){
        this.op_org = op_org;
    }

	public EMS_storage_op_docPO toPO(){
		EMS_storage_op_docPO po = new EMS_storage_op_docPO();
		
    	po.setDoc_no(doc_no);
		po.setCla_id(cla_id);
		po.setDoc_year(doc_year);
		po.setDoc_month(doc_month);
		po.setDoc_op_type(doc_op_type);
		po.setOp_type(op_type);
		po.setDoc_op_amt(doc_op_amt);
		po.setDoc_unit(doc_unit);
		po.setOp_emp(op_emp);
		po.setOp_date(op_date);
		po.setUse_emp(use_emp);
		po.setUse_time(use_time);
		po.setUse_org(use_org);
		po.setOp_org(op_org);
		
		return po;
	}
		
}