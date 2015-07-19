package com.yd.ems.storage.service;

import com.yd.ems.storage.data.po.EMS_storage_objectPO;
import com.yd.ems.storage.data.vo.EMS_storage_objectVO;
import com.yd.ems.storage.data.key.EMS_storage_objectKey;
import com.yd.ems.storage.data.mapper.EMS_storage_objectMapper;
import com.yd.ems.storage.data.EMS_storage_objectData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_storage_objectService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public interface EMS_storage_objectService {

	public void updateData(EMS_storage_objectVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_storage_objectVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_storage_objectVO getData(Object[] keys);
	
	public List<EMS_storage_objectData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出设备信息
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}