package com.yd.ems.mdm.service;

import com.yd.ems.mdm.data.po.EMS_mdm_orgehPO;
import com.yd.ems.mdm.data.vo.EMS_mdm_orgehVO;
import com.yd.ems.mdm.data.key.EMS_mdm_orgehKey;
import com.yd.ems.mdm.data.mapper.EMS_mdm_orgehMapper;
import com.yd.ems.mdm.data.EMS_mdm_orgehData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_mdm_orgehService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public interface EMS_mdm_orgehService {

	public void updateData(EMS_mdm_orgehVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_mdm_orgehVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_mdm_orgehVO getData(Object[] keys);
	
	public List<EMS_mdm_orgehData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出组织机构主数据
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}