package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_auth_attr - 权限对象属性信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_attrKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			obj_attr_id,
					obj_id
		};
	}
	
	public Object[] setKeys(String obj_attr_id,String obj_id){
		return new Object[]{ 
			obj_attr_id,
					obj_id
		};
	}
	



    /** 
    * obj_attr_id - 权限对象属性id 
    */
    private String obj_attr_id;

    /** 
    * obj_id - 权限对象id 
    */
    private String obj_id;

	private String remark;
	
	private String operateCode;
	
    public String getObj_attr_id(){
        return this.obj_attr_id;
    }
    
    public void setObj_attr_id(String obj_attr_id){
        this.obj_attr_id = obj_attr_id;
    }
    public String getObj_id(){
        return this.obj_id;
    }
    
    public void setObj_id(String obj_id){
        this.obj_id = obj_id;
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