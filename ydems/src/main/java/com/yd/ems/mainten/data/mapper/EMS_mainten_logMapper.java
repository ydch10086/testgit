package com.yd.ems.mainten.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_mainten_log - 设备保养日志表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_logMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("mainten_no", "保养流水号");
		    titleMap.put("obj_id", "设备编码");
		    titleMap.put("mainten_org", "所属组织");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("set_date", "定期保养日期");
		    titleMap.put("begin_date", "有效起始日期");
		    titleMap.put("mainten_op", "保养人");
		    titleMap.put("mainten_status", "保养状态");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "保养流水号","mainten_no");
		    fieldMap.put("设备编码","obj_id");
		    fieldMap.put("所属组织","mainten_org");
		    fieldMap.put("供应商","sup_code");
		    fieldMap.put("定期保养日期","set_date");
		    fieldMap.put("有效起始日期","begin_date");
		    fieldMap.put("保养人","mainten_op");
		    fieldMap.put("保养状态","mainten_status");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("mainten_no", rs.getLong("mainten_no"));
			data.put("obj_id", rs.getLong("obj_id"));
			data.put("mainten_org", rs.getInt("mainten_org"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("set_date", rs.getString("set_date"));
			data.put("begin_date", rs.getString("begin_date"));
			data.put("mainten_op", rs.getInt("mainten_op"));
			data.put("mainten_op_name", rs.getString("mainten_op_name"));
			data.put("mainten_status", rs.getString("mainten_status"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}