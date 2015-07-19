package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_codes - 数据编码</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_codesKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			code_type,
					domain_id
		};
	}
	
	public Object[] setKeys(String code_type,String domain_id){
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

	private String remark;
	
	private String operateCode;
	
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