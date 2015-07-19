package com.yd.common.runtime;


import java.io.InputStream;
import java.util.Map;
import java.util.Properties;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.yd.common.auth.CIPAuthManager;
import com.yd.common.cache.CIPCacheManager;
import com.yd.common.conf.CIPConfigureManager;
import com.yd.common.log.CIPLogManager;
import com.yd.common.session.CIPHttpSession;
import com.yd.common.session.CIPSessionManager;
import com.yd.common.session.CIPUser;

/**
 * 应用上下文初始化类
 * @author 
 *
 * 应用体系初始化加载顺序
 * 1、启动 系统根服务
 * 2、启动 日志服务
 * 3、启动 配置服务
 * 4、启动 缓存服务
 * 5、启动 文本服务
 * 6、启动 用户服务
 * 7、启动 授权服务
 * 8、检查 数据库服务
 * 
 */

public class CIPRuntimeContextInitializer implements InitializingBean{
	private Logger log = Logger.getLogger(CIPRuntimeContextInitializer.class);
	

	@Override
	public void afterPropertiesSet() throws Exception {
		//加载config.properties
		loadConfig();
		//加载table.properties，初始化ORMapping
	}
	
	@Autowired
	private CIPAuthManager authManager = null;
	
	/**
	 * 加载配置文件
	 */
	private void loadConfig() {
		InputStream stream = null;
		try {
			//1.启动应用根服务
			Properties props = new Properties();
			stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			props.load(stream);
			CIPRuntimeConfigure.cip_system_id = props.getProperty("cip.system.id").trim();
			CIPRuntimeConfigure.cip_system_type = props.getProperty("cip.system.type").trim();
			CIPRuntimeConfigure.dbSchema = props.getProperty("cip.db.schema").trim();
			
			String xRemote = props.getProperty("cip.system.xcluster").trim();
			if("X".equals(xRemote))
				CIPRuntimeConfigure.cip_is_cluster = true;

			//2.启动日志服务
			xRemote = props.getProperty("cip.log.xremote").trim();
			if("X".equals(xRemote))
				CIPRuntimeConfigure.cip_is_remote_log = true;
			if(CIPRuntimeConfigure.cip_is_remote_log){
				CIPRuntimeConfigure.cip_log_url = props.getProperty("cip.log.url").trim();
				checkLogAvailable(CIPRuntimeConfigure.cip_log_url);
			}
			CIPLogManager.init();
			
			//3.启动 配置服务
			xRemote = props.getProperty("cip.conf.xremote").trim();
			if("X".equals(xRemote))
				CIPRuntimeConfigure.cip_is_remote_conf = true;
			
			if(CIPRuntimeConfigure.cip_is_remote_conf){
				CIPRuntimeConfigure.cip_remote_conf_url = props.getProperty("cip.conf.remote.url").trim();
				CIPConfigureManager.init();
			}
			else {
				CIPRuntimeConfigure.cip_local_conf_file = props.getProperty("cip.conf.local.file").trim();
				CIPConfigureManager.init();
			}
			
			//4. 启动缓存服务
			if(CIPRuntimeConfigure.cip_is_remote_cache){
				CIPCacheManager.createCacheManager(CIPCacheManager.CACHE_SCHEMA_REMOTE);
			}
			else{
				CIPCacheManager.createCacheManager(CIPCacheManager.CACHE_SCHEMA_LOCAL);
			}
			
			//5. 启动系统session
			String sessionId = CIPSessionManager.initSystemSession();
			CIPHttpSession cipSession = CIPSessionManager.getSystemSession(sessionId);
			CIPUser systemUser = new CIPUser();
			systemUser.setUserId("system");
			systemUser.setUserName("system user");
			//set system user for remote system call
			cipSession.setAttribute(CIPRuntimeConstants.LOGIN_USER, systemUser);
			CIPRuntime.runtimeInfo.put(CIPRuntimeConstants.SYSTEM_SESSION_ID, sessionId);
			
			//7.启动授权服务
			//System.out.println(authBehaviorConfDao);
			authManager.init();
			CIPRuntime.authManager = authManager;

			//8.其它配置项加载
			loadAdditionnalConfigures();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("配置文件config.properties加载失败！");
		}finally{

		}
	}

	private void loadAdditionnalConfigures() {
		Map<String,String> configures = CIPConfigureManager.getConfigures();
		CIPRuntimeConfigure.cip_actual_file_path = configures.get("cip.actual.file.path").trim();
		CIPRuntimeConfigure.cip_temp_file_path = configures.get("cip.temp.file.path").trim();

		CIPRuntimeConfigure.additionalInfos = configures;

	}

	private void checkLogAvailable(String logURL) {
		// TODO Auto-generated method stub
		
	}



}
