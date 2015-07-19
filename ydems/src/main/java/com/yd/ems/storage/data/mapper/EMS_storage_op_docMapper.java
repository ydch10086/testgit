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
 * <p>Table: em_storage_op_doc - 物料操作凭证</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_op_docMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("doc_no", "操作凭证流水");
		    titleMap.put("cla_id", "对象类标识");
		    titleMap.put("doc_year", "年度");
		    titleMap.put("doc_month", "月度");
		    titleMap.put("doc_op_type", "出入标识");
		    titleMap.put("op_type", "操作类型");
		    titleMap.put("doc_op_amt", "操作数量");
		    titleMap.put("doc_unit", "数量单位");
		    titleMap.put("op_emp", "入库出库人");
		    titleMap.put("op_date", "入库出库日期");
		    titleMap.put("use_emp", "领用人");
		    titleMap.put("use_time", "领用时间");
		    titleMap.put("use_org", "领用机构");
		    titleMap.put("op_org", "出入库机构");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "操作凭证流水","doc_no");
		    fieldMap.put("对象类标识","cla_id");
		    fieldMap.put("年度","doc_year");
		    fieldMap.put("月度","doc_month");
		    fieldMap.put("出入标识","doc_op_type");
		    fieldMap.put("操作类型","op_type");
		    fieldMap.put("操作数量","doc_op_amt");
		    fieldMap.put("数量单位","doc_unit");
		    fieldMap.put("入库出库人","op_emp");
		    fieldMap.put("入库出库日期","op_date");
		    fieldMap.put("领用人","use_emp");
		    fieldMap.put("领用时间","use_time");
		    fieldMap.put("领用机构","use_org");
		    fieldMap.put("出入库机构","op_org");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("doc_no", rs.getLong("doc_no"));
			data.put("cla_id", rs.getLong("cla_id"));
			data.put("doc_year", rs.getString("doc_year"));
			data.put("doc_month", rs.getString("doc_month"));
			data.put("doc_op_type", rs.getString("doc_op_type"));
			data.put("op_type", rs.getString("op_type"));
			data.put("doc_op_amt", rs.getBigDecimal("doc_op_amt"));
			data.put("doc_unit", rs.getString("doc_unit"));
			data.put("op_emp", rs.getInt("op_emp"));
			data.put("op_date", rs.getString("op_date"));
			data.put("use_emp", rs.getInt("use_emp"));
			data.put("use_time", rs.getString("use_time"));
			data.put("use_org", rs.getInt("use_org"));
			data.put("op_org", rs.getInt("op_org"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}