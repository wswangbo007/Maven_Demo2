package com.test.cglib.test;

import org.junit.Test;

import com.test.cglib.dao.CGlibDao;
import com.test.cglib.dao.CGlibDaoFactory;
import com.test.cglib.util.MyCGLibUtil;

public class TestCGLib {
	
	@Test
	public void cglibTest() {
		Class classz = CGlibDao.class;
//		CGlibDao cgLibDao = (CGlibDao) CGlibDaoFactory.getProxyInstance(new MyCGLibUtil("wangbo"), classz);
//		cgLibDao.create();
//		CGlibDao cgLibDao1 = (CGlibDao) CGlibDaoFactory.getProxyInstance(new MyCGLibUtil("张三"), classz);
//		cgLibDao1.create();
//		cgLibDao.update();
//		cgLibDao.query();
//		cgLibDao.delete();
		CGlibDao cgLibDao = (CGlibDao)CGlibDaoFactory.getMethodFitler(new MyCGLibUtil("wangbo"),classz,"com.test.cglib.util.CallBackUtil");
		cgLibDao.create();
		cgLibDao.query();
		CGlibDao cgLibDao1 = (CGlibDao)CGlibDaoFactory.getMethodFitler(new MyCGLibUtil("张三"),classz,"com.test.cglib.util.CallBackUtil");
		cgLibDao1.create();
		cgLibDao1.query();
	}
}