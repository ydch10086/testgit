package com.yd.common.function.admin.data;


/**
 * <p>Data实体类</p>
 * <p>View: cip_admin_auth_role - 角色权限值配置</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_roleData {


    /** 
    * auth_attr_id - 权限属性id
    */
    private String auth_attr_id;

    /** 
    * auth_role_id - 角色Id
    */
    private String auth_role_id;

    /** 
    * auth_attr_val - 权限属性值 
    */
    private String auth_attr_val;


    public String getAuth_attr_id(){
        return this.auth_attr_id;
    }
    public void setAuth_attr_id(String auth_attr_id){
        this.auth_attr_id = auth_attr_id;
    }

    public String getAuth_role_id(){
        return this.auth_role_id;
    }
    public void setAuth_role_id(String auth_role_id){
        this.auth_role_id = auth_role_id;
    }

    public String getAuth_attr_val(){
        return this.auth_attr_val;
    }
    public void setAuth_attr_val(String auth_attr_val){
        this.auth_attr_val = auth_attr_val;
    }

}