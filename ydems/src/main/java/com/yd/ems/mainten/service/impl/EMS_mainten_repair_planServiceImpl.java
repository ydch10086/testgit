package com.yd.ems.mainten.service.impl;

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

import com.yd.ems.mainten.service.EMS_mainten_repair_planService;
import com.yd.ems.mainten.dao.EMS_mainten_repair_planDao;
import com.yd.ems.mainten.data.po.EMS_mainten_repair_planPO;
import com.yd.ems.mainten.data.vo.EMS_mainten_repair_planVO;
import com.yd.ems.mainten.data.key.EMS_mainten_repair_planKey;
import com.yd.ems.mainten.data.EMS_mainten_repair_planData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_mainten_repair_planService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public class EMS_mainten_repair_planServiceImpl implements EMS_mainten_repair_planService {
	
	@Autowired
	private EMS_mainten_repair_planDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;
	
	/** 
	 * 修改数据
	 */
	@Override
	public void updateData(EMS_mainten_repair_planVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_mainten_repair_planPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_mainten_repair_planPO po0 = dataDao.getSingle(keys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}
		
		po.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		
		po.setOp_time(operateInf.getOperate_tm());
		
		dataDao.update(po);
		
	}
	
	/** 
	 * 添加数据
	 */
	@Override
	public void addData(EMS_mainten_repair_planVO vo, CIPRuntimeOperator operateInf){
		EMS_mainten_repair_planPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_mainten_repair_planPO po0 = dataDao.getSingle(keys);
		if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}
		
		//TODO　添加记录基本判断
		po.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		po.setOp_time(operateInf.getOperate_tm());
		
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
	public EMS_mainten_repair_planVO getData(Object[] keys ){
		EMS_mainten_repair_planPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_mainten_repair_planData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<EMS_mainten_repair_planData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_mainten_repair_plan");
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