package com.yd.common.function.admin.data;


/**
 * <p>Data实体类</p>
 * <p>View: cip_admin_op_log - 系统操作日志</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_op_logData {


    /** 
    * op_seq_no - 操作流水号
    */
    private Long op_seq_no;

    /** 
    * op_table_id - 操作对象类型 
    */
    private String op_table_id;

    /** 
    * op_obj_id - 操作对象id 
    */
    private String op_obj_id;

    /** 
    * op_type - 操作类型 
    */
    private String op_type;

    /** 
    * remark - 操作备注 
    */
    private String remark;

    /** 
    * create_time - 系统时间 
    */
    private String create_time;

    /** 
    * operator - 操作人员 
    */
    private String operator;
	/**
	* 文本描述信息
	*/
	private String op_type_name;


    public Long getOp_seq_no(){
        return this.op_seq_no;
    }
    public void setOp_seq_no(Long op_seq_no){
        this.op_seq_no = op_seq_no;
    }

    public String getOp_table_id(){
        return this.op_table_id;
    }
    public void setOp_table_id(String op_table_id){
        this.op_table_id = op_table_id;
    }

    public String getOp_obj_id(){
        return this.op_obj_id;
    }
    public void setOp_obj_id(String op_obj_id){
        this.op_obj_id = op_obj_id;
    }

    public String getOp_type(){
        return this.op_type;
    }
    public void setOp_type(String op_type){
        this.op_type = op_type;
    }

    public String getRemark(){
        return this.remark;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }

    public String getCreate_time(){
        return this.create_time;
    }
    public void setCreate_time(String create_time){
        this.create_time = create_time;
    }

    public String getOperator(){
        return this.operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

	public String getOp_type_name(){
        return this.op_type_name;
    }
    public void setOp_type_name(String op_type_name){
        this.op_type_name = op_type_name;
    }
    
}