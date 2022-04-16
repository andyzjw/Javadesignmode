package com.behavior.chainOfResponsibility;

/**
 * ������ģʽ
 * 
 * �ж������ÿ��������ж���һ����������ã������ͻ��γ�һ�������������������ϴ��ݣ�
 * ֱ��ĳһ���������������󡣵��Ƿ����߲���������������Ǹ�����ᴦ�������
 * ���ԣ�������ģʽ����ʵ�֣��������ͻ��˵�����£���ϵͳ���ж�̬�ĵ�����
 * 
 * �����ϵ����������һ������������һ��������������һ������ģʽ����Լ���������Ҫ�����Լ�ȥʵ�֣�
 * ͬʱ����һ��ʱ�̣�����ֻ������һ�����󴫸���һ�����󣬶����������������
 * @author andy
 *
 */
public class ChainofResponsibilityTest {
	public static void main(String[] args) {
		MyHandler handler = new MyHandler("a");
		MyHandler handler2 = new MyHandler("b");
		MyHandler handler3 = new MyHandler("c");
		handler.setHandler(handler2);
		handler2.setHandler(handler3);
		handler.operator();
		
	}
}


class MyHandler extends AbstractHandler implements Handler{
	private String name;
	public MyHandler(String name) {
		this.name=name;
	}
	
	
	@Override
	public void operator() {
		System.out.println(this.name+" ��ʼ������");
		
		if(getHandler() != null) {
			getHandler().operator();
		}
		System.out.println(this.name+" ��ʼ������");

	}
	
}


interface Handler{
	void operator();
}

abstract class AbstractHandler{
	private Handler handler;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	
	
}