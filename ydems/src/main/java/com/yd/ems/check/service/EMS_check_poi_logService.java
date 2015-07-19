package com.yd.ems.check.service;

import com.yd.ems.check.data.po.EMS_check_poi_logPO;
import com.yd.ems.check.data.vo.EMS_check_poi_logVO;
import com.yd.ems.check.data.key.EMS_check_poi_logKey;
import com.yd.ems.check.data.mapper.EMS_check_poi_logMapper;
import com.yd.ems.check.data.EMS_check_poi_logData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_check_poi_logService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_check_poi_logService {

	public void updateData(EMS_check_poi_logVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_check_poi_logVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_check_poi_logVO getData(Object[] keys);
	
	public List<EMS_check_poi_logData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出设备日常点检日志
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}