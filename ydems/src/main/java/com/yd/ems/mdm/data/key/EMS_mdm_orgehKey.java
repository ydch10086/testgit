package com.yd.ems.mdm.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_mdm_orgeh - 组织机构主数据</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_orgehKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			org_id
		};
	}
	
	public Object[] setKeys(int org_id){
		return new Object[]{ 
			org_id
		};
	}
	



    /** 
    * org_id - 组织编码 
    */
    private int org_id;

	private String remark;
	
	private String operateCode;
	
    public int getOrg_id(){
        return this.org_id;
    }
    
    public void setOrg_id(int org_id){
        this.org_id = org_id;
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