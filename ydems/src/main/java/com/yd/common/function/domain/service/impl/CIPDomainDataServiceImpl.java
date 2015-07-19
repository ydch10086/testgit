package com.yd.common.function.domain.service.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yd.common.function.domain.dao.impl.CIPCommonDaoImpl;
import com.yd.common.function.domain.service.CIPDomainDataService;

@Service
public class CIPDomainDataServiceImpl<Data> implements
		CIPDomainDataService<Data> {
	private CIPCommonDaoImpl<Data> commonDao = null;

	@Override
	public void addData(Data d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateData(Data d) {
		// TODO Auto-generated method stub

	}

	@Override
	public Data getData(Object[] keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteData(Object[] keys) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Data> getDatas() {
		// TODO Auto-generated method stub
		List<Data> datas = commonDao.getAll();
		return datas;
	}

	private String tableName;
	private String[] keys;

	@Override
	public void init(Class<?> clazz, String tableName, String[] keys) {
		this.tableName = tableName;
		this.keys = keys;
		commonDao = new CIPCommonDaoImpl<Data>((Class<Data>) clazz, tableName,
				keys);
	}

	@Override
	public boolean checkData(Data d) {
		Class c = d.getClass();
		int length = keys.length;
		Object[] values = new Object[length];
		Method m;
		try {
			for (int i = 0; i < length; i++) {
				m = c.getMethod("get" + Character.toUpperCase(keys[i].charAt(0))+keys[i].substring(1));
				values[i] = m.invoke(d, null);
			}
			Data v = commonDao.getSingle(values);
			if( v == null )
				return false;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

}
