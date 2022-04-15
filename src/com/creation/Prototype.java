package com.creation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ԭ��ģʽ
 * ԭ��ģʽ��Ȼ�Ǵ����͵�ģʽ�������빤��ģʽû�й�ϵ�������ּ��ɿ�����
 * ��ģʽ��˼����ǽ�һ��������Ϊԭ�ͣ�������и��ơ���¡������һ����ԭ�������Ƶ��¶���
 * @author andy
 *
 */
public class Prototype {

	 public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		// ǳ���Ʋ��� ������ֻ�ǰ�����ֱ�Ӹ��ƶ���
//		 SchoolRoomShallow school = new SchoolRoomShallow();
//		 school.setStudent(new Student("С��",11));
//		 SchoolRoomShallow school2 =(SchoolRoomShallow) school.clone();
//		 school2.getStudent().setName("�Ķ�������");
//		 System.out.println(school);
//		 System.out.println(school2);
		 // ���
		 SchoolRoomDeep school3 = new SchoolRoomDeep();
		 school3.setStudent(new StudentDeep("С��",11));
		 SchoolRoomDeep school4 =(SchoolRoomDeep) school3.deepclone();
		 school4.getStudent().setName("�Ķ�������");
		 System.out.println(school3);
		 System.out.println(school4);
		 
	}
}

// ��� ���ƻ����������ͣ������ڴ�ռ䣩�����ƶ��󣨿����ڴ�ռ䣩
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
		 
		  /* д�뵱ǰ����Ķ������� */  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = new ObjectOutputStream(bos);  
        oos.writeObject(this);  
  
        /* �������������������¶��� */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return ois.readObject();  

        
	}
	
	 

}



// ǳ���ƣ����ƻ����������ͣ����ٿռ䣩�����ƶ���ֻ�ǰ����ø��ƹ�ȥ��
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