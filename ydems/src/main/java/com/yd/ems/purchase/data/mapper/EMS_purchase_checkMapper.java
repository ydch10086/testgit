package com.yd.ems.purchase.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_purchase_check - 设备验收表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_purchase_checkMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("che_no", "设备验收流水号");
		    titleMap.put("che_obj", "对象标识");
		    titleMap.put("che_org", "操作机构组织");
		    titleMap.put("sup_code", "验收供应商");
		    titleMap.put("che_date", "设备验收时间");
		    titleMap.put("che_emp", "验收人员");
		    titleMap.put("result_type", "验收结果");
		    titleMap.put("pro_emp", "整改跟进人员");
		    titleMap.put("pro_txt", "整改结果");
		    titleMap.put("plain_date", "整改要求完成时间");
		    titleMap.put("act_date", "整改实际完成时间");
		    titleMap.put("pur_no", "采购计划流水号");
		    titleMap.put("che_status", "验收记录状态");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		    titleMap.put("che_org_name", "组织机构名称");
			titleMap.put("sup_code_name", "供应商名称");
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "设备验收流水号","che_no");
		    fieldMap.put("对象标识","che_obj");
		    fieldMap.put("操作机构组织","che_org");
		    fieldMap.put("验收供应商","sup_code");
		    fieldMap.put("设备验收时间","che_date");
		    fieldMap.put("验收人员","che_emp");
		    fieldMap.put("验收结果","result_type");
		    fieldMap.put("整改跟进人员","pro_emp");
		    fieldMap.put("整改结果","pro_txt");
		    fieldMap.put("整改要求完成时间","plain_date");
		    fieldMap.put("整改实际完成时间","act_date");
		    fieldMap.put("采购计划流水号","pur_no");
		    fieldMap.put("验收记录状态","che_status");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		    fieldMap.put("组织机构名称","che_org_name");
		    fieldMap.put("供应商名称","sup_code_name");
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("che_no", rs.getLong("che_no"));
			data.put("che_obj", rs.getLong("che_obj"));
			data.put("che_org", rs.getInt("che_org"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("che_date", rs.getString("che_date"));
			data.put("che_emp", rs.getInt("che_emp"));
			data.put("result_type", rs.getString("result_type"));
			data.put("pro_emp", rs.getInt("pro_emp"));
			data.put("pro_txt", rs.getString("pro_txt"));
			data.put("plain_date", rs.getString("plain_date"));
			data.put("act_date", rs.getString("act_date"));
			data.put("pur_no", rs.getLong("pur_no"));
			data.put("che_status", rs.getString("che_status"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
			data.put("che_org_name", rs.getString("che_org_name"));
			data.put("sup_code_name", rs.getString("sup_code_name"));
		return data;
	}
}