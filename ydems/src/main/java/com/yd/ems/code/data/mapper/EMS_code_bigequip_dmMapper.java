package com.yd.ems.code.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_code_bigequip_dm - 备品备件工具</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_code_bigequip_dmMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
			titleMap.put("bigequip_id", "对象标识");
		    titleMap.put("bigequip_name", "对象名称");
		    titleMap.put("bigequip_sub_type", "对象子类型");
		    titleMap.put("bigequip_type", "所属一级分类");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("brand", "所属品牌");
		    titleMap.put("org_id", "管理组织");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
		fieldMap.put("对象标识","bigequip_id");
	    fieldMap.put("对象名称","bigequip_name");
	    fieldMap.put("对象子类型","bigequip_sub_type");
	    fieldMap.put("所属一级分类","bigequip_type");
	    fieldMap.put("供应商","sup_code");
	    fieldMap.put("所属品牌","brand");
	    fieldMap.put("管理组织","org_id");
	    fieldMap.put("修改者","operator");
	    fieldMap.put("修改日期","op_time");		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
			data.put("bigequip_id", rs.getLong("bigequip_id"));
			data.put("bigequip_name", rs.getString("bigequip_name"));
			data.put("bigequip_sub_type", rs.getInt("bigequip_sub_type"));
			data.put("bigequip_sub_type_name", rs.getString("bigequip_sub_type_name"));
			data.put("bigequip_type", rs.getInt("bigequip_type"));
			data.put("bigequip_type_name", rs.getString("bigequip_type_name"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("sup_code_name", rs.getString("sup_code_name"));
			data.put("brand", rs.getString("brand"));
			data.put("org_id", rs.getInt("org_id"));
			data.put("org_id_name", rs.getString("org_id_name"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		return data;
	}
}