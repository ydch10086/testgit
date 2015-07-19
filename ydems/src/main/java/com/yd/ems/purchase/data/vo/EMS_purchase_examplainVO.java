package com.yd.ems.purchase.data.vo;

import java.math.BigDecimal;

import com.yd.ems.purchase.data.po.EMS_purchase_examplainPO;
import com.yd.ems.purchase.data.po.EMS_purchase_plainPO;

/**
 * <p>实体类</p>
 * <p>Table: em_purchase_plain - 设备采购计划表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_purchase_examplainVO {

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

    public long getPur_no(){
        return this.pur_no;
    }
    public void setPur_no(long pur_no){
        this.pur_no = pur_no;
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
	public EMS_purchase_examplainPO toPO(){
		EMS_purchase_examplainPO po = new EMS_purchase_examplainPO();
    	po.setPur_no(pur_no);
		po.setExa_emp(exa_emp);
		po.setApp_emp_num(app_emp_num);
		po.setExa_emp_num(exa_emp_num);
		po.setApp_date(app_date);
		po.setExa_date(exa_date);
		po.setPur_status(pur_status);
		return po;
	}
	/*public EMS_purchase_examplainPO toExamPO(){
		EMS_purchase_examplainPO po = new EMS_purchase_examplainPO();
    	po.setPur_no(pur_no);
		po.setExa_emp(exa_emp);
		po.setApp_emp_num(app_emp_num);
		po.setExa_emp_num(exa_emp_num);
		po.setApp_date(app_date);
		po.setExa_date(exa_date);
		po.setPur_status(pur_status);
		return po;
	}*/
		
}