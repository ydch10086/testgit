package com.yd.ems.mdm.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_mdm_employee - 人员主数据信息</p>
 *
 * @since 2015-05-29 02:42:13
 */
public class EMS_mdm_employeeKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			emp_id
		};
	}
	
	public Object[] setKeys(int emp_id){
		return new Object[]{ 
			emp_id
		};
	}
	



    /** 
    * emp_id - 人员工号 
    */
    private int emp_id;

	private String remark;
	
	private String operateCode;
	
    public int getEmp_id(){
        return this.emp_id;
    }
    
    public void setEmp_id(int emp_id){
        this.emp_id = emp_id;
    }

	public void setOperateCode(String operateCode){
		this.operateCode = operateCode;
	}
	
	public String getOperateCode(){
		return operateCode;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}
		
}