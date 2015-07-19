package com.yd.ems.report.service;

import com.yd.ems.report.data.po.EMS_report_trainPO;
import com.yd.ems.report.data.vo.EMS_report_trainVO;
import com.yd.ems.report.data.key.EMS_report_trainKey;
import com.yd.ems.report.data.mapper.EMS_report_trainMapper;
import com.yd.ems.report.data.EMS_report_trainData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_report_trainService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public interface EMS_report_trainService {

	public void updateData(EMS_report_trainVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_report_trainVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_report_trainVO getData(Object[] keys);
	
	public List<EMS_report_trainData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出设备培训方案表
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}