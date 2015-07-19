package com.yd.ems.code.service;

import com.yd.ems.code.data.vo.EMS_code_type_dmVO;
import com.yd.ems.code.data.vo.EMS_parameterVO;
import com.yd.ems.code.data.EMS_code_type_dmData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_code_type_dmService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_code_type_dmService {

	public void updateData(EMS_code_type_dmVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_code_type_dmVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_code_type_dmVO getData(Object[] keys);
	
	public void addEquipData(EMS_parameterVO d, CIPRuntimeOperator operateInf);
	
	public List<EMS_code_type_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出对象类型
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}