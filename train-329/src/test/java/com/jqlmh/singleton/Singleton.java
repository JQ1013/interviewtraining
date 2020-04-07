package com.jqlmh.singleton; /**
 * 手写饿汉式单例模式
 * @author LMH
 * @create 2020-03-29 23:28
 */

/**
 * 使用静态代码块初始化
 */
public class Singleton {
	//1.内部创建类的对象,要求是私有的静态的;
	private static Singleton singleton;
	//使用静态代码块创建
	static {
			singleton=new Singleton();
	}
	//2.私有化构造器
	private Singleton(){
	}
	//3.公有方法获取实例
	public static Singleton getInstance(){
		return singleton;
	}
}


/**
 * 不使用静态代码块初始化
 */
class Singleton2 {
	//1.内部创建类的对象,要求是私有的静态的;
	private static Singleton2 singleton2=new Singleton2();
	//使用静态代码块创建
	//2.私有化构造器
	private Singleton2(){
	}
	//3.公有方法获取实例
	public static Singleton2 getInstance(){
		return singleton2;
	}
}


