package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_op_log - 系统操作日志</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_op_logKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			op_seq_no
		};
	}
	
	public Object[] setKeys(Long op_seq_no){
		return new Object[]{ 
			op_seq_no
		};
	}
	



    /** 
    * op_seq_no - 操作流水号 
    */
    private Long op_seq_no;

	private String remark;
	
	private String operateCode;
	
    public Long getOp_seq_no(){
        return this.op_seq_no;
    }
    
    public void setOp_seq_no(Long op_seq_no){
        this.op_seq_no = op_seq_no;
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