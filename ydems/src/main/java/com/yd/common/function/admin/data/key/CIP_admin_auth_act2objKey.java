package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_auth_act2obj - 权限对象授权配置</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_act2objKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			obj_attr_id,
					obj_id,
					resource_id,
					root_node_id
		};
	}
	
	public Object[] setKeys(String obj_attr_id,String obj_id,String resource_id,String root_node_id){
		return new Object[]{ 
			obj_attr_id,
					obj_id,
					resource_id,
					root_node_id
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

    /** 
    * resource_id - 行为资源id 
    */
    private String resource_id;

    /** 
    * root_node_id - 资源根节点 
    */
    private String root_node_id;

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
    public String getResource_id(){
        return this.resource_id;
    }
    
    public void setResource_id(String resource_id){
        this.resource_id = resource_id;
    }
    public String getRoot_node_id(){
        return this.root_node_id;
    }
    
    public void setRoot_node_id(String root_node_id){
        this.root_node_id = root_node_id;
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