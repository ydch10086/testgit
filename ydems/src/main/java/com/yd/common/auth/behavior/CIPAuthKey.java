package com.yd.common.auth.behavior;

import java.util.HashMap;
import java.util.Map;

public class CIPAuthKey {
	private Map<String,String> attributes = null;
	
	private Map<String,String> values = new HashMap<String,String>();
	
	private String objectId;
	
	public CIPAuthKey(String objectId, Map<String,String> attributes){
		this.objectId = objectId;
		this.attributes = attributes;
		values = new HashMap<String,String>(attributes.size());
	}
	
	public String getObjectId() {
		return objectId;
	}

	public void setAuthValue(String attrId, String attrValue){
		if(attributes.get(attrId)!= null){
			values.put(attrId, attrValue);
		}
	}
	
	public Map<String,String> getAuthValues(){
		return values;
	}
	
	public void clear(){
		values.clear();
	}
	
}
