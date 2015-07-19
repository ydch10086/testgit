package com.yd.common.data;

public class CIPReqCondition {
	private String fieldName;
	private int operator=0; // 0: =; 1: >; 2 <;3>=;4<=; 5 not equal;
	private String highValue;
	private String lowValue;
	private String[] values;
	
	
	
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public String getHighValue() {
		return highValue;
	}
	public void setHighValue(String highValue) {
		this.highValue = highValue;
	}
	public String getLowValue() {
		return lowValue;
	}
	public void setLowValue(String lowValue) {
		this.lowValue = lowValue;
	}
	@Override
	public String toString() {
		return "CIPReqCondition [fieldName=" + fieldName + ", operator="
				+ operator + ", highValue=" + highValue + ", lowValue="
				+ lowValue + "]";
	}
	
	
}
