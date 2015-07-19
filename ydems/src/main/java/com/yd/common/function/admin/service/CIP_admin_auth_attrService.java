package com.yd.common.function.admin.service;

import com.yd.common.function.admin.data.po.CIP_admin_auth_attrPO;
import com.yd.common.function.admin.data.vo.CIP_admin_auth_attrVO;
import com.yd.common.function.admin.data.key.CIP_admin_auth_attrKey;
import com.yd.common.function.admin.data.mapper.CIP_admin_auth_attrMapper;
import com.yd.common.function.admin.data.CIP_admin_auth_attrData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: CIP_admin_auth_attrService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public interface CIP_admin_auth_attrService {

	public void updateData(CIP_admin_auth_attrVO d, CIPRuntimeOperator operateInf);
	
	public void addData(CIP_admin_auth_attrVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public CIP_admin_auth_attrVO getData(Object[] keys);
	
	public List<CIP_admin_auth_attrData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出权限对象属性信息
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}