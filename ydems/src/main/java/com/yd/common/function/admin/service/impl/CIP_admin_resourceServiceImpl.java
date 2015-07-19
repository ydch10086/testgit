package com.yd.common.function.admin.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.exception.CIPServiceException;
import com.yd.common.function.admin.data.po.CIP_admin_op_logPO;
import com.yd.common.function.admin.dao.CIP_admin_op_logDao;

import com.yd.common.function.admin.service.CIP_admin_resourceService;
import com.yd.common.function.admin.dao.CIP_admin_resourceDao;
import com.yd.common.function.admin.data.po.CIP_admin_resourcePO;
import com.yd.common.function.admin.data.vo.CIP_admin_resourceVO;
import com.yd.common.function.admin.data.key.CIP_admin_resourceKey;
import com.yd.common.function.admin.data.CIP_admin_resourceData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: CIP_admin_resourceService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public class CIP_admin_resourceServiceImpl implements CIP_admin_resourceService {
	
	@Autowired
	private CIP_admin_resourceDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;
	
	/** 
	 * 修改数据
	 */
	@Override
	public void updateData(CIP_admin_resourceVO vo, CIPRuntimeOperator operateInf){
		//TODO
		CIP_admin_resourcePO po = vo.toPO();
		Object[] keys = po.getKeys();
		CIP_admin_resourcePO po0 = dataDao.getSingle(keys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}
		
		po.setUpdate_time(operateInf.getOperate_tm());
		po.setOperator(operateInf.getSubject_id());
		
		dataDao.update(po);
		
	}
	
	/** 
	 * 添加数据
	 */
	@Override
	public void addData(CIP_admin_resourceVO vo, CIPRuntimeOperator operateInf){
		CIP_admin_resourcePO po = vo.toPO();
		Object[] keys = po.getKeys();
		CIP_admin_resourcePO po0 = dataDao.getSingle(keys);
		if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}
		
		//TODO　添加记录基本判断
		po.setCreate_time(operateInf.getOperate_tm());
		po.setOperator(operateInf.getSubject_id());
		
		dataDao.add(po);
		
	}
	
	/** 
	 * 删除数据
	 */
	@Override
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf){
		dataDao.delete(keys);
		
	}
	
	/** 
	 * 获取数据
	 */		
	@Override
	public CIP_admin_resourceVO getData(Object[] keys ){
		CIP_admin_resourcePO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<CIP_admin_resourceData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<CIP_admin_resourceData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("cip_admin_resource");
			log.setOp_obj_id("");
			log.setOp_type("E");
			log.setRemark("批量导出数据");
			log.setOperator(operateInf.getSubject_id());
			log.setCreate_time(operateInf.getOperate_tm());
			opLogDao.add(log);
		}
		return dataDao.exportEntities(page, conditions, xFirst);
	}
}