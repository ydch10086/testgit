package com.yd.ems.storage.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.ems.storage.data.EMS_storage_inout_dmData;
import com.yd.ems.storage.data.vo.EMS_storage_inout_dmVO;

/**
 * <p>Service类</p>
 * <p>Class: EMS_storage_inout_dmService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_storage_inout_dmService {

	public void updateData(EMS_storage_inout_dmVO d, CIPRuntimeOperator operateInf);
	
	public void updateOutStoreData(EMS_storage_inout_dmVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_storage_inout_dmVO d, CIPRuntimeOperator operateInf);
	
	public void addOutStoreData(EMS_storage_inout_dmVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_storage_inout_dmVO getData(Object[] keys);
	
	public List<EMS_storage_inout_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出对象类型
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}