package com.behavior.memento;

/**
 * ����¼ģʽ ����һ�������ĳ��״̬���Ա����ʵ���ʱ��ָ����󣬸��˾��ýб���ģʽ������Щ��ͨ�׵Ľ��£�������ԭʼ��A��A���и������ԣ�
 * A���Ծ�����Ҫ���ݵ����ԣ�����¼��B�������洢A��һЩ�ڲ�״̬����C�أ�����һ�������洢����¼�ģ���ֻ�ܴ洢�������޸ĵȲ���
 * 
 * A ->B ->C
 * 
 * Original����ԭʼ�࣬��������Ҫ���������value������һ������¼�࣬��������valueֵ��
 * Memento���Ǳ���¼�࣬Storage���Ǵ洢����¼���࣬����Memento���ʵ������ģʽ�ܺ���⡣
 * 
 * @author andy
 *
 */
public class MementoTest {
	public static void main(String[] args) {
		Original original = new Original("����Ҫȥ����");
		// ����
		Storage storage = new Storage(original.createMemento());
		
		System.out.println("�޸�ǰ ["+original.getValue()+"]\n�޸��±���¼��");
		original.setValue("��ȥ���У���ȥ����");
		System.out.println("["+original.getValue()+"]");

		System.out.println("���˲�ȥ�����޸Ļ�����");
		
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
