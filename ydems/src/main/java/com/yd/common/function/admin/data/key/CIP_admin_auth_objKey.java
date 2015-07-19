package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_auth_obj - 权限对象信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_objKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			auth_obj_id
		};
	}
	
	public Object[] setKeys(String auth_obj_id){
		return new Object[]{ 
			auth_obj_id
		};
	}
	



    /** 
    * auth_obj_id - 权限对象id 
    */
    private String auth_obj_id;

	private String remark;
	
	private String operateCode;
	
    public String getAuth_obj_id(){
        return this.auth_obj_id;
    }
    
    public void setAuth_obj_id(String auth_obj_id){
        this.auth_obj_id = auth_obj_id;
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