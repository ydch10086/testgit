package com.yd.ems.mainten.service;

import com.yd.ems.mainten.data.po.EMS_mainten_logPO;
import com.yd.ems.mainten.data.vo.EMS_mainten_logVO;
import com.yd.ems.mainten.data.key.EMS_mainten_logKey;
import com.yd.ems.mainten.data.mapper.EMS_mainten_logMapper;
import com.yd.ems.mainten.data.EMS_mainten_logData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_mainten_logService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_mainten_logService {

	public void updateData(EMS_mainten_logVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_mainten_logVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_mainten_logVO getData(Object[] keys);
	
	public List<EMS_mainten_logData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出设备保养日志表
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}