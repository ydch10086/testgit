package com.yd.common.function.admin.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: cip_admin_domain - 数据域信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_domainMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("domain_id", "数据域id");
		    titleMap.put("domain_name", "数据域名称");
		    titleMap.put("domain_type", "数据域类型");
		    titleMap.put("is_null_flag", "允许为空标识");
		    titleMap.put("data_length", "数据长度");
		    titleMap.put("default_value", "默认值");
		    titleMap.put("float_length", "小数位长度");
		    titleMap.put("data_type", "数据类型");
		    titleMap.put("create_time", "创建时间");
		    titleMap.put("update_time", "修改时间");
		    titleMap.put("operator", "操作人员");
		    titleMap.put("resp_id", "责任人");
		    titleMap.put("domain_desc", "数据域描述");
		    titleMap.put("ref_table_id", "参考引用数据表");
		    titleMap.put("ref_domain_id", "引用数据域id");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put("domain_id", "数据域id");
		    fieldMap.put("domain_name", "数据域名称");
		    fieldMap.put("domain_type", "数据域类型");
		    fieldMap.put("is_null_flag", "允许为空标识");
		    fieldMap.put("data_length", "数据长度");
		    fieldMap.put("default_value", "默认值");
		    fieldMap.put("float_length", "小数位长度");
		    fieldMap.put("data_type", "数据类型");
		    fieldMap.put("create_time", "创建时间");
		    fieldMap.put("update_time", "修改时间");
		    fieldMap.put("operator", "操作人员");
		    fieldMap.put("resp_id", "责任人");
		    fieldMap.put("domain_desc", "数据域描述");
		    fieldMap.put("ref_table_id", "参考引用数据表");
		    fieldMap.put("ref_domain_id", "引用数据域id");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("domain_id", rs.getString("domain_id"));
			data.put("domain_name", rs.getString("domain_name"));
			data.put("domain_type", rs.getInt("domain_type"));
			data.put("is_null_flag", rs.getInt("is_null_flag"));
			data.put("data_length", rs.getInt("data_length"));
			data.put("default_value", rs.getString("default_value"));
			data.put("float_length", rs.getInt("float_length"));
			data.put("data_type", rs.getString("data_type"));
			data.put("create_time", rs.getString("create_time"));
			data.put("update_time", rs.getString("update_time"));
			data.put("operator", rs.getString("operator"));
			data.put("resp_id", rs.getString("resp_id"));
			data.put("domain_desc", rs.getString("domain_desc"));
			data.put("ref_table_id", rs.getString("ref_table_id"));
			data.put("ref_domain_id", rs.getString("ref_domain_id"));
		
		return data;
	}
}