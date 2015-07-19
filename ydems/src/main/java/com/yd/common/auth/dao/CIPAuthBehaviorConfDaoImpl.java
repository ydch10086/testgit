package com.yd.common.auth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.yd.common.exception.CIPDaoException;
import com.yd.common.function.admin.data.po.CIP_admin_auth_act2objPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_attrPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_objPO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_rolePO;
import com.yd.common.function.admin.data.po.CIP_admin_auth_userPO;
import com.yd.common.runtime.CIPErrorCode;

@Repository
public class CIPAuthBehaviorConfDaoImpl implements CIPAuthBehaviorConfDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	private final BeanPropertyRowMapper<CIP_admin_auth_userPO> userRM = BeanPropertyRowMapper.newInstance(CIP_admin_auth_userPO.class);
	private final BeanPropertyRowMapper<CIP_admin_auth_rolePO> roleRM = BeanPropertyRowMapper.newInstance(CIP_admin_auth_rolePO.class);
	private final BeanPropertyRowMapper<CIP_admin_auth_objPO> objRM = BeanPropertyRowMapper.newInstance(CIP_admin_auth_objPO.class);
	private final BeanPropertyRowMapper<CIP_admin_auth_attrPO> attrRM = BeanPropertyRowMapper.newInstance(CIP_admin_auth_attrPO.class);
	private final BeanPropertyRowMapper<CIP_admin_auth_act2objPO> actionRM = BeanPropertyRowMapper.newInstance(CIP_admin_auth_act2objPO.class);
	
	
//	public CIPAuthBehaviorConfDaoImpl(){
//		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
//		jdbcTemplate = (JdbcTemplate) wac.getBean("jdbcTemplate");
//	}
	
	private String userSql = "select * from cip_admin_auth_user";
	
	@Override
	public List<CIP_admin_auth_userPO> getUserConf() {
		try{
			return jdbcTemplate.query(userSql, userRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}

	private String roleSql = "select * from CIP_admin_auth_role where auth_role_id=?";
	
	@Override
	public List<CIP_admin_auth_rolePO> getRoleConf(String roleId) {
		try{
			return jdbcTemplate.query(roleSql, new Object[]{roleId}, roleRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
	private String roleAllSql = "select * from CIP_admin_auth_role";
	
	@Override
	public List<CIP_admin_auth_rolePO> getRoleConfs() {
		try{
			return jdbcTemplate.query(roleAllSql, roleRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
	private String objectSql = "select * from CIP_admin_auth_obj";

	@Override
	public List<CIP_admin_auth_objPO> getObjectConf() {
		try{
			return jdbcTemplate.query(objectSql, objRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}
	
	private String actionSql = "select A.* from CIP_admin_auth_act2obj A left join cip_admin_roles B on A.root_node_id = B.root_resource_id " +
			"where A.obj_id=? and A.resource_id=? and B.role_id = ?";

	@Override
	public List<CIP_admin_auth_act2objPO> getAction2ObjectConf(String objectId,
			String actionId, String roleId) {
		try{
			return jdbcTemplate.query(actionSql, new Object[]{objectId, actionId, roleId}, actionRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}

	private String attrSql = "select * from CIP_admin_auth_attr where obj_id = ?";
	
	@Override
	public List<CIP_admin_auth_attrPO> getObjectAttributesConf(String objectId) {
		try{
			return jdbcTemplate.query(attrSql, new Object[]{objectId}, attrRM);
		}catch(DataAccessException e) {
			throw new CIPDaoException(CIPErrorCode.ERROR_DATABASE_TECH_EXCEPTION);
		}
	}

}
