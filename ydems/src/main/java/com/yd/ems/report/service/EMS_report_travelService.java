package com.yd.ems.report.service;

import com.yd.ems.report.data.po.EMS_report_travelPO;
import com.yd.ems.report.data.vo.EMS_report_travelVO;
import com.yd.ems.report.data.key.EMS_report_travelKey;
import com.yd.ems.report.data.mapper.EMS_report_travelMapper;
import com.yd.ems.report.data.EMS_report_travelData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_report_travelService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public interface EMS_report_travelService {

	public void updateData(EMS_report_travelVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_report_travelVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_report_travelVO getData(Object[] keys);
	
	public List<EMS_report_travelData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出人员出差报告
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}