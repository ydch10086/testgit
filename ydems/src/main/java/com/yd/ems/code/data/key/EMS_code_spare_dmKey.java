package com.yd.ems.code.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_type_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_spare_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
				spare_id
		};
	}
	
	public Object[] setKeys(int typ_type){
		return new Object[]{ 
				spare_id
		};
	}
	



    /** 
    * spare_id - 备品备品工具类表示
    */
    private long spare_id;

	private String remark;
	
	private String operateCode;
	
	public long getSpare_id() {
		return spare_id;
	}

	public void setSpare_id(long spare_id) {
		this.spare_id = spare_id;
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