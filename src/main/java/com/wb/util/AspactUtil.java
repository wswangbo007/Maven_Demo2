package com.wb.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspactUtil {
	
	public AspactUtil() {
		// TODO Auto-generated constructor stub
		System.err.println("初始化初始化初始化初始化初始化初始化!!");
		System.out.println("1231313232131");
	}

	@Pointcut("execution (* com.wb.service.*.*(..))")
	public void anyMoethod(){};
	
	@Before("anyMoethod()")
	public void doBeforeMethod() {
		System.err.println("这是前置通知!!");
		System.out.println("1231313232131");
	}
}
