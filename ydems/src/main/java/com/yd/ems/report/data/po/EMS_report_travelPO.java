package com.yd.ems.report.data.po;


import com.yd.ems.report.data.vo.EMS_report_travelVO;

/**
 * <p>实体类</p>
 * <p>Table: em_report_travel - 人员出差报告</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_report_travelPO {

	public Object[] getKeys(){
		return new Object[]{ 
			travel_no
		};
	}


    /** 
    * travel_no - 出差报告流水号 
    */
    private long travel_no;

    /** 
    * travel_purchse - 出差目的
    */
    private String travel_purchse;

    /** 
    * travel_org - 出差分拨
    */
    private int travel_org;

    /** 
    * travel_date_txt - 出差时间
    */
    private String travel_date_txt;

    /** 
    * travel_emp_txt - 出差人员
    */
    private String travel_emp_txt;

    /** 
    * operator - 修改者
    */
    private int operator;

    /** 
    * op_time - 修改日期
    */
    private String op_time;


    public long getTravel_no(){
        return this.travel_no;
    }
    public void setTravel_no(long travel_no){
        this.travel_no = travel_no;
    }

    public String getTravel_purchse(){
        return this.travel_purchse;
    }
    public void setTravel_purchse(String travel_purchse){
        this.travel_purchse = travel_purchse;
    }

    public int getTravel_org(){
        return this.travel_org;
    }
    public void setTravel_org(int travel_org){
        this.travel_org = travel_org;
    }

    public String getTravel_date_txt(){
        return this.travel_date_txt;
    }
    public void setTravel_date_txt(String travel_date_txt){
        this.travel_date_txt = travel_date_txt;
    }

    public String getTravel_emp_txt(){
        return this.travel_emp_txt;
    }
    public void setTravel_emp_txt(String travel_emp_txt){
        this.travel_emp_txt = travel_emp_txt;
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

	public EMS_report_travelVO toVO(){
		EMS_report_travelVO vo = new EMS_report_travelVO();
		
    	vo.setTravel_no(travel_no);
		vo.setTravel_purchse(travel_purchse);
		vo.setTravel_org(travel_org);
		vo.setTravel_date_txt(travel_date_txt);
		vo.setTravel_emp_txt(travel_emp_txt);
		
		return vo;
	}
		
}