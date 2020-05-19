package com.jqlmh.javathread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author LMH
 * @create 2020-05-05 17:33
 */
public class ThreadTest {

	/**
	 * 创建线程的方式1:继承thread类
	 */
	@Test
	public void test1() {

		T1 t1 = new T1();
		System.out.println(Thread.currentThread().getName());
		t1.start();

		T1 t2 = new T1();
		System.out.println(Thread.currentThread().getName());
		t2.start();
	}


	/**
	 * 创建线程的方式1:实现Runnable接口
	 */
	@Test
	public void test2() {
		Thread thread = new Thread(new T2());
		thread.start();
	}


	/**
	 * 创建线程的方式1:实现Callable接口
	 */
	@Test
	public void test3() {
		T3 t3 = new T3();
		t3.notify();
		FutureTask task = new FutureTask(t3);
		Thread thread = new Thread(task);
		thread.start();
	}

	/**
	 * 创建线程的方式1:使用线程池
	 */
	@Test
	public void test4() throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(16);
		Future<?> future = executorService.submit(new T2());
		System.out.println(future.get());  //获取返回值
		executorService.shutdown();

	}
}


class T3 implements Callable {
	@Override
	public Object call() throws Exception {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "----" + i);
		}
		return null;
	}
}

class T2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "----" + i);
		}
	}
}

class T1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "----" + i);
		}
	}
}
