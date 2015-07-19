package com.yd.ems.mdm.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.mdm.data.po.EMS_mdm_orgehPO;
import com.yd.ems.mdm.data.EMS_mdm_orgehData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: mdm_orgeh - 组织机构主数据</p>
 *
 * @since 2015-05-29 02:42:14
 */
 
@Repository
public interface EMS_mdm_orgehDao extends IDao<EMS_mdm_orgehPO> {
	
	public List<EMS_mdm_orgehData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
