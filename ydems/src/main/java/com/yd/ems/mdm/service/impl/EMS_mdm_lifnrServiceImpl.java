package com.yd.ems.mdm.service.impl;

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

import com.yd.ems.mdm.service.EMS_mdm_lifnrService;
import com.yd.ems.mdm.dao.EMS_mdm_lifnrDao;
import com.yd.ems.mdm.data.po.EMS_mdm_lifnrPO;
import com.yd.ems.mdm.data.vo.EMS_mdm_lifnrVO;
import com.yd.ems.mdm.data.key.EMS_mdm_lifnrKey;
import com.yd.ems.mdm.data.EMS_mdm_lifnrData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_mdm_lifnrService</p>
 *
 * @since 2015-05-29 02:42:14
 */

@Service
public class EMS_mdm_lifnrServiceImpl implements EMS_mdm_lifnrService {
	
	@Autowired
	private EMS_mdm_lifnrDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;
	
	/** 
	 * 修改数据
	 */
	@Override
	public void updateData(EMS_mdm_lifnrVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_mdm_lifnrPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_mdm_lifnrPO po0 = dataDao.getSingle(keys);
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
	public void addData(EMS_mdm_lifnrVO vo, CIPRuntimeOperator operateInf){
		EMS_mdm_lifnrPO po = vo.toPO();//将vo转化为PO，添加了operator和op_time
		Object[] keys = po.getKeys();
		EMS_mdm_lifnrPO po0 = dataDao.getSingle(keys);
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
	public EMS_mdm_lifnrVO getData(Object[] keys ){
		EMS_mdm_lifnrPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_mdm_lifnrData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<EMS_mdm_lifnrData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_mdm_lifnr");
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