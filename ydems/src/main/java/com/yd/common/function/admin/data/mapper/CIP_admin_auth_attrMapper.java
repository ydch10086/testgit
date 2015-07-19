package com.yd.common.function.admin.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: cip_admin_auth_attr - 权限对象属性信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_attrMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("obj_attr_id", "权限对象属性id");
			titleMap.put("obj_id", "权限对象id");
		    titleMap.put("obj_attr_name", "权限对象描述");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put("obj_attr_id", "权限对象属性id");
			fieldMap.put("obj_id", "权限对象id");
		    fieldMap.put("obj_attr_name", "权限对象描述");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("obj_attr_id", rs.getString("obj_attr_id"));
			data.put("obj_id", rs.getString("obj_id"));
			data.put("obj_attr_name", rs.getString("obj_attr_name"));
		
		return data;
	}
}