package com.yd.ems.mainten.data.vo;


import com.yd.ems.mainten.data.po.EMS_mainten_repair_logPO;

/**
 * <p>实体类</p>
 * <p>Table: em_mainten_repair_log - 设备维修日志表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_repair_logVO {

	public Object[] getKeys(){
		return new Object[]{ 
			rep_no
		};
	}


    /** 
    * rep_no - 维修流水号 
    */
    private long rep_no;
    /** 
    * obj_id - 设备编码 
    */
    private long obj_id;
    /** 
    * apply_date - 维修申请日期 
    */
    private String apply_date;
    /** 
    * rep_org - 所属组织 
    */
    private int rep_org;
    /** 
    * rep_orgeh - 设备位置编码 
    */
    private int rep_orgeh;
    /** 
    * sup_code - 供应商 
    */
    private String sup_code;
    /** 
    * fault_txt - 故障现象 
    */
    private String fault_txt;
    /** 
    * begin_time - 报修时间 
    */
    private String begin_time;
    /** 
    * end_time - 报复时间 
    */
    private String end_time;
    /** 
    * fault_reason - 故障原因 
    */
    private String fault_reason;
    /** 
    * fault_solution - 处理措施 
    */
    private String fault_solution;
    /** 
    * fault_type - 故障分类 
    */
    private int fault_type;
    /** 
    * cla_id - 更换部件 
    */
    private long cla_id;
    /** 
    * repair_stye_txt - 部件型号 
    */
    private String repair_stye_txt;
    /** 
    * repair_type - 维修类型 
    */
    private int repair_type;
    /** 
    * repair_emp_quan - 维修人数 
    */
    private int repair_emp_quan;
    /** 
    * repair_emp_no - 维修人 -对应下拉选择框中的内容
    */
    private int repair_emp_no;
    /** 
     * repair_emps_name - 维修人 成员
     */
     private String repair_emps_name;
    /** 
    * op - 修改者 
    */
    private int op;

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
    public String getApply_date(){
        return this.apply_date;
    }
    public void setApply_date(String apply_date){
        this.apply_date = apply_date;
    }
    public int getRep_org(){
        return this.rep_org;
    }
    public void setRep_org(int rep_org){
        this.rep_org = rep_org;
    }
    public int getRep_orgeh(){
        return this.rep_orgeh;
    }
    public void setRep_orgeh(int rep_orgeh){
        this.rep_orgeh = rep_orgeh;
    }
    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }
    public String getFault_txt(){
        return this.fault_txt;
    }
    public void setFault_txt(String fault_txt){
        this.fault_txt = fault_txt;
    }
    public String getBegin_time(){
        return this.begin_time;
    }
    public void setBegin_time(String begin_time){
        this.begin_time = begin_time;
    }
    public String getEnd_time(){
        return this.end_time;
    }
    public void setEnd_time(String end_time){
        this.end_time = end_time;
    }
    public String getFault_reason(){
        return this.fault_reason;
    }
    public void setFault_reason(String fault_reason){
        this.fault_reason = fault_reason;
    }
    public String getFault_solution(){
        return this.fault_solution;
    }
    public void setFault_solution(String fault_solution){
        this.fault_solution = fault_solution;
    }
    public int getFault_type(){
        return this.fault_type;
    }
    public void setFault_type(int fault_type){
        this.fault_type = fault_type;
    }
    public long getCla_id(){
        return this.cla_id;
    }
    public void setCla_id(long cla_id){
        this.cla_id = cla_id;
    }
    public String getRepair_stye_txt(){
        return this.repair_stye_txt;
    }
    public void setRepair_stye_txt(String repair_stye_txt){
        this.repair_stye_txt = repair_stye_txt;
    }
    public String getRepair_emps_name() {
		return repair_emps_name;
	}
	public void setRepair_emps_name(String repair_emps_name) {
		this.repair_emps_name = repair_emps_name;
	}
	public int getRepair_type(){
        return this.repair_type;
    }
    public void setRepair_type(int repair_type){
        this.repair_type = repair_type;
    }
    public int getRepair_emp_quan(){
        return this.repair_emp_quan;
    }
    public void setRepair_emp_quan(int repair_emp_quan){
        this.repair_emp_quan = repair_emp_quan;
    }
    public int getRepair_emp_no(){
        return this.repair_emp_no;
    }
    public void setRepair_emp_no(int repair_emp_no){
        this.repair_emp_no = repair_emp_no;
    }
    public int getOp(){
        return this.op;
    }
    public void setOp(int op){
        this.op = op;
    }

	public EMS_mainten_repair_logPO toPO(){
		EMS_mainten_repair_logPO po = new EMS_mainten_repair_logPO();
		
    	po.setRep_no(rep_no);
		po.setObj_id(obj_id);
		po.setApply_date(apply_date);
		po.setRep_org(rep_org);
		po.setRep_orgeh(rep_orgeh);
		po.setSup_code(sup_code);
		po.setFault_txt(fault_txt);
		po.setBegin_time(begin_time);
		po.setEnd_time(end_time);
		po.setFault_reason(fault_reason);
		po.setFault_solution(fault_solution);
		po.setFault_type(fault_type);
		po.setCla_id(cla_id);
		po.setRepair_stye_txt(repair_stye_txt);
		po.setRepair_type(repair_type);
		po.setRepair_emp_quan(repair_emp_quan);
		po.setRepair_emp_no(repair_emp_no);
		po.setRepair_emps_name(repair_emps_name);
	//	po.setRepair_process_no(repair_process_no);
		po.setOp(op);
		
		return po;
	}
		
}