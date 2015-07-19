package com.yd.ems.purchase.data.po;

import java.math.BigDecimal;

import com.yd.ems.purchase.data.vo.EMS_purchase_plainVO;

/**
 * <p>实体类</p>
 * <p>Table: em_purchase_plain - 设备采购计划表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_purchase_plainPO {

	public Object[] getKeys(){
		return new Object[]{ 
				pur_no
		};
	}


    /** 
    * pur_no - 采购计划流水号 
    */
    private long pur_no;

    /** 
    * pur_obj - 对象标识
    */
    private int pur_obj;

    /** 
    * pur_org - 所属组织
    */
    private int pur_org;
  
    /** 
    * pur_date - 采购日期
    */
    private String pur_date;

    /** 
    * type_txt - 对象型号
    */
    private String type_txt;

    /** 
    * sup_code - 供应商
    */
    private String sup_code;
    

    /** 
    * pla_date - 计划到货日期
    */
    private String pla_date;

    /** 
    * pur_amt - 申请数量
    */
    private BigDecimal pur_amt;

    /** 
    * pur_unit - 数量单位
    */
    private String pur_unit;

    /** 
    * app_emp - 申请人
    */
    private String app_emp;

    /** 
    * exa_emp - 审核人
    */
    private String exa_emp;
    /** 
     * app_emp_num - 申请人 工号
     */
     private String app_emp_num;
     /** 
     * exa_emp_num - 审核人 工号
     */
     private String exa_emp_num;
    /** 
    * app_date - 申请日期
    */
    private String app_date;

    /** 
    * exa_date - 审核日期
    */
    private String exa_date;

    /** 
    * pur_status - 记录状态
    */
    private String pur_status;

    /** 
    * operator - 修改者
    */
    private int operator;

    /** 
    * op_time - 修改日期
    */
    private String op_time;


    public long getPur_no(){
        return this.pur_no;
    }
    public void setPur_no(long pur_no){
        this.pur_no = pur_no;
    }

    public int getPur_obj(){
        return this.pur_obj;
    }
    public void setPur_obj(int pur_obj){
        this.pur_obj = pur_obj;
    }

    public int getPur_org(){
        return this.pur_org;
    }
    public void setPur_org(int pur_org){
        this.pur_org = pur_org;
    }

    public String getPur_date(){
        return this.pur_date;
    }
    public void setPur_date(String pur_date){
        this.pur_date = pur_date;
    }

    public String getType_txt(){
        return this.type_txt;
    }
    public void setType_txt(String type_txt){
        this.type_txt = type_txt;
    }

    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }

    public String getPla_date(){
        return this.pla_date;
    }
    public void setPla_date(String pla_date){
        this.pla_date = pla_date;
    }

	public BigDecimal getPur_amt(){
        return this.pur_amt;
    }
    public void setPur_amt(BigDecimal pur_amt){
        this.pur_amt = pur_amt;
    }

    public String getPur_unit(){
        return this.pur_unit;
    }
    public void setPur_unit(String pur_unit){
        this.pur_unit = pur_unit;
    }

    public String getApp_emp(){
        return this.app_emp;
    }
    public void setApp_emp(String app_emp){
        this.app_emp = app_emp;
    }

	public String getExa_emp(){
        return this.exa_emp;
    }
    public void setExa_emp(String exa_emp){
        this.exa_emp = exa_emp;
    }

    public String getApp_date(){
        return this.app_date;
    }
    public void setApp_date(String app_date){
        this.app_date = app_date;
    }

	public String getExa_date(){
        return this.exa_date;
    }
    public void setExa_date(String exa_date){
        this.exa_date = exa_date;
    }

    public String getPur_status(){
        return this.pur_status;
    }
    public void setPur_status(String pur_status){
        this.pur_status = pur_status;
    }

    public int getOperator(){
        return this.operator;
    }
    public void setOperator(int operator){
        this.operator = operator;
    }

    public String getOp_time(){
        return this.op_time;
    }
    public void setOp_time(String op_time){
        this.op_time = op_time;
    }

	public String getApp_emp_num() {
		return app_emp_num;
	}
	public void setApp_emp_num(String app_emp_num) {
		this.app_emp_num = app_emp_num;
	}
	public String getExa_emp_num() {
		return exa_emp_num;
	}
	public void setExa_emp_num(String exa_emp_num) {
		this.exa_emp_num = exa_emp_num;
	}
	public EMS_purchase_plainVO toVO(){
		EMS_purchase_plainVO vo = new EMS_purchase_plainVO();
    	vo.setPur_no(pur_no);
		vo.setPur_obj(pur_obj);
		vo.setPur_org(pur_org);
		vo.setPur_date(pur_date);
		vo.setType_txt(type_txt);
		vo.setSup_code(sup_code);
		vo.setPla_date(pla_date);
		vo.setPur_amt(pur_amt);
		vo.setPur_unit(pur_unit);
		vo.setApp_emp(app_emp);
		vo.setExa_emp(exa_emp);
		vo.setApp_emp_num(app_emp_num);
		vo.setExa_emp_num(exa_emp_num);
		vo.setApp_date(app_date);
		vo.setExa_date(exa_date);
		vo.setPur_status(pur_status);
		return vo;
	}
		
}