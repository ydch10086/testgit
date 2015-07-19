package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_auth_role - 角色权限值配置</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_roleKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			auth_attr_id,
					auth_role_id
		};
	}
	
	public Object[] setKeys(String auth_attr_id,String auth_role_id){
		return new Object[]{ 
			auth_attr_id,
					auth_role_id
		};
	}
	



    /** 
    * auth_attr_id - 权限属性id 
    */
    private String auth_attr_id;

    /** 
    * auth_role_id - 角色Id 
    */
    private String auth_role_id;

	private String remark;
	
	private String operateCode;
	
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