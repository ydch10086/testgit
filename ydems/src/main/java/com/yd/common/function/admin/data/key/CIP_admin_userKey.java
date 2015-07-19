package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_user - 用户信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_userKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			user_id
		};
	}
	
	public Object[] setKeys(String user_id){
		return new Object[]{ 
			user_id
		};
	}
	



    /** 
    * user_id - 用户id 
    */
    private String user_id;

	private String remark;
	
	private String operateCode;
	
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