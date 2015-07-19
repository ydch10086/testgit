package com.yd.ems.storage.data.vo;

import java.math.BigDecimal;

import com.yd.ems.storage.data.po.EMS_storage_logPO;

/**
 * <p>实体类</p>
 * <p>Table: em_storage_log - 备品备件工具库存日志</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_logVO {

	public Object[] getKeys(){
		return new Object[]{ 
			rep_no
		};
	}


    /** 
    * rep_no - 日志流水号 
    */
    private long rep_no;
    /** 
    * cla_id - 类标识 
    */
    private long cla_id;
    /** 
    * bus_time - 业务时间 
    */
    private String bus_time;
    /** 
    * begin_quan - 期初库存 
    */
    private BigDecimal begin_quan;
    /** 
    * act_quan - 本期发生 
    */
    private BigDecimal act_quan;
    /** 
    * end_quan - 期末库存 
    */
    private BigDecimal end_quan;
    /** 
    * rep_unit - 库存单位 
    */
    private String rep_unit;
    /** 
    * op_type - 操作类型 
    */
    private String op_type;
    /** 
    * op_org - 操作机构 
    */
    private int op_org;
    /** 
    * to_org - 目标机构 
    */
    private int to_org;
    /** 
    * from_org - 源机构 
    */
    private int from_org;

    public long getRep_no(){
        return this.rep_no;
    }
    public void setRep_no(long rep_no){
        this.rep_no = rep_no;
    }
    public long getCla_id(){
        return this.cla_id;
    }
    public void setCla_id(long cla_id){
        this.cla_id = cla_id;
    }
    public String getBus_time(){
        return this.bus_time;
    }
    public void setBus_time(String bus_time){
        this.bus_time = bus_time;
    }
    public BigDecimal getBegin_quan(){
        return this.begin_quan;
    }
    public void setBegin_quan(BigDecimal begin_quan){
        this.begin_quan = begin_quan;
    }
    public BigDecimal getAct_quan(){
        return this.act_quan;
    }
    public void setAct_quan(BigDecimal act_quan){
        this.act_quan = act_quan;
    }
    public BigDecimal getEnd_quan(){
        return this.end_quan;
    }
    public void setEnd_quan(BigDecimal end_quan){
        this.end_quan = end_quan;
    }
    public String getRep_unit(){
        return this.rep_unit;
    }
    public void setRep_unit(String rep_unit){
        this.rep_unit = rep_unit;
    }
    public String getOp_type(){
        return this.op_type;
    }
    public void setOp_type(String op_type){
        this.op_type = op_type;
    }
    public int getOp_org(){
        return this.op_org;
    }
    public void setOp_org(int op_org){
        this.op_org = op_org;
    }
    public int getTo_org(){
        return this.to_org;
    }
    public void setTo_org(int to_org){
        this.to_org = to_org;
    }
    public int getFrom_org(){
        return this.from_org;
    }
    public void setFrom_org(int from_org){
        this.from_org = from_org;
    }

	public EMS_storage_logPO toPO(){
		EMS_storage_logPO po = new EMS_storage_logPO();
		
    	po.setRep_no(rep_no);
		po.setCla_id(cla_id);
		po.setBus_time(bus_time);
		po.setBegin_quan(begin_quan);
		po.setAct_quan(act_quan);
		po.setEnd_quan(end_quan);
		po.setRep_unit(rep_unit);
		po.setOp_type(op_type);
		po.setOp_org(op_org);
		po.setTo_org(to_org);
		po.setFrom_org(from_org);
		
		return po;
	}
		
}