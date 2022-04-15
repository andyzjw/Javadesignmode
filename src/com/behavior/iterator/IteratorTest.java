package com.behavior.iterator;

/**
 * ������ģʽ ������ģʽ����˳����ʾۼ��еĶ���һ����˵�������зǳ������� ����Լ�����Ƚ���Ϥ�Ļ�����Ȿģʽ��ʮ�����ɡ�
 * ��仰����������˼��һ����Ҫ�����Ķ��󣬼��ۼ����󣬶��ǵ������������ڶԾۼ�������б�������
 * 
 *���� �ӿ� Collection Iterator
 * ������ҪIterator ˳����ʾۼ����� ����Iteratorʵ�ֶ���(MyIterator) �� ��Ҫʵ��Collection�Ķ���(Mycollection)�� 
 * MyIterator��ʵ��Mycollection������ʵ����ʱ������������
 * 
 *Iterator�ӿڷ��� next; hasNext; previous; first  ;
 *Collection�ӿڷ���  iterator���� ����Iterator ; put ; get; size;
 * 
 * MyCollection ʵ��Collection ʵ����ʱ��ʼ�� MyIterator ������ Iterator
 * �����Ա��private Iterator iterator; ���ⷽ���� public Iterator iterator()
 *  
 *  MyIterator 
 *  �����Ա�� private Collection collection; (�� ʵ����Mycollectionʱ��ע��)
 * 
 * @author andy
 *
 */
public class IteratorTest {
	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator it= collection.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println(it.First());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.previous());
	}
}

interface Collection {
	Iterator iterator();

	void put(Object o);

	Object get(int i);

	/* ȡ�ü��ϴ�С */
	int size();

}

class MyCollection implements Collection {
	private Iterator iterator;

	private String[] strArray = { "aaa", "bbb", "ccc", "ddd", "eee" };
	private int size = strArray.length;

	public MyCollection() {
		super();
		this.iterator = new MyIterator(this);
	}

	@Override
	public Iterator iterator() {
		return this.iterator;
	}

	@Override
	public void put(Object o) {
		System.out.println("����");

	}

	@Override
	public Object get(int i) {
		if (i > this.size - 1) {
			return null;
		}
		return strArray[i];
	}

	@Override
	public int size() {
		return this.size;
	}

}

interface Iterator {
	Object previous();

	Object next();

	boolean hasNext();

	Object First();

}

class MyIterator implements Iterator {
	private Collection collection;
	private int pos = -1; // ��¼��ǰλ��
	
	public MyIterator(Collection c) {
		this.collection = c;
	}

	@Override
	public Object previous() {
		if(this.pos > 0) {
			this.pos --;
		}else {
			throw new ArrayIndexOutOfBoundsException("Խ����");
		}
		return collection.get(pos);
	}

	@Override
	public Object next() {
		if(this.pos < collection.size()-1) {
			return collection.get(++this.pos);
		}else {
			return null;
		}
		
	}

	@Override
	public boolean hasNext() {
		if( this.pos < collection.size()-1) {
			return true;
		}
		
		return false;
	}

	@Override
	public Object First() {
		Object o =collection.get(this.pos = 0);
		System.out.println("��ǰthis.pos "+pos);
 		return o;
	}

}