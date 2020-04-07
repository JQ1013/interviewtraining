package com.jqlmh.proxy;

/**
 * @author LMH
 * @create 2020-03-30 5:54
 */
public class ProxyTest {
	public static void main(String[] args) {
		ProxyInterface proxyInterface = new WeddingCompany(new NormalHome());
		proxyInterface.marry();
	}
}

//代理接口
interface ProxyInterface {
	//需要代理的是结婚这件事，如果还有其他事情需要代理，比如吃饭睡觉上厕所，也可以写
	void marry();
}

//代理类
class WeddingCompany implements ProxyInterface {

	private ProxyInterface proxyInterface;

	public WeddingCompany(ProxyInterface proxyInterface) {
		this.proxyInterface = proxyInterface;
	}

	@Override
	public void marry() {
		System.out.println("我们是婚庆公司的");
		System.out.println("我们在做结婚前的准备工作");
		System.out.println("节目彩排...");
		System.out.println("礼物购买...");
		System.out.println("工作人员分工...");
		System.out.println("可以开始结婚了");
		proxyInterface.marry();
		System.out.println("结婚完毕，我们需要做后续处理，你们可以回家了，其余的事情我们公司来做");
	}
}


//被代理类
class NormalHome implements ProxyInterface{

	@Override
	public void marry() {
		//被代理类对象实际要做的事
		System.out.println("我们结婚啦～");
	}

}