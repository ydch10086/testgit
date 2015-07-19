package com.yd.common.function.admin.dao.impl;

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

import com.yd.common.function.admin.data.CIP_admin_rolesData;
import com.yd.common.function.admin.data.mapper.CIP_admin_rolesMapper;
import com.yd.common.function.admin.data.po.CIP_admin_rolesPO;
import com.yd.common.function.admin.dao.CIP_admin_rolesDao;
/**
 * <p>Dao实现类</p>
 * <p>Class: admin_roles - 角色信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
 
@Repository
public class CIP_admin_rolesDaoImpl extends IDaoImpl<CIP_admin_rolesPO> 
						implements CIP_admin_rolesDao {
	
	private final BeanPropertyRowMapper<CIP_admin_rolesData> dataRM = BeanPropertyRowMapper.newInstance(CIP_admin_rolesData.class);
	
	public CIP_admin_rolesDaoImpl() {
		super();
		this.tableName = "cip_admin_roles";
		this.tableKeys = new String[]{
						   "role_id" 
						};
	}
	
	@Override
	protected String generateWhere(Object... args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<CIP_admin_rolesData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
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
	
	private CIP_admin_rolesMapper mapperRM = new CIP_admin_rolesMapper();
	
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


