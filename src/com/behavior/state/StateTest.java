package com.behavior.state;
/**
 * 状态模式
 * 
 * 当对象的状态改变时，同时改变其行为，很好理解！就拿QQ来说，有几种状态，在线、隐身、忙碌等，
 * 每个状态对应不同的操作，而且你的好友也能看到你的状态，
 * 所以，状态模式就两点：1、可以通过改变状态来获得不同的行为。2、你的好友能同时看到你的变化。
 * @author andy
 *
 */
public class StateTest {
	public static void main(String[] args) {
		State state = new State("up");
		Context context = new Context(state);
		
		context.execute();
		
		context.setState(new State("down"));
		context.execute();

	}
}

class State{
	private String value;

	public State(String value) {
		super();
		this.value = value;
	}


	public void method1() {
		System.out.println("执行方法1");
	}

	
	public void method2() {
		System.out.println("执行方法2");
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}


class Context{
	private State state;
	public Context(State state) {
		this.state = state;
	}
	
	public void execute() {
		if("up".equals(this.state.getValue())) {
			this.state.method1();
		}else if("down".equals(this.state.getValue())) {
			this.state.method2();
		}else {
			System.out.println("无此方法");
		}
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
