package com.yd.ems.mdm.data.vo;


import com.yd.ems.mdm.data.po.EMS_mdm_employeePO;

/**
 * <p>实体类</p>
 * <p>Table: em_mdm_employee - 人员主数据信息</p>
 *
 * @since 2015-05-29 02:42:13
 */
public class EMS_mdm_employeeVO {

	public Object[] getKeys(){
		return new Object[]{ 
			emp_id
		};
	}


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
    /* private String emp_org_name;*/
    /** 
    * emp_status - 在职状态 
    */
    private int emp_status;

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

	/*public String getEmp_org_name() {
		return emp_org_name;
	}
	public void setEmp_org_name(String emp_org_name) {
		this.emp_org_name = emp_org_name;
	}*/
	public EMS_mdm_employeePO toPO(){
		EMS_mdm_employeePO po = new EMS_mdm_employeePO();
		
    	po.setEmp_id(emp_id);
		po.setEmp_name(emp_name);
		po.setEmp_org(emp_org);
		po.setEmp_status(emp_status);
		
		return po;
	}
		
}