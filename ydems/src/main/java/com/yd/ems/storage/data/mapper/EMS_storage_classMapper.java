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
 * <p>Table: em_storage_class - 备品备件工具类</p>
 *
 * @since 2015-05-29 02:42:14
 */
public class EMS_storage_classMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
			titleMap.put("cla_id", "对象类标识");
		    titleMap.put("cla_type", "对象类类型");
		    titleMap.put("cla_sub_type", "对象类子类型");
		    titleMap.put("cla_txt", "对象类名称");
		    titleMap.put("cla_bel_type", "所属种类");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("cla_bra", "所属品牌");
		    titleMap.put("cla_orgeh", "管理组织");
		    titleMap.put("cla_imp_amt", "入库数量");
		    titleMap.put("cla_amt", "库存数量");
		    titleMap.put("cla_exp_amt", "出库数量");
		    titleMap.put("cla_unit", "数量单位");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
			fieldMap.put( "对象类标识","cla_id");
		    fieldMap.put("对象类类型","cla_type");
		    fieldMap.put("对象类子类型","cla_sub_type");
		    fieldMap.put("对象类名称","cla_txt");
		    fieldMap.put("所属种类","cla_bel_type");
		    fieldMap.put("供应商","sup_code");
		    fieldMap.put("所属品牌","cla_bra");
		    fieldMap.put("管理组织","cla_orgeh");
		    fieldMap.put("入库数量","cla_imp_amt");
		    fieldMap.put("库存数量","cla_amt");
		    fieldMap.put("出库数量","cla_exp_amt");
		    fieldMap.put("数量单位","cla_unit");
		    fieldMap.put("修改者","operator");
		    fieldMap.put("修改日期","op_time");
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
			data.put("cla_id", rs.getLong("cla_id"));
			data.put("cla_type", rs.getInt("cla_type"));
			data.put("cla_sub_type", rs.getInt("cla_sub_type"));
			data.put("cla_txt", rs.getString("cla_txt"));
			data.put("cla_bel_type", rs.getInt("cla_bel_type"));
			data.put("sup_code", rs.getInt("sup_code"));
			data.put("cla_bra", rs.getString("cla_bra"));
			data.put("cla_orgeh", rs.getInt("cla_orgeh"));
			data.put("cla_imp_amt", rs.getBigDecimal("cla_imp_amt"));
			data.put("cla_amt", rs.getBigDecimal("cla_amt"));
			data.put("cla_exp_amt", rs.getBigDecimal("cla_exp_amt"));
			data.put("cla_unit", rs.getInt("cla_unit"));
			data.put("operator", rs.getInt("operator"));
			data.put("op_time", rs.getString("op_time"));
		
		return data;
	}
}