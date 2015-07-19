package com.yd.ems.code.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.ems.code.data.EMS_store_spare_dmData;
import com.yd.ems.code.data.po.EMS_store_spare_dmPO;

/**
 * <p>Dao类</p>
 * <p>Class: code_spare_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
 
@Repository
public interface EMS_store_spare_dmDao extends IDao<EMS_store_spare_dmPO> {
	
	public List<EMS_store_spare_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
