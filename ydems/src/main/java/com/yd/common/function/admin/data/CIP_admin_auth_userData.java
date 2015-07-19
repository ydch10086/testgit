package com.yd.common.function.admin.data;


/**
 * <p>Data实体类</p>
 * <p>View: cip_admin_auth_user - 用户权限字段配置</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_userData {


    /** 
    * user_attr_id - 权限属性id
    */
    private String user_attr_id;

    /** 
    * auth_attr_name - 权限属性名称 
    */
    private String auth_attr_name;


    public String getUser_attr_id(){
        return this.user_attr_id;
    }
    public void setUser_attr_id(String user_attr_id){
        this.user_attr_id = user_attr_id;
    }

    public String getAuth_attr_name(){
        return this.auth_attr_name;
    }
    public void setAuth_attr_name(String auth_attr_name){
        this.auth_attr_name = auth_attr_name;
    }

}