package com.yd.ems.code.service;

import com.yd.ems.code.data.vo.EMS_parameterVO;
import com.yd.ems.code.data.EMS_parameterData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_parameterService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_parameterService {

	public void updateData(EMS_parameterVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_parameterVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_parameterVO getData(Object[] keys);
	
	public void addEquipData(EMS_parameterVO d, CIPRuntimeOperator operateInf);
	
	public List<EMS_parameterData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出对象类型
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}