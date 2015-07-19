package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_roles - 角色信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_rolesKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			role_id
		};
	}
	
	public Object[] setKeys(String role_id){
		return new Object[]{ 
			role_id
		};
	}
	



    /** 
    * role_id - 角色id 
    */
    private String role_id;

	private String remark;
	
	private String operateCode;
	
    public String getRole_id(){
        return this.role_id;
    }
    
    public void setRole_id(String role_id){
        this.role_id = role_id;
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