package com.yd.ems.storage.data.vo;


import com.yd.ems.storage.data.po.EMS_storage_objectPO;

/**
 * <p>实体类</p>
 * <p>Table: em_storage_object - 设备信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_objectVO {

	public Object[] getKeys(){
		return new Object[]{ 
			obj_id
		};
	}


    /** 
    * obj_id - 对象标识ID 
    */
    private long obj_id;
    /** 
    * cla_id - 对象所属类型 
    */
    private long cla_id;
    /** 
    * obj_org - 所属组织 
    */
    private int obj_org;
    /** 
    * obj_txt - 对象描述 
    */
    private String obj_txt;
    /** 
    * obj_status - 使用状态 
    */
    private String obj_status;

    public long getObj_id(){
        return this.obj_id;
    }
    public void setObj_id(long obj_id){
        this.obj_id = obj_id;
    }
    public long getCla_id(){
        return this.cla_id;
    }
    public void setCla_id(long cla_id){
        this.cla_id = cla_id;
    }
    public int getObj_org(){
        return this.obj_org;
    }
    public void setObj_org(int obj_org){
        this.obj_org = obj_org;
    }
    public String getObj_txt(){
        return this.obj_txt;
    }
    public void setObj_txt(String obj_txt){
        this.obj_txt = obj_txt;
    }
    public String getObj_status(){
        return this.obj_status;
    }
    public void setObj_status(String obj_status){
        this.obj_status = obj_status;
    }

	public EMS_storage_objectPO toPO(){
		EMS_storage_objectPO po = new EMS_storage_objectPO();
		
    	po.setObj_id(obj_id);
		po.setCla_id(cla_id);
		po.setObj_org(obj_org);
		po.setObj_txt(obj_txt);
		po.setObj_status(obj_status);
		
		return po;
	}
		
}