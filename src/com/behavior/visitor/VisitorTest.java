package com.behavior.visitor;

/**
 * 访问者模式
 * 访问者模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由地演化。访问者模式适用于数据结构相对稳定算法又易变化的系统
 * 优点：增加操作容易
 * 
 * 该模式适用场景：如果我们想为一个现有的类增加新功能，不得不考虑几个事情：
 * 1、新功能会不会与现有功能出现兼容性问题？
 * 2、以后会不会再需要添加？
 * 3、如果类不允许修改代码怎么办？
 * 面对这些问题，最好的解决方法就是使用访问者模式，访问者模式适用于数据结构相对稳定的系统，把数据结构和算法解耦
 * @author andy
 *
 */
public class VisitorTest {
	public static void main(String[] args) {
		Visitor visitor = new MyVisitor();
		Subject subject = new MySubject("welcome");
		
		subject.accept(visitor);
		
	}
}

interface Visitor{
	// 访问
	void visit(Subject subject);

}

class MyVisitor implements Visitor{

	@Override
	public void visit(Subject subject) {
		System.out.println("访问到Subject啦，数据："+subject.getDate());
	}
	
}

interface Subject{
	// 接受访问者
	void accept(Visitor visitor);
	// 获取需要访问的数据
	String getDate();
}

class MySubject implements Subject{
	private String date;
	
	
	public MySubject(String date) {
		super();
		this.date = date;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getDate() {
		return date;
	}
	
 	public void setDate(String date) {
		this.date = date;
	}
	
}
