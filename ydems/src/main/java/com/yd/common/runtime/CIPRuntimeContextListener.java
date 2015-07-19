package com.yd.common.runtime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CIPRuntimeContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//TODO 系统启动日志
		System.out.println("系统启动中"+System.currentTimeMillis());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("系统关闭"+System.currentTimeMillis());
	}

	

}
