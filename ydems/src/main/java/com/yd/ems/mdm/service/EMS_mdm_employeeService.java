package com.yd.ems.mdm.service;

import com.yd.ems.mdm.data.po.EMS_mdm_employeePO;
import com.yd.ems.mdm.data.vo.EMS_mdm_employeeVO;
import com.yd.ems.mdm.data.key.EMS_mdm_employeeKey;
import com.yd.ems.mdm.data.mapper.EMS_mdm_employeeMapper;
import com.yd.ems.mdm.data.EMS_mdm_employeeData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_mdm_employeeService</p>
 *
 * @since 2015-05-29 02:42:13
 */

@Service
public interface EMS_mdm_employeeService {

	public void updateData(EMS_mdm_employeeVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_mdm_employeeVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_mdm_employeeVO getData(Object[] keys);
	
	public List<EMS_mdm_employeeData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出人员主数据信息
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}