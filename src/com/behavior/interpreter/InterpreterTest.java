package com.behavior.interpreter;

/**
 * ������ģʽ
 * һ����ҪӦ����OOP�����еı������Ŀ����У�����������Ƚ�խ
 * ������������һ�����ԣ�����������Ե��ķ���ʾ�������һ�������������������еľ��ӡ�
 * Ҳ����˵���ñ������Եķ�ʽ������Ӧ���е�ʵ��������ģʽʵ�����ķ����ʽ����Ľӿڣ��ýӿڽ���һ���ض��������ġ�
 * 
 * ���������ָ����Ľ���������������ʽ�ȵĽ�����
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