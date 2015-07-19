package com.yd.ems.code.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_type_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_type_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			typ_type
		};
	}
	
	public Object[] setKeys(int typ_type){
		return new Object[]{ 
			typ_type
		};
	}
	



    /** 
    * typ_type - 对象类型编码 
    */
    private int typ_type;

	private String remark;
	
	private String operateCode;
	
    public int getTyp_type(){
        return this.typ_type;
    }
    
    public void setTyp_type(int typ_type){
        this.typ_type = typ_type;
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