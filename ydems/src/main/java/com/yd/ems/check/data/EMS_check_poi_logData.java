package com.yd.ems.check.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_check_poi_log - 设备日常点检日志</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_check_poi_logData {


    /** 
    * poi_no - 点检流水号
    */
    private long poi_no;

    /** 
    * obj_id - 资产编码 
    */
    private long obj_id;

    /** 
    * poi_time - 点检时间 
    */
    private String poi_time;

    /** 
    * poi_org - 所属组织 
    */
    private int poi_org;

    /** 
    * mod_type_txt - 设备型号 
    */
    private String mod_type_txt;

    /** 
    * sup_code - 供应商 
    */
    private String sup_code;

    /** 
    * begin_date - 设备起始日 
    */
    private String begin_date;

    /** 
    * fault_txt - 故障描述 
    */
    private String fault_txt;

    /** 
    * che_op - 点检人 
    */
    private int che_op;

    /** 
    * exa_op - 审核人 
    */
    private int exa_op;

    private String sup_code_name;
    private String poi_org_name;
    
    public long getPoi_no(){
        return this.poi_no;
    }
    public void setPoi_no(long poi_no){
        this.poi_no = poi_no;
    }

    public long getObj_id(){
        return this.obj_id;
    }
    public void setObj_id(long obj_id){
        this.obj_id = obj_id;
    }

    public String getPoi_time(){
        return this.poi_time;
    }
    public void setPoi_time(String poi_time){
        this.poi_time = poi_time;
    }

    public int getPoi_org(){
        return this.poi_org;
    }
    public void setPoi_org(int poi_org){
        this.poi_org = poi_org;
    }

    public String getMod_type_txt(){
        return this.mod_type_txt;
    }
    public void setMod_type_txt(String mod_type_txt){
        this.mod_type_txt = mod_type_txt;
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

    public String getFault_txt(){
        return this.fault_txt;
    }
    public void setFault_txt(String fault_txt){
        this.fault_txt = fault_txt;
    }

    public int getChe_op(){
        return this.che_op;
    }
    public void setChe_op(int che_op){
        this.che_op = che_op;
    }

    public String getSup_code_name() {
		return sup_code_name;
	}
	public void setSup_code_name(String sup_code_name) {
		this.sup_code_name = sup_code_name;
	}
	public String getPoi_org_name() {
		return poi_org_name;
	}
	public void setPoi_org_name(String poi_org_name) {
		this.poi_org_name = poi_org_name;
	}
	public int getExa_op(){
        return this.exa_op;
    }
    public void setExa_op(int exa_op){
        this.exa_op = exa_op;
    }

}