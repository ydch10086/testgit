package com.yd.ems.mainten.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_mainten_scrap_plan - 设备报废计划表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_scrap_planMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("scrap_no", "报废流水号");
		    titleMap.put("obj_id", "设备编码");
		    titleMap.put("scrap_org", "所属组织");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("begin_date", "设备起始日");
		    titleMap.put("status_txt", "设备状态");
		    titleMap.put("theory_date", "理论报废日期");
		    titleMap.put("act_date", "实际报废日期");
		    titleMap.put("start_op", "发起人");
		    titleMap.put("examine_op", "审核人");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "报废流水号","scrap_no");
		    fieldMap.put("设备编码","obj_id");
		    fieldMap.put("所属组织","scrap_org");
		    fieldMap.put("供应商","sup_code");
		    fieldMap.put("设备起始日","begin_date");
		    fieldMap.put("设备状态","status_txt");
		    fieldMap.put("理论报废日期","theory_date");
		    fieldMap.put("实际报废日期","act_date");
		    fieldMap.put("发起人","start_op");
		    fieldMap.put("审核人","examine_op");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("scrap_no", rs.getLong("scrap_no"));
			data.put("obj_id", rs.getLong("obj_id"));
			data.put("scrap_org", rs.getInt("scrap_org"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("sup_code_name", rs.getString("sup_code_name"));
			data.put("begin_date", rs.getString("begin_date"));
			data.put("status_txt", rs.getString("status_txt"));
			data.put("theory_date", rs.getString("theory_date"));
			data.put("act_date", rs.getString("act_date"));
			data.put("start_op", rs.getInt("start_op"));
			data.put("examine_op", rs.getInt("examine_op"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
			data.put("start_op_name", rs.getString("start_op_name"));
			data.put("examine_op_name", rs.getString("examine_op_name"));
			data.put("examine_status", rs.getInt("examine_status"));
			data.put("examine_status_name", rs.getString("examine_status_name"));
		return data;
	}
}