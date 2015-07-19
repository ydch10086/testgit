package com.yd.common.data;

public class CIPReqParameter {
	private int rows = 30;  //每页显示条数
	private int page = 1;
	private String search_condition = null;
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSearch_condition() {
		return search_condition;
	}
	public void setSearch_condition(String search_condition) {
		this.search_condition = search_condition;
	}
	
	
	
}
