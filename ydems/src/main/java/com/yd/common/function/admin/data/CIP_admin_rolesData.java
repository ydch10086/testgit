package com.yd.common.function.admin.data;


/**
 * <p>Data实体类</p>
 * <p>View: cip_admin_roles - 角色信息</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_rolesData {


    /** 
    * role_id - 角色id
    */
    private String role_id;

    /** 
    * role_name - 角色名称 
    */
    private String role_name;

    /** 
    * root_resource_id - 资源根节点id 
    */
    private String root_resource_id;

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


    public String getRole_id(){
        return this.role_id;
    }
    public void setRole_id(String role_id){
        this.role_id = role_id;
    }

    public String getRole_name(){
        return this.role_name;
    }
    public void setRole_name(String role_name){
        this.role_name = role_name;
    }

    public String getRoot_resource_id(){
        return this.root_resource_id;
    }
    public void setRoot_resource_id(String root_resource_id){
        this.root_resource_id = root_resource_id;
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

}