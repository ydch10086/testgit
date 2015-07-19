package com.yd.common.function.admin.data.vo;


import com.yd.common.function.admin.data.po.CIP_admin_domainPO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_domain - 数据域信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_domainVO {

	public Object[] getKeys(){
		return new Object[]{ 
			domain_id
		};
	}


    /** 
    * domain_id - 数据域id 
    */
    private String domain_id;
    /** 
    * domain_name - 数据域名称 
    */
    private String domain_name;
    /** 
    * domain_type - 数据域类型 
    */
    private Integer domain_type;
    /** 
    * is_null_flag - 允许为空标识 
    */
    private Integer is_null_flag;
    /** 
    * data_length - 数据长度 
    */
    private Integer data_length;
    /** 
    * default_value - 默认值 
    */
    private String default_value;
    /** 
    * float_length - 小数位长度 
    */
    private Integer float_length;
    /** 
    * data_type - 数据类型 
    */
    private String data_type;
    /** 
    * resp_id - 责任人 
    */
    private String resp_id;
    /** 
    * domain_desc - 数据域描述 
    */
    private String domain_desc;
    /** 
    * ref_table_id - 参考引用数据表 
    */
    private String ref_table_id;
    /** 
    * ref_domain_id - 引用数据域id 
    */
    private String ref_domain_id;

    public String getDomain_id(){
        return this.domain_id;
    }
    public void setDomain_id(String domain_id){
        this.domain_id = domain_id;
    }
    public String getDomain_name(){
        return this.domain_name;
    }
    public void setDomain_name(String domain_name){
        this.domain_name = domain_name;
    }
    public Integer getDomain_type(){
        return this.domain_type;
    }
    public void setDomain_type(Integer domain_type){
        this.domain_type = domain_type;
    }
    public Integer getIs_null_flag(){
        return this.is_null_flag;
    }
    public void setIs_null_flag(Integer is_null_flag){
        this.is_null_flag = is_null_flag;
    }
    public Integer getData_length(){
        return this.data_length;
    }
    public void setData_length(Integer data_length){
        this.data_length = data_length;
    }
    public String getDefault_value(){
        return this.default_value;
    }
    public void setDefault_value(String default_value){
        this.default_value = default_value;
    }
    public Integer getFloat_length(){
        return this.float_length;
    }
    public void setFloat_length(Integer float_length){
        this.float_length = float_length;
    }
    public String getData_type(){
        return this.data_type;
    }
    public void setData_type(String data_type){
        this.data_type = data_type;
    }
    public String getResp_id(){
        return this.resp_id;
    }
    public void setResp_id(String resp_id){
        this.resp_id = resp_id;
    }
    public String getDomain_desc(){
        return this.domain_desc;
    }
    public void setDomain_desc(String domain_desc){
        this.domain_desc = domain_desc;
    }
    public String getRef_table_id(){
        return this.ref_table_id;
    }
    public void setRef_table_id(String ref_table_id){
        this.ref_table_id = ref_table_id;
    }
    public String getRef_domain_id(){
        return this.ref_domain_id;
    }
    public void setRef_domain_id(String ref_domain_id){
        this.ref_domain_id = ref_domain_id;
    }

	public CIP_admin_domainPO toPO(){
		CIP_admin_domainPO po = new CIP_admin_domainPO();
		
    	po.setDomain_id(domain_id);
		po.setDomain_name(domain_name);
		po.setDomain_type(domain_type);
		po.setIs_null_flag(is_null_flag);
		po.setData_length(data_length);
		po.setDefault_value(default_value);
		po.setFloat_length(float_length);
		po.setData_type(data_type);
		po.setResp_id(resp_id);
		po.setDomain_desc(domain_desc);
		po.setRef_table_id(ref_table_id);
		po.setRef_domain_id(ref_domain_id);
		
		return po;
	}
		
}