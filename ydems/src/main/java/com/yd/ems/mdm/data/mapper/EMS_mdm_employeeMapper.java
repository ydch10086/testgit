package com.yd.ems.mdm.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_mdm_employee - 人员主数据信息</p>
 *
 * @since 2015-05-29 02:42:13
 */
public class EMS_mdm_employeeMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("emp_id", "人员工号");
		    titleMap.put("emp_name", "人员姓名");
		    titleMap.put("emp_org", "所属组织");
		    titleMap.put("emp_status", "在职状态");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "人员工号","emp_id");
		    fieldMap.put("人员姓名","emp_name");
		    fieldMap.put("所属组织","emp_org");
		    fieldMap.put("在职状态","emp_status");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("emp_id", rs.getInt("emp_id"));
			data.put("emp_name", rs.getString("emp_name"));
			data.put("emp_org", rs.getInt("emp_org"));
			data.put("emp_status", rs.getString("emp_status"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}