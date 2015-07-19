package com.yd.ems.mainten.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.mainten.data.po.EMS_mainten_repair_planPO;
import com.yd.ems.mainten.data.EMS_mainten_repair_planData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: mainten_repair_plan - 设备大修计划表</p>
 *
 * @since 2015-05-29 02:42:12
 */
 
@Repository
public interface EMS_mainten_repair_planDao extends IDao<EMS_mainten_repair_planPO> {
	
	public List<EMS_mainten_repair_planData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
