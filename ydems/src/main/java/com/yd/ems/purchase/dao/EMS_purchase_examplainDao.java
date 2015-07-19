package com.yd.ems.purchase.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.purchase.data.po.EMS_purchase_examplainPO;
import com.yd.ems.purchase.data.EMS_purchase_examplainData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: purchase_examplain - 设备采购计划表</p>
 *
 * @since 2015-05-29 02:42:14
 */
 
@Repository
public interface EMS_purchase_examplainDao extends IDao<EMS_purchase_examplainPO> {
	
	public List<EMS_purchase_examplainData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
