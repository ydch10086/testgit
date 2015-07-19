package com.yd.ems.code.dao;

import org.springframework.stereotype.Repository;

import com.yd.ems.code.data.po.EMS_code_bigequip_dmPO;
import com.yd.ems.code.data.EMS_code_bigequip_dmData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: bigequip_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
 
@Repository
public interface EMS_code_bigequip_dmDao extends IDao<EMS_code_bigequip_dmPO> {
	
	public List<EMS_code_bigequip_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
