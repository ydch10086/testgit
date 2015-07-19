package com.yd.ems.storage.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_storage_inrecord_dm - 入库记录</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_inrecord_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
				inrecord_id
		};
	}
	
	public Object[] setKeys(int typ_type){
		return new Object[]{ 
				inrecord_id
		};
	}
	/**
	 * 入库库标示
	 */
	private String inrecord_id;
    private String remark;
	private String operateCode;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperateCode() {
		return operateCode;
	}

	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}
	public String getInrecord_id() {
		return inrecord_id;
	}

	public void setInrecord_id(String inrecord_id) {
		this.inrecord_id = inrecord_id;
	}

		
}