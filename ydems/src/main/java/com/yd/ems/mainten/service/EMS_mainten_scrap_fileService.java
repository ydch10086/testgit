package com.yd.ems.mainten.service;

import com.yd.ems.mainten.data.po.EMS_mainten_scrap_filePO;
import com.yd.ems.mainten.data.vo.EMS_mainten_scrap_fileVO;
import com.yd.ems.mainten.data.key.EMS_mainten_scrap_fileKey;
import com.yd.ems.mainten.data.mapper.EMS_mainten_scrap_fileMapper;
import com.yd.ems.mainten.data.EMS_mainten_scrap_fileData;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;

/**
 * <p>Service类</p>
 * <p>Class: EMS_mainten_scrap_fileService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public interface EMS_mainten_scrap_fileService {

	public void updateData(EMS_mainten_scrap_fileVO d, CIPRuntimeOperator operateInf);
	public void addData(EMS_mainten_scrap_fileVO d, CIPRuntimeOperator operateInf);
	
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf);
	
	public EMS_mainten_scrap_fileVO getData(Object[] keys);
	
	public List<EMS_mainten_scrap_fileData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);

	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst);
	
}