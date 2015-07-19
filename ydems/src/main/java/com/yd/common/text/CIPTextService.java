package com.yd.common.text;

public interface CIPTextService {

	
	public String getText(int textNo, String lang);
	
	public String getText(int textNo);
	
	public void init(String parameter, String sysId, String defaultLang);
	
}
