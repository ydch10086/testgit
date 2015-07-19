package com.yd.common.tool.db;

public class CIPTxtField {
	private String txtField;
	private String txtFieldName;
	private String getMethod;
	private String setMethod;
	
	
	
	public String getTxtFieldName() {
		return txtFieldName;
	}
	public void setTxtFieldName(String txtFieldName) {
		this.txtFieldName = txtFieldName;
	}
	public String getTxtField() {
		return txtField;
	}
	public void setTxtField(String txtField) {
		this.txtField = txtField;
		String temp = Character.toUpperCase(txtField.charAt(0))+txtField.substring(1);
		getMethod = "get"+temp;
		setMethod = "set"+temp;
	}
	public String getGetMethod() {
		return getMethod;
	}

	public String getSetMethod() {
		return setMethod;
	}

	
}
