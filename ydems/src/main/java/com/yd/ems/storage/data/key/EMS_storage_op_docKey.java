package com.yd.ems.storage.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_storage_op_doc - 物料操作凭证</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_op_docKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
			doc_no
		};
	}
	
	public Object[] setKeys(long doc_no){
		return new Object[]{ 
			doc_no
		};
	}
	



    /** 
    * doc_no - 操作凭证流水 
    */
    private long doc_no;

	private String remark;
	
	private String operateCode;
	
    public long getDoc_no(){
        return this.doc_no;
    }
    
    public void setDoc_no(long doc_no){
        this.doc_no = doc_no;
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