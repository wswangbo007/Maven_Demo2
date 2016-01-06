//package com.test.lock;
//
//import java.util.Random;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//public class ReadWriteLockTest {
//
//	public static void main(String[] args) {
//		final DataResouce dataResouce = new ReadWriteLockTest().new DataResouce();
//		final Random random = new Random();
//		for (int i = 0; i < 1; i++) {
//			new Thread(new Runnable() {
//				public void run() {
//					for (int j = 0; j < 5; j++) {
//						dataResouce.set(random.nextInt(30));
//					}
//				};
//			}).start();
//		}
//		for (int i = 0; i < 1; i++) {
//			new Thread(new Runnable(){
//				@Override
//				public void run() {
//					for (int j = 0; j < 5; j++) {
//						dataResouce.get();
//					}
//				}
//			}).start();;
//		}
//	}
//	
//	class DataResouce {
//		private int data;
//		
//		private ReadWriteLock lock = new ReentrantReadWriteLock();
//		
//		public void set(int data) {
//			lock.writeLock().lock();
//			System.out.println(Thread.currentThread().getName() + "准备写入数据");
//			try {
//				Thread.sleep(200L);
//				this.data = data;
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} finally {
//				System.out.println(Thread.currentThread().getName() + "写入" + this.data);
//			}
//			lock.writeLock().unlock();
//		}
//		
//		public void get() {
//			lock.readLock().lock();
//			System.out.println(Thread.currentThread().getName() + "准备读取数据");
//			try {
//				Thread.sleep(200L);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} finally {
//				System.out.println(Thread.currentThread().getName() + "读取" + this.data);
//			}
//			lock.readLock().unlock();
//		}
//	}
//}
