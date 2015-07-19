package com.yd.ems.mainten.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_mainten_repair_log - 设备维修日志表</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_repair_logMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("rep_no", "维修流水号");
		    titleMap.put("obj_id", "设备编码");
		    titleMap.put("apply_date", "维修申请日期");
		    titleMap.put("rep_org", "所属组织");
		    titleMap.put("rep_orgeh", "设备位置编码");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("fault_txt", "故障现象");
		    titleMap.put("begin_time", "报修时间");
		    titleMap.put("end_time", "报复时间");
		    titleMap.put("fault_reason", "故障原因");
		    titleMap.put("fault_solution", "处理措施");
		    titleMap.put("fault_type", "故障分类");
		    titleMap.put("cla_id", "更换部件");
		    titleMap.put("repair_stye_txt", "部件型号");
		    titleMap.put("repair_type", "维修类型");
		    titleMap.put("repair_emp_quan", "维修人数");
		    titleMap.put("repair_emp_no", "维修人");
		    titleMap.put("op", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "维修流水号","rep_no");
		    fieldMap.put("设备编码","obj_id");
		    fieldMap.put("维修申请日期","apply_date");
		    fieldMap.put("所属组织","rep_org");
		    fieldMap.put("设备位置编码","rep_orgeh");
		    fieldMap.put("供应商","sup_code");
		    fieldMap.put("故障现象","fault_txt");
		    fieldMap.put("报修时间","begin_time");
		    fieldMap.put("报复时间","end_time");
		    fieldMap.put("故障原因","fault_reason");
		    fieldMap.put("处理措施","fault_solution");
		    fieldMap.put("故障分类","fault_type");
		    fieldMap.put("更换部件","cla_id");
		    fieldMap.put("部件型号","repair_stye_txt");
		    fieldMap.put("维修类型","repair_type");
		    fieldMap.put("维修人数","repair_emp_quan");
		    fieldMap.put("维修人","repair_emp_no");
		    fieldMap.put("修改者","op");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("rep_no", rs.getLong("rep_no"));
			data.put("obj_id", rs.getLong("obj_id"));
			data.put("apply_date", rs.getString("apply_date"));
			data.put("rep_org", rs.getInt("rep_org"));
			data.put("rep_orgeh", rs.getInt("rep_orgeh"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("fault_txt", rs.getString("fault_txt"));
			data.put("begin_time", rs.getString("begin_time"));
			data.put("end_time", rs.getString("end_time"));
			data.put("fault_reason", rs.getString("fault_reason"));
			data.put("fault_solution", rs.getString("fault_solution"));
			data.put("fault_type", rs.getInt("fault_type"));
			data.put("cla_id", rs.getLong("cla_id"));
			data.put("repair_stye_txt", rs.getString("repair_stye_txt"));
			data.put("repair_type", rs.getInt("repair_type"));
			data.put("repair_emp_quan", rs.getInt("repair_emp_quan"));
			data.put("repair_emp_no", rs.getInt("repair_emp_no"));
			data.put("op", rs.getInt("op"));
			data.put("op_time", rs.getString("op_time"));
			data.put("repair_emps_name", rs.getString("repair_emps_name"));
		
		return data;
	}
}