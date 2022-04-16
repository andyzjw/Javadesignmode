package com.behavior.mediator;

/**
 * �н���ģʽ
 * 
 * ������������֮�����ϵģ���Ϊ�������֮����������ϵ�Ļ��������ڹ��ܵ���չ��ά��
 * �н���ģʽ��ֻ����ĺ�Mediator��Ĺ�ϵ����������֮��Ĺ�ϵ�����Ƚ���Mediator����
 * 
 * 
 * 
 * 
 * @author andy
 *
 */
public class MediatorTest {
	public static void main(String[] args) {
		Mediator me = new MyMediator();
		me.createMediator();
		me.workAll();

	}
}

interface Mediator {
	void createMediator();

	void workAll();
}

abstract class User {
	private Mediator mediator;

	public User(Mediator mediator) {
		super();
		this.mediator = mediator;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public abstract void work();
}

class User1 extends User {

	public User1(Mediator m) {
		super(m);
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("user1 ��ʼ��");
	}
}

class User2 extends User {
	public User2(Mediator m) {
		super(m);
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("user2 ��ʼ��");
	}
}

class MyMediator implements Mediator {
	private User user1;
	private User user2;

	public User getUser1() {
		return user1;
	}

	public User getUser2() {
		return user2;
	}

	@Override
	public void createMediator() {
		user1 = new User1(this);
		user2 = new User2(this);
	}

	@Override
	public void workAll() {
		user1.work();
		user2.work();
	}

}
