package com.behavior.templateMethod;

import java.util.ArrayList;

/**
 * 模板方法模式
 * 一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，
 * 也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
 * 
 * @author andy
 *
 */
public class TemplateMethodTest {
	public static void main(String[] args) {
		AbstractCalculator calculator = new Plus();
		int result = calculator.calculate("4+6", "+");
		System.out.println("结果是: " + result);
		AbstractCalculator calculator2 = new Multiply();
		System.out.println("结果是: " + calculator2.calculate("3*6", "*"));
		AbstractCalculator calculator3 = new Divide();
		System.out.println("结果是: " + calculator3.calculate("18/6", "/"));
	}
}

abstract class AbstractCalculator {

	// 拆分算式
//	因为+、*、|、\等符号在正则表达示中有相应的不同意义，所以在使用时要进行转义处理。
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
	// 计算
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
