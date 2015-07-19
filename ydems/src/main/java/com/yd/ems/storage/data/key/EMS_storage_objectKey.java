package com.yd.ems.storage.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_storage_object - 设备信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_objectKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			obj_id
		};
	}
	
	public Object[] setKeys(long obj_id){
		return new Object[]{ 
			obj_id
		};
	}
	



    /** 
    * obj_id - 对象标识ID 
    */
    private long obj_id;

	private String remark;
	
	private String operateCode;
	
    public long getObj_id(){
        return this.obj_id;
    }
    
    public void setObj_id(long obj_id){
        this.obj_id = obj_id;
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