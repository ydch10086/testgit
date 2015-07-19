package com.yd.ems.storage.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_storage_inout_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_inout_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
				inout_id
		};
	}
	
	public Object[] setKeys(int typ_type){
		return new Object[]{ 
				inout_id
		};
	}
	



    /** 
    * inout_id - 库存操作流水号
    */
    private String inout_id;

	private String remark;
	
	private String operateCode;

	public String getInout_id() {
		return inout_id;
	}

	public void setInout_id(String inout_id) {
		this.inout_id = inout_id;
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