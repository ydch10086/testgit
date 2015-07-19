package com.yd.common.function.admin.data.vo;


import com.yd.common.function.admin.data.po.CIP_admin_codesPO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_codes - 数据编码</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_codesVO {

	public Object[] getKeys(){
		return new Object[]{ 
			code_type,
					domain_id
		};
	}


    /** 
    * code_type - 编码类型 
    */
    private String code_type;

    /** 
    * domain_id - 数据域id 
    */
    private String domain_id;
    /** 
    * code_name - 编码名称 
    */
    private String code_name;

    public String getCode_type(){
        return this.code_type;
    }
    public void setCode_type(String code_type){
        this.code_type = code_type;
    }
    public String getDomain_id(){
        return this.domain_id;
    }
    public void setDomain_id(String domain_id){
        this.domain_id = domain_id;
    }
    public String getCode_name(){
        return this.code_name;
    }
    public void setCode_name(String code_name){
        this.code_name = code_name;
    }

	public CIP_admin_codesPO toPO(){
		CIP_admin_codesPO po = new CIP_admin_codesPO();
		
    	po.setCode_type(code_type);
    	po.setDomain_id(domain_id);
		po.setCode_name(code_name);
		
		return po;
	}
		
}