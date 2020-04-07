package com.jqlmh.singleton;

/**
 * 静态内部类方式的单例
 * @author LMH
 * @create 2020-03-29 23:45
 */
public class Singleton5 {

	//定义静态内部类
	private static class SingletonHolder{
		//静态内部类定义一个Singleton5类型的常量
		private static final Singleton5 SINGLETON_5=new Singleton5();
	}

	//构造器私有化
	private Singleton5(){}

	//定义公共方法获取静态内部内的实例
	public static Singleton5 getInstance(){
		return SingletonHolder.SINGLETON_5;
	}

}
