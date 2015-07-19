package com.yd.common.function.admin.data;


/**
 * <p>Data实体类</p>
 * <p>View: cip_admin_auth_obj - 权限对象信息</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_objData {


    /** 
    * auth_obj_id - 权限对象id
    */
    private String auth_obj_id;

    /** 
    * auth_obj_name - 权限对象描述 
    */
    private String auth_obj_name;


    public String getAuth_obj_id(){
        return this.auth_obj_id;
    }
    public void setAuth_obj_id(String auth_obj_id){
        this.auth_obj_id = auth_obj_id;
    }

    public String getAuth_obj_name(){
        return this.auth_obj_name;
    }
    public void setAuth_obj_name(String auth_obj_name){
        this.auth_obj_name = auth_obj_name;
    }

}