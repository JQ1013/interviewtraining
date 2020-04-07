package com.jqlmh.factorymode;

/**
 * @author LMH
 * @create 2020-03-30 5:43
 */
public class AbstractFactoryMode {
	public static void main(String[] args) {
		DefaultFactory defaultFactory = new DefaultFactory();
		defaultFactory.creatAirPlane().fly();
		defaultFactory.creatBird().fly();
		defaultFactory.creatKitty().fly();
	}
}

//抽象角色
interface Flyable{

	void fly();
}

//具体角色
class Bird implements Flyable{
	@Override
	public void fly() {
		System.out.println("小鸟可以飞");
	}
}

class AirPlane implements Flyable{
	@Override
	public void fly() {
		System.out.println("飞机可以飞");
	}
}

class Kitty implements Flyable{
	@Override
	public void fly() {
		System.out.println("风筝可以飞");
	}
}

//抽象工厂
abstract class AbstractFactory{

	public abstract Bird creatBird();
	public abstract AirPlane creatAirPlane();
	public abstract Kitty creatKitty();
}

//具体工厂
class DefaultFactory extends AbstractFactory{
	@Override
	public Bird creatBird() {
		return new Bird();
	}

	@Override
	public AirPlane creatAirPlane() {
		return new AirPlane();
	}

	@Override
	public Kitty creatKitty() {
		return new Kitty();
	}
}
