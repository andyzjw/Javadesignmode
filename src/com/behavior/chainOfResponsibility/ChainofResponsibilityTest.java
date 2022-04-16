package com.behavior.chainOfResponsibility;

/**
 * 责任链模式
 * 
 * 有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，
 * 直到某一对象决定处理该请求。但是发出者并不清楚到底最终那个对象会处理该请求，
 * 所以，责任链模式可以实现，在隐瞒客户端的情况下，对系统进行动态的调整。
 * 
 * 链接上的请求可以是一条链，可以是一个树，还可以是一个环，模式本身不约束这个，需要我们自己去实现，
 * 同时，在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象。
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
		System.out.println(this.name+" 开始处理了");
		
		if(getHandler() != null) {
			getHandler().operator();
		}
		System.out.println(this.name+" 开始结束了");

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