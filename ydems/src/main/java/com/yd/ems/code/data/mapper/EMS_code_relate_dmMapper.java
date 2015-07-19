package com.yd.ems.code.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_code_relate_dm - 对象类型子类型关系</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_relate_dmMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("cla_subtype", "子类型编码");
			titleMap.put("cla_subtype_name", "子类型编码名称");
			titleMap.put("cla_type", "类型编码");
			titleMap.put("cla_type_name", "类型编码名称");
		    titleMap.put("sty_status", "使用状态");
		    titleMap.put("sty_status_name", "使用状态名称");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "子类型编码","cla_subtype");
			fieldMap.put( "子类型编码名称","cla_subtype_name");
			fieldMap.put( "类型编码","cla_type");
			fieldMap.put( "类型编码名称","cla_type_name");
		    fieldMap.put("使用状态","sty_status");
		    fieldMap.put("使用状态名称","sty_status_name");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("cla_subtype", rs.getInt("cla_subtype"));
			data.put("cla_subtype_name", rs.getString("cla_subtype_name"));
			data.put("cla_type", rs.getInt("cla_type"));
			data.put("cla_type_name", rs.getString("cla_type_name"));
			data.put("sty_status", rs.getInt("sty_status"));
			data.put("sty_status_name", rs.getString("sty_status_name"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}