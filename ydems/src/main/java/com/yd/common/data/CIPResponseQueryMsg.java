package com.yd.common.data;

public class CIPResponseQueryMsg extends CIPResponseMsg {

	public Object rows;
	
	//totals of returning records 
	public int total;
	
	// pages in total 
	public int total_pages;
	
	//current page position
	public int current_page;
	
	//number records of current page
	public int page_count;	
	
}
