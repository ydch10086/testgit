package com.yd.ems.report.data.vo;


import com.yd.ems.report.data.po.EMS_report_trainPO;

/**
 * <p>实体类</p>
 * <p>Table: em_report_train - 设备培训方案表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_report_trainVO {

	public Object[] getKeys(){
		return new Object[]{ 
			train_no
		};
	}


    /** 
    * train_no - 培训流水号 
    */
    private long train_no;
    /** 
    * train_purchse - 培训目的 
    */
    private String train_purchse;
    /** 
    * train_object - 培训对象 
    */
    private String train_object;
    /** 
    * train_comment - 培训内容 
    */
    private String train_comment;
    /** 
    * train_teacher - 培训讲师 
    */
    private String train_teacher;
    /** 
    * train_time - 培训时间 
    */
    private String train_time;

    public long getTrain_no(){
        return this.train_no;
    }
    public void setTrain_no(long train_no){
        this.train_no = train_no;
    }
    public String getTrain_purchse(){
        return this.train_purchse;
    }
    public void setTrain_purchse(String train_purchse){
        this.train_purchse = train_purchse;
    }
    public String getTrain_object(){
        return this.train_object;
    }
    public void setTrain_object(String train_object){
        this.train_object = train_object;
    }
    public String getTrain_comment(){
        return this.train_comment;
    }
    public void setTrain_comment(String train_comment){
        this.train_comment = train_comment;
    }
    public String getTrain_teacher(){
        return this.train_teacher;
    }
    public void setTrain_teacher(String train_teacher){
        this.train_teacher = train_teacher;
    }
    public String getTrain_time(){
        return this.train_time;
    }
    public void setTrain_time(String train_time){
        this.train_time = train_time;
    }

	public EMS_report_trainPO toPO(){
		EMS_report_trainPO po = new EMS_report_trainPO();
		
    	po.setTrain_no(train_no);
		po.setTrain_purchse(train_purchse);
		po.setTrain_object(train_object);
		po.setTrain_comment(train_comment);
		po.setTrain_teacher(train_teacher);
		po.setTrain_time(train_time);
		
		return po;
	}
		
}