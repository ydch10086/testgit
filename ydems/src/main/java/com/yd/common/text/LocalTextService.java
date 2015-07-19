package com.yd.common.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.yd.common.exception.CIPRuntimeException;
import com.yd.common.runtime.CIPErrorCode;
/*
 * 
 * 本地文件命名规则：text_en.txt;text_zh.txt etc.
 * 
 */
public class LocalTextService implements CIPTextService {

	Map<String,Map<Integer,String>> texts = new HashMap<String,Map<Integer,String>>();
	
	private String fileName;
	private String lang;

	@Override
	public void init(String parameter, String sysId, String defaultLang) {
		fileName = parameter;
		lang = defaultLang;
				
		loadTexts(lang);		
	}
	
	private void loadTexts(String lang){
		String textFile = fileName.replace("?", lang).toLowerCase();
		InputStream stream = null;
		
		stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(textFile);
		Map<Integer,String> textMap = new HashMap<Integer,String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String text;
		try {
			text = br.readLine();
			String texts[];
			while(text!=null){
				texts = text.split(":");
				textMap.put(Integer.parseInt(texts[0]), texts[1]);
				text = br.readLine();
			}
			this.texts.put(lang, textMap);
		} catch (IOException e) {
			throw new CIPRuntimeException(CIPErrorCode.ERROR_RESOURCE_IS_NOT_READY, e);
		}
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
