package com.yd.ems.code.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.ems.code.data.EMS_store_spare_dmData;
import com.yd.ems.code.data.vo.EMS_store_spare_dmVO;

/**
 * <p>Service类</p>
 * <p>Class: EMS_storage_spare_dmService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_store_spare_dmService {

	public void updateData(EMS_store_spare_dmVO d, CIPRuntimeOperator operateInf);
	
	public void addStoreData(EMS_store_spare_dmVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_store_spare_dmVO getData(Object[] keys);
	
	public List<EMS_store_spare_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出对象类型
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}