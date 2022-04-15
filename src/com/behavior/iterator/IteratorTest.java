package com.behavior.iterator;

/**
 * 迭代子模式 迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见， 如果对集合类比较熟悉的话，理解本模式会十分轻松。
 * 这句话包含两层意思：一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问
 * 
 *创建 接口 Collection Iterator
 * 由于需要Iterator 顺序访问聚集对象 所以Iterator实现对象(MyIterator) 里 需要实现Collection的对象(Mycollection)。 
 * MyIterator由实现Mycollection对象在实例化时，创建并持有
 * 
 *Iterator接口方法 next; hasNext; previous; first  ;
 *Collection接口方法  iterator方法 返回Iterator ; put ; get; size;
 * 
 * MyCollection 实现Collection 实例化时初始化 MyIterator 并赋予 Iterator
 * 特殊成员：private Iterator iterator; 特殊方法： public Iterator iterator()
 *  
 *  MyIterator 
 *  特殊成员： private Collection collection; (由 实例化Mycollection时，注入)
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

	/* 取得集合大小 */
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
		System.out.println("增加");

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
	private int pos = -1; // 记录当前位置
	
	public MyIterator(Collection c) {
		this.collection = c;
	}

	@Override
	public Object previous() {
		if(this.pos > 0) {
			this.pos --;
		}else {
			throw new ArrayIndexOutOfBoundsException("越界啦");
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
		System.out.println("当前this.pos "+pos);
 		return o;
	}

}