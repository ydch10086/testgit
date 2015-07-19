package com.yd.ems.mainten.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_mainten_log - 设备保养日志表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_logKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			mainten_no
		};
	}
	
	public Object[] setKeys(long mainten_no){
		return new Object[]{ 
			mainten_no
		};
	}
	



    /** 
    * mainten_no - 保养流水号 
    */
    private long mainten_no;

	private String remark;
	
	private String operateCode;
	
    public long getMainten_no(){
        return this.mainten_no;
    }
    
    public void setMainten_no(long mainten_no){
        this.mainten_no = mainten_no;
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