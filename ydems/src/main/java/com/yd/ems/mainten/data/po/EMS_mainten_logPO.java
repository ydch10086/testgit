package com.yd.ems.mainten.data.po;


import com.yd.ems.mainten.data.vo.EMS_mainten_logVO;

/**
 * <p>实体类</p>
 * <p>Table: em_mainten_log - 设备保养日志表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_logPO {

	public Object[] getKeys(){
		return new Object[]{ 
			mainten_no
		};
	}


    /** 
    * mainten_no - 保养流水号 
    */
    private long mainten_no;

    /** 
    * obj_id - 设备编码
    */
    private long obj_id;

    /** 
    * mainten_org - 所属组织
    */
    private int mainten_org;

    /** 
    * sup_code - 供应商
    */
    private String sup_code;

    /** 
    * set_date - 定期保养日期
    */
    private String set_date;

    /** 
    * begin_date - 有效起始日期
    */
    private String begin_date;

    /** 
    * mainten_op - 保养人
    */
    private int mainten_op;

    /** 
    * mainten_status - 保养状态
    */
    private String mainten_status;

    /** 
    * operator - 修改者
    */
    private int operator;

    /** 
    * op_time - 修改日期
    */
    private String op_time;


    public long getMainten_no(){
        return this.mainten_no;
    }
    public void setMainten_no(long mainten_no){
        this.mainten_no = mainten_no;
    }

    public long getObj_id(){
        return this.obj_id;
    }
    public void setObj_id(long obj_id){
        this.obj_id = obj_id;
    }

    public int getMainten_org(){
        return this.mainten_org;
    }
    public void setMainten_org(int mainten_org){
        this.mainten_org = mainten_org;
    }

    public String getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(String sup_code){
        this.sup_code = sup_code;
    }

    public String getSet_date(){
        return this.set_date;
    }
    public void setSet_date(String set_date){
        this.set_date = set_date;
    }

    public String getBegin_date(){
        return this.begin_date;
    }
    public void setBegin_date(String begin_date){
        this.begin_date = begin_date;
    }

    public int getMainten_op(){
        return this.mainten_op;
    }
    public void setMainten_op(int mainten_op){
        this.mainten_op = mainten_op;
    }

    public String getMainten_status(){
        return this.mainten_status;
    }
    public void setMainten_status(String mainten_status){
        this.mainten_status = mainten_status;
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

	public EMS_mainten_logVO toVO(){
		EMS_mainten_logVO vo = new EMS_mainten_logVO();
		
    	vo.setMainten_no(mainten_no);
		vo.setObj_id(obj_id);
		vo.setMainten_org(mainten_org);
		vo.setSup_code(sup_code);
		vo.setSet_date(set_date);
		vo.setBegin_date(begin_date);
		vo.setMainten_op(mainten_op);
		vo.setMainten_status(mainten_status);
		
		return vo;
	}
		
}