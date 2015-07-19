package com.yd.common.function.admin.data.vo;


import com.yd.common.function.admin.data.po.CIP_admin_op_logPO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_op_log - 系统操作日志</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_op_logVO {

	public Object[] getKeys(){
		return new Object[]{ 
			op_seq_no
		};
	}


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

	public CIP_admin_op_logPO toPO(){
		CIP_admin_op_logPO po = new CIP_admin_op_logPO();
		
    	po.setOp_seq_no(op_seq_no);
		po.setOp_table_id(op_table_id);
		po.setOp_obj_id(op_obj_id);
		po.setOp_type(op_type);
		po.setRemark(remark);
		
		return po;
	}
		
}