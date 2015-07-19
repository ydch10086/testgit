package com.yd.common.session;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.common.auth.CIPAuthManager;
import com.yd.common.auth.CIPResource;
import com.yd.common.cache.CIPCacheManager;
import com.yd.common.cache.CIPCacheService;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.runtime.CIPRuntime;
import com.yd.common.runtime.CIPRuntimeConfigure;
import com.yd.common.runtime.CIPRuntimeConstants;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.utils.DateUtils;



/**
 *
 * 登录过滤器
 * 注：解决请求合法性问题，用sessionId识别当前用户的合法性
 */
public class CIPLocalLoginFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public CIPLocalLoginFilter() {
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
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
	
		String type = httpRequest.getHeader("X-Requested-With");
		if ("XMLHttpRequest".equalsIgnoreCase(type)) {//ajax请求
			httpResponse.setHeader("Pragma", "no-cache");
			httpResponse.setDateHeader("Expires", 0);
			httpResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
		}
		
		//2. 获取session信息 
		CIPHttpSession session = null;
		CIPUser loginUser = null;
		try{
			session = CIPSessionManager.getSession(httpRequest, httpResponse);
		}catch(Exception e) {
			if ("XMLHttpRequest".equalsIgnoreCase(type)) {
				httpResponse.setCharacterEncoding("utf-8");
				httpResponse.getWriter().write(
						"{\"errorCode\":"+CIPErrorCode.ERROR_CONNECTION_TIMEOUT.code+",\"msg\":\""+CIPErrorCode.ERROR_CONNECTION_TIMEOUT.name+"\"}");
				httpResponse.getWriter().flush();
				return;
			}else{
				httpResponse.sendRedirect(CIPRuntimeConfigure.ErrorPageURI);
				return;
			}
		}		
				
		//3. 从session中获取user对象
		loginUser = session.getAttribute(CIPRuntimeConstants.LOGIN_USER, CIPUser.class);

		if(loginUser == null){
			if ("XMLHttpRequest".equalsIgnoreCase(type)) {
				httpResponse.setCharacterEncoding("utf-8");
				httpResponse.getWriter().write(
						"{\"errorCode\":"+CIPErrorCode.ERROR_CONNECTION_TIMEOUT.code+",\"msg\":\""+CIPErrorCode.ERROR_CONNECTION_TIMEOUT.name+"\"}");
				httpResponse.getWriter().flush();
				return;
			}else{
						
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/" + CIPRuntimeConfigure.loginPageURI);
				return;
			}			
		} else{
			
			String dynamicUrl = httpRequest.getPathInfo();
			if(dynamicUrl == null ) 
				dynamicUrl = httpRequest.getRequestURI();
			
			//check access authorization
			String actionId = request.getParameter(CIPRuntimeConstants.CIP_ACTION_ID);
			CIPErrorCode error = CIPRuntime.authManager.checkAccess(loginUser, actionId, dynamicUrl);
			if( error != null ){
				httpResponse.setCharacterEncoding("utf-8");
				httpResponse.getWriter().write(
						"{\"errorCode\":"+error.code+",\"msg\":\""+error.name+"\"}");
				httpResponse.getWriter().flush();
				return;
			}
			
			//assign current operator info
			CIPRuntimeOperator operateSubject = new CIPRuntimeOperator();
			operateSubject.setSubject_id(loginUser.getUserId());
			Date d = new Date();
			operateSubject.setOperate_tm(DateUtils.getDateTime(d));
			//operateSubject.setOperate_dt(DateUtils.getDate(d));
			operateSubject.setSubject_ip(httpRequest.getRemoteAddr());
			
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
