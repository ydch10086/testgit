package com.yd.ems.purchase.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;

/**
 * <p>实体mapper类</p>
 * <p>Table: em_purchase_plain - 设备采购计划表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_purchase_examplainMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("pur_no", "采购计划流水号");
		    titleMap.put("pur_obj", "对象标识");
		    titleMap.put("pur_org", "所属组织");
		    titleMap.put("pur_date", "采购日期");
		    titleMap.put("type_txt", "对象型号");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("pla_date", "计划到货日期");
		    titleMap.put("pur_amt", "申请数量");
		    titleMap.put("pur_unit", "数量单位");
		    titleMap.put("app_emp", "申请人");
		    titleMap.put("exa_emp", "审核人");
		    titleMap.put("app_emp_num", "申请人工号");
		    titleMap.put("exa_emp_num", "审核人工号");
		    titleMap.put("app_date", "申请日期");
		    titleMap.put("exa_date", "审核日期");
		    titleMap.put("pur_status", "记录状态");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		    titleMap.put("pur_org_name", "组织名称");
		    titleMap.put("sup_code_name", "供应商名称");
		    titleMap.put("pur_unit_name", "单位名称");
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "采购计划流水号","pur_no");
		    fieldMap.put("对象标识","pur_obj");
		    fieldMap.put("所属组织","pur_org");
		    fieldMap.put("采购日期","pur_date");
		    fieldMap.put("对象型号","type_txt");
		    fieldMap.put("供应商","sup_code");
		    fieldMap.put("计划到货日期","pla_date");
		    fieldMap.put("申请数量","pur_amt");
		    fieldMap.put("数量单位","pur_unit");
		    fieldMap.put("申请人","app_emp");
		    fieldMap.put("审核人","exa_emp");
		    fieldMap.put("申请人工号","app_emp_num");
		    fieldMap.put("审核人工号","exa_emp_num");
		    fieldMap.put("申请日期","app_date");
		    fieldMap.put("审核日期","exa_date");
		    fieldMap.put("记录状态","pur_status");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		    fieldMap.put("组织名称","pur_org_name");
		    fieldMap.put("供应商名称","sup_code_name");
		    fieldMap.put("单位名称","pur_unit_name");
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("pur_no", rs.getLong("pur_no"));
			data.put("pur_obj", rs.getInt("pur_obj"));
			data.put("pur_org", rs.getInt("pur_org"));
			data.put("pur_date", rs.getString("pur_date"));
			data.put("type_txt", rs.getString("type_txt"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("pla_date", rs.getString("pla_date"));
			data.put("pur_amt", rs.getBigDecimal("pur_amt"));
			data.put("pur_unit", rs.getString("pur_unit"));
			data.put("app_emp", rs.getString("app_emp"));
			data.put("app_emp_num", rs.getString("app_emp_num"));
			data.put("exa_emp", rs.getString("exa_emp"));
			data.put("exa_emp_num", rs.getString("exa_emp_num"));
			data.put("app_date", rs.getString("app_date"));
			data.put("exa_date", rs.getString("exa_date"));
			data.put("pur_status", rs.getString("pur_status"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		    data.put("pur_org_name", rs.getString("pur_org_name"));
			data.put("sup_code_name", rs.getString("sup_code_name"));
			data.put("pur_unit_name", rs.getString("pur_unit_name"));
		return data;
	}
}