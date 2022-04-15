package com.structure.decorator;

/**
 * װ����ģʽ ��һ����������һЩ����
 *  װ����ģʽ��Ӧ�ó����� 
 *  1����Ҫ��չһ����Ĺ��ܡ�
 * 2����̬��Ϊһ���������ӹ��ܣ����һ��ܶ�̬���������̳в���������һ�㣬�̳еĹ����Ǿ�̬�ģ����ܶ�̬��ɾ���� 
 * ȱ�㣺�����������ƵĶ��󣬲����Ŵ�
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
		System.out.println("����ִ��ǰװ��");
		sourceable.method();
		System.out.println("����ִ�к�װ��");
	}
}

interface Sourceable {
	void method();
}

class Source implements Sourceable {

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}

}

class Test {
	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable sourceable = new Decorator(source);
		sourceable.method();
	}
}