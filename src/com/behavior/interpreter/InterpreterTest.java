package com.behavior.interpreter;

/**
 * 解释器模式
 * 一般主要应用在OOP开发中的编译器的开发中，所以适用面比较窄
 * 给分析对象定义一个语言，并定义该语言的文法表示，再设计一个解析器来解释语言中的句子。
 * 也就是说，用编译语言的方式来分析应用中的实例。这种模式实现了文法表达式处理的接口，该接口解释一个特定的上下文。
 * 
 * 用来做各种各样的解释器，如正则表达式等的解释器
 * 
 * @author andy
 *
 */
public class InterpreterTest {
	public static void main(String[] args) {
		int result = new Plus().interpret(new Context(2, 3));
		System.out.println("2+3="+result);
		
		result = new Minus().interpret(new Context(new Plus().interpret(new Context(5, 3)),2));
		System.out.println("5+3-2="+result);
	}
}

interface Interpreter{
	int interpret(Context context);
}

class Plus implements Interpreter{

	@Override
	public int interpret(Context context) {
		return context.getNum1()+context.getNum2();
	}
	
}

class Minus implements Interpreter{
	@Override
	public int interpret(Context context) {
		return context.getNum1()-context.getNum2();
	}
}

class Context{
	private int num1;
	private int num2;
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public Context(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	
}