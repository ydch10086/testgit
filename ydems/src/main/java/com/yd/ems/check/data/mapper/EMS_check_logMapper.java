package com.yd.ems.check.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_check_log - 设备日常巡检日志</p>
 *
 * @since 2015-05-29 02:42:11
 */
public class EMS_check_logMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("check_are", "巡检区域");
			titleMap.put("check_beg_time", "巡检开始时间");
			titleMap.put("check_end_time", "巡检结束时间");
			titleMap.put("check_org", "分拨中心");
		    titleMap.put("check_no", "巡检流水号");
		    titleMap.put("check_op", "巡检人工号");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "巡检区域","check_are");
			fieldMap.put( "巡检开始时间","check_beg_time");
			fieldMap.put( "巡检结束时间","check_end_time");
			fieldMap.put( "分拨中心","check_org");
		    fieldMap.put("巡检流水号","check_no");
		    fieldMap.put("巡检人工号","check_op");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("check_are", rs.getString("check_are"));
			data.put("check_beg_time", rs.getString("check_beg_time"));
			data.put("check_end_time", rs.getString("check_end_time"));
			data.put("check_org", rs.getInt("check_org"));
			data.put("check_no", rs.getLong("check_no"));
			data.put("check_op", rs.getInt("check_op"));
		
		return data;
	}
}