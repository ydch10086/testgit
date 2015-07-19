package com.yd.ems.report.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_report_travel - 人员出差报告</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_report_travelMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("travel_no", "出差报告流水号");
		    titleMap.put("travel_purchse", "出差目的");
		    titleMap.put("travel_org", "出差分拨");
		    titleMap.put("travel_date_txt", "出差时间");
		    titleMap.put("travel_emp_txt", "出差人员");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "出差报告流水号","travel_no");
		    fieldMap.put("出差目的","travel_purchse");
		    fieldMap.put("出差分拨","travel_org");
		    fieldMap.put("出差时间","travel_date_txt");
		    fieldMap.put("出差人员","travel_emp_txt");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("travel_no", rs.getLong("travel_no"));
			data.put("travel_purchse", rs.getString("travel_purchse"));
			data.put("travel_org", rs.getInt("travel_org"));
			data.put("travel_date_txt", rs.getString("travel_date_txt"));
			data.put("travel_emp_txt", rs.getString("travel_emp_txt"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}