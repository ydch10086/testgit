package com.yd.ems.mdm.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_mdm_employee - 人员主数据信息</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:13
 */
public class EMS_mdm_employeeData {


    /** 
    * emp_id - 人员工号
    */
    private int emp_id;

    /** 
    * emp_name - 人员姓名 
    */
    private String emp_name;

    /** 
    * emp_org - 所属组织 
    */
    private String emp_org;
    /** 
     * emp_org - 所属组织名称
     */
     private String emp_org_name;


    /** 
    * emp_status - 在职状态 
    */
    private int emp_status;
    /** 
     * emp_status_name - 在职状态中文名称 
     */
     private String emp_status_name;

    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;


    public int getEmp_id(){
        return this.emp_id;
    }
    public void setEmp_id(int emp_id){
        this.emp_id = emp_id;
    }

    public String getEmp_name(){
        return this.emp_name;
    }
    public void setEmp_name(String emp_name){
        this.emp_name = emp_name;
    }

    public String getEmp_org(){
        return this.emp_org;
    }
    public void setEmp_org(String emp_org){
        this.emp_org = emp_org;
    }

    public int getEmp_status(){
        return this.emp_status;
    }
    public void setEmp_status(int emp_status){
        this.emp_status = emp_status;
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
	public String getEmp_org_name() {
		return emp_org_name;
	}
	public void setEmp_org_name(String emp_org_name) {
		this.emp_org_name = emp_org_name;
	}
	public String getEmp_status_name() {
		return emp_status_name;
	}
	public void setEmp_status_name(String emp_status_name) {
		this.emp_status_name = emp_status_name;
	}

}