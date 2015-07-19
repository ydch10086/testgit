package com.yd.ems.storage.data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p>Data实体类</p>
 * <p>View: em_storage_class - 备品备件工具类</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_classData {


    /** 
    * cla_id - 对象类标识
    */
    private BigInteger cla_id;

    /** 
    * cla_type - 对象类类型 
    */
    private int cla_type;

    /** 
    * cla_sub_type - 对象类子类型 
    */
    private int cla_sub_type;

    /** 
    * cla_txt - 对象类名称 
    */
    private String cla_txt;

    /** 
    * cla_bel_type - 所属种类 
    */
    private int cla_bel_type;

    /** 
    * sup_code - 供应商 
    */
    private int sup_code;

    /** 
    * cla_bra - 所属品牌 
    */
    private String cla_bra;

    /** 
    * cla_orgeh - 管理组织 
    */
    private int cla_orgeh;

    /** 
    * cla_imp_amt - 入库数量 
    */
    private BigDecimal cla_imp_amt;

    /** 
    * cla_amt - 库存数量 
    */
    private BigDecimal cla_amt;

    /** 
    * cla_exp_amt - 出库数量 
    */
    private BigDecimal cla_exp_amt;

    /** 
    * cla_unit - 数量单位 
    */
    private int cla_unit;

    /** 
    * operator - 修改者 
    */
    private int operator;

    /** 
    * op_time - 修改日期 
    */
    private String op_time;


    public BigInteger getCla_id(){
        return this.cla_id;
    }
    public void setCla_id(BigInteger cla_id){
        this.cla_id = cla_id;
    }

    public int getCla_type(){
        return this.cla_type;
    }
    public void setCla_type(int cla_type){
        this.cla_type = cla_type;
    }

    public int getCla_sub_type(){
        return this.cla_sub_type;
    }
    public void setCla_sub_type(int cla_sub_type){
        this.cla_sub_type = cla_sub_type;
    }

    public String getCla_txt(){
        return this.cla_txt;
    }
    public void setCla_txt(String cla_txt){
        this.cla_txt = cla_txt;
    }

    public int getCla_bel_type(){
        return this.cla_bel_type;
    }
    public void setCla_bel_type(int cla_bel_type){
        this.cla_bel_type = cla_bel_type;
    }

    public int getSup_code(){
        return this.sup_code;
    }
    public void setSup_code(int sup_code){
        this.sup_code = sup_code;
    }

    public String getCla_bra(){
        return this.cla_bra;
    }
    public void setCla_bra(String cla_bra){
        this.cla_bra = cla_bra;
    }

    public int getCla_orgeh(){
        return this.cla_orgeh;
    }
    public void setCla_orgeh(int cla_orgeh){
        this.cla_orgeh = cla_orgeh;
    }

    public BigDecimal getCla_imp_amt(){
        return this.cla_imp_amt;
    }
    public void setCla_imp_amt(BigDecimal cla_imp_amt){
        this.cla_imp_amt = cla_imp_amt;
    }

    public BigDecimal getCla_amt(){
        return this.cla_amt;
    }
    public void setCla_amt(BigDecimal cla_amt){
        this.cla_amt = cla_amt;
    }

    public BigDecimal getCla_exp_amt(){
        return this.cla_exp_amt;
    }
    public void setCla_exp_amt(BigDecimal cla_exp_amt){
        this.cla_exp_amt = cla_exp_amt;
    }

    public int getCla_unit(){
        return this.cla_unit;
    }
    public void setCla_unit(int cla_unit){
        this.cla_unit = cla_unit;
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

}