package com.yd.ems.purchase.dao.impl;

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

import com.yd.ems.purchase.data.EMS_purchase_plainData;
import com.yd.ems.purchase.data.mapper.EMS_purchase_plainMapper;
import com.yd.ems.purchase.data.po.EMS_purchase_plainPO;
import com.yd.ems.purchase.dao.EMS_purchase_plainDao;
/**
 * <p>Dao实现类</p>
 * <p>Class: purchase_plain - 设备采购计划表</p>
 *
 * @since 2015-05-29 02:42:14
 */
 
@Repository
public class EMS_purchase_plainDaoImpl extends IDaoImpl<EMS_purchase_plainPO> 
						implements EMS_purchase_plainDao {
	
	private final BeanPropertyRowMapper<EMS_purchase_plainData> dataRM = BeanPropertyRowMapper.newInstance(EMS_purchase_plainData.class);
	
	public EMS_purchase_plainDaoImpl() {
		super();
		this.tableName = CIPRuntimeConfigure.dbSchema + "em_purchase_plain";
		this.tableKeys = new String[]{
						   "pur_no" 
						};
	}
	
	@Override
	protected String generateWhere(Object... args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<EMS_purchase_plainData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
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
	
	private EMS_purchase_plainMapper mapperRM = new EMS_purchase_plainMapper();
	
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


