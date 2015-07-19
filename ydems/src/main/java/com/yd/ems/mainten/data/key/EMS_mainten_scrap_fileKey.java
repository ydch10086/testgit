package com.yd.ems.mainten.data.key;

/**
 * <p>实体key类</p>
 * <p>Table: em_mainten_scrap_file - 设备报废日志文件上传</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_scrap_fileKey {	
	
	public Object[] getKeys(){
		return new Object[]{ 
				file_id
		};
	}
	
	public Object[] setKeys(long scrap_no){
		return new Object[]{ 
				file_id
		};
	}
	



    /** 
    * file_id - 文件标示
    */
    private long file_id;

	private String remark;
	
	private String operateCode;
	

	public long getFile_id() {
		return file_id;
	}

	public void setFile_id(long file_id) {
		this.file_id = file_id;
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