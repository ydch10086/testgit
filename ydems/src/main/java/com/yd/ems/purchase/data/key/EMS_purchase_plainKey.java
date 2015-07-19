package com.yd.ems.purchase.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_purchase_plain - 设备采购计划表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_purchase_plainKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			pur_no
		};
	}
	
	public Object[] setKeys(long pur_no){
		return new Object[]{ 
			pur_no
		};
	}
	



    /** 
    * pur_no - 采购计划流水号 
    */
    private long pur_no;

	private String remark;
	
	private String operateCode;
	
	private int pur_org_name;
	  private String sup_code_name;
	  private String pur_unit_name;
	 public int getPur_org_name() {
		return pur_org_name;
	}

	public void setPur_org_name(int pur_org_name) {
		this.pur_org_name = pur_org_name;
	}

	public String getSup_code_name() {
		return sup_code_name;
	}

	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}

	public String getPur_unit_name() {
		return pur_unit_name;
	}

	public void setPur_unit_name(String pur_unit_name) {
		this.pur_unit_name = pur_unit_name;
	}

    public long getPur_no(){
        return this.pur_no;
    }
    
    public void setPur_no(long pur_no){
        this.pur_no = pur_no;
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