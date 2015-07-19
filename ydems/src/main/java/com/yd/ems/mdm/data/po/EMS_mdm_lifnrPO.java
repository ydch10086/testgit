package com.yd.ems.mdm.data.po;


import com.yd.ems.mdm.data.vo.EMS_mdm_lifnrVO;

/**
 * <p>实体类</p>
 * <p>Table: em_mdm_lifnr - 供应商基础信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_lifnrPO {

	public Object[] getKeys(){
		return new Object[]{ 
			sup_code
		};
	}


    /** 
    * sup_code - 供应商编码 
    */
    private String sup_code;

    /** 
    * sup_code_name - 供应商名称
    */
    private String sup_code_name;

    /** 
    * sup_status - 使用状态
    */
    private String sup_status;

    /** 
    * sup_adress - 联系地址
    */
    private String sup_adress;

    /** 
    * sup_contact - 联系电话
    */
    private int sup_contact;

    /** 
    * operator - 修改者
    */
    private int operator;

    /** 
    * op_time - 修改日期
    */
    private String op_time;


    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }

    public String getSup_code_name(){
        return this.sup_code_name;
    }
    public void setSup_code_name(String sup_code_name){
        this.sup_code_name = sup_code_name;
    }

    public String getSup_status(){
        return this.sup_status;
    }
    public void setSup_status(String sup_status){
        this.sup_status = sup_status;
    }

    public String getSup_adress(){
        return this.sup_adress;
    }
    public void setSup_adress(String sup_adress){
        this.sup_adress = sup_adress;
    }

    public int getSup_contact(){
        return this.sup_contact;
    }
    public void setSup_contact(int sup_contact){
        this.sup_contact = sup_contact;
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

	public EMS_mdm_lifnrVO toVO(){
		EMS_mdm_lifnrVO vo = new EMS_mdm_lifnrVO();
		
    	vo.setSup_code(sup_code);
		vo.setSup_code_name(sup_code_name);
		vo.setSup_status(sup_status);
		vo.setSup_adress(sup_adress);
		vo.setSup_contact(sup_contact);
		
		return vo;
	}
		
}