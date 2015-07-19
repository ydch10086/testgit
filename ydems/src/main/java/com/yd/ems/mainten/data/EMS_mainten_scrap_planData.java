package com.yd.ems.mainten.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_mainten_scrap_plan - 设备报废计划表</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_scrap_planData {


    /** 
    * scrap_no - 报废流水号
    */
    private long scrap_no;

    /** 
    * obj_id - 设备编码 
    */
    private long obj_id;

    /** 
    * scrap_org - 所属组织 
    */
    private int scrap_org;

    /** 
    * sup_code - 供应商 
    */
    private String sup_code;

    /** 
    * begin_date - 设备起始日 
    */
    private String begin_date;

    /** 
    * status_txt - 设备状态 
    */
    private String status_txt;

    /** 
    * theory_date - 理论报废日期 
    */
    private String theory_date;

    /** 
    * act_date - 实际报废日期 
    */
    private String act_date;

    /** 
    * start_op - 发起人 工号
    */
    private int start_op;

    /** 
    * examine_op - 审核人 工号
    */
    private int examine_op;
    /**
     * 审核审核状态
     */
    private int examine_status;
    
    /**
     * 设备审核状态名称
     */
    private String examine_status_name;
    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;

    /** 
     * scrap_org_name - 所属组织名称
     */
     private String scrap_org_name;

     /** 
     * sup_code_name - 供应商 
     */
     private String sup_code_name;

    
     /** 
      * start_op_name - 发起人姓名 
      */
      private String start_op_name;

      /** 
      * examine_op_name - 审核人 姓名
      */
      private String examine_op_name;
    public long getScrap_no(){
        return this.scrap_no;
    }
    public void setScrap_no(long scrap_no){
        this.scrap_no = scrap_no;
    }

    public long getObj_id(){
        return this.obj_id;
    }
    public void setObj_id(long obj_id){
        this.obj_id = obj_id;
    }

    public int getScrap_org(){
        return this.scrap_org;
    }
    public void setScrap_org(int scrap_org){
        this.scrap_org = scrap_org;
    }

    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }

    public String getBegin_date(){
        return this.begin_date;
    }
    public void setBegin_date(String begin_date){
        this.begin_date = begin_date;
    }

    public String getStatus_txt(){
        return this.status_txt;
    }
    public void setStatus_txt(String status_txt){
        this.status_txt = status_txt;
    }

    public String getTheory_date(){
        return this.theory_date;
    }
    public void setTheory_date(String theory_date){
        this.theory_date = theory_date;
    }

    public String getAct_date(){
        return this.act_date;
    }
    public void setAct_date(String act_date){
        this.act_date = act_date;
    }

    public int getStart_op(){
        return this.start_op;
    }
    public void setStart_op(int start_op){
        this.start_op = start_op;
    }

    public int getExamine_op(){
        return this.examine_op;
    }
    public void setExamine_op(int examine_op){
        this.examine_op = examine_op;
    }

    public int getOperator(){
        return this.operator;
    }
    public void setOperator(int operator){
        this.operator = operator;
    }

    public int getExamine_status() {
		return examine_status;
	}
	public void setExamine_status(int examine_status) {
		this.examine_status = examine_status;
	}
	public String getExamine_status_name() {
		return examine_status_name;
	}
	public void setExamine_status_name(String examine_status_name) {
		this.examine_status_name = examine_status_name;
	}
	public String getOp_time(){
        return this.op_time;
    }
    public void setOp_time(String op_time){
        this.op_time = op_time;
    }
	public String getScrap_org_name() {
		return scrap_org_name;
	}
	public void setScrap_org_name(String scrap_org_name) {
		this.scrap_org_name = scrap_org_name;
	}
	public String getStart_op_name() {
		return start_op_name;
	}
	public void setStart_op_name(String start_op_name) {
		this.start_op_name = start_op_name;
	}
	public String getExamine_op_name() {
		return examine_op_name;
	}
	public void setExamine_op_name(String examine_op_name) {
		this.examine_op_name = examine_op_name;
	}
	public String getSup_code_name() {
		return sup_code_name;
	}
	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}

}