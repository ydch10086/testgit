package com.yd.ems.code.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_code_type_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_type_dmMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("typ_type", "对象类型编码");
		    titleMap.put("typ_type_name", "对象类型描述");
		    titleMap.put("typ_status", "使用状态");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "对象类型编码","typ_type");
		    fieldMap.put("对象类型描述","typ_type_name");
		    fieldMap.put("使用状态","typ_status");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("typ_type", rs.getInt("typ_type"));
			data.put("typ_type_name", rs.getString("typ_type_name"));
			data.put("typ_status", rs.getString("typ_status"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}