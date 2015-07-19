package com.yd.ems.code.service.impl;

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

import com.yd.ems.code.service.EMS_parameterService;
import com.yd.ems.code.dao.EMS_parameterDao;
import com.yd.ems.code.data.po.EMS_parameterPO;
import com.yd.ems.code.data.vo.EMS_parameterVO;
import com.yd.ems.code.data.EMS_parameterData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_parameterService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public class EMS_parameterServiceImpl implements EMS_parameterService {
	
	@Autowired
	private EMS_parameterDao dataDao = null;
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
	 * 修改数据
	 */
	@Override
	public void updateData(EMS_parameterVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_parameterPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_parameterPO po0 = dataDao.getSingle(keys);
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
	public void addData(EMS_parameterVO vo, CIPRuntimeOperator operateInf){
		EMS_parameterPO po = vo.toPO();
		Object[] keys = po.getKeys();
		/*po对象中多了操作者和修改时间两个实体属性*/
		EMS_parameterPO po0 = dataDao.getSingle(keys);
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
	public EMS_parameterVO getData(Object[] keys ){
		EMS_parameterPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_parameterData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<EMS_parameterData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_parameter");
			log.setOp_obj_id("");
			log.setOp_type("E");
			log.setRemark("批量导出数据");
			log.setOperator(operateInf.getSubject_id());
			log.setCreate_time(operateInf.getOperate_tm());
			opLogDao.add(log);
		}
		return dataDao.exportEntities(page, conditions, xFirst);
	}

	//为某个对象类型添加具体的设备
	@Override
	public void addEquipData(EMS_parameterVO vo, CIPRuntimeOperator operateInf) {
		/** 
		 * 添加数据
		 */
		EMS_parameterPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_parameterPO po0 = parameterDao.getSingle(keys);;
		if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}
		//TODO　添加记录基本判断
		po.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		po.setOp_time(operateInf.getOperate_tm());
		
		parameterDao.add(po);
	}
		
}