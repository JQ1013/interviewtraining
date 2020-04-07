package com.jqlmh.singleton;

/**
 * 懒汉式单例模式:线程不安全写法
 * @author LMH
 * @create 2020-03-29 23:34
 */
public class Singleton1 {

	//声明当前类对象,但是没有初始化
	private static Singleton1 singleton1;

	private Singleton1(){}

	public static Singleton1 getInstance(){
		if(singleton1==null){
		    singleton1=new Singleton1();
		}
		return singleton1;
	}
}

/**
 * 线程安全的懒汉式
 */
class Singleton3 {

	//声明当前类对象,但是没有初始化
	private static Singleton3 singleton3;

	private Singleton3(){}

	//线程安全
	public static synchronized Singleton3 getInstance(){
		if(singleton3==null){
				singleton3=new Singleton3();
		}
		return singleton3;
	}
}



