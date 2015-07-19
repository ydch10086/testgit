package com.yd.ems.purchase.service;

import com.yd.ems.purchase.data.vo.EMS_purchase_examplainVO;
import com.yd.ems.purchase.data.EMS_purchase_examplainData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_purchase_examplainService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public interface EMS_purchase_examplainService {

	public void updateData(EMS_purchase_examplainVO d, CIPRuntimeOperator operateInf);
	public void updateStatusData(EMS_purchase_examplainVO d, CIPRuntimeOperator operateInf);
	public void addData(EMS_purchase_examplainVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_purchase_examplainVO getData(Object[] keys);
	
	public List<EMS_purchase_examplainData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出设备采购计划表
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}