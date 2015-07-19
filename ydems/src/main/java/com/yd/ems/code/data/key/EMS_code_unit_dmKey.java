package com.yd.ems.code.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_unit_dm - 单位</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_unit_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			unit_code
		};
	}
	
	public Object[] setKeys(int unit_code){
		return new Object[]{ 
			unit_code
		};
	}
	



    /** 
    * unit_code - 单位编码 
    */
    private int unit_code;

	private String remark;
	
	private String operateCode;
	
    public int getUnit_code(){
        return this.unit_code;
    }
    
    public void setUnit_code(int unit_code){
        this.unit_code = unit_code;
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