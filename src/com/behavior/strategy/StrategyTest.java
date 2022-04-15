package com.behavior.strategy;

/**
 * 策略模式
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，
 * 且算法的变化不会影响到使用算法的客户。需要设计一个接口，
 * 为一系列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类（可有可无，属于辅助类），提供辅助函数，
 * @author andy
 *
 */
public class StrategyTest {
	public static void main(String[] args) {
		Calculator c = new Minus();
		System.out.println(c.calculate("2-8"));
		
		
	}
}

class Multiply  extends AbstractCalculator implements Calculator{
	 
	/**
	 * 因为+、*、|、\等符号在正则表达示中有相应的不同意义，所以在使用时要进行转义处理。
	 */
	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int[] arrayInt =split(exp,"\\*");
		
        return arrayInt[0]*arrayInt[1];  
	}
	
}

class Minus extends AbstractCalculator implements Calculator{
	 
	/**
	 * 因为+、*、|、\等符号在正则表达示中有相应的不同意义，所以在使用时要进行转义处理。
	 */
	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int[] arrayInt =split(exp,"-");
		
        return arrayInt[0]-arrayInt[1];  
	}
	
}

class Plus extends AbstractCalculator implements Calculator{
 
	/**
	 * 因为+、*、|、\等符号在正则表达示中有相应的不同意义，所以在使用时要进行转义处理。
	 */
	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int[] arrayInt =split(exp,"\\+");
		
        return arrayInt[0]+arrayInt[1];  
	}
	
}


// 辅助类
abstract class AbstractCalculator {
	public int[] split(String exp,String opt) {
		int[] intArray =new int[2];
		
		String[] strArray = exp.split(opt);
		intArray[0] = Integer.parseInt(strArray[0]);
		intArray[1] = Integer.parseInt(strArray[1]);
		return intArray;
	}
}

// 接口
interface Calculator{
	int  calculate(String exp);
}

