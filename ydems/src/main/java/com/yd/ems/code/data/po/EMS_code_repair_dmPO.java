package com.yd.ems.code.data.po;


import com.yd.ems.code.data.vo.EMS_code_repair_dmVO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_repair_dm - 维修类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_repair_dmPO {

	public Object[] getKeys(){
		return new Object[]{ 
			rep_type
		};
	}


    /** 
    * rep_type - 维修类型 
    */
    private int rep_type;

    /** 
    * rep_type_name - 维修类型描述
    */
    private String rep_type_name;

    /** 
    * rep_status - 使用状态
    */
    private String rep_status;

    /** 
    * operator - 修改者
    */
    private int operator;

    /** 
    * op_time - 修改时间
    */
    private String op_time;


    public int getRep_type(){
        return this.rep_type;
    }
    public void setRep_type(int rep_type){
        this.rep_type = rep_type;
    }

    public String getRep_type_name(){
        return this.rep_type_name;
    }
    public void setRep_type_name(String rep_type_name){
        this.rep_type_name = rep_type_name;
    }

    public String getRep_status(){
        return this.rep_status;
    }
    public void setRep_status(String rep_status){
        this.rep_status = rep_status;
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

	public EMS_code_repair_dmVO toVO(){
		EMS_code_repair_dmVO vo = new EMS_code_repair_dmVO();
		
    	vo.setRep_type(rep_type);
		vo.setRep_type_name(rep_type_name);
		vo.setRep_status(rep_status);
		
		return vo;
	}
		
}