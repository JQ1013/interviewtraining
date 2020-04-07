package com.jqlmh.singleton;

/**
 * @author LMH
 * @create 2020-03-29 23:58
 */
public class Singleton6 {
	//volatile防止重排序
	private volatile static Singleton6 singleton6;

	private Singleton6(){}

	public static Singleton6 getInstance(){
		//先判断是否初始化,如果没有就加锁,防止每次调用方法就加锁,浪费资源
		if(null==singleton6){
		    synchronized (Singleton6.class){
		    	//在判断是否初始化,没有就初始化
		    	if(null==singleton6){
		    	    singleton6=new Singleton6();
		    	}
			}
		}
		return singleton6;
	}
}
