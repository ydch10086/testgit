package com.yd.ems.mainten.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_mainten_log - 设备保养日志表</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_logData {


    /** 
    * mainten_no - 保养流水号
    */
    private long mainten_no;

    /** 
    * obj_id - 设备编码 
    */
    private long obj_id;

    /** 
    * mainten_org - 所属组织 
    */
    private int mainten_org;

    /** 
    * sup_code - 供应商 
    */
    private String sup_code;

    /** 
    * set_date - 定期保养日期 
    */
    private String set_date;

    /** 
    * begin_date - 有效起始日期 
    */
    private String begin_date;

    /** 
    * mainten_op - 保养人工号
    */
    private int mainten_op;
    /**
     * 保养人姓名
     */
    private String mainten_op_name;
    /** 
    * mainten_status - 保养状态 
    */
    private String mainten_status;

    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;
    private String mainten_org_name;
    private String sup_code_name;
    private String mainten_status_name;
    public long getMainten_no(){
        return this.mainten_no;
    }
    public void setMainten_no(long mainten_no){
        this.mainten_no = mainten_no;
    }

    public long getObj_id(){
        return this.obj_id;
    }
    public void setObj_id(long obj_id){
        this.obj_id = obj_id;
    }

    public int getMainten_org(){
        return this.mainten_org;
    }
    public void setMainten_org(int mainten_org){
        this.mainten_org = mainten_org;
    }

    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }

    public String getSet_date(){
        return this.set_date;
    }
    public void setSet_date(String set_date){
        this.set_date = set_date;
    }

    public String getBegin_date(){
        return this.begin_date;
    }
    public void setBegin_date(String begin_date){
        this.begin_date = begin_date;
    }

    public int getMainten_op(){
        return this.mainten_op;
    }
    public void setMainten_op(int mainten_op){
        this.mainten_op = mainten_op;
    }

    public String getMainten_status(){
        return this.mainten_status;
    }
    public void setMainten_status(String mainten_status){
        this.mainten_status = mainten_status;
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
	public String getMainten_org_name() {
		return mainten_org_name;
	}
	public void setMainten_org_name(String mainten_org_name) {
		this.mainten_org_name = mainten_org_name;
	}
	public String getMainten_op_name() {
		return mainten_op_name;
	}
	public void setMainten_op_name(String mainten_op_name) {
		this.mainten_op_name = mainten_op_name;
	}
	public String getSup_code_name() {
		return sup_code_name;
	}
	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}
	public String getMainten_status_name() {
		return mainten_status_name;
	}
	public void setMainten_status_name(String mainten_status_name) {
		this.mainten_status_name = mainten_status_name;
	}

}