package com.jqlmh.factorymode;

/**
 * @author LMH
 * @create 2020-03-30 5:32
 */
public class FactoryMethod {
	public static void main(String[] args) {
		PlaneFactory planeFactory = new PlaneFactory();
		Moveable moveable = planeFactory.create();
		moveable.run();

		Bikefactory bikefactory = new Bikefactory();
		Moveable moveable1 = bikefactory.create();
		moveable1.run();

	}
}

//抽象产品角色
interface Moveable{

	void run();
}

//具体产品角色
class Plane implements Moveable{
	@Override
	public void run() {
		System.out.println("飞机");
	}
}

class Bike implements Moveable{
	@Override
	public void run() {
		System.out.println("自行车");
	}
}

//抽象共厂
abstract class Factory{
	//造产品
	public abstract Moveable create();
}

//具体工厂
class PlaneFactory extends Factory{

	@Override
	public Moveable create() {
		return new Plane();
	}
}

class Bikefactory extends Factory{
	@Override
	public Moveable create() {
		return new Bike();
	}
}


