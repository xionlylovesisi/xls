package com.xls;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorCase {
	private static Executor executor = Executors.newFixedThreadPool(10,Executors.privilegedThreadFactory());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Date(System.nanoTime()));
		for (int i = 0; i < 10; i++) {
			executor.execute(new Task());
		}
	}
	static class Task implements Runnable{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	static class MyHandler implements RejectedExecutionHandler{

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println(Thread.currentThread().getName()+"阻塞");
		}
		
	}
}
