package com.yd.ems.storage.service;

import com.yd.ems.storage.data.po.EMS_storage_logPO;
import com.yd.ems.storage.data.vo.EMS_storage_logVO;
import com.yd.ems.storage.data.key.EMS_storage_logKey;
import com.yd.ems.storage.data.mapper.EMS_storage_logMapper;
import com.yd.ems.storage.data.EMS_storage_logData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_storage_logService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public interface EMS_storage_logService {

	public void updateData(EMS_storage_logVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_storage_logVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_storage_logVO getData(Object[] keys);
	
	public List<EMS_storage_logData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出备品备件工具库存日志
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}