package com.yd.ems.code.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_code_relate_dm - 对象类型子类型关系</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_relate_dmKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			cla_subtype,
					cla_type
		};
	}
	
	public Object[] setKeys(int cla_subtype,int cla_type){
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
    * cla_type - 类型编码 
    */
    private int cla_type;

	private String remark;
	
	private String operateCode;
	
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