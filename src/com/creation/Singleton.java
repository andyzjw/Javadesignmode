package com.creation;
/**
 * 单例模式
 * @author andy
 *
 */
public class Singleton {

}

// 懒汉式
class SingletonLazy{
	private static SingletonLazy instance;
	// 私有化构造方法
	private SingletonLazy() {}
	
	public static synchronized SingletonLazy getInstance() {
		 
		if(instance == null) {
			return new SingletonLazy();
		}
		return  instance;
	}
	
}
// 恶汉式
class SingletonHungary{
	private static SingletonHungary instance = new SingletonHungary();;
	// 私有化构造方法
	private SingletonHungary() {}
	
	public static SingletonHungary getInstance() {
		 
		return  instance;
	}
	
}

// 双重锁
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
