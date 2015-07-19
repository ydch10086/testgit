package com.yd.common.function.auth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yd.common.exception.CIPDaoException;
import com.yd.common.function.auth.dao.CIPRole2ResourceDao;
import com.yd.common.function.auth.data.CIPRole2ResourceData;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntimeConfigure;

@Repository
public class CIPRoleDao2ResourceImpl implements CIPRole2ResourceDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	private final BeanPropertyRowMapper<CIPRole2ResourceData> resourceRM = BeanPropertyRowMapper.newInstance(CIPRole2ResourceData.class);
	
	
	
	@Override
	public List<CIPRole2ResourceData> getResources(String resourceId) {
		try{
			String sqlResource = "SELECT * from " + CIPRuntimeConfigure.dbSchema + "cip_admin_view_resources where root_node_id = ?";
			
			return jdbcTemplate.query(sqlResource, new Object[]{resourceId}, resourceRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}

	@Override
	public List<CIPRole2ResourceData> getActionResources(
			String resourceId, String reqResourceId) {
		try{
			String sqlResource = "SELECT * from " + CIPRuntimeConfigure.dbSchema + "cip_admin_view_resources where root_node_id = ? and res_node_sup = ? and resource_type='B'";
			
			return jdbcTemplate.query(sqlResource, new Object[]{resourceId, reqResourceId}, resourceRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
}
