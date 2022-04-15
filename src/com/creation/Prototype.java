package com.creation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式
 * 原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，
 * 该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 * @author andy
 *
 */
public class Prototype {

	 public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		// 浅复制测试 ，对象只是把引用直接复制而已
//		 SchoolRoomShallow school = new SchoolRoomShallow();
//		 school.setStudent(new Student("小明",11));
//		 SchoolRoomShallow school2 =(SchoolRoomShallow) school.clone();
//		 school2.getStudent().setName("改动名字啦");
//		 System.out.println(school);
//		 System.out.println(school2);
		 // 深复制
		 SchoolRoomDeep school3 = new SchoolRoomDeep();
		 school3.setStudent(new StudentDeep("小明",11));
		 SchoolRoomDeep school4 =(SchoolRoomDeep) school3.deepclone();
		 school4.getStudent().setName("改动名字啦");
		 System.out.println(school3);
		 System.out.println(school4);
		 
	}
}

// 深复制 复制基本数据类型（开辟内存空间）；复制对象（开辟内存空间）
class SchoolRoomDeep implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5325908259669889667L;
	private StudentDeep student ;
	 public StudentDeep getStudent() {
		return student;
	}
	public void setStudent(StudentDeep student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "SchoolRoomDeep [student=" + student + "]";
	}
	
	protected Object deepclone() throws CloneNotSupportedException, IOException, ClassNotFoundException  {
		 
		  /* 写入当前对象的二进制流 */  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = new ObjectOutputStream(bos);  
        oos.writeObject(this);  
  
        /* 读出二进制流产生的新对象 */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return ois.readObject();  

        
	}
	
	 

}



// 浅复制，复制基本数据类型（开辟空间）；复制对象（只是把引用复制过去）
class SchoolRoomShallow implements Cloneable{
	private Student student ;
	 public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Object clone() throws CloneNotSupportedException {  
		 SchoolRoomShallow proto = (SchoolRoomShallow) super.clone();  
	        return proto;  
	    }
	@Override
	public String toString() {
		return "SchoolRoomShallow [student=" + student + "]";
	}  

}



class Student{
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	public Student() {}
	public Student(String name ,int age) {
		this.name = name;
		this.age =age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class StudentDeep implements Serializable {
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return "StudentDeep [name=" + name + ", age=" + age + "]";
	}
	public StudentDeep() {}
	public StudentDeep(String name ,int age) {
		this.name = name;
		this.age =age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}