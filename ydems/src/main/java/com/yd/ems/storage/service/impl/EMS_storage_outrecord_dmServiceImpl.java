package com.yd.ems.storage.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.utils.RandomNumberGenerator;
import com.yd.common.exception.CIPServiceException;
import com.yd.common.function.admin.data.po.CIP_admin_op_logPO;
import com.yd.common.function.admin.dao.CIP_admin_op_logDao;

import com.yd.ems.storage.service.EMS_storage_outrecord_dmService;
import com.yd.ems.storage.dao.EMS_storage_outrecord_dmDao;
import com.yd.ems.storage.data.po.EMS_storage_outrecord_dmPO;
import com.yd.ems.storage.data.vo.EMS_storage_outrecord_dmVO;
import com.yd.ems.storage.data.key.EMS_storage_outrecord_dmKey;
import com.yd.ems.storage.data.EMS_storage_outrecord_dmData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_storage_outrecord_dmService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public class EMS_storage_outrecord_dmServiceImpl implements EMS_storage_outrecord_dmService {
	
	@Autowired
	private EMS_storage_outrecord_dmDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;
	
	/** 
	 * 修改数据
	 */
	@Override
	public void updateData(EMS_storage_outrecord_dmVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_storage_outrecord_dmPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_storage_outrecord_dmPO po0 = dataDao.getSingle(keys);
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
	public void addData(EMS_storage_outrecord_dmVO vo, CIPRuntimeOperator operateInf){
		EMS_storage_outrecord_dmPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_storage_outrecord_dmPO po0 = dataDao.getSingle(keys);
		if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}
		int randomNum = RandomNumberGenerator.buildRandom(6);
		 String dateStr = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		po.setOutrecord_id(dateStr+String.valueOf(randomNum));
		po.setInout_type("出库操作");
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
	public EMS_storage_outrecord_dmVO getData(Object[] keys ){
		EMS_storage_outrecord_dmPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_storage_outrecord_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<EMS_storage_outrecord_dmData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_storage_outrecord_dm");
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