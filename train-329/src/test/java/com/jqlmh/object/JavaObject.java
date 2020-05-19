package com.jqlmh.object;

import org.junit.Test;

/**
 * @author LMH
 * @create 2020-05-03 11:14
 */
public class JavaObject {


	/**
	 * 包装类
	 */
	@Test
	public void test3() {

		Integer i = new Integer(2);
		String s = String.valueOf(i);
		System.out.println(s);
	}

	/**
	 * 基本数据类型值传递
	 */
	@Test
	public void test1() {
		System.out.println("***********基本数据类型：****************");
		int m = 10;
		int n = m;

		System.out.println("m = " + m + ", n = " + n);

		n = 20;

		System.out.println("m = " + m + ", n = " + n);

		System.out.println("***********引用数据类型：****************");

		Order o1 = new Order();
		o1.orderId = 1001;

		Order o2 = o1;//赋值以后，o1和o2的地址值相同，都指向了堆空间中同一个对象实体。

		System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " + o2.orderId);

		o2.orderId = 1002;

		System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " + o2.orderId);
	}


	/**
	 * 引用类型值传递
	 */
	@Test
	public void test2() {

		int m = 10;
		int n = 20;
		swap(m, n);
		System.out.println("m=" + m + ",n=" + n);
	}

	private void swap(int m, int n) {
		int temp = m;
		m = n;
		n = temp;
		System.out.println("m=" + m + ",n=" + n);
	}
}

interface N{
	public void show();
	void show1();
	void show2();
}

interface M{}

interface C extends N,M{
	@Override
	void show();

	@Override
	void show1();
}

abstract class A {
	public abstract void test1();

	abstract void test2();

	protected abstract void test3();

	private void test4() {
	}
}

class Order {
	int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
