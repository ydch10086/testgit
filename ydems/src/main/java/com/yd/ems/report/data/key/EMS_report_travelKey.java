package com.yd.ems.report.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_report_travel - 人员出差报告</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_report_travelKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			travel_no
		};
	}
	
	public Object[] setKeys(long travel_no){
		return new Object[]{ 
			travel_no
		};
	}
	



    /** 
    * travel_no - 出差报告流水号 
    */
    private long travel_no;

	private String remark;
	
	private String operateCode;
	
    public long getTravel_no(){
        return this.travel_no;
    }
    
    public void setTravel_no(long travel_no){
        this.travel_no = travel_no;
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