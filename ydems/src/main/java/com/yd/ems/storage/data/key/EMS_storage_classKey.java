package com.yd.ems.storage.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_storage_class - 备品备件工具类</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_classKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			cla_id
		};
	}
	
	public Object[] setKeys(long cla_id){
		return new Object[]{ 
			cla_id
		};
	}
	



    /** 
    * cla_id - 对象类标识 
    */
    private long cla_id;

	private String remark;
	
	private String operateCode;
	
    public long getCla_id(){
        return this.cla_id;
    }
    
    public void setCla_id(long cla_id){
        this.cla_id = cla_id;
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