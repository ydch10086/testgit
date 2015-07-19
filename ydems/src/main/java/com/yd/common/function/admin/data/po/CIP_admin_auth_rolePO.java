package com.yd.common.function.admin.data.po;


import com.yd.common.function.admin.data.vo.CIP_admin_auth_roleVO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_auth_role - 角色权限值配置</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_rolePO {

	public Object[] getKeys(){
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

    /** 
    * auth_attr_val - 权限属性值
    */
    private String auth_attr_val;


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

    public String getAuth_attr_val(){
        return this.auth_attr_val;
    }
    public void setAuth_attr_val(String auth_attr_val){
        this.auth_attr_val = auth_attr_val;
    }

	public CIP_admin_auth_roleVO toVO(){
		CIP_admin_auth_roleVO vo = new CIP_admin_auth_roleVO();
		
    	vo.setAuth_attr_id(auth_attr_id);
    	vo.setAuth_role_id(auth_role_id);
		vo.setAuth_attr_val(auth_attr_val);
		
		return vo;
	}
		
}