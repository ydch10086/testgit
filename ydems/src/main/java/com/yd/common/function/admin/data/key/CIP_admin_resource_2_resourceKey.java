package com.yd.common.function.admin.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: cip_admin_resource_2_resource - 资源与资源关系</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_resource_2_resourceKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			res_node_id,
					res_node_sup,
					root_node_id
		};
	}
	
	public Object[] setKeys(String res_node_id,String res_node_sup,String root_node_id){
		return new Object[]{ 
			res_node_id,
					res_node_sup,
					root_node_id
		};
	}
	



    /** 
    * res_node_id - 资源节点id 
    */
    private String res_node_id;

    /** 
    * res_node_sup - 资源上级节点id 
    */
    private String res_node_sup;

    /** 
    * root_node_id - 根节点 
    */
    private String root_node_id;

	private String remark;
	
	private String operateCode;
	
    public String getRes_node_id(){
        return this.res_node_id;
    }
    
    public void setRes_node_id(String res_node_id){
        this.res_node_id = res_node_id;
    }
    public String getRes_node_sup(){
        return this.res_node_sup;
    }
    
    public void setRes_node_sup(String res_node_sup){
        this.res_node_sup = res_node_sup;
    }
    public String getRoot_node_id(){
        return this.root_node_id;
    }
    
    public void setRoot_node_id(String root_node_id){
        this.root_node_id = root_node_id;
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