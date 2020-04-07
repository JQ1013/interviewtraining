package com.jqlmh.decoratormode;

/**
 * @author LMH
 * @create 2020-03-30 1:54
 */
public class Food {

	public static void main(String[] args) {
		Food food=new Bread(new Vegetable(new Cream(new Food("香肠"))));
		System.out.println(food.make());
	}
	private String foodName;
	public Food() {
	}

	public Food(String foodName) {
		this.foodName = foodName;
	}

	public String make(){
		return foodName;
	}
}

//面包类
class Bread extends Food{
	private Food food;

	public Bread(Food food) {
		this.food = food;
	}

	@Override
	public String make() {
		return food.make()+"+面包";
	}
}

//奶油类
class Cream extends Food{
	private Food food;

	public Cream(Food food) {
		this.food = food;
	}

	@Override
	public String make() {
		return food.make()+"+奶油";
	}
}

//蔬菜类
class Vegetable extends Food{
	private Food food;

	public Vegetable(Food food) {
		this.food = food;
	}

	@Override
	public String make() {
		return food.make()+"+蔬菜";
	}
}
