package com.test.callable;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteServiceTest {
	
	private static ExecutorService executorService = Executors.newCachedThreadPool();
	
	private static List<Integer> intList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		CallAbleJava callAbleJava = new ExecuteServiceTest().new CallAbleJava();
		CompletionService<List<Integer>> completionService = new ExecutorCompletionService<List<Integer>>(executorService);
		for (int i = 0; i < 5; i++) {
			completionService.submit(callAbleJava);
		}
		try {
			for (int i = 0; i < 5; i++) {
				Future<List<Integer>> future = completionService.take();
				List<Integer> temp = future.get();
				intList.addAll(temp);
			}
			System.out.println(intList.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	private int g(final int a) {
		return a +1;
	}

	private class CallAbleJava implements Callable<List<Integer>> {
		
		private Set<Integer> intSet = new LinkedHashSet<Integer>();

		public CallAbleJava() {
			super();
		}

		@Override
		public List<Integer> call() throws Exception {
			intList.clear();
			for (int i = 0; i < 20; i++) {
				intSet.add(i);
			}
			List<Integer> intList = new ArrayList<Integer>(intSet);
			System.err.println(Thread.currentThread().getName() +"     size : "+ intList.size() + "  " + intList.toString());
			return intList;
		}
		
	}
}
