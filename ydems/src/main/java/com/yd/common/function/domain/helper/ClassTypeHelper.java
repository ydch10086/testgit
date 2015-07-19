package com.yd.common.function.domain.helper;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeHelper {

	private static Map<String, Class<?>> classTypes = new HashMap<String, Class<?>>();
	
	private static Map<String, Class<?>> domainTypes = new HashMap<String, Class<?>>();

	public static Class<?> getClassType(String classType ) throws Exception{
		
		Class<?> clazz = classTypes.get(classType);
		if( clazz == null ){
			clazz = Class.forName(classType);
			classTypes.put(classType, clazz);
		}
		
		return clazz;
		
	}

	public static Class<?> getDataType(String clazzName) {
		return domainTypes.get(clazzName);
	}
	
	public static void setDataType(String clazzName, Class<?> clazz){
		domainTypes.put(clazzName, clazz);
	}
}
