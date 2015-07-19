package com.yd.ems.mainten.data;

import java.math.BigDecimal;

/**
 * <p>Data实体类</p>
 * <p>View: em_mainten_repair_plan - 设备大修计划表</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_repair_planData {


    /** 
    * rep_no - 大修流水号
    */
    private long rep_no;

    /** 
    * obj_id - 设备编码 
    */
    private long obj_id;

    /** 
    * rep_app_date - 大修申请日期 
    */
    private String rep_app_date;

    /** 
    * rep_org - 所属组织 
    */
    private int rep_org;

    /** 
    * sup_code - 供应商 
    */
    private String sup_code;

    /** 
    * rep_beg_date - 设备起始日 
    */
    private String rep_beg_date;

    /** 
    * rep_status_txt - 设备状态 
    */
    private String rep_status_txt;

    /** 
    * rep_end_date - 大修完成日期 
    */
    private String rep_end_date;

    /** 
    * rep_amt - 大修费用 
    */
    private BigDecimal rep_amt;

    /** 
    * rep_op - 大修负责人工号 
    */
    private int rep_op;
    /**
     * 大修负责人姓名
     */
    private String rep_op_name;
    
    /**
     * 设备大修状态
     */
    private int repair_status;
    /**
     * 设备大修状态名称
     */
    private String repair_status_name;
    
    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;
    /** 
     * rep_org_name - 所属组织名称
     */
     private String rep_org_name;

     /** 
     * sup_code - 供应商名称
     */
     private String sup_code_name;

    public long getRep_no(){
        return this.rep_no;
    }
    public void setRep_no(long rep_no){
        this.rep_no = rep_no;
    }

    public long getObj_id(){
        return this.obj_id;
    }
    public void setObj_id(long obj_id){
        this.obj_id = obj_id;
    }

    public String getRep_app_date(){
        return this.rep_app_date;
    }
    public void setRep_app_date(String rep_app_date){
        this.rep_app_date = rep_app_date;
    }

    public int getRep_org(){
        return this.rep_org;
    }
    public void setRep_org(int rep_org){
        this.rep_org = rep_org;
    }

    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }

    public String getRep_beg_date(){
        return this.rep_beg_date;
    }
    public void setRep_beg_date(String rep_beg_date){
        this.rep_beg_date = rep_beg_date;
    }

    public String getRep_status_txt(){
        return this.rep_status_txt;
    }
    public void setRep_status_txt(String rep_status_txt){
        this.rep_status_txt = rep_status_txt;
    }

    public String getRep_end_date(){
        return this.rep_end_date;
    }
    public void setRep_end_date(String rep_end_date){
        this.rep_end_date = rep_end_date;
    }

    public BigDecimal getRep_amt(){
        return this.rep_amt;
    }
    public void setRep_amt(BigDecimal rep_amt){
        this.rep_amt = rep_amt;
    }

    public int getRep_op(){
        return this.rep_op;
    }
    public void setRep_op(int rep_op){
        this.rep_op = rep_op;
    }

    public int getRepair_status() {
		return repair_status;
	}
	public void setRepair_status(int repair_status) {
		this.repair_status = repair_status;
	}
	public String getRepair_status_name() {
		return repair_status_name;
	}
	public void setRepair_status_name(String repair_status_name) {
		this.repair_status_name = repair_status_name;
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
	public String getRep_org_name() {
		return rep_org_name;
	}
	public String getRep_op_name() {
		return rep_op_name;
	}
	public void setRep_op_name(String rep_op_name) {
		this.rep_op_name = rep_op_name;
	}
	public void setRep_org_name(String rep_org_name) {
		this.rep_org_name = rep_org_name;
	}
	public String getSup_code_name() {
		return sup_code_name;
	}
	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}

}