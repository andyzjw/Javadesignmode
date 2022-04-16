package com.behavior.command;

/**
 * ����ģʽ
 * �ٸ����ӣ�˾��Ա������ʿ��ȥ�ɼ����飬����������ĽǶ������ǣ�˾��Ա�������ǣ����������������ݣ�������ʿ�������ʿ��ȥִ�С�
 * ������̺��ڣ������໥����κ�һ��������ȥ���������ˣ�ֻ��Ҫ�����Լ����¶����У�˾��ԱҪ���ǽ��������ȥ��ע����ʿ������ôʵ�ֵ�
 * 
 * ����ģʽ��Ŀ�ľ��Ǵﵽ����ķ����ߺ�ִ����֮����ʵ�������ִ�зֿ�
 * 
 * @author andy
 *
 */
public class CommandTest {
	public static void main(String[] args) {
		Invoker invoke = new Invoker(new MyCommand(new Receiver()));
		invoke.action("����������ҹ");
	}
}

//����ͷ�
class Invoker{
	private Command command;
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void action(String str) {
		System.out.println("�����: "+str);
		command.execute(str);
	}
}

interface Command{
	void execute(String str);
}

// ��������һ������Ҫ������͸�ִ����
class MyCommand implements Command{
	private Receiver receiver;
	
	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void execute(String str) {
		System.out.println("������յ��ˣ���ʼת�������շ�");
		receiver.action(str);
	}
	
}

class Receiver{
	public void action(String str) {
		System.out.println("Receiver ��ʼִ������:  "+str);
	}
}