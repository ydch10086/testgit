package com.yd.ems.mdm.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_mdm_orgeh - 组织机构主数据</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_orgehData {


    /** 
    * org_id - 组织编码
    */
    private int org_id;

    /** 
    * org_name - 组织描述 
    */
    private String org_name;

    /** 
    * org_status - 使用状态 
    */
    private String org_status;
    
    /** 
     * org_status_name - 使用状态中文名称 
     */
     private String org_status_name;

    /** 
    * org_fat_id - 父级编码 
    */
    private int org_fat_id;

    /** 
    * operator - 修改者 
    */
    private String operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;


    public int getOrg_id(){
        return this.org_id;
    }
    public void setOrg_id(int org_id){
        this.org_id = org_id;
    }

    public String getOrg_name(){
        return this.org_name;
    }
    public void setOrg_name(String org_name){
        this.org_name = org_name;
    }

    public String getOrg_status(){
        return this.org_status;
    }
    public void setOrg_status(String org_status){
        this.org_status = org_status;
    }

    public int getOrg_fat_id(){
        return this.org_fat_id;
    }
    public void setOrg_fat_id(int org_fat_id){
        this.org_fat_id = org_fat_id;
    }

    public String getOperator(){
        return this.operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

    public String getOp_time(){
        return this.op_time;
    }
    public void setOp_time(String op_time){
        this.op_time = op_time;
    }
	public String getOrg_status_name() {
		return org_status_name;
	}
	public void setOrg_status_name(String org_status_name) {
		this.org_status_name = org_status_name;
	}

}