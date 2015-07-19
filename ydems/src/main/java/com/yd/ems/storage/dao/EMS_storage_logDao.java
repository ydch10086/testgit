package com.yd.ems.storage.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.storage.data.po.EMS_storage_logPO;
import com.yd.ems.storage.data.EMS_storage_logData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: storage_log - 备品备件工具库存日志</p>
 *
 * @since 2015-05-29 02:42:14
 */
 
@Repository
public interface EMS_storage_logDao extends IDao<EMS_storage_logPO> {
	
	public List<EMS_storage_logData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
