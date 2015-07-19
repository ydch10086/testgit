package com.yd.ems.storage.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;

/**
 * <p>实体mapper类</p>
 * <p>Table: em_storage_log - 备品备件工具库存日志</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_logMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("rep_no", "日志流水号");
		    titleMap.put("cla_id", "类标识");
		    titleMap.put("bus_time", "业务时间");
		    titleMap.put("begin_quan", "期初库存");
		    titleMap.put("act_quan", "本期发生");
		    titleMap.put("end_quan", "期末库存");
		    titleMap.put("rep_unit", "库存单位");
		    titleMap.put("op_type", "操作类型");
		    titleMap.put("op_org", "操作机构");
		    titleMap.put("to_org", "目标机构");
		    titleMap.put("from_org", "源机构");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "日志流水号","rep_no");
		    fieldMap.put("类标识","cla_id");
		    fieldMap.put("业务时间","bus_time");
		    fieldMap.put("期初库存","begin_quan");
		    fieldMap.put("本期发生","act_quan");
		    fieldMap.put("期末库存","end_quan");
		    fieldMap.put("库存单位","rep_unit");
		    fieldMap.put("操作类型","op_type");
		    fieldMap.put("操作机构","op_org");
		    fieldMap.put("目标机构","to_org");
		    fieldMap.put("源机构","from_org");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("rep_no", rs.getLong("rep_no"));
			data.put("cla_id", rs.getLong("cla_id"));
			data.put("bus_time", rs.getString("bus_time"));
			data.put("begin_quan", rs.getBigDecimal("begin_quan"));
			data.put("act_quan", rs.getBigDecimal("act_quan"));
			data.put("end_quan", rs.getBigDecimal("end_quan"));
			data.put("rep_unit", rs.getString("rep_unit"));
			data.put("op_type", rs.getString("op_type"));
			data.put("op_org", rs.getInt("op_org"));
			data.put("to_org", rs.getInt("to_org"));
			data.put("from_org", rs.getInt("from_org"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}