package com.yd.common.runtime;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.yd.common.auth.CIPAuthManager;
import com.yd.common.session.CIPHttpSession;
import com.yd.common.session.CIPSessionManager;
import com.yd.common.session.CIPUser;
import com.yd.common.utils.DateUtils;


//系统级全局共享信息
public class CIPRuntime {
	//请求人员信息
	private static ThreadLocal<CIPRuntimeOperator> subject = new ThreadLocal<CIPRuntimeOperator>();

	public static void setOperateSubject(CIPRuntimeOperator operateSubject) {
		subject.set(operateSubject);
	}
	
	public static CIPRuntimeOperator getOperateSubject() {
		return subject.get();
	}
	
	public static void clear() {
		subject.remove();
	}
	
	public static CIPAuthManager authManager = null;
	
	public static Map<String, String> runtimeInfo = new HashMap<String,String>();
	
	public static CIPRuntimeOperator getSystemOperateSubject() {
		String sessionId = runtimeInfo.get(CIPRuntimeConstants.SYSTEM_SESSION_ID);
		CIPHttpSession systemSession = CIPSessionManager.getSystemSession(sessionId);
		CIPUser systemUser = systemSession.getAttribute(CIPRuntimeConstants.LOGIN_USER, CIPUser.class);
		CIPRuntimeOperator operateSubject = new CIPRuntimeOperator();
		operateSubject.setSubject_id(systemUser.getUserId());
		Date d = new Date();
		operateSubject.setOperate_tm(DateUtils.getDateTime(d));

		return operateSubject;
	}
}
