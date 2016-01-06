package com.test.cglib.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class CallBackUtil implements CallbackFilter {

	@Override
	public int accept(Method method) {
		// TODO Auto-generated method stub
		if (!"query".equalsIgnoreCase(method.getName())) {
			return 0;
		}
		return 1;
	}

}
