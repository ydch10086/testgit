package com.yd.ems.storage.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_type_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_outrecord_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
				outrecord_id
		};
	}
	
	public Object[] setKeys(int typ_type){
		return new Object[]{ 
				outrecord_id
		};
	}
	/**
	 * 出库标示
	 */
	private String outrecord_id;
	public String getOutrecord_id() {
		return outrecord_id;
	}

	public void setOutrecord_id(String outrecord_id) {
		this.outrecord_id = outrecord_id;
	}

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
	private String remark;
	
	private String operateCode;

		
}