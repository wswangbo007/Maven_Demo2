package com.test.cglib.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyCGLibUtil implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();
	
	private String name;

	public MyCGLibUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public MyCGLibUtil(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	/** 
	  * 根据class对象创建该对象的代理对象 
	  * 1、设置父类；2、设置回调 
	  * 本质：动态创建了一个class对象的子类 
	  * 
	  * @param cls 
	  * @return 
	  */  
	public Object getObj(Class cls) {
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] objArray,
			MethodProxy methodProxy) throws Throwable {
		System.out.println(" 当前方法 : " + method.getName() + "  姓名 : " + name);
		if (name.equals("张三")) {
			System.out.println("您没有权限!");
			return null;
		}
		Object result = methodProxy.invokeSuper(obj, objArray);
		return result;
	}

}
