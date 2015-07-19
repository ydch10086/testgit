package com.yd.common.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yd.common.runtime.CIPRuntime;

@Aspect
@Component
public class LogInterceptor {
	private Logger log = Logger.getLogger(getClass());
	
	@Around(value = "appLogic() && @annotation(annotation)", argNames = "annotation")
	public Object interceptorApplogic(ProceedingJoinPoint joinPoint, LogAnnotation annotation) throws Throwable{
		
		Object ret = joinPoint.proceed();
		Object[] args = joinPoint.getArgs();
		StringBuffer logInfo = new StringBuffer("用户:"+CIPRuntime.getOperateSubject().getSubject_id()+",");
		logInfo.append("时间:"+CIPRuntime.getOperateSubject().getOperate_tm()+",");
		logInfo.append("操作模式:"+annotation.operateMode()+",");
		logInfo.append("操作数据:"+args[0].toString());
		log.info(logInfo.toString());
		
		return ret;
	}
}
