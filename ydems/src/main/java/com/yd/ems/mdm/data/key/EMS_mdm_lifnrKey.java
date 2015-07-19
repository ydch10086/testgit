package com.yd.ems.mdm.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_mdm_lifnr - 供应商基础信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_lifnrKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			sup_code
		};
	}
	
	public Object[] setKeys(String sup_code){
		return new Object[]{ 
			sup_code
		};
	}
	



    /** 
    * sup_code - 供应商编码 
    */
    private String sup_code;

	private String remark;
	
	private String operateCode;
	
    public String getSup_code(){
        return this.sup_code;
    }
    
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
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