package com.yd.ems.storage.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.storage.data.po.EMS_storage_objectPO;
import com.yd.ems.storage.data.EMS_storage_objectData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: storage_object - 设备信息</p>
 *
 * @since 2015-05-29 02:42:14
 */
 
@Repository
public interface EMS_storage_objectDao extends IDao<EMS_storage_objectPO> {
	
	public List<EMS_storage_objectData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
