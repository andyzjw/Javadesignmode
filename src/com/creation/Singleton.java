package com.creation;
/**
 * ����ģʽ
 * @author andy
 *
 */
public class Singleton {

}

// ����ʽ
class SingletonLazy{
	private static SingletonLazy instance;
	// ˽�л����췽��
	private SingletonLazy() {}
	
	public static synchronized SingletonLazy getInstance() {
		 
		if(instance == null) {
			return new SingletonLazy();
		}
		return  instance;
	}
	
}
// ��ʽ
class SingletonHungary{
	private static SingletonHungary instance = new SingletonHungary();;
	// ˽�л����췽��
	private SingletonHungary() {}
	
	public static SingletonHungary getInstance() {
		 
		return  instance;
	}
	
}

// ˫����
class SingletonDoubleLock{
	private static volatile SingletonDoubleLock instance;
	
	private SingletonDoubleLock() {};
	
	public static SingletonDoubleLock getInstance() {
		if(instance == null) {
			synchronized(SingletonDoubleLock.class) {
				if(instance == null) {
					instance = new SingletonDoubleLock();
				}
			}
		}
		return instance;
	}
	
}
