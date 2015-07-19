package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_resource - 系统资源信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_resourceKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			resource_id
		};
	}
	
	public Object[] setKeys(String resource_id){
		return new Object[]{ 
			resource_id
		};
	}
	



    /** 
    * resource_id - 资源id 
    */
    private String resource_id;

	private String remark;
	
	private String operateCode;
	
    public String getResource_id(){
        return this.resource_id;
    }
    
    public void setResource_id(String resource_id){
        this.resource_id = resource_id;
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