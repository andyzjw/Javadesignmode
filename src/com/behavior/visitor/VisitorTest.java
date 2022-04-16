package com.behavior.visitor;

/**
 * ������ģʽ
 * ������ģʽ�����ݽṹ�������ڽṹ�ϵĲ�������ϣ�ʹ�ò������Ͽ�������ɵ��ݻ���������ģʽ���������ݽṹ����ȶ��㷨���ױ仯��ϵͳ
 * �ŵ㣺���Ӳ�������
 * 
 * ��ģʽ���ó��������������Ϊһ�����е��������¹��ܣ����ò����Ǽ������飺
 * 1���¹��ܻ᲻�������й��ܳ��ּ��������⣿
 * 2���Ժ�᲻������Ҫ��ӣ�
 * 3������಻�����޸Ĵ�����ô�죿
 * �����Щ���⣬��õĽ����������ʹ�÷�����ģʽ��������ģʽ���������ݽṹ����ȶ���ϵͳ�������ݽṹ���㷨����
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
	// ����
	void visit(Subject subject);

}

class MyVisitor implements Visitor{

	@Override
	public void visit(Subject subject) {
		System.out.println("���ʵ�Subject�������ݣ�"+subject.getDate());
	}
	
}

interface Subject{
	// ���ܷ�����
	void accept(Visitor visitor);
	// ��ȡ��Ҫ���ʵ�����
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
