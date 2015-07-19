package com.yd.ems.code.data.po;


import com.yd.ems.code.data.vo.EMS_code_fault_dmVO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_fault_dm - 故障类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_fault_dmPO {

	public Object[] getKeys(){
		return new Object[]{ 
			fau_type
		};
	}


    /** 
    * fau_type - 故障类型 
    */
    private int fau_type;

    /** 
    * fau_type_name - 故障类型描述
    */
    private String fau_type_name;

    /** 
    * fau_status - 使用状态
    */
    private String fau_status;

    /** 
    * operator - 修改者
    */
    private int operator;

    /** 
    * op_time - 修改日期
    */
    private String op_time;


    public int getFau_type(){
        return this.fau_type;
    }
    public void setFau_type(int fau_type){
        this.fau_type = fau_type;
    }

    public String getFau_type_name(){
        return this.fau_type_name;
    }
    public void setFau_type_name(String fau_type_name){
        this.fau_type_name = fau_type_name;
    }

    public String getFau_status(){
        return this.fau_status;
    }
    public void setFau_status(String fau_status){
        this.fau_status = fau_status;
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

	public EMS_code_fault_dmVO toVO(){
		EMS_code_fault_dmVO vo = new EMS_code_fault_dmVO();
		
    	vo.setFau_type(fau_type);
		vo.setFau_type_name(fau_type_name);
		vo.setFau_status(fau_status);
		
		return vo;
	}
		
}