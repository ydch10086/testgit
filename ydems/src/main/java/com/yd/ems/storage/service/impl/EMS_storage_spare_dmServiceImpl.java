package com.yd.ems.storage.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.exception.CIPServiceException;
import com.yd.common.function.admin.data.po.CIP_admin_op_logPO;
import com.yd.common.function.admin.dao.CIP_admin_op_logDao;

import com.yd.ems.code.dao.EMS_parameterDao;
import com.yd.ems.storage.dao.EMS_storage_spare_dmDao;
import com.yd.ems.storage.data.EMS_storage_spare_dmData;
import com.yd.ems.storage.data.po.EMS_storage_spare_dmPO;
import com.yd.ems.storage.data.vo.EMS_storage_spare_dmVO;
import com.yd.ems.storage.service.EMS_storage_spare_dmService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_storage_spare_dmService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public class EMS_storage_spare_dmServiceImpl implements EMS_storage_spare_dmService {
	
	@Autowired
	private EMS_storage_spare_dmDao dataDao = null;
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
	public void updateData(EMS_storage_spare_dmVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_storage_spare_dmPO storePO = vo.toPO();
		Object[] storekeys = storePO.getKeys();
		EMS_storage_spare_dmPO po0 = dataDao.getSingle(storekeys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}
		/*获取数据库中已经入库的数据*/
		BigDecimal hasInStoreNum = po0.getSpare_in_store_num();
		/*获取已经出库数量*/
		BigDecimal hasOutStoreNum = po0.getSpare_out_store_num();
		/*页面中要入库的数据*/
		BigDecimal beInStoreNum = storePO.getSpare_in_store_num();
		/*数据库中总的入库数 = 已入库数据+要入库数据*/
		BigDecimal dbInStoreData = hasInStoreNum.add(beInStoreNum);
		/*计算最终库存 = 数据库总的入库数-已出库数量*/
		BigDecimal nowStore = dbInStoreData.subtract(hasOutStoreNum);
		storePO.setSpare_in_store_num(dbInStoreData);
		storePO.setSpare_store_num(nowStore);
		storePO.setSpare_out_store_num(hasOutStoreNum);
		storePO.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		storePO.setOp_time(operateInf.getOperate_tm());
		dataDao.update(storePO);
		
	}
	
	/** 
	 * 出库操作
	 */
	@Override
	public void updateOutStoreData(EMS_storage_spare_dmVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_storage_spare_dmPO storePO = vo.toPO();
		Object[] storekeys = storePO.getKeys();
		EMS_storage_spare_dmPO po0 = dataDao.getSingle(storekeys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}
		/*获取数据库中已经入库的数据*/
		BigDecimal hasInStoreNum = po0.getSpare_in_store_num();
		/*页面中要出库的数据*/
		BigDecimal beOutStoreNum = storePO.getSpare_out_store_num();
		/*获取数据库中已经出库数量*/
		BigDecimal hasOutStoreNum = po0.getSpare_out_store_num();
		/*数据库中总的出库数 = 已出库数据+要出库数据*/
		BigDecimal dbOutStoreData = hasOutStoreNum.add(beOutStoreNum);
		/*最终库存 = 已入库数 - 出库数*/
		BigDecimal nowStore = hasInStoreNum.subtract(dbOutStoreData);
		storePO.setSpare_out_store_num(dbOutStoreData);
		storePO.setSpare_store_num(nowStore);
		storePO.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		storePO.setOp_time(operateInf.getOperate_tm());
		
		dataDao.update(storePO);
		
	}
	
	/** 
	 * 添加数据
	 */
	@Override
	public void addData(EMS_storage_spare_dmVO vo, CIPRuntimeOperator operateInf){
		EMS_storage_spare_dmPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_storage_spare_dmPO po0 = dataDao.getSingle(keys);
		if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}
		po.setSpare_out_store_num(BigDecimal.valueOf(0));//新增入库时出库数量为0
		po.setSpare_store_num(BigDecimal.valueOf(0));//新增入库时库存数量为0
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
	public EMS_storage_spare_dmVO getData(Object[] keys ){
		EMS_storage_spare_dmPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_storage_spare_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<EMS_storage_spare_dmData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_storage_spare_dm");
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