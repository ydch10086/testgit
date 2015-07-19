package com.yd.common.function.admin.service;

import com.yd.common.function.admin.data.po.CIP_admin_auth_rolePO;
import com.yd.common.function.admin.data.vo.CIP_admin_auth_roleVO;
import com.yd.common.function.admin.data.key.CIP_admin_auth_roleKey;
import com.yd.common.function.admin.data.mapper.CIP_admin_auth_roleMapper;
import com.yd.common.function.admin.data.CIP_admin_auth_roleData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: CIP_admin_auth_roleService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public interface CIP_admin_auth_roleService {

	public void updateData(CIP_admin_auth_roleVO d, CIPRuntimeOperator operateInf);
	
	public void addData(CIP_admin_auth_roleVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public CIP_admin_auth_roleVO getData(Object[] keys);
	
	public List<CIP_admin_auth_roleData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出角色权限值配置
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}