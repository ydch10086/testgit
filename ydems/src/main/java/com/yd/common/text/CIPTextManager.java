package com.yd.common.text;

import com.yd.common.runtime.CIPRuntimeConfigure;

public class CIPTextManager {
	
	private static CIPTextService textService = null;
	
	public static void init(){
		if(CIPRuntimeConfigure.cip_text_xremote){
			textService = new RemoteTextService();
			textService.init(CIPRuntimeConfigure.cip_text_remote_url,
							 CIPRuntimeConfigure.cip_system_id,
							 CIPRuntimeConfigure.cip_default_lang);
		}
		else {
			textService = new LocalTextService();
			textService.init(CIPRuntimeConfigure.cip_text_local_file,
					 		 CIPRuntimeConfigure.cip_system_id,
					 		 CIPRuntimeConfigure.cip_default_lang);
		}
	}
	
	public static String getText(int textNo, String lang){
		return textService.getText(textNo, lang);
	}
	
	public static String getText(int textNo){
		return textService.getText(textNo);
	}
}
