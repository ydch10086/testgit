package com.yd.common.function.admin.data.vo;


import com.yd.common.function.admin.data.po.CIP_admin_rolesPO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_roles - 角色信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_rolesVO {

	public Object[] getKeys(){
		return new Object[]{ 
			role_id
		};
	}


    /** 
    * role_id - 角色id 
    */
    private String role_id;
    /** 
    * role_name - 角色名称 
    */
    private String role_name;
    /** 
    * root_resource_id - 资源根节点id 
    */
    private String root_resource_id;

    public String getRole_id(){
        return this.role_id;
    }
    public void setRole_id(String role_id){
        this.role_id = role_id;
    }
    public String getRole_name(){
        return this.role_name;
    }
    public void setRole_name(String role_name){
        this.role_name = role_name;
    }
    public String getRoot_resource_id(){
        return this.root_resource_id;
    }
    public void setRoot_resource_id(String root_resource_id){
        this.root_resource_id = root_resource_id;
    }

	public CIP_admin_rolesPO toPO(){
		CIP_admin_rolesPO po = new CIP_admin_rolesPO();
		
    	po.setRole_id(role_id);
		po.setRole_name(role_name);
		po.setRoot_resource_id(root_resource_id);
		
		return po;
	}
		
}