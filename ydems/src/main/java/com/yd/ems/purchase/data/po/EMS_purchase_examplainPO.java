package com.yd.ems.purchase.data.po;

import java.math.BigDecimal;

import com.yd.ems.purchase.data.vo.EMS_purchase_examplainVO;
import com.yd.ems.purchase.data.vo.EMS_purchase_plainVO;

/**
 * <p>实体类</p>
 * <p>Table: em_purchase_plain - 设备采购计划表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_purchase_examplainPO {

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
	public EMS_purchase_examplainVO toVO(){
		EMS_purchase_examplainVO vo = new EMS_purchase_examplainVO();
		vo.setExa_emp(exa_emp);
		vo.setApp_emp_num(app_emp_num);
		vo.setExa_emp_num(exa_emp_num);
		vo.setApp_date(app_date);
		vo.setExa_date(exa_date);
		vo.setPur_status(pur_status);
		return vo;
	}
		
}