package com.yd.ems.mainten.data.vo;


import com.yd.ems.mainten.data.po.EMS_mainten_scrap_planPO;

/**
 * <p>实体类</p>
 * <p>Table: em_mainten_scrap_plan - 设备报废计划表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_scrap_planVO {

	public Object[] getKeys(){
		return new Object[]{ 
			scrap_no
		};
	}


    /** 
    * scrap_no - 报废流水号 
    */
    private long scrap_no;
    /** 
    * obj_id - 设备编码 
    */
    private long obj_id;
    /** 
    * scrap_org - 所属组织 
    */
    private int scrap_org;
    /** 
    * sup_code - 供应商 
    */
    private String sup_code;
    /** 
    * begin_date - 设备起始日 
    */
    private String begin_date;
    /** 
    * status_txt - 设备状态 
    */
    private String status_txt;
    /** 
    * theory_date - 理论报废日期 
    */
    private String theory_date;
    /** 
    * act_date - 实际报废日期 
    */
    private String act_date;
    /** 
    * start_op - 发起人 
    */
    private int start_op;
    /** 
    * examine_op - 审核人 
    */
    private int examine_op;
   
    /**
     * 审核状态
     * @return
     */
    private int examine_status;
    public long getScrap_no(){
        return this.scrap_no;
    }
    public void setScrap_no(long scrap_no){
        this.scrap_no = scrap_no;
    }
    public long getObj_id(){
        return this.obj_id;
    }
    public void setObj_id(long obj_id){
        this.obj_id = obj_id;
    }
    public int getScrap_org(){
        return this.scrap_org;
    }
    public void setScrap_org(int scrap_org){
        this.scrap_org = scrap_org;
    }
    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }
    public String getBegin_date(){
        return this.begin_date;
    }
    public void setBegin_date(String begin_date){
        this.begin_date = begin_date;
    }
    public String getStatus_txt(){
        return this.status_txt;
    }
    public void setStatus_txt(String status_txt){
        this.status_txt = status_txt;
    }
    public String getTheory_date(){
        return this.theory_date;
    }
    public void setTheory_date(String theory_date){
        this.theory_date = theory_date;
    }
    public String getAct_date(){
        return this.act_date;
    }
    public void setAct_date(String act_date){
        this.act_date = act_date;
    }
    public int getStart_op(){
        return this.start_op;
    }
    public void setStart_op(int start_op){
        this.start_op = start_op;
    }
    public int getExamine_op(){
        return this.examine_op;
    }
    public void setExamine_op(int examine_op){
        this.examine_op = examine_op;
    }

	public int getExamine_status() {
		return examine_status;
	}
	public void setExamine_status(int examine_status) {
		this.examine_status = examine_status;
	}
	public EMS_mainten_scrap_planPO toPO(){
		EMS_mainten_scrap_planPO po = new EMS_mainten_scrap_planPO();
		
    	po.setScrap_no(scrap_no);
		po.setObj_id(obj_id);
		po.setScrap_org(scrap_org);
		po.setSup_code(sup_code);
		po.setBegin_date(begin_date);
		po.setStatus_txt(status_txt);
		po.setTheory_date(theory_date);
		po.setAct_date(act_date);
		po.setStart_op(start_op);
		return po;
	}
	public EMS_mainten_scrap_planPO toScrapPO(){
		EMS_mainten_scrap_planPO po = new EMS_mainten_scrap_planPO();
		
    	po.setScrap_no(scrap_no);
		po.setObj_id(obj_id);
		po.setScrap_org(scrap_org);
		po.setSup_code(sup_code);
		po.setBegin_date(begin_date);
		po.setStatus_txt(status_txt);
		po.setTheory_date(theory_date);
		po.setAct_date(act_date);
		po.setStart_op(start_op);
		po.setExamine_op(examine_op);
		po.setExamine_status(examine_status);
		return po;
	}
}