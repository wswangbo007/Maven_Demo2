//package com.test.lock;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//import org.junit.Test;
//
//public class LockTest {
//
//	OutPutter output = new OutPutter();
//	
//	private final String name = "wangbo";
//	
//	@Test
//	public void Test1() {
//		try {
//			Run1 run1 = new Run1();
//			Thread t1 = new Thread(run1);
//			t1.start();
//			t1.join();
//			Thread t2 = new Thread() {
//				public void run() {
//					output.outPut("zhaoshuqing");
//				};
//			};
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	class Run1 implements Runnable{
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			output.outPut(name);
//		}
//		
//	}
//	
//	public class OutPutter {
//		private Lock lock = new ReentrantLock();
//		
//		public void outPut(String name) {
//			System.out.println(name);
//			lock.lock();
//			int i = 0;
//			while (i < name.length()) {
//				System.out.println(name.charAt(i));
//				i++;
//			}
//			
//		}
//	}
//	
//	
//	
//}
