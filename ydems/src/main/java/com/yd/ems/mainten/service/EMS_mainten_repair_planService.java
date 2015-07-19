package com.yd.ems.mainten.service;

import com.yd.ems.mainten.data.po.EMS_mainten_repair_planPO;
import com.yd.ems.mainten.data.vo.EMS_mainten_repair_planVO;
import com.yd.ems.mainten.data.key.EMS_mainten_repair_planKey;
import com.yd.ems.mainten.data.mapper.EMS_mainten_repair_planMapper;
import com.yd.ems.mainten.data.EMS_mainten_repair_planData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_mainten_repair_planService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_mainten_repair_planService {

	public void updateData(EMS_mainten_repair_planVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_mainten_repair_planVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_mainten_repair_planVO getData(Object[] keys);
	
	public List<EMS_mainten_repair_planData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出设备大修计划表
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}