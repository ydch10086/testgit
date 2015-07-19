package com.yd.ems.check.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.yd.common.dao.IDaoImpl;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.data.CIPOperatorType;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.exception.CIPDaoException;

import com.yd.ems.check.data.EMS_check_logData;
import com.yd.ems.check.data.mapper.EMS_check_logMapper;
import com.yd.ems.check.data.po.EMS_check_logPO;
import com.yd.ems.check.dao.EMS_check_logDao;
/**
 * <p>Dao实现类</p>
 * <p>Class: check_log - 设备日常巡检日志</p>
 *
 * @since 2015-05-29 02:42:11
 */
 
@Repository
public class EMS_check_logDaoImpl extends IDaoImpl<EMS_check_logPO> 
						implements EMS_check_logDao {
	
	private final BeanPropertyRowMapper<EMS_check_logData> dataRM = BeanPropertyRowMapper.newInstance(EMS_check_logData.class);
	
	public EMS_check_logDaoImpl() {
		super();
		this.tableName = CIPRuntimeConfigure.dbSchema + "em_check_log";
		this.tableKeys = new String[]{
						   "check_are" ,
						   "check_beg_time" ,
						   "check_end_time" ,
						   "check_org" 
						};
	}
	
	@Override
	protected String generateWhere(Object... args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<EMS_check_logData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		try{
			List<Object> params = new ArrayList<Object>();
			String querySql = generateQuerySql(page, conditions, params);
			return jdbcTemplate.query(querySql.toString(), params.toArray(), dataRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
	private String generateQuerySql(CIPPageInfo pageUtil, CIPReqCondition[] conditions, List<Object> params){
		StringBuffer countSql = new StringBuffer().append("SELECT COUNT(1) from ").append(tableName).append("_v");
		StringBuffer querySql = new StringBuffer().append("SELECT * from ").append(tableName).append("_v");
				StringBuffer whereSql = new StringBuffer().append(" where ");
		if(conditions!=null && conditions.length>0) {
			int operator;
			for(int i=0 ; i<conditions.length; i++){
				operator = conditions[i].getOperator();
				if(operator == CIPOperatorType.EQUAL.code){
					whereSql.append(conditions[i].getFieldName()).append(" = ? and ");
					params.add(conditions[i].getLowValue());
				}
				else if(operator == CIPOperatorType.GREAT_EQUAL.code){
					whereSql.append(conditions[i].getFieldName()).append(" >= ? and ");
					params.add(conditions[i].getLowValue());
				}
				else if(operator == CIPOperatorType.GREAT_THAN.code){
					whereSql.append(conditions[i].getFieldName()).append(" > ? and ");
					params.add(conditions[i].getLowValue());
				}
				else if(operator == CIPOperatorType.LESS_EQUAL.code){
					whereSql.append(conditions[i].getFieldName()).append(" <= ? and ");
					params.add(conditions[i].getHighValue());
				}
				else if(operator == CIPOperatorType.LESS_THAN.code){
					whereSql.append(conditions[i].getFieldName()).append(" < ? and ");
					params.add(conditions[i].getHighValue());
				}
				else if(operator == CIPOperatorType.BETWEEN.code){
					whereSql.append(conditions[i].getFieldName()).append(" BETWEEN ? and ? ");
					params.add(conditions[i].getLowValue());
					params.add(conditions[i].getHighValue());
				}
				else if(operator == CIPOperatorType.IN.code){
					whereSql.append(conditions[i].getFieldName()).append(" IN ( ");
					String[] values = conditions[i].getValues();
					for(int j=0 ; j < values.length; j++ ){
						if( j < values.length - 1)
							whereSql.append("?, ");
						else 
							whereSql.append("? ) and ");
						params.add(values[j]);
					}
				}
			}
			String whereStr = whereSql.substring(0, whereSql.length() - 4);
			querySql.append(whereStr);
			countSql.append(whereStr);
		}
		
		querySql.append(" limit ?,?");
	
		int total = jdbcTemplate.queryForObject(countSql.toString(), params.toArray(), Integer.class);
		pageUtil.setTotal(total);

		params.add(pageUtil.getStartRecord());
		params.add(pageUtil.getRows());
		return querySql.toString();
	}
	
	private EMS_check_logMapper mapperRM = new EMS_check_logMapper();
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo pageUtil, CIPReqCondition[] conditions, boolean xFirst){
		List<Object> params = new ArrayList<Object>();
		StringBuffer countSql = new StringBuffer().append("SELECT COUNT(1) from ").append(tableName).append("_v");
		StringBuffer querySql = new StringBuffer().append("SELECT * from ").append(tableName).append("_v");
		StringBuffer whereSql = new StringBuffer().append(" where ");
		if(conditions!=null && conditions.length>0) {
			int operator;
			for(int i=0 ; i<conditions.length; i++){
				operator = conditions[i].getOperator();
				if(operator == CIPOperatorType.EQUAL.code){
					whereSql.append(conditions[i].getFieldName()).append(" = ? and ");
					params.add(conditions[i].getLowValue());
				}
				else if(operator == CIPOperatorType.GREAT_EQUAL.code){
					whereSql.append(conditions[i].getFieldName()).append(" >= ? and ");
					params.add(conditions[i].getLowValue());
				}
				else if(operator == CIPOperatorType.GREAT_THAN.code){
					whereSql.append(conditions[i].getFieldName()).append(" > ? and ");
					params.add(conditions[i].getLowValue());
				}
				else if(operator == CIPOperatorType.LESS_EQUAL.code){
					whereSql.append(conditions[i].getFieldName()).append(" <= ? and ");
					params.add(conditions[i].getHighValue());
				}
				else if(operator == CIPOperatorType.LESS_THAN.code){
					whereSql.append(conditions[i].getFieldName()).append(" < ? and ");
					params.add(conditions[i].getHighValue());
				}
				else if(operator == CIPOperatorType.BETWEEN.code){
					whereSql.append(conditions[i].getFieldName()).append(" BETWEEN ? and ? ");
					params.add(conditions[i].getLowValue());
					params.add(conditions[i].getHighValue());
				}
				else if(operator == CIPOperatorType.IN.code){
					whereSql.append(conditions[i].getFieldName()).append(" IN ( ");
					String[] values = conditions[i].getValues();
					for(int j=0 ; j < values.length; j++ ){
						if( j < values.length - 1)
							whereSql.append("?, ");
						else 
							whereSql.append("? ) and ");
						params.add(values[j]);
					}
				}
			}
			String whereStr = whereSql.substring(0, whereSql.length() - 4);
			querySql.append(whereStr);
			countSql.append(whereStr);
		}
		
		querySql.append(" limit ?,?");
		
		if(xFirst){
			int total = jdbcTemplate.queryForObject(countSql.toString(), params.toArray(), Integer.class);
			pageUtil.setTotal(total);
		}

		params.add(pageUtil.getStartRecord());
		params.add(pageUtil.getRows());
		
		try{
			return jdbcTemplate.query(querySql.toString(), params.toArray(), mapperRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
}


