package com.yd.ems.mdm.data.po;


import com.yd.ems.mdm.data.vo.EMS_mdm_orgehVO;

/**
 * <p>实体类</p>
 * <p>Table: em_mdm_orgeh - 组织机构主数据</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_orgehPO {

	public Object[] getKeys(){
		return new Object[]{ 
			org_id
		};
	}


    /** 
    * org_id - 组织编码 
    */
    private int org_id;

    /** 
    * org_name - 组织描述
    */
    private String org_name;

    /** 
    * org_status - 使用状态
    */
    private String org_status;

    /** 
    * org_fat_id - 父级编码
    */
    private int org_fat_id;

    /** 
    * operator - 修改者
    */
    private String operator;

    /** 
    * op_time - 修改日期
    */
    private String op_time;


    public int getOrg_id(){
        return this.org_id;
    }
    public void setOrg_id(int org_id){
        this.org_id = org_id;
    }

    public String getOrg_name(){
        return this.org_name;
    }
    public void setOrg_name(String org_name){
        this.org_name = org_name;
    }

    public String getOrg_status(){
        return this.org_status;
    }
    public void setOrg_status(String org_status){
        this.org_status = org_status;
    }

    public int getOrg_fat_id(){
        return this.org_fat_id;
    }
    public void setOrg_fat_id(int org_fat_id){
        this.org_fat_id = org_fat_id;
    }

    public String getOperator(){
        return this.operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

    public String getOp_time(){
        return this.op_time;
    }
    public void setOp_time(String op_time){
        this.op_time = op_time;
    }

	public EMS_mdm_orgehVO toVO(){
		EMS_mdm_orgehVO vo = new EMS_mdm_orgehVO();
		
    	vo.setOrg_id(org_id);
		vo.setOrg_name(org_name);
		vo.setOrg_status(org_status);
		vo.setOrg_fat_id(org_fat_id);
		
		return vo;
	}
		
}