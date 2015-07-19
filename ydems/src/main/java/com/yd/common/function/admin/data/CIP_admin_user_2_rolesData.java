package com.yd.common.function.admin.data;


/**
 * <p>Data实体类</p>
 * <p>View: cip_admin_user_2_roles - 用户角色关联</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_user_2_rolesData {


    /** 
    * role_id - 角色id
    */
    private String role_id;

    /** 
    * user_id - 用户id
    */
    private String user_id;

    /** 
    * create_time - 系统生成时间 
    */
    private String create_time;

    /** 
    * update_time - 修改时间 
    */
    private String update_time;

    /** 
    * operator - 操作人 
    */
    private String operator;

    /** 
    * default_flag - 默认角色标识 
    */
    private Integer default_flag;
	/**
	* 文本描述信息
	*/
	private String default_flag_name;


    public String getRole_id(){
        return this.role_id;
    }
    public void setRole_id(String role_id){
        this.role_id = role_id;
    }

    public String getUser_id(){
        return this.user_id;
    }
    public void setUser_id(String user_id){
        this.user_id = user_id;
    }

    public String getCreate_time(){
        return this.create_time;
    }
    public void setCreate_time(String create_time){
        this.create_time = create_time;
    }

    public String getUpdate_time(){
        return this.update_time;
    }
    public void setUpdate_time(String update_time){
        this.update_time = update_time;
    }

    public String getOperator(){
        return this.operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

    public Integer getDefault_flag(){
        return this.default_flag;
    }
    public void setDefault_flag(Integer default_flag){
        this.default_flag = default_flag;
    }

	public String getDefault_flag_name(){
        return this.default_flag_name;
    }
    public void setDefault_flag_name(String default_flag_name){
        this.default_flag_name = default_flag_name;
    }
    
}