package com.yd.ems.check.data.po;


import com.yd.ems.check.data.vo.EMS_check_poi_logVO;

/**
 * <p>实体类</p>
 * <p>Table: em_check_poi_log - 设备日常点检日志</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_check_poi_logPO {

	public Object[] getKeys(){
		return new Object[]{ 
			poi_no
		};
	}


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

    public int getExa_op(){
        return this.exa_op;
    }
    public void setExa_op(int exa_op){
        this.exa_op = exa_op;
    }

	public EMS_check_poi_logVO toVO(){
		EMS_check_poi_logVO vo = new EMS_check_poi_logVO();
		
    	vo.setPoi_no(poi_no);
		vo.setObj_id(obj_id);
		vo.setPoi_time(poi_time);
		vo.setPoi_org(poi_org);
		vo.setMod_type_txt(mod_type_txt);
		vo.setSup_code(sup_code);
		vo.setBegin_date(begin_date);
		vo.setFault_txt(fault_txt);
		vo.setChe_op(che_op);
		vo.setExa_op(exa_op);
		
		return vo;
	}
		
}