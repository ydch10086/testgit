package com.yd.common.function.admin.service;

import com.yd.common.function.admin.data.po.CIP_admin_op_logPO;
import com.yd.common.function.admin.data.vo.CIP_admin_op_logVO;
import com.yd.common.function.admin.data.key.CIP_admin_op_logKey;
import com.yd.common.function.admin.data.mapper.CIP_admin_op_logMapper;
import com.yd.common.function.admin.data.CIP_admin_op_logData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: CIP_admin_op_logService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public interface CIP_admin_op_logService {

	public List<CIP_admin_op_logData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);


	/** 
	 * 导出系统操作日志
	 */
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}