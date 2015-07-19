package com.yd.common.function.admin.data.po;


import com.yd.common.function.admin.data.vo.CIP_admin_op_logVO;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_op_log - 系统操作日志</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_op_logPO {
	
	public static CIP_admin_op_logPO getLog(String tableId, String key, String opType, String remark, CIPRuntimeOperator operateInf){
		CIP_admin_op_logPO log = new CIP_admin_op_logPO();
		log.setOp_seq_no(System.currentTimeMillis());
		log.setOp_table_id(tableId);
		log.setOp_obj_id(key);
		log.setOp_type(opType);
		log.setRemark(remark);
		log.setOperator(operateInf.getSubject_id());
		log.setCreate_time(operateInf.getOperate_tm());
		return log;
	}
	
	public static final String OP_TYPE_LOCK	 	 = "L";//锁定
	public static final String OP_TYPE_UNLOCK	 = "U";//解锁
	public static final String OP_TYPE_AUDIT	 = "A";//审核通过
	public static final String OP_TYPE_REJECT	 = "R";//审核回退
	public static final String OP_TYPE_ADD	 	 = "I";//新增
	public static final String OP_TYPE_UPDATE	 = "M";//修改
	public static final String OP_TYPE_DELETE	 = "D";//删除
	public static final String OP_TYPE_SEARCH	 = "S";//查询
	public static final String OP_TYPE_QUERY	 = "Q";//查看
	public static final String OP_TYPE_EXPORT 	 = "E"; //导出
	public static final String OP_TYPE_IMPORT 	 = "P"; //导入
	
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

    /** 
    * create_time - 系统时间
    */
    private String create_time;

    /** 
    * operator - 操作人员
    */
    private String operator;


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

	public CIP_admin_op_logVO toVO(){
		CIP_admin_op_logVO vo = new CIP_admin_op_logVO();
		
    	vo.setOp_seq_no(op_seq_no);
		vo.setOp_table_id(op_table_id);
		vo.setOp_obj_id(op_obj_id);
		vo.setOp_type(op_type);
		vo.setRemark(remark);
		
		return vo;
	}
		
}