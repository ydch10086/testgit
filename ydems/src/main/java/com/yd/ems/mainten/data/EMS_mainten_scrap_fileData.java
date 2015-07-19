package com.yd.ems.mainten.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_mainten_scrap_file - 设备报废日志是文件上传</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_scrap_fileData {

	 /** 
	    * file_id - 文件标示
	    */
	    private long file_id;

	    /** 
	    * scrap_no - 报废流水号
	    */
	    private long scrap_no;
	    /** 
	    * upload_op - 上传人工号
	    */
	    private int upload_op;

	    /**
	     * 文件后缀名
	     */
	    private String file_last_name;
	    /**
	     * 文件名称
	     */
	    private String file_name;
	    /**
	     * 文件地址
	     */
	    private String file_address;
		public long getFile_id() {
			return file_id;
		}
		public void setFile_id(long file_id) {
			this.file_id = file_id;
		}
		public long getScrap_no() {
			return scrap_no;
		}
		public void setScrap_no(long scrap_no) {
			this.scrap_no = scrap_no;
		}
		public int getUpload_op() {
			return upload_op;
		}
		public void setUpload_op(int upload_op) {
			this.upload_op = upload_op;
		}
		public String getFile_last_name() {
			return file_last_name;
		}
		public void setFile_last_name(String file_last_name) {
			this.file_last_name = file_last_name;
		}
		public String getFile_name() {
			return file_name;
		}
		public void setFile_name(String file_name) {
			this.file_name = file_name;
		}
		public String getFile_address() {
			return file_address;
		}
		public void setFile_address(String file_address) {
			this.file_address = file_address;
		}
	    
}