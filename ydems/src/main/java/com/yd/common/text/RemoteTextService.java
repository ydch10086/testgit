package com.yd.common.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yd.common.data.CIPParameter;
import com.yd.common.data.CIPResponseMsg;
import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.utils.HttpUtils;
import com.yd.common.utils.JSONUtils;

public class RemoteTextService implements CIPTextService {

	Map<String,Map<Integer,String>> texts = new HashMap<String,Map<Integer,String>>();
	
	private void loadTexts(String lang) {
		try {
			List<CIPParameter> params = new ArrayList<CIPParameter>(2);
			CIPParameter param = new CIPParameter();
			param.setKey("sys_id");
			param.setValue(sysId);
			params.add(param);
			param = new CIPParameter();
			param.setKey("lang");
			param.setValue(lang);
			params.add(param);

			CIPResponseMsg msg = HttpUtils.post(textURL, params);
			if (msg.errorCode > 0) {
				throw new CIPRuntimeException(
						CIPErrorCode.ERROR_REMOTE_SERVER_RETURN_ERROR);
			}
			CIPTextData[] texts = JSONUtils.convertJson2Object(
					msg.data.toString(), CIPTextData[].class);
			Map<Integer,String> textMap = new HashMap<Integer,String>();
			for(int i=0; i<texts.length; ){
				textMap.put(texts[i].getText_no(), texts[i++].getText());
			}
			this.texts.put(lang, textMap);
		} catch (Exception e) {
			throw new CIPRuntimeException(
					CIPErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		}
	}

	private String textURL;
	private String sysId;
	private String lang;

	@Override
	public void init(String parameter, String sysId, String defaultLang) {
		textURL = parameter;
		lang = defaultLang;
		this.sysId = sysId;
		
		loadTexts(lang);
	}

	@Override
	public String getText(int textNo, String lang) {
		Map<Integer,String> texts = this.texts.get(lang);
		if(texts == null){
			try{
				loadTexts(lang);
				texts = this.texts.get(lang);
				if(texts != null)
					return texts.get(textNo);
			}
			catch(CIPRuntimeException e){}
			return getText(textNo);
		}
		return texts.get(textNo);
	}

	@Override
	public String getText(int textNo) {
		Map<Integer,String> texts = this.texts.get(lang);
		return texts.get(textNo);
	}

}
