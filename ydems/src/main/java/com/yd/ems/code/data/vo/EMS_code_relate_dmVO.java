package com.yd.ems.code.data.vo;


import com.yd.ems.code.data.po.EMS_code_relate_dmPO;

/**
 * <p>实体类</p>
 * <p>Table: em_code_relate_dm - 对象类型子类型关系</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_relate_dmVO {

	public Object[] getKeys(){
		return new Object[]{ 
			cla_subtype,
		    cla_type
		};
	}


    /** 
    * cla_subtype - 子类型编码 
    */
    private int cla_subtype;
    /** 
     * cla_subtype_name - 子类型名称
     */
    private String cla_subtype_name;
    /** 
    * cla_type - 类型编码 
    */
    private int cla_type;
    /** 
    * sty_status - 使用状态 
    */
    private int sty_status;

    public int getCla_subtype(){
        return this.cla_subtype;
    }
    public void setCla_subtype(int cla_subtype){
        this.cla_subtype = cla_subtype;
    }
    public int getCla_type(){
        return this.cla_type;
    }
    public void setCla_type(int cla_type){
        this.cla_type = cla_type;
    }
    public int getSty_status(){
        return this.sty_status;
    }
    public void setSty_status(int sty_status){
        this.sty_status = sty_status;
    }

	public String getCla_subtype_name() {
		return cla_subtype_name;
	}
	public void setCla_subtype_name(String cla_subtype_name) {
		this.cla_subtype_name = cla_subtype_name;
	}
	public EMS_code_relate_dmPO toPO(){
		EMS_code_relate_dmPO po = new EMS_code_relate_dmPO();
    	po.setCla_subtype(cla_subtype);
    	po.setCla_subtype_name(cla_subtype_name);
    	po.setCla_type(cla_type);
		po.setSty_status(sty_status);
		return po;
	}
		
}