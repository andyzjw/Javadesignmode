package com.behavior.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 
 * 观察者模式（类与类之间的关系）
 * 当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化！对象之间是一种一对多的关系。
 * 
 * 定义观察者接口Observer ，观察者对象2个(实现此接口) ObserverSub1 ObserverSub2
 * 定义被观察的对象接口
 * 定义Subject 接口 ，方法：增加观察者、移除观察者、通知观察者被观察对象变化了、被观察者变化运行的代码
 * 
 * AbstractSubject抽象类实现Subject 针对观察者的操作 增加 移除，通知观察者要运行的方法
 * 
 * MySubject 真正被观察的对象，继承AbstractSubject，实现operation方法(被观察者变化运行的代码，以及通知各个观察者 )
 * 
 * @author andy
 *
 */
public class ObserverTest {
	public static void main(String[] args) {
		Subject my = new MySubject();
		Observer o = new ObserverSub1();
		my.add(o);
		my.add(new ObserverSub2());
		
		my.operation();
		my.remove(o);
		my.operation();
	}
}
//  观察者===============================================
interface Observer{
	void update();
}

class ObserverSub1 implements Observer{

	@Override
	public void update() {
		System.out.println("ObserverSub1 接收到MySubject变化，准备更新");
	}
	
}

class ObserverSub2 implements Observer{

	@Override
	public void update() {
		System.out.println("ObserverSub2 接收到MySubject变化，准备更新");
	}
	
}
//观察者===============================================

// 被观察方
interface Subject{
	void add(Observer observer);
	void remove(Observer observer);
	void notifyObservers();
	void operation();
}


abstract class AbstractSubject implements Subject{

	private Vector<Observer> vector = new Vector<Observer>();
	
	@Override
	public void add(Observer observer) {
		vector.add(observer);		
	}

	@Override
	public void remove(Observer observer) {
		vector.remove(observer);		
	}

	@Override
	public void notifyObservers() {
		Enumeration<Observer> enumeration = this.vector.elements();
		
		while (enumeration.hasMoreElements()) {
			  enumeration.nextElement().update();
		}
	}

}


class MySubject extends AbstractSubject{

	@Override
	public void operation() {
		System.out.println("MySubject 我要开始变化啦");
		super.notifyObservers();
	}
	
}

