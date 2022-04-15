package com.structure.decorator;

/**
 * 装饰者模式 对一个对象增加一些功能
 *  装饰器模式的应用场景： 
 *  1、需要扩展一个类的功能。
 * 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。） 
 * 缺点：产生过多相似的对象，不易排错！
 * 
 * @author andy
 *
 */
public class Decorator implements Sourceable {
	private Sourceable sourceable;

	public Decorator(Sourceable source) {
		this.sourceable = source;
	}

	@Override
	public void method() {
		System.out.println("方法执行前装饰");
		sourceable.method();
		System.out.println("方法执行后装饰");
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

class Test {
	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable sourceable = new Decorator(source);
		sourceable.method();
	}
}