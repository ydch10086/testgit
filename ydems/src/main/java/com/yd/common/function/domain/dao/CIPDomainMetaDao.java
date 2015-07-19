package com.yd.common.function.domain.dao;

import org.springframework.stereotype.Repository;

import com.yd.common.tool.db.model.CIPTable;

@Repository
public interface CIPDomainMetaDao {

	public CIPTable getDomainTable(String tableName);
	
}
