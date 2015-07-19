package com.yd.ems.code.service;

import com.yd.ems.code.data.po.EMS_code_mode_dmPO;
import com.yd.ems.code.data.vo.EMS_code_mode_dmVO;
import com.yd.ems.code.data.key.EMS_code_mode_dmKey;
import com.yd.ems.code.data.mapper.EMS_code_mode_dmMapper;
import com.yd.ems.code.data.EMS_code_mode_dmData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_code_mode_dmService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_code_mode_dmService {

	public void updateData(EMS_code_mode_dmVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_code_mode_dmVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_code_mode_dmVO getData(Object[] keys);
	
	public List<EMS_code_mode_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出设备型号类型
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}