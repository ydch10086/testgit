package com.yd.common.function.admin.service;

import com.yd.common.function.admin.data.po.CIP_admin_auth_act2objPO;
import com.yd.common.function.admin.data.vo.CIP_admin_auth_act2objVO;
import com.yd.common.function.admin.data.key.CIP_admin_auth_act2objKey;
import com.yd.common.function.admin.data.mapper.CIP_admin_auth_act2objMapper;
import com.yd.common.function.admin.data.CIP_admin_auth_act2objData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: CIP_admin_auth_act2objService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public interface CIP_admin_auth_act2objService {

	public void updateData(CIP_admin_auth_act2objVO d, CIPRuntimeOperator operateInf);
	
	public void addData(CIP_admin_auth_act2objVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public CIP_admin_auth_act2objVO getData(Object[] keys);
	
	public List<CIP_admin_auth_act2objData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出权限对象授权配置
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}