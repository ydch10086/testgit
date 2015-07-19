package com.yd.ems.code.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_code_mode_dm - 设备型号类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_mode_dmMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("mod_type", "设备型号");
		    titleMap.put("mod_type_name", "设备型号名称");
		    titleMap.put("mod_status", "使用状态");
		    titleMap.put("mod_status_name", "使用状态名称");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put("设备型号","mod_type");
		    fieldMap.put("型号名称","mod_type_name");
		    fieldMap.put("使用状态","mod_status");
		    fieldMap.put("使用状态名称","mod_status_name");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("mod_type", rs.getInt("mod_type"));
			data.put("mod_type_name", rs.getString("mod_type_name"));
			data.put("mod_status", rs.getString("mod_status"));
			data.put("mod_status_name", rs.getString("mod_status_name"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}