package com.behavior.mediator;

/**
 * 中介者模式
 * 
 * 用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，不利于功能的拓展和维护
 * 中介者模式，只需关心和Mediator类的关系，具体类类之间的关系及调度交给Mediator就行
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
		System.out.println("user1 开始了");
	}
}

class User2 extends User {
	public User2(Mediator m) {
		super(m);
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("user2 开始了");
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
