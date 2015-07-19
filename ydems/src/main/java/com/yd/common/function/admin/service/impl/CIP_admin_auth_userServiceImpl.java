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

import com.yd.common.function.admin.service.CIP_admin_auth_userService;
import com.yd.common.function.admin.dao.CIP_admin_auth_userDao;
import com.yd.common.function.admin.data.po.CIP_admin_auth_userPO;
import com.yd.common.function.admin.data.vo.CIP_admin_auth_userVO;
import com.yd.common.function.admin.data.key.CIP_admin_auth_userKey;
import com.yd.common.function.admin.data.CIP_admin_auth_userData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: CIP_admin_auth_userService</p>
 *
 * @since 2015-05-21 12:44:17
 */

@Service
public class CIP_admin_auth_userServiceImpl implements CIP_admin_auth_userService {
	
	@Autowired
	private CIP_admin_auth_userDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;
	
	/** 
	 * 修改数据
	 */
	@Override
	public void updateData(CIP_admin_auth_userVO vo, CIPRuntimeOperator operateInf){
		//TODO
		CIP_admin_auth_userPO po = vo.toPO();
		Object[] keys = po.getKeys();
		CIP_admin_auth_userPO po0 = dataDao.getSingle(keys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}
		
		
		dataDao.update(po);
		
	}
	
	/** 
	 * 添加数据
	 */
	@Override
	public void addData(CIP_admin_auth_userVO vo, CIPRuntimeOperator operateInf){
		CIP_admin_auth_userPO po = vo.toPO();
		Object[] keys = po.getKeys();
		CIP_admin_auth_userPO po0 = dataDao.getSingle(keys);
		if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}
		
		//TODO　添加记录基本判断
		
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
	public CIP_admin_auth_userVO getData(Object[] keys ){
		CIP_admin_auth_userPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<CIP_admin_auth_userData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<CIP_admin_auth_userData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("cip_admin_auth_user");
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