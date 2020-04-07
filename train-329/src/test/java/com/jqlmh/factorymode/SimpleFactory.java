package com.jqlmh.factorymode;

/**
 * @author LMH
 * @create 2020-03-30 4:18
 */
public class SimpleFactory {
	public static void main(String[] args) {
		Car car = CarFactory.getCar("bmw");
		if(car!=null){
		    car.run();
		    car.stop();
		}else{
			System.out.println("我们造不了这种车");
		}
	}
}

//抽象汽车类
abstract class Car{

	abstract void run();
	abstract void stop();
}

//抽象类实现类
class Benz extends Car{
	public Benz() {
	}

	@Override
	void run() {
		System.out.println("奔驰车启动");
	}

	@Override
	void stop() {
		System.out.println("奔驰车熄火");
	}
}
//抽象类实现类
class BMW extends Car{
	public BMW() {
	}

	@Override
	void run() {
		System.out.println("宝马车启动");
	}

	@Override
	void stop() {
		System.out.println("宝马车熄火");
	}
}
//汽车工厂,获得具体汽车实例
class CarFactory{
	public CarFactory() {
	}

	public static Car getCar(String type){
		Car car=null;
		if("benz".equals(type)){
		    car=new Benz();
		}
		if("bmw".equals(type)){
		    car=new BMW();
		}
		return car;
	}


}