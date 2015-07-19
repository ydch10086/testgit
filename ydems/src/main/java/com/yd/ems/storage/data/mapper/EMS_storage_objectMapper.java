package com.yd.ems.storage.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_storage_object - 设备信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_objectMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("obj_id", "对象标识ID");
		    titleMap.put("cla_id", "对象所属类型");
		    titleMap.put("obj_org", "所属组织");
		    titleMap.put("obj_txt", "对象描述");
		    titleMap.put("obj_status", "使用状态");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "对象标识ID","obj_id");
		    fieldMap.put("对象所属类型","cla_id");
		    fieldMap.put("所属组织","obj_org");
		    fieldMap.put("对象描述","obj_txt");
		    fieldMap.put("使用状态","obj_status");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("obj_id", rs.getLong("obj_id"));
			data.put("cla_id", rs.getLong("cla_id"));
			data.put("obj_org", rs.getInt("obj_org"));
			data.put("obj_txt", rs.getString("obj_txt"));
			data.put("obj_status", rs.getString("obj_status"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}