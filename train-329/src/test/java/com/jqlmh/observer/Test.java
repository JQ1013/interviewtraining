package com.jqlmh.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LMH
 * @create 2020-03-30 0:54
 */
public class Test {
	public static void main(String[] args) {
		XiaoWang xiaoWang = new XiaoWang();
		XiaoLi xiaoLi = new XiaoLi();
		Xiaomei xiaomei = new Xiaomei();
		//小王和小李都在小美这里注册一下
		xiaomei.addObserver(xiaoLi);
		xiaomei.addObserver(xiaoWang);
		//小美发送通知给两位
		xiaomei.notifyObserver();
	}

}

//小王和小李通过这个借口可以收到小美的消息(想当与小王和小李的电话),小美发送通知就会拨打getMessage这个电话给小王和小李告诉他们
interface Observe {
	void getMessage(String msg);
}


//小美
class Xiaomei{
	private List<Observe> list= new ArrayList<>();

	public Xiaomei() {
	}

	public void addObserver(Observe observe){
		list.add(observe);
	}

	//遍历list,把消息发送给暗恋自己的人
	public void notifyObserver(){
		for (Observe observe : list) {
			observe.getMessage("我是小美,你们谁先收到我的消息我就和谁约会");
		}
	}

}

//小李
class XiaoLi implements Observe{

	private final String name="小李";

	public XiaoLi() {
	}

	@Override
	public void getMessage(String msg) {
		System.out.println(name+"收到来自小美的消息:"+msg);
	}
}

//小王
class XiaoWang implements Observe{
	private final String name="小王";

	public XiaoWang() {
	}


	@Override
	public void getMessage(String msg) {
		System.out.println(name+"收到来自小美的消息:"+msg);
	}
}
