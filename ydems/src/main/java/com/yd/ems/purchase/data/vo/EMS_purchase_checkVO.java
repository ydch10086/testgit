package com.yd.ems.purchase.data.vo;


import com.yd.ems.purchase.data.po.EMS_purchase_checkPO;

/**
 * <p>实体类</p>
 * <p>Table: em_purchase_check - 设备验收表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_purchase_checkVO {

	public Object[] getKeys(){
		return new Object[]{ 
			che_no
		};
	}


    /** 
    * che_no - 设备验收流水号 
    */
    private long che_no;
    /** 
    * che_obj - 对象标识 
    */
    private long che_obj;
    /** 
    * che_org - 操作机构组织 
    */
    private int che_org;
    /** 
    * sup_code - 验收供应商 
    */
    private String sup_code;
    /** 
    * che_date - 设备验收时间 
    */
    private String che_date;
    /** 
    * che_emp - 验收人员 
    */
    private int che_emp;
    /** 
    * result_type - 验收结果 
    */
    private String result_type;
    /** 
    * pro_emp - 整改跟进人员 
    */
    private int pro_emp;
    /** 
    * pro_txt - 整改结果 
    */
    private String pro_txt;
    /** 
    * plain_date - 整改要求完成时间 
    */
    private String plain_date;
    /** 
    * act_date - 整改实际完成时间 
    */
    private String act_date;
    /** 
    * pur_no - 采购计划流水号 
    */
    private long pur_no;
    /** 
    * che_status - 验收记录状态 
    */
    private String che_status;

    /** 
     * che_org_name - 操作机构组织 名称
     */
     private String che_org_name;
     /** 
      * sup_code_name - 验收供应商名称 
      */
      private String sup_code_name;
     public String getChe_org_name() {
		return che_org_name;
	}
	public void setChe_org_name(String che_org_name) {
		this.che_org_name = che_org_name;
	}
	public String getSup_code_name() {
		return sup_code_name;
	}
	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}

    
    public long getChe_no(){
        return this.che_no;
    }
    public void setChe_no(long che_no){
        this.che_no = che_no;
    }
    public long getChe_obj(){
        return this.che_obj;
    }
    public void setChe_obj(long che_obj){
        this.che_obj = che_obj;
    }
    public int getChe_org(){
        return this.che_org;
    }
    public void setChe_org(int che_org){
        this.che_org = che_org;
    }
    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }
    public String getChe_date(){
        return this.che_date;
    }
    public void setChe_date(String che_date){
        this.che_date = che_date;
    }
    public int getChe_emp(){
        return this.che_emp;
    }
    public void setChe_emp(int che_emp){
        this.che_emp = che_emp;
    }
    public String getResult_type(){
        return this.result_type;
    }
    public void setResult_type(String result_type){
        this.result_type = result_type;
    }
    public int getPro_emp(){
        return this.pro_emp;
    }
    public void setPro_emp(int pro_emp){
        this.pro_emp = pro_emp;
    }
    public String getPro_txt(){
        return this.pro_txt;
    }
    public void setPro_txt(String pro_txt){
        this.pro_txt = pro_txt;
    }
    public String getPlain_date(){
        return this.plain_date;
    }
    public void setPlain_date(String plain_date){
        this.plain_date = plain_date;
    }
    public String getAct_date(){
        return this.act_date;
    }
    public void setAct_date(String act_date){
        this.act_date = act_date;
    }
    public long getPur_no(){
        return this.pur_no;
    }
    public void setPur_no(long pur_no){
        this.pur_no = pur_no;
    }
    public String getChe_status(){
        return this.che_status;
    }
    public void setChe_status(String che_status){
        this.che_status = che_status;
    }

	public EMS_purchase_checkPO toPO(){
		EMS_purchase_checkPO po = new EMS_purchase_checkPO();
		
    	po.setChe_no(che_no);
		po.setChe_obj(che_obj);
		po.setChe_org(che_org);
		po.setSup_code(sup_code);
		po.setChe_date(che_date);
		po.setChe_emp(che_emp);
		po.setResult_type(result_type);
		po.setPro_emp(pro_emp);
		po.setPro_txt(pro_txt);
		po.setPlain_date(plain_date);
		po.setAct_date(act_date);
		po.setPur_no(pur_no);
		po.setChe_status(che_status);
		return po;
	}
		
}