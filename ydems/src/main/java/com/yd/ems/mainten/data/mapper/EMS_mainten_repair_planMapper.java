package com.yd.ems.mainten.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;

/**
 * <p>实体mapper类</p>
 * <p>Table: em_mainten_repair_plan - 设备大修计划表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_repair_planMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("rep_no", "大修流水号");
		    titleMap.put("obj_id", "设备编码");
		    titleMap.put("rep_app_date", "大修申请日期");
		    titleMap.put("rep_org", "所属组织");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("rep_beg_date", "设备起始日");
		    titleMap.put("rep_status_txt", "设备状态");
		    titleMap.put("rep_end_date", "大修完成日期");
		    titleMap.put("rep_amt", "大修费用");
		    titleMap.put("rep_op", "大修负责人工号");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "大修流水号","rep_no");
		    fieldMap.put("设备编码","obj_id");
		    fieldMap.put("大修申请日期","rep_app_date");
		    fieldMap.put("所属组织","rep_org");
		    fieldMap.put("供应商","sup_code");
		    fieldMap.put("设备起始日","rep_beg_date");
		    fieldMap.put("设备状态","rep_status_txt");
		    fieldMap.put("大修完成日期","rep_end_date");
		    fieldMap.put("大修费用","rep_amt");
		    fieldMap.put("大修负责人工号","rep_op");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		 /**
	     * 大修负责人姓名
	     */
	    //private String rep_op_name;
			data.put("rep_no", rs.getLong("rep_no"));
			data.put("obj_id", rs.getLong("obj_id"));
			data.put("rep_app_date", rs.getString("rep_app_date"));
			data.put("rep_org", rs.getInt("rep_org"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("rep_beg_date", rs.getString("rep_beg_date"));
			data.put("rep_status_txt", rs.getString("rep_status_txt"));
			data.put("rep_end_date", rs.getString("rep_end_date"));
			data.put("rep_amt", rs.getBigDecimal("rep_amt"));
			data.put("rep_op", rs.getInt("rep_op"));
			data.put("repair_status", rs.getInt("repair_status"));
			data.put("repair_status_name", rs.getString("repair_status_name"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
			data.put("rep_op_name", rs.getString("rep_op_name"));
		return data;
	}
}