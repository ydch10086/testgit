package com.yd.ems.report.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_report_train - 设备培训方案表</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:14
 */
public class EMS_report_trainData {


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

    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;


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

    public int getOperator(){
        return this.operator;
    }
    public void setOperator(int operator){
        this.operator = operator;
    }

    public String getOp_time(){
        return this.op_time;
    }
    public void setOp_time(String op_time){
        this.op_time = op_time;
    }

}