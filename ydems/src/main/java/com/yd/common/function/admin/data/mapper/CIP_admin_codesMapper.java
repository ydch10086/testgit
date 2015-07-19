package com.yd.common.function.admin.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: cip_admin_codes - 数据编码</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_codesMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("code_type", "编码类型");
			titleMap.put("domain_id", "数据域id");
		    titleMap.put("code_name", "编码名称");
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
		
			fieldMap.put("code_type", "编码类型");
			fieldMap.put("domain_id", "数据域id");
		    fieldMap.put("code_name", "编码名称");
		    fieldMap.put("create_time", "系统生成时间");
		    fieldMap.put("update_time", "修改时间");
		    fieldMap.put("operator", "操作人");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("code_type", rs.getString("code_type"));
			data.put("domain_id", rs.getString("domain_id"));
			data.put("code_name", rs.getString("code_name"));
			data.put("create_time", rs.getString("create_time"));
			data.put("update_time", rs.getString("update_time"));
			data.put("operator", rs.getString("operator"));
		
		return data;
	}
}