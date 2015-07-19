package com.yd.ems.storage.service;

import com.yd.ems.storage.data.po.EMS_storage_op_docPO;
import com.yd.ems.storage.data.vo.EMS_storage_op_docVO;
import com.yd.ems.storage.data.key.EMS_storage_op_docKey;
import com.yd.ems.storage.data.mapper.EMS_storage_op_docMapper;
import com.yd.ems.storage.data.EMS_storage_op_docData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_storage_op_docService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public interface EMS_storage_op_docService {

	public void updateData(EMS_storage_op_docVO d, CIPRuntimeOperator operateInf);
	
	public void addData(EMS_storage_op_docVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_storage_op_docVO getData(Object[] keys);
	
	public List<EMS_storage_op_docData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出物料操作凭证
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}