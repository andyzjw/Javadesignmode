package com.structure.adapter;

/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，
 * 目的是消除由于接口不匹配所造成的类的兼容性问题。主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 * 
 * 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，
在Wrapper类的方法中，调用实例的方法就行。
接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。

 * @author andy
 *
 */
public class Adapter {
	public static void main(String[] args) {
		// 类适配器
		Targetable clazzTargetable = new ClassAdapter();
		clazzTargetable.method1();
		clazzTargetable.method2();

		// 对象适配器
		Targetable objectTargetable = new Wrapper(new Source());
		objectTargetable.method1();
		objectTargetable.method2();
		
		// 接口适配器
		Sourceable source = new SourceSub1();
		Sourceable source1 = new SourceSub2();
		
		source.method1();
		source1.method2();
		
	}
}

//  =====================  类适配器
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
		System.out.println("适配后新增的方法");
	}

}

class Source {
	public void method1() {
		System.out.println("适配前的方法");
	}
}

interface Targetable {
	// 与原类的方法相同
	public void method1();

	// 新类方法
	public void method2();
}
//=====================  类适配器

// ================ 对象适配器  将对象放入适配类中
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
		System.out.println("适配后新增的方法");
	}
}

//================ 对象适配器
// =======================接口适配器  用一个抽象类实现接口，其他类想使用接口中个别方法，就继承这个抽象类
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



