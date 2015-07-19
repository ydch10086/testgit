package com.yd.common.function.admin.dao;

import org.springframework.stereotype.Repository;

import com.yd.common.function.admin.data.po.CIP_admin_user_2_rolesPO;
import com.yd.common.function.admin.data.CIP_admin_user_2_rolesData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: admin_user_2_roles - 用户角色关联</p>
 *
 * @since 2015-05-21 12:44:17
 */
 
@Repository
public interface CIP_admin_user_2_rolesDao extends IDao<CIP_admin_user_2_rolesPO> {
	
	public List<CIP_admin_user_2_rolesData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
