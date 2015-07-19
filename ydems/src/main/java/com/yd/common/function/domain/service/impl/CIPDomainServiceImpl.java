package com.yd.common.function.domain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.function.admin.dao.CIP_admin_codesDao;
import com.yd.common.function.admin.dao.CIP_admin_domainDao;
import com.yd.common.function.admin.data.CIP_admin_codesData;
import com.yd.common.function.admin.data.po.CIP_admin_codesPO;
import com.yd.common.function.admin.data.po.CIP_admin_domainPO;
import com.yd.common.function.admin.data.vo.CIP_admin_domainVO;
import com.yd.common.function.domain.dao.CIPDomainMetaDao;
import com.yd.common.function.domain.helper.ClassTypeHelper;
import com.yd.common.function.domain.helper.PojoGenerator;
import com.yd.common.function.domain.service.CIPDomainService;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.tool.db.model.CIPColumn;
import com.yd.common.tool.db.model.CIPTable;

@Service
public class CIPDomainServiceImpl implements CIPDomainService {

	@Autowired
	private CIP_admin_domainDao domainDao;
	@Autowired
	private CIP_admin_codesDao codeDao;
	@Autowired
	private CIPDomainMetaDao domainMetaDao;

	private Map<String, String> domains = new HashMap<String, String>();
	
	private Map<String, String[]> domainKeys = new HashMap<String, String[]>();
	
	
	@Override
	public CIP_admin_domainVO getDomain(String domainId) {
		return domainDao.getSingle(domainId).toVO();
	}

	private final static String clazzPackage = "com.yd.common.domain.data.";

	@Override
	public Class<?> getDomainDataClass(String domainId) {
		String tableName = domains.get(domainId);
		if(tableName == null)
			return null;

		String clazzName = clazzPackage + tableName;
		return ClassTypeHelper.getDataType(clazzName);
	}

	@Override
	public void initDomain(String domainId) {
		String tableName = domains.get(domainId);
		Class<?> clazz = null;
		try {
			String[] keys;
			String clazzName = clazzPackage + tableName;
			if( tableName != null ){
				clazz = ClassTypeHelper.getDataType(clazzName);
				if (clazz != null)
					return;
			}
				
			CIP_admin_domainPO meta = domainDao.getSingle(domainId);
			tableName = meta.getRef_table_id();
			if (tableName == null || "".equals(tableName)) {
				tableName = domainId;
			}
							
			Class<?> typeClazz = null;
			String classType = null;
						
			CIPTable table = domainMetaDao.getDomainTable(tableName);
			List<CIPColumn> cKeys = table.getPrimaryKeys();
			int length = cKeys.size();
			keys = new String[length];
			for (int i = 0; i < length;i++) {
				keys[i] = cKeys.get(i).getColumnName();
			}

			List<CIPColumn> columns = table.getColumns();

			Map<String, Class<?>> props = new HashMap<String, Class<?>>(
					columns.size());
			for (CIPColumn column : columns) {
				classType = column.getFullJavaType();
				typeClazz = ClassTypeHelper.getClassType(classType);
				props.put(column.getColumnName(), typeClazz);
			}
			
			clazzName = clazzPackage + tableName;
			clazz = PojoGenerator.generate(clazzName, props);

			ClassTypeHelper.setDataType(clazzName, clazz);
			
			domains.put(domainId, tableName);
			domainKeys.put(domainId, keys);
		} catch (Exception e) {
			throw new CIPRuntimeException(
					CIPErrorCode.ERROR_RESOURCE_IS_NOT_READY, e);
		}
	}

	@Override
	public String getDomainTableName(String domainId) {
		return domains.get(domainId);
	}

	@Override
	public String[] getDomainTableKeys(String domainId) {
		return domainKeys.get(domainId);
	}


	@Override
	public String getTableName(String domainId) {
		CIP_admin_domainPO po = domainDao.getSingle(domainId);
		if( po != null ){
			String ref_domain_id = po.getRef_domain_id(); 
			if(ref_domain_id==null || !ref_domain_id.equals("") ){
				po = domainDao.getSingle(domainId);
			}
			if( po!= null )
				return po.getRef_table_id();
		}
		return null;
	}
	
	private final String C_FIELD_DOMAIN_ID = "domain_id";
	private CIPReqCondition[] conditions = new CIPReqCondition[]{new CIPReqCondition()};
	private CIPPageInfo defaultPage = new CIPPageInfo(1,100);
	
	@Override
	public List<CIP_admin_codesData> getDomainCodes(String domainId) {
		conditions[0].setFieldName(C_FIELD_DOMAIN_ID);
		conditions[0].setLowValue(domainId);
		
		return codeDao.searchData(defaultPage, conditions);
	}

	@Override
	public boolean checkDomainCode(String domainid, String domainValue) {
		CIP_admin_codesPO po = codeDao.getSingle(domainValue,domainid);
		if(po != null)
			return true;
		return false;
	}

}
