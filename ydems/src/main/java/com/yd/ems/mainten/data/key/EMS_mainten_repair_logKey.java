package com.yd.ems.mainten.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_mainten_repair_log - 设备维修日志表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_repair_logKey {	
	
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
    * rep_no - 维修流水号 
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