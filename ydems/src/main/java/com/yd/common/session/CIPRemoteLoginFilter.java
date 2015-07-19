package com.yd.common.session;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.yd.common.auth.CIPAuthManager;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntime;
import com.yd.common.runtime.CIPRuntimeConstants;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.utils.DateUtils;



/**
 *
 * 登录过滤器
 * 注：解决请求合法性问题，用auth_code识别当前用户的合法性
 */
public class CIPRemoteLoginFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public CIPRemoteLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		//1. 获取auth_code信息 
		String authCode = request.getParameter(CIPRuntimeConstants.AUTH_CODE);
		String srcSystemId = request.getParameter(CIPRuntimeConstants.AUTH_SOURCE_SYSTEM_ID);
		String srcIp = request.getRemoteAddr();
		if(authCode == null||"".equals(authCode)||srcSystemId==null||srcSystemId.equals("")){
			httpResponse.getWriter().write(
					"{\"errorCode\":"+CIPErrorCode.ERROR_INVALID_AUTHORIZATION.code+",\"msg\":"+CIPErrorCode.ERROR_INVALID_AUTHORIZATION.name+",\"data\":\"\",\"type\":0,\"total_records\":0,\"total_pages\":0,\"current_page\":0,\"page_count\":0}");
			httpResponse.getWriter().flush();
			return;
		}
		
		//2.验证授权码
		boolean xValid = CIPRuntime.authManager.checkAuthCode(authCode,srcSystemId,srcIp);
		if(!xValid){
			httpResponse.getWriter().write(
					"{\"errorCode\":"+CIPErrorCode.ERROR_INVALID_AUTHORIZATION.code+",\"msg\":"+CIPErrorCode.ERROR_INVALID_AUTHORIZATION.name+",\"data\":\"\",\"type\":0,\"total_records\":0,\"total_pages\":0,\"current_page\":0,\"page_count\":0}");
			httpResponse.getWriter().flush();
			return;
		}
		
		//3. 确认合法auth_code,则从session中获取system user对象
		String sessionId = CIPRuntime.runtimeInfo.get(CIPRuntimeConstants.SYSTEM_SESSION_ID);
		CIPHttpSession session = CIPSessionManager.getSystemSession(sessionId);
		CIPUser loginUser = session.getAttribute(CIPRuntimeConstants.LOGIN_USER, CIPUser.class);
		if(loginUser == null){
			//不能做系统集成
			httpResponse.getWriter().write(
					"{\"errorCode\":"+CIPErrorCode.ERROR_NOT_SUPPORT_REMOTE_CALL.code+",\"msg\":"+CIPErrorCode.ERROR_NOT_SUPPORT_REMOTE_CALL.name+",\"data\":\"\",\"type\":0,\"total_records\":0,\"total_pages\":0,\"current_page\":0,\"page_count\":0}");
			return;		
		}else{
			CIPRuntimeOperator operateSubject = new CIPRuntimeOperator();
			operateSubject.setSubject_id(loginUser.getUserId());
			Date d = new Date();
			operateSubject.setOperate_tm(DateUtils.getTime(d));
			operateSubject.setOperate_dt(DateUtils.getDate(d));
			operateSubject.setSubject_ip(request.getRemoteAddr());
			
			CIPRuntime.setOperateSubject(operateSubject);
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
