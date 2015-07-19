package com.yd.ems.purchase.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_purchase_check - 设备验收表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_purchase_checkKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			che_no
		};
	}
	
	public Object[] setKeys(long che_no){
		return new Object[]{ 
			che_no
		};
	}
	



    /** 
    * che_no - 设备验收流水号 
    */
    private long che_no;

	private String remark;
	
	private String operateCode;
	
    public long getChe_no(){
        return this.che_no;
    }
    
    public void setChe_no(long che_no){
        this.che_no = che_no;
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