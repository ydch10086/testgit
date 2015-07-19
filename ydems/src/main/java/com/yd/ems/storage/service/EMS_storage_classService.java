package com.yd.ems.storage.service;

import com.yd.ems.storage.data.po.EMS_storage_classPO;
import com.yd.ems.storage.data.vo.EMS_storage_classVO;
import com.yd.ems.storage.data.key.EMS_storage_classKey;
import com.yd.ems.storage.data.mapper.EMS_storage_classMapper;
import com.yd.ems.storage.data.EMS_storage_classData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_storage_classService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public interface EMS_storage_classService {

	public void updateData(EMS_storage_classVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_storage_classVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_storage_classVO getData(Object[] keys);
	
	public List<EMS_storage_classData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出备品备件工具类
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}