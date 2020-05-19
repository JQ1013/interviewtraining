package com.jqlmh.javareflection;

import org.junit.Test;

/**
 * @author LMH
 * @version 1.0
 * @description
 * @create 2020-05-06 17:34
 */
public class ReflectionTest {

	@Test
	public void test1(){
		book book1 = new book();
		book1.setId(5);
		System.out.println(book1);

	}
}



class book implements Cloneable{
	private int id;

	public book() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "book{" +
				"id=" + id +
				'}';
	}
}
