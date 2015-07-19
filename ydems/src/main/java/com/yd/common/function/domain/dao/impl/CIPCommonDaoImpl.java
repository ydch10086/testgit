package com.yd.common.function.domain.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.yd.common.constants.OperateMode;
import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.exception.CIPDaoException;
import com.yd.common.log.LogAnnotation;
import com.yd.common.runtime.CIPErrorCode;


/**
 * @author zhengfc
 * 操作数据库基类
 * @param <Data>
 * TODO:1.左外连接
 */
@Repository
public class CIPCommonDaoImpl<Data> implements IDao<Data>{
	protected Logger log = Logger.getLogger(getClass());
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	protected String tableName;
	protected RowMapper<Data> rm;
	protected Class<Data> clazz;
	protected String[] tableKeys;
	
	/**
	 * 获得超类的参数类型，取第一个参数类型
	 * @param <T> 类型参数
	 * @param clazz 超类类型
	 */
	private static <T> Class<?> getClassGenricType(final Class<?> clazz) {
		return getClassGenricType(clazz, 0);
	}
	
	/**
	 * 根据索引获得超类的参数类型
	 * @param clazz 超类类型
	 * @param index 索引
	 */
	private static Class<?> getClassGenricType(final Class<?> clazz, final int index) {
		Type genType = clazz.getGenericSuperclass();
		
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class<?>) params[index];
	}
	public CIPCommonDaoImpl(){
		
	}
    @SuppressWarnings("unchecked")
	public CIPCommonDaoImpl(Class<Data> clazz, String tableName, String[] keys){
    	this.tableKeys = keys;
    	this.tableName = tableName;
    	this.clazz = clazz;
		rm = BeanPropertyRowMapper.newInstance(clazz);
		
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
		jdbcTemplate = (JdbcTemplate) wac.getBean("jdbcTemplate");
    }
	/**--------------- 增删改 ---------------- */
    @LogAnnotation(module="IDao",operateMode="add")
	@Override
	public boolean add(Data d) throws CIPDaoException {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate).withTableName(tableName);
		try{
			return insertActor.execute(new BeanPropertySqlParameterSource(d)) > 0;
		}catch(DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
    @LogAnnotation(module="IDao",operateMode="batchAdd")
	@Override
	public boolean batchAdd(List<Data> ds) throws CIPDaoException{
    	if(ds != null && ds.size() ==0) return true;
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate).withTableName(tableName);
		SqlParameterSource[] psArray = new SqlParameterSource[ds.size()];
		for(int i=0; i<ds.size(); i++)
			psArray[i] = new BeanPropertySqlParameterSource(ds.get(i));
		try{
			int[] result = insertActor.executeBatch(psArray);
			for(int i: result)
				if(i<0 && i!=-2) return false;
			return true;
		}catch(DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}

    @LogAnnotation(module="IDao",operateMode="batchUpdate")
	@Override
	public boolean batchUpdate(List<Data> ds) throws CIPDaoException{
		StringBuffer sql = new StringBuffer("update " + tableName + " set ");
		Field[] fields = ds.get(0).getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			Class<?> fieldType = field.getType();
			if (!(Arrays.asList(tableKeys).contains(fieldName)
					|| fieldType.equals(Collections.class)
					|| fieldType.equals(Map.class)
					|| fieldType.equals(List.class)
					|| fieldType.equals(Set.class)))
				sql.append(fieldName + " = :" + fieldName + ",");
		}
		sql.replace(sql.lastIndexOf(","), sql.length(), "");
		
		SqlParameterSource[] psArray = new SqlParameterSource[ds.size()];
		for(int i=0; i<ds.size(); i++)
			psArray[i] = new BeanPropertySqlParameterSource(ds.get(i));
		try{
			int[] result = namedParameterJdbcTemplate.batchUpdate(getUpdateWhereCondition(sql), psArray);
			
			for(int i: result)
				if(i<0 && i!=-2) return false;
			return true;
		}catch(DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
    @LogAnnotation(module="IDao",operateMode="update")
	@Override
	public boolean update(Data d) throws CIPDaoException{
		StringBuffer sql = new StringBuffer("update " + tableName + " set ");
		
		Field[] fields = d.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			Class<?> fieldType = field.getType();
			if (!(Arrays.asList(tableKeys).contains(fieldName)
					|| fieldType.equals(Collections.class)
					|| fieldType.equals(Map.class)
					|| fieldType.equals(List.class)
					|| fieldType.equals(Set.class)))
				sql.append(fieldName + " = :" + fieldName + ",");
		}
		sql.replace(sql.lastIndexOf(","), sql.length(), "");
		
		SqlParameterSource ps = new BeanPropertySqlParameterSource(d);
		
		try{
			return namedParameterJdbcTemplate.update(getUpdateWhereCondition(sql), ps) > 0;
		}catch(DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
    @LogAnnotation(module="IDao",operateMode="updateKV")
	@Override
	public boolean updateKV(Map<String, Object> map, Object... keys) throws CIPDaoException{
    	if(map == null || map.size()==0) return true;
		StringBuffer sql = new StringBuffer("update " + tableName + " set ");
		
		Set<Entry<String, Object>> entrySet = map.entrySet();
		Object[] args = new Object[entrySet.size() + keys.length];
		int j = 0;
		for (Map.Entry<String, Object> entry : entrySet) { 
			sql.append(entry.getKey() + " = ?,");
			args[j++] = entry.getValue();
		}  
		for(int i=0; i<keys.length; i++){
			args[i+j] = keys[i];
		}

		try{ 
			return jdbcTemplate.update(getWhereKeysCondition(sql.deleteCharAt(sql.length()-1)), args) >0;
		}catch(DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
    
    @LogAnnotation(module="IDao",operateMode="batchUpdateKV")
    @Override
    public boolean batchUpdateKV(List<Map<String,Object>> list, List<Object[]>keysList) throws CIPDaoException {
    	if(list==null || list.isEmpty()) return true;
    	
    	StringBuffer sql = null;
    	
    	List<Object[]> params = new ArrayList<Object[]>(list.size());
    	for(int t=0;t<list.size();t++) {
    		Map<String,Object> map = list.get(t);
    		Object[]keys = keysList.get(t);
    		sql = new StringBuffer("update " + tableName + " set ");
    		
    		Set<Entry<String, Object>> entrySet = map.entrySet();
    		Object[] args = new Object[entrySet.size() + keys.length];
    		int j = 0;
    		for (Map.Entry<String, Object> entry : entrySet) { 
    			sql.append(entry.getKey() + " = ?,");
    			args[j++] = entry.getValue();
    		}  
    		
    		for(int i=0; i<keys.length; i++){
    			args[i+j] = keys[i];
    		}
    		params.add(args);
    	}
    	try{
    		jdbcTemplate.batchUpdate(getWhereKeysCondition(sql.deleteCharAt(sql.length()-1)), params);
    		return true;
    	}catch(DataAccessException e) {
    		log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
    	}
    	
    }
	
    @LogAnnotation(module="IDao",operateMode="delete")
	@Override
	public boolean delete(Object... keys) throws CIPDaoException{
		StringBuffer sql  = new StringBuffer("delete from " + tableName);
		try{ 
			return jdbcTemplate.update(getWhereKeysCondition(sql), keys)>0;
		}catch(DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
    @LogAnnotation(module="IDao",operateMode="batchDelete")
	@Override
	public boolean batchDelete(final List<Object []> keys) throws CIPDaoException{
    	if(keys.size() == 0) return true;
		final int pkSize = keys.get(0).length;
		StringBuffer sql  = new StringBuffer("delete from " + tableName);
		try{
			int[] result = jdbcTemplate.batchUpdate(getWhereKeysCondition(sql), new BatchPreparedStatementSetter() {
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					for(int j=0; j<pkSize; j++)
						ps.setString(j+1, keys.get(i)[j].toString());
				}
				
				public int getBatchSize() {
					return keys.size();
				}
			});
			for(int i: result)
				if(i<0 && i!=-2) return false;
			return true;
		}catch(DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}

	/**--------------- 查询单条 ---------------- */
	@Override
	public Data getSingle(Object... keys) throws CIPDaoException{
		try {
			StringBuffer sql  = new StringBuffer("select t.* from " + tableName + " t");
			List<Data> result = jdbcTemplate.query(getWhereKeysCondition(sql), rm, keys);
			if(result.size()>0){
				return result.get(0);
			}
			return null;
		} catch (DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
			
		}
	}
	
	  @LogAnnotation(module="IDao",operateMode="isExist")
		@Override
		public boolean isExist(Object... keys) throws CIPDaoException {
	    	try {
				StringBuffer sql  = new StringBuffer("select count(1) from " + tableName + " t");
				Object o = jdbcTemplate.queryForObject(getWhereKeysCondition(sql), rm, keys);
				if( o == null )
					return false;
				else 
					return true;
			} catch (DataAccessException e) {
				log.error(e);
				throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
			}
		}
	    
	    @LogAnnotation(module="IDao",operateMode="isUsable")
		@Override
		public boolean isUsable(Object... keys) throws CIPDaoException{
	    	throw new CIPDaoException(CIPErrorCode.ERROR_FUNCTION_NOT_SUPPORT);
	    }
		

	/**--------------- 查询全部 ---------------- */
	@Override
	public List<Data> getAll() throws CIPDaoException  {
		try {
			String sql =  getSql(null, null, false);
			return jdbcTemplate.query(sql, rm);
		} catch (DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
	@Override
	public List<Data> getAll(CIPPageInfo page) throws CIPDaoException {
		try {
			page.setTotal(getAllCount());
			String sql = getSql(null, page, false);
			return jdbcTemplate.query(sql, rm);
		} catch (DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
	@Override
	public List<Data> getAll(Object... keys) throws CIPDaoException{
		try {
			StringBuffer sql  = new StringBuffer("select t.* from " + tableName + " t");
		
			return jdbcTemplate.query(getWhereKeysCondition(sql, keys.length), rm, keys);

		} catch (DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	


	/**--------------- 按条件查询 ---------------- */
	@Override
	public List<Data> getByCondition(Object[] args) throws CIPDaoException {
		try {
			String sql =  getSql(args, null, false);
			return jdbcTemplate.query(sql, rm);
		} catch (DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	@Override
	public List<Data> getByCondition(CIPPageInfo page, Object[] args) throws CIPDaoException {
		try {
			page.setTotal(getByConditionCount(args));
			String sql =  getSql(args, page, false);
			return jdbcTemplate.query(sql, rm);
		} catch (DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
	/**--------------- 总条数 ---------------- */
	@Override
	public int getAllCount() throws CIPDaoException{
		try {
			String sql = getSql(null, null, true);
			return jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	@Override
	public int getByConditionCount(Object...args) throws CIPDaoException{
		try {
			String sql = getSql(args, null, true);
			return jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (DataAccessException e) {
			log.error(e);
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
	/**
	 * 拼接主键where条件sql
	 * @param sql
	 * @return
	 */
	private String getUpdateWhereCondition(StringBuffer sql){
		return getKeysCondition(sql, OperateMode.UPDATE);
	}
	private String getWhereKeysCondition(StringBuffer sql){
		 return getKeysCondition(sql, null);
	}
	private String getKeysCondition(StringBuffer sql, OperateMode mode){
		sql.append(" where ");
		
		if(OperateMode.UPDATE.equals(mode)) for(String pk: tableKeys) sql.append(" and " + pk + " = :" + pk);
		else for(String pk: tableKeys) sql.append(" and " + pk + " = ?");
		
		sql.replace(sql.indexOf(" and "), sql.indexOf(" and ") + 5, "");
//		log.info("sql:"+sql);
		return sql.toString();
	}
	
	private String getWhereKeysCondition(StringBuffer sql, int length) {
		sql.append(" where ");
		String pk;
		for(int index = 0 ; index < length ; index++) {
			pk = tableKeys[index];
			sql.append(" and " + pk + " = :" + pk);
		}
		sql.replace(sql.indexOf(" and "), sql.indexOf(" and ") + 5, "");
	
		return sql.toString();
	}
	
	/**
	 * @param args:查询条件
	 * @param page:查询分页
	 * @param isCount:是否是查询总数
	 * @return
	 */
	protected String getSql(Object[] args, CIPPageInfo page, boolean isCount){
		StringBuffer buffer = new StringBuffer();
		//1.连表
		if(isCount)  //是否查询总数,结果集合不同
			buffer.append("select count(1)");
		else
			buffer.append("select t.*").append(getLinkSelect());
		buffer.append(" from ").append(tableName).append(" t").append(getLinkTable())
	    .append(" where 1=1").append(getLinkCondition(args));
		
		//2.条件查询
		if(args!=null && args.length>0) buffer.append(generateWhere(args));
		
		//3.分页
		if(page!=null) buffer.append(getMySqlPage(page));
		if(buffer.toString().indexOf("1=1 and")>0){
			log.info("querySql:"+buffer.toString().replace("1=1 and", ""));
			return buffer.toString().replace("1=1 and", "");
		}else{
			log.info("querySql:"+buffer.toString().replace("where 1=1", ""));
			return buffer.toString().replace("where 1=1", "");
		}
	}
	
	/**
	 * 拼接分页sql(oracle实现)
	 * @param querySql
	 * @param page
	 * @return
	 */
	/*private StringBuffer getOraPage(StringBuffer querySql, PageInfo page){
		StringBuffer pageQuerySql = new StringBuffer();
		pageQuerySql.append("select * from (select page.*, row_number() over(order by null) as row_number from (")
		.append(querySql).append(" where rownum<="+page.getEndRecord()+") page) where row_number>")
		.append(page.getStartRecord());
		log.info("querySql:"+pageQuerySql.toString());
		return pageQuerySql;
	}*/
	/**
	 * 拼接分页sql(mysql实现)
	 * @param querySql
	 * @param page
	 * @return
	 */
	private String getMySqlPage(CIPPageInfo page){
		return " limit "+page.getStartRecord()+","+page.getRows();
	}
	
	// 查询默认单表:要连表,子类需要实现此三个方法
	protected String getLinkSelect() {
		return "";
	}
	protected String getLinkTable() {
		return "";
	}
	protected String getLinkCondition(Object... args) {
		return "";
	}
	// 查询条件:子类必须实现
	protected String generateWhere(Object... args){
		return "";
	}

	@Override
	public List<Data> getByCondtion(Map<String, Object> conditions)
			throws CIPDaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
