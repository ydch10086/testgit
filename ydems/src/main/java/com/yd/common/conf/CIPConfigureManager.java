package com.yd.common.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yd.common.runtime.CIPRuntimeConfigure;

public class CIPConfigureManager {

	private static CIPConfigureService configureService = null;

	public static void init() throws Exception {
		if (CIPRuntimeConfigure.cip_is_remote_conf) {
			configureService = new CIPRemoteConfigureService();
			configureService.init(CIPRuntimeConfigure.cip_remote_conf_url, CIPRuntimeConfigure.cip_system_type );
		} else {
			configureService = new CIPLocalConfigureService();
			configureService.init(CIPRuntimeConfigure.cip_local_conf_file, CIPRuntimeConfigure.cip_system_type);
		}
		
	}

	public static String getConfigure(String confId) {
		CIPConfigureData conf = configureService.getConfigure(CIPRuntimeConfigure.cip_system_id, confId);
		return conf.getConf_value();
	}

	public static String getConfigureText(String confId) {
		CIPConfigureData conf = configureService.getConfigure(CIPRuntimeConfigure.cip_system_id, confId);
		return conf.getConf_txt();
	}

	public static Map<String, String> getConfigures() {
		List<CIPConfigureData> confs = configureService.getConfigures(CIPRuntimeConfigure.cip_system_id);
		Map<String,String> m = new HashMap<String,String>();
		for(CIPConfigureData conf:confs){
			m.put(conf.getConf_id(), conf.getConf_value());
		}
		return m;
	}

	public static Map<String, String> getConfigureTexts() {
		List<CIPConfigureData> confs = configureService.getConfigures(CIPRuntimeConfigure.cip_system_id);
		Map<String,String> m = new HashMap<String,String>();
		for(CIPConfigureData conf:confs){
			m.put(conf.getConf_id(), conf.getConf_txt());
		}
		return m;
	}
}
