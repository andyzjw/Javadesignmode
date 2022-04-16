package com.behavior.command;

/**
 * 命令模式
 * 举个例子，司令员下令让士兵去干件事情，从整个事情的角度来考虑，司令员的作用是，发出口令，口令经过传递，传到了士兵耳朵里，士兵去执行。
 * 这个过程好在，三者相互解耦，任何一方都不用去依赖其他人，只需要做好自己的事儿就行，司令员要的是结果，不会去关注到底士兵是怎么实现的
 * 
 * 命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开
 * 
 * @author andy
 *
 */
public class CommandTest {
	public static void main(String[] args) {
		Invoker invoke = new Invoker(new MyCommand(new Receiver()));
		invoke.action("今晚认真守夜");
	}
}

//命令发送方
class Invoker{
	private Command command;
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void action(String str) {
		System.out.println("命令发送: "+str);
		command.execute(str);
	}
}

interface Command{
	void execute(String str);
}

// 接收命令一方，需要把命令发送给执行者
class MyCommand implements Command{
	private Receiver receiver;
	
	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void execute(String str) {
		System.out.println("命令接收到了，开始转发给接收方");
		receiver.action(str);
	}
	
}

class Receiver{
	public void action(String str) {
		System.out.println("Receiver 开始执行命令:  "+str);
	}
}