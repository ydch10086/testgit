package com.yd.ems.mdm.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_mdm_orgeh - 组织机构主数据</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_orgehMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("org_id", "组织编码");
		    titleMap.put("org_name", "组织描述");
		    titleMap.put("org_status", "使用状态");
		    titleMap.put("org_fat_id", "父级编码");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "组织编码","org_id");
		    fieldMap.put("组织描述","org_name");
		    fieldMap.put("使用状态","org_status");
		    fieldMap.put("父级编码","org_fat_id");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("org_id", rs.getInt("org_id"));
			data.put("org_name", rs.getString("org_name"));
			data.put("org_status", rs.getString("org_status"));
			data.put("org_fat_id", rs.getInt("org_fat_id"));
			data.put("operator", rs.getString("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}