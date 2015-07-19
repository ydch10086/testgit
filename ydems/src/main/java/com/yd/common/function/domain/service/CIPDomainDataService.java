package com.yd.common.function.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CIPDomainDataService<Data> {
	public void addData(Data d);
	
	public void updateData(Data d);
	
	public void deleteData(Object[] keys);
	
	public Data getData(Object[] keys);


	List<Data> getDatas();
	
	public boolean checkData(Data d);
	
	void init(Class<?> clazz, String tableName, String[] keys);
}
