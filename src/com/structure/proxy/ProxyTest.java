package com.structure.proxy;

/**
 * ����ģʽ 
 * ����ģʽ��Ӧ�ó����� 
 * ������еķ�����ʹ�õ�ʱ����Ҫ��ԭ�еķ������иĽ�����ʱ�����ְ취��
 * 1���޸�ԭ�еķ�������Ӧ������Υ���ˡ�����չ���ţ����޸Ĺرա���ԭ��
 * 2�����ǲ���һ�����������ԭ�еķ������ҶԲ����Ľ�����п��ơ����ַ������Ǵ���ģʽ�� ʹ�ô���ģʽ�����Խ����ܻ��ֵĸ��������������ں���ά����
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
		System.out.println("������");
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
		System.out.println("proxy �����");

	}

	private void before() {
		// TODO Auto-generated method stub
		System.out.println("proxy ����ǰ");

	}

}