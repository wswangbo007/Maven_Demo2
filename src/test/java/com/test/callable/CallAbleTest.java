package com.test.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallAbleTest {
	
	public static void main(String[] args) {
		CallAbleTest1 callable = new CallAbleTest().new CallAbleTest1();
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	class CallAbleTest1 implements Callable<Integer> {

		private Random random = new Random();
		
		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			return random.nextInt(30);
		}
			
	}
}
