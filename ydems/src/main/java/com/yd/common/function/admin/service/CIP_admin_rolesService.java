package com.yd.common.function.admin.service;

import com.yd.common.function.admin.data.po.CIP_admin_rolesPO;
import com.yd.common.function.admin.data.vo.CIP_admin_rolesVO;
import com.yd.common.function.admin.data.key.CIP_admin_rolesKey;
import com.yd.common.function.admin.data.mapper.CIP_admin_rolesMapper;
import com.yd.common.function.admin.data.CIP_admin_rolesData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: CIP_admin_rolesService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public interface CIP_admin_rolesService {

	public void updateData(CIP_admin_rolesVO d, CIPRuntimeOperator operateInf);
	
	public void addData(CIP_admin_rolesVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public CIP_admin_rolesVO getData(Object[] keys);
	
	public List<CIP_admin_rolesData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出角色信息
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}