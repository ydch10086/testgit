package com.yd.ems.code.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_fault_dm - 故障类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_fault_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			fau_type
		};
	}
	
	public Object[] setKeys(int fau_type){
		return new Object[]{ 
			fau_type
		};
	}
	



    /** 
    * fau_type - 故障类型 
    */
    private int fau_type;

	private String remark;
	
	private String operateCode;
	
    public int getFau_type(){
        return this.fau_type;
    }
    
    public void setFau_type(int fau_type){
        this.fau_type = fau_type;
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