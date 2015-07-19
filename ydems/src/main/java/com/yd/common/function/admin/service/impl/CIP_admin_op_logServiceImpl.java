package com.yd.common.function.admin.service.impl;

import java.util.List;
import java.util.Map;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.function.admin.dao.CIP_admin_op_logDao;

import com.yd.common.function.admin.service.CIP_admin_op_logService;
import com.yd.common.function.admin.data.CIP_admin_op_logData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: CIP_admin_op_logService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public class CIP_admin_op_logServiceImpl implements CIP_admin_op_logService {
	
	@Autowired
	private CIP_admin_op_logDao dataDao = null;

	/** 
	 * 检索数据
	 */		
	@Override
	public List<CIP_admin_op_logData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<CIP_admin_op_logData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		return dataDao.exportEntities(page, conditions, xFirst);
	}
}