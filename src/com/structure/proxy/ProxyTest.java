package com.structure.proxy;

/**
 * 代理模式 
 * 代理模式的应用场景： 
 * 如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
 * 1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
 * 2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。 使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
 * 
 * @author andy
 *
 */
public class ProxyTest {
	public static void main(String[] args) {
		Sourceable sourceable = new Proxy();
		sourceable.method();
		
	}
}

interface Sourceable {
	void method();
}

class Source implements Sourceable {

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("主方法");
	}

}

class Proxy implements Sourceable {
	private Sourceable sourceable;

	public Proxy() {
		super();
		this.sourceable = new Source();
	}

	@Override
	public void method() {
		before();
		sourceable.method();
		after();
	}

	private void after() {
		// TODO Auto-generated method stub
		System.out.println("proxy 代理后");

	}

	private void before() {
		// TODO Auto-generated method stub
		System.out.println("proxy 代理前");

	}

}