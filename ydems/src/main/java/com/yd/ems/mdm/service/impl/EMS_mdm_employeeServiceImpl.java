package com.yd.ems.mdm.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.data.CIPResponseMsg;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.exception.CIPServiceException;
import com.yd.common.function.admin.data.po.CIP_admin_op_logPO;
import com.yd.common.function.admin.dao.CIP_admin_op_logDao;

import com.yd.ems.code.dao.EMS_code_mode_dmDao;
import com.yd.ems.code.data.po.EMS_code_mode_dmPO;
import com.yd.ems.code.data.vo.EMS_code_mode_dmVO;
import com.yd.ems.mdm.service.EMS_mdm_employeeService;
import com.yd.ems.mdm.dao.EMS_mdm_employeeDao;
import com.yd.ems.mdm.data.po.EMS_mdm_employeePO;
import com.yd.ems.mdm.data.vo.EMS_mdm_employeeVO;
import com.yd.ems.mdm.data.key.EMS_mdm_employeeKey;
import com.yd.ems.mdm.data.EMS_mdm_employeeData;
import com.yd.ems.mdm.data.EMS_mdm_lifnrData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_mdm_employeeService</p>
 *
 * @since 2015-05-29 02:42:13
 */

@Service
public class EMS_mdm_employeeServiceImpl implements EMS_mdm_employeeService {
	
	@Autowired
	private EMS_mdm_employeeDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;
	@Autowired
	private EMS_code_mode_dmDao modedataDao = null;
	
	/** 
	 * 修改数据
	 */
	@Override
	public void updateData(EMS_mdm_employeeVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_mdm_employeePO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_mdm_employeePO po0 = dataDao.getSingle(keys);
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
	public void addData(EMS_mdm_employeeVO vo, CIPRuntimeOperator operateInf){
		EMS_mdm_employeePO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_mdm_employeePO po0 = dataDao.getSingle(keys);
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
	public EMS_mdm_employeeVO getData(Object[] keys ){
		EMS_mdm_employeePO  po = dataDao.getSingle(keys);
	//	List<EMS_code_mode_dmPO> modeDataPo = modedataDao.getAll(po1);
		//po.setEmp_status(modeDataPo.get(index))
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_mdm_employeeData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		/*datas中获取到的数据中emp_status还是数据库中存储的数字类型数据*/
		List<EMS_mdm_employeeData> datas = dataDao.searchData(page, conditions);
	
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_mdm_employee");
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