package com.jqlmh.adapter;

/**
 * @author LMH
 * @create 2020-03-30 3:26
 */
public class Test {
	public static void main(String[] args) {
		Phone phone = new Phone(new ChargeAdapter());
		phone.charge();
	}
}

class Phone{
	//正常交流电电流
	public static final int v=220;

	//手机充电器适配器
	private ChargeAdapter adapter=new ChargeAdapter();

	public Phone() {
	}

	public Phone(ChargeAdapter adapter) {
		this.adapter = adapter;
	}
	//充电,调用变压器转换电压
	public void charge(){
		adapter.chargeVoltage();
	}

}

//变压器(就相当于一个适配器)
class ChargeAdapter{
	//改变电压的功能
	public void chargeVoltage(){
		System.out.println("手机正在充电");
		System.out.println("手机充电的原始电压为:"+Phone.v+"v");
		System.out.println("经过变压适配器适配电压后的电压为"+(Phone.v-200)+"v");
	}
}

