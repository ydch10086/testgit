package com.yd.common.function.admin.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: cip_admin_roles - 角色信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_rolesMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("role_id", "角色id");
		    titleMap.put("role_name", "角色名称");
		    titleMap.put("root_resource_id", "资源根节点id");
		    titleMap.put("create_time", "系统生成时间");
		    titleMap.put("update_time", "修改时间");
		    titleMap.put("operator", "操作人");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put("role_id", "角色id");
		    fieldMap.put("role_name", "角色名称");
		    fieldMap.put("root_resource_id", "资源根节点id");
		    fieldMap.put("create_time", "系统生成时间");
		    fieldMap.put("update_time", "修改时间");
		    fieldMap.put("operator", "操作人");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("role_id", rs.getString("role_id"));
			data.put("role_name", rs.getString("role_name"));
			data.put("root_resource_id", rs.getString("root_resource_id"));
			data.put("create_time", rs.getString("create_time"));
			data.put("update_time", rs.getString("update_time"));
			data.put("operator", rs.getString("operator"));
		
		return data;
	}
}