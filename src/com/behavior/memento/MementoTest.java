package com.behavior.memento;

/**
 * 备忘录模式 保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，通俗的讲下：假设有原始类A，A中有各种属性，
 * A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作
 * 
 * A ->B ->C
 * 
 * Original类是原始类，里面有需要保存的属性value及创建一个备忘录类，用来保存value值。
 * Memento类是备忘录类，Storage类是存储备忘录的类，持有Memento类的实例，该模式很好理解。
 * 
 * @author andy
 *
 */
public class MementoTest {
	public static void main(String[] args) {
		Original original = new Original("今天要去郊游");
		// 备份
		Storage storage = new Storage(original.createMemento());
		
		System.out.println("修改前 ["+original.getValue()+"]\n修改下备忘录吧");
		original.setValue("先去超市，再去郊游");
		System.out.println("["+original.getValue()+"]");

		System.out.println("算了不去超市修改回来吧");
		
		original.restoreMemento(storage.getMemento());
		System.out.println("["+original.getValue()+"]");
		
	}
}

class Original {
	private String value;

	public Original(String value) {
		this.value = value;
	}

	public Memento createMemento() {
		return new Memento(value);
	}

	public void restoreMemento(Memento memento) {
		this.value = memento.getValue();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

class Memento {
	private String value;

	public Memento(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

class Storage {

	private Memento memento;

	public Storage(Memento memento) {
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
