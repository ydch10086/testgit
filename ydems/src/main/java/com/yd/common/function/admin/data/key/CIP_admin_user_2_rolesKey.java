package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_user_2_roles - 用户角色关联</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_user_2_rolesKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			role_id,
					user_id
		};
	}
	
	public Object[] setKeys(String role_id,String user_id){
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

	private String remark;
	
	private String operateCode;
	
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