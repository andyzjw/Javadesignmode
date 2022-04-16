package com.behavior.state;
/**
 * ״̬ģʽ
 * 
 * �������״̬�ı�ʱ��ͬʱ�ı�����Ϊ���ܺ���⣡����QQ��˵���м���״̬�����ߡ�����æµ�ȣ�
 * ÿ��״̬��Ӧ��ͬ�Ĳ�����������ĺ���Ҳ�ܿ������״̬��
 * ���ԣ�״̬ģʽ�����㣺1������ͨ���ı�״̬����ò�ͬ����Ϊ��2����ĺ�����ͬʱ������ı仯��
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
		System.out.println("ִ�з���1");
	}

	
	public void method2() {
		System.out.println("ִ�з���2");
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
			System.out.println("�޴˷���");
		}
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
