package com.yd.ems.storage.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_code_spare_dm - 备品备件工具</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_storage_inout_dmMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
			titleMap.put("spare_store_id", "对象标识");
		    titleMap.put("spare_name", "对象名称");
		    titleMap.put("spare_sub_type", "对象子类型");
		    titleMap.put("spare_type", "所属一级分类");
		    titleMap.put("sup_code", "供应商");
		    titleMap.put("brand", "所属品牌");
		    titleMap.put("org_id", "管理组织");
		    titleMap.put("operator", "修改者");
		    titleMap.put("op_time", "修改日期");
		    titleMap.put("spare_in_store_num", "入库数量");
		    titleMap.put("spare_out_store_num", "出库数量");
		    titleMap.put("spare_store_num", "库存");
		    titleMap.put("unit_code", "单位");
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
		fieldMap.put("对象标识","spare_store_id");
	    fieldMap.put("对象名称","spare_name");
	    fieldMap.put("对象子类型","spare_sub_type");
	    fieldMap.put("所属一级分类","spare_type");
	    fieldMap.put("供应商","sup_code");
	    fieldMap.put("所属品牌","brand");
	    fieldMap.put("管理组织","org_id");
	    fieldMap.put("修改者","operator");
	    fieldMap.put("修改日期","op_time");	
	    fieldMap.put("入库数量","spare_in_store_num");
	    fieldMap.put("出库数量","spare_out_store_num");
	    fieldMap.put("库存数量","spare_store_num");
	    fieldMap.put("单位","unit_code");
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		    data.put("inout_id", rs.getString("inout_id"));
		    data.put("inout_type", rs.getString("inout_type"));
			data.put("spare_store_id", rs.getString("spare_store_id"));
			data.put("spare_name", rs.getString("spare_name"));
			data.put("spare_sub_type", rs.getInt("spare_sub_type"));
			data.put("spare_type", rs.getInt("spare_type"));
			data.put("spare_type_name", rs.getString("spare_type_name"));
			data.put("sup_code", rs.getString("sup_code"));
			data.put("sup_code_name", rs.getString("sup_code_name"));
			data.put("unit_code", rs.getInt("unit_code"));
			data.put("unit_code_name", rs.getString("unit_code_name"));
			data.put("brand", rs.getString("brand"));
			data.put("org_id", rs.getInt("org_id"));
			data.put("org_id_name", rs.getString("org_id_name"));
			data.put("operator", rs.getInt("operator"));
			data.put("spare_in_store_num", rs.getBigDecimal("spare_in_store_num"));
			data.put("spare_out_store_num", rs.getBigDecimal("spare_out_store_num"));
			data.put("store_time", rs.getString("store_time"));
			data.put("out_store_time", rs.getString("out_store_time"));
			data.put("in_store_type", rs.getInt("in_store_type"));
			data.put("in_store_type_name", rs.getString("in_store_type_name"));
			
		return data;
	}
}