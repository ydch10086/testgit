package com.yd.ems.mdm.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.mdm.data.po.EMS_mdm_lifnrPO;
import com.yd.ems.mdm.data.EMS_mdm_lifnrData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: mdm_lifnr - 供应商基础信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
 
@Repository
public interface EMS_mdm_lifnrDao extends IDao<EMS_mdm_lifnrPO> {
	
	public List<EMS_mdm_lifnrData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
