package com.behavior.strategy;

/**
 * ����ģʽ
 * ����ģʽ������һϵ���㷨������ÿ���㷨��װ������ʹ���ǿ����໥�滻��
 * ���㷨�ı仯����Ӱ�쵽ʹ���㷨�Ŀͻ����㷨�仯��Ӱ��ͻ��ˣ�����Ҫ���һ���ӿڣ�
 * Ϊһϵ��ʵ�����ṩͳһ�ķ��������ʵ����ʵ�ָýӿڣ����һ�������ࣨ���п��ޣ����ڸ����ࣩ���ṩ����������
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
	 * ��Ϊ+��*��|��\�ȷ�����������ʾ������Ӧ�Ĳ�ͬ���壬������ʹ��ʱҪ����ת�崦��
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
	 * ��Ϊ+��*��|��\�ȷ�����������ʾ������Ӧ�Ĳ�ͬ���壬������ʹ��ʱҪ����ת�崦��
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
	 * ��Ϊ+��*��|��\�ȷ�����������ʾ������Ӧ�Ĳ�ͬ���壬������ʹ��ʱҪ����ת�崦��
	 */
	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int[] arrayInt =split(exp,"\\+");
		
        return arrayInt[0]+arrayInt[1];  
	}
	
}


// ������
abstract class AbstractCalculator {
	public int[] split(String exp,String opt) {
		int[] intArray =new int[2];
		
		String[] strArray = exp.split(opt);
		intArray[0] = Integer.parseInt(strArray[0]);
		intArray[1] = Integer.parseInt(strArray[1]);
		return intArray;
	}
}

// �ӿ�
interface Calculator{
	int  calculate(String exp);
}

