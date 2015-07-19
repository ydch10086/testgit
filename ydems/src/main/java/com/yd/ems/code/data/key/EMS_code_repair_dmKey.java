package com.yd.ems.code.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_repair_dm - 维修类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_repair_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			rep_type
		};
	}
	
	public Object[] setKeys(int rep_type){
		return new Object[]{ 
			rep_type
		};
	}
	



    /** 
    * rep_type - 维修类型 
    */
    private int rep_type;

	private String remark;
	
	private String operateCode;
	
    public int getRep_type(){
        return this.rep_type;
    }
    
    public void setRep_type(int rep_type){
        this.rep_type = rep_type;
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