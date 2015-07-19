package com.yd.common.function.admin.dao;

import org.springframework.stereotype.Repository;

import com.yd.common.function.admin.data.po.CIP_admin_codesPO;
import com.yd.common.function.admin.data.CIP_admin_codesData;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: admin_codes - 数据编码</p>
 *
 * @since 2015-05-21 12:44:17
 */
 
@Repository
public interface CIP_admin_codesDao extends IDao<CIP_admin_codesPO> {
	
	public List<CIP_admin_codesData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
