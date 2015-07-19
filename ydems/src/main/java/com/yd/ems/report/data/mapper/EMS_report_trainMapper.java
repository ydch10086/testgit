package com.yd.ems.report.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_report_train - 设备培训方案表</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_report_trainMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("train_no", "培训流水号");
		    titleMap.put("train_purchse", "培训目的");
		    titleMap.put("train_object", "培训对象");
		    titleMap.put("train_comment", "培训内容");
		    titleMap.put("train_teacher", "培训讲师");
		    titleMap.put("train_time", "培训时间");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "培训流水号","train_no");
		    fieldMap.put("培训目的","train_purchse");
		    fieldMap.put("培训对象","train_object");
		    fieldMap.put("培训内容","train_comment");
		    fieldMap.put("培训讲师","train_teacher");
		    fieldMap.put("培训时间","train_time");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("train_no", rs.getLong("train_no"));
			data.put("train_purchse", rs.getString("train_purchse"));
			data.put("train_object", rs.getString("train_object"));
			data.put("train_comment", rs.getString("train_comment"));
			data.put("train_teacher", rs.getString("train_teacher"));
			data.put("train_time", rs.getString("train_time"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}