package com.yd.common.function.admin.data.po;


import com.yd.common.function.admin.data.vo.CIP_admin_auth_objVO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_auth_obj - 权限对象信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_objPO {

	public Object[] getKeys(){
		return new Object[]{ 
			auth_obj_id
		};
	}


    /** 
    * auth_obj_id - 权限对象id 
    */
    private String auth_obj_id;

    /** 
    * auth_obj_name - 权限对象描述
    */
    private String auth_obj_name;


    public String getAuth_obj_id(){
        return this.auth_obj_id;
    }
    public void setAuth_obj_id(String auth_obj_id){
        this.auth_obj_id = auth_obj_id;
    }

    public String getAuth_obj_name(){
        return this.auth_obj_name;
    }
    public void setAuth_obj_name(String auth_obj_name){
        this.auth_obj_name = auth_obj_name;
    }

	public CIP_admin_auth_objVO toVO(){
		CIP_admin_auth_objVO vo = new CIP_admin_auth_objVO();
		
    	vo.setAuth_obj_id(auth_obj_id);
		vo.setAuth_obj_name(auth_obj_name);
		
		return vo;
	}
		
}