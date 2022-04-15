package com.behavior.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 
 * �۲���ģʽ��������֮��Ĺ�ϵ��
 * ��һ������仯ʱ�����������ö���Ķ��󶼻��յ�֪ͨ���������ű仯������֮����һ��һ�Զ�Ĺ�ϵ��
 * 
 * ����۲��߽ӿ�Observer ���۲��߶���2��(ʵ�ִ˽ӿ�) ObserverSub1 ObserverSub2
 * ���屻�۲�Ķ���ӿ�
 * ����Subject �ӿ� �����������ӹ۲��ߡ��Ƴ��۲��ߡ�֪ͨ�۲��߱��۲����仯�ˡ����۲��߱仯���еĴ���
 * 
 * AbstractSubject������ʵ��Subject ��Թ۲��ߵĲ��� ���� �Ƴ���֪ͨ�۲���Ҫ���еķ���
 * 
 * MySubject �������۲�Ķ��󣬼̳�AbstractSubject��ʵ��operation����(���۲��߱仯���еĴ��룬�Լ�֪ͨ�����۲��� )
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
//  �۲���===============================================
interface Observer{
	void update();
}

class ObserverSub1 implements Observer{

	@Override
	public void update() {
		System.out.println("ObserverSub1 ���յ�MySubject�仯��׼������");
	}
	
}

class ObserverSub2 implements Observer{

	@Override
	public void update() {
		System.out.println("ObserverSub2 ���յ�MySubject�仯��׼������");
	}
	
}
//�۲���===============================================

// ���۲췽
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
		System.out.println("MySubject ��Ҫ��ʼ�仯��");
		super.notifyObservers();
	}
	
}

