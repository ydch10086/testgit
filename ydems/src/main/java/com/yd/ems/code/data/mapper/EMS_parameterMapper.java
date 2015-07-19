package com.yd.ems.code.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_parameter - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_parameterMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
			titleMap.put("equip_id", "设备编码");
		    titleMap.put("equip_type", "设备类型编码");
		    titleMap.put("equip_type_name", "设备类型名称");
		    titleMap.put("equip_name", "设备名称");
		    titleMap.put("equip_description", "设备描述");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改时间");
		    titleMap.put("remark", "remark");
		    titleMap.put("sup_code", "供应商编码");//供应商名称
		    titleMap.put("sup_code_name", "供应商名称");//供应商名称
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
			fieldMap.put("设备编码","equip_id");
		    fieldMap.put("设备类型","equip_type");
		    fieldMap.put("设备名称","equip_name");
		    fieldMap.put("设备描述","equip_description");
		    fieldMap.put("设备类型编码","equip_type");
		    fieldMap.put("设备类型名称","equip_type_name");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改时间","op_time");
		    fieldMap.put("供应商编码","sup_code");
		    fieldMap.put("供应商名称","sup_code_name");
		    fieldMap.put("remark","remark");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("equip_id", rs.getString("equip_id"));
			data.put("equip_name", rs.getString("equip_name"));
			data.put("equip_type", rs.getInt("equip_type"));
			data.put("equip_type_name", rs.getString("equip_type_name"));
			data.put("equip_description", rs.getString("equip_description"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
			data.put("remark", rs.getString("remark"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("sup_code_name", rs.getString("sup_code_name"));
			data.put("equip_status", rs.getInt("equip_status"));
			data.put("equip_status_name", rs.getString("equip_status_name"));
			data.put("org_id", rs.getInt("org_id"));
			data.put("org_id_name", rs.getString("org_id_name"));
		return data;
	}
}