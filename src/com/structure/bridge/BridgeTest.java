package com.structure.bridge;

 
/**
 * 桥接模式
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：将抽象化与实现化解耦，
 * 使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时候，在各个数据库之间进行切换，
 * 基本不需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了。
 * @author andy
 *
 */
public class BridgeTest {
	public static void main(String[] args) {
		Bridge bridge = new MyBridge();
		bridge.setSourceable(new SourceSub1());
		bridge.method1();
	}
}



class MyBridge extends Bridge{
	 public void method1(){  
		 getSourceable().method1();  
	    }  
}

abstract class Bridge {
	private Sourceable sourceable;

	public Sourceable getSourceable() {
		return sourceable;
	}

	public void setSourceable(Sourceable sourceable) {
		this.sourceable = sourceable;
	}
	
	 public void method1(){  
		 sourceable.method1();  
	    }  

}

interface Sourceable {
	public void method1();
}

class SourceSub1 implements Sourceable{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("SourceSub1 method1");
	}
	
}

class SourceSub2 implements Sourceable{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("SourceSub2 method2");
	}
	
}