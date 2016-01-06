package com.test.cglib.dao;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import com.test.cglib.util.MyCGLibUtil;

public class CGlibDaoFactory {

	private CGlibDaoFactory() {};
	
	public static Object getProxyInstance(MyCGLibUtil myProxy,Class classs) {    
	     Enhancer en = new Enhancer();
	     //进行代理
	     en.setSuperclass(classs);
	     en.setCallback(myProxy);
	     //生成代理实例
	     return en.create();
	 }
	
	public static Object getMethodFitler(MyCGLibUtil myProxy,Class classs,String className) {
		Enhancer en = new Enhancer();
		en.setSuperclass(classs);
		en.setCallbacks(new Callback[]{myProxy,NoOp.INSTANCE});
		try {
			en.setCallbackFilter((CallbackFilter)Class.forName(className).newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return en.create();
	}
}
