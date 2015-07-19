package com.yd.common.function.admin.service;

import com.yd.common.function.admin.data.po.CIP_admin_resourcePO;
import com.yd.common.function.admin.data.vo.CIP_admin_resourceVO;
import com.yd.common.function.admin.data.key.CIP_admin_resourceKey;
import com.yd.common.function.admin.data.mapper.CIP_admin_resourceMapper;
import com.yd.common.function.admin.data.CIP_admin_resourceData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: CIP_admin_resourceService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public interface CIP_admin_resourceService {

	public void updateData(CIP_admin_resourceVO d, CIPRuntimeOperator operateInf);
	
	public void addData(CIP_admin_resourceVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public CIP_admin_resourceVO getData(Object[] keys);
	
	public List<CIP_admin_resourceData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出系统资源信息
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}