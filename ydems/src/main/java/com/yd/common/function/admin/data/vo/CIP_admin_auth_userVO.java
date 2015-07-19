package com.yd.common.function.admin.data.vo;


import com.yd.common.function.admin.data.po.CIP_admin_auth_userPO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_auth_user - 用户权限字段配置</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_userVO {

	public Object[] getKeys(){
		return new Object[]{ 
			user_attr_id
		};
	}


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

	public CIP_admin_auth_userPO toPO(){
		CIP_admin_auth_userPO po = new CIP_admin_auth_userPO();
		
    	po.setUser_attr_id(user_attr_id);
		po.setAuth_attr_name(auth_attr_name);
		
		return po;
	}
		
}