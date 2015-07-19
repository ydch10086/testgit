package com.yd.ems.storage.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_storage_log - 备品备件工具库存日志</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_logKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			rep_no
		};
	}
	
	public Object[] setKeys(long rep_no){
		return new Object[]{ 
			rep_no
		};
	}
	



    /** 
    * rep_no - 日志流水号 
    */
    private long rep_no;

	private String remark;
	
	private String operateCode;
	
    public long getRep_no(){
        return this.rep_no;
    }
    
    public void setRep_no(long rep_no){
        this.rep_no = rep_no;
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