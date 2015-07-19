package com.yd.common.function.admin.service;

import com.yd.common.function.admin.data.po.CIP_admin_resource_2_resourcePO;
import com.yd.common.function.admin.data.vo.CIP_admin_resource_2_resourceVO;
import com.yd.common.function.admin.data.key.CIP_admin_resource_2_resourceKey;
import com.yd.common.function.admin.data.mapper.CIP_admin_resource_2_resourceMapper;
import com.yd.common.function.admin.data.CIP_admin_resource_2_resourceData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: CIP_admin_resource_2_resourceService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public interface CIP_admin_resource_2_resourceService {

	public void updateData(CIP_admin_resource_2_resourceVO d, CIPRuntimeOperator operateInf);
	
	public void addData(CIP_admin_resource_2_resourceVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public CIP_admin_resource_2_resourceVO getData(Object[] keys);
	
	public List<CIP_admin_resource_2_resourceData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出资源与资源关系
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}