package com.yd.ems.mainten.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_mainten_scrap_plan - 设备报废计划表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_scrap_planKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			scrap_no
		};
	}
	
	public Object[] setKeys(long scrap_no){
		return new Object[]{ 
			scrap_no
		};
	}
	



    /** 
    * scrap_no - 报废流水号 
    */
    private long scrap_no;

	private String remark;
	
	private String operateCode;
	
    public long getScrap_no(){
        return this.scrap_no;
    }
    
    public void setScrap_no(long scrap_no){
        this.scrap_no = scrap_no;
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