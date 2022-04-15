package com.structure.adapter;

/**
 * ������ģʽ��ĳ����Ľӿ�ת���ɿͻ�����������һ���ӿڱ�ʾ��
 * Ŀ�����������ڽӿڲ�ƥ������ɵ���ļ��������⡣��Ҫ��Ϊ���ࣺ���������ģʽ�������������ģʽ���ӿڵ�������ģʽ��
 * 
 * ���������ģʽ����ϣ����һ����ת����������һ���½ӿڵ���ʱ������ʹ�����������ģʽ������һ�����࣬�̳�ԭ�е��࣬ʵ���µĽӿڼ��ɡ�
�����������ģʽ����ϣ����һ������ת����������һ���½ӿڵĶ���ʱ�����Դ���һ��Wrapper�࣬����ԭ���һ��ʵ����
��Wrapper��ķ����У�����ʵ���ķ������С�
�ӿڵ�������ģʽ������ϣ��ʵ��һ���ӿ������еķ���ʱ�����Դ���һ��������Wrapper��ʵ�����з���������д������ʱ�򣬼̳г����༴�ɡ�

 * @author andy
 *
 */
public class Adapter {
	public static void main(String[] args) {
		// ��������
		Targetable clazzTargetable = new ClassAdapter();
		clazzTargetable.method1();
		clazzTargetable.method2();

		// ����������
		Targetable objectTargetable = new Wrapper(new Source());
		objectTargetable.method1();
		objectTargetable.method2();
		
		// �ӿ�������
		Sourceable source = new SourceSub1();
		Sourceable source1 = new SourceSub2();
		
		source.method1();
		source1.method2();
		
	}
}

//  =====================  ��������
class ClassAdapter extends Source implements Targetable {

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		super.method1();
//		this.method1();
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
//        System.out.println("this is the targetable method!");
		System.out.println("����������ķ���");
	}

}

class Source {
	public void method1() {
		System.out.println("����ǰ�ķ���");
	}
}

interface Targetable {
	// ��ԭ��ķ�����ͬ
	public void method1();

	// ���෽��
	public void method2();
}
//=====================  ��������

// ================ ����������  �����������������
class Wrapper implements Targetable {
	private Source source;

	public Wrapper(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		source.method1();
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("����������ķ���");
	}
}

//================ ����������
// =======================�ӿ�������  ��һ��������ʵ�ֽӿڣ���������ʹ�ýӿ��и��𷽷����ͼ̳����������
interface Sourceable {
	public void method1();

	public void method2();
}

abstract class WrapperAbstract implements Sourceable{
	@Override
	public void method1() {}
	@Override
	public void method2() {}
}

class SourceSub1 extends WrapperAbstract{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("SourceSub1 method1");
	}
	
}

class SourceSub2 extends WrapperAbstract{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("SourceSub2 method2");
	}
	
}



