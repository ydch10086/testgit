package com.yd.ems.check.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_check_log - 设备日常巡检日志</p>
 *
 * @since 2015-05-29 02:42:11
 */
public class EMS_check_logKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			check_are,
					check_beg_time,
					check_end_time,
					check_org
		};
	}
	
	public Object[] setKeys(String check_are,String check_beg_time,String check_end_time,int check_org){
		return new Object[]{ 
			check_are,
					check_beg_time,
					check_end_time,
					check_org
		};
	}
	



    /** 
    * check_are - 巡检区域 
    */
    private String check_are;

    /** 
    * check_beg_time - 巡检开始时间 
    */
    private String check_beg_time;

    /** 
    * check_end_time - 巡检结束时间 
    */
    private String check_end_time;

    /** 
    * check_org - 分拨中心 
    */
    private int check_org;

	private String remark;
	
	private String operateCode;
	
    public String getCheck_are(){
        return this.check_are;
    }
    
    public void setCheck_are(String check_are){
        this.check_are = check_are;
    }
    public String getCheck_beg_time(){
        return this.check_beg_time;
    }
    
    public void setCheck_beg_time(String check_beg_time){
        this.check_beg_time = check_beg_time;
    }
    public String getCheck_end_time(){
        return this.check_end_time;
    }
    
    public void setCheck_end_time(String check_end_time){
        this.check_end_time = check_end_time;
    }
    public int getCheck_org(){
        return this.check_org;
    }
    
    public void setCheck_org(int check_org){
        this.check_org = check_org;
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