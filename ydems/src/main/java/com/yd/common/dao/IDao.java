package com.yd.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.exception.CIPDaoException;


@Repository
public interface IDao<Data> {
	boolean add(Data d) throws CIPDaoException;
	boolean batchAdd(List<Data> ds) throws CIPDaoException;
	boolean update(Data d) throws CIPDaoException;
	boolean updateKV(Map<String, Object> map, Object... keys) throws CIPDaoException;
	boolean batchUpdateKV(List<Map<String,Object>> list, List<Object[]>keysList) throws CIPDaoException;
	boolean batchUpdate(List<Data> ds) throws CIPDaoException;
	boolean delete(Object... keys) throws CIPDaoException;
	boolean batchDelete(List<Object []> keysArr) throws CIPDaoException;
	
	boolean isExist(Object... keys) throws CIPDaoException;
	boolean isUsable(Object... keys) throws CIPDaoException;
	
	Data getSingle(Object... keys) throws CIPDaoException;
	
	List<Data> getAll() throws CIPDaoException;
	
	List<Data> getAll(Object... keys) throws CIPDaoException;
	
	int getAllCount() throws CIPDaoException;
	List<Data> getAll(CIPPageInfo page) throws CIPDaoException;
	
	List<Data> getByCondition(Object[] args) throws CIPDaoException;
	
	List<Data> getByCondtion(Map<String,Object> conditions) throws CIPDaoException;
	
	int getByConditionCount(Object...args) throws CIPDaoException;
	List<Data> getByCondition(CIPPageInfo page, Object[] args) throws CIPDaoException;
}
