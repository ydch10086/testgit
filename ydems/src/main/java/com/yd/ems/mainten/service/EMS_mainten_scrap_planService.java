package com.yd.ems.mainten.service;

import com.yd.ems.mainten.data.po.EMS_mainten_scrap_planPO;
import com.yd.ems.mainten.data.vo.EMS_mainten_scrap_planVO;
import com.yd.ems.mainten.data.key.EMS_mainten_scrap_planKey;
import com.yd.ems.mainten.data.mapper.EMS_mainten_scrap_planMapper;
import com.yd.ems.mainten.data.EMS_mainten_scrap_planData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_mainten_scrap_planService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_mainten_scrap_planService {

	public void updateData(EMS_mainten_scrap_planVO d, CIPRuntimeOperator operateInf);
	/*审核报废日志*/
	public void updateScrapData(EMS_mainten_scrap_planVO d, CIPRuntimeOperator operateInf);
	public void addData(EMS_mainten_scrap_planVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_mainten_scrap_planVO getData(Object[] keys);
	
	public List<EMS_mainten_scrap_planData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出设备报废计划表
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}