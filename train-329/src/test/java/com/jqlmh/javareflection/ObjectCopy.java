package com.jqlmh.javareflection;

import org.junit.Test;

import java.io.*;

/**
 * @author LMH
 * @version 1.0
 * @description
 * @create 2020-05-06 17:47
 */
public class ObjectCopy {


	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj)
			throws Exception {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bout);
		oos.writeObject(obj);

		ByteArrayInputStream bin =
				new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bin);
		return (T) ois.readObject();

		// 说明：调用ByteArrayInputStream
		//或ByteArrayOutputStream对象的close方法没有任何意义
		// 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，
		//这一点不同于对外部资源（如文件流）的释放
	}


	@Test
	public void test1() {

		Person person = new Person("小姜", 23, new Acount(2300.0));
		try {
			Person clone = clone(person); //深度拷贝
			clone.getAcount().setBalance(3000.0); //修改clone的账户值为3000
			//打印两个对象
			System.out.println("拷贝的对象:" + clone);
			System.out.println("原始对象:" + person);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


class Person implements Serializable {

	public static final long serialVersionUID = 45646446461212L;
	private String name;
	private int age;
	private Acount acount;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, Acount acount) {
		this.name = name;
		this.age = age;
		this.acount = acount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Acount getAcount() {
		return acount;
	}

	public void setAcount(Acount acount) {
		this.acount = acount;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", acount=" + acount +
				'}';
	}
}

class Acount implements Serializable {
	public static final long serialVersionUID = 54613841L;
	private double balance;

	public Acount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Acount{" +
				"balance=" + balance +
				'}';
	}
}


