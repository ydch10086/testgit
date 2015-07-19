package com.yd.common.conf;

import java.util.List;

public interface CIPConfigureService {

	public void init(String parameter, String systemType) throws Exception;
	
	public CIPConfigureData getConfigure(String sysId, String confId);

	public List<CIPConfigureData> getConfigures(String sysId);

}
