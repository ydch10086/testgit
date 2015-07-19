package com.yd.common.data;

public enum CIPOperatorType {
	EQUAL(0, "="),
	GREAT_THAN(1, ">"),
	LESS_THAN(2,"<"),
	GREAT_EQUAL(3,">="),
	LESS_EQUAL(4,"<="),
	NOT_EQUAL(5,"!="),
	BETWEEN(6,"between"),
	IN(7,"in");
	
	public final int code;
	public final String name;
	private CIPOperatorType(int code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static String getName(int code){
		for (CIPOperatorType d : CIPOperatorType.values()) {  
            if (d.code == code) {  
                return d.name;  
            }  
        }  
        return null; 
	}
	
}
