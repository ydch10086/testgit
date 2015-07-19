package com.yd.ems.mdm.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_mdm_lifnr - 供应商基础信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_mdm_lifnrMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("sup_code", "供应商编码");
		    titleMap.put("sup_code_name", "供应商名称");
		    titleMap.put("sup_status", "使用状态");
		    titleMap.put("sup_adress", "联系地址");
		    titleMap.put("sup_contact", "联系电话");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "供应商编码","sup_code");
		    fieldMap.put("供应商名称","sup_code_name");
		    fieldMap.put("使用状态","sup_status");
		    fieldMap.put("联系地址","sup_adress");
		    fieldMap.put("联系电话","sup_contact");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("sup_code", rs.getString("sup_code"));
			data.put("sup_code_name", rs.getString("sup_code_name"));
			data.put("sup_status", rs.getString("sup_status"));
			data.put("sup_adress", rs.getString("sup_adress"));
			data.put("sup_contact", rs.getInt("sup_contact"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}