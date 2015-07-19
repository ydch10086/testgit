package com.yd.ems.check.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_check_poi_log - 设备日常点检日志</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_check_poi_logMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("poi_no", "点检流水号");
		    titleMap.put("obj_id", "资产编码");
		    titleMap.put("poi_time", "点检时间");
		    titleMap.put("poi_org", "所属组织");
		    titleMap.put("mod_type_txt", "设备型号");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("begin_date", "设备起始日");
		    titleMap.put("fault_txt", "故障描述");
		    titleMap.put("che_op", "点检人");
		    titleMap.put("exa_op", "审核人");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "点检流水号","poi_no");
		    fieldMap.put("资产编码","obj_id");
		    fieldMap.put("点检时间","poi_time");
		    fieldMap.put("所属组织","poi_org");
		    fieldMap.put("设备型号","mod_type_txt");
		    fieldMap.put("供应商","sup_code");
		    fieldMap.put("设备起始日","begin_date");
		    fieldMap.put("故障描述","fault_txt");
		    fieldMap.put("点检人","che_op");
		    fieldMap.put("审核人","exa_op");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("poi_no", rs.getLong("poi_no"));
			data.put("obj_id", rs.getLong("obj_id"));
			data.put("poi_time", rs.getString("poi_time"));
			data.put("poi_org", rs.getInt("poi_org"));
			data.put("mod_type_txt", rs.getString("mod_type_txt"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("begin_date", rs.getString("begin_date"));
			data.put("fault_txt", rs.getString("fault_txt"));
			data.put("che_op", rs.getInt("che_op"));
			data.put("exa_op", rs.getInt("exa_op"));
		
		return data;
	}
}