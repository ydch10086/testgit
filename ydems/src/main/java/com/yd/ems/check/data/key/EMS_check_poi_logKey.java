package com.yd.ems.check.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_check_poi_log - 设备日常点检日志</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_check_poi_logKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			poi_no
		};
	}
	
	public Object[] setKeys(long poi_no){
		return new Object[]{ 
			poi_no
		};
	}
	



    /** 
    * poi_no - 点检流水号 
    */
    private long poi_no;

	private String remark;
	
	private String operateCode;
	
    public long getPoi_no(){
        return this.poi_no;
    }
    
    public void setPoi_no(long poi_no){
        this.poi_no = poi_no;
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