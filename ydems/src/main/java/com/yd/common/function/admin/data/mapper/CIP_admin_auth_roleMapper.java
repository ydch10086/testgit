package com.yd.common.function.admin.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: cip_admin_auth_role - 角色权限值配置</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_roleMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("auth_attr_id", "权限属性id");
			titleMap.put("auth_role_id", "角色Id");
		    titleMap.put("auth_attr_val", "权限属性值");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put("auth_attr_id", "权限属性id");
			fieldMap.put("auth_role_id", "角色Id");
		    fieldMap.put("auth_attr_val", "权限属性值");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("auth_attr_id", rs.getString("auth_attr_id"));
			data.put("auth_role_id", rs.getString("auth_role_id"));
			data.put("auth_attr_val", rs.getString("auth_attr_val"));
		
		return data;
	}
}