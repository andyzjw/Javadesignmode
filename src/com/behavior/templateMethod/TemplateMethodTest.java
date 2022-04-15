package com.behavior.templateMethod;

import java.util.ArrayList;

/**
 * ģ�巽��ģʽ
 * һ���������У���һ�����������ٶ���1...n�������������ǳ���ģ�
 * Ҳ������ʵ�ʵķ���������һ���࣬�̳иó����࣬��д���󷽷���ͨ�����ó����࣬ʵ�ֶ�����ĵ���
 * 
 * @author andy
 *
 */
public class TemplateMethodTest {
	public static void main(String[] args) {
		AbstractCalculator calculator = new Plus();
		int result = calculator.calculate("4+6", "+");
		System.out.println("�����: " + result);
		AbstractCalculator calculator2 = new Multiply();
		System.out.println("�����: " + calculator2.calculate("3*6", "*"));
		AbstractCalculator calculator3 = new Divide();
		System.out.println("�����: " + calculator3.calculate("18/6", "/"));
	}
}

abstract class AbstractCalculator {

	// �����ʽ
//	��Ϊ+��*��|��\�ȷ�����������ʾ������Ӧ�Ĳ�ͬ���壬������ʹ��ʱҪ����ת�崦��
	public int[] split(String exp, String type) {
		if ("+".equals(type)) {
			type = "\\+";
		} else if ("*".equals(type)) {
			type = "\\*";
		} else if ("/".equals(type)) {
			type = "\\/";
		}

		String[] strArray = exp.split(type);
		int[] intArray = { Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]) };

		return intArray;
	}
	// ����
	public final int calculate(String exp, String type) {
		int[] array = this.split(exp, type);
		return calculate(array[0], array[1]);
	}

	public abstract int calculate(int num1, int num2);
}

class Plus extends AbstractCalculator {

	@Override
	public int calculate(int num1, int num2) {

		return num1 + num2;
	}

}



class Multiply extends AbstractCalculator{

	@Override
	public int calculate(int num1, int num2) {
		return num1 * num2;
	}
	
}


class Divide extends AbstractCalculator{

	@Override
	public int calculate(int num1, int num2) {
		return num1 / num2;
	}
	
}
