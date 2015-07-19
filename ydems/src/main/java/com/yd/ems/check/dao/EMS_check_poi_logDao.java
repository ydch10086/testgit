package com.yd.ems.check.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.check.data.po.EMS_check_poi_logPO;
import com.yd.ems.check.data.EMS_check_poi_logData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: check_poi_log - 设备日常点检日志</p>
 *
 * @since 2015-05-29 02:42:12
 */
 
@Repository
public interface EMS_check_poi_logDao extends IDao<EMS_check_poi_logPO> {
	
	public List<EMS_check_poi_logData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
