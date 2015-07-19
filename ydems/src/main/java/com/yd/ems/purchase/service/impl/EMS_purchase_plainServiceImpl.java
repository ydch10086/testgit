package com.yd.ems.purchase.service.impl;

import java.math.BigDecimal;
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

import com.yd.ems.purchase.service.EMS_purchase_plainService;
import com.yd.ems.purchase.dao.EMS_purchase_plainDao;
import com.yd.ems.purchase.data.po.EMS_purchase_plainPO;
import com.yd.ems.purchase.data.po.EMS_purchase_plainPO;
import com.yd.ems.purchase.data.vo.EMS_purchase_plainVO;
import com.yd.ems.purchase.data.vo.EMS_purchase_plainVO;
import com.yd.ems.purchase.data.key.EMS_purchase_plainKey;
import com.yd.ems.purchase.data.EMS_purchase_plainData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_purchase_plainService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public class EMS_purchase_plainServiceImpl implements EMS_purchase_plainService {
	
	@Autowired
	private EMS_purchase_plainDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;
	
	/** 
	 * 修改数据
	 */
	@Override
	public void updateData(EMS_purchase_plainVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_purchase_plainPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_purchase_plainPO po0 = dataDao.getSingle(keys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}
		po.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		po.setOp_time(operateInf.getOperate_tm());
		dataDao.update(po);
		
	}
	
	/** 
	 * 审核采购计划
	 */
	@Override
	public void updateStatusData(EMS_purchase_plainVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_purchase_plainPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_purchase_plainPO po0 = dataDao.getSingle(keys);
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
	public void addData(EMS_purchase_plainVO vo, CIPRuntimeOperator operateInf){
		EMS_purchase_plainPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_purchase_plainPO po0 = dataDao.getSingle(keys);
		if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}
		
		po.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		po.setOp_time(operateInf.getOperate_tm());
		po.setExa_date("0000-00-00");
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
	public EMS_purchase_plainVO getData(Object[] keys ){
		EMS_purchase_plainPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_purchase_plainData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<EMS_purchase_plainData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_purchase_plain");
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