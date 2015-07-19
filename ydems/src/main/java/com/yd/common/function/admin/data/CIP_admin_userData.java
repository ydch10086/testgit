package com.yd.common.function.admin.data;


/**
 * <p>Data实体类</p>
 * <p>View: cip_admin_user - 用户信息</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_userData {


    /** 
    * user_id - 用户id
    */
    private String user_id;

    /** 
    * user_name - 用户名称 
    */
    private String user_name;

    /** 
    * start_date - 开始时间 
    */
    private String start_date;

    /** 
    * end_date - 结束时间 
    */
    private String end_date;

    /** 
    * user_pwd - 密码 
    */
    private String user_pwd;

    /** 
    * pwd_init_flag - 初始密码标识 
    */
    private Integer pwd_init_flag;

    /** 
    * user_his1_pwd - 历史密码1 
    */
    private String user_his1_pwd;

    /** 
    * user_his2_pwd - 历史密码2 
    */
    private String user_his2_pwd;

    /** 
    * user_his3_pwd - 历史密码3 
    */
    private String user_his3_pwd;

    /** 
    * pwd_set_time - 密码设置时间 
    */
    private String pwd_set_time;

    /** 
    * pwd_reset_days - 密码重置天数 
    */
    private Integer pwd_reset_days;

    /** 
    * pwd_reset_flag - 重置密码标识 
    */
    private Integer pwd_reset_flag;

    /** 
    * user_status - 用户状态 
    */
    private Integer user_status;

    /** 
    * user_type - 用户类型 
    */
    private Integer user_type;

    /** 
    * person_id - 使用人id 
    */
    private String person_id;

    /** 
    * org_id - 使用机构id 
    */
    private String org_id;

    /** 
    * position_id - 岗位id 
    */
    private String position_id;

    /** 
    * create_time - 系统生成时间 
    */
    private String create_time;

    /** 
    * update_time - 修改时间 
    */
    private String update_time;

    /** 
    * operator - 操作人 
    */
    private String operator;
	/**
	* 文本描述信息
	*/
	private String pwd_reset_flag_name;
	/**
	* 文本描述信息
	*/
	private String user_status_name;
	/**
	* 文本描述信息
	*/
	private String user_type_name;


    public String getUser_id(){
        return this.user_id;
    }
    public void setUser_id(String user_id){
        this.user_id = user_id;
    }

    public String getUser_name(){
        return this.user_name;
    }
    public void setUser_name(String user_name){
        this.user_name = user_name;
    }

    public String getStart_date(){
        return this.start_date;
    }
    public void setStart_date(String start_date){
        this.start_date = start_date;
    }

    public String getEnd_date(){
        return this.end_date;
    }
    public void setEnd_date(String end_date){
        this.end_date = end_date;
    }

    public String getUser_pwd(){
        return this.user_pwd;
    }
    public void setUser_pwd(String user_pwd){
        this.user_pwd = user_pwd;
    }

    public Integer getPwd_init_flag(){
        return this.pwd_init_flag;
    }
    public void setPwd_init_flag(Integer pwd_init_flag){
        this.pwd_init_flag = pwd_init_flag;
    }

    public String getUser_his1_pwd(){
        return this.user_his1_pwd;
    }
    public void setUser_his1_pwd(String user_his1_pwd){
        this.user_his1_pwd = user_his1_pwd;
    }

    public String getUser_his2_pwd(){
        return this.user_his2_pwd;
    }
    public void setUser_his2_pwd(String user_his2_pwd){
        this.user_his2_pwd = user_his2_pwd;
    }

    public String getUser_his3_pwd(){
        return this.user_his3_pwd;
    }
    public void setUser_his3_pwd(String user_his3_pwd){
        this.user_his3_pwd = user_his3_pwd;
    }

    public String getPwd_set_time(){
        return this.pwd_set_time;
    }
    public void setPwd_set_time(String pwd_set_time){
        this.pwd_set_time = pwd_set_time;
    }

    public Integer getPwd_reset_days(){
        return this.pwd_reset_days;
    }
    public void setPwd_reset_days(Integer pwd_reset_days){
        this.pwd_reset_days = pwd_reset_days;
    }

    public Integer getPwd_reset_flag(){
        return this.pwd_reset_flag;
    }
    public void setPwd_reset_flag(Integer pwd_reset_flag){
        this.pwd_reset_flag = pwd_reset_flag;
    }

    public Integer getUser_status(){
        return this.user_status;
    }
    public void setUser_status(Integer user_status){
        this.user_status = user_status;
    }

    public Integer getUser_type(){
        return this.user_type;
    }
    public void setUser_type(Integer user_type){
        this.user_type = user_type;
    }

    public String getPerson_id(){
        return this.person_id;
    }
    public void setPerson_id(String person_id){
        this.person_id = person_id;
    }

    public String getOrg_id(){
        return this.org_id;
    }
    public void setOrg_id(String org_id){
        this.org_id = org_id;
    }

    public String getPosition_id(){
        return this.position_id;
    }
    public void setPosition_id(String position_id){
        this.position_id = position_id;
    }

    public String getCreate_time(){
        return this.create_time;
    }
    public void setCreate_time(String create_time){
        this.create_time = create_time;
    }

    public String getUpdate_time(){
        return this.update_time;
    }
    public void setUpdate_time(String update_time){
        this.update_time = update_time;
    }

    public String getOperator(){
        return this.operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

	public String getPwd_reset_flag_name(){
        return this.pwd_reset_flag_name;
    }
    public void setPwd_reset_flag_name(String pwd_reset_flag_name){
        this.pwd_reset_flag_name = pwd_reset_flag_name;
    }
    
	public String getUser_status_name(){
        return this.user_status_name;
    }
    public void setUser_status_name(String user_status_name){
        this.user_status_name = user_status_name;
    }
    
	public String getUser_type_name(){
        return this.user_type_name;
    }
    public void setUser_type_name(String user_type_name){
        this.user_type_name = user_type_name;
    }
    
}