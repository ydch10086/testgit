package com.yd.common.function.admin.data.vo;


import com.yd.common.function.admin.data.po.CIP_admin_resourcePO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_resource - 系统资源信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_resourceVO {

	public Object[] getKeys(){
		return new Object[]{ 
			resource_id
		};
	}


    /** 
    * resource_id - 资源id 
    */
    private String resource_id;
    /** 
    * resource_name - 资源名称 
    */
    private String resource_name;
    /** 
    * resource_desc - 资源描述 
    */
    private String resource_desc;
    /** 
    * sys_uri - 访问URI 
    */
    private String sys_uri;
    /** 
    * resource_type - 资源类型 
    */
    private String resource_type;
    /** 
    * icon_id - 图标id 
    */
    private String icon_id;

    public String getResource_id(){
        return this.resource_id;
    }
    public void setResource_id(String resource_id){
        this.resource_id = resource_id;
    }
    public String getResource_name(){
        return this.resource_name;
    }
    public void setResource_name(String resource_name){
        this.resource_name = resource_name;
    }
    public String getResource_desc(){
        return this.resource_desc;
    }
    public void setResource_desc(String resource_desc){
        this.resource_desc = resource_desc;
    }
    public String getSys_uri(){
        return this.sys_uri;
    }
    public void setSys_uri(String sys_uri){
        this.sys_uri = sys_uri;
    }
    public String getResource_type(){
        return this.resource_type;
    }
    public void setResource_type(String resource_type){
        this.resource_type = resource_type;
    }
    public String getIcon_id(){
        return this.icon_id;
    }
    public void setIcon_id(String icon_id){
        this.icon_id = icon_id;
    }

	public CIP_admin_resourcePO toPO(){
		CIP_admin_resourcePO po = new CIP_admin_resourcePO();
		
    	po.setResource_id(resource_id);
		po.setResource_name(resource_name);
		po.setResource_desc(resource_desc);
		po.setSys_uri(sys_uri);
		po.setResource_type(resource_type);
		po.setIcon_id(icon_id);
		
		return po;
	}
		
}