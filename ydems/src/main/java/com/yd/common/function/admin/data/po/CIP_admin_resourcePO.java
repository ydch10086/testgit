package com.yd.common.function.admin.data.po;


import com.yd.common.function.admin.data.vo.CIP_admin_resourceVO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_resource - 系统资源信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_resourcePO {

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
    * create_time - 系统生成时间
    */
    private String create_time;

    /** 
    * update_time - 修改时间
    */
    private String update_time;

    /** 
    * operator - 操作人员
    */
    private String operator;

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

    public String getCreate_time(){
        return this.create_time;
    }
    public void setCreate_time(String create_time){
        this.create_time = create_time;
    }

    public String getUpdate_time(){
        return this.update_time;
    }
    public void setUpdate_time(String update_time){
        this.update_time = update_time;
    }

    public String getOperator(){
        return this.operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

    public String getIcon_id(){
        return this.icon_id;
    }
    public void setIcon_id(String icon_id){
        this.icon_id = icon_id;
    }

	public CIP_admin_resourceVO toVO(){
		CIP_admin_resourceVO vo = new CIP_admin_resourceVO();
		
    	vo.setResource_id(resource_id);
		vo.setResource_name(resource_name);
		vo.setResource_desc(resource_desc);
		vo.setSys_uri(sys_uri);
		vo.setResource_type(resource_type);
		vo.setIcon_id(icon_id);
		
		return vo;
	}
		
}