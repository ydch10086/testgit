package com.yd.ems.storage.dao;

import org.springframework.stereotype.Repository;
import com.yd.ems.storage.data.EMS_storage_inrecord_dmData;
import com.yd.ems.storage.data.po.EMS_storage_inrecord_dmPO;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: storage_inrecord_dm - 出库记录</p>
 *
 * @since 2015-05-29 02:42:12
 */
 
@Repository
public interface EMS_storage_inrecord_dmDao extends IDao<EMS_storage_inrecord_dmPO> {
	
	public List<EMS_storage_inrecord_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
