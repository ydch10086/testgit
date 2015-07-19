package com.yd.common.conf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class CIPLocalConfigureService implements CIPConfigureService {

	private Properties props = null;

	@Override
	public void init(String fileName, String sysType) throws Exception {
		String confFile = fileName.replace("?", sysType).toLowerCase();
		InputStream stream = null;
		props = new Properties();
		stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(confFile);
		props.load(stream);
	}


	@Override
	public CIPConfigureData getConfigure(String sysId, String confId) {
		CIPConfigureData conf = new CIPConfigureData();
		conf.setConf_id(confId);
		conf.setConf_value(props.getProperty(confId));
		return conf;
	}


	@Override
	public List<CIPConfigureData> getConfigures(String sysId) {
		Enumeration<Object> es = props.keys();
		Object e = null;
		CIPConfigureData conf = null;
		List<CIPConfigureData> confs = new ArrayList<CIPConfigureData>();
		String conf_id;
		String conf_value;
		while(es.hasMoreElements()){
			e = es.nextElement();
			conf = new CIPConfigureData();
			conf_id = (String) e;
			conf_value = props.getProperty(conf_id);
			conf.setConf_id(conf_id);
			conf.setConf_value(conf_value);
			confs.add(conf);
		}
		
		return confs;
	}

}
