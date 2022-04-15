package com.structure.bridge;

 
/**
 * �Ž�ģʽ
 * �Ž�ģʽ���ǰ�����������ʵ�ַֿ���ʹ���ǿ��Ը��Զ����ı仯���Žӵ������ǣ���������ʵ�ֻ����
 * ʹ�ö��߿��Զ����仯�������ǳ��õ�JDBC��DriverManagerһ����JDBC�����������ݿ��ʱ���ڸ������ݿ�֮������л���
 * ��������Ҫ��̫��Ĵ��룬����˿�����ö���ԭ�����JDBC�ṩͳһ�ӿڣ�ÿ�����ݿ��ṩ���Ե�ʵ�֣���һ���������ݿ������ĳ������ŽӾ����ˡ�
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