package com.yd.common.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD})
public @interface LogAnnotation {
	String module();       //操作模块
	String operateMode();  //操作模式
}
