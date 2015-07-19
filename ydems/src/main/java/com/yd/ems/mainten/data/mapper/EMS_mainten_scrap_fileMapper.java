package com.yd.ems.mainten.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>实体mapper类</p>
 * <p>Table: em_mainten_scrap_file -</p>
 *
 * @since 2015-05-29 02:42:12
 */
public class EMS_mainten_scrap_fileMapper implements RowMapper<Map<String, Object>> {

	private static Map<String, String> titleMap = getExcelTitle();
	private static Map<String, String> fieldMap = getFieldTitle();

	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
			titleMap = new LinkedHashMap<String, String>();
		else
			return titleMap;
		
		return titleMap;
		
	}
	
	public static Map<String, String> getFieldTitle() {
		if (fieldMap == null)
			fieldMap = new LinkedHashMap<String, String>();
		else
			return fieldMap;
		
		return fieldMap;
	}
	
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		
		    /**
		     * `file_id` bigint(20) NOT NULL COMMENT '文件标示',
  `scrap_no` bigint(20) NOT NULL COMMENT '报废流水号',
  `upload_op` int(8) DEFAULT NULL COMMENT '上传人工号',
  `upload_op_name` varchar(20) DEFAULT NULL COMMENT '上传人姓名',
  `file_last_name` varchar(10) DEFAULT NULL COMMENT '文件后缀名',
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名称',
  `file_address` varchar(100) DEFAULT NULL COMMENT '文件地址',
		     */
			data.put("file_id", rs.getLong("file_id"));
			data.put("scrap_no", rs.getLong("scrap_no"));
			data.put("upload_op", rs.getInt("upload_op"));
			data.put("upload_op_name", rs.getString("upload_op_name"));
			data.put("file_last_name", rs.getString("file_last_name"));
			data.put("file_name", rs.getString("file_name"));
			data.put("file_address", rs.getString("file_address"));
		return data;
	}
}