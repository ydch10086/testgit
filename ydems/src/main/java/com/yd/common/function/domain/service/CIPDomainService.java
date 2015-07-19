package com.yd.common.function.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yd.common.function.admin.data.CIP_admin_codesData;
import com.yd.common.function.admin.data.vo.CIP_admin_domainVO;

@Service
public interface CIPDomainService {
	
	public CIP_admin_domainVO getDomain(String domainId);
	
	public void initDomain(String domainId);
	
	public Class<?> getDomainDataClass(String domainId);
	
	public String getDomainTableName(String domainId);
	
	public String[] getDomainTableKeys(String domainId);
	
	public String getTableName(String domainId);
	
	public boolean checkDomainCode(String domainid, String domainValue);
	
	public List<CIP_admin_codesData> getDomainCodes(String domainId);

}
