package com.yd.common.auth.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yd.common.function.admin.data.po.CIP_admin_auth_act2objPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_attrPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_objPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_rolePO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_userPO;

@Repository
public interface CIPAuthBehaviorConfDao {
	
	public List<CIP_admin_auth_userPO> getUserConf();
	
	public List<CIP_admin_auth_rolePO> getRoleConf(String roleId);
	
	public List<CIP_admin_auth_objPO> getObjectConf();
	
	public List<CIP_admin_auth_act2objPO> getAction2ObjectConf(String objectId, String actionId, String rootId);
	
	public List<CIP_admin_auth_attrPO> getObjectAttributesConf(String objectId);

	public List<CIP_admin_auth_rolePO> getRoleConfs();
	
}
