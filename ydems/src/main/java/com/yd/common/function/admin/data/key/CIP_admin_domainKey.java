package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_domain - 数据域信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_domainKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			domain_id
		};
	}
	
	public Object[] setKeys(String domain_id){
		return new Object[]{ 
			domain_id
		};
	}
	



    /** 
    * domain_id - 数据域id 
    */
    private String domain_id;

	private String remark;
	
	private String operateCode;
	
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