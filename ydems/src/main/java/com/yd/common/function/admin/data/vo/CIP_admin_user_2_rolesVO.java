package com.yd.common.function.admin.data.vo;


import com.yd.common.function.admin.data.po.CIP_admin_user_2_rolesPO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_user_2_roles - 用户角色关联</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_user_2_rolesVO {

	public Object[] getKeys(){
		return new Object[]{ 
			role_id,
					user_id
		};
	}


    /** 
    * role_id - 角色id 
    */
    private String role_id;

    /** 
    * user_id - 用户id 
    */
    private String user_id;
    /** 
    * default_flag - 默认角色标识 
    */
    private Integer default_flag;

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
    public Integer getDefault_flag(){
        return this.default_flag;
    }
    public void setDefault_flag(Integer default_flag){
        this.default_flag = default_flag;
    }

	public CIP_admin_user_2_rolesPO toPO(){
		CIP_admin_user_2_rolesPO po = new CIP_admin_user_2_rolesPO();
		
    	po.setRole_id(role_id);
    	po.setUser_id(user_id);
		po.setDefault_flag(default_flag);
		
		return po;
	}
		
}