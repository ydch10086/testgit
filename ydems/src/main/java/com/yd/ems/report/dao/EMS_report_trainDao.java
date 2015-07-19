package com.yd.ems.report.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.report.data.po.EMS_report_trainPO;
import com.yd.ems.report.data.EMS_report_trainData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: report_train - 设备培训方案表</p>
 *
 * @since 2015-05-29 02:42:14
 */
 
@Repository
public interface EMS_report_trainDao extends IDao<EMS_report_trainPO> {
	
	public List<EMS_report_trainData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
