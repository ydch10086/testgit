package com.yd.common.function.admin.dao;

import org.springframework.stereotype.Repository;

import com.yd.common.function.admin.data.po.CIP_admin_domainPO;
import com.yd.common.function.admin.data.CIP_admin_domainData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: admin_domain - 数据域信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
 
@Repository
public interface CIP_admin_domainDao extends IDao<CIP_admin_domainPO> {
	
	public List<CIP_admin_domainData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
