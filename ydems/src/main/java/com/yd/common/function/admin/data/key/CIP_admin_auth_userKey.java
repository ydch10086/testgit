package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_auth_user - 用户权限字段配置</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_userKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			user_attr_id
		};
	}
	
	public Object[] setKeys(String user_attr_id){
		return new Object[]{ 
			user_attr_id
		};
	}
	



    /** 
    * user_attr_id - 权限属性id 
    */
    private String user_attr_id;

	private String remark;
	
	private String operateCode;
	
    public String getUser_attr_id(){
        return this.user_attr_id;
    }
    
    public void setUser_attr_id(String user_attr_id){
        this.user_attr_id = user_attr_id;
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