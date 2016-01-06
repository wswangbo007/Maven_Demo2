//package com.test;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//import org.junit.Test;
//
//public class Test1 {
//	
//	Lock lock = new ReentrantLock();
//	
//	@Test
//	public void main11() {
//		String a = "Programming";
//		String b = new String("Programming");
//		String c = "Program" + "ming";
//		
//		lock.lock();
//		lock.unlock();
//		
//		float aaa = 3.4F;
//		assert false;
//		
//		StringBuffer sb = new StringBuffer("1234567");
//		sb.reverse();
//		
//		System.out.println(8 >> 2);
//		
//		/*System.out.println(reverse("1234567"));
//		
//		System.out.println(a == b);
//		System.out.println(a == c);
//		System.out.println(a.equals(b));
//		System.out.println(a.equals(c));
//		System.out.println(a.intern() == b.intern());*/
//	}
//	
//	public String reverse(String originStr) {
//        if(originStr == null || originStr.length() <= 1)   
//            return originStr;
//        System.out.println(reverse(originStr.substring(1)) + originStr.charAt(0));
//        return reverse(originStr.substring(1)) + originStr.charAt(0);  
//    }
//	
//	// java 的八大数据类型 int,byte,shrat,double,long,float,boolean,char  emenu 枚举,String 引用类型
//	
//	
//}