package com.yd.ems.storage.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.utils.RandomNumberGenerator;
import com.yd.common.exception.CIPServiceException;
import com.yd.common.function.admin.data.po.CIP_admin_op_logPO;
import com.yd.common.function.admin.dao.CIP_admin_op_logDao;

import com.yd.ems.code.dao.EMS_parameterDao;
import com.yd.ems.storage.dao.EMS_storage_inout_dmDao;
import com.yd.ems.storage.data.EMS_storage_inout_dmData;
import com.yd.ems.storage.data.po.EMS_storage_inout_dmPO;
import com.yd.ems.storage.data.vo.EMS_storage_inout_dmVO;
import com.yd.ems.storage.service.EMS_storage_inout_dmService;


import org.apache.http.impl.cookie.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_storage_inout_dmService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public class EMS_storage_inout_dmServiceImpl implements EMS_storage_inout_dmService {
	
	@Autowired
	private EMS_storage_inout_dmDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;
	@Autowired
	private EMS_parameterDao parameterDao = null;
	public EMS_parameterDao getParameterDao() {
		return parameterDao;
	}

	public void setParameterDao(EMS_parameterDao parameterDao) {
		this.parameterDao = parameterDao;
	}

	/** 
	 * 入库操作
	 */
	@Override
	public void updateData(EMS_storage_inout_dmVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_storage_inout_dmPO storePO = vo.toPO();
		Object[] storekeys = storePO.getKeys();
		EMS_storage_inout_dmPO po0 = dataDao.getSingle(storekeys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}	
		storePO.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		dataDao.update(storePO);
		
	}
	
	/** 
	 * 出库操作
	 */
	@Override
	public void updateOutStoreData(EMS_storage_inout_dmVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_storage_inout_dmPO storePO = vo.toPO();
		Object[] storekeys = storePO.getKeys();
		EMS_storage_inout_dmPO po0 = dataDao.getSingle(storekeys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}
		storePO.setOperator(Integer.parseInt(operateInf.getSubject_id()));			
		dataDao.update(storePO);
		
	}
	
	/** 
	 * 添加入库数据
	 */
	@Override
	public void addData(EMS_storage_inout_dmVO vo, CIPRuntimeOperator operateInf){
		EMS_storage_inout_dmPO po = vo.toPO();
		String dateStr = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		Object[] keys = po.getKeys();
		//EMS_storage_inout_dmPO po0 = dataDao.getSingle(keys);
		/*if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}*/
		//TODO　添加记录基本判断
		int randomNum = RandomNumberGenerator.buildRandom(6);
		po.setInout_id(dateStr+String.valueOf(randomNum));
		po.setInout_type("入库操作");
		po.setSpare_out_store_num(BigDecimal.valueOf(0));
		po.setOperator(Integer.parseInt(operateInf.getSubject_id()));
		po.setOut_store_time("0000-00-00");
		po.setOp_time(operateInf.getOperate_tm());
		dataDao.add(po);
		
	}

	/** 
	 * 添加出库数据
	 */
	@Override
	public void addOutStoreData(EMS_storage_inout_dmVO vo, CIPRuntimeOperator operateInf){
		EMS_storage_inout_dmPO po = vo.toPO();
		Date date = new Date();
		String dateStr = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		Object[] keys = po.getKeys();
		//EMS_storage_inout_dmPO po0 = dataDao.getSingle(keys);
		/*if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}*/
		//TODO　添加记录基本判断
		int randomNum = RandomNumberGenerator.buildRandom(6);
		po.setInout_id(dateStr+String.valueOf(randomNum));
		po.setInout_type("出库操作");
		po.setStore_time("0000-00-00");
		po.setSpare_in_store_num(BigDecimal.valueOf(0));
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
	public EMS_storage_inout_dmVO getData(Object[] keys ){
		EMS_storage_inout_dmPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_storage_inout_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<EMS_storage_inout_dmData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_storage_inout_dm");
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