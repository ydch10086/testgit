package com.yd.ems.mdm.data.vo;


import com.yd.ems.mdm.data.po.EMS_mdm_orgehPO;

/**
 * <p>实体类</p>
 * <p>Table: em_mdm_orgeh - 组织机构主数据</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_orgehVO {

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

	public EMS_mdm_orgehPO toPO(){
		EMS_mdm_orgehPO po = new EMS_mdm_orgehPO();
		
    	po.setOrg_id(org_id);
		po.setOrg_name(org_name);
		po.setOrg_status(org_status);
		po.setOrg_fat_id(org_fat_id);
		
		return po;
	}
		
}