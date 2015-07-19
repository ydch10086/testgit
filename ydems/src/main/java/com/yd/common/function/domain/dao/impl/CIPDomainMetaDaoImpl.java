package com.yd.common.function.domain.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.function.domain.dao.CIPDomainMetaDao;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.tool.db.CIPDBUtils;
import com.yd.common.tool.db.CIPDatabase;
import com.yd.common.tool.db.model.CIPTable;

@Repository
public class CIPDomainMetaDaoImpl implements CIPDomainMetaDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	private CIPDatabase db = null;

	@Override
	public CIPTable getDomainTable(String tableName) {
		try {
			db = CIPDBUtils.createDatabase(jdbcTemplate.getDataSource()
						.getConnection());
			return db.getTable(null, CIPRuntimeConfigure.dbSchema, tableName);
		} catch (SQLException e) {
			throw new CIPRuntimeException(
					CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION, e);
		}
	}

}
