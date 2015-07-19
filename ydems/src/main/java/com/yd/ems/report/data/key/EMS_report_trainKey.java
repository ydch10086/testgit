package com.yd.ems.report.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_report_train - 设备培训方案表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_report_trainKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			train_no
		};
	}
	
	public Object[] setKeys(long train_no){
		return new Object[]{ 
			train_no
		};
	}
	



    /** 
    * train_no - 培训流水号 
    */
    private long train_no;

	private String remark;
	
	private String operateCode;
	
    public long getTrain_no(){
        return this.train_no;
    }
    
    public void setTrain_no(long train_no){
        this.train_no = train_no;
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