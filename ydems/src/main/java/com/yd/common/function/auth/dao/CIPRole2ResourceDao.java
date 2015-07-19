package com.yd.common.function.auth.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yd.common.function.auth.data.CIPRole2ResourceData;

@Repository
public interface CIPRole2ResourceDao {
	public List<CIPRole2ResourceData> getResources(String resourceId);

	public List<CIPRole2ResourceData> getActionResources(
			String resourceId, String reqResourceId);
}
